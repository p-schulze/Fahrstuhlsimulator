/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sebastian
 */
public abstract class RandomMitarbeiterGenerator {
    
    private static int koerperImgID = 0;
    private static int armeImgID = 0;
    private static int beineImgID = 0;
    
    public static void makeRandomMitarbeiter()
    {
        koerperImgID = randInt(0,3);
        armeImgID = randInt(0,3);
        beineImgID = randInt(0,3);
        System.out.println(koerperImgID+ " "+ armeImgID+ " "+beineImgID);
    }
    
    public static int getKoerperImgID()
    {
        return koerperImgID;
    }
    public static int getArmeImgID()
    {
        return armeImgID;
    }
    public static int getBeineImgID()
    {
        return beineImgID;
    }
    
    
    private static int randInt(int min, int max) {

    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
}
