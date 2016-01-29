/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian
 */
public class TestPanel extends JPanel {
    
    private BufferedImage skin;
    public ArrayList<MitarbeiterGraphic> mitarbeiterGraphics = new ArrayList();
    
    public TestPanel()
    {
        
        this.setSize(800, 600);
        this.setLayout(null);
        this.setVisible(true);
        erstelleTestPerson();
        repaint();
        
    }
    
    private void erstelleTestPerson()
    {
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
        mitarbeiterGraphics.get(0).schrittVor();
        mitarbeiterGraphics.get(0).moveToPosition(100);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 300, 1));
        mitarbeiterGraphics.get(1).schrittVor();
        mitarbeiterGraphics.get(1).moveToPosition(150);
        
        
        
        
        
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
//        mitarbeiterGraphics.get(1).setPosition(400, 0);
//        mitarbeiterGraphics.get(1).setGestreckteArme();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(MitarbeiterGraphic mitarbeiterGraphic:mitarbeiterGraphics)
        {
            drawMitarbeiterGraphic(g2d,mitarbeiterGraphic);
        }
        
    }
    
    private void drawMitarbeiterGraphic(Graphics2D g2d, MitarbeiterGraphic mitarbeiterGraphic)
    {
        
        
        g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts());
        g2d.drawImage(mitarbeiterGraphic.getArm_rechts(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
        g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts());
        g2d.drawImage(mitarbeiterGraphic.getBein_rechts(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
        g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
        g2d.drawImage(mitarbeiterGraphic.getKoerper(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
        g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_links());
        g2d.drawImage(mitarbeiterGraphic.getArm_links(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
        g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_links());
        g2d.drawImage(mitarbeiterGraphic.getBein_links(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
//        g2d.drawImage(mitarbeiterGraphic.getArm_rechts(), mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts(), null);
//        g2d.drawImage(mitarbeiterGraphic.getBein_rechts(), mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts(), null);
//        g2d.drawImage(mitarbeiterGraphic.getKoerper(), mitarbeiterGraphic.getAnimator().getImg_trans_koerper(), null);
//        g2d.drawImage(mitarbeiterGraphic.getArm_links(), mitarbeiterGraphic.getAnimator().getImg_trans_arm_links(), null);
//        g2d.drawImage(mitarbeiterGraphic.getBein_links(), mitarbeiterGraphic.getAnimator().getImg_trans_bein_links(), null);
        
    }
    
}
