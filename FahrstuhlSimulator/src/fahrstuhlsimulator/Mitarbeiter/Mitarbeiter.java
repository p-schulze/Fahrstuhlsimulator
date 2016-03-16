/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Mitarbeiter;

import fahrstuhlsimulator.FahrstuhlSimulator;
import java.util.ArrayList;
import fahrstuhlsimulator.Gebaeude.Etage;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Fahrstuhl;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;
import fahrstuhlsimulator.Misc.FahrstuhlOpenListener;
import fahrstuhlsimulator.Misc.MitarbeiterMoveListener;
import fahrstuhlsimulator.Misc.RandomMitarbeiterGenerator;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;

/**
 *
 * @author becksusanna
 */
public class Mitarbeiter implements MitarbeiterMoveListener, FahrstuhlOpenListener{
    private String name;
    private int aktuelleEtage;
    public MitarbeiterGraphic graphic;
    private ArrayList<String> erlaubteEtagen;
    public int zieletage;
    
    private boolean wartetAufFahrstuhl = false;
    private boolean ruftFahrstuhl = false;
    private Fahrstuhl zubenutzenderFahrstuhl;
    
    protected Mitarbeiter(String name) {
        this.name=name;
        //temp
            RandomMitarbeiterGenerator.makeRandomMitarbeiter();
        graphic = new MitarbeiterGraphic(RandomMitarbeiterGenerator.getArmeImgID(),RandomMitarbeiterGenerator.getBeineImgID(),RandomMitarbeiterGenerator.getKoerperImgID(),1-0,1,false);
        //this.erlaubteEtagen=erlaubteEtagen;
        this.aktuelleEtage=1;
        FahrstuhlSimulator.graphicDrawer.addMitarbeiterMoveListener(this);
        FahrstuhlSimulator.graphicDrawer.addFahrstuhlOpenListenerList(this);
    }
    
    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name=name;
    }
    
    public int getAktEtage() {
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
        this.setAktEtage(etage);
    }
    
    public void goTo(int etage)
    {
        zieletage = etage;
        if(!(this.aktuelleEtage == etage))
        {
            ruftFahrstuhl = true;
            callFahrstuhl(etage);
        }
    }
    
    private void callFahrstuhl(int etage)
    {
        zubenutzenderFahrstuhl = FahrstuhlSimulator.konsole.fBrain.welcherFahrstuhl(FahrstuhlSimulator.konsole.getFahrstuhlListe(), etage);
        FahrstuhlGraphic fahrstuhlG = zubenutzenderFahrstuhl.getFahrstuhlGrafik().get(this.aktuelleEtage);
        
        int dis = 0;
        if(this.graphic.getX_Pos() > fahrstuhlG.getX_Pos())
        {  
            if(this.graphic.getFlipped())
            {
                this.graphic.umdrehen();
            }
            dis = graphic.getX_Pos() - fahrstuhlG.getX_Pos();
        }else if(this.graphic.getX_Pos() < fahrstuhlG.getX_Pos())
        {
            if(!this.graphic.getFlipped())
            {
                this.graphic.umdrehen();
            }
            dis = fahrstuhlG.getX_Pos() - graphic.getX_Pos();
        }
        
        this.graphic.moveDistanceWithAnimation(dis);
        //FahrstuhlSimulator.konsole.getFahrstuhlListe().get(0).fahren(etage);
        
    }

    @Override
    public void onPosition(MitarbeiterGraphic mG)
    {
        if(ruftFahrstuhl)
        {
            if(mG == this.graphic)
            {
                ruftFahrstuhl = false;
                wartetAufFahrstuhl = true;
                FahrstuhlSimulator.konsole.analyze("call "+FahrstuhlSimulator.konsole.getFahrstuhlID(zubenutzenderFahrstuhl) +" "+FahrstuhlSimulator.konsole.getMitarbeiterID(this));
            }
        }
    }

    @Override
    public void opened(FahrstuhlGraphic fG) 
    {
        if(wartetAufFahrstuhl && fG.getEtage() == this.graphic.getEtage())
        {
            wartetAufFahrstuhl = false;
            FahrstuhlSimulator.konsole.analyze("einsteigen "+FahrstuhlSimulator.konsole.getFahrstuhlID(zubenutzenderFahrstuhl) +" " +FahrstuhlSimulator.konsole.getMitarbeiterID(this) +" "+zieletage);
            
        }
    }

    @Override
    public void closed(FahrstuhlGraphic fG) 
    {
        
    }

    /**
     * @return the vis
     */
    
}
