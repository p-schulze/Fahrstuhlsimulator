/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Konsole;

import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
import fahrstuhlsimulator.testumgebung.TestFenster;
import fahrstuhlsimulator.testumgebung.TestPanel;
import java.awt.BorderLayout;
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
    final JFrame masterFrame = new JFrame();
    final JTextArea masterArea = new JTextArea();
    final JTextField masterField = new JTextField();
    final JScrollPane masterPane = new JScrollPane(masterArea);
    
    final ArrayList<Mitarbeiter> mitarbeiter= new ArrayList();
    
    public void kStart (){
        
        masterArea.setEditable(false);
        
        masterFrame.add(masterField, BorderLayout.SOUTH);
      
        masterFrame.add(masterPane, BorderLayout.CENTER);
        
        masterFrame.pack();
        
        masterFrame.setSize(380, 175);
        masterFrame.setResizable(false);
        masterFrame.setLocationByPlatform(true);

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
    
    private void schreibe(String command){
       
        masterArea.append(">"+ command + "\n");
    }
    
    private void schreibeAktion(String command){
       
        masterArea.append(".. "+ command + "\n");
    }
    
    private void help(){
        schreibeAktion("addKoch Position Name");
        schreibeAktion("move id Pixel");
        schreibeAktion("flip id");        
    }
       
    private void addPerson(String name, String art){
        if(art == "Koch"){
            mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Koch(name));}
        else if(art == "Entwickler"){
             }

//andere Arten von Mitarbeitern
        
        mitarbeiter.get(mitarbeiter.size()-1).move(50);
    }
    
    private void move(Mitarbeiter person, int pix){
        person.move(pix);
    }
    
    private void fahre(Mitarbeiter person, int etage){
      //  person.goto(etage);
    }
    
    //Analyse 
    private void analyze(String command){
        String[] commandArray = command.split("\\s+");
       
        //AddKoch
        if(commandArray[0].equalsIgnoreCase("add")){
            // bibliothekar, entwickler, hausmeister, koch, laborant, putze
            addPerson(commandArray[2], commandArray[1]);}
        
        else if(commandArray[0].equalsIgnoreCase("move")){
            for (Mitarbeiter mitarbeiter1 : mitarbeiter) {
                if (mitarbeiter1.getName() == commandArray[1]) {
                    move(mitarbeiter1, Integer.parseInt(commandArray[1]));
                }
            }
        }
       
        else if(commandArray[0].equalsIgnoreCase("goto")){
            for (Mitarbeiter mitarbeiter1 : mitarbeiter) {
                if (mitarbeiter1.getName() == commandArray[1]) {
                    fahre(mitarbeiter1, Integer.parseInt(commandArray[1]));
                }
            }
        }  
       
        else if(commandArray[0].equalsIgnoreCase("help")){
            help();
        }
        
        else if(commandArray[0].equalsIgnoreCase("xray"))
        {
            //2. Command
            TestPanel.X_RAY = !TestPanel.X_RAY;
            schreibeAktion("X-Ray: " + TestPanel.X_RAY);
            TestFenster.panel.repaint();
        }
        else if(commandArray[0].equalsIgnoreCase("open"))
        {
            if(!TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open){
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).oeffneTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open = true;
            schreibeAktion("open door: " + commandArray[1]);
            }else{
                schreibeAktion("door: open");
            }
        }  
        else if(commandArray[0].equalsIgnoreCase("close"))
        {
            if(TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open){ 
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).schliesseTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open = false;
            schreibeAktion("close door: " + commandArray[1]);}
            else{
                schreibeAktion("door: close");
            }
        }
        else if(commandArray[0].equalsIgnoreCase("move"))
        {
            if(Integer.parseInt(commandArray[1]) < 0){
            TestPanel.mitarbeiterGraphics.get(0).umdrehen();
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(Integer.parseInt(commandArray[1]) * (-1));
            }else {
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(Integer.parseInt(commandArray[1]));
            }   
            schreibeAktion("move: " + commandArray[1]);
        } else if(commandArray[0].equalsIgnoreCase("etage"))
        {
            TestPanel.mitarbeiterGraphics.get(0).setEtage(Integer.parseInt(commandArray[1]));
            TestFenster.panel.repaint();
            //TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(0);
            schreibeAktion("etage: " + commandArray[1]);
        } else if(commandArray[0].equalsIgnoreCase("goto"))
        {
            if(TestPanel.mitarbeiterGraphics.get(0).getX_Pos() <= 368){
                if(TestPanel.mitarbeiterGraphics.get(0).getFlipped() == false){
                TestPanel.mitarbeiterGraphics.get(0).umdrehen();
                }
                TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).getX_Pos() - TestPanel.mitarbeiterGraphics.get(0).getX_Pos());
            } else {
                 if(TestPanel.mitarbeiterGraphics.get(0).getFlipped() == true){
                TestPanel.mitarbeiterGraphics.get(0).umdrehen();
                }
                TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(TestPanel.mitarbeiterGraphics.get(0).getX_Pos() - TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).getX_Pos() );
            }
          /*  TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).oeffneTuer();
            TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).schliesseTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).oeffneTuer();
            TestPanel.mitarbeiterGraphics.get(0).setPosition(368, Integer.parseInt(commandArray[1]));
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(0);
            TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).schliesseTuer(); */
            schreibeAktion("goto: " + commandArray[1]);
        } 
        else 
        {
            
            
            //Error
            schreibeAktion("Error: Befehl nicht erkannt");
        } 
}
    
  
