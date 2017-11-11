/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Lauren
 */
public class GameController {
    private GameView gameView;
    private GameViewTwo gameViewTwo;
    private GameViewThree gameViewThree;
    String user;
    Culture culture;
    Resource resource;
    int money;
    static GameController gameController;
    private EndView endView;

 
 GameController(String user, int i){

     this.culture = culture;
     
    
     
     this.user = user;
     
     
     money=10;
     
     
     
  if(i==1){
      
   Timer timer = new Timer(true);
   TimerTask myTimerTask = new AddAttributes();
      
   timer.scheduleAtFixedRate(myTimerTask, 0, 5*1000); 
    gameView = new GameView(user);
    gameView.setVisible(true);
    gameView.setGameView(this.gameView);
    gameView.addResourceListenerOne(new ResourceToMoneyListener());
    gameView.updateMoneyLabel(10);
     }
         
   if(i==2){
      
    gameViewTwo = new GameViewTwo(user);
    gameViewTwo.setVisible(true); 
   
    

    gameViewTwo.setGameView(this.gameViewTwo); 
    gameViewTwo.addSecondResourceListener(new ResourceToMoneyListenerTwo());
    gameViewTwo.updateMoneyLabel(10);
    }
    
   else if(i==3){

    gameViewThree = new GameViewThree(user);
   
    gameViewThree.setVisible(true);
    gameViewThree.setGameView(this.gameViewThree);
    gameViewThree.addResourceListenerThree(new ResourceToMoneyListenerThree());
    gameViewThree.updateMoneyLabel(10);
   }  
   else if(i==4){
       endView = new EndView();
       endView.setVisible(true);
   }
 
    }

    public void setGameController(GameController gameC) {
       gameController= gameC;
    }
      
    private class ResourceToMoneyListener implements ActionListener{
        @Override
        
        public void actionPerformed(ActionEvent e){
            
            
          int amount = gameView.getResourceAmount();
          
             if(amount>10){
          
          money = addMoney(money);
          gameView.updateMoneyLabel(money); 
          amount= amount-10;
          gameView.updateResourceLabels("Stone", amount);
          gameView.setResourceAmount(amount);
             }
        }
    }   
        
       private class ResourceToMoneyListenerTwo implements ActionListener{
        @Override
        
        public void actionPerformed(ActionEvent e){
     
          int amount = gameViewTwo.getResourceAmount();
            System.out.println(amount);
            if(amount>10){
                 money = addMoney(money);//resource.switchResourceForWealth();
                 gameViewTwo.updateMoneyLabel(money);  
                 amount= amount-10;
          gameViewTwo.updateResourceLabels("Copper", amount);
          gameViewTwo.setResourceAmount(amount);
                 
            }
       
        }
    }  
    
         private class ResourceToMoneyListenerThree implements ActionListener{
        @Override
        
        public void actionPerformed(ActionEvent e){
     
          int amount = gameViewThree.getResourceAmount();
            System.out.println(amount);
            System.out.println("Change Resource to Money");
          money = addMoney(money);//resource.switchResourceForWealth();
          
          gameViewThree.updateMoneyLabel(money); 
          amount= amount-10;
          gameViewThree.updateResourceLabels("Iron", amount);
          gameViewThree.setResourceAmount(amount);
       
        }
    }   
    
    
        
        
        

    
    public int addMoney(int money){
        money = money+10;
        return money;
    }
    
    public int getMoney(){
        return this.money;
    }
    public void decreaseMoney(int decrement){
        money= money-decrement;
    }
    
 
      public static GameController getGameController(){
          return gameController;
      }
    

}