/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Konsole;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Fahrstuhl;
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
import java.util.Random;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;


/**
 *
 * @author pascalschulze
 */

public class Konsole {
    protected final JFrame masterFrame = new JFrame();
    protected final JTextArea masterArea = new JTextArea();
    protected final JTextField masterField = new JTextField();
    protected final JScrollPane masterPane = new JScrollPane(masterArea);
    
    protected ArrayList<Mitarbeiter> mitarbeiter= new ArrayList();
    protected ArrayList<Fahrstuhl> farhstuehle = new ArrayList();
    
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
    public void schreibe(String command){
       
        masterArea.append(">"+ command + "\n");
    }
    
    /**
     * Die Funktion schreibt einen formatierten String in das JTextArea.
     * @param command die Ausfürung
     */
    protected void schreibeAktion(String command){
       
        masterArea.append(".. "+ command + "\n");
    }
    
    /**
     * Die Funktion zeigt alle Eingabemvarianten für den User ein. (Mit der richtigen Reihenfolge und Datentyp)
     */
    protected void help(){
        schreibeAktion("add Art(String) Name(String)");
        schreibeAktion("move id(int) pixel(int)");
        schreibeAktion("flip id(int)");
        schreibeAktion("fahre id(int) etage(int)");
        schreibeAktion("teleport id(int) etage(int)");
        schreibeAktion("create - fügt einen Fahrstuhl hinzu.");
    }
  
