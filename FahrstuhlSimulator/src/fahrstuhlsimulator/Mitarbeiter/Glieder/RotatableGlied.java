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
public class RotatableGlied extends AffineTransform{
    private double winkel = 0;
    public RotatableGlied()
    {
        super();
    }
    
    
//    public boolean checkPositionGleichZielPosition(double x_pos_ziel)
//    {
//        System.out.println(x_pos + " " + x_pos_ziel);
//        return(x_pos <= x_pos_ziel);
//    }
    
    public boolean checkWinkelGleichZielWinkel(double ziel_winkel)
    {
        //System.out.println(winkel +" " + ziel_winkel);
        return(winkel >= ziel_winkel);
    }
    public boolean checkRevertWinkelGleichZielWinkel(double ziel_winkel)
    {
        return(winkel <= ziel_winkel);
    }
    
    public double getWinkel()
    {
        return winkel;
    }
    
    @Override
    public void rotate(double theta) {
        super.rotate(theta); //To change body of generated methods, choose Tools | Templates.
        winkel = winkel + theta;
        //System.out.println(winkel);
    }

    
}
