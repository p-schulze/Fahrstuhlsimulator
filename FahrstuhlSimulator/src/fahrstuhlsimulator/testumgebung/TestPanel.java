/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

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
    private ArrayList<fahrstuhlsimulator.Mitarbeiter.MitarbeiterGraphic> mitarbeiterGraphics = new ArrayList();
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
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.MitarbeiterGraphic("img/Person/Administrator/", 300, 0));
        mitarbeiterGraphics.get(0).setPosition(300, WIDTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        for(fahrstuhlsimulator.Mitarbeiter.MitarbeiterGraphic mitarbeiterGraphic:mitarbeiterGraphics)
        {
            drawMitarbeiterGraphic(g2d,mitarbeiterGraphic);
        }
        
    }
    
    private void drawMitarbeiterGraphic(Graphics2D g2d, fahrstuhlsimulator.Mitarbeiter.MitarbeiterGraphic mitarbeiterGraphic)
    {
        
//        AffineTransform at = new AffineTransform();
//        at.translate(200, 100);
//        at.rotate(Math.toRadians(180));
//        at.translate(-mitarbeiterGraphic.getArm_rechts().getWidth()/2, -mitarbeiterGraphic.getArm_rechts().getHeight()/2);
//        g2d.drawImage(mitarbeiterGraphic.getArm_rechts(), at, null);
        
        g2d.drawImage(mitarbeiterGraphic.getArm_rechts(), mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts(), null);
        g2d.drawImage(mitarbeiterGraphic.getBein_rechts(), mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts(), null);
        g2d.drawImage(mitarbeiterGraphic.getKoerper(), mitarbeiterGraphic.getAnimator().getImg_trans_koerper(), null);
        g2d.drawImage(mitarbeiterGraphic.getArm_links(), mitarbeiterGraphic.getAnimator().getImg_trans_arm_links(), null);
        g2d.drawImage(mitarbeiterGraphic.getBein_links(), mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts(), null);
        
//        g2d.drawImage(mitarbeiterGraphic.getArm_rechts(), null, mitarbeiterGraphic.getX_Pos(), 100);
//        g2d.drawImage(mitarbeiterGraphic.getBein_rechts(), null, mitarbeiterGraphic.getX_Pos(), 100+32);
//        g2d.drawImage(mitarbeiterGraphic.getKoerper(), null, mitarbeiterGraphic.getX_Pos(), 100);
//        g2d.drawImage(mitarbeiterGraphic.getArm_links(), null, mitarbeiterGraphic.getX_Pos(), 100);
//        g2d.drawImage(mitarbeiterGraphic.getBein_links(), null, mitarbeiterGraphic.getX_Pos(), 100+32);
    }
    
}
