/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FSE;
import cravings.Food;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.FindFoodView;
import view.MainFrameView;

/**
 *
 * @author Jackson Hofmann
 */
public class FindFoodCntl {
    FindFoodView view;
    MainFrameView frame;
    
    public FindFoodCntl(FindFoodView view, MainFrameView frame)
    {
        this.frame = frame;
        this.view = view;
        FindButtonListener findListener = new FindButtonListener();
        view.getFindButton().addActionListener(findListener);
    }
    
    public class FindButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int row = view.getFindFoodTable().getSelectedRow();
            Food temp = frame.getMainFrameCntl().getAuthenticationCntl().getFoodList().getFoodByCode(Integer.parseInt((String)view.getFindFoodTable().getValueAt(row, 0)));
            ArrayList<FSE> listFse = frame.getMainFrameCntl().getAuthenticationCntl().getFseList().getListOfFSEs();
            boolean found = false;
            for(int i = 0; i < listFse.size(); i++)
            {
                for(int j =0; j < listFse.get(i).getMenu().getMenu().size(); j++)
                {
                    
                    if(temp.getCode() == listFse.get(i).getMenu().getMenu().get(j).getCode())
                    {
                        JOptionPane.showMessageDialog(view, temp.getFoodName() + " can be found at: " + listFse.get(i).getName());
                        found = true;
                    }
                }
            }
            if(!found)
            {
                JOptionPane.showMessageDialog(view, temp.getFoodName() + " cannot be found. :(");
            }
        }

    }
    
}
