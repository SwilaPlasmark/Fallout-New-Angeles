
package falloutgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class EnemyBase extends ImportantArea{
    
    EnemyBase()
    {
        
    }
    public static void draw(Graphics2D g,int x, int y, int xdelta,int ydelta) {    
        g.setColor(Color.RED);
        g.fillOval(x,y,xdelta,ydelta);        
    }    
}
