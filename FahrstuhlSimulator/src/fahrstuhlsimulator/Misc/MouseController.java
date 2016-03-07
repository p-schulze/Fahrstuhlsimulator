/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import fahrstuhlsimulator.testumgebung.RightClickMenu.RightClickMenu;
import fahrstuhlsimulator.testumgebung.TestFenster;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Sebastian
 */
public class MouseController implements MouseMotionListener, MouseListener {
    
    public AuswahlFeld auswahlFeld;
    public RightClickMenu rCM_panel;
    public MouseController()
    {
        auswahlFeld = new AuswahlFeld();
        rCM_panel = new RightClickMenu();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getX() >= auswahlFeld.x)
        {
            auswahlFeld.width = e.getX()-auswahlFeld.x;
        }
        if(e.getY() >= auswahlFeld.y)
        {
            auswahlFeld.height = e.getY()-auswahlFeld.y;
        }
        if(auswahlFeld.width >= 16 && auswahlFeld.height >= 16)
        {
            rCM_panel.visible = false;
            System.out.println("Selecting...");
        }
        System.out.println("mouseDragged on: "+e.getX()+" "+e.getY());
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 3)
        {
            rCM_panel.x = e.getX();
            rCM_panel.y = e.getY();
            rCM_panel.visible = true;
        }
        else if(e.getButton() == 1)
        {
            rCM_panel.visible = false;
        }
        //System.out.println("MouseClicked on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        auswahlFeld.x = e.getX();
        auswahlFeld.y = e.getY();
        System.out.println("MousePressed on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        auswahlFeld.x = 0;
        auswahlFeld.y = 0;
        auswahlFeld.width = 0;
        auswahlFeld.height = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
