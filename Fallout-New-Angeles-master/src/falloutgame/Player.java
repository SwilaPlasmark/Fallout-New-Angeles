package falloutgame;

import java.awt.Color;

public class Player {
    private static Player currPlayer;
    private static Player players[] = new Player[2];
    private int points;
    private Color color;  
        
    public static void Reset() {
        if (players[0] == null) {
           players[0] = new Player(Color.red);
           players[1] = new Player(Color.black);
        }
       currPlayer = players[0];
    }
    Player(Color _color) {
       points = 0;
       color = _color;
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
//    public void addPoints(int value) {
//        points += value;
//    }
//    public int getPoints() {
//        return points;
//    }    
}
