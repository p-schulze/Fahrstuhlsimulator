package fahrstuhlsimulator;

import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.ImageLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class FahrstuhlSimulator {

    public static GraphicDrawer graphicDrawer;
    public static Thread graphicDrawer_th;
    

    public static void main(String[] args){  
        graphicDrawer = new GraphicDrawer();
        graphicDrawer_th = new Thread(graphicDrawer);
        graphicDrawer_th.start();
        ImageLoader.loadImages();

        new fahrstuhlsimulator.Konsole.Konsole().kStart();    
        
        new fahrstuhlsimulator.testumgebung.TestFenster();

        

        
        
    }
    
}
