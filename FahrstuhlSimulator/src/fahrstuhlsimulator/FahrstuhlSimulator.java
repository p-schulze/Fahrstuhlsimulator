package fahrstuhlsimulator;

import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.ImageLoader;
import fahrstuhlsimulator.Mitarbeiter.Koch;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
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
        
        Koch mitarbeiter1 = new Koch(1, "Sebastian");
        graphicDrawer.addMitarbeiterMoveListener(mitarbeiter1);
        
        new fahrstuhlsimulator.testumgebung.TestFenster();

        

        
        
    }
    
}
