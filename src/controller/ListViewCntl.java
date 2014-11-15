/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FSE;
import cravings.FSEAddress;
import cravings.Food;
import cravings.FoodGenre;
import cravings.FoodGenreList;
import cravings.FoodList;
import cravings.VegFood;
import cravings.ViewType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import view.CreateFoodDialogue;
import view.CreateFseDialogue;
import view.ListView;
import view.MainFrameView;

/**
 *
 * @author Jackson Hofmann
 */
public class ListViewCntl {
    private CreateFoodDialogue foodDialog;
    private CreateFseDialogue fseDialog;
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
                   if(view.getViewType() == ViewType.FOOD)
                   {
                       java.awt.EventQueue.invokeLater(new Runnable() 
                            {
                                public void run() 
                                {
                                    FoodPopupListener theFoodListener = new FoodPopupListener();
                                    foodDialog = new CreateFoodDialogue();
                                    foodDialog.getSubmit().addActionListener(theFoodListener);
                                    foodDialog.getNewFoodName().setText(view.getCDText().getText());
                                    frame.getMainFrameCntl().getAuthenticationCntl().getFGList().refreshStringList();
                                    ArrayList<String> listOfGenres = frame.getMainFrameCntl().getAuthenticationCntl().getFGList().getTheFoodGenreStringList();
                                    String[] genres = listOfGenres.toArray(new String[listOfGenres.size()]);
                                    foodDialog.getGenreList().setModel(new DefaultComboBoxModel(genres));
                                    foodDialog.setVisible(true);
                                    foodDialog.setLocationRelativeTo(null);
                                    foodDialog.requestFocus();
                                }
                            });
                   }
                   else if(view.getViewType() == ViewType.FSE)
                   {
                       java.awt.EventQueue.invokeLater(new Runnable() 
                            {
                                public void run() 
                                {
                                    FsePopupListener theFseListener = new FsePopupListener();
                                    fseDialog = new CreateFseDialogue();
                                    fseDialog.getSubmit().addActionListener(theFseListener);
                                    fseDialog.getNewFseName().setText(view.getCDText().getText());
                                    fseDialog.setVisible(true);
                                    fseDialog.setLocationRelativeTo(null);
                                    fseDialog.requestFocus();
                                }
                            });
                   }
                    
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
            String name = foodDialog.getNewFoodName().getText();
            String description = foodDialog.getDescription().getText();
            String genre = foodDialog.getGenreList().getSelectedItem().toString();
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
            if(foodDialog.getNeitherRadio().isSelected())
            {
                newFood = new Food(code, name, genreCode, description);
            }
            if(foodDialog.getVeganRadio().isSelected())
            {
                newFood = new VegFood(code, name, genreCode, description, true, false);
            }
            if(foodDialog.getVegitRadio().isSelected())
            {
                newFood = new VegFood(code, name, genreCode, description, false, true);
            }
            tempAuth.getFoodList().getTheFoodList().add(newFood);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
            foodDialog.dispose();
        }
    }
    
    public class FsePopupListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String name = fseDialog.getNewFseName().getText();
            int houseNum = Integer.parseInt(fseDialog.getHouseNumField().getText());
            String street = fseDialog.getStreetField().getText();
            char[] state = fseDialog.getStateField().getText().toCharArray();
            int zipcode = Integer.parseInt(fseDialog.getZipCodeField().getText());
            String city = fseDialog.getCityField().getText();
            FSEAddress address = new FSEAddress(city, street, state, houseNum, zipcode);
            int[] openHour = new int[8], closeHour = new int[8];
            String hoursString = fseDialog.getHoursField().getText();
            String[] hours = hoursString.split("~");
            for(int i = 1; i < 7; i++)
            {
                String[] day = hours[i-1].split("-");
                openHour[i] = Integer.parseInt(day[0]);
                closeHour[i] = Integer.parseInt(day[1]);
            }
            int code = frame.getMainFrameCntl().getAuthenticationCntl().getFseList().getNextCode();
            FSE newFSE = new FSE(code, name, address, openHour, closeHour);
            AuthenticationCntl tempAuth = frame.getMainFrameCntl().getAuthenticationCntl();
            tempAuth.getFseList().getListOfFSEs().add(newFSE);
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
            fseDialog.dispose();
        }
    }
}
