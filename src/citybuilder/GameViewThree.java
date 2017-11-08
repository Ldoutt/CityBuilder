/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
    ImageIcon house = new ImageIcon("stone_house.gif");
    JLabel displayUserLabel;
    JLabel culture;
    
    ImageIcon copperMine = new ImageIcon("iron_mine.gif");
    JLabel displayStoneLabel;
    JLabel displayHouseLabel;
    //default
    ImageIcon selectedStructure=new ImageIcon("stone_house.gif");
    Structure structureToAdd=new Structure("Stone House");
    Resource resourceToAdd;
    
    ArrayList <Structure> s2;// = new ArrayList <Structure>();
    StructureCntl s1; // = new StructureCntl(s2);
    static GameViewThree gameView;
    JLabel resourceLabelOne;
    
    Resource wealth;
    Resource stone;
     
    public GameViewThree(String user) {

        s2 = new ArrayList <Structure>();
        s1 = new StructureCntl(s2);
        
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
        
        
        
        playerPanel.add(culture);
        playerPanel.add(displayUserLabel);

        playerPanel.setBackground(Color.green);
        
        displayStoneLabel = new JLabel();
        displayStoneLabel.setIcon(copperMine);
        
        displayHouseLabel = new JLabel();
        displayHouseLabel.setIcon(house);
        
        playerPanel.add(displayStoneLabel);
        playerPanel.add(displayHouseLabel);
        playerPanel.add(resourceLabelOne);
       
     
      
            
            displayStoneLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  selectedStructure =new ImageIcon("copper_mine.gif");
                  structureToAdd = new Structure("Copper Mine");
                  resourceToAdd = new Resource("Copper");
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
                  selectedStructure =new ImageIcon("stone_house.gif");
                   structureToAdd = new Structure("Stone House");
                   
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
                    
                    temp.setIcon(selectedStructure);
                    System.out.println("Pressed");
                    temp.validate();
                    temp.repaint();

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
}


