/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Lauren
 */
public class addCulture extends TimerTask{
Culture culture = new Culture();

 ArrayList <Structure> boardStuff;
    @Override
    public void run() {
    //   culture.addCulture(10);
    //    System.out.println(culture.getCulture());
     
     StructureCntl structurecntl = StructureCntl.getStructureCntl();
     
    
    boardStuff = structurecntl.getStructureList();
     
   for(Structure s : boardStuff){
       
       System.out.println(s.getName());
        if(s.getName().equals("Mud House")){
            culture.addCulture(5);
        }
        else if(s.getName().equals("Stone Mine")){
            culture.addCulture(10);
        }
        System.out.println(culture.getCulture());
     }
    }
    
}
