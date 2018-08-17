/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManyFrames extends JFrame{

    JButton newFrameBtn = new JButton("Create new frame");
    JButton newDialogBtn = new JButton("Create new dialog");
    private JFrame thisFrame = this;
    
    ManyFrames()
    {
    
        initComponents();
    
    }
    
    void initComponents()
    {
    
       
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(newFrameBtn);
        this.getContentPane().add(newDialogBtn);
        
        newFrameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new NewFrame(thisFrame).setVisible(true);
            }
        });
        
         newDialogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new NewDialog(thisFrame).setVisible(true);
            }
        });
        
        
    }
            
   
    public static void main(String[] args) {
    
        new ManyFrames().setVisible(true);
        
    }
    
}
