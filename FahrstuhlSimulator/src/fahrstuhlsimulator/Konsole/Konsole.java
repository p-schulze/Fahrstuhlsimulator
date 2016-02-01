/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Konsole;

import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.testumgebung.TestFenster;
import fahrstuhlsimulator.testumgebung.TestPanel;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.text.DefaultCaret;


/**
 *
 * @author pascalschulze
 */

public class Konsole {
    private JFrame masterFrame = new JFrame();
    private JPanel masterPanel = new JPanel();
    private JTextArea masterArea = new JTextArea();
    private JTextField masterField = new JTextField();
    private ArrayList<MitarbeiterGraphic> mitarbeiterGraphics = new ArrayList();
    
    public void kStart (){
        
        masterFrame.setSize(500, 170);
        masterFrame.setResizable(false);
        masterPanel.setLayout(null);
        masterArea.setEditable(false);
        masterArea.setBounds(0, 0, 500, 120);
        masterField.setBounds(0, 120, 500, 30);
        masterPanel.add(masterArea);
        masterPanel.add(masterField);
        masterFrame.add(masterPanel);
        DefaultCaret caret = (DefaultCaret)masterArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        masterFrame.setVisible(true);
        masterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("Konsole gestartet...");
   
        
    masterField.addKeyListener(new KeyListener(){
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            
            String command = masterField.getText();
            masterField.setText("");
            schreibe(command);
            analyze(command);
            
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
});
       
}
    
    private void analyze(String command){
        if(command.contains("person")){
           schreibe(".." + "Person wird erzeugt");
             String[] array = command.split("[(),]");
              
        

<<<<<<< Updated upstream
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
//        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(100);
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 1));
//        mitarbeiterGraphics.get(1).moveDistanceWithAnimation(100);
        fahrstuhlsimulator.testumgebung.TestPanel.mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        TestFenster.panel.repaint();
=======

        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(100);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 1));
        mitarbeiterGraphics.get(1).moveDistanceWithAnimation(100);

        fahrstuhlsimulator.testumgebung.TestPanel.mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        

>>>>>>> Stashed changes
            
           
                   
        }
        else if(command.equalsIgnoreCase("X-RAY") || command.equalsIgnoreCase("X") )
        {
            TestPanel.X_RAY = !TestPanel.X_RAY;
            TestFenster.panel.repaint();
        }
    }
    
    private void schreibe(String command){
        masterArea.append("> "+ command + "\n");
    }
}
