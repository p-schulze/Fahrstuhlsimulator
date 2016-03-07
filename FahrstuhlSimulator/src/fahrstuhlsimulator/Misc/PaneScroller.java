/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;
import fahrstuhlsimulator.testumgebung.TestPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class PaneScroller implements KeyListener {
    
    private TestPanel panel;
    private boolean keyRelease = true;
    private Runnable keyrunner_up;
    private Thread keyrunner_up_th;
    private Runnable keyrunner_down;
    private Thread keyrunner_down_th;
    
    private int scrollnum = 2;

    public PaneScroller(TestPanel pane)
    {
        
        panel = pane;
        keyrunner_up = new Runnable() {

            @Override
            public void run()
            {
                while(true)
                {
                    if(panel.getY() < 0)
                    {   
                        panel.setLocation(panel.getX(), panel.getY()+scrollnum);
                    }
                    try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PaneScroller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }
        };
        keyrunner_down = new Runnable() {

            @Override
            public void run()
            {
                while(true)
                {
                    if(panel.getY() >= -600)
                    {   
                        panel.setLocation(panel.getX(), panel.getY()-scrollnum);
                    }
                try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PaneScroller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(keyRelease)
        {
            if(e.isShiftDown())
            {
                scrollnum = 6;
            }
            else
            {
                scrollnum = 2;
            }
            if(e.getKeyCode() == 38)
            {
                keyRelease = false;
                keyrunner_up_th = new Thread(keyrunner_up);
                keyrunner_up_th.start();
            }
            else if(e.getKeyCode() == 40)
            {
                keyRelease = false;
                keyrunner_down_th = new Thread(keyrunner_down);
                keyrunner_down_th.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == 38)
        {
            keyrunner_up_th.stop();
            keyRelease = true;
        }else if(e.getKeyCode() == 40)
        {
            keyrunner_down_th.stop();
            keyRelease = true;
        }
    }
    
}
