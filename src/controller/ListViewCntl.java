/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FSE;
import cravings.ViewType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import view.CreateFoodDialogue;
import view.ListView;
import view.MainFrameView;

/**
 *
 * @author Jackson Hofmann
 */
public class ListViewCntl {
    private CreateFoodDialogue dialog;
    private ListView view;
    private MainFrameView frame;
    
    public ListViewCntl(ListView view, MainFrameView frame)
    {
        this.view = view;
        this.frame = frame;
        initView();
    }
    
    public void initView()
    {
        
        ViewType listType = view.getViewType();
        if(listType.toString().equalsIgnoreCase("fse"))
        {
            frame.getMainFrameCntl().setTitle("FSE List");
            view.getCDLabel().setText("FSE Name:");
        }
        else if(listType.toString().equalsIgnoreCase("food"))
        {
            frame.getMainFrameCntl().setTitle("Food List");
            view.getCDLabel().setText("Food Name:");
        }
        else
        {
            frame.getMainFrameCntl().setTitle("Default");
            view.getCDLabel().setText("Default");
        }
        CDListener theCDListener = new CDListener();
        UpdateListener theUpdateListener = new UpdateListener();
        view.getCDButton().addActionListener(theCDListener);
        view.getUpdateButton().addActionListener(theUpdateListener);
        
    }
    
    public class UpdateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    public class CDListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch(view.getCDAction().getSelectedIndex())
            {
                case 0:
                    JOptionPane.showMessageDialog(view,"Please select an action");
                    break;
                case 1: //create
                    java.awt.EventQueue.invokeLater(new Runnable() 
                    {
                        public void run() 
                        {
                            FoodPopupListener theFoodListener = new FoodPopupListener();
                            dialog = new CreateFoodDialogue();
                            dialog.getSubmit().addActionListener(theFoodListener);
                            dialog.getNewFoodName().setText(view.getCDText().getText());
                            //dialog.setUndecorated(true);
                            ArrayList<String> listOfFse = frame.getMainFrameCntl().getAuthenticationCntl().getFseList().getStringListOfFSEs();
                            String[] locations = listOfFse.toArray(new String[listOfFse.size()]);
                            dialog.getFSEList().setModel(new DefaultComboBoxModel(locations));
                            dialog.setVisible(true);
                        }
                    });
                    //newFood.setUndecorated(true);
                    
                    break;
                case 2: //delete
                    break;

            }
        }
    }
    
    public class FoodPopupListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dialog.dispose();
        }
    }
}
