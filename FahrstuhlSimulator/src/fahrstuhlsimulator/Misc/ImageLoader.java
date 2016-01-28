package fahrstuhlsimulator.Misc;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public abstract class ImageLoader {
    public static HashMap images = new HashMap();
    
    public static void loadImages()
    {
        try{
        FileReader fr = new FileReader("img/Image.reg");
        BufferedReader br = new BufferedReader(fr);

        String zeile;
            //System.out.println("Grafik wird Gelanden...");
        while( (zeile = br.readLine() ) != null )
        {
            //System.out.println(zeile);
            if(!zeile.equals("") && !zeile.startsWith("//"))
            {
                BufferedImage img = ImageIO.read(new File(zeile));
                images.put(zeile, img);
            }
            
            
        }
        //System.out.println("Fertig...");
        }catch(Exception ex){System.out.println(ex.toString());}
    }
    public static HashMap getImagesVomPfad(String pfad)
    {
        HashMap returnHashMap = new HashMap();
        ArrayList<String> images_keySet = new ArrayList(images.keySet());
        for(String image_key:images_keySet)
        {
            if(image_key.contains(pfad))
            {
                String[] image_keySplit = image_key.split("/");
                //System.out.println(image_keySplit[image_keySplit.length-1].split("\\.")[0]);
                returnHashMap.put(image_keySplit[image_keySplit.length-1].split("\\.")[0], images.get(image_key));
            }
        }
        return returnHashMap;
    }
    public static HashMap getImages()
    {
        return images;
    }
}
