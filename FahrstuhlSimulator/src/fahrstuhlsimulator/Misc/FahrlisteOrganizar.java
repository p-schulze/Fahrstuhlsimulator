/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class FahrlisteOrganizar {
    
    public static ArrayList<Integer> FahrlisteOrdnen(ArrayList<Integer> fahrliste)
    {
        for(int i = 0; i<fahrliste.size(); i++)
        {
            int tempE = fahrliste.get(i);
            while(fahrliste.indexOf(tempE) != fahrliste.lastIndexOf(tempE))
            {
                fahrliste.remove(fahrliste.lastIndexOf(tempE));
            }
        }
        
        return fahrliste;
        
    }
    
    public static void main(String[] args)
    {  
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(4);
        array.add(4);
        array.add(4);array.add(4);
        
        
        array.add(1);
        array.add(1);
        array.add(6);
        System.out.println(array);
        System.out.println(FahrlisteOrganizar.FahrlisteOrdnen(array));
    }
    
}
