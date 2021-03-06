/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Lauren
 */
public class AddAttributes extends TimerTask {

    Culture culture = new Culture();
    Resource resource = new Resource("");
    boolean oneTimeSwitch = false;
    boolean secondOneTimeSwitch = false;
    boolean thirdOneTimeSwitch = false;
    String name;
    GameController controller;

    ArrayList<Structure> boardStuff;

    @Override
    public void run() {

        StructureCntl structurecntl = StructureCntl.getStructureCntl();

        boardStuff = structurecntl.getStructureList();

        for (Structure s : boardStuff) {

            
            switch (s.getName()) {
                case "Mud House":
                    culture.addCulture(2, 1);
                    resource.addResource("Bread");
                    break;
                case "Wooden House":
                    culture.addCulture(3, 2);
                    resource.addResource("Beef");
                    break;
                case "Stone House":
                    culture.addCulture(4, 3);
                    resource.addResource("Beer");
                    break;
                case "Stone Mine":
                    culture.addCulture(1, 1);
                    resource.addResource("Stone");
                    break;
                case "Copper Mine":
                    culture.addCulture(2, 2);
                    resource.addResource("Copper");
                    break;
                case "Iron Mine":
                    culture.addCulture(3, 3);
                    resource.addResource("Iron");
                    break;
                default:
                    break;
            }
        }

        if (culture.getCulture() >= 50 & oneTimeSwitch == false) {
            controller = GameController.getGameController();
            name = controller.getUserName();

            controller = new GameController(name, 2);
            controller.setGameController(controller);
            oneTimeSwitch = true;

        }
        if (culture.getCulture() >= 200 & secondOneTimeSwitch == false) {
            controller = GameController.getGameController();
            name = controller.getUserNameTwo();

            controller = new GameController(name, 3);
            controller.setGameController(controller);
            secondOneTimeSwitch = true;
        }
        if (culture.getCulture() >= 400 & thirdOneTimeSwitch == false) {

            controller = new GameController("", 4);
            controller.setGameController(controller);
            thirdOneTimeSwitch = true;
        }
    }
}
