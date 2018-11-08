
package falloutgame;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class FalloutGame extends JFrame implements Runnable {
    
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    boolean gameOver;
    int timeCount;
    double frameRate = 25;
    Image FalloutMenu;
    boolean start;

    Image Fallout2map;
 
    static FalloutGame frame;
    public static void main(String[] args) {
        frame = new FalloutGame();
        frame.setSize(Menu.WINDOW_WIDTH, Menu.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public FalloutGame() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button
                    Board.PlayerMove();
// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();
                    
                 if(Board.StartPressed(e.getX()-Window.getX(0),e.getY()-Window.getY(0))) {
                      start=true;
                  }
                    
                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                
                if (gameOver)
                    return;
                
                if (e.VK_UP == e.getKeyCode()) {
                    
                } else if (e.VK_DOWN == e.getKeyCode()) {
                    
                } else if (e.VK_LEFT == e.getKeyCode()) {
                    
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    
                } else if (e.VK_SPACE == e.getKeyCode()) {
                   Board.PlayerMove2();
                    
                }

                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }



////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            Drawing.setDrawingInfo(g,this);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.black);
        g.fillPolygon(x, y, 4);
// draw border
//        g.setColor(Color.black);
//        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        
          ///display Main Menu when start is fasle    
      if(start!=true) { 
        g.drawImage(FalloutMenu,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
        g.setColor(Color.white);
        g.fillRoundRect(Window.getX(Window.getWidth2()/2-50), Window.getY(Window.getHeight2()/2), 100, 50, 40, 40);
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.drawString("Start", Window.getX(Window.getWidth2()/2-25), Window.getY(Window.getHeight2()/2+30));
      }
      if(start){
       g.drawImage(Fallout2map,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
        Board.Draw(g);
        
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);        
      }
        if (gameOver)
        {
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,50));
            g.drawString("Game Over", 60, 360);        
        }            
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
//            double seconds = .04;    //time that 1 frame takes.
            double seconds = 1/frameRate;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        Player.Reset();
        timeCount = 0;
        gameOver = false;
        start =false;

    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
        
            Fallout2map = Toolkit.getDefaultToolkit().getImage("./F02.png");
            FalloutMenu = Toolkit.getDefaultToolkit().getImage("./Menu1.png");
//            rocketImage = Toolkit.getDefaultToolkit().getImage("./animRocket.GIF");
            reset();    
            //bgSound = new sound("starwars.wav");
            
        }
//        if (gameOver)
//            return;
        
        if(start){
            frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        }
        else{
            frame.setSize(Menu.WINDOW_WIDTH, Menu.WINDOW_HEIGHT);
        }

        //if (bgSound.donePlaying)       
            //bgSound = new sound("starwars.wav");
        
        
        
        
        timeCount++;
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}
////////////////////////////////////////////////////////////////////////////


class Drawing {
    private static Graphics2D g;
    private static FalloutGame mainClassInst;

    public static void setDrawingInfo(Graphics2D _g,FalloutGame _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawCircle(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillOval(-10,-10,20,20);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    
}



    

