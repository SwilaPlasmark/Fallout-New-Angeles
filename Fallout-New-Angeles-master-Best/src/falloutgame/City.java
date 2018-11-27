
package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class City extends ImportantArea{

    City(String _name,int _row, int _col) {
        super(_name,_row,_col);
    }
    public void draw(Graphics2D g, int xdelta, int ydelta) {
        g.setColor(Color.WHITE);
        g.fillOval(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);        
        g.setColor(Color.BLACK);
        g.drawOval(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);     
    }
    public static void drawMenu(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(Window.getX(-370), Window.getY(100), 350, 600);
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        if (Player.getOtherPlayer().getColor() == Color.BLUE) {
            g.drawString("Player 1 has entered a city", Window.getX(-360), Window.getY(120));    
        }
        else {
            g.drawString("Player 2 has entered a city", Window.getX(-360), Window.getY(120));   
        }
        g.fillRect(Window.getX(-340), Window.getY(130), 100, 40);
        g.fillRect(Window.getX(-150), Window.getY(130), 100, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        g.drawString("Barter", Window.getX(-320), Window.getY(150));
        g.drawString("Rest", Window.getX(-120), Window.getY(150));
    }    
}
