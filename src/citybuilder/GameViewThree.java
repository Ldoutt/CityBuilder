/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lauren
 */
public class GameViewThree extends JFrame {

    String userName;
    JPanel playerPanel;
    JPanel gamePanel;
    ImageIcon house = new ImageIcon("stone_house_small.gif");
    JLabel displayUserLabel;
    JLabel culture;

    ImageIcon copperMine = new ImageIcon("iron_mine.gif");
    JLabel displayIronLabel;
    JLabel displayHouseLabel;
    //default
    ImageIcon selectedStructure = new ImageIcon("iron_mine.gif");
    Structure structureToAdd = new Structure("Iron Mine");
    Resource resourceToAdd;

    ArrayList<Structure> s2;// = new ArrayList <Structure>();
    StructureCntl s1; // = new StructureCntl(s2);
    static GameViewThree gameView;
    JLabel resourceLabelOne;
    JLabel resourceLabelTwo;

    JLabel money;
    JButton resourceToMoney;
    int amountOfIron = 0;
    int amountOfBeer = 0;
    GameController controller;
    int moneyDecrease = 5;

    public GameViewThree(String user) {
        this.amountOfIron = 0;
        s2 = new ArrayList<Structure>();
        s1 = new StructureCntl(s2);
        money = new JLabel("Money ");
        resourceToMoney = new JButton("Resource to $");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Iron Age");
        this.setSize(new Dimension(700, 700));
        this.setLayout(null);

        playerPanel = new JPanel();
        playerPanel.setLayout(null);

        gamePanel = new JPanel();
        gamePanel.setLayout(null);

        playerPanel.setBounds(525, 0, 175, 700);
        gamePanel.setBounds(0, 0, 525, 700);

        this.add(playerPanel);
        this.add(gamePanel);

        displayUserLabel = new JLabel("Welcome " + user);

        culture = new JLabel("Culture");

        resourceLabelOne = new JLabel("Iron");
        resourceLabelTwo = new JLabel("Beer");
        GridLayout layout2 = new GridLayout(8, 2);
        playerPanel.setLayout(layout2);

        playerPanel.add(culture);
        playerPanel.add(displayUserLabel);

        playerPanel.setBackground(Color.green);

        displayIronLabel = new JLabel();
        displayIronLabel.setIcon(copperMine);

        displayHouseLabel = new JLabel();
        displayHouseLabel.setIcon(house);

        playerPanel.add(displayIronLabel);
        playerPanel.add(displayHouseLabel);
        playerPanel.add(resourceLabelOne);
        playerPanel.add(resourceLabelTwo);
        playerPanel.add(money);
        playerPanel.add(resourceToMoney);

        displayIronLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moneyDecrease = 5;
                selectedStructure = new ImageIcon("iron_mine.gif");
                structureToAdd = new Structure("Iron Mine");
                resourceToAdd = new Resource("Iron");

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
        });

        displayHouseLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                controller = GameController.getGameController();
                if (controller.getMoney() >= 15) {
                    selectedStructure = new ImageIcon("stone_house_small.gif");
                    structureToAdd = new Structure("Stone House");
                    moneyDecrease = 15;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
        });

        gamePanel.setBackground(Color.LIGHT_GRAY);

        GridLayout layout = new GridLayout(5, 5);
        gamePanel.setLayout(layout);

        JLabel[] gridLabels = new JLabel[25];

        for (int i = 0; i < 25; i++) {

            gridLabels[i] = new JLabel("----");

            gamePanel.add(gridLabels[i]);

            gridLabels[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    JLabel temp = (JLabel) e.getSource();

                    controller = GameController.getGameController();
                    if (controller.getMoney() >= moneyDecrease) {
                        s1 = StructureCntl.getStructureCntl();

                        s1.addStructure(structureToAdd);

                        controller.decreaseMoney(moneyDecrease);

                        updateMoneyLabel(controller.getMoney());

                        temp.setIcon(selectedStructure);

                        temp.validate();
                        temp.repaint();
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }
            });
        }

    }

    public void setUserName(String name) {
        this.userName = name;
        displayUserLabel.setText("Welcome " + name);
    }

    public String getUserName() {
        return userName;
    }

    public void updateLabel(int amountOfCulture) {
        culture.setText("Culture: " + amountOfCulture);
    }

    public void setGameView(GameViewThree view) {

        gameView = view;
    }

    public static GameViewThree getGameView() {
        return gameView;
    }

    public void updateResourceLabels(String type, int amount) {
        if (type.equals("Iron")) {
        resourceLabelOne.setText("Iron " + amount);
        }
        else if (type.equals("Beer")) {
            resourceLabelTwo.setText("Beer " + amount);
        }

    }

    public void addResourceListenerThree(ActionListener listener) {
        resourceToMoney.addActionListener(listener);

    }

    public void updateMoneyLabel(int wealth) {
        money.setText("Money " + wealth);
    }

    public void setResourceAmount(String type, int amount) {
        if (type.equals("Iron")) {
        this.amountOfIron = amount;
        }
        else if (type.equals("Beer")) {
            this.amountOfBeer = amount;
        }
       
    }

    public int getResourceAmount(String type) {
    int rv = 0;
    
        if (type.equals("Iron")) {
            rv = this.amountOfIron;
        }
        else if (type.equals("Beer")) {
            rv = this.amountOfBeer;
        }
        return rv;
    }
}
