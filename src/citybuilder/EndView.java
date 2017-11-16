/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lauren
 */
public class EndView extends JFrame {

    JPanel endPanel;
    JLabel endLabel;
    ImageIcon end = new ImageIcon("gameover.png");

    public EndView() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("End Game");
        this.setSize(new Dimension(700, 700));

        endPanel = new JPanel();
        this.add(endPanel);
        endLabel = new JLabel();
        endLabel.setIcon(end);
        endPanel.add(endLabel);
    }
}
