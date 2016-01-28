/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.animaton;

import fahrstuhlsimulator.Mitarbeiter.Glieder.RotatableGlied;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Sebastian
 */
public class MitarbeiterAnimator extends Animator {
    private RotatableGlied img_trans_arm_rechts;
    private RotatableGlied img_trans_arm_links;
    private RotatableGlied img_trans_koerper;
    private RotatableGlied img_trans_bein_links;
    private RotatableGlied img_trans_bein_rechts;
    
    public MitarbeiterAnimator()
    {
        img_trans_arm_rechts = new RotatableGlied();
        img_trans_arm_links = new RotatableGlied();
        img_trans_koerper = new RotatableGlied();
        img_trans_bein_links = new RotatableGlied();
        img_trans_bein_rechts = new RotatableGlied();
    }
    
    private void spielLaufanimation()
    {
        
    }
    public void setArmLinksRotation(double winkel, int x, int y)
    {
        this.rotateImg(img_trans_arm_links, winkel, 32, 64, x, y);
    }
    public void setArmRechtsRotation(double winkel, int x, int y)
    {
        this.rotateImg(img_trans_arm_rechts, winkel, 32, 64, x, y);
    }
    public void setBeinLinksRotation(double winkel, int x, int y)
    {
        this.rotateImg(img_trans_bein_links, winkel, 32, 96, x, y);
    }
    public void setBeinRechtsRotation(double winkel, int x, int y)
    {
        this.rotateImg(img_trans_bein_rechts, winkel, 32, 96, x, y);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getter Methoden fuer AffineTransformObjekte">
    
    public RotatableGlied getImg_trans_arm_rechts()
    {
        return img_trans_arm_rechts;
    }
    public RotatableGlied getImg_trans_arm_links()
    {
        return img_trans_arm_links;
    }
    public RotatableGlied getImg_trans_koerper()
    {
        return img_trans_koerper;
    }
    public RotatableGlied getImg_trans_bein_links()
    {
        return img_trans_bein_links;
    }
    public RotatableGlied getImg_trans_bein_rechts()
    {
        return img_trans_bein_rechts;
    }
//</editor-fold>
    
}
