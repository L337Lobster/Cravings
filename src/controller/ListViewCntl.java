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
import cravings.FoodList;
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
        MainMenuButtonListener backListener = new MainMenuButtonListener();
        UpdateListener theUpdateListener = new UpdateListener();
        view.getMainMenu().addActionListener(backListener);
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
                            ArrayList<String> listOfGenres = frame.getMainFrameCntl().getAuthenticationCntl().getFGList().getTheFoodGenreStringList();
                            String[] genres = listOfGenres.toArray(new String[listOfGenres.size()]);
                            dialog.getGenreList().setModel(new DefaultComboBoxModel(genres));
                            dialog.setVisible(true);
                            dialog.setLocationRelativeTo(null);
                            dialog.requestFocus();
                        }
                    });
                    
                    break;
                case 2: //delete
                    break;

            }
        }
    }
    public class MainMenuButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            frame.getMainFrameCntl().getAuthenticationCntl().showMainMenuUI(view);
        }
    }
    public class FoodPopupListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            FoodGenre newGenre;
            FoodGenreList theFGList = frame.getMainFrameCntl().getAuthenticationCntl().getFGList();
            FoodList theFoodList = frame.getMainFrameCntl().getAuthenticationCntl().getFoodList();
            Food newFood = null;
            AuthenticationCntl tempAuth = frame.getMainFrameCntl().getAuthenticationCntl();
            String name = dialog.getNewFoodName().getText();
            String description = dialog.getDescription().getText();
            System.out.println("Name: "+name);
            String genre = dialog.getGenreList().getSelectedItem().toString();
            System.out.println("Genre: " + genre);
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
            int code = theFoodList.getNextCode();
            if(dialog.getNeitherRadio().isSelected())
            {
                newFood = new Food(code, name, genreCode, description);
            }
            if(dialog.getVeganRadio().isSelected())
            {
                newFood = new VegFood(code, name, genreCode, description, true, false);
            }
            if(dialog.getVegitRadio().isSelected())
            {
                newFood = new VegFood(code, name, genreCode, description, false, true);
            }
            tempAuth.getFoodList().getTheFoodList().add(newFood);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
            dialog.dispose();
        }
    }
}
