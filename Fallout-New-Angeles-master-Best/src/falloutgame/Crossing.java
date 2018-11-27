/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Crossing extends ImportantArea{
    int direct;
    Crossing(String _name,int _row, int _col,int _direct) {
        super(_name,_row,_col);
        direct=_direct;
    }
    public void setDirection(int _direct){
        direct=_direct;
    }
    
    public int getDirection(){
        return direct;
    }
    
    public void draw(Graphics2D g, int xdelta, int ydelta) {
        g.setColor(Color.CYAN);
        g.fillRect(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);        
        g.setColor(Color.BLACK);
        g.drawRect(Window.getX(col*xdelta),Window.getY(row*ydelta),xdelta,ydelta);     
    }
    public static void drawMenu(Graphics2D g) {
        g.setColor(Player.getOtherPlayer().getColor());
        g.fillRect(Window.getX(-370), Window.getY(100), 350, 600);
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        if (Player.getOtherPlayer().getColor() == Color.BLUE) {
            g.drawString("Where would you like to go?", Window.getX(-360), Window.getY(160));   
            g.drawString("Player 1 entered a fork in the road", Window.getX(-360), Window.getY(120));    
        }
        else {
            g.drawString("Where would you like to go?", Window.getX(-360), Window.getY(160));   
            g.drawString("Player 2 entered a fork in the road", Window.getX(-360), Window.getY(120));
            
        }
        g.fillRect(Window.getX(-340), Window.getY(230), 100, 40);
        g.fillRect(Window.getX(-150), Window.getY(230), 100, 40);
        
        g.fillRect(Window.getX(-340), Window.getY(430), 100, 40);
        g.fillRect(Window.getX(-150), Window.getY(430), 100, 40);
        
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        
        g.drawString("North", Window.getX(-320), Window.getY(250));
        
        g.drawString("South", Window.getX(-120), Window.getY(250));
        
        g.drawString("East", Window.getX(-320), Window.getY(450));
        
        g.drawString("West", Window.getX(-120), Window.getY(450));
    
    }    
}
