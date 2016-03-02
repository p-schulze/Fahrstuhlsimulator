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
        schreibeAktion("addKoch Art(String) Name(String)");
        schreibeAktion("move id(int) pixel(int)");
        schreibeAktion("flip id(int)");
        schreibeAktion("fahre id(int) etage(int)");
        schreibeAktion("teleport id(int) etage(int)");
    }
       
    private void addPerson(String name, String art){
        switch (art) {
            case "Koch":
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Koch(name));
                break;
            case "Entwickler":
                break;
        }
        
        mitarbeiter.get(mitarbeiter.size()-1).move(50);
    }
    
    private void move(Mitarbeiter person, int pix){
         if(pix < 0){
            flip(person);
            person.move(pix*(-1));
            } else {
            person.move(pix);
            }   
    }
    
    private void flip(Mitarbeiter person){
      //  person.umdrehen();       
    }
    
    private void fahre(Mitarbeiter person, int etage){
      //  person.goto(etage);
    }
    
    private void teleport(Mitarbeiter person, int etage){
        //person.teleport(etage);
    }
    
    public fahrstuhlsimulator.Mitarbeiter.Mitarbeiter getMitarbeiter(int index){
        return mitarbeiter.get(index);  
    }
    
    public ArrayList<Mitarbeiter> getMitarbeiterListe(){
        return mitarbeiter;  
    }
    
    //Analyse 
    private void analyze(String command){
        String[] commandArray = command.split("\\s+");
        
        switch (commandArray[0]) {
            case "add":
                schreibeAktion(commandArray[1] +" "+ commandArray[2] + " wurde erstellt.");
                addPerson(commandArray[2], commandArray[1]);
                break;
            case "move":
                schreibeAktion("Person " +commandArray[1] + " läuft " + commandArray[2] + " Pixel.");
                move(getMitarbeiter(Integer.parseInt(commandArray[1])), Integer.parseInt(commandArray[2]));
                break;
            case "fahre":
                fahre(getMitarbeiter(Integer.parseInt(commandArray[1])), Integer.parseInt(commandArray[2]));
                schreibeAktion("Person " +commandArray[1] + " fährt in die " + commandArray[2] + " Etage.");
                break;    
            case "help":
                help();
                break;
            case "teleport":
                schreibeAktion("Person " +commandArray[1] + " wird in die " + commandArray[2] + " Etage teleportiert.");
                teleport(getMitarbeiter(Integer.parseInt(commandArray[1])), Integer.parseInt(commandArray[2]));
                break;
            case "xray":
                //XRay an / aus
                break;
            default:
                schreibeAktion("Error: Befehl nicht erkannt");
                break;
            
        }
       
      
       /* else if(commandArray[0].equalsIgnoreCase("xray"))
        {
            //TestPanel.X_RAY = !TestPanel.X_RAY;
           // schreibeAktion("X-Ray: " + TestPanel.X_RAY);
           // TestFenster.panel.repaint();
        }
        /*else if(commandArray[0].equalsIgnoreCase("open"))
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
        }*/
       
    }
}    
  
