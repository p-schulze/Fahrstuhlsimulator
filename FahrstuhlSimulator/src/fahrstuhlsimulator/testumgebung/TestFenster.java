/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.Misc.MouseController;
import fahrstuhlsimulator.Misc.PaneScroller;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Sebastian
 */
public class TestFenster extends JFrame
{


    public static TestPanel panel;

    public TestFenster()
    {
        super("TestUmgebung");
        this.setBounds(0,0,800, 600);
        this.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        
        panel = new TestPanel();
        
        this.addKeyListener(new PaneScroller(panel));
        
        add(panel);
        this.setVisible(true);
                
    }
    
}
