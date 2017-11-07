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
    Resource wealth;
    Resource stone;
    
    
    public Resource(String name){
        this.name = name;
        this.amount = 0;
    }
    
 
    
  public void addResource(String name, int amountChange){
      if(name.equals("Wealth")){
         
         amount= wealth.getResource(); 
      }
      else{
          amount= stone.getResource();
      }
      amount = amount + amountChange;
      view = GameView.getGameView();
      view.updateResourceLabels( name, amount);
      System.out.println(""+name+" "+ amount);
  }
  
  public int getResource(){
      return amount;
  }
    public Resource getStone(){
        return stone;
    }
    public Resource getWealth(){
        return wealth;
    }
    
}
