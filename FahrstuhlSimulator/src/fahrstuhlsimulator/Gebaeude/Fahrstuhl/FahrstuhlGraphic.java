/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude.Fahrstuhl;

import fahrstuhlsimulator.Misc.ImageLoader;
import fahrstuhlsimulator.animaton.FahrstuhlAnimator;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sebastian
 */
public class FahrstuhlGraphic {
    
    private FahrstuhlAnimator animator;
    private BufferedImage fahrstuhl_rahmen;
    private BufferedImage fahrstuhl_tuer_links;
    private BufferedImage fahrstuhl_tuer_rechts;
    private BufferedImage fahrstuhl_gesperrt;
    
    //<editor-fold defaultstate="collapsed" desc="Koordinaten">
    private int x_pos;
    private int etage;
    //</editor-fold>
    
    public FahrstuhlGraphic(String fahrstuhlPfad, int x_position, int etage)
    {
        HashMap fastuhlImgs = ImageLoader.getImagesVomPfad(fahrstuhlPfad);
        
        ArrayList<String> images_keySet = new ArrayList(fastuhlImgs.keySet());
        for(String image_key:images_keySet)
        {
            if(image_key.contains("Rahmen"))
            {
                fahrstuhl_rahmen = (BufferedImage) fastuhlImgs.get(image_key);
            }
            else if(image_key.contains("Tuer_Links"))
            {
                fahrstuhl_tuer_links = (BufferedImage) fastuhlImgs.get(image_key);
            }
            else if(image_key.contains("Tuer_Rechts"))
            {
                fahrstuhl_tuer_rechts = (BufferedImage) fastuhlImgs.get(image_key);
            }
            else if(image_key.contains("Gesperrt"))
            {
                fahrstuhl_gesperrt = (BufferedImage) fastuhlImgs.get(image_key);
            }
        }
        x_pos = x_position;
        this.etage = etage;
        animator = new FahrstuhlAnimator();
    }
    
    public BufferedImage getFahrstuhl_rahmen()
    {
        return fahrstuhl_rahmen;
    }
    public BufferedImage getFahrstuhl_tuer_links()
    {
        return fahrstuhl_tuer_links;
    }
    public BufferedImage getFahrstuhl_tuer_rechts()
    {
        return fahrstuhl_tuer_rechts;
    }
    public BufferedImage getFahrstuhl_gesperrt()
    {
        return fahrstuhl_gesperrt;
    }
    
    
    public int getX_Pos()
    {
        return x_pos;
    }
    public int getY_Pos()
    {
        return 472-(64*etage); //TODO: An Klasse Etage anpassen
    }
    public int getEtage()
    {
        return etage;
    }
    
    public void setPosition(int x, int etage) // TODO: Klasse etagen mit einbeziehen
    {
        setX_Pos(x);
        setEtage(etage);
    }
    
    private void setX_Pos(int x)
    {
        x_pos = x;
    }
    private void setEtage(int etage)
    {
        this.etage = etage;
    }
    
    public FahrstuhlAnimator getAnimator()
    {
        return animator;
    }
        
}
