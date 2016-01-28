/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter.Graphic;

import fahrstuhlsimulator.Misc.ImageLoader;
import fahrstuhlsimulator.*;
import fahrstuhlsimulator.animaton.MitarbeiterAnimator;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class MitarbeiterGraphic
{
    private MitarbeiterAnimator animator;
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
        /**
        animator.getImg_trans_koerper().translate((32/2)+ getX_Pos(), (32/2)+getY_Pos());
        System.out.println(animator.getImg_trans_koerper().getScaleX());
        animator.getImg_trans_koerper().scale(-1, 1);
        System.out.println(animator.getImg_trans_koerper().getScaleX());
        animator.getImg_trans_koerper().translate((32/2)- getX_Pos(), (32/2)-getY_Pos());
        **/
        
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
    public int getY_Pos()
    {
        return 472-(64*etage); //TODO: An Klasse Etage anpassen
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
    }
    //<editor-fold defaultstate="collapsed" desc="Setter Methoden fuer die Koordinaten">
    private void setX_Pos(int x)
    {
        // Verbesserungswuedig!:D
        double tempDegrees_bein_rechts = Math.toDegrees(animator.getImg_trans_bein_rechts().getWinkel());
        double tempDegrees_bein_links = Math.toDegrees(animator.getImg_trans_bein_links().getWinkel());
        double tempDegrees_arm_links = Math.toDegrees(animator.getImg_trans_arm_links().getWinkel());
        double tempDegrees_arm_rechts = Math.toDegrees(animator.getImg_trans_arm_rechts().getWinkel());
        animator.setBeinRechtsRotation(-tempDegrees_bein_rechts, getX_Pos(), getY_Pos());
        animator.setBeinLinksRotation(-tempDegrees_bein_links, getX_Pos(), getY_Pos());
        animator.setArmLinksRotation(-tempDegrees_arm_links, getX_Pos(), getY_Pos());
        animator.setArmRechtsRotation(-tempDegrees_arm_rechts, getX_Pos(), getY_Pos());
        x_pos = x;
        animator.setBeinRechtsRotation(tempDegrees_bein_rechts, getX_Pos(), getY_Pos());
        animator.setBeinLinksRotation(tempDegrees_bein_links, getX_Pos(), getY_Pos());
        animator.setArmLinksRotation(tempDegrees_arm_links, getX_Pos(), getY_Pos());
        animator.setArmRechtsRotation(tempDegrees_arm_rechts, getX_Pos(), getY_Pos());
    }
    private void setEtage(int etage)
    {
        this.etage = etage;
    }
//</editor-fold>
    
    
    
    public void moveToPosition(int x)
    {
        ArrayList<String> tasks1 = new ArrayList();
        ArrayList<Object> objects1 = new ArrayList();
        
        tasks1.add("Mitarbeiter.move:speed(20)ziel("+x+")");
        objects1.add(this);
        
        FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
    }
    
    public boolean checkPositionGleichZielPosition(int x_ziel)
    {
        //System.out.println(x_pos + " "+ x_ziel);
        return(x_pos <= x_ziel);
    }
    public void addToX(int add)
    {
        setX_Pos(x_pos + add);
    }
    
    public void schrittVor()
    {
        
        ArrayList<String> tasks1 = new ArrayList();
        ArrayList<Object> objects1 = new ArrayList();
        
        tasks1.add("Mitarbeiter.hebFuss.rechts:speed(-20)winkel(-50)");
        objects1.add(this);
        tasks1.add("Mitarbeiter.hebFuss.rechts:speed(20)winkel(50)");
        objects1.add(this);
        tasks1.add("Mitarbeiter.hebFuss.rechts:speed(-20)winkel(-1)");
        objects1.add(this);
        
        ArrayList<String> tasks2 = new ArrayList();
        ArrayList<Object> objects2 = new ArrayList();
        
        tasks2.add("Mitarbeiter.hebFuss.links:speed(20)winkel(50)");
        objects2.add(this);
        tasks2.add("Mitarbeiter.hebFuss.links:speed(-20)winkel(-50)");
        objects2.add(this);
        tasks2.add("Mitarbeiter.hebFuss.links:speed(20)winkel(1)");
        objects2.add(this);
        
        ArrayList<String> tasks3 = new ArrayList();
        ArrayList<Object> objects3 = new ArrayList();
        
        tasks3.add("Mitarbeiter.hebArm.links:speed(-20)winkel(-50)");
        objects3.add(this);
        tasks3.add("Mitarbeiter.hebArm.links:speed(20)winkel(50)");
        objects3.add(this);
        tasks3.add("Mitarbeiter.hebArm.links:speed(-20)winkel(-1)");
        objects3.add(this);
        
        ArrayList<String> tasks4 = new ArrayList();
        ArrayList<Object> objects4 = new ArrayList();
        
        tasks4.add("Mitarbeiter.hebArm.rechts:speed(20)winkel(50)");
        objects4.add(this);
        tasks4.add("Mitarbeiter.hebArm.rechts:speed(-20)winkel(-50)");
        objects4.add(this);
        tasks4.add("Mitarbeiter.hebArm.rechts:speed(20)winkel(1)");
        objects4.add(this);
        
        FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
        FahrstuhlSimulator.graphicDrawer.addTask(tasks2, objects2);
        FahrstuhlSimulator.graphicDrawer.addTask(tasks3, objects3);
        FahrstuhlSimulator.graphicDrawer.addTask(tasks4, objects4);
        
        
    }
    
    
    
}
