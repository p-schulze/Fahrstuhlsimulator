/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter;

import fahrstuhlsimulator.*;
import fahrstuhlsimulator.animaton.MitarbeiterAnimator;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class MitarbeiterGraphic
{
    private fahrstuhlsimulator.animaton.MitarbeiterAnimator animator;
    //<editor-fold defaultstate="collapsed" desc="BufferedImages fuer KoerperGlieder">
    private BufferedImage koerper;
    private BufferedImage bein_links;
    private BufferedImage bein_rechts;
    private BufferedImage arm_links;
    private BufferedImage arm_rechts;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Koordinaten">
    private int x_pos;
    private int etage;
    //</editor-fold>
    
    public MitarbeiterGraphic(String gliederPfad, int x_position, int etage)
    {
        HashMap gliederImgs = ImageLoader.getImagesVomPfad(gliederPfad);
        
        ArrayList<String> images_keySet = new ArrayList(gliederImgs.keySet());
        for(String image_key:images_keySet)
        {
            //<editor-fold defaultstate="collapsed" desc="Speicherung der BufferedImages">
        
            if(image_key.contains("Koerper"))
            {
                koerper = (BufferedImage) gliederImgs.get(image_key);
            }
            else if(image_key.contains("Arm_Links"))
            {
                arm_links = (BufferedImage) gliederImgs.get(image_key);
            }
            else if(image_key.contains("Arm_Rechts"))
            {
                arm_rechts = (BufferedImage) gliederImgs.get(image_key);
            }
            else if(image_key.contains("Bein_Links"))
            {
                bein_links = (BufferedImage) gliederImgs.get(image_key);
            }
            else if(image_key.contains("Bein_Rechts"))
            {
                bein_rechts =  (BufferedImage) gliederImgs.get(image_key);
            }
        
//</editor-fold>
        }
        //<editor-fold defaultstate="collapsed" desc="Speicherung der Koordinaten">
        x_pos = x_position;
        this.etage = etage;
//</editor-fold>
        
        animator = new MitarbeiterAnimator();
        
    }
    public MitarbeiterAnimator getAnimator()
    {
        return animator;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getter Methoden fuer KoerperGlieder">
    
    public BufferedImage getKoerper()
    {
        return koerper;
    }
    public BufferedImage getBein_links()
    {
        return bein_links;
    }
    public BufferedImage getBein_rechts()
    {
        return bein_rechts;
    }
    public BufferedImage getArm_links()
    {
        return arm_links;
    }
    public BufferedImage getArm_rechts()
    {
        return arm_rechts;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter Methoden fuer die Koordinaten">
    public int getX_Pos()
    {
        return x_pos;
    }
    public int getEtage()
    {
        return etage;
    }
//</editor-fold>

    public void setPosition(int x, int etage) // TODO: Klasse etagen mit einbeziehen
    {
        setX_Pos(x);
        setEtage(etage);
        animator.setPosition(x, 100); // Hier muss das etagen System implementiert werden
    }
    //<editor-fold defaultstate="collapsed" desc="Setter Methoden fuer die Koordinaten">
    private void setX_Pos(int x)
    {
        x_pos = x;
    }
    private void setEtage(int etage)
    {
        this.etage = etage;
    }
//</editor-fold>
    
    
    // Test Funktionen
    public void setStreckArme()
    {
        animator.setArmRotation(90);
    }
    
    
    
}
