package fahrstuhlsimulator;

import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.ImageLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class FahrstuhlSimulator {

    public static GraphicDrawer graphicDrawer;
    

    public static void main(String[] args){  
        graphicDrawer = new GraphicDrawer();
        Thread th = new Thread(graphicDrawer);
        th.start();
        ImageLoader.loadImages();

        new fahrstuhlsimulator.testumgebung.TestFenster();

        new fahrstuhlsimulator.Konsole.Konsole().kStart();    

        
        
    }
    
}
