/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Maciek
 */
public class ListExample extends JFrame {

    ListExample()
    {
    
        initComponents();
    
    }
    
    JPanel listPanel=new JPanel();
    JPanel labelPanel=new JPanel();
    JLabel desc=new JLabel();
    String[] foods = {"Cake", "Pie", "Marshmallow", "IceCream", "Oreo", "CandyBar","Cookie","Brownie"};
    JList listOfFood = new JList(foods);
    JScrollPane scrollListOfFood = new JScrollPane(listOfFood);
   
    /**
     * Better way to create list;
     */
    DefaultListModel defaultListOfLetters = new DefaultListModel();
    JList listOfLetters = new JList(defaultListOfLetters);
    
    void initComponents()
    {
    
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(3);
        listOfFood.setVisibleRowCount(4);    
        this.getContentPane().add(listPanel,BorderLayout.NORTH);
        this.getContentPane().add(labelPanel,BorderLayout.CENTER);
        labelPanel.add(desc);
        
        listPanel.add(scrollListOfFood);
        
        listOfFood.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
               if(!lse.getValueIsAdjusting())
               {
                 
                   List listOfChosenFoods = ((JList)lse.getSource()).getSelectedValuesList();
                   Iterator<String> it = listOfChosenFoods.iterator();
                   String chosenFoods="";
                   while(it.hasNext())
                   {
                       chosenFoods+=it.next();
                       chosenFoods+=", ";
                   }
                   desc.setText("I like: " + chosenFoods);
                   
               }
            }
        });
        
        defaultListOfLetters.addElement("A");
        defaultListOfLetters.addElement("B");
        defaultListOfLetters.addElement("C");
        defaultListOfLetters.addElement("D");
        
        this.getContentPane().add(listOfLetters);
      listOfLetters.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
               
                
                defaultListOfLetters.removeElement(((JList)lse.getSource()).getSelectedValue());
            }
        });
        
    
    }
  
    public static void main(String[] args) {
       
        new ListExample().setVisible(true);
        
    }
    
}
