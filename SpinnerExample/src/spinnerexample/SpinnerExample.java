/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spinnerexample;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Maciek
 */
public class SpinnerExample extends JFrame{

    SpinnerExample()
    {
       
        initComponents();
    
    }
    
    void initComponents()
    {
    
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(3);
      
        
        String[] months = new DateFormatSymbols().getMonths();
        //SpinnerListModel monthsModel = new SpinnerListModel(months); 
      
        MySpinnerListModel monthsModel = new MySpinnerListModel(cutArray(months,0,11));
        JSpinner spinner = new JSpinner(monthsModel);
        
        SpinnerNumberModel numberModel = new SpinnerNumberModel(2,1,5,1);
        JSpinner spinner2 = new JSpinner(numberModel);
        
        
        Calendar calendarItem = Calendar.getInstance();
        
        Date startingTime  = calendarItem.getTime();
        calendarItem.add(Calendar.DAY_OF_MONTH, -20);
        Date minimalTime = calendarItem.getTime();
        calendarItem.add(Calendar.DAY_OF_MONTH, 40);
        Date maximalTime = calendarItem.getTime();
                
        
        SpinnerDateModel dateModel = new SpinnerDateModel(startingTime,minimalTime,maximalTime,Calendar.DAY_OF_MONTH);
        JSpinner spinner3 = new JSpinner(dateModel);
        
       
        JPanel panel = new JPanel();
        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);
        
        this.getContentPane().add(panel,BorderLayout.NORTH);
        
        
    
    }
    
    
    private class MySpinnerListModel extends SpinnerListModel
    {
        
        public MySpinnerListModel(Object[] values)
        {
        
            super(values);
            this.firstValue = values[0];
            this.lastValue = values[values.length-1];
        }
    
        Object firstValue, lastValue;
        
        @Override
        public Object getNextValue()
        {
        
            if (super.getNextValue()==null)
                return firstValue;
            else
            return super.getNextValue();
        
        }
        @Override
        public Object getPreviousValue()
        {
            if (super.getPreviousValue()==null)
                return lastValue;
            else
            return super.getPreviousValue();
        
        }
        
    }
    
    public Object[] cutArray(Object[] arr,int beginCut, int endCut)
    {
        
   
        
        Object[] arr2= new Object[endCut+1-beginCut];
        
        for(int i=beginCut,j=0;i<endCut+1;i++,j++)
            arr2[j]=arr[i];


        return arr2;
    }
    
    public static void main(String[] args) {
        
        new SpinnerExample().setVisible(true);
        
    }
    
}
