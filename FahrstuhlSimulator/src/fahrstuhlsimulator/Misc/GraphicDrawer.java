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
    
    private final int timeForFrame = 600;
    private ArrayList<String> taskList_task = new ArrayList();
    private ArrayList<Object> taskList_object = new ArrayList();
    
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
        for(int i = 0; i< taskList_task.size(); i++)
        {
            String[] taskList_taskSplit = taskList_task.get(i).split("\\.");
            if(taskList_taskSplit[0].equalsIgnoreCase("Mitarbeiter"))
            {
                if(taskList_taskSplit[1].equalsIgnoreCase("streckArme"))
                {
                    System.out.println("GraphicDrawer:Mitarbeiter: Arme werden gestreckt");
                    ((MitarbeiterGraphic) taskList_object.get(i)).getAnimator().setArmRotation(10);
                }
            }
        }
        System.out.println("GraphicDrawer: Gestartet");
        try {Thread.sleep(timeForFrame);} catch (InterruptedException ex) {Logger.getLogger(GraphicDrawer.class.getName()).log(Level.SEVERE, null, ex);}
        System.out.println("GraphicDrawer: Fertig");
        TestFenster.panel.repaint();
        this.run();
    }
    
}
