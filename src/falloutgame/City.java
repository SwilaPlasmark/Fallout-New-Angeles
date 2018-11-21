
package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class City extends ImportantArea{

    City()
    {
        
    }
    public static void draw(Graphics2D g,int x, int y, int xdelta,int ydelta) {    
        g.setColor(Color.WHITE);
        g.fillOval(x,y,xdelta,ydelta);        
        g.setColor(Color.BLACK);
        g.drawOval(x,y,xdelta,ydelta);    
        g.setColor(Color.BLACK);
        g.drawOval(x,y,xdelta,ydelta);
    }
    public static void IfSteppedOn(Graphics2D g, int row, int col) {
        g.setColor(Color.black);
        g.fillRect(Window.getX(100), Window.getY(100), 400, 600);
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));        
        if (((Player_Token)Board.board[row][col]).getColor() == Color.BLUE) 
            g.drawString("Player 1 has entered a city", Window.getX(120), Window.getY(120));                  
        else
            g.drawString("Player 2 has entered a city", Window.getX(120), Window.getY(120));    
    }
}
