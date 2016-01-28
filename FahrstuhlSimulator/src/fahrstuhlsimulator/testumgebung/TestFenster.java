/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import javax.swing.JFrame;

/**
 *
 * @author Sebastian
 */
public class TestFenster extends JFrame
{
<<<<<<< Updated upstream
    public static TestPanel panel;
=======
    public TestPanel panel;
>>>>>>> Stashed changes
    public TestFenster()
    {
        super("TestUmgebung");
        this.setBounds(0,0,800, 600);
        this.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new TestPanel();
        add(panel);
        this.setVisible(true);
                
    }
    
}
