/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.animaton;

import java.awt.geom.AffineTransform;

/**
 *
 * @author Sebastian
 */
public class MitarbeiterAnimator extends Animator {
    private AffineTransform img_trans_arm_rechts;
    private AffineTransform img_trans_arm_links;
    private AffineTransform img_trans_koerper;
    private AffineTransform img_trans_bein_links;
    private AffineTransform img_trans_bein_rechts;
    
    public MitarbeiterAnimator()
    {
        img_trans_arm_rechts = new AffineTransform();
        img_trans_arm_links = new AffineTransform();
        img_trans_koerper = new AffineTransform();
        img_trans_bein_links = new AffineTransform();
        img_trans_bein_rechts = new AffineTransform();
    }
    
    private 
    
}
