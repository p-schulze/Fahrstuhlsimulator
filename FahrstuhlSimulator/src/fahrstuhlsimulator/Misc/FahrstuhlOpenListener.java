/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.FahrstuhlGraphic;

/**
 *
 * @author Sebastian
 */
public interface FahrstuhlOpenListener {
    
    public void opened(FahrstuhlGraphic fG);
    
    public void closed(FahrstuhlGraphic fG);
    
}
