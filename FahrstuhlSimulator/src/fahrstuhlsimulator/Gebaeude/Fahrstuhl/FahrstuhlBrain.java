/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Gebaeude.Fahrstuhl;

import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Fahrstuhl;
import java.util.ArrayList;

/**
 *
 * @author pascalschulze
 */
public class FahrstuhlBrain {
    
    public Fahrstuhl welcherFahrstuhl(ArrayList<Fahrstuhl> fahrstuehle, int ziel){
        
        Fahrstuhl schnellsterFahrstuhl = fahrstuehle.get(0);
        if (fahrstuehle.get(0).fahrliste.size() > fahrstuehle.get(1).fahrliste.size()){
            schnellsterFahrstuhl = fahrstuehle.get(1);
        } else if (fahrstuehle.get(0).fahrliste.size() > fahrstuehle.get(2).fahrliste.size()){
            schnellsterFahrstuhl = fahrstuehle.get(2);
        }
        
        return schnellsterFahrstuhl;
    }
    
    
    public void sortiertEinfuegen(Fahrstuhl fahrstuhl, int ziel){
        
        //System.out.println("Fahrliste: "+fahrstuhl.fahrliste);
        //System.out.println("Ziel: "+ziel);
        
        boolean eingetragen = false;
        
        if(!fahrstuhl.fahrliste.isEmpty()){
            if(fahrstuhl.getEtage()-fahrstuhl.fahrliste.get(0) < 0){
                //Fahrstuhl fährt nach oben
            
                if(fahrstuhl.getEtage() < ziel){
                    //System.out.println("Fahrstuhl fährt nach oben und ist unter dem Ziel");
                    
                    for(int a = 0; a < fahrstuhl.fahrliste.size(); a++){
                    
                        if(fahrstuhl.fahrliste.get(a) > ziel){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        } if (a >= 1 && fahrstuhl.fahrliste.get(a) < fahrstuhl.fahrliste.get(a-1)){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        }
                        
                        
                    }
                    
                    if(fahrstuhl.fahrliste.get(fahrstuhl.fahrliste.size()-1) < ziel && !eingetragen){
                        fahrstuhl.fahrliste.add(ziel);
                    }
                    
                    
                } else{
                    //System.out.println("Fahrstuhl fährt nach oben und ist über dem Ziel");
                    
                    for(int a = 0; a < fahrstuhl.fahrliste.size(); a++){
                        if(fahrstuhl.fahrliste.get(a) < ziel){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        }
                    }
                    
                    if (!eingetragen){
                        fahrstuhl.fahrliste.add(ziel);
                    }
                }
            
            } else {
                //Fahrstuhl fährt nach unten
            
                if(fahrstuhl.getEtage() < ziel){
                   
                    //System.out.println("Fahrstuhl fährt nach unten und ist unter dem Ziel");
                    
                    for(int a = 0; a < fahrstuhl.fahrliste.size(); a++){
                        if(fahrstuhl.fahrliste.get(a) > ziel){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        }
                    }
                    
                    if (!eingetragen){
                        fahrstuhl.fahrliste.add(ziel);
                    }
                    
                    
                    
                } else{
                   
                    //System.out.println("Fahrstuhl fährt nach unten und ist über dem Ziel");
                      for(int a = 0; a < fahrstuhl.fahrliste.size(); a++){
                    
                        if(fahrstuhl.fahrliste.get(a) < ziel){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        } if (a >= 1 && fahrstuhl.fahrliste.get(a) > fahrstuhl.fahrliste.get(a-1)){
                            fahrstuhl.fahrliste.add(a, ziel);
                            eingetragen = true;
                            break;
                        }
                        
                        
                    }
                    
                    if(fahrstuhl.fahrliste.get(fahrstuhl.fahrliste.size()-1) > ziel && !eingetragen){
                        fahrstuhl.fahrliste.add(ziel);
                    }
                    
                    
                }
            }
        
       
        } else{
            
           fahrstuhl.fahrliste.add(ziel);
        }
        
        //System.out.println("Neue Fahrliste: "+fahrstuhl.fahrliste);
    
}

}