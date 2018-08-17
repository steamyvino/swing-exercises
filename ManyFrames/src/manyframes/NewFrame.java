/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyframes;

import javax.swing.*;
import java.awt.*;

public class NewFrame extends JFrame{

    private int width,height;
    private static int i=1;
    
    NewFrame(JFrame parent)
    {
        
        initComponents();
        int frameWidth=(int)parent.getBounds().getWidth();
        int frameHeight=(int)parent.getBounds().getHeight();
        this.width=this.getSize().width;
        this.height=this.getSize().height;
        this.setLocation(parent.getBounds().x+(frameWidth-width)/2,parent.getBounds().y+(frameHeight-height)/2);
        
       
    
    }
    
    void initComponents()
    {
        this.setTitle("This is frame "+(i++));
        this.setBounds(12,12,200,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        
        
        
    }
}