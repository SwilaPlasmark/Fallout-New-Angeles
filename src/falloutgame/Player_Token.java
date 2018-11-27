package falloutgame;

import static falloutgame.Board.PopUpCityMenu;
import java.awt.*;


public class Player_Token extends Board_Position{
    private static Image player_image1 = Toolkit.getDefaultToolkit().getImage("./Player1.png");
    private static Image player_image2 = Toolkit.getDefaultToolkit().getImage("./Player2.png");
    
    private Color color;
    private int playernum;
    Player_Token(Color _color,int _playernum){
        playernum=_playernum;
        color = _color; 
    }
    public int move(int Spacemove,int currSpace){
        return(currSpace+Spacemove);
    }
    
    public Color getColor()
    {
        return (color);
    }    
    public void draw(Graphics2D g,int _row, int _column, int xdelta,int ydelta) {
        g.setColor(color);
        if(playernum==1) {
        if ((Board.PopUpCityMenu || Board.PopUpEnemyBaseMenu) && Player.getOtherPlayer().getColor() == Color.blue)
            g.drawOval(Window.getX((_column-1)*xdelta),Window.getY((_row-1)*ydelta),xdelta,ydelta);
        else         
            g.fillOval(Window.getX((_column-1)*xdelta),Window.getY((_row-1)*ydelta),xdelta,ydelta);      
        Drawing.drawImage(player_image1, Window.getX(_column*xdelta)-xdelta/2, (Window.getY(_row*ydelta)-ydelta/2), 0, .75, .75);
        }
        else if(playernum==2) {
        if ((Board.PopUpCityMenu || Board.PopUpEnemyBaseMenu) && Player.getOtherPlayer().getColor() == Color.MAGENTA)
            g.drawOval(Window.getX((_column-1)*xdelta),Window.getY((_row-1)*ydelta),xdelta,ydelta);
        else         
            g.fillOval(Window.getX((_column-1)*xdelta),Window.getY((_row-1)*ydelta),xdelta,ydelta);            
        Drawing.drawImage(player_image2, Window.getX(_column*xdelta)-xdelta/2, Window.getY(_row*ydelta)-ydelta/2, 0, .75, .75); 
        }
    }     
}
