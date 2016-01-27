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
public class Animator {
    
    public Animator()
    {
        
    }
    
    private void rotateImg(AffineTransform img_transformer, int winkel)
    {
        
    }
    protected void setPositionImg(AffineTransform img_transformer, int x,int y)
    {
        img_transformer.translate(x, y);
    }
}
