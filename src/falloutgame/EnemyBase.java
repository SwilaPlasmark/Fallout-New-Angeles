
package falloutgame;

import java.awt.Graphics2D;

public class EnemyBase {
    
    EnemyBase()
    {
        
    }
    public static void draw(Graphics2D g,int x, int y, int xdelta,int ydelta) {    
        g.fillOval(x,y,xdelta,ydelta);        
    }    
}
