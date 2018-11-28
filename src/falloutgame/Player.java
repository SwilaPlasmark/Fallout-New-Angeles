package falloutgame;

import java.awt.Color;

public class Player {
    private static Player currPlayer;
    private static Player players[] = new Player[2];
    public Weapons weapons[] = new Weapons[Weapons.NUM_WEAPONS];    
    private int points;
    private Color color;
    private int direction;
    private int SpacesMoved;
    
    
    public static void Reset() {
        if (players[0] == null) {
           players[0] = new Player(Color.BLUE);
           players[1] = new Player(Color.MAGENTA);
        }
       currPlayer = players[0];
       
       players[0].weapons[0] = new Weapons();
       players[1].weapons[0] = new Weapons();
    
    }
    Player(Color _color) {
       points = 0;
       color = _color;
       direction = 0;
       SpacesMoved = 0;
    }
    
    public static Player getCurrentPlayer() {
        return currPlayer;
    }   
    public static void switchTurn() {
        if (players[0] == currPlayer)
            currPlayer = players[1];
        else
            currPlayer = players[0];
    }   
            
    public Color getColor() {
        return color;
    }
    public int getDirection() {
        return direction;
    }
    public int getSpacesMoved() {
        return SpacesMoved;
    }        
    public void changeDirection(int newDirection) {
        direction = newDirection;
    }
    public void addSpacesMoved(int space) {
        SpacesMoved += space;
    }    
    public static Player getOtherPlayer() {
        if (players[0] == currPlayer)
            return players[1];
        else
            return players[0];
    }       
    public static Player getPlayer1() {
        return players[0];
    }
    public static Player getPlayer2() {
        return players[1];
    }
    
    public void addWeapons(String Name, int Damg)
    {
        for(int i=0;i<Weapons.NUM_WEAPONS;i++)
            if(weapons[i]==null)
               weapons[i]=new Weapons(Name,Damg);
        
    }
   
    
//    public void addPoints(int value) {
//        points += value;
//    }
//    public int getPoints() {
//        return points;
//    }    
}
