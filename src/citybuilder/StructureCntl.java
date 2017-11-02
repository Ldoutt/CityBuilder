/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.util.ArrayList;

/**
 *
 * @author Lauren
 */
public class StructureCntl {
   
    private ArrayList <Structure> structures;
  StructureCntl structureCntl;
  
    public StructureCntl(){
       // structures = new ArrayList<>();
    }
  
    
    
    
    public void addStructure(Structure addStructure){
        structures.add(addStructure);
    }
    
    public ArrayList <Structure> getStructureList(){
        if(structures==null){
            structures = new ArrayList <Structure>();
        }
        
        return structures;
    }
    
    public StructureCntl getStructureCntl(){
        if(structureCntl ==null){
            structureCntl = new StructureCntl();
        }
        
        return structureCntl;
    }
    
}
