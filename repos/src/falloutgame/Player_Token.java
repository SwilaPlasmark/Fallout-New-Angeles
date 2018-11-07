package falloutgame;

import java.awt.*;


public class Player_Token {
private static Image player_image = Toolkit.getDefaultToolkit().getImage("./Player1.png"); 
    
    Player_Token(){

        
    }
     
//    public static int PlayerPos() {
//        return value;
//    }
    
    public static void draw(Graphics2D g,int _row, int _column, int xdelta,int ydelta) {
        

        Drawing.drawImage(player_image, Window.getX(_column*xdelta)-xdelta/2, Window.getY(_row*ydelta)-ydelta/2, 0, .75, .75);
    }     

}
