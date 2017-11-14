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
public class Culture {

    int amountOfCulture;
    GameView view;
    GameViewTwo viewTwo;
    GameViewThree viewThree;
    GameController controller;

    public Culture() {
        this.amountOfCulture = 0;

    }

    public void addCulture(int amountChange, int versionView) {

        amountOfCulture = amountOfCulture + amountChange;
        if (versionView == 1) {
            view = GameView.getGameView();
            view.updateLabel(amountOfCulture);
        } else if (versionView == 2) {
            viewTwo = GameViewTwo.getGameView();
            viewTwo.updateLabel(amountOfCulture);
        } else if (versionView == 3) {
            viewThree = GameViewThree.getGameView();
            viewThree.updateLabel(amountOfCulture);

        }

    }

    public int getCulture() {
        return amountOfCulture;
    }

}
