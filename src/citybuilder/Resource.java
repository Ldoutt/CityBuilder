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
    int amountOfStone;
    int amountOfCopper;
    int amountOfIron;
    int amount;
    
    GameView view;
    GameViewTwo viewTwo;
    GameViewThree viewThree;
    int wealth;
    static Resource resource;
    
    public Resource(String name){
        this.name = name;
        this.amountOfStone = 0;
        this.amountOfCopper=0;
        this.amountOfIron=0;
        this.wealth=0;
    }
    
 
    
  public void addResource(String name){
      
     if(name.equals("Stone")){
         
      this.amountOfStone = this.amountOfStone+10;
     view = GameView.getGameView();
     this.amountOfStone= view.getResourceAmount()+10;
      view.updateResourceLabels( name, amountOfStone);
      view.setResourceAmount(amountOfStone);
      
      
         
      }
     
      else if(name.equals("Copper")){
          this.amountOfCopper= this.amountOfCopper+10;
              
      viewTwo = GameViewTwo.getGameView();
      this.amountOfCopper= viewTwo.getResourceAmount()+10;
      viewTwo.updateResourceLabels( name, amountOfCopper);
      viewTwo.setResourceAmount(amountOfCopper);
      System.out.println(""+name+" "+ amountOfCopper);
      }
      
      else if(name.equals("Iron")){
          this.amountOfIron= this.amountOfIron+10;
              
      viewThree = GameViewThree.getGameView();
      this.amountOfIron= viewThree.getResourceAmount()+10;
      viewThree.updateResourceLabels( name, amountOfIron);
      viewThree.setResourceAmount(amountOfIron);
      }
      
      
      
  }
  
  public static Resource getResourceCurrent(){
      return resource;
  }
  
  public int getStone(){
      return amountOfStone;
  }
 public int getCopper(){
      return amountOfCopper;
  }
 public int getIron(){
      return amountOfIron;
  }
 //added
  public void setResourceAmount(int amount){
      this.amount = amount;
  }
   public void setResource(Resource resource){
          
          this.resource = resource;
      }
      public static Resource getResource(){
          return resource;
      }
      
        public void decreaseStone(){
      amountOfStone= amountOfStone-10;
        }
        public void decreaseCopper(){
        amountOfCopper = amountOfCopper-10;
        }
        public void decreaseIron(){
        amountOfIron = amountOfIron-10;
        }
}
