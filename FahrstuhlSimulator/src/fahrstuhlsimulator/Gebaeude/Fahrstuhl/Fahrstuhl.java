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
    private ArrayList<Integer> fahrliste;
    
    public Fahrstuhl(int x) {
        this.max=7;
        this.min=1;
        this.etage=1;
        this.faehrt=0;
        this.inFahrstuhl = new ArrayList<Mitarbeiter>();
        this.grafik = new ArrayList<FahrstuhlGraphic>();
        this.fahrliste = new ArrayList();
         
        for (int i = 0; i<8; i++) {
            //System.out.println(grafik);
            FahrstuhlGraphic element = new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1",x,i,false);
            this.grafik.add(element);
        }
    }
    
    public void addEtageToFahrliste(int e){
        fahrliste.add(e);
        
    }
    
    public boolean pruefeE(Mitarbeiter person, String etage) {
        return person.getErlaubteEtagen().contains(etage);        
    }
    
     public void fahren(int e){
        if(!open){
         etage = e;
        for (int i= 0; i<inFahrstuhl.size(); i++){
            inFahrstuhl.get(i).teleport(etage);
        }
        }
    }
    
    public void fahre(){
        if(!open){
        etage = this.fahrliste.get(0);
        for (int i= 0; i<inFahrstuhl.size(); i++){
            inFahrstuhl.get(i).teleport(etage);
        }
        this.fahrliste.remove(0);
        this.open();
    }}
    
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
    public void einsteigen(Mitarbeiter p) {
        inFahrstuhl.add(p);
        p.graphic.setVisible(false);
    }
    public void aussteigen(Mitarbeiter p) {
        this.inFahrstuhl.remove(p);
        p.graphic.setVisible(true);
    }
    public int getEtage() {return etage;}
    public ArrayList<FahrstuhlGraphic> getFahrstuhlGrafik(){return grafik;}
    public ArrayList<Mitarbeiter> getImFS() {return this.inFahrstuhl;}
    
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
            for (int i= 0; i<inFahrstuhl.size(); i++){
                if(inFahrstuhl.get(i).zieletage == etage){
                    this.aussteigen(inFahrstuhl.get(i));
                }
            }
        }
    }
}