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
public class CityBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuView menu = new MenuView();
        menu.setVisible(true);
        
       // NavigationController controller = new NavigationController();
        
       GameView game = new GameView();
       game.setVisible(true);
       
    }
    
}
