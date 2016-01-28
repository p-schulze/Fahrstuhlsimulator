/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrstuhlsimulator.Misc;

import fahrstuhlsimulator.Mitarbeiter.Graphic.MitarbeiterGraphic;
import fahrstuhlsimulator.testumgebung.TestFenster;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class GraphicDrawer implements Runnable {
    
    private final int timeForFrame = 40;
    private static ArrayList<ArrayList<String>> taskList_task = new ArrayList();
    private static ArrayList<ArrayList<Object>> taskList_object = new ArrayList();
    
    public GraphicDrawer()
    {
        
    }
    
    public void addTask(ArrayList<String> tasks, ArrayList<Object> objects)
    {
        taskList_task.add(tasks);
        taskList_object.add(objects);
    }
    
    @Override
    public void run()
    {
        try{
            for(int i = 0; i < taskList_task.size();i++)
            {
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
                                    //System.out.println("HebArm: X: "+ mitarbeiterG.getY_Pos());
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
                                    mitarbeiterG.addToX(-5);
                                }
                                else{
                                    
                                    deleteTask(i);
                                }
                                
                        }
                    }
            }
        }catch(IndexOutOfBoundsException ex) {
            //System.out.println("Keine Aufgaben vorhanden");
        }
        //System.out.println("GraphicDrawer: Gestartet");
        try {TestFenster.panel.repaint();} catch(NullPointerException e) {/**System.out.println("Panel ist nochnicht geladen");**/}
        try {Thread.sleep(timeForFrame);} catch (InterruptedException ex) {Logger.getLogger(GraphicDrawer.class.getName()).log(Level.SEVERE, null, ex);}
        //System.out.println("GraphicDrawer: Fertig");
        this.run();
    }
    private void deleteTask(int i)
    {
        if((taskList_task.get(i).size()==1)) // TODO: Koennte zum ERROR fuehren
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
    
}
