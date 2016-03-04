/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import fahrstuhlsimulator.FahrstuhlSimulator;
import fahrstuhlsimulator.Gebaeude.Fahrstuhl.Graphic.FahrstuhlGraphic;
import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.testumgebung.TestFenster;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class GraphicDrawer implements Runnable {
    
    private boolean pausiert = false;
    public static final int TIME_FOR_A_FRAME = 40;
    
    private static long durationForFrame = 0;
    
    private static ArrayList<ArrayList<String>> taskList_task = new ArrayList();
    private static ArrayList<ArrayList<Object>> taskList_object = new ArrayList();
    
    private ArrayList<Object> mitarbeiterMoveListenerList = new ArrayList();
    private ArrayList<Object> fahrstuhlOpenListenerList = new ArrayList();
    
    public GraphicDrawer()
    {
        
    }
    
    public void addTask(ArrayList<String> tasks, ArrayList<Object> objects)
    {
        taskList_task.add(tasks);
        taskList_object.add(objects);
        
    }
    
    public boolean isPausiert()
    {
        return pausiert;
    }
    public void resumeThread()
    {
        pausiert = false;
        System.out.println("GraphicDrawer_Thread: wieder aufgenommen");
        FahrstuhlSimulator.graphicDrawer_th.resume();
    }
    
    @Override
    public void run()
    {
        long systemTime =  System.currentTimeMillis();
        boolean zeichnen = false;
        try{
            for(int i = 0; i < taskList_task.size();i++)
            {
                zeichnen = true;
                String temp_taskList_task = taskList_task.get(i).get(0);
                Object temp_taskList_object = taskList_object.get(i).get(0);

                String[] taskList_taskSplit = temp_taskList_task.split("\\.");
                    if(taskList_taskSplit[0].equalsIgnoreCase("Mitarbeiter"))
                    {
                        if(taskList_taskSplit[1].equalsIgnoreCase("hebArm"))
                        {
                            if(taskList_taskSplit[2].split(":")[0].equalsIgnoreCase("rechts"))
                                //<editor-fold defaultstate="collapsed" desc="Heb Arm Rechts">
                            {
                                
                                MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                                //split("[(),]");
                                String[] parameter = taskList_taskSplit[2].split(":")[1].split("[(),]");
                                int speed = 0;
                                double ziel_winkel = 0;
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    //System.out.println("HebArm: Y: "+ mitarbeiterG.getY_Pos());
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }else if(parameter[i_parameter].equalsIgnoreCase("winkel"))
                                    {
                                        ziel_winkel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }
                                if(!(ziel_winkel <0?(mitarbeiterG.getAnimator().getImg_trans_arm_rechts().checkRevertWinkelGleichZielWinkel(Math.toRadians(ziel_winkel))):(mitarbeiterG.getAnimator().getImg_trans_arm_rechts().checkWinkelGleichZielWinkel(Math.toRadians(ziel_winkel)))))
                                {
                                    
                                    mitarbeiterG.getAnimator().setArmRechtsRotation(100/speed, mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                                }
                                else{
                                    
                                    deleteTask(i);
                                }
                            }
                            //</editor-fold>
                            else if(taskList_taskSplit[2].split(":")[0].equalsIgnoreCase("links"))
                                //<editor-fold defaultstate="collapsed" desc="Heb Arm Links">
                            {
                                
                                MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                                //split("[(),]");
                                String[] parameter = taskList_taskSplit[2].split(":")[1].split("[(),]");
                                int speed = 0;
                                double ziel_winkel = 0;
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }else if(parameter[i_parameter].equalsIgnoreCase("winkel"))
                                    {
                                        ziel_winkel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }
                                if(!(ziel_winkel <0?(mitarbeiterG.getAnimator().getImg_trans_arm_links().checkRevertWinkelGleichZielWinkel(Math.toRadians(ziel_winkel))):(mitarbeiterG.getAnimator().getImg_trans_arm_links().checkWinkelGleichZielWinkel(Math.toRadians(ziel_winkel)))))
                                {
                                    
                                    mitarbeiterG.getAnimator().setArmLinksRotation(100/speed, mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                                }
                                else{
                                    
                                    deleteTask(i);
                                }
                            }
                            //</editor-fold>
                        }
                        else if(taskList_taskSplit[1].equalsIgnoreCase("hebFuss"))
                        {
                            if(taskList_taskSplit[2].split(":")[0].equalsIgnoreCase("rechts"))
                                //<editor-fold defaultstate="collapsed" desc="Heb Fuss Rechts">
                            {
                                
                                MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                                //split("[(),]");
                                String[] parameter = taskList_taskSplit[2].split(":")[1].split("[(),]");
                                int speed = 0;
                                double ziel_winkel = 0;
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }else if(parameter[i_parameter].equalsIgnoreCase("winkel"))
                                    {
                                        ziel_winkel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }
                                if(!(ziel_winkel <0?(mitarbeiterG.getAnimator().getImg_trans_bein_rechts().checkRevertWinkelGleichZielWinkel(Math.toRadians(ziel_winkel))):(mitarbeiterG.getAnimator().getImg_trans_bein_rechts().checkWinkelGleichZielWinkel(Math.toRadians(ziel_winkel)))))
                                {
                                    
                                    mitarbeiterG.getAnimator().setBeinRechtsRotation(100/speed, mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                                }
                                else{
                                    
                                    deleteTask(i);
                                }
                            }
                            //</editor-fold>
                            else if(taskList_taskSplit[2].split(":")[0].equalsIgnoreCase("links"))
                                //<editor-fold defaultstate="collapsed" desc="Heb Fuss Links">
                            {
                                
                                MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                                //split("[(),]");
                                String[] parameter = taskList_taskSplit[2].split(":")[1].split("[(),]");
                                int speed = 0;
                                double ziel_winkel = 0;
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }else if(parameter[i_parameter].equalsIgnoreCase("winkel"))
                                    {
                                        ziel_winkel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }
                                if(!(ziel_winkel <0?(mitarbeiterG.getAnimator().getImg_trans_bein_links().checkRevertWinkelGleichZielWinkel(Math.toRadians(ziel_winkel))):(mitarbeiterG.getAnimator().getImg_trans_bein_links().checkWinkelGleichZielWinkel(Math.toRadians(ziel_winkel)))))
                                {
                                    
                                    mitarbeiterG.getAnimator().setBeinLinksRotation(100/speed, mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                                }
                                else{
                                    
                                    deleteTask(i);
                                }
                            }
//</editor-fold>
                        }
                        else if(taskList_taskSplit[1].split(":")[0].equalsIgnoreCase("move"))
                        {
                            //<editor-fold defaultstate="collapsed" desc="Move">
                            MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                            
                            String[] parameter = taskList_taskSplit[1].split(":")[1].split("[(),]");
                            int speed = 0;
                            int ziel = mitarbeiterG.getX_Pos();
                            for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                            {
                                //System.out.println(parameter[i_parameter]);
                                if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                {
                                    speed = Integer.parseInt(parameter[i_parameter+1]);
                                }
                                else if(parameter[i_parameter].equalsIgnoreCase("ziel"))
                                {
                                    ziel = Integer.parseInt(parameter[i_parameter+1]);
                                }
                                
                            }
                            
                            if(!(mitarbeiterG.checkPositionGleichZielPosition(ziel)))
                            {
                                mitarbeiterG.addToX(mitarbeiterG.getFlipped()?5:-5);
                            }
                            else{
                                
                                deleteTask(i);
                                sendOnPositionEvent(mitarbeiterG);
                            }
//</editor-fold>
                        }
                        else if(taskList_taskSplit[1].split(":")[0].equalsIgnoreCase("umdrehen"))
                        {
                            MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object;
                            mitarbeiterG.getAnimator().setArmLinksFlip(mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                            mitarbeiterG.getAnimator().setArmRechtsFlip(mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                            mitarbeiterG.getAnimator().setBeinLinksFlip(mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                            mitarbeiterG.getAnimator().setBeinRechtsFlip(mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                            mitarbeiterG.getAnimator().setKoerperFlip(mitarbeiterG.getX_Pos(), mitarbeiterG.getY_Pos());
                            
                            mitarbeiterG.setFlipped(!mitarbeiterG.getFlipped());
                            deleteTask(i);
                        }
                    }
                    else if(taskList_taskSplit[0].equalsIgnoreCase("Fahrstuhl"))
                    {
                        if(taskList_taskSplit[1].equalsIgnoreCase("tuer"))
                        {
                            if(taskList_taskSplit[2].equalsIgnoreCase("links"))
                            {
                                boolean tempOeffnen = true;
                                if(taskList_taskSplit[3].split(":")[0].equalsIgnoreCase("schliessen"))
                                {
                                    tempOeffnen = false;
                                }    
                                FahrstuhlGraphic fahrstuhlG = (FahrstuhlGraphic) temp_taskList_object;

                                String[] parameter = taskList_taskSplit[3].split(":")[1].split("[(),]");
                                int speed = 0;
                                int ziel = fahrstuhlG.getX_Pos();
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    //System.out.println(parameter[i_parameter]);
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                    else if(parameter[i_parameter].equalsIgnoreCase("ziel"))
                                    {
                                        ziel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }

                                if(!(fahrstuhlG.checkTuerLinksPositionGleichZielPosition(ziel, tempOeffnen)))
                                {
                                    fahrstuhlG.addToX_tuerLinks(tempOeffnen?-1:1);
                                }
                                else{

                                    deleteTask(i);
                                    //sendOnPositionEvent(fahrstuhlG);
                                }
                                    
                                
                            }
                            else if(taskList_taskSplit[2].equalsIgnoreCase("rechts"))
                            {
                                boolean tempOeffnen = true;
                                if(taskList_taskSplit[3].split(":")[0].equalsIgnoreCase("schliessen"))
                                {
                                    tempOeffnen = false;
                                }
                                FahrstuhlGraphic fahrstuhlG = (FahrstuhlGraphic) temp_taskList_object;

                                String[] parameter = taskList_taskSplit[3].split(":")[1].split("[(),]");
                                int speed = 0;
                                int ziel = fahrstuhlG.getX_Pos();
                                for(int i_parameter = 0; i_parameter < parameter.length; i_parameter++)
                                {
                                    //System.out.println(parameter[i_parameter]);
                                    if(parameter[i_parameter].equalsIgnoreCase("speed"))
                                    {
                                        speed = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                    else if(parameter[i_parameter].equalsIgnoreCase("ziel"))
                                    {
                                        ziel = Integer.parseInt(parameter[i_parameter+1]);
                                    }
                                }
                                if(!(fahrstuhlG.checkTuerRechtsPositionGleichZielPosition(ziel, tempOeffnen)))
                                {
                                    fahrstuhlG.addToX_tuerRechts(tempOeffnen?1:-1);
                                }
                                else{

                                    deleteTask(i);
                                    if(tempOeffnen) {sendOpenedEvent(fahrstuhlG);} else {sendClosedEvent(fahrstuhlG);}
                                }
                            }
                        }
                    }
            }
        }catch(IndexOutOfBoundsException ex) {
            //System.out.println("Keine Aufgaben vorhanden");
        }
        //System.out.println("GraphicDrawer: Gestartet");
        try {if(zeichnen){TestFenster.panel.repaint();}else{System.out.println("GraphicDrawer_Thread: Pausiert");pausiert = true;FahrstuhlSimulator.graphicDrawer_th.suspend();}} catch(NullPointerException e) {/**System.out.println("Panel ist nochnicht geladen");**/}
        try {Thread.sleep(TIME_FOR_A_FRAME);} catch (InterruptedException ex) {}
        durationForFrame = System.currentTimeMillis() - systemTime;
        
        this.run();
    }
    
    public static long getDurrationForFrame()
    {
        return durationForFrame;
    }
    
    private void deleteTask(int i)
    {
        if((taskList_task.get(i).size()==1))
        {
            taskList_task.remove(i);
            taskList_object.remove(i);
        }
        else
        {
            taskList_task.get(i).remove(0);
            taskList_object.get(i).remove(0);
        }
    }
    
    public void addMitarbeiterMoveListener(Object e)
    {
        mitarbeiterMoveListenerList.add(e);
    }
    public void removeMitarbeiterMoveListener(Object e)
    {
        mitarbeiterMoveListenerList.remove(e);
    }
    public void sendOnPositionEvent(MitarbeiterGraphic mG)
    {
        for(Object mitarbeiterMoveListener:mitarbeiterMoveListenerList)
        {
            ((MitarbeiterMoveListener) mitarbeiterMoveListener).onPosition(mG);
        }
    }
    
    public void addFahrstuhlOpenListenerList(Object e)
    {
        System.out.println("1");
        fahrstuhlOpenListenerList.add(e);
    }
    public void removeFahrstuhlOpenListenerList(Object e)
    {
        fahrstuhlOpenListenerList.remove(e);
    }
    public void sendOpenedEvent(FahrstuhlGraphic fG)
    {
        System.out.println(fahrstuhlOpenListenerList);
        for(Object fahrstuhlOpenListener:fahrstuhlOpenListenerList)
        {
            ((FahrstuhlOpenListener) fahrstuhlOpenListener).opened(fG);
        }
    }
    public void sendClosedEvent(FahrstuhlGraphic fG)
    {
        for(Object fahrstuhlOpenListener:fahrstuhlOpenListenerList)
        {
            ((FahrstuhlOpenListener) fahrstuhlOpenListener).closed(fG);
        }
    }
    
}
