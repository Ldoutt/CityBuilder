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
public class Resource {
    
    String name;
    int amount;
    GameView view;
    
    
    public Resource(String name){
        this.name = name;
        this.amount = 0;
    }
    
 
    
  public void addResource(String name){
     if(name.equals("Stone")){
         this.amount = this.amount+10; 
      }
      else if(name.equals("Copper")){
          this.amount= this.amount+10;
      }
      else if(name.equals("Iron")){
          this.amount= this.amount+10;
      }
      
      
      view = GameView.getGameView();
      view.updateResourceLabels( name, amount);
      System.out.println(""+name+" "+ amount);
  }
  
  public int getResource(){
      return amount;
  }
  
    
}
