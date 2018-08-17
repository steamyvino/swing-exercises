/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Maciek
 */
public class Main extends JFrame{

    private JPanel panel = new JPanel();
    private JComboBox comboList = new JComboBox();
    
    
    Main()
    {
        super("ComboBox Example");
        initComponents();
    
    }
    
    void initComponents()
    {
        
        this.setBounds(300,300,300,200);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(panel);
        comboList.addItem(new ColorHandler(Color.RED,"Red"));
        comboList.addItem(new ColorHandler(Color.GREEN,"Green"));
        comboList.addItem(new ColorHandler(Color.BLUE,"Blue"));
        comboList.addItem(new ColorHandler(Color.BLACK,"Black"));
        comboList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                ColorHandler colorChanger = (ColorHandler)comboList.getSelectedItem();
                comboList.setBackground(colorChanger.color);
               
                System.out.println(colorChanger.colorName);           
                
                //Casting 
                panel.setBackground(((ColorHandler)comboList.getSelectedItem()).color);
                
            }
        });
        
        panel.add(comboList);
    }
    
    private class ColorHandler
    {
       private Color color;
       private String colorName;
       
       ColorHandler(Color color, String colorName)
       {
           
           this.color=color;
           this.colorName=colorName;
         
       }
      
       
       
       @Override
       public String toString()
       {
       
           return this.colorName;
       
       }
        
    }
    
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
    
}
