/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitpaneexample;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SplitPaneExample extends JFrame{

  
    SplitPaneExample()
    {
    
        initComponents();
    
    }
    
    
    JList imageNames = new JList(new Image[]
    {
    new Image("Apple","This is Apple"),
    new Image("Orange","This is Orange"),
    new Image("Banana","Banana")
 
    });

    JPanel namePanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JLabel imageLabel = new JLabel();
    JPanel descPanel = new JPanel();
    JLabel descLabel = new JLabel();
    
    public void initComponents()
    {
        
        this.setBounds(300,300,800,800);
        this.setDefaultCloseOperation(3);
        
        JSplitPane splitOne = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,namePanel,imagePanel);
        JSplitPane splitMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitOne,descPanel);
        this.getContentPane().add(splitMain);
        
        imagePanel.add(imageLabel);
        descPanel.add(descLabel);
        
        namePanel.add(imageNames);
        splitOne.setDividerLocation(100);
        splitMain.setDividerLocation(400);
        
        imageNames.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
               
                Image tmp = (Image)((JList)lse.getSource()).getSelectedValue();
                
                imageLabel.setIcon(tmp.returnImage());
                descLabel.setText(tmp.returnDesc());
                
               
                
            }
        });
    
        
        
        
    }
    
    public class Image 
    {
        String name,desc;
        ImageIcon icon;
    
        Image(String name,String desc)
        {
        
            this.name=name;
            this.desc=desc;
            
            icon = new ImageIcon(name+".png");
           
        }
    
        ImageIcon returnImage()
        {
        
            return icon;
        
        }
        
        String returnDesc()
        {
        
            return desc;
        
        }
        
        @Override
        public String toString()
        {
        
            return name;
            
        }
    }
    
    
    public static void main(String[] args) {
        new SplitPaneExample().setVisible(true);
    }
    
}
