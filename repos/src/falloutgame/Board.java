/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falloutgame;
import java.awt.*;

public class Board {  
    private final static int NUM_ROWS = 20;
    private final static int NUM_COLUMNS = 20;      
    private static Player_Token board[][] = new Player_Token[NUM_ROWS][NUM_COLUMNS];
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
    }
public static void PlayerMove() {
    board[1][1] = new Player_Token();
    
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
        
        Player_Token.draw(g, 6, 2, xdelta, ydelta);
        
        return;
        
    }    
}
//Draw the tokens.        
//        for (int zi = 0;zi<NUM_ROWS;zi++)
//        {
//            for (int zx = 0;zx<NUM_COLUMNS;zx++)
//            {
//                if (board[zi][zx] != null)
//                {
//                    board[zi][zx].draw(g,zi,zx,xdelta,ydelta);
//                }
//            }
//        } 
//    }
//    public static void AddTokenPixel(int xpixel,int ypixel) {
//
//        if (xpixel < 0 || xpixel > Window.getWidth2() || ypixel < 0 || 
//           ypixel > Window.getHeight2())
//            return;
//        
///*
//        int currRow = 0;
//        int ydelta = Window.getHeight2()/NUM_ROWS;
//        int currYVal = ydelta;
//        while (ypixel > currYVal)
//        {
//            currRow++;
//            currYVal += ydelta;
//        }
//*/
//
//        int currCol = 0;
//        int xdelta = Window.getWidth2()/NUM_COLUMNS;
//        int currXVal = xdelta;
//        while (xpixel > currXVal)
//        {
//            currCol++;
//            currXVal += xdelta;
//        }
//
//        int currRow = NUM_ROWS-1;
//        while(currRow > 0 && board[currRow][currCol] != null)
//        {
//            currRow--;
//        }
//
//        if (board[0][currCol] == null) {
//            board[currRow][currCol] = new Token(Player.getCurrentPlayer().getColor());
//            Player.switchTurn();
//            numTokens++;
//            return;
//        }
//
//
//        return;
//    }
//
//
//    

