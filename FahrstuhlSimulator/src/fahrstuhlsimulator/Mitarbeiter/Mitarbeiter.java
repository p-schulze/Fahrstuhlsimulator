/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter;

import fahrstuhlsimulator.FahrstuhlSimulator;
import java.util.ArrayList;
import fahrstuhlsimulator.Gebaeude.Etage;
import fahrstuhlsimulator.Misc.MitarbeiterMoveListener;
import fahrstuhlsimulator.Misc.RandomMitarbeiterGenerator;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;

/**
 *
 * @author becksusanna
 */
public class Mitarbeiter{
    private String name;
    private int aktuelleEtage;
    private MitarbeiterGraphic graphic;
    private ArrayList<String> erlaubteEtagen;
    
    protected Mitarbeiter(String name) {
        this.name=name;
        //temp
            RandomMitarbeiterGenerator.makeRandomMitarbeiter();
        graphic = new MitarbeiterGraphic(RandomMitarbeiterGenerator.getArmeImgID(),RandomMitarbeiterGenerator.getBeineImgID(),RandomMitarbeiterGenerator.getKoerperImgID(),1-0,1,false);
        //this.erlaubteEtagen=erlaubteEtagen;
        //this.aktuelleEtage=EG;
    }
    
    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name=name;
    }
    
    protected int getAktEtage() {
        return aktuelleEtage;
    }
    protected void setAktEtage(int aktEtage) {
        this.aktuelleEtage=aktEtage;
    }
    
    public MitarbeiterGraphic getGraphic()
    {
        return graphic;
    }
    
    public ArrayList<String> getErlaubteEtagen() {
        return erlaubteEtagen;
    }
    protected void setErlaubteEtagen(ArrayList<String> nErlaubteEtagen) {
        this.erlaubteEtagen=nErlaubteEtagen;
    }
    protected void erhoeheEtage()
    {
        aktuelleEtage++;
    }
    protected void verringereEtage()
    {
        aktuelleEtage--;
    }
    
//    public void openFahrstuhl()
//    {
//        if(!TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open){
//            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).oeffneTuer();
//            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open = true;
//            schreibeAktion("open door: " + commandArray[1]);
//            }else{
//                schreibeAktion("door: open");
//            }
//    }
    
    public void move(int pix)
    {
        graphic.moveDistanceWithAnimation(pix);
    }
    public void umdrehen()
    {
        graphic.umdrehen();
    }
    public void teleport(int etage)
    {
        graphic.setEtage(etage);
    }
    
    public void goTo(int etage)
    {
        callFahrstuhl(etage);
    }
    
    private void callFahrstuhl(int etage)
    {
        FahrstuhlSimulator.konsole.getFahrstuhlListe().get(0).fahren(etage);
        
    }
}
        
    /**
     * if(commandArray[0].equalsIgnoreCase("Person")){
            //1. Command
            schreibeAktion("Person wird erzeugt");            
        }
        else if(commandArray[0].equalsIgnoreCase("open"))
        {
            if(!TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open){
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).oeffneTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open = true;
            schreibeAktion("open door: " + commandArray[1]);
            }else{
                schreibeAktion("door: open");
            }
        }  
        else if(commandArray[0].equalsIgnoreCase("close"))
        {
            if(TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open){ 
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).schliesseTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).open = false;
            schreibeAktion("close door: " + commandArray[1]);}
            else{
                schreibeAktion("door: close");
            }
        }
        else if(commandArray[0].equalsIgnoreCase("move"))
        {
            if(Integer.parseInt(commandArray[1]) < 0){
            TestPanel.mitarbeiterGraphics.get(0).umdrehen();
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(Integer.parseInt(commandArray[1]) * (-1));
            }else {
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(Integer.parseInt(commandArray[1]));
            }   
            schreibeAktion("move: " + commandArray[1]);
        } else if(commandArray[0].equalsIgnoreCase("etage"))
        {
            TestPanel.mitarbeiterGraphics.get(0).setEtage(Integer.parseInt(commandArray[1]));
            TestFenster.panel.repaint();
            //TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(0);
            schreibeAktion("etage: " + commandArray[1]);
        } else if(commandArray[0].equalsIgnoreCase("goto"))
        {
            if(TestPanel.mitarbeiterGraphics.get(0).getX_Pos() <= 368){
                if(TestPanel.mitarbeiterGraphics.get(0).getFlipped() == false){
                TestPanel.mitarbeiterGraphics.get(0).umdrehen();
                }
                TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).getX_Pos() - TestPanel.mitarbeiterGraphics.get(0).getX_Pos());
            } else {
                 if(TestPanel.mitarbeiterGraphics.get(0).getFlipped() == true){
                TestPanel.mitarbeiterGraphics.get(0).umdrehen();
                }
                TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(TestPanel.mitarbeiterGraphics.get(0).getX_Pos() - TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).getX_Pos() );
            }
          /*  TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).oeffneTuer();
            TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).schliesseTuer();
            TestPanel.fahrstuhlGraphics.get(Integer.parseInt(commandArray[1])).oeffneTuer();
            TestPanel.mitarbeiterGraphics.get(0).setPosition(368, Integer.parseInt(commandArray[1]));
            TestPanel.mitarbeiterGraphics.get(0).moveDistanceWithAnimation(0);
            TestPanel.fahrstuhlGraphics.get(TestPanel.mitarbeiterGraphics.get(0).getEtage()).schliesseTuer(); */
           
