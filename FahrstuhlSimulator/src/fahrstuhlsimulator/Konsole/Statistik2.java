/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Konsole;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import fahrstuhlsimulator.Konsole.Konsole;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;


public class Statistik2 implements Runnable{
                             //Listen nur zu Testzwecken
    
    final int PAD = 20;
    
    public static ArrayList<Mitarbeiter> tdliste = new ArrayList<>();
    public static ArrayList<Mitarbeiter> gtdliste= new ArrayList<>();
    public static int teilnehmerdaten;                                                            //teilnehmerdaten beschreibt die Gesamtheit der Elemente aus Teilnehmerliste innerhalb von jeweils 10 Sekunden
    public   static  int gesamttd;                                                                   //gesamtteilnehmerdaten beschreibt die Gesamtheit der Elemente aus Teilnehmerliste innerhalb der 60 Sekunden
     public   static int anzahl;                                                                     //anzahl ist die Anzahl der Teilnehmer
     public static   int t;                                                                          //t ist bloß um einen Timer darzustellen (jeweils 10 Sekunden)
    /**
     * Erstellt neues Objekt
     */
    public Statistik2(){
        
    }
    
   public static void main(String[] args) throws InterruptedException {
        Statistik2 konst = new Statistik2();
        (new Thread(konst)).start(); 
        
    }

    @Override
    /**
     * Rechnet den Durchschnitt aus in 60 Sekunden, wobei auf die Inhalte der Liste, also die Eigenschaften der Objekte eingegangen wird.
     */
    public void run() 
    {
                              //Listen etc werden festgelegt
        tdliste = (fahrstuhlsimulator.Konsole.Konsole.getMitarbeiterListe());
        System.out.println(tdliste);
       
        gtdliste = (fahrstuhlsimulator.Konsole.Konsole.getMitarbeiterListe());
                                                                         //t ist bloß um einen Timer darzustellen (jeweils 10 Sekunden)
        while(true){
            
//Inhalt der Teilnehmerdatenliste wird gelöscht,
            teilnehmerdaten=0;                                                          //damit bei einer erneuten Überprüfung auch mit neuen Teilnehmern gerechnet wird.
            gesamttd=0;                                                                 
            anzahl=0;                                                               
            t=0;
            
            for(int i=0;i<=5;i++){
                teilnehmerdaten=0;
                
                
               
                for(int c = 0; c < tdliste.size(); c++) {                               //Liste durchgehen um daten zu bekommen
                    teilnehmerdaten += 1;
                    gtdliste.add(tdliste.get(c));
                    
                }
                tdliste.clear();
                gesamttd = gesamttd + teilnehmerdaten;
                anzahl = anzahl + tdliste.size();
                try {
                    Thread.sleep(3000);                                                 //10 Sekunden abwarten 
                    t=t+10;                                                             //10 Sekunden Timer anzeigen
                    System.out.println(t);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(anzahl !=0){
            gesamttd = gesamttd / anzahl;    
                }//Durchschnitt berechnen
            System.out.println("Anzahl der Teilnehmer:" + gtdliste.size());
            System.out.println("Alle Teilnehmer:");
            for(int e = 0; e < gtdliste.size(); e++) {                                  //Alle Teilnehmer anzeigen
                    System.out.println(gtdliste.get(e));
                    
            }
            System.out.println("********");
            System.out.println("    " + gesamttd);                                      //Durchschnitt anzeigen
            System.out.println("********");
            
//            JFrame f = new JFrame();
//            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            f.add(new Zeichnen());
//            f.setSize(400,400);
//            f.setLocation(200,200);
//            f.setVisible(true);
            tdliste.clear();   
            gtdliste.clear();
        }
        
    }
}}
    

