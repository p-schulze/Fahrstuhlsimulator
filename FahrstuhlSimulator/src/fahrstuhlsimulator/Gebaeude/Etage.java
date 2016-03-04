/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude;

/**
 *
 * @author becksusanna
 */
public class Etage {
    private int etagenzahl;
    public Etage(int nummer){
    int etagenzahl = nummer;
    }
    
     protected void setEtagenzahl(int id) {
        this.etagenzahl=id;
    }
    protected int getEtagenzahl()
    {
       return etagenzahl;

    }
}
