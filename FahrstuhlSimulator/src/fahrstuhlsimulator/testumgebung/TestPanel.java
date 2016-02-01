/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.FahrstuhlGraphic;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import java.awt.Color;
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
    
    public static boolean X_RAY = false;
    
    public TestPanel()
    {
        
        this.setBounds(0,0, 800, 600);
        this.setLayout(null);
        this.setVisible(true);
        erstelleTestPerson();
        repaint();
        
    }
    
    private void erstelleTestPerson()
    {
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", -32, 2));
        mitarbeiterGraphics.get(0).umdrehen();
        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", -64, 2));
        mitarbeiterGraphics.get(1).umdrehen();
        mitarbeiterGraphics.get(1).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", -96, 2));
        mitarbeiterGraphics.get(2).umdrehen();
        mitarbeiterGraphics.get(2).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", -32, 3));
        mitarbeiterGraphics.get(3).umdrehen();
        mitarbeiterGraphics.get(3).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", -64, 3));
        mitarbeiterGraphics.get(4).umdrehen();
        mitarbeiterGraphics.get(4).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", -96, 3));
        mitarbeiterGraphics.get(5).umdrehen();
        mitarbeiterGraphics.get(5).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", -32, 4));
        mitarbeiterGraphics.get(6).umdrehen();
        mitarbeiterGraphics.get(6).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", -64, 4));
        mitarbeiterGraphics.get(7).umdrehen();
        mitarbeiterGraphics.get(7).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", -96, 4));
        mitarbeiterGraphics.get(8).umdrehen();
        mitarbeiterGraphics.get(8).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 800, 4));
        mitarbeiterGraphics.get(9).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 832, 4));
        mitarbeiterGraphics.get(10).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 864, 4));
        mitarbeiterGraphics.get(11).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 800, 3));
        mitarbeiterGraphics.get(12).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 832, 3));
        mitarbeiterGraphics.get(13).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 864, 3));
        mitarbeiterGraphics.get(14).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/SebastianArndt/", 800, 0,true));
        mitarbeiterGraphics.get(15).moveDistanceWithAnimation(450);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 832, 2));
        mitarbeiterGraphics.get(16).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 864, 2));
        mitarbeiterGraphics.get(17).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 896, 2));
        mitarbeiterGraphics.get(18).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 928, 2));
        mitarbeiterGraphics.get(19).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 960, 2));
        mitarbeiterGraphics.get(20).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 896, 3));
        mitarbeiterGraphics.get(21).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 928, 3));
        mitarbeiterGraphics.get(22).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 960, 3));
        mitarbeiterGraphics.get(23).moveDistanceWithAnimation(368);
        
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Administrator/", 896, 4));
        mitarbeiterGraphics.get(24).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person1/", 928, 4));
        mitarbeiterGraphics.get(25).moveDistanceWithAnimation(368);
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2/", 960, 4));
        mitarbeiterGraphics.get(26).moveDistanceWithAnimation(368);
        
        
        for(int i = 0; i < 6; i++)
        {
            fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, i, false));
        }
        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, 6, false));
        fahrstuhlGraphics.get(6).oeffneTuer();
        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, 7, true));
        fahrstuhlGraphics.get(7).schliesseTuer();
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(X_RAY)
        {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(0, 0, 800, 600);
            g2d.setColor(Color.black);
        }
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
        if(!X_RAY)
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
        else
        {
            g2d.setColor(mitarbeiterGraphic.markiert?Color.green:Color.blue);
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+31, 5, 16);
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+45, 6, 19);
            
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+12, mitarbeiterGraphic.getY_Pos()+28, 9, 18);
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+13, mitarbeiterGraphic.getY_Pos()+18, 8, 10);
            g2d.setColor(Color.red);
            g2d.drawRect(mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), 32, 64);
            g2d.setColor(mitarbeiterGraphic.markiert?Color.green:Color.blue);
            g2d.drawString(mitarbeiterGraphic.graphic_id+"", mitarbeiterGraphic.getX_Pos()+5, mitarbeiterGraphic.getY_Pos()+15);
            
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_links());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+31, 5, 16);
            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_links());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+45, 6, 19);
            g2d.setColor(Color.black);
        }
        
    }
    private void drawFahrstuhlGraphic(Graphics2D g2d, FahrstuhlGraphic fahrstuhlGraphic)
    {
        if(!X_RAY)
        {
        g2d.drawImage(fahrstuhlGraphic.getFahrstuhl_tuer_links(), fahrstuhlGraphic.getX_Pos_TuerLinks(), fahrstuhlGraphic.getY_Pos(), null);
        g2d.drawImage(fahrstuhlGraphic.getFahrstuhl_tuer_rechts(), fahrstuhlGraphic.getX_Pos_TuerRechts(), fahrstuhlGraphic.getY_Pos(), null);
        
        g2d.drawImage(fahrstuhlGraphic.getFahrstuhl_rahmen(), fahrstuhlGraphic.getX_Pos(), fahrstuhlGraphic.getY_Pos(), null);
        }
        else
        {
            g2d.drawRect(fahrstuhlGraphic.getX_Pos_TuerLinks()+10, fahrstuhlGraphic.getY_Pos()+12, 22, 51);
            g2d.drawRect(fahrstuhlGraphic.getX_Pos_TuerRechts()+32, fahrstuhlGraphic.getY_Pos()+12, 22, 51);
            
            g2d.drawRect(fahrstuhlGraphic.getX_Pos()+4, fahrstuhlGraphic.getY_Pos()+5, 56, 59);
        }
    }
    
}
