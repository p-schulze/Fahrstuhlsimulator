package fahrstuhlsimulator.Konsole;

import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statistik implements Runnable{
    /**
     * Erstellt neues Objekt
     */
    public Statistik(){
        
    }
    
    //public static void main(String[] args) throws InterruptedException {
      //  Statistik konst = new Statistik();
        //(new Thread(konst)).start();
     
    //}

    @Override
    /**
     * Rechnet den Durchschnitt aus in 60 Sekunden, wobei auf die Länge der Liste eingegangen wird und somit Statistiken über die Anzahl von etwas erstellt werden können.
     */
    public void run() 
    {
        ArrayList<Integer> teilnehmer= new ArrayList<Integer>();
        int laenge;
        int durchschnitt;
        while(true){
            laenge=0;
            for(int i=0;i<=5;i++){
                teilnehmer.clear();
                for(int r=0;r<=(int)(Math.random() * 10);r++){
                    teilnehmer.add(2);
                }
                laenge = laenge + teilnehmer.size();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            //System.out.println(sizel1);
            durchschnitt= laenge/6;
            System.out.println("***");
            System.out.println(durchschnitt);
            System.out.println("***");
        }
    }
    
}
