/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.FahrstuhlGraphic;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian
 */
public class TestPanel extends JPanel {
    
    public static ArrayList<MitarbeiterGraphic> mitarbeiterGraphics = new ArrayList();
    public ArrayList<FahrstuhlGraphic> fahrstuhlGraphics = new ArrayList();
    
    public TestPanel()
    {
        
        this.setBounds(0,0, 800, 600);
        this.setLayout(null);
        this.setVisible(true);
        //erstelleTestPerson();
        repaint();
        
    }
    
    private void erstelleTestPerson()
    {
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 100, 3));
        //mitarbeiterGraphics.get(0).umdrehen();
        //mitarbeiterGraphics.get(0).moveDistanceWithAnimation(500);
        //mitarbeiterGraphics.get(0).umdrehen();
//        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(732);
//        
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 700, 2));
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 668, 2));
//        mitarbeiterGraphics.get(2).umdrehen();
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/SebastianArndt/", 100, 2));
        mitarbeiterGraphics.get(1).umdrehen();
        mitarbeiterGraphics.get(1).schritteVor(2, false);
        //mitarbeiterGraphics.get(1).moveDistanceWithAnimation(500);
        
        
//        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 200, 2));
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(FahrstuhlGraphic fahrstuhlGraphic:fahrstuhlGraphics)
        {
            drawFahrstuhlGraphic(g2d,fahrstuhlGraphic);
        }
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
        
    }
    private void drawFahrstuhlGraphic(Graphics2D g2d, FahrstuhlGraphic fahrstuhlGraphic)
    {
        g2d.drawImage(fahrstuhlGraphic.getFahrstuhl_gesperrt(), fahrstuhlGraphic.getX_Pos(), fahrstuhlGraphic.getY_Pos(), null);
        
    }
    
}
