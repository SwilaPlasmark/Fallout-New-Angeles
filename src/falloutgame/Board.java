
package falloutgame;

import java.awt.*;

public class Board {  
    public final static int NUM_ROWS = 20;
    public final static int NUM_COLUMNS = 20;      
    public static Board_Position board[][] = new Board_Position[NUM_ROWS][NUM_COLUMNS]; 
    
    public static boolean PopUpCityMenu = false;
    public static boolean PopUpEnemyBaseMenu = false;
    public static boolean PopUpCrossroadMenu = false;
    public static boolean RandomEventOccured = false;
    
    public static Board_Position NewPostion = null;        
   
    private static int points;

    public static RandomEvent Event;
            
    public static void Reset() {
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
        }
//Players        
        board[3][2] = new Player_Token(Color.BLUE,1);
        board[3][1] = new Player_Token(Color.MAGENTA,2);
//Cities
        board[10][13] = new City("Sunny Shades",10,13);
        board[3][8] = new City("New Vegas",3,8);
        //board[3][12] = new City("Viper City",3,12); 
//EnemyBases
        board[6][19] = new EnemyBase("Raider Camp",6,19);
        board[3][15] = new EnemyBase("Super Mutant Camp",3,15);        
//Crossings
        board[3][13] = new Crossing("",3,13,3);
        //board[3][8] = new Crossing("",3,8);
        //board[3][12] = new Crossing("",3,12); 
        //board[6][19] = new Crossing("",6,19);
        //board[3][15] = new Crossing("",3,15);
    }
    
    public static void PlayerMove(Graphics2D g,int numMoved) {
        RandomEventOccured = false;
        int newRow=0;
        int newCol=0;
        int currRow = 0; 
        int currCol = 0;
        int rowDir=0;
        int colDir=0;
        for (int zi = 0;zi<NUM_ROWS;zi++)
            {
                for (int zx = 0;zx<NUM_COLUMNS;zx++)
                {
                    if(board[zi][zx]!=null&& board[zi][zx] instanceof Player_Token && ((Player_Token)board[zi][zx]).getColor()==Player.getCurrentPlayer().getColor()){
                        //if(rowdir==1)
                        //newRow=board[zi][zx].move(move,zi);
                        
                        /*ALLREAD
                            rowDir 1 is the RIGHT(East)
                            rowDir -1 is the LEFT(West)
                            colDir 1 is UP(North)
                            colDir -1 is Down(South)
                        
                            dirrMove 0 = right
                            dirrMove 1 = left
                            dirrMove 2 = up
                            dirrmove 3 = down;
                        */
                        
                        currRow=zi;
                        currCol=zx;
                        
                        if(Player.getCurrentPlayer().getDirection() == 0){
                        newCol=((Player_Token)board[zi][zx]).move(numMoved,zx);
                        newRow=currRow;
                        }                        
                        else if(Player.getCurrentPlayer().getDirection() == 1){
                        newCol=((Player_Token)board[zi][zx]).move(-numMoved,zx);
                        newRow=currRow;
                        }
                        else if(Player.getCurrentPlayer().getDirection() == 2) {
                        newRow=((Player_Token)board[zi][zx]).move(numMoved,zi);
                        newCol=currCol;
                        }
                        else if(Player.getCurrentPlayer().getDirection() == 3) {
                        newRow=((Player_Token)board[zi][zx]).move(-numMoved,zi);
                        newCol=currCol;                        
                   }
                }
            }
        }
        if(board[newRow][newCol] instanceof Player_Token){
            Player.switchTurn();
            return;
        }
        else if(board[newRow][newCol] instanceof City) {              
            board[2][2] = board[newRow][newCol];
            NewPostion = board[2][2];             
            Board_Position.setTempStoredPos(newRow, newCol);
            board[newRow][newCol] = null;
            PopUpCityMenu = true;
        }
        else if (board[newRow][newCol] instanceof EnemyBase) {
            board[2][2] = board[newRow][newCol];
            NewPostion = board[2][2];             
            Board_Position.setTempStoredPos(newRow, newCol);
            board[newRow][newCol] = null;
            PopUpEnemyBaseMenu = true;
        }
        else if (board[newRow][newCol] instanceof Crossing) {
            board[2][2] = board[newRow][newCol];
            NewPostion = board[2][2];             
            Board_Position.setTempStoredPos(newRow, newCol);
            Player.getCurrentPlayer().changeDirection(2);
            PopUpEnemyBaseMenu = true;     
        }
        else {
            PopUpCityMenu = false;
            PopUpEnemyBaseMenu = false;
            PopUpCrossroadMenu = false;
            RandomEventOccured = true;
        }
//If the Player's position is the city's old position            
        if (board[currRow][currCol] == board[Board_Position.getRow()][Board_Position.getCol()]) {
            board[newRow][newCol] = board[currRow][currCol];
            board[currRow][currCol] = null;
            
            if (RandomEventOccured) {
                Event = new RandomEvent();
            }
            
            board[Board_Position.getRow()][Board_Position.getCol()] = NewPostion;
            NewPostion = null;
        }
        else {
            if (RandomEventOccured) {
                Event = new RandomEvent(); 
            }
            
            board[newRow][newCol] = board[currRow][currCol];               
            board[currRow][currCol] = null;
        }
    }

