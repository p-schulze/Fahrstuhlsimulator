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
    //Nur fuer X-Ray:
    public int graphic_id = 0;
    private static int idcounter = 0;
    public boolean markiert = false;
    //#######
    private MitarbeiterAnimator animator;
    private boolean flipped = false;
    private String gliederPfad;
    private boolean vis = true;
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
    
    private int koerperImgID = -1;
    private int armeImgID = -1;
    private int beineImgID = -1;
    
    public MitarbeiterGraphic(String gliederPfad, int x_position, int etage, boolean wichtig)
    {
        markiert = wichtig;
        this.gliederPfad = gliederPfad;
        saveBufferedImages(gliederPfad, "Links");
        this.MitarbeiterGraphicConsturctor(x_position,etage);
    }
    public MitarbeiterGraphic(int randomKoerperImgID, int randomArmeImgID,int randomBeineImgID, int x_position, int etage, boolean wichtig)
    {
        markiert = wichtig;
        koerperImgID= randomKoerperImgID;
        armeImgID   = randomArmeImgID;
        beineImgID  = randomBeineImgID;
        saveBufferedImages(randomKoerperImgID,randomArmeImgID,randomBeineImgID,"Links");
        this.MitarbeiterGraphicConsturctor(x_position,etage);
    }
    public MitarbeiterGraphic(String gliederPfad, int x_position, int etage)
    {
        this.gliederPfad = gliederPfad;
        saveBufferedImages(gliederPfad, "Links");
        this.MitarbeiterGraphicConsturctor(x_position,etage);
    }
    private void MitarbeiterGraphicConsturctor(int x_position, int etage)
    {
        graphic_id = idcounter++;
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
    
    public void setVisible(boolean vis)
    {
        this.vis = vis;
    }
    public boolean getVisible() {
        return vis;
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
        return (472+600)-(64*etage); //TODO: An Klasse Etage anpassen
    }
    public int getEtage()
    {
        return etage;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter Methoden fuer die Koordinaten">
    public void setPosition(int x, int etage) // TODO: Klasse etagen mit einbeziehen
    {
        setX_Pos(x);
        setEtage(etage);
    }
    
    private void setX_Pos(int x)
    {
        // Verbesserungswuedig!:D Wie so viele andere Teile im code^^ 
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
    public void setEtage(int etage)
    {
        // Verbesserungswuedig!:D Wie so viele andere Teile im code^^ 
        double tempDegrees_bein_rechts = Math.toDegrees(animator.getImg_trans_bein_rechts().getWinkel());
        double tempDegrees_bein_links = Math.toDegrees(animator.getImg_trans_bein_links().getWinkel());
        double tempDegrees_arm_links = Math.toDegrees(animator.getImg_trans_arm_links().getWinkel());
        double tempDegrees_arm_rechts = Math.toDegrees(animator.getImg_trans_arm_rechts().getWinkel());
        
        animator.setBeinRechtsRotation(-tempDegrees_bein_rechts, getX_Pos(), getY_Pos());
        animator.setBeinLinksRotation(-tempDegrees_bein_links, getX_Pos(), getY_Pos());
        animator.setArmLinksRotation(-tempDegrees_arm_links, getX_Pos(), getY_Pos());
        animator.setArmRechtsRotation(-tempDegrees_arm_rechts, getX_Pos(), getY_Pos());
        
        this.etage = etage;
        
        animator.setBeinRechtsRotation(tempDegrees_bein_rechts, getX_Pos(), getY_Pos());
        animator.setBeinLinksRotation(tempDegrees_bein_links, getX_Pos(), getY_Pos());
        animator.setArmLinksRotation(tempDegrees_arm_links, getX_Pos(), getY_Pos());
        animator.setArmRechtsRotation(tempDegrees_arm_rechts, getX_Pos(), getY_Pos());
    }
//</editor-fold>
    
    
    public void moveDistance(int x_distance)
    {
        int x = 0;
        if(flipped)
        {
            x = getX_Pos() + x_distance;
        }
        else
        {    
            x = getX_Pos() - x_distance;
        }
        ArrayList<String> tasks1 = new ArrayList();
        ArrayList<Object> objects1 = new ArrayList();
        
        tasks1.add("Mitarbeiter.move:speed(20)ziel("+x+")");
        objects1.add(this);
        
        FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
        if(FahrstuhlSimulator.graphicDrawer.isPausiert()){FahrstuhlSimulator.graphicDrawer.resumeThread();}
    }
    public void moveDistanceWithAnimation(int x)
    {
        
        int weg = x;
        int anzahlAnimationen = weg/200;
        schritteVor(anzahlAnimationen, weg%200>=50);
        moveDistance(x);
    }
    
    public boolean checkPositionGleichZielPosition(int x_ziel)
    {
        //System.out.println(x_pos + " "+ x_ziel);
        if(flipped)
        {
            return(x_pos >= x_ziel);
        }else
        {
            return(x_pos <= x_ziel);
        }
        
    }
    public void addToX(int add)
    {
        setX_Pos(x_pos + add);
    }
    
    public void schritteVor(int anzSchritte, boolean plusHalberSchritt)
    {
        if(anzSchritte > 0)
        {
            //<editor-fold defaultstate="collapsed" desc="SchritteVorVerarbeitung">
            ArrayList<String> tasks1 = new ArrayList();
            ArrayList<Object> objects1 = new ArrayList();

            ArrayList<String> tasks2 = new ArrayList();
            ArrayList<Object> objects2 = new ArrayList();

            ArrayList<String> tasks3 = new ArrayList();
            ArrayList<Object> objects3 = new ArrayList();

            ArrayList<String> tasks4 = new ArrayList();
            ArrayList<Object> objects4 = new ArrayList();

            for(int i = 0; i < anzSchritte; i++)
            {
                tasks1.add("Mitarbeiter.hebFuss.rechts:speed(-20)winkel(-50)");
                objects1.add(this);
                tasks1.add("Mitarbeiter.hebFuss.rechts:speed(20)winkel(50)");
                objects1.add(this);
                tasks1.add("Mitarbeiter.hebFuss.rechts:speed(-20)winkel(-1)");
                objects1.add(this);

                tasks2.add("Mitarbeiter.hebFuss.links:speed(20)winkel(50)");
                objects2.add(this);
                tasks2.add("Mitarbeiter.hebFuss.links:speed(-20)winkel(-50)");
                objects2.add(this);
                tasks2.add("Mitarbeiter.hebFuss.links:speed(20)winkel(1)");
                objects2.add(this);

                tasks3.add("Mitarbeiter.hebArm.links:speed(-20)winkel(-50)");
                objects3.add(this);
                tasks3.add("Mitarbeiter.hebArm.links:speed(20)winkel(50)");
                objects3.add(this);
                tasks3.add("Mitarbeiter.hebArm.links:speed(-20)winkel(-1)");
                objects3.add(this);

                tasks4.add("Mitarbeiter.hebArm.rechts:speed(20)winkel(50)");
                objects4.add(this);
                tasks4.add("Mitarbeiter.hebArm.rechts:speed(-20)winkel(-50)");
                objects4.add(this);
                tasks4.add("Mitarbeiter.hebArm.rechts:speed(20)winkel(1)");
                objects4.add(this);
            }
            if(plusHalberSchritt)
            {
                boolean zufall = Math.random()>=0.5;
                tasks1.add("Mitarbeiter.hebFuss.rechts:"+(zufall?"speed(-20)winkel(-50)":"speed(20)winkel(50)"));
                objects1.add(this);
                tasks1.add("Mitarbeiter.hebFuss.rechts:"+(zufall?"speed(20)winkel(1)":"speed(-20)winkel(-1)"));
                objects1.add(this);

                tasks2.add("Mitarbeiter.hebFuss.links:"+(zufall?"speed(20)winkel(50)":"speed(-20)winkel(-50)"));
                objects2.add(this);
                tasks2.add("Mitarbeiter.hebFuss.links:"+(zufall?"speed(-20)winkel(-1)":"speed(20)winkel(1)"));
                objects2.add(this);

                tasks3.add("Mitarbeiter.hebArm.links:"+(zufall?"speed(-20)winkel(-50)":"speed(20)winkel(50)"));
                objects3.add(this);
                tasks3.add("Mitarbeiter.hebArm.links:"+(zufall?"speed(20)winkel(1)":"speed(-20)winkel(-1)"));
                objects3.add(this);

                tasks4.add("Mitarbeiter.hebArm.rechts:"+(zufall?"speed(20)winkel(50)":"speed(-20)winkel(-50)"));
                objects4.add(this);
                tasks4.add("Mitarbeiter.hebArm.rechts:"+(zufall?"speed(-20)winkel(-1)":"speed(20)winkel(1)"));
                objects4.add(this);
            }

            FahrstuhlSimulator.graphicDrawer.addTask(tasks1, objects1);
            FahrstuhlSimulator.graphicDrawer.addTask(tasks2, objects2);
            FahrstuhlSimulator.graphicDrawer.addTask(tasks3, objects3);
            FahrstuhlSimulator.graphicDrawer.addTask(tasks4, objects4);
        }
//</editor-fold>
    }
    public void umdrehen()
    {
        if(flipped)
        {
            if(koerperImgID >= 0)
            {
                saveBufferedImages(koerperImgID,armeImgID,beineImgID, "Links");
            }else
            {
                saveBufferedImages(gliederPfad, "Links");
            }
            flipped = false;
        }
        else
        {
            if(koerperImgID >= 0)
            {
                saveBufferedImages(koerperImgID,armeImgID,beineImgID, "Rechts");
            }else
            {
                saveBufferedImages(gliederPfad, "Rechts");
            }
            flipped = true;
        }
    }
    
    public boolean getFlipped()
    {
        return flipped;
    }

    public void setFlipped(boolean b) {
        flipped = b;
    }

    private void saveBufferedImages(String gliederPfad, String seite) {
        HashMap gliederImgs = ImageLoader.getImagesVomPfad(gliederPfad);
        ArrayList<String> images_keySet = new ArrayList(gliederImgs.keySet());
        for(String image_key:images_keySet)
        {
            //<editor-fold defaultstate="collapsed" desc="Speicherung der BufferedImages">
            String[] image_keySplit = image_key.split("_");
            
            if(image_keySplit[1].equalsIgnoreCase(seite))
            {
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
            }
        
//</editor-fold>
        }
    }
    
    private void saveBufferedImages(int randomKoerperImgID, int randomArmeImgID,int randomBeineImgID, String seite) {
        HashMap gliederImgs = ImageLoader.getImagesVomPfad("img/Person/RandomMitarbeiter/Koerper/"+randomKoerperImgID);
        ArrayList<String> images_keySet = new ArrayList(gliederImgs.keySet());
        for(String image_key:images_keySet)
        {
            //<editor-fold defaultstate="collapsed" desc="Speicherung der BufferedImages">
            String[] image_keySplit = image_key.split("_");
            
            if(image_keySplit[0].equalsIgnoreCase(seite))
            {
                if(image_key.contains("Koerper"))
                {
                    koerper = (BufferedImage) gliederImgs.get(image_key);
                }
            }
        
//</editor-fold>
        }
        gliederImgs = ImageLoader.getImagesVomPfad("img/Person/RandomMitarbeiter/Arme/"+randomArmeImgID);
        images_keySet = new ArrayList(gliederImgs.keySet());
        for(String image_key:images_keySet)
        {
            //<editor-fold defaultstate="collapsed" desc="Speicherung der BufferedImages">
            String[] image_keySplit = image_key.split("_");
            
            if(image_keySplit[0].equalsIgnoreCase(seite))
            {
                if(image_key.contains("Arm_Links"))
                {
                    arm_links = (BufferedImage) gliederImgs.get(image_key);
                }
                else if(image_key.contains("Arm_Rechts"))
                {
                    arm_rechts = (BufferedImage) gliederImgs.get(image_key);
                }
            }
        
//</editor-fold>
        }
        gliederImgs = ImageLoader.getImagesVomPfad("img/Person/RandomMitarbeiter/Beine/"+randomBeineImgID);
        images_keySet = new ArrayList(gliederImgs.keySet());
        for(String image_key:images_keySet)
        {
            //<editor-fold defaultstate="collapsed" desc="Speicherung der BufferedImages">
            String[] image_keySplit = image_key.split("_");
            
            if(image_keySplit[0].equalsIgnoreCase(seite))
            {
                if(image_key.contains("Bein_Links"))
                {
                    bein_links = (BufferedImage) gliederImgs.get(image_key);
                }
                else if(image_key.contains("Bein_Rechts"))
                {
                    bein_rechts =  (BufferedImage) gliederImgs.get(image_key);
                }
            }
        
//</editor-fold>
        }
    }
    
    
}
