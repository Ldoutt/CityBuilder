/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.Color;
import java.awt.Dimension;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Lauren
 */
public class GameView extends JFrame {
    
    JPanel playerPanel;
    JPanel gamePanel;
    
    JLabel [] [] gridLabel = new JLabel [5][5];
    
    public GameView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("City Builer");
        this.setSize(new Dimension(1000, 1000));
        this.setLayout(null);
        
        playerPanel = new JPanel();
        playerPanel.setLayout(null);
        
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        
        
        
        playerPanel.setBounds(800,0,200,1000 );
        gamePanel.setBounds(0, 0, 800, 1000);
        
        this.add(playerPanel);
        this.add(gamePanel);
        
       gamePanel.setBackground(Color.red);
       
       getGrid();
       
      // JLabel clickedLabel = (JLabel) e.getSource();
       
    }
    
    
    public void getGrid(){
        for(int i=0; i<5; i++){
            for(int b=0; b<5; b++){
                
              gridLabel[i][b]= new JLabel();
              
              
              //to add action listener to labels you have to use mouselistener.. which needs to override all these methods :(
             gridLabel[i][b].addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("mouse clicked");
             
                    JLabel temp = (JLabel) e.getSource();
              
                    temp.setText("Hi");
                    System.out.println("Pressed");
                    temp.repaint();
                    
              }
                @Override public void mouseExited(MouseEvent e){
                    
                }
                @Override public void mouseReleased (MouseEvent e){
                    
                }
                @Override
                public void mousePressed(MouseEvent e){
                    
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    
                }
            });
                    gridLabel[i][b].setBounds(500, 500, i, b);
                 this.gamePanel.add(gridLabel[i][b]);
            }
        }
    }
}
