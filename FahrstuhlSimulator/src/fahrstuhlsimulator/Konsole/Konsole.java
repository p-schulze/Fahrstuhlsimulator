/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Konsole;

import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


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
             //String[] array = command.split("[(),]");
            //for(int i =0; i<array.length ; i++){
                

        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
        mitarbeiterGraphics.get(0).schrittVor();
        mitarbeiterGraphics.get(0).moveToPosition(100);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 1));
        mitarbeiterGraphics.get(1).schrittVor();
        mitarbeiterGraphics.get(1).moveToPosition(150);
            
           
            
            
        }
    }
    
    private void schreibe(String command){
        masterArea.append("> "+ command + "\n");
    }
}
