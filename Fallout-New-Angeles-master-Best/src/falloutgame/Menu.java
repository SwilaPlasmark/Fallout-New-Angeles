package falloutgame;

public class Menu {
    private static final int XBORDER = 20;
    private static final int YTITLE = 30;
    private static final int WINDOW_BORDER = 8;
    
    private static final int TOP_BORDER = 40;
    private static final int BOTTOM_BORDER = 50;
    
    static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER ) + 925;
    static final int WIDTH = 2*(WINDOW_BORDER + XBORDER ) + 925-40;
    
    static final int WINDOW_HEIGHT =  YTITLE +WINDOW_BORDER + 550;
    static final int HEIGHT =    550-BOTTOM_BORDER;

    static int xsize = -1;
    static int ysize = -1;

    public static int getX(int x) {
        return (x  +XBORDER);
    }
    public static int getY(int y) {
//        return (y + YBORDER + YTITLE );
        return (y + TOP_BORDER +  YTITLE); 
    }
    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }
    public static int getHeight2() {
//        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
        return (ysize - (BOTTOM_BORDER + TOP_BORDER) - WINDOW_BORDER - YTITLE);
    }      
}
