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
    
    private final int timeForFrame = 20;
    private static ArrayList<String> taskList_task = new ArrayList();
    private static ArrayList<Object> taskList_object = new ArrayList();
    
    public GraphicDrawer()
    {
        
    }
    
    public void addTask(String task, Object object)
    {
        taskList_task.add(task);
        taskList_object.add(object);
    }
    
    @Override
    public void run()
    {
        
        ArrayList<String> temp_taskList_task = taskList_task;
        ArrayList<Object> temp_taskList_object = taskList_object;
        for(int i = 0; i< temp_taskList_task.size(); i++)
        {
            
            String[] taskList_taskSplit = temp_taskList_task.get(i).split("\\.");
            if(taskList_taskSplit[0].equalsIgnoreCase("Mitarbeiter"))
            {
                if(taskList_taskSplit[1].equalsIgnoreCase("streckArm"))
                {
                    //<editor-fold defaultstate="collapsed" desc="StreckArme">
                    if(taskList_taskSplit[2].equalsIgnoreCase("rechts"))
                    {
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        //System.out.println("GraphicDrawer:Mitarbeiter: Linker Arm wird gestreckt");
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_arm_rechts().checkWinkelGleichZielWinkel()))
                        {
                            mitarbeiterG.getAnimator().setArmRechtsRotation(100/speed);
                        }
                        else{
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                    }else if(taskList_taskSplit[2].equalsIgnoreCase("links"))
                    {
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        //System.out.println("GraphicDrawer:Mitarbeiter: Linker Arm wird gestreckt");
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_arm_links().checkWinkelGleichZielWinkel()))
                        {
                            mitarbeiterG.getAnimator().setArmLinksRotation(100/speed);
                        }
                        else{
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                    }
                    //</editor-fold>
                }

                else if(taskList_taskSplit[1].equalsIgnoreCase("senkArm"))
                {
                    //<editor-fold defaultstate="collapsed" desc="SenkArme">
                    if(taskList_taskSplit[2].equalsIgnoreCase("rechts"))
                    {
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_arm_rechts().checkRevertWinkelGleichZielWinkel()))
                        {
                            mitarbeiterG.getAnimator().setArmRechtsRotation(-100/speed);
                        }
                        else{
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                        
                    }
                    else if(taskList_taskSplit[2].equalsIgnoreCase("links"))
                    {
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_arm_links().checkRevertWinkelGleichZielWinkel()))
                        {
                            mitarbeiterG.getAnimator().setArmLinksRotation(-100/speed);
                        }
                        else{
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                    }
                    
                    
//</editor-fold>
                }
                else if(taskList_taskSplit[1].equalsIgnoreCase("hebFuss"))
                {
                    if(taskList_taskSplit[2].equalsIgnoreCase("rechts"))
                    {
                        System.out.println("1");
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_bein_rechts().checkWinkelGleichZielWinkel()))
                        {
                            
                            mitarbeiterG.getAnimator().setBeinRechtsRotation(100/speed);
                        }
                        else{
                            System.out.println("2");
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                    }else if(taskList_taskSplit[2].equalsIgnoreCase("links"))
                    {
                        System.out.println("Links");
                        MitarbeiterGraphic mitarbeiterG = (MitarbeiterGraphic) temp_taskList_object.get(i);
                        int speed = Integer.parseInt(taskList_taskSplit[3].split(":")[1]);
                        if(!(mitarbeiterG.getAnimator().getImg_trans_bein_links().checkWinkelGleichZielWinkel()))
                        {
                            mitarbeiterG.getAnimator().setBeinLinksRotation(100/speed);
                        }
                        else{
                            temp_taskList_task.remove(i);
                            temp_taskList_object.remove(i);
                        }
                    }
                }
            }
        }
        //System.out.println("GraphicDrawer: Gestartet");
        try {Thread.sleep(timeForFrame);} catch (InterruptedException ex) {Logger.getLogger(GraphicDrawer.class.getName()).log(Level.SEVERE, null, ex);}
        //System.out.println("GraphicDrawer: Fertig");
        try {TestFenster.panel.repaint();} catch(NullPointerException e) {/**System.out.println("Panel ist nochnicht geladen");**/}
        this.run();
    }
    
}
