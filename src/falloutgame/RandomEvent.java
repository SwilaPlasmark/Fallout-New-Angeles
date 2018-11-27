package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class RandomEvent {
    private final int Event_1 = 7;
    private final int Event_2 = 8;
    private final int Event_3 = 9;
    private final int Event_4 = 10;
    private final int Event_5 = 11;
    private final int Event_6 = 12;
    private final int Event_7 = 13;
    
    private int Event;
    
    RandomEvent() {
        Event = (int)(Math.random()*14);        
    }
    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,20));
        if (Event < 7) {
            g.drawString("Nothing occured", Window.getX(-360), Window.getY(120));
        }        
        else if (Event == Event_1) {
            g.drawString("You have encountered a Drifter", Window.getX(-360), Window.getY(120));
        }
        else if (Event == Event_2) {
            g.drawString("You have encountered a Raider", Window.getX(-360), Window.getY(120));
        }
        else if (Event == Event_3) {
            g.drawString("You have encountered a Civilian", Window.getX(-360), Window.getY(120));
        }
        else if (Event == Event_4) {
            g.drawString("You have found food", Window.getX(-360), Window.getY(120));
        }    
        else if (Event == Event_5) {
            g.drawString("You have found a gun", Window.getX(-360), Window.getY(120));
        } 
        else if (Event == Event_6) {
            g.drawString("You are Ill", Window.getX(-360), Window.getY(120));
        }    
        else if (Event == Event_7) {
            g.drawString("You have been diagnosed with the dead", Window.getX(-360), Window.getY(120));
        }    
    }            
}