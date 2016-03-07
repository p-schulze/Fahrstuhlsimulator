/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung;

import fahrstuhlsimulator.FahrstuhlSimulator;
import fahrstuhlsimulator.Gebaeude.EtageGraphic;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;
import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.MouseController;
import fahrstuhlsimulator.Misc.PaneScroller;
import fahrstuhlsimulator.Misc.RandomMitarbeiterGenerator;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


/**
 *
 * @author Sebastian
 */
public class TestPanel extends JPanel{
    
    public static ArrayList<MitarbeiterGraphic> mitarbeiterGraphics = new ArrayList();
    public static ArrayList<FahrstuhlGraphic> fahrstuhlGraphics = new ArrayList();
    public static ArrayList<EtageGraphic> etageGraphics = new ArrayList();
    
    private MouseController mC;
    
    public static boolean X_RAY = false;
    
    public TestPanel()
    {
        
        this.setBounds(0,-600, 800, 1200);
        this.setLayout(null);
        this.setVisible(true);
        mC = new MouseController();
        this.addMouseMotionListener(mC);
        this.addMouseListener(mC);
        erstelleTestPerson();
        repaint();
        
    }
    
    private void erstelleTestPerson()
    {
//        mitarbeiterGraphics.add(new fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic("img/Person/Person2", 0, 0));
//        mitarbeiterGraphics.get(0).umdrehen();
//        mitarbeiterGraphics.get(0).moveDistanceWithAnimation(368);
        
        //mitarbeiterGraphics.get(1).moveDistanceWithAnimation(368);
        
        
        for(int i = 0; i < 6; i++)
        {
            fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, i, false));
        }
        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, 6, false));
        fahrstuhlGraphics.get(6).oeffneTuer();
        fahrstuhlGraphics.add(new FahrstuhlGraphic("img/Fahrstuhl/Fahrstuhl1", 368, 7, true));
        fahrstuhlGraphics.get(7).schliesseTuer();
        
        for(int i = 0; i < 8; i++)
        {
            etageGraphics.add(new EtageGraphic(i));
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(X_RAY)
        {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(0, 0, 800, 1200);
            g2d.setColor(Color.BLACK);
        }
        else
        {
            g2d.setColor(new Color(133,224,255));
            g2d.fillRect(0, 0, 800, 1200);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 1072, 800, 128);
        }
        //Veraltet###
        for(EtageGraphic etageGraphic: etageGraphics)
        {
            drawEtageGraphic(g2d, etageGraphic);
        }
        for(FahrstuhlGraphic fahrstuhlGraphic:fahrstuhlGraphics)
        {
            drawFahrstuhlGraphic(g2d,fahrstuhlGraphic);
        }
//        for(MitarbeiterGraphic mitarbeiterGraphic:mitarbeiterGraphics)
//        {
//            drawMitarbeiterGraphic(g2d,mitarbeiterGraphic);
//        }
        //###
        ArrayList<Mitarbeiter> mitarbeiter = FahrstuhlSimulator.konsole.getMitarbeiterListe();
        for(Mitarbeiter einMitarbeiter:mitarbeiter)
        {
            
            drawMitarbeiterGraphic(g2d, einMitarbeiter);
        }
        
        g2d.setColor(Color.cyan);
        g2d.setXORMode(Color.RED);
        g2d.drawRect(mC.auswahlFeld.x, mC.auswahlFeld.y, mC.auswahlFeld.width, mC.auswahlFeld.height);
        g2d.setColor(Color.BLACK);
        g2d.setPaintMode();
        
        if(mC.rCM_panel.visible)
        {
            g2d.fillRect(mC.rCM_panel.x, mC.rCM_panel.y, mC.rCM_panel.width, mC.rCM_panel.height);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(mC.rCM_panel.x+2, mC.rCM_panel.y+2, mC.rCM_panel.width-4, mC.rCM_panel.height-4);
            
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fill3DRect(mC.rCM_panel.btn.relative_x +mC.rCM_panel.x, mC.rCM_panel.btn.relative_y +mC.rCM_panel.y, mC.rCM_panel.btn.width, mC.rCM_panel.btn.height, true);
            g2d.setColor(Color.BLACK);
            g2d.drawString(mC.rCM_panel.btn.text, mC.rCM_panel.btn.relative_x +mC.rCM_panel.x+30, mC.rCM_panel.btn.relative_y +mC.rCM_panel.y+15);
            //g2d.drawRect(632, 906,100 , 200);
        }
        
        
        
        if(X_RAY)
        {
            g2d.setColor(Color.cyan);
            g2d.drawString("X-Ray Modus", 700, 15);
            g2d.setColor(Color.blue);
            g2d.drawString("(600/"+GraphicDrawer.getDurrationForFrame()+")Fps", 705,30);
            g2d.drawString(((float) 600/+GraphicDrawer.getDurrationForFrame())+" Fps", 705,45);
            g2d.setColor(Color.black);
        }
    }
    
    private void drawMitarbeiterGraphic(Graphics2D g2d, Mitarbeiter mitarbeiter)
    {
        
        MitarbeiterGraphic mitarbeiterGraphic = mitarbeiter.getGraphic();
        if(!X_RAY)
        {
            
            AffineTransform tx = AffineTransform.getRotateInstance(mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts().getWinkel(), mitarbeiterGraphic.getArm_rechts().getWidth()/2, mitarbeiterGraphic.getArm_rechts().getHeight()/2);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(mitarbeiterGraphic.getArm_rechts(), null), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
            tx = AffineTransform.getRotateInstance(mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts().getWinkel(), mitarbeiterGraphic.getBein_rechts().getWidth()/2, mitarbeiterGraphic.getBein_rechts().getHeight()/2+16);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(mitarbeiterGraphic.getBein_rechts(), null), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
            g2d.drawString(mitarbeiter.getName(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos()+15);
            g2d.drawImage(mitarbeiterGraphic.getKoerper(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
            tx = AffineTransform.getRotateInstance(mitarbeiterGraphic.getAnimator().getImg_trans_arm_links().getWinkel(), mitarbeiterGraphic.getArm_links().getWidth()/2, mitarbeiterGraphic.getArm_links().getHeight()/2);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(mitarbeiterGraphic.getArm_links(), null), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
            tx = AffineTransform.getRotateInstance(mitarbeiterGraphic.getAnimator().getImg_trans_bein_links().getWinkel(), mitarbeiterGraphic.getBein_links().getWidth()/2, mitarbeiterGraphic.getBein_links().getHeight()/2+16);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            g2d.drawImage(op.filter(mitarbeiterGraphic.getBein_links(), null), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts());
            //g2d.drawImage(op.filter(mitarbeiterGraphic.getArm_rechts(), null), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
//            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts());
//            g2d.drawImage(mitarbeiterGraphic.getBein_rechts(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
//            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
//            g2d.drawString(mitarbeiter.getName(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos()+10);
//            g2d.drawImage(mitarbeiterGraphic.getKoerper(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
//            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_links());
//            g2d.drawImage(mitarbeiterGraphic.getArm_links(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
            
//            g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_links());
//            g2d.drawImage(mitarbeiterGraphic.getBein_links(), mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), null);
        }
        else
        {
            
            g2d.setColor(mitarbeiterGraphic.markiert?Color.green:Color.blue);
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_rechts());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+31, 5, 16);
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_rechts());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+45, 6, 19);
            
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+12, mitarbeiterGraphic.getY_Pos()+28, 9, 18);
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_koerper());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+13, mitarbeiterGraphic.getY_Pos()+18, 8, 10);
            g2d.setColor(Color.red);
            g2d.drawRect(mitarbeiterGraphic.getX_Pos(), mitarbeiterGraphic.getY_Pos(), 32, 64);
            g2d.setColor(mitarbeiterGraphic.markiert?Color.green:Color.blue);
            g2d.drawString(FahrstuhlSimulator.konsole.getMitarbeiterID(mitarbeiter)+"", mitarbeiterGraphic.getX_Pos()+5, mitarbeiterGraphic.getY_Pos()+15);
            
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_arm_links());
            g2d.drawRect(mitarbeiterGraphic.getX_Pos()+14, mitarbeiterGraphic.getY_Pos()+31, 5, 16);
            //g2d.setTransform(mitarbeiterGraphic.getAnimator().getImg_trans_bein_links());
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

    private void drawEtageGraphic(Graphics2D g2d, EtageGraphic etageGraphic)
    {
        if(!X_RAY)
        {
            g2d.drawImage(etageGraphic.getImg(), 0, etageGraphic.getY_Pos(), null);
        }
        else
        {
            g2d.drawRect(0, etageGraphic.getY_Pos(), etageGraphic.getImg().getWidth(), etageGraphic.getImg().getHeight());
        }
    }
    
}
