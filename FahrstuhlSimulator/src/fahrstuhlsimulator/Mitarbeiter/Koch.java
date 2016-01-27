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
 * @author becksusanna
 */
public class Koch extends Mitarbeiter{
    public Koch(int id, String name) {
        super(id,name);
        ArrayList<Etage> liste = new ArrayList();
        //liste.add(EG);
        //liste.add(Cafeteria);
        setErlaubteEtagen(liste);
    }
}
