/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Lauren
 */
public class GameView extends JFrame {

    String userName;
    JPanel playerPanel;
    JPanel gamePanel;
    ImageIcon house = new ImageIcon("mud_house.gif");
    JLabel displayUserLabel;
    JLabel culture;
    
    ImageIcon stoneMine = new ImageIcon("stone_iron_mine.gif");
    JLabel displayStoneLabel;
    JLabel displayHouseLabel;
    //default
    ImageIcon selectedStructure=new ImageIcon("stone_iron_mine.gif");
    Structure structureToAdd=new Structure("Stone Mine");
    Resource resourceToAdd;
    
    ArrayList <Structure> s2;// = new ArrayList <Structure>();
    StructureCntl s1; // = new StructureCntl(s2);
    static GameView gameView;
    JLabel resourceLabelOne;
    JLabel resourceLabelTwo;
   
    Resource stone;
    JLabel money;
    JButton resourceToMoney;
    int amountOfStone=0;
    GameController controller;
    int moneyDecrease=5;

     
    public GameView(String user) {
        this.amountOfStone=0;
        s2 = new ArrayList <Structure>();
        s1 = new StructureCntl(s2);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Stone Age");
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
        
        
    
       displayUserLabel= new JLabel("Welcome "+user);

        culture = new JLabel("Culture");
        resourceLabelOne = new JLabel("Stone");
        money = new JLabel("Money");
        resourceToMoney= new JButton("Resource to $");
       
        
        GridLayout layout2 = new GridLayout(8, 2);
        playerPanel.setLayout(layout2);
        
        
        
        playerPanel.add(culture);
        playerPanel.add(displayUserLabel);

        playerPanel.setBackground(Color.pink);
        
        displayStoneLabel = new JLabel();
        displayStoneLabel.setIcon(stoneMine);
        
        displayHouseLabel = new JLabel();
        displayHouseLabel.setIcon(house);
        
 

 
        playerPanel.add(displayStoneLabel);
        playerPanel.add(displayHouseLabel);
        playerPanel.add(resourceLabelOne);
        playerPanel.add(money);
        playerPanel.add(resourceToMoney);
        
        
            
            displayStoneLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  selectedStructure =new ImageIcon("stone_iron_mine.gif");
                  structureToAdd = new Structure("Stone Mine");
                  resourceToAdd = new Resource("Stone");
                  moneyDecrease=5;
                //  s1 = StructureCntl.getStructureCntl();
                 // s1.addStructure(structureToAdd);
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
                  selectedStructure =new ImageIcon("mud_house.gif");
                   structureToAdd = new Structure("Mud House");
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

        gamePanel.setBackground(Color.green);

        GridLayout layout = new GridLayout(5, 5);
        gamePanel.setLayout(layout);

        JLabel[] gridLabels = new JLabel[25];

        for (int i = 0; i < 25; i++) {

            gridLabels[i] = new JLabel("-----");
        //("Label: " + i);

            gamePanel.add(gridLabels[i]);

            gridLabels[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                   // StructureCntl structurecntl;
                    //structurecntl
                    
                    
                    System.out.println("mouse clicked");

                    JLabel temp = (JLabel) e.getSource();
                    
                    
                    
                    
                     controller= GameController.getGameController();
                    if(controller.getMoney()>=moneyDecrease){
                    
                    s1= StructureCntl.getStructureCntl();
                    
                    s1.addStructure(structureToAdd);
                        
                   controller.decreaseMoney(moneyDecrease);
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
      
      public void setGameView(GameView view){
          
          gameView = view;
      }
      public static GameView getGameView(){
          return gameView;
      }
    
      public void updateResourceLabels(String type, int amount){
          if(type.equals("Stone")){
            resourceLabelOne.setText("Stone "+amount);   
          }
      }
      
      
 
       public void addResourceListenerOne(ActionListener listener){
        resourceToMoney.addActionListener(listener);
      
    }
       
      public void updateMoneyLabel(int wealth){
          money.setText("Money "+wealth);
      }
      
      public void setResourceAmount(int amountOfStone){
         this.amountOfStone = amountOfStone;
      }
      public int getResourceAmount(){
          return this.amountOfStone;
      }
}
