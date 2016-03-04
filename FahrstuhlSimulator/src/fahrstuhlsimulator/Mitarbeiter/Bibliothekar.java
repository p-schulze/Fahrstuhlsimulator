/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter;
import java.util.ArrayList;
import fahrstuhlsimulator.Gebaeude.Etage;
/**
 *
 * @author schueler
 */
public class Bibliothekar extends Mitarbeiter{
    public Bibliothekar(String name) {
        super(name);
        ArrayList<String> liste = new ArrayList();
        liste.add("EG");
        liste.add("Cafeteria");
        liste.add("Bibliothek");
        liste.add("Besprechung");
        setErlaubteEtagen(liste); 
    }
    
}
