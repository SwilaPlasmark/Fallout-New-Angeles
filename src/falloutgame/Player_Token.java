package falloutgame;

import java.awt.*;

public class Player_Token {
    private static Image player_image = Toolkit.getDefaultToolkit().getImage("./Player1.png");
    private Color color;
    private int row;
    private int col;
    
    Player_Token(Color _color, int _row, int _col){
        color = _color; 
        row = _row;
        col = _col;
    }
    public int PlayerRow() {
        return row;
    }
    public int PlayerCol() {
        return col;
    }    
    public Color getColor()
    {
        return (color);
    }    
    public void draw(Graphics2D g,int y, int x, int xdelta,int ydelta) {
        Drawing.drawImage(player_image, Window.getX(x*xdelta)-xdelta/2, Window.getY(y*ydelta)-ydelta/2, 0, .75, .75);
    }     

}
