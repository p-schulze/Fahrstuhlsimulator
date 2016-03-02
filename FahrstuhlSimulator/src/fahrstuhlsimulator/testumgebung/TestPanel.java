/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.FahrstuhlSimulator;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;
import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.RandomMitarbeiterGenerator;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
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
    public static ArrayList<FahrstuhlGraphic> fahrstuhlGraphics = new ArrayList();
    
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
        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2", 0, 0));
        mitarbeiterGraphics.get(0).umdrehen();
        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(368);
        
        //mitarbeiterGraphics.get(1).moveDistanceWithAnimation(368);
        
        
        for(int i = 0; i < 6; i++)
        {
            fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, i, false));
        }
        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, 6, false));
        //fahrstuhlGraphics.get(6).oeffneTuer();
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
            g2d.setColor(Color.cyan);
            g2d.drawString("X-Ray Modus", 700, 15);
            g2d.setColor(Color.blue);
            g2d.drawString("(600/"+GraphicDrawer.getDurrationForFrame()+")Fps", 705,30);
            g2d.drawString(((float) 600/+GraphicDrawer.getDurrationForFrame())+" Fps", 705,45);
            g2d.setColor(Color.black);
        }
        //Veraltet###
        for(FahrstuhlGraphic fahrstuhlGraphic:fahrstuhlGraphics)
        {
            drawFahrstuhlGraphic(g2d,fahrstuhlGraphic);
        }
        for(MitarbeiterGraphic mitarbeiterGraphic:mitarbeiterGraphics)
        {
            drawMitarbeiterGraphic(g2d,mitarbeiterGraphic);
        }
        //###
        ArrayList<Mitarbeiter> mitarbeiter = MitarbeiterFahrstuhlSimulator.konsole.getMitarbeiter();
        for(Mitarbeiter einMitarbeiter:mitarbeiter)
        {
            MitarbeiterGraphic mGf = einMitarbeiter.getGraphic();
            drawMitarbeiterGraphic(g2d, mGf);
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
