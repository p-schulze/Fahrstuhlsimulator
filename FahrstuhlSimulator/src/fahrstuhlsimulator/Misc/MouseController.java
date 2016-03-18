/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import fahrstuhlsimulator.FahrstuhlSimulator;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
import fahrstuhlsimulator.testumgebung.RightClickMenu.RightClickMenu;
import fahrstuhlsimulator.testumgebung.TestFenster;
import fahrstuhlsimulator.testumgebung.TestPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class MouseController implements MouseMotionListener, MouseListener {
    
    public AuswahlFeld auswahlFeld;
    public RightClickMenu rCM_panel;
    
    private ArrayList<Mitarbeiter> ausgewaehlteMitarbeiter = new ArrayList();
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
        //if(auswahlFeld.width >= 16 && auswahlFeld.height >= 16)
        {
            TestPanel.rightClickMenu.setVisible(false);
            for(Mitarbeiter mitarbeiter:FahrstuhlSimulator.konsole.getMitarbeiterListe())
            {
                //if (mitarbeiter.getGraphic().getX_Pos() <= auswahlFeld.x && mitarbeiter.getGraphic().getX_Pos()+mitarbeiter.getGraphic().getKoerper().getWidth() >= auswahlFeld.x+auswahlFeld.width && mitarbeiter.getGraphic().getY_Pos() <= auswahlFeld.y && mitarbeiter.getGraphic().getY_Pos()+mitarbeiter.getGraphic().getKoerper().getHeight() >= auswahlFeld.y+auswahlFeld.height)
                //if (mitarbeiter.getGraphic().getX_Pos() <= e.getX() && mitarbeiter.getGraphic().getX_Pos()+mitarbeiter.getGraphic().getKoerper().getWidth() >= e.getX() && mitarbeiter.getGraphic().getY_Pos() <= e.getY() && mitarbeiter.getGraphic().getY_Pos()+mitarbeiter.getGraphic().getKoerper().getHeight() >= e.getY()) 
                if (auswahlFeld.x <= mitarbeiter.getGraphic().getX_Pos()+mitarbeiter.getGraphic().getKoerper().getWidth() && auswahlFeld.x+auswahlFeld.width >= mitarbeiter.getGraphic().getX_Pos() && auswahlFeld.y <= mitarbeiter.getGraphic().getY_Pos()+mitarbeiter.getGraphic().getKoerper().getHeight()&& auswahlFeld.y+auswahlFeld.height >= mitarbeiter.getGraphic().getY_Pos())
                {
                    if(!getAusgewaehlteMitarbeiter().contains(mitarbeiter))
                    {
                        getAusgewaehlteMitarbeiter().add(mitarbeiter);
                    }
                }
                else
                {
                    if(getAusgewaehlteMitarbeiter().contains(mitarbeiter))
                    {
                        getAusgewaehlteMitarbeiter().remove(mitarbeiter);
                    }
                }
            }
            
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 3)
        {
            TestPanel.rightClickMenu.setLocation(e.getX(), e.getY());
            TestPanel.rightClickMenu.setVisible(true);
        }
        else if(e.getButton() == 1)
        {
            boolean mitarbeiterAusgewählt = false;
            for(Mitarbeiter mitarbeiter:FahrstuhlSimulator.konsole.getMitarbeiterListe())
            {
               if (mitarbeiter.getGraphic().getX_Pos() <= e.getX() && mitarbeiter.getGraphic().getX_Pos()+mitarbeiter.getGraphic().getKoerper().getWidth() >= e.getX() && mitarbeiter.getGraphic().getY_Pos() <= e.getY() && mitarbeiter.getGraphic().getY_Pos()+mitarbeiter.getGraphic().getKoerper().getHeight() >= e.getY()) 
                {
                    getAusgewaehlteMitarbeiter().clear();
                    getAusgewaehlteMitarbeiter().add(mitarbeiter);
                    mitarbeiterAusgewählt = true;
                    break;
                }
            }
            if(!mitarbeiterAusgewählt)
            {
                getAusgewaehlteMitarbeiter().clear();
            }
            TestPanel.rightClickMenu.setVisible(false);
        }
        //System.out.println("MouseClicked on: "+e.getX()+" "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        auswahlFeld.x = e.getX();
        auswahlFeld.y = e.getY();
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

    /**
     * @return the ausgewaehlteMitarbeiter
     */
    public ArrayList<Mitarbeiter> getAusgewaehlteMitarbeiter() {
        return ausgewaehlteMitarbeiter;
    }
    
}
