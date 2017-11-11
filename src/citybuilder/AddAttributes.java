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
boolean oneTimeSwitch=false;
boolean secondOneTimeSwitch=false;
boolean thirdOneTimeSwitch = false;

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
            culture.addCulture(2,1);
        }
        else if(s.getName().equals("Wooden House")){
            culture.addCulture(3,2);
        }
        
        else if(s.getName().equals("Stone House")){
            culture.addCulture(4,3);
        }
        else if(s.getName().equals("Stone Mine")){
            culture.addCulture(1, 1);
            resource.addResource("Stone");
        }
        else if(s.getName().equals("Copper Mine")){
           culture.addCulture(2, 2);
            resource.addResource("Copper");
         }
        else if(s.getName().equals("Iron Mine")){
            culture.addCulture(3, 3);
            resource.addResource("Iron");
          
         }
    }
   
   if(culture.getCulture()>=50& oneTimeSwitch==false){
       
          GameController controller = new GameController("", 2);
          controller.setGameController(controller);
          oneTimeSwitch=true;
          
    }
    if(culture.getCulture()>=200& secondOneTimeSwitch==false){
 
        GameController controller = new GameController("", 3);
        controller.setGameController(controller);
        secondOneTimeSwitch=true;
    }
     if(culture.getCulture()>=400& thirdOneTimeSwitch==false){
 
        GameController controller = new GameController("", 4);
        controller.setGameController(controller);
        thirdOneTimeSwitch=true;
    }
    }
}

