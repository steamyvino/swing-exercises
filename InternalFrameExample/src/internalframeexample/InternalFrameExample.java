/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalframeexample;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 *
 * @author Maciek
 */
public class InternalFrameExample extends JFrame {

    InternalFrameExample()
    {
    
        initComponents();
    
    }
    
    JDesktopPane desktop = new JDesktopPane();
    JInternalFrame intrlFrame = new JInternalFrame("test",true,true,true,true);

    
    
    
    public void initComponents()
    {
        
        this.setBounds(300,300,400,400);
        this.setDefaultCloseOperation(3); 
        this.getContentPane().add(desktop,BorderLayout.CENTER);
        
        intrlFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        intrlFrame.setVisible(true);
        intrlFrame.add(new JButton("test"));
        intrlFrame.pack();
        desktop.add(intrlFrame);
        
       
        intrlFrame.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent ife) {
                System.out.println("Opened");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent ife) {
               String answer= JOptionPane.showInternalInputDialog(ife.getInternalFrame(), "Write 'close' to close frame or 'exit' to exit the program");
               
               if (answer.equals("close"))
                       ife.getInternalFrame().dispose();
               if (answer.equals("exit"))
                       System.exit(0);
         
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent ife) {
                System.out.println("Closed");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent ife) {
                System.out.println("Iconified");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent ife) {
               System.out.println("Deiconified");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent ife) {
                System.out.println("Activated");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent ife) {
                System.out.println("Deactivated");
            }
        });
     
        
    }

    public static void main(String[] args) {
       
        new InternalFrameExample().setVisible(true);
        
    }
    
}
