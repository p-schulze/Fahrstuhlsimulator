/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Sebastian
 */
public class MouseController implements MouseMotionListener, MouseListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouseDragged on: "+e.getX()+" "+e.getY());
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MouseClicked on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("MousePressed on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("MouseReleased on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
