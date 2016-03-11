/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung.RightClickMenu;

import fahrstuhlsimulator.FahrstuhlSimulator;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
import fahrstuhlsimulator.testumgebung.TestFenster;
import fahrstuhlsimulator.testumgebung.TestPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Sebastian
 */
public class RightClickMenu extends JPanel {
    
    private JLabel titel;
    private JButton move;
    
    private ActionListener actL;
    
    public RightClickMenu()
    {
        actL = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if((JButton)e.getSource() == move)
                {
                    for(Mitarbeiter mitarbeiter:TestFenster.panel.getmC().getAusgewaehlteMitarbeiter())
                    {
                        int distance = TestPanel.rightClickMenu.getLocation().x-mitarbeiter.getGraphic().getX_Pos();
                        if(!mitarbeiter.getGraphic().getFlipped())
                        {
                            distance = distance*-1;
                        }
                        System.out.println(distance+": "+TestPanel.rightClickMenu.getLocation().x+" | "+mitarbeiter.getGraphic().getX_Pos());
                        String cmd = "move "+FahrstuhlSimulator.konsole.getMitarbeiterID(mitarbeiter)+" "+distance;
                        FahrstuhlSimulator.konsole.schreibe(cmd);
                        FahrstuhlSimulator.konsole.analyze(cmd);
                    }
                }
            }
        };
        setBounds(100, 700, 100, 200);
        this.setLayout(null);
        setVisible(false);
        titel = new JLabel("Menu");
        titel.setBounds(4, 4, 92, 20);
        move = new JButton("Move");
        move.setFocusable(false);
        move.setBounds(4, 30, 92, 20);
        move.addActionListener(actL);
        this.add(titel);
        this.add(move);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
    }
}
