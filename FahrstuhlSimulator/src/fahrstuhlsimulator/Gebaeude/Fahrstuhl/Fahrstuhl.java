/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude.Fahrstuhl;

import java.util.ArrayList;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;

/**
 *
 * @author becksusanna
 */

public class Fahrstuhl {
    private boolean open;
    private int etage;
    private final int max;
    private final int min;
    private int faehrt; //0=fährt nicht, 1=hoch, 2=runter
    private ArrayList<Mitarbeiter> inFahrstuhl;
    private final ArrayList<FahrstuhlGraphic> grafik;
    
    public Fahrstuhl(int x) {
        this.max=7;
        this.min=1;
        this.etage=1;
        this.faehrt=0;
        this.inFahrstuhl = new ArrayList<Mitarbeiter>();
        this.grafik = new ArrayList<FahrstuhlGraphic>();
        for (int i = 0; i==7; i++) {
            FahrstuhlGraphic element = new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1",x,i,false);
            this.grafik.add(element);
        }
    }
    
    public boolean pruefeE(Mitarbeiter person, String etage) {
        return person.getErlaubteEtagen().contains(etage);        
    }
    public void fahren(int e) {
        String etage =this.EWandel(e);
        if (e>=0 && e <=7) {
            ArrayList<Integer> pruefen = new ArrayList<Integer>();  //erstellen ArrayList pruefen zum überprüfen, ob alle Personen im Fahrstuhl in die gewählte Etage fahren dürfen.
            for (int i =0;i<this.getImFS().size();i++) {
                if (this.pruefeE(this.getImFS().get(i),etage)) {
                    pruefen.add(0);                                 //für jede Person die in die Etage darf wird eine 0 eingefügt.
                }
                else {pruefen.add(1);}                              //für jede Person die nicht in die Etage darf wird eine 1 eingefügt.
            }   
            if (pruefen.contains(1) != true) {                      //enthält pruefen eine 1, so fährt der Fahrstuhl nicht los.
                if (e > this.etage) {
                    this.faehrt = 1;
                    while (this.etage<e) {
                        hoch();
                    }
                    for (int i =0;i<this.getImFS().size();i++) {this.getImFS().get(i).teleport(this.getEtage());}  //Teleportieren aller Personen im Fahrstuhl in Zieletage, wenn Fahrstuhl dort angekommen.
                    this.faehrt = 0;
                }
                else {
                    if (e < this.etage) {
                        this.faehrt = 2;
                        while (this.etage>e) {
                            runter();
                        }
                        for (int i =0;i<this.getImFS().size();i++) {this.getImFS().get(i).teleport(this.getEtage());}  //Teleportieren aller Personen im Fahrstuhl in Zieletage, wenn Fahrstuhl dort angekommen.
                        this.faehrt = 0;
                    }
                    else {System.out.println("Der Fahrstuhl ist bereits in Etage " + this.getEtage() + ".");}
                }
            }
            else {System.out.println("Eine der Personen im Fahrstuhl ist nicht berechtigt in Etage " + etage + " zu fahren.");}
        }
        else {System.out.println("Diese Etage existiert nicht.");}
    }
    public void fahren(String etage) {
        int e =this.EWandel(etage);
        if (e>=0 && e <=7) {
            ArrayList<Integer> pruefen = new ArrayList<Integer>();  //erstellen ArrayList pruefen zum überprüfen, ob alle Personen im Fahrstuhl in die gewählte Etage fahren dürfen.
            for (int i =0;i<this.getImFS().size();i++) {
                if (this.pruefeE(this.getImFS().get(i),etage)) {
                    pruefen.add(0);                                 //für jede Person die in die Etage darf wird eine 0 eingefügt.
                }
                else {pruefen.add(1);}                              //für jede Person die nicht in die Etage darf wird eine 1 eingefügt.
            }   
            if (pruefen.contains(1) != true) {                      //enthält pruefen eine 1, so fährt der Fahrstuhl nicht los.
                if (e > this.etage) {
                    this.faehrt = 1;
                    while (this.etage<e) {
                        hoch();
                    }
                    for (int i =0;i<this.getImFS().size();i++) {this.getImFS().get(i).teleport(this.getEtage());}  //Teleportieren aller Personen im Fahrstuhl in Zieletage, wenn Fahrstuhl dort angekommen.
                    this.faehrt = 0;
                }
                else {
                    if (e < this.etage) {
                        this.faehrt = 2;
                        while (this.etage>e) {
                            runter();
                        }
                        for (int i =0;i<this.getImFS().size();i++) {this.getImFS().get(i).teleport(this.getEtage());}  //Teleportieren aller Personen im Fahrstuhl in Zieletage, wenn Fahrstuhl dort angekommen.
                        this.faehrt = 0;
                    }
                    else {System.out.println("Der Fahrstuhl ist bereits in Etage " + this.getEtage() + ".");}
                }
            }
            else {System.out.println("Eine der Personen im Fahrstuhl ist nicht berechtigt in Etage " + etage + " zu fahren.");}
        }
        else {System.out.println("Diese Etage existiert nicht.");}
    }
    public void hoch() {
        this.etage ++;
        //Befehl für Grafik ?
    }
    public void runter() {
        this.etage --;
        //Befehl für Grafik ?
        
    }
    public String EWandel(int etage) {
        switch(etage) {
            case 0:
                return "IT";
            case 1:
                return "EG";
            case 2:
                return "Bibliothek";
            case 3:
                return "Test";
            case 4:
                return "Entwicklung";
            case 5:
                return "Labor";
            case 6:
                return "Besprechung";
            case 7:
                return "Cafeteria";
            default:
                return "";
                //"IT", "Tresor"
        }
    }
    public int EWandel(String etage) {
        switch(etage) {
            case "EG":
                return 1;
            case "Bibliothek":
                return 2;
            case "Test":
                return 3;
            case "Entwicklung":
                return 4;
            case "Labor":
                return 5;
            case "Besprechung":
                return 6;
            case "Cafeteria":
                return 7;
            default:
                return 20;
                //"IT", "Tresor"
        }
    }
    public void einsteigen(Mitarbeiter p) {inFahrstuhl.add(p);}
    public void aussteigen(Mitarbeiter p) {this.inFahrstuhl.remove(p);}
    public int getEtage() {return etage;}
    public ArrayList<FahrstuhlGraphic> getFahrstuhlGrafik(){return grafik;}
    public ArrayList<Mitarbeiter> getImFS() {return this.inFahrstuhl;}
    public void callFahrstuhl(String etage) {
        fahren(etage);
    }
    public void callFahrstuhl(int etage) {
        fahren(EWandel(etage));
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public void close(){
        if(open){
            open = false;
            grafik.get(etage).schliesseTuer();
        }
    }
    
    public void open(){
        if(!open){
            open = true;
            grafik.get(etage).oeffneTuer();
        }
    }
}