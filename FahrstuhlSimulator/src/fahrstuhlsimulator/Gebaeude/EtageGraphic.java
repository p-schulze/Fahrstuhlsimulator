/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude;
import fahrstuhlsimulator.Misc.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author becksusanna
 */
public class EtageGraphic {
    
    private int y_pos = 0;
    private BufferedImage img;
    
    public EtageGraphic(int etage) {
        this.y_pos= (472+600)-(64*etage);
        img = (BufferedImage) ImageLoader.getImages().get("img/Etage/Etage"+etage+".png");
    }
    
    public BufferedImage getImg()
    {
        return img;
    }
    public int getY_Pos()
    {
        return y_pos;
    }
}
