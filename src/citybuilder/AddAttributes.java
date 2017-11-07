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
public class AddAttributes extends TimerTask{
Culture culture = new Culture();
Resource resource;

 ArrayList <Structure> boardStuff;
    @Override
    public void run() {
    //   culture.AddAttributes(10);
    //    System.out.println(culture.getCulture());
     
     StructureCntl structurecntl = StructureCntl.getStructureCntl();
     
    
    boardStuff = structurecntl.getStructureList();
     
   for(Structure s : boardStuff){
       
       System.out.println(s.getName());
        if(s.getName().equals("Mud House")){
            culture.addCulture(5);
            resource = new Resource("Wealth");
            resource.addResource("Wealth", 50);
        }
        else if(s.getName().equals("Stone Mine")){
            culture.addCulture(10);
            resource = new Resource("Stone");
            resource.addResource("Stone", 100);
        }
        System.out.println(culture.getCulture());
     }
    }
    
}
