/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
     
    
       
     gameView = new GameView(user);
     gameView.setVisible(true);
  
 }




}
