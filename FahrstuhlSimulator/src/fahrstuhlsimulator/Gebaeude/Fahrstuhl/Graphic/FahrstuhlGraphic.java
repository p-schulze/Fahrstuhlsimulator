/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic;

import fahrstuhlsimulator.FahrstuhlSimulator;
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
    public boolean open = false;
    
    //<editor-fold defaultstate="collapsed" desc="Koordinaten">
    private int x_pos;
    private int etage;
    
    private int x_pos_tuerLinks;
    private int x_pos_tuerRechts;
    //</editor-fold>
    
    public FahrstuhlGraphic(String fahrstuhlPfad, int x_position, int etage, boolean open)
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
        
        x_pos_tuerLinks = x_pos-(open?20:0);
        x_pos_tuerRechts = x_pos+(open?20:0);
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
    
    public int getX_Pos_TuerLinks()
    {
        return x_pos_tuerLinks;
    }
    public int getX_Pos_TuerRechts()
    {
        return x_pos_tuerRechts;
    }
    public int getX_Pos()
    {
        return x_pos;
    }
    public int getY_Pos()
    {
        return (472+600)-(64*etage); //TODO: An Klasse Etage anpassen
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
    
    public void setX_Pos_TuerLinks(int x)
    {
        x_pos_tuerLinks = x;
    }
    public void setX_Pos_TuerRechts(int x)
    {
        x_pos_tuerRechts = x;
    }
    private void setX_Pos(int x)
    {
        x_pos = x;
    }
    public void setEtage(int etage)
    {
        this.etage = etage;
    }
    
    public FahrstuhlAnimator getAnimator()
    {
        return animator;
    }
    
    
    public void oeffneTuer()
    {
        ArrayList<String> tasks1 = new ArrayList();
        ArrayList<Object> objects1 = new ArrayList();

        ArrayList<String> tasks2 = new ArrayList();
        ArrayList<Object> objects2 = new ArrayList();
        
        tasks1.add("Fahrstuhl.tuer.links.oeffnen:speed(20)ziel("+(getX_Pos_TuerLinks()-20)+")");
        objects1.add(this);

        tasks2.add("Fahrstuhl.tuer.rechts.oeffnen:speed(20)ziel("+(getX_Pos_TuerRechts()+20)+")");
        objects2.add(this);
        
        FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
        FahrstuhlSimulator.graphicDrawer.addTask(tasks2, objects2);
        if(FahrstuhlSimulator.graphicDrawer.isPausiert()){FahrstuhlSimulator.graphicDrawer.resumeThread();}
    }
    public void schliesseTuer()
    {
        ArrayList<String> tasks1 = new ArrayList();
        ArrayList<Object> objects1 = new ArrayList();

        ArrayList<String> tasks2 = new ArrayList();
        ArrayList<Object> objects2 = new ArrayList();
        
        tasks1.add("Fahrstuhl.tuer.links.schliessen:speed(20)ziel("+(getX_Pos_TuerLinks()+20)+")");
        objects1.add(this);

        tasks2.add("Fahrstuhl.tuer.rechts.schliessen:speed(20)ziel("+(getX_Pos_TuerRechts()-20)+")");
        objects2.add(this);
        
        FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
        FahrstuhlSimulator.graphicDrawer.addTask(tasks2, objects2);
        if(FahrstuhlSimulator.graphicDrawer.isPausiert()){FahrstuhlSimulator.graphicDrawer.resumeThread();}
    }

    public void addToX_tuerLinks(int add) 
    {
        setX_Pos_TuerLinks(x_pos_tuerLinks + add);
    }
    public void addToX_tuerRechts(int add) 
    {
        setX_Pos_TuerRechts(x_pos_tuerRechts + add);
    }

    public boolean checkTuerLinksPositionGleichZielPosition(int x_ziel, boolean opening)
    {
        
        if(opening)
        {
            return(x_pos_tuerLinks <= x_ziel);
        }else
        {
            return(x_pos_tuerLinks >= x_ziel);
        }
        
    }
    public boolean checkTuerRechtsPositionGleichZielPosition(int x_ziel, boolean opening)
    {
        if(opening)
        {
            return(x_pos_tuerRechts >= x_ziel);
        }else
        {
            return(x_pos_tuerRechts <= x_ziel);
        }
    }
        
}
