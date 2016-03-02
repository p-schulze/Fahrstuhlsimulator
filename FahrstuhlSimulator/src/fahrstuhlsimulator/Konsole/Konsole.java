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
import java.awt.Dimension;
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
    
    /**
     * Die Konsole wird grafisch generiert und gestartet. Der KeyListener wird erstellt und zum Frame hinzugefügt.
     */
    public void kStart (){
        
        masterArea.setEditable(false);
        masterFrame.setMinimumSize(new Dimension(380, 175));
        
        masterFrame.add(masterField, BorderLayout.SOUTH);
      
        masterFrame.add(masterPane, BorderLayout.CENTER);
        
        masterFrame.pack();
        
        masterFrame.setSize(380, 175);
        masterFrame.setResizable(true);
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
    
    /**
     * Die Funktion schreibt einen String in das JTextArea.
     * @param command der Befehl
     */
    private void schreibe(String command){
       
        masterArea.append(">"+ command + "\n");
    }
    
    /**
     * Die Funktion schreibt einen formatierten String in das JTextArea.
     * @param command die Ausfürung
     */
    private void schreibeAktion(String command){
       
        masterArea.append(".. "+ command + "\n");
    }
    
    /**
     * Die Funktion zeigt alle Eingabemvarianten für den User ein. (Mit der richtigen Reihenfolge und Datentyp)
     */
    private void help(){
        schreibeAktion("add Art(String) Name(String)");
        schreibeAktion("move id(int) pixel(int)");
        schreibeAktion("flip id(int)");
        schreibeAktion("fahre id(int) etage(int)");
        schreibeAktion("teleport id(int) etage(int)");
    }
  
    /**
     * Eine neue Person wird erstellt.
     * @param name Name des neuen Mitarbeiters
     * @param art Rolle des neuen Mitarbeites
     */
    private void addPerson(String name, String art){
        switch (art) {
            case "Koch":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Koch(name));
                break;
            case "Hausmeister":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Hausmeister(name));
                break;
            case "Putzkolonne":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Putzkolonne(name));
                break;
            default:
                schreibeAktion("Der angegebene Typ existiert nicht. Bitte wählen sie:");
                schreibeAktion("  Koch");
                schreibeAktion("  Hausmeister");
                schreibeAktion("  Putzkolonne");
                break;
        }
        
        mitarbeiter.get(mitarbeiter.size()-1).move(50);
    }
    
    /**
     * Die Bewegungsmethode des Mitarbeiters wird aufgerufen. Ist die Pixelanzahl kleiner also 0, so dreht sich die Person vorher um.
     * @param person ein Mitarbeiter
     * @param pix Anzahl der Pixel
     */
    private void move(Mitarbeiter person, int pix){
         if(pix < 0){
            flip(person);
            person.move(pix*(-1));
            } else {
            person.move(pix);
            }   
    }
    
    /**
     * Die Umdrehen-Methode des Mitarbeiters wird aufgerufen. Sie hat dann die umgekehrte Blickrichtung.
     * @param person ein Mitarbeiter
     */
    private void flip(Mitarbeiter person){
      //  person.umdrehen();       
    }
    
    /**
     * Die Fahrfunktion des Mitarbeiters wird aufgerufen und die Zieletage übergeben.
     * @param person ein Mitarbeiter
     * @param etage eine Etage
     */
    private void fahre(Mitarbeiter person, int etage){
      //  person.goto(etage);
    }
    
    /**
     * Die Teleportmethode des Mitarbeiters wird aufgerufen.
     * @param person ein Mitarbeiter
     * @param etage Zieletage
     */
    private void teleport(Mitarbeiter person, int etage){
        //person.teleport(etage);
    }
    
    /**
     * Der Mitarbeiter mit dem Index "id" in der Liste Mitarbeiter wird zurückgegeben.
     * @param id Erkennung eines Mitarbeiters
     * @return Mitarbeiter der den Index "id" besitzt
     */
    public fahrstuhlsimulator.Mitarbeiter.Mitarbeiter getMitarbeiter(int id){
        return mitarbeiter.get(id);  
    }
    
    /**
     * Die Liste aller Mitarbeiter wird zurückgegeben.
     * @return alle Mitarbeiter
     */
    public ArrayList<Mitarbeiter> getMitarbeiterListe(){
        return mitarbeiter;  
    }
    
    /**
     * Der Befehl des Users (String) wird in ein String[] zerlegt. Dann wird das Feld analysiert und die richtigen Methoden werden aufgerufen.
     * @param command Eingabebefehl des Users
     */ 
    private void analyze(String command){
        String[] commandArray = command.split("\\s+");
        
        switch (commandArray[0]) {
            case "add":
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
  
