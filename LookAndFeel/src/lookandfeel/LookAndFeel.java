/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lookandfeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Maciek
 */
public class LookAndFeel extends JFrame{

    JPanel panelTop = new JPanel();
    JPanel panelCenter=new JPanel();
    JPanel panelBottom = new JPanel();
    JComboBox lookChanger = new JComboBox();
    JButton testBtn = new JButton("test");
    JRadioButton testRadioBtn = new JRadioButton("test");
    JCheckBox checkBoxBtn = new JCheckBox("test");
    JTextField testTextField = new JTextField("test",5);
    
    LookAndFeel()
    {
        
        initComponents();
    
    }
    
    void initComponents()
    {
    
      this.setBounds(300,300,300,150);
      this.setDefaultCloseOperation(3);
      
      this.getContentPane().add(panelTop,BorderLayout.NORTH);
      this.getContentPane().add(panelCenter,BorderLayout.CENTER);
      this.getContentPane().add(panelBottom,BorderLayout.SOUTH);
      
      panelTop.add(lookChanger);
      lookChanger.addItem("Windows");
      lookChanger.addItem("Motif");
      lookChanger.addItem("Metal");
      lookChanger.addItem("Macintosh");
      
      panelCenter.add(testBtn);
      panelCenter.add(testRadioBtn);
      
      panelBottom.add(checkBoxBtn);
      panelBottom.add(testTextField);
      
      
      lookChanger.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              
              String lookAndFeelName="";
              
             if (lookChanger.getSelectedItem().toString().equals("Windows"))
                 lookAndFeelName="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
             if (lookChanger.getSelectedItem().toString().equals("Metal"))
                 lookAndFeelName="javax.swing.plaf.metal.MetalLookAndFeel";
             if (lookChanger.getSelectedItem().toString().equals("Motif"))
                 lookAndFeelName="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
             if (lookChanger.getSelectedItem().toString().equals("Macintosh"))
                 lookAndFeelName=UIManager.getSystemLookAndFeelClassName();
            
              try {
                  UIManager.setLookAndFeel(lookAndFeelName);
                  SwingUtilities.updateComponentTreeUI(rootPane);
              } catch (ClassNotFoundException ex) {
              
              } catch (InstantiationException ex) {
                 
              } catch (IllegalAccessException ex) {
                
              } catch (UnsupportedLookAndFeelException ex) {
                  System.out.println("Unsuported");
              }
              
              
          }
      });
      
    
    }
    
    public static void main(String[] args) {
       
        new LookAndFeel().setVisible(true);
        
    }
    
}
