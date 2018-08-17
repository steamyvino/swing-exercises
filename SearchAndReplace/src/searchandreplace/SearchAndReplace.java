/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchandreplace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maciek
 */
public class SearchAndReplace extends JFrame{

    SearchAndReplace()
    {
    
        this.setBounds(300,300,250,300);
        this.setDefaultCloseOperation(3);
        initComponents();
    
    }
    
    JTextArea textField = new JTextArea("This is test text in text area. ",4,2);
    JScrollPane oknoPrzewijania = new JScrollPane(textField);
    JPanel findPanel = new JPanel();
    JButton findBtn = new JButton ("    Find    ");
    JTextField findField = new JTextField(10);
    
    
    JButton replaceBtn = new JButton ("Replace");
    JTextField replaceField = new JTextField(10);
    
    JButton replaceAllBtn = new JButton ("Replace all");
    
    
    
    void initComponents()
    {
        this.getContentPane().add(oknoPrzewijania,BorderLayout.NORTH);
        this.getContentPane().add(findPanel,BorderLayout.CENTER);
        findPanel.add(findBtn);
        findPanel.add(findField);
        findBtn.addActionListener(new FindBtnHandler());
        
        findPanel.add(replaceBtn);
        findPanel.add(replaceField);
         
        replaceBtn.addActionListener(new ReplaceBtnHandler());
        findPanel.add(replaceAllBtn);
        
        replaceAllBtn.addActionListener(new ReplaceAllBtnHandler());
    
        // textField.selectAll(); //- zaznacza cały tekst
        // textField.select(0, 2);// - zaznacza obszar, podany od kąd do kąd
        // textField.replaceSelection("lala"); - zamienić obszar, który jest zaznaczony
        // textField.replaceRange("lala", 0, 3); - range z ang. zasięg, podmieniamy na string z danego obszaru
        // textField.insert("jakis tam", 18);
        // textField.append("dolaczone do konca");
        // textField.select(textField.getText().indexOf("test"), textField.getText().indexOf("test")+"test".length());
    }
    
    class FindBtnHandler implements ActionListener
    {
       private int selectionStart=0;
       
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           textField.select(0, 0);
           String textToFind=findField.getText();
           selectionStart=textField.getText().indexOf(textToFind, selectionStart+textToFind.length());
           System.out.println(selectionStart);
           System.out.println(textToFind);
          
           if (selectionStart == -1)         
                selectionStart = textField.getText().indexOf(textToFind);
           
           if (selectionStart > 0)
           { 
                textField.requestFocus();
                System.out.println("zazanczamami");
                textField.select(selectionStart,selectionStart+textToFind.length());
           }
            
        }

    }
    
    class ReplaceBtnHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField.getSelectedText()!=null)
            textField.replaceSelection(replaceField.getText());
        }
       

    }
    
    
    class ReplaceAllBtnHandler implements ActionListener
    {
        
        private int selectionStart=0;

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String textToReplace=findField.getText();
            String replacementText=replaceField.getText();
            
            int choice = JOptionPane.showConfirmDialog(rootPane, "Do you want to replace "+ textToReplace +" with "+ replacementText +" ?", "Are you sure?", JOptionPane.YES_NO_OPTION);
            if(choice ==0)
            {
                while(textField.getText().contains(textToReplace))
                {
                    selectionStart=textField.getText().indexOf(textToReplace, selectionStart+textToReplace.length());
                    textField.select(selectionStart,selectionStart+textToReplace.length());
                    textField.replaceSelection(replacementText);
                }   
            }    
        }
       

    }
    
    
    public static void main(String[] args) {
     
        new SearchAndReplace().setVisible(true);
        
        
        
    }
    
}
