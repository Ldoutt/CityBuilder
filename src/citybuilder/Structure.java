/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

/**
 *
 * @author Lauren
 */
public class Structure {
    String name;
    Resource resource;
    String resourceName;
    
    public Structure(String name){
        this.name = name;
      
    }
    
    public String getName(){
        return name;
    }
}
