/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter.Glieder;

import java.awt.geom.AffineTransform;

/**
 *
 * @author Sebastian
 */
public class Arm extends AffineTransform{
    private double winkel = 0;
    private double ziel_winkel = 0;
    public Arm()
    {
        super();
    }
    
    public boolean checkWinkelGleichZielWinkel()
    {
        return(winkel == ziel_winkel);
    }
    
    public void setZielWinkel(double winkel)
    {
        ziel_winkel = winkel;
    }
    public double getWinkel()
    {
        return winkel;
    }
    
    @Override
    public void rotate(double theta) {
        super.rotate(theta); //To change body of generated methods, choose Tools | Templates.
        winkel = theta;
    }

    
}
