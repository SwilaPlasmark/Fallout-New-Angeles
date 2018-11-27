package falloutgame;

public class Board_Position {
    public static int row;
    public static int col;
    Board_Position() {
       
    }
    public static void setTempStoredPos(int _row,int _col) {
        row = _row;
        col = _col;
    }
    public static int getRow() {
        return row;
    }
    public static int getCol() {
        return col;
    }
}
