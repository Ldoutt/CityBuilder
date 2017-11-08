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
Resource resource =new Resource("");

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
        }
        else if(s.getName().equals("Wooden House")){
            culture.addCulture(5);
        }
        
        else if(s.getName().equals("Stone House")){
            culture.addCulture(5);
        }
        else if(s.getName().equals("Stone Mine")){
            culture.addCulture(1);
            resource.addResource("Stone");
        }
        else if(s.getName().equals("Copper Mine")){
            culture.addCulture(2);
            resource.addResource("Copper");
         }
        else if(s.getName().equals("Iron Mine")){
            culture.addCulture(3);
            resource.addResource("Iron");
         }
    }
   
   if(culture.getCulture()>10& culture.getCulture()<50){
          GameController controller = new GameController("", 2);
          
    }
    if(culture.getCulture()>50){
        GameController controller = new GameController("", 3);
    }
    }
}

