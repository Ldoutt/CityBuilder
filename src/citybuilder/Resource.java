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
public class Resource {

    String name;
    int amountOfStone;
    int amountOfCopper;
    int amountOfIron;
    int amountOfBread;
    int amountOfBeef;
    int amountOfBeer;
    int amount;

    GameView view;
    GameViewTwo viewTwo;
    GameViewThree viewThree;
    int wealth;
    static Resource resource;

    public Resource(String name) {
        this.name = name;
        this.amountOfStone = 0;
        this.amountOfCopper = 0;
        this.amountOfIron = 0;
        this.amountOfBread = 0;
        this.amountOfBeef = 0;
        this.amountOfBeer = 0;
        this.wealth = 0;
    }

    public void addResource(String name) {

        switch (name) {
            case "Stone":
                this.amountOfStone = this.amountOfStone + 10;
                view = GameView.getGameView();
                this.amountOfStone = view.getResourceAmount("Stone") + 10;
                view.updateResourceLabels(name, amountOfStone);
                view.setResourceAmount("Stone", amountOfStone);
                break;
            case "Bread":
                this.amountOfBread = this.amountOfBread + 10;
                view = GameView.getGameView();
                this.amountOfBread = view.getResourceAmount("Bread") + 10;
                view.updateResourceLabels(name, amountOfBread);
                view.setResourceAmount("Bread", amountOfBread);
                break;
            case "Beef":
                this.amountOfBeef = this.amountOfBeef + 10;
                viewTwo = GameViewTwo.getGameView();
                this.amountOfBeef = viewTwo.getResourceAmount("Beef") + 10;
                viewTwo.updateResourceLabels(name, amountOfBeef);
                viewTwo.setResourceAmount("Beef", amountOfBeef);
                break;
            case "Beer":
                this.amountOfBeer = this.amountOfBeer + 10;
                viewThree = GameViewThree.getGameView();
                this.amountOfBeer = viewThree.getResourceAmount("Beer") + 10;
                viewThree.updateResourceLabels(name, amountOfBeer);
                viewThree.setResourceAmount("Beer", amountOfBeer);
                break;
            case "Copper":
                this.amountOfCopper = this.amountOfCopper + 10;
                viewTwo = GameViewTwo.getGameView();
                this.amountOfCopper = viewTwo.getResourceAmount("Copper") + 10;
                viewTwo.updateResourceLabels(name, amountOfCopper);
                viewTwo.setResourceAmount("Copper", amountOfCopper);
                break;
            case "Iron":
                this.amountOfIron = this.amountOfIron + 10;
                viewThree = GameViewThree.getGameView();
                this.amountOfIron = viewThree.getResourceAmount("Iron") + 10;
                viewThree.updateResourceLabels(name, amountOfIron);
                viewThree.setResourceAmount("Iron", amountOfIron);
                break;
            default:
                break;
        }

    }

    public static Resource getResourceCurrent() {
        return resource;
    }

    public int getStone() {
        return amountOfStone;
    }

    public int getCopper() {
        return amountOfCopper;
    }

    public int getIron() {
        return amountOfIron;
    }

    //added

    public void setResourceAmount(int amount) {
        this.amount = amount;
    }

    public void setResource(Resource resource) {

        this.resource = resource;
    }

    public static Resource getResource() {
        return resource;
    }

    public void decreaseStone() {
        amountOfStone = amountOfStone - 10;
    }

    public void decreaseCopper() {
        amountOfCopper = amountOfCopper - 10;
    }

    public void decreaseIron() {
        amountOfIron = amountOfIron - 10;
    }
}
