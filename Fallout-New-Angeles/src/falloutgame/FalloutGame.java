
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
    public static boolean stopsounds;
    public static boolean start;
    
    public static boolean radiostatus;
    public static boolean menumusicstatus;
    
    Image Fallout2map;
    sound menuSound = null;
    sound travelMusic = null;
    sound radioMusic = null;
    
    sound battleMusic = null;
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
                    
                    if(Board.StartPressed( e.getX(), e.getY())) {
                      start=true;
                    
                     
                      
                    int randtype=(int)(Math.random()*2);
                    
                    SetAmbiantAudio(randtype);
                  }
                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    //stopsounds=true;
                    
                    //reset();
                    
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
                else if(e.VK_M==e.getKeyCode()){
                    if(!stopsounds)
                       stopsounds=true;
                    
                    
                    else if(stopsounds){
                            stopsounds=false;
                       int randtype=(int)(Math.random()*2);
               
                       if(!start){
                        menumusicstatus=true;
                        SetMenuAudio();
                       }
                       if(start&&radiostatus)
                       SetRadioAudio(randtype);

                       else if(start&&!radiostatus) 
                       SetAmbiantAudio(randtype);
                    
                       
                       
                    }
                    
                    
                }
                else if(e.VK_ENTER==e.getKeyCode()){
                start=true;  
                }
                    
                    
                
                
                
                else if(e.VK_R==e.getKeyCode()){
                   Board.PlayerMove2();
                   if(!radiostatus){
                       radiostatus=true;
                       int randtype=(int)(Math.random()*2);
                       SetAmbiantAudio(randtype);
                   }
                   else if(radiostatus)
                   radiostatus=false;
                   
                   int randtype=(int)(Math.random()*2);
                   SetRadioAudio(randtype);
                   
                }
                else if(e.VK_E==e.getKeyCode()){
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

    public void SetMenuAudio(){
        //int type=_type;
        //System.out.println();
        //if(type==0)    
        menuSound = new sound("Main Title - Fallout New Vegas .wav", 0);
        
//        if(type==1)    
//        radioMusic = new sound("Traveling2.wav",1);
        
    }
////////////////////////////////////////////////////////////////////////////
        public void SetRadioAudio(int _type){
        int type=_type;
        System.out.println(type);
        
        if(type==0)    
        radioMusic = new sound("Radio1.wav",2);   
        
        if(type==1)    
        radioMusic = new sound("Radio2.wav",2);
        
    }
////////////////////////////////////////////////////////////////////////////

    public void SetAmbiantAudio(int _type){
        int type=_type;
        System.out.println(type);
        if(type==0)    
        travelMusic = new sound("Traveling1.wav",1);   
        
        if(type==1)    
        travelMusic = new sound("Traveling2.wav",1);
        
        
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
        if(start!=true) { 
            g.drawImage(FalloutMenu,Menu.getX(0),Menu.getY(0),
                    Menu.WIDTH,Menu.HEIGHT,this);
            g.setColor(Color.ORANGE);
           
            g.fillRect(Menu.getX(Menu.WINDOW_WIDTH/2-60), Menu.getY(Menu.HEIGHT-60), 100, 30);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman",Font.PLAIN,20));
            g.drawString("Start", Menu.getX(Menu.WIDTH/2-10), Menu.getY(Menu.HEIGHT-40));
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
  
      
        //stopsounds=false;
        menumusicstatus=true;
        menuSound = new sound("Main Title - Fallout New Vegas .wav", 0);
        //travelMusic = new sound("Traveling2.wav",1); 
        //menuSound = new sound(,0);
        
        
        
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
                        //rocketImage = Toolkit.getDefaultToolkit().getImage("./animRocket.GIF");
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

      


           
        
        if (menuSound.donePlaying)       
            menuSound = new sound("Main Title - Fallout New Vegas .wav", 0);
        
        
        
        
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



    

