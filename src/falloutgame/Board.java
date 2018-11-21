
package falloutgame;
import java.awt.*;

public class Board {  
    private final static int NUM_ROWS = 20;
    private final static int NUM_COLUMNS = 20;      
    public static Board_Position board[][] = new Board_Position[NUM_ROWS][NUM_COLUMNS];
    
    //private static City board[][] = new City[NUM_ROWS][NUM_COLUMNS];
   
    private static int numTokens;
    private final static int NUM_CONNECT = 4;
    private static int points;
   
    public static void Reset() {
 
        //numTokens = 0;
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
        }
        board[3][2] = new Player_Token(Color.BLUE,1);
        board[5][2] = new Player_Token(Color.MAGENTA,2);
    }
    public static void PlayerMove(int numMoved) {
        int newRow=0;
        int newCol=0;
        int currRow = 0; 
        int currCol = 0; 
        for (int zi = 0;zi<NUM_ROWS;zi++)
            {
                for (int zx = 0;zx<NUM_COLUMNS;zx++)
                {
                   if(board[zi][zx]!=null&&((Player_Token)board[zi][zx]).getColor()==Player.getCurrentPlayer().getColor()){
                        //if(rowdir==1)
                        //newRow=board[zi][zx].move(move,zi);
                        
                        newCol=((Player_Token)board[zi][zx]).move(numMoved,zx);
                        //currCol = ; 
                        //currRow = newRow;
                        currRow=zi;
                        currCol=zx;
                   }
                    
                }
            }
            //if(board[currRow][newCol].getColor()==Player.getOtherPlayer().getColor()){
            board[currRow][newCol]=board[currRow][currCol];
            
            
            board[currRow][currCol]=null;
            //}
    }
    public static void PlayerMove2() {
        board[10][13] = board[3][2];
        board[3][2] = null;
        
        board[10][14] = board[5][2];
        board[5][2] = null;
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
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
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
        
//Cities
        g.setColor(Color.white);
        City.draw(g, Window.getX(12*xdelta), Window.getY(9*ydelta), xdelta, ydelta);
        City.draw(g, Window.getX(18*xdelta), Window.getY(5*ydelta), xdelta, ydelta);
//EnemyBases
        EnemyBase.draw(g, Window.getX(18*xdelta), Window.getY(5*ydelta), xdelta, ydelta);
//End Space
        g.setColor(Color.GREEN);
        g.fillRect(Window.getX(8*xdelta),Window.getY(8*ydelta),xdelta,ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(8*xdelta),Window.getY(8*ydelta),xdelta,ydelta);
//Draw Movement buttons
        g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,25));
            g.drawString("Game Over", 60, 120);      
//When someone enters a city.
    if (board[10][13] != null)
        City.IfSteppedOn(g,10,13);
//Draw player
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null)
                {
                    ((Player_Token)board[zi][zx]).draw(g, zi, zx, xdelta, ydelta);
                }
            }
        } 
        return;
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

