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
    String user;
 Culture culture;

 
 GameController(String user, int i){
    
     this.culture = culture;
     
     this.gameView = gameView;
     
     
     this.user = user;
     

      
   if(i==1){
      
   Timer timer = new Timer(true);
   TimerTask myTimerTask = new AddAttributes();
      
   timer.scheduleAtFixedRate(myTimerTask, 0, 5*1000); 
    gameView = new GameView(user);
    gameView.setVisible(true);
    gameView.setGameView(this.gameView);
       
 
   }
   else if(i==2){
     
    GameViewTwo gameViewTwo = new GameViewTwo(user);
  gameViewTwo.setVisible(true); 
    gameViewTwo.setGameView(gameViewTwo);   
    }
    
   else if(i==3){
    GameViewThree gameViewThree = new GameViewThree(user);
    gameViewThree.setVisible(true);
    gameViewThree.setGameView(gameViewThree);
    }     
 }




}
