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

    
    public MenuView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Menu");
        this.setSize(new Dimension(600, 600));
        //this.setLayout(null);
        
                
        menuPanel = new JPanel();
      
      
        
        this.add(menuPanel);
                
        
        
        
        startButton = new JButton("start");
        titleOfGame = new JLabel("City Builder");
        titleOfGame.setBackground(Color.blue);
        userNameField = new JTextField("Enter UserName Here");
  
          
        menuPanel.add(titleOfGame);
        menuPanel.add(startButton);
        menuPanel.add(userNameField);

           
    }
    
    public void addStartButtonListener(ActionListener listener){
        startButton.addActionListener(listener);
      //  System.out.println("reahced");
    }

 
      public String getUser(){
           return this.userNameField.getText();
       }
}

