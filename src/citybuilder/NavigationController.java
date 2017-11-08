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
public class NavigationController {
    private String user;
    private MenuView menuView;
    private GameView gameView;
    
    
    public NavigationController(){
        this.menuView = new MenuView();
        menuView.addStartButtonListener(new StartListener());
        menuView.setVisible(true);
        
    }
    private class StartListener implements ActionListener{
        @Override
        
        public void actionPerformed(ActionEvent e){
  
            GameController gameC = new GameController(menuView.getUser(), 1);
            menuView.setVisible(false);
        }
    }
    
   
}
