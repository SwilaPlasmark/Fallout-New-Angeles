package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ImportantArea extends Board_Position{
    String name;
    public int row;
    public int col;
    public int SavedRow;
    public int SavedCol;
    
    public static void drawMenu(Graphics2D g) {
       
    }          
    ImportantArea(String _name,int _row, int _col) {          
        name = _name;
        row = _row-1;
        col = _col-1;
        SavedRow = _row-1;
        SavedCol = _col-1;    
    }
    public void draw(Graphics2D g, int xdelta, int ydelta) {
        g.setColor(Color.BLACK);
        g.fillOval(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);        
        g.setColor(Color.BLACK);
        g.drawOval(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);
    }
    public int getSavedRow() {
        return SavedRow;
    }
    public int getSavedCol() {
        return SavedCol;
    }
    public String getName() {
        return name;
    }
}
