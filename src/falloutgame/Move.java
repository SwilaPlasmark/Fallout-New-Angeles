package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Move {
   private int Speed;
   int move_1 = 1;
   int move_2 = 2;
   int move_3 = 3;
   int move_4 = 4;
   int move_5 = 5;
   int move_6 = 6;
   int move_7 = 7;
   Move() 
   {
       
   }
    public static void draw(Graphics2D g,int x, int y,int xdelta,int ydelta) {
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        g.drawString("Move",Window.getX(x*xdelta), Window.getY(y*ydelta));        
        for (int i=1;i<5;i++) {
            g.drawString("    "+i,Window.getX((i+1)*xdelta), Window.getY(y*ydelta));           
        }        
    }
//    public static void MovePlayer() {
//        
//    }    
}
