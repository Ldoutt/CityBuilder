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
import javax.swing.JFrame;

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
    private StructureCntl structureArrayTwo;
    private StructureCntl structureArrayThree;
    private String name;

    GameController(String user, int i) {
        gameView = new GameView(user);
        gameViewTwo = new GameViewTwo(user);
        gameViewThree = new GameViewThree(user);

        setUserNameTwo(user);
        setUserName(user);

        this.user = user;
        money = 10;

        if (i == 1) {

            Timer timer = new Timer(true);
            TimerTask myTimerTask = new AddAttributes();

            timer.scheduleAtFixedRate(myTimerTask, 0, 5 * 1000);

            gameView.setVisible(true);
            gameView.setGameView(this.gameView);
            gameView.addResourceListenerOne(new ResourceToMoneyListener());
            gameView.updateMoneyLabel(10);

        }

        if (i == 2) {
            gameView = GameView.getGameView();
            gameView.setVisible(false);

            structureArrayTwo = StructureCntl.getStructureCntl();
            structureArrayTwo.resetStructureArray();

            gameViewTwo.setVisible(true);
            gameViewTwo.setGameView(this.gameViewTwo);
            gameViewTwo.addSecondResourceListener(new ResourceToMoneyListenerTwo());
            gameViewTwo.updateMoneyLabel(10);
        } else if (i == 3) {
            gameViewTwo = GameViewTwo.getGameView();
            gameViewTwo.setVisible(false);

            structureArrayThree = StructureCntl.getStructureCntl();
            structureArrayThree.resetStructureArray();

            gameViewThree.setVisible(true);
            gameViewThree.setGameView(this.gameViewThree);
            gameViewThree.addResourceListenerThree(new ResourceToMoneyListenerThree());
            gameViewThree.updateMoneyLabel(10);
        } else if (i == 4) {
            gameViewThree = GameViewThree.getGameView();
            gameViewThree.setVisible(false);
            endView = new EndView();
            endView.setVisible(true);
        }

    }

    public void setGameController(GameController gameC) {
        gameController = gameC;
    }

    private class ResourceToMoneyListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {

            int amount = gameView.getResourceAmount("Stone");

            if (amount >= 10) {

                money = addMoney(money);
                gameView.updateMoneyLabel(money);
                amount = amount - 10;
                gameView.updateResourceLabels("Stone", amount);
                gameView.setResourceAmount("Stone", amount);
            }
        }
    }

    private class ResourceToMoneyListenerTwo implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {

            int amount = gameViewTwo.getResourceAmount("Copper");
            if (amount >= 10) {
                money = addMoney(money);//resource.switchResourceForWealth();
                gameViewTwo.updateMoneyLabel(money);
                amount = amount - 10;
                gameViewTwo.updateResourceLabels("Copper", amount);
                gameViewTwo.setResourceAmount("Copper", amount);

            }

        }
    }

    private class ResourceToMoneyListenerThree implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {

            int amount = gameViewThree.getResourceAmount("Iron");
            if (amount >= 10) {
                money = addMoney(money);//resource.switchResourceForWealth();

                gameViewThree.updateMoneyLabel(money);
                amount = amount - 10;
                gameViewThree.updateResourceLabels("Iron", amount);
                gameViewThree.setResourceAmount("Iron", amount);
            }
        }
    }

    public int addMoney(int money) {
        money = money + 10;
        return money;
    }

    public int getMoney() {
        return this.money;
    }

    public void decreaseMoney(int decrement) {
        money = money - decrement;
    }

    public static GameController getGameController() {
        return gameController;
    }

    public void setUserName(String name) {

        gameViewTwo.setUserName(name);

    }

    public String getUserName() {
        user = gameViewTwo.getUserName();
        return user;
    }

    public void setUserNameTwo(String name) {

        gameViewThree.setUserName(name);

    }

    public String getUserNameTwo() {
        user = gameViewThree.getUserName();
        return user;
    }

}
