
package falloutgame;

import java.awt.Color;
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
}
