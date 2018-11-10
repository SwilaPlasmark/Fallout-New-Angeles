package falloutgame;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

class sound implements Runnable {
    Thread myThread;
    File soundFile;
    public boolean donePlaying = false;
    int type;
    sound(String _name, int _type)
    {
        soundFile = new File(_name);
        myThread = new Thread(this);
        myThread.start();
        type = _type;
    }
    public void run()
    {
        try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
        AudioFormat format = ais.getFormat();
    //    System.out.println("Format: " + format);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        SourceDataLine source = (SourceDataLine) AudioSystem.getLine(info);
        source.open(format);
        source.start();
       
            int read = 0;
            byte[] audioData = new byte[16384];
            while (read > -1){
                read = ais.read(audioData,0,audioData.length);
                if (read >= 0 && !FalloutGame.start && type ==0) {
                    source.write(audioData,0,read);
                }
//                if(read >= 0 && FalloutGame.start && type ==1){
//                    source.write(audioData,0,read);
//                }
                if (read >= 0 && type ==1) {
                    source.write(audioData,0,read);
                }
                
            }
        
        donePlaying = true;

        source.drain();
        source.close();
        }
        catch (Exception exc) {
            System.out.println("error: " + exc.getMessage());
            exc.printStackTrace();
        }
    }
}