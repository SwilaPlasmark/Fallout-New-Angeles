package falloutgame;

public class Window {
    protected static final int XBORDER = 20;
    protected final static int NUM_ROWS = 24;
    protected final static int NUM_COLUMNS = 28;      
//    private static final int YBORDER = 20;
    
    protected static final int TOP_BORDER = 40;
    protected static final int BOTTOM_BORDER = 20;
    
    protected static final int YTITLE = 30;
    protected static final int WINDOW_BORDER = 8;
    
    //static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER) + 850;
    //static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 850;
    
    static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER) + 950;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 950;
    
    
    static int xsize = -1;
    static int ysize = -1;


/////////////////////////////////////////////////////////////////////////
                
    public static int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }

    public static int getY(int y) {
//        return (y + YBORDER + YTITLE );
        return (y + TOP_BORDER + YTITLE );
        
    }

    public static int getYNormal(int y) {
//          return (-y + YBORDER + YTITLE + getHeight2());
      return (-y + TOP_BORDER + YTITLE + getHeight2());
        
    }
    
    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }

    public static int getHeight2() {
//        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
        return (ysize - (BOTTOM_BORDER + TOP_BORDER) - WINDOW_BORDER - YTITLE);
    }    
}


