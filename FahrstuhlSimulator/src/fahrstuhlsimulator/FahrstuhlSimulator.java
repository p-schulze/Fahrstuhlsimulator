package fahrstuhlsimulator;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Fahrstuhl;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.FahrstuhlBrain;
import fahrstuhlsimulator.Konsole.Konsole;
import fahrstuhlsimulator.Misc.GraphicDrawer;
import fahrstuhlsimulator.Misc.ImageLoader;
import fahrstuhlsimulator.Misc.RandomMitarbeiterGenerator;
import fahrstuhlsimulator.Mitarbeiter.Koch;
import fahrstuhlsimulator.Mitarbeiter.Mitarbeiter;
import java.util.ArrayList;
import java.util.HashMap;

public class FahrstuhlSimulator {

    public static GraphicDrawer graphicDrawer;
    public static Thread graphicDrawer_th;
    public static Konsole konsole;
    

    public static void main(String[] args){  
        graphicDrawer = new GraphicDrawer();
        graphicDrawer_th = new Thread(graphicDrawer);
        graphicDrawer_th.start();
        ImageLoader.loadImages();

        //konsole = new fahrstuhlsimulator.Konsole.Konsole();
        //konsole.kStart();
        
      //  new fahrstuhlsimulator.testumgebung.TestFenster();

        FahrstuhlBrain brain = new FahrstuhlBrain();
        Fahrstuhl fahrstuhl = new Fahrstuhl(3);
        
        fahrstuhl.etage = 10;
        fahrstuhl.fahrliste.add(8);
        fahrstuhl.fahrliste.add(6);
        fahrstuhl.fahrliste.add(7);
        fahrstuhl.fahrliste.add(9);
        
        brain.sortiertEinfuegen(fahrstuhl, 2);
       
       
        
        
        
    }
    
}
