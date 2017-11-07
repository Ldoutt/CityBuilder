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
 
 GameController(String user){
    
     
     
     this.gameView = gameView;

     
     this.user = user;
     
   Timer timer = new Timer(true);
   TimerTask myTimerTask = new AddAttributes();
      
   timer.scheduleAtFixedRate(myTimerTask, 0, 5*1000); 
       
     gameView = new GameView(user);
     gameView.setVisible(true);
     gameView.setGameView(this.gameView);
   
 }




}
