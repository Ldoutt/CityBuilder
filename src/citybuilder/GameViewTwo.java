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
public class GameViewTwo extends JFrame{


    String userName;
    JPanel playerPanel;
    JPanel gamePanel;
    ImageIcon house = new ImageIcon("house.gif");
    JLabel displayUserLabel;
    JLabel culture;
    
    ImageIcon copperMine = new ImageIcon("copper_mine.gif");
    JLabel displayCopperLabel;
    JLabel displayHouseLabel;
    //default
    ImageIcon selectedStructure=new ImageIcon("copper_mine.gif");
    Structure structureToAdd=new Structure("Copper Mine");
    Resource resourceToAdd;
    
    ArrayList <Structure> s2;// = new ArrayList <Structure>();
    StructureCntl s1; // = new StructureCntl(s2);
    static GameViewTwo gameView;
    JLabel resourceLabelOne;

    
    JLabel money;
    JButton resourceToMoney;
    int amountOfCopper=0;
     GameController controller;
      int moneyDecrease;
      
    public GameViewTwo(String user) {
        this.amountOfCopper=0;
        s2 = new ArrayList <Structure>();
        s1 = new StructureCntl(s2);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Bronze Age");
        this.setSize(new Dimension(600, 600));
        this.setLayout(null);
        
        playerPanel = new JPanel();
        playerPanel.setLayout(null);

        gamePanel = new JPanel();
        gamePanel.setLayout(null);

        playerPanel.setBounds(450, 0, 150, 600);
        gamePanel.setBounds(0, 0, 450, 600);

        this.add(playerPanel);
        this.add(gamePanel);
         moneyDecrease=0;
        
    
       displayUserLabel= new JLabel("Welcome "+user);

        culture = new JLabel("Culture");
        resourceLabelOne = new JLabel("Copper");
         money = new JLabel("Money");
        resourceToMoney= new JButton("Resource to $");
        
        
        GridLayout layout2 = new GridLayout(8, 2);
        playerPanel.setLayout(layout2);
        
        
        
        playerPanel.add(culture);
        playerPanel.add(displayUserLabel);

        playerPanel.setBackground(Color.pink);
        
        displayCopperLabel = new JLabel();
        displayCopperLabel.setIcon(copperMine);
        
        displayHouseLabel = new JLabel();
        displayHouseLabel.setIcon(house);
        
        playerPanel.add(displayCopperLabel);
        playerPanel.add(displayHouseLabel);
        playerPanel.add(resourceLabelOne);
        playerPanel.add(money);
        playerPanel.add(resourceToMoney);
     
      
            
            displayCopperLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  selectedStructure =new ImageIcon("copper_mine.gif");
                  structureToAdd = new Structure("Copper Mine");
                  resourceToAdd = new Resource("Copper");
                //  s1 = StructureCntl.getStructureCntl();
                 // s1.addStructure(structureToAdd);
                  moneyDecrease=5;
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
                    
                     controller= GameController.getGameController();
                        if(controller.getMoney()>15){
                    
                  selectedStructure =new ImageIcon("house.gif");
                   structureToAdd = new Structure("Wooden House");
                        
                   //s1 = StructureCntl.getStructureCntl();
                  //s1.addStructure(structureToAdd);
              moneyDecrease=15;
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

        gamePanel.setBackground(Color.gray);

        GridLayout layout = new GridLayout(5, 5);
        gamePanel.setLayout(layout);

        JLabel[] gridLabels = new JLabel[25];

        for (int i = 0; i < 25; i++) {

            gridLabels[i] = new JLabel("Label: " + i);

            gamePanel.add(gridLabels[i]);

            gridLabels[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                   // StructureCntl structurecntl;
                    //structurecntl
                    s1= StructureCntl.getStructureCntl();
                    //structurecntl
                    s1.addStructure(structureToAdd);
                    
                    System.out.println("mouse clicked");

                    JLabel temp = (JLabel) e.getSource();
                    
                    
                    
                    controller= GameController.getGameController();
                    if(controller.getMoney()>=moneyDecrease){
                    
                        
                   controller.decreaseMoney(moneyDecrease);
                        System.out.println("DECREASE MONEY");
                   updateMoneyLabel(controller.getMoney());
                    
                    
                    
                    
                    temp.setIcon(selectedStructure);
                    System.out.println("Pressed");
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
    public void setUserName(String name){
        this.userName = name;
    }
      public String getUserName(){
          return userName;
      }  

      public void updateLabel(int amountOfCulture){
          culture.setText("Culture: " +amountOfCulture);
      }
      
      public void setGameView(GameViewTwo view){
          
          gameView = view;
      }
      public static GameViewTwo getGameView(){
          return gameView;
      }
    
      public void updateResourceLabels(String type, int amount){
          
          resourceLabelOne.setText("Copper "+amount);
      
      }
      
      public void addSecondResourceListener(ActionListener listener){
        resourceToMoney.addActionListener(listener);
      
    }
       
      public void updateMoneyLabel(int wealth){
          money.setText("Money "+wealth);
      }
      
      public void setResourceAmount(int amountOfCopper){
         this.amountOfCopper = amountOfCopper;
          System.out.println("Made It");
      }
      public int getResourceAmount(){
          return this.amountOfCopper;
          
      }
}