public static void Draw(Graphics2D g) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;          
 //Draw the grid.
        g.setColor(Color.GREEN);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }     
//Draw the Path
        for (int i = 1;i<19;i++) {
        g.setColor(Color.GREEN);            
        g.fillRect(Window.getX(i*xdelta),Window.getY(2*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(i*xdelta),Window.getY(2*ydelta),xdelta,ydelta);   
        }
        for (int i = 3;i<18;i++) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(18*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(18*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        }
        for (int i = 18;i>1;i--) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(i*xdelta),Window.getY(18*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(i*xdelta),Window.getY(18*ydelta),xdelta,ydelta);
        }        
        for (int i = 17;i>3;i--) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(2*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(2*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        }
        for (int i = 3;i<9;i++) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(i*xdelta),Window.getY(4*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(i*xdelta),Window.getY(4*ydelta),xdelta,ydelta);
        }
        for (int i = 4;i<9;i++) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(9*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(9*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        }
        for (int i = 17;i>8;i--) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(i*xdelta),Window.getY(14*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(i*xdelta),Window.getY(14*ydelta),xdelta,ydelta);
        }
        for (int i = 15;i<18;i++) {
        g.setColor(Color.GREEN);    
        g.fillRect(Window.getX(9*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(9*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        }
        for (int i = 3;i<14;i++) {
        g.setColor(Color.yellow);    
        g.fillRect(Window.getX(12*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(12*xdelta),Window.getY(i*ydelta),xdelta,ydelta);
        }
//End Space
        g.setColor(Color.GREEN);
        g.fillRect(Window.getX(8*xdelta),Window.getY(8*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(8*xdelta),Window.getY(8*ydelta),xdelta,ydelta);
//Draw Movement buttons
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,25));
        g.drawString("Game Over", 60, 120); 
//Draw crossroads
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null && board[zi][zx] instanceof Crossing)
                    ((Crossing)board[zi][zx]).draw(g,xdelta, ydelta);
            }
        }

//Draw EnemyBases
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null && board[zi][zx] instanceof EnemyBase)
                    ((EnemyBase)board[zi][zx]).draw(g,xdelta, ydelta);
            }
        }
//Draw Cities
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null && board[zi][zx] instanceof City)
                    ((City)board[zi][zx]).draw(g,xdelta, ydelta);
            }
        }
//Draw Player Tokens
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null && board[zi][zx] instanceof Player_Token) {
                    ((Player_Token)board[zi][zx]).draw(g, zi, zx, xdelta, ydelta); 
                }
            }
        }
//Display PopUp Menus         
        if (PopUpCityMenu) {
            City.drawMenu(g);
        }
        if (PopUpEnemyBaseMenu) {
            EnemyBase.drawMenu(g);
        }        
        if (PopUpEnemyBaseMenu) {
            Crossing.drawMenu(g);
        }
        if (RandomEventOccured) {
            Event.draw(g);
        }
        return;
    }
    public static void SelectOption(int xpixel, int ypixel){
           if (xpixel < 170 && xpixel > 70 && ypixel < 240 && ypixel > 200)
                System.out.println("you have selected barter");
           if (xpixel < 360 && xpixel > 260 && ypixel < 240 && ypixel > 200)
                System.out.println("you have selected rest");           
    }
    //check is you click within the boudaries
    public static boolean StartPressed(int xpixel, int ypixel){
        if(Menu.getX(Menu.WINDOW_WIDTH/2)-60<xpixel&&
           Menu.getX(Menu.WINDOW_WIDTH/2)+40>xpixel&&
           438<ypixel&&474>ypixel){
            return(true);
        }
        return false;
    }
}

