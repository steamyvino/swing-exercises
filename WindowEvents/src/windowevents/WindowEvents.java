
package windowevents;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Maciek
 */
public class WindowEvents extends JFrame implements WindowListener{

    
    WindowEvents()
    {
        initComponents();
    
    }

    void initComponents()
    {
    
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
    
    }
    
    
    
    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(rootPane,"Hello!");
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
        int input=JOptionPane.showConfirmDialog(rootPane,"Do you want to save your progress?","Save your work!",JOptionPane.YES_NO_CANCEL_OPTION);
        if (input==0)
        {
              JOptionPane.showMessageDialog(rootPane,"Progress saved");  
              this.dispose();
        }
        if (input==1)
              this.dispose();
      
               
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed, data saving");
    }

    @Override
    public void windowIconified(WindowEvent e) {
         System.out.println("Window minimized");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       System.out.println("Window maximized");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window active");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window inactive");
    }
  
    
     public static void main(String[] args) {
       new WindowEvents().setVisible(true);
    }
}
