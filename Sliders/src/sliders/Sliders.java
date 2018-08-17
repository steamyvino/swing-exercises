/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliders;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;



public class Sliders extends JFrame {

    
    JPanel sliderPanel = new JPanel(new BorderLayout());
    JPanel colorPanel = new JPanel();
   
    JSlider redSlider = new JSlider(0,255);
    JSlider greenSlider = new JSlider(0,255);
    JSlider blueSlider = new JSlider(0,255);
   
    
    Sliders()
    {
        initComponents();
    }
    
    void initComponents()
    {
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(3);
        this.setLayout(new GridLayout(2,1));
        this.getContentPane().add(sliderPanel);
        this.getContentPane().add(colorPanel);
        sliderPanel.setLayout(new GridLayout(3,2));
        sliderPanel.add(new JLabel("  red"));
        sliderPanel.add(redSlider);
        sliderPanel.add(new JLabel("  green"));
        sliderPanel.add(greenSlider);
        sliderPanel.add(new JLabel("  blue"));
        sliderPanel.add(blueSlider);
        redSlider.setMajorTickSpacing(255);
        redSlider.setPaintLabels(true);
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setPaintLabels(true);
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setPaintLabels(true);
        
        colorPanel.setBackground(new Color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue()));
        
        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 Color color = new Color(((JSlider)e.getSource()).getValue(),colorPanel.getBackground().getGreen(),colorPanel.getBackground().getBlue());     
                 colorPanel.setBackground(color);
            }
         });
         greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 Color color = new Color(colorPanel.getBackground().getRed(),((JSlider)e.getSource()).getValue(),colorPanel.getBackground().getBlue());     
                 colorPanel.setBackground(color);
            }
         });
          blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 Color color = new Color(colorPanel.getBackground().getRed(),colorPanel.getBackground().getGreen(),((JSlider)e.getSource()).getValue());     
                 colorPanel.setBackground(color);
            }
         });
        
        
    }
    public static void main(String[] args) {
        new Sliders().setVisible(true);
    }
    
}
