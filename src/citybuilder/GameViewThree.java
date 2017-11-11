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
public class GameViewThree extends JFrame{


    String userName;
    JPanel playerPanel;
    JPanel gamePanel;
    ImageIcon house = new ImageIcon("stone_house.png");
    JLabel displayUserLabel;
    JLabel culture;
    
    ImageIcon copperMine = new ImageIcon("iron_mine.gif");
    JLabel displayIronLabel;
    JLabel displayHouseLabel;
    //default
    ImageIcon selectedStructure=new ImageIcon("iron_mine.gif");
    Structure structureToAdd=new Structure("Iron Mine");
    Resource resourceToAdd;
    
    ArrayList <Structure> s2;// = new ArrayList <Structure>();
    StructureCntl s1; // = new StructureCntl(s2);
    static GameViewThree gameView;
    JLabel resourceLabelOne;
    
    JLabel money;
    JButton resourceToMoney;
    int amountOfIron=0;
    GameController controller;
     int moneyDecrease;
     
    public GameViewThree(String user) {
        this.amountOfIron =0;
        s2 = new ArrayList <Structure>();
        s1 = new StructureCntl(s2);
        money= new JLabel("Money ");
        resourceToMoney= new JButton("Resource to $");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Iron Age");
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
        
        resourceLabelOne = new JLabel("Iron");
        GridLayout layout2 = new GridLayout(8, 2);
        playerPanel.setLayout(layout2);
         moneyDecrease=0;
        
        
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
       playerPanel.add(money);
       playerPanel.add(resourceToMoney);
     
      
            
            displayIronLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  selectedStructure =new ImageIcon("iron_mine.gif");
                  structureToAdd = new Structure("Iron Mine");
                  resourceToAdd = new Resource("Iron");
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
                        if(controller.getMoney()>10){
                  selectedStructure =new ImageIcon("stone_house.png");
                   structureToAdd = new Structure("Stone House");
                   moneyDecrease=15;
                        }
                   //s1 = StructureCntl.getStructureCntl();
                  //s1.addStructure(structureToAdd);
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
      
      public void setGameView(GameViewThree view){
          
          gameView = view;
      }
      public static GameViewThree getGameView(){
          return gameView;
      }
    
      public void updateResourceLabels(String type, int amount){
          
          resourceLabelOne.setText("Iron "+amount);
      
          
          
      }
             public void addResourceListenerThree(ActionListener listener){
        resourceToMoney.addActionListener(listener);
      
    }
       
      public void updateMoneyLabel(int wealth){
          money.setText("Money "+wealth);
      }
      
      public void setResourceAmount(int amountOfIron){
         this.amountOfIron = amountOfIron;
      }
      public int getResourceAmount(){
          return this.amountOfIron;
      }
}


