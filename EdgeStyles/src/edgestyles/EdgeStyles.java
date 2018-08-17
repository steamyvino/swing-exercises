/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgestyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

/**
 *
 * @author Maciek
 */
public class EdgeStyles extends JFrame {

   
    ButtonGroup group = new ButtonGroup();
    
    
    JPanel radioPanel = new JPanel();
    JPanel examplePanel = new JPanel();
    
    
    EdgeStyles()
    {
    
        initComponents();
        
    }
    
    void initComponents()
    {
    
        this.setBounds(300, 300,300,200);
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(radioPanel);
        this.getContentPane().add(examplePanel);
    
         createRadioButton("EtchedBorder", BorderFactory.createEtchedBorder());
         createRadioButton("LoweredBevelBorder", BorderFactory.createLoweredBevelBorder());

        
    }
    
    void createRadioButton(String name, Border border)
    {
     
         JRadioButton radioBtn = new JRadioButton(name);
         radioBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                examplePanel.setBorder(BorderFactory.createTitledBorder(border,name));
             }
         });
        
          group.add(radioBtn);
          radioPanel.add(radioBtn);
    }    
    
    public static void main(String[] args) {
        new EdgeStyles().setVisible(true);
    }
    
}
