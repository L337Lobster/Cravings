/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FSE;
import cravings.Food;
import cravings.FoodGenre;
import cravings.FoodGenreList;
import cravings.VegFood;
import cravings.ViewType;
import static cravings.ViewType.FSE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
                            ArrayList<String> listOfFse = frame.getMainFrameCntl().getAuthenticationCntl().getFseList().getStringListOfFSEs();
                            ArrayList<String> listOfGenres = frame.getMainFrameCntl().getAuthenticationCntl().getFGList().getTheFoodGenreStringList();
                            String[] locations = listOfFse.toArray(new String[listOfFse.size()]);
                            String[] genres = listOfGenres.toArray(new String[listOfGenres.size()]);
                            dialog.getFSEList().setModel(new DefaultComboBoxModel(locations));
                            dialog.getGenreList().setModel(new DefaultComboBoxModel(genres));
                            dialog.setVisible(true);
                            dialog.setLocationRelativeTo(null);
                            dialog.requestFocus();
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
            //if()
            FSE newFSE;
            FoodGenre newGenre;
            FoodGenreList theFGList = frame.getMainFrameCntl().getAuthenticationCntl().getFGList();
            Food newFood = null;
            AuthenticationCntl tempAuth = frame.getMainFrameCntl().getAuthenticationCntl();
            String name = dialog.getNewFoodName().getText();
            System.out.println("Name: "+name);
            String genre = dialog.getGenreList().getSelectedItem().toString();
            System.out.println("Genre: " + genre);
            String location = dialog.getFSEList().getSelectedItem().toString();
            System.out.println("Location: " + location);
            newFSE = new FSE(location);
            int genreCode = theFGList.getNextCode();
            if(!theFGList.getTheFoodGenreList().contains(genre))
            {
                newGenre = new FoodGenre(genreCode, genre);
                theFGList.getTheFoodGenreList().add(newGenre);
            }
            else
            {
                for(int i = 0; i < theFGList.getTheFoodGenreList().size(); i++)
                {
                    if(theFGList.getTheFoodGenreList().get(i).equals(genre))
                    {
                        newGenre = theFGList.getTheFoodGenreList().get(i);
                    }
                }
            }
            
            if(dialog.getNeitherRadio().isSelected())
            {
                newFood = new Food(name, newFSE, genreCode);
            }
            if(dialog.getVeganRadio().isSelected())
            {
                newFood = new VegFood(name, newFSE, genreCode, true, false);
            }
            if(dialog.getVegitRadio().isSelected())
            {
                newFood = new VegFood(name, newFSE, genreCode, false, true);
            }
            tempAuth.getFoodList().getTheFoodList().add(newFood);
            dialog.dispose();
        }
    }
}
