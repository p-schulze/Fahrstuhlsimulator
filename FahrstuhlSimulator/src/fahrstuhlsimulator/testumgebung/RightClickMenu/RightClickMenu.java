/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung.RightClickMenu;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian
 */
public class RightClickMenu {
    
    public int x = 0;
    public int y = 0;
    public int width = 100;
    public int height = 200;
    public boolean visible = false;
    
    public RCM_Button btn;
    
    public RightClickMenu()
    {
        btn = new RCM_Button(2,10,"Move");
        btn.visible = true;
    }
    
}
