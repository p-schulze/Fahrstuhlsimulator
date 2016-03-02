/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter;

import java.util.ArrayList;
import fahrstuhlsimulator.Gebaeude.Etage;
import fahrstuhlsimulator.Misc.MitarbeiterMoveListener;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;

/**
 *
 * @author becksusanna
 */
public class Mitarbeiter{
    private int id;
    private String name;
    private String aktuelleEtage;
    private ArrayList<String> erlaubteEtagen;
    
    protected Mitarbeiter(int id, String name) {
        this.id=id;
        this.name=name;
        //this.erlaubteEtagen=erlaubteEtagen;
        //this.aktuelleEtage=EG;
    }
    
    protected int getID() {
        return id;
    }
    protected void setID(int id) {
        this.id=id;
    }
    
    protected String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name=name;
    }
    
    protected String getAktEtage() {
        return aktuelleEtage;
    }
    protected void setAktEtage(String aktEtage) {
        this.aktuelleEtage=aktEtage;
    }
    
    protected ArrayList<String> getErlaubteEtagen() {
        return erlaubteEtagen;
    }
    protected void setErlaubteEtagen(ArrayList<String> nErlaubteEtagen) {
        this.erlaubteEtagen=nErlaubteEtagen;
    }
}
