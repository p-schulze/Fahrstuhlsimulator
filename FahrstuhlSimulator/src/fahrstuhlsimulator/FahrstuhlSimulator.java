package fahrstuhlsimulator;

import java.util.ArrayList;
import java.util.HashMap;

public class FahrstuhlSimulator {

    public static void main(String[] args){
        
        ImageLoader.loadImages();
        new fahrstuhlsimulator.testumgebung.TestFenster();
        new fahrstuhlsimulator.Konsole.Konsole().kStart();
        
        
    }
    
}
