/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.testumgebung.RightClickMenu;

/**
 *
 * @author Sebastian
 */
public class RCM_Button {
    public int relative_x = 0;
    public int relative_y = 0;
    public int width = 95;
    public int height = 20;
    public String text = "";
    
    public boolean visible = false;
    
    public RCM_Button(int relative_x, int relative_y, String text)
    {
        this.relative_x = relative_x;
        this.relative_y = relative_y;
        this.text = text;
    }
    
}
