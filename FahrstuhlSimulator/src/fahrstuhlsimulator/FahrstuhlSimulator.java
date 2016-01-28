package fahrstuhlsimulator;

import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.ImageLoader;
import java.util.ArrayList;
import java.util.HashMap;

public class FahrstuhlSimulator {
<<<<<<< Updated upstream
    public static GraphicDrawer graphicDrawer;
    

    public static void main(String[] args){  
        graphicDrawer = new GraphicDrawer();
        Thread th = new Thread(graphicDrawer);
        th.start();
        ImageLoader.loadImages();
=======
    
    public static void main(String[] args){
        
        ImageLoader.loadImages();
       
        new fahrstuhlsimulator.testumgebung.TestFenster();
>>>>>>> Stashed changes
        new fahrstuhlsimulator.Konsole.Konsole().kStart();
        new fahrstuhlsimulator.testumgebung.TestFenster();
        
        
        
    }
    
}