    /**
     * Eine neue Person wird erstellt.
     * @param name Name des neuen Mitarbeiters
     * @param art Rolle des neuen Mitarbeites
     */
    protected void addPerson(String name, String art){
        Random rand = new Random();
        int random = rand.nextInt(120); 
        
        switch (art) {
            case "Koch":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Koch(name));
                flip(mitarbeiter.get(mitarbeiter.size()-1));
                mitarbeiter.get(mitarbeiter.size()-1).move(random);
                break;
            case "Hausmeister":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Hausmeister(name));
                flip(mitarbeiter.get(mitarbeiter.size()-1));
                mitarbeiter.get(mitarbeiter.size()-1).move(random);
                break;
            case "Putzkolonne":
                schreibeAktion(art + " wurde erstellt.");
                mitarbeiter.add(new fahrstuhlsimulator.Mitarbeiter.Putzkolonne(name));
                flip(mitarbeiter.get(mitarbeiter.size()-1));
                mitarbeiter.get(mitarbeiter.size()-1).move(random);
                break;
            default:
                schreibeAktion("Der angegebene Typ existiert nicht. Bitte wählen sie:");
                schreibeAktion("  Koch");
                schreibeAktion("  Hausmeister");
                schreibeAktion("  Putzkolonne");
                break;
            }
        System.out.println(random);
        
    }
    
    /**
     * Die Bewegungsmethode des Mitarbeiters wird aufgerufen. Ist die Pixelanzahl kleiner also 0, so dreht sich die Person vorher um.
     * @param person ein Mitarbeiter
     * @param pix Anzahl der Pixel
     */
    protected void move(Mitarbeiter person, int pix){
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
    protected void flip(Mitarbeiter person){
        person.umdrehen();       
    }
    
    /**
     * Die Fahrfunktion des Mitarbeiters wird aufgerufen und die Zieletage übergeben.
     * @param person ein Mitarbeiter
     * @param etage eine Etage
     */
    protected void fahre(Mitarbeiter person, int etage){
        person.goTo(etage);
    }
    
    /**
     * Die Teleportmethode des Mitarbeiters wird aufgerufen.
     * @param person ein Mitarbeiter
     * @param etage Zieletage
     */
    protected void teleport(Mitarbeiter person, int etage){
        person.teleport(etage);
    }
    
    /**
     * Der Mitarbeiter mit dem Index "id" in der Liste Mitarbeiter wird zurückgegeben.
     * @param id Erkennung eines Mitarbeiters
     * @return Mitarbeiter der den Index "id" besitzt
     */
    public fahrstuhlsimulator.Mitarbeiter.Mitarbeiter getMitarbeiter(int id){
        return mitarbeiter.get(id);  
    }
    
    public int getMitarbeiterID(Mitarbeiter mitarbeiterObject){
        return mitarbeiter.indexOf(mitarbeiterObject);
    }
    
    /**
     * Die Liste aller Mitarbeiter wird zurückgegeben.
     * @return alle Mitarbeiter
     */
    public ArrayList<Mitarbeiter> getMitarbeiterListe(){
        return mitarbeiter;  
    }
    
    public ArrayList<Fahrstuhl> getFahrstuhlListe(){
        return farhstuehle;  
    }
    
    public void einsteigen(Mitarbeiter p, int fahrstuhl){
        farhstuehle.get(fahrstuhl).einsteigen(p);
    }
    
    /**
     * Fügt einen Fahrstuhl hinzu. (maximal 3 Fahrstühle möglich, feste X-Koordinaten)
     */
    protected void addFahrstuhl(){
       int xk = 368;
       if(farhstuehle.size() < 3){
        
            if(farhstuehle.size() ==1){
                xk=468;
            }
            if(farhstuehle.size() ==2){
                xk=268;
            }
            farhstuehle.add(new Fahrstuhl(xk));
        
       }
        
    } 
    
    protected void startRandom(int anzahl){
        int pause = 60/anzahl;
        int indexStart = mitarbeiter.size()-1;
        
        for(int i=0; i<anzahl; i++){
            addPerson("randomPerson", "Koch");
        }
    } 
    
    /**
     * Der Befehl des Users (String) wird in ein String[] zerlegt. Dann wird das Feld analysiert und die richtigen Methoden werden aufgerufen.
     * @param command Eingabebefehl des Users
     */ 
    public void analyze(String command){
        String[] commandArray = command.split("\\s+");
        
        switch (commandArray[0]) {
            case "add":
                addPerson(commandArray[2], commandArray[1]);
                break;
            case "create":
                if(farhstuehle.size()<3){
                schreibeAktion("Fahrstuhl wird erstellt.");
                addFahrstuhl();}
                else{schreibeAktion("Maximale Anzahl erreicht.");}
                
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
            case "flip":
                schreibeAktion("Person " +commandArray[1] + " wird in die " + commandArray[2] + " Etage teleportiert.");
                flip(getMitarbeiter(Integer.parseInt(commandArray[1])));
                break;
            case "xray":
                fahrstuhlsimulator.testumgebung.TestFenster.panel.X_RAY = !fahrstuhlsimulator.testumgebung.TestFenster.panel.X_RAY;
                fahrstuhlsimulator.testumgebung.TestFenster.panel.repaint();
                break;
            case "random":
                startRandom(Integer.parseInt(commandArray[1]));
                break;
            case "close":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).close();
                schreibeAktion("door: close");
                break;
            case "open":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).open();
                schreibeAktion("door: open");
                break;
            case "goup":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).fahre();
                break;
             case "fahredirekt":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).fahren(Integer.parseInt(commandArray[2]));
                break;
            case "einsteigen":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).einsteigen(mitarbeiter.get(Integer.parseInt(commandArray[2])));
                mitarbeiter.get(Integer.parseInt(commandArray[2])).zieletage = Integer.parseInt(commandArray[3]);
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).addEtageToFahrliste(Integer.parseInt(commandArray[3]));
                break;
            case "aussteigen":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).aussteigen(mitarbeiter.get(Integer.parseInt(commandArray[2])));
                break;
            case "call":
                (farhstuehle.get(Integer.parseInt(commandArray[1]))).addEtageToFahrliste(mitarbeiter.get(Integer.parseInt(commandArray[2])).getAktEtage());
                break;
            default:
                schreibeAktion("Error: Befehl nicht erkannt");
                break;
            
        }       
    }
}    
  
