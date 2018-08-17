/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Maciek
 */
public class TabExample extends JFrame{

    TabExample()
    {
    
        initComponents();
    
    }
    
    private JTabbedPane tabs = new JTabbedPane();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel createTabPanel = new JPanel();

    public void initComponents()
    {
    
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(3);
      
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        tabs.addTab("Tab1", new JLabel("Tab1"));
        tabs.setMnemonicAt(0, KeyEvent.VK_T);   //Alt must be pressed
        tabs.addTab("Tab2", new ImageIcon("save.png"), panel1, "this is tab2"); 
        tabs.addTab("tab3",panel2);
        
        JLabel createTabLabel = new JLabel("Name of te file");
        JTextField createTabTextField = new JTextField(10);
        JButton createTabButton = new JButton("Create");
        JTextArea textArea = new JTextArea();
        
        panel2.add(createTabLabel);
        panel2.add(createTabTextField);
        panel2.add(createTabButton);
        
        createTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               tabs.addTab(createTabTextField.getText(), textArea);
               tabs.setSelectedIndex(tabs.getTabCount()-1);
               
               textArea.addKeyListener(new KeyAdapter() {
     
        
                @Override
                public void keyPressed(KeyEvent e)
                {


                    if (!(tabName+e.getKeyChar()).equals(textProgression) && isItAscii(e.getKeyChar()) && (flagSave))
                    {
                        System.out.println("nowy content");
                        textProgression=tabName+e.getKeyChar();
                        tabs.setTitleAt(tabIndex, tabName+"*");
                        flagSave=false;

                    }
                    else if (e.isControlDown() && e.getKeyCode()== KeyEvent.VK_S && isItAscii(e.getKeyChar()) && !flagSave)
                    {
                        System.out.println("zapisuje");   
                        tabs.setTitleAt(tabIndex, tabName);
                        flagSave=true;

                    }

                }

                public boolean isItAscii(char ch)
                {

                    for(int i=0;i<255;i++)
                    {
                        if(ch==i)
                        {
                            System.out.println("it is Ascii");
                            return true;

                        }

                    }

                    return false;


                }

                boolean flagSave=true;
                String textProgression="";       
                int tabIndex = tabs.getSelectedIndex();
                String tabName = tabs.getTitleAt(tabIndex);

            });
               
            }
        });
        
       
        
        
        
        this.getContentPane().add(tabs);
       
    }
    
    
    public static void main(String[] args) {
        
        new TabExample().setVisible(true);
        
    }
    
}
