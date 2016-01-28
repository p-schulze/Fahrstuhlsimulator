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
    
    protected void rotateImg(AffineTransform img_transformer, double winkel, int widthFromImg, int heightFromImg, int x, int y)
    {
        img_transformer.translate((widthFromImg/2)+ x, (heightFromImg/2)+y);  // + koordinaten
        img_transformer.rotate(Math.toRadians(winkel));
        img_transformer.translate(-(widthFromImg/2)- x, -(heightFromImg/2)-y); // - koordinaten
    }
    protected void setPositionImg(AffineTransform img_transformer, int x,int y)
    {
        img_transformer.translate(-img_transformer.getTranslateX(),0);
        img_transformer.translate(x, 0);
    }
}
