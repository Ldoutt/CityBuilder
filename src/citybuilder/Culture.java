/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Lauren
 */
public class Culture{
    int amountOfCulture;
    GameView view;
    GameController controller;
    
    public Culture(){
      this.amountOfCulture= 0;
     
    }
    
  public void addCulture(int amountChange){
    
      amountOfCulture = amountOfCulture + amountChange;
      view = GameView.getGameView();
      view.updateLabel(amountOfCulture);
   
      
  }
  
  public int getCulture(){
      return amountOfCulture;
  }
  
  
 
      
  }

