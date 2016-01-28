/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.animaton;

import fahrstuhlsimulator.Mitarbeiter.Glieder.Arm;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Sebastian
 */
public class MitarbeiterAnimator extends Animator {
    private Arm img_trans_arm_rechts;
    private Arm img_trans_arm_links;
    private AffineTransform img_trans_koerper;
    private AffineTransform img_trans_bein_links;
    private AffineTransform img_trans_bein_rechts;
    
    public MitarbeiterAnimator()
    {
        img_trans_arm_rechts = new Arm();
        img_trans_arm_links = new Arm();
        img_trans_koerper = new AffineTransform();
        img_trans_bein_links = new AffineTransform();
        img_trans_bein_rechts = new AffineTransform();
    }
    
    private void spielLaufanimation()
    {
        
    }
    public void setArmLinksRotation(double winkel)
    {
        this.rotateImg(img_trans_arm_links, winkel, 32, 64);
    }
    public void setArmRechtsRotation(double winkel)
    {
        this.rotateImg(img_trans_arm_rechts, winkel, 32, 64);
    }
    public void setPosition(int x, int y)
    {
        this.setPositionImg(img_trans_arm_rechts, x, y);
        this.setPositionImg(img_trans_arm_links, x, y);
        this.setPositionImg(img_trans_koerper, x, y);
        this.setPositionImg(img_trans_bein_links, x, y+32);
        this.setPositionImg(img_trans_bein_rechts, x, y+32);

    }
    //<editor-fold defaultstate="collapsed" desc="Getter Methoden fuer AffineTransformObjekte">
    
    public Arm getImg_trans_arm_rechts()
    {
        return img_trans_arm_rechts;
    }
    public Arm getImg_trans_arm_links()
    {
        return img_trans_arm_links;
    }
    public AffineTransform getImg_trans_koerper()
    {
        return img_trans_koerper;
    }
    public AffineTransform getImg_trans_bein_links()
    {
        return img_trans_bein_links;
    }
    public AffineTransform getImg_trans_bein_rechts()
    {
        return img_trans_bein_rechts;
    }
//</editor-fold>
    
}
