package falloutgame;

import java.awt.*;


public class Player_Token {
private static Image player_image = Toolkit.getDefaultToolkit().getImage("./Player1.png");

    private Color color;
    
    Player_Token(Color _color){
        color = _color; 
    }
//    public static int PlayerPos() {
//        return value;
//    }
    public Color getColor()
    {
        return (color);
    }    
    public void draw(Graphics2D g,int _row, int _column, int xdelta,int ydelta) {
        g.setColor(color);
        g.fillOval(Window.getX((_column-1)*xdelta),Window.getY((_row-1)*ydelta),xdelta,ydelta);
        Drawing.drawImage(player_image, Window.getX(_column*xdelta)-xdelta/2, Window.getY(_row*ydelta)-ydelta/2, 0, .75, .75);
    }     

}
