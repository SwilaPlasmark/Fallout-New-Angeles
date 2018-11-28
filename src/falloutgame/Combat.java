package falloutgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Combat {
    private static boolean combatstatus;
    
    public static void Fight(int damagetoEnemy,int damagetoPlayer){
        if(combatstatus){
            
            
        }
    }
    
    
    Combat(Enemy _enemy,Weapons _weapon) {
        combatstatus=true;
    
    }
    
    
    private void EndCombat(Enemy _enemy,Weapons _weapon){
        combatstatus=false;
    }  
    
    
    public static void drawMenu(Graphics2D g) {
            if(combatstatus){
                g.setColor(Color.white);
                g.fillRect(Window.getX(980), Window.getY(100), 350, 600);
            }
        }    
    
}
