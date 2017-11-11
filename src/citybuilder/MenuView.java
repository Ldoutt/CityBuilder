/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Lauren
 */
public class MenuView extends JFrame{
    
    JPanel menuPanel;
    JButton startButton;
    JLabel titleOfGame;
    JTextField userNameField;
     ImageIcon title = new ImageIcon("City Builder.png");
    JDialog instructions;
    JLabel instructionBody;
    JLabel instructionBodyTwo;
    JLabel instructionBodyThree;
     JLabel instructionBodyFour;
      JLabel instructionBodyFive;
    
    public MenuView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Menu");
        this.setSize(new Dimension(700, 700));
        //this.setLayout(null);
        
                
        menuPanel = new JPanel();
      
      
        
        this.add(menuPanel);
                
        
        
        
        startButton = new JButton("Start Game");
        titleOfGame = new JLabel();
        titleOfGame.setIcon(title);
        titleOfGame.setBackground(Color.blue);
        userNameField = new JTextField("Enter UserName Here");
        instructionBody= new JLabel("The Goal of the Game: is to Obtain Culture to Move to the next Age. ");
        instructionBodyTwo= new JLabel("First you must gain resources to obtain wealth."+ '\n');
        instructionBodyThree= new JLabel( " Then you can purchase houses. Each structure you purchase gains you culture."+'\n');
        instructionBodyFour = new JLabel("Houses Cost $15 and give you 2 pts of Culture. ");
         instructionBodyFive = new JLabel("Mines Cost $5 and give you 1 pt of Culture. ");
       
        //instructions=new JDialog(this,"Instructions for City Builder: " ,true);
          
        menuPanel.add(titleOfGame);
        menuPanel.add(instructionBody);
        menuPanel.add(instructionBodyTwo);
        menuPanel.add(instructionBodyThree);
        menuPanel.add(instructionBodyFour);
        menuPanel.add(instructionBodyFive);
        
        menuPanel.add(startButton);
        menuPanel.add(userNameField);
        
       // instructions.add(instructionBody);
       // instructions.add(instructionBodyTwo);
       // instructions.add(instructionBodyThree);
       // instructions.setSize(1000,1000);
       // instructions.setVisible(true);
           
    }
    
    public void addStartButtonListener(ActionListener listener){
        startButton.addActionListener(listener);
      //  System.out.println("reahced");
    }

 
      public String getUser(){
           return this.userNameField.getText();
       }
}

