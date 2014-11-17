/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.DayOfTheWeek;
import cravings.FSE;
import cravings.Food;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DetailView;
import view.MainFrameView;

/**
 *
 * @author Jackson Hofmann
 */
public class DetailViewCntl {
    DetailView view;
    MainFrameView frame;
    FSE theFse;
    Food theFood;
    public DetailViewCntl(DetailView view, MainFrameView frame, Food theFood)
    {
        this.view = view;
        this.frame = frame;
        this.theFood = theFood;
        initView();
    }
    public DetailViewCntl(DetailView view, MainFrameView frame, FSE theFse)
    {
        this.view = view;
        this.frame = frame;
        this.theFse = theFse;
        initView();
    }

    private void initView() {
        
        MainMenuButtonListener goBack = new MainMenuButtonListener();
        view.getMainMenuButton().addActionListener(goBack);
        
        switch(view.getViewType())
        {
            case FOOD:
                frame.getMainFrameCntl().setTitle("Food " + theFood.getCode());
                view.getDetailTitle().setText(theFood.getFoodName());
                view.getDetailSubTitle().setText(frame.getMainFrameCntl().getAuthenticationCntl().getFGList().getGenreByCode(theFood.getFoodGenreCode()).getName());
                view.getDetailDetails().setText(theFood.getFoodDescription());
                break;
            case FSE:
                frame.getMainFrameCntl().setTitle("FSE " + theFse.getCode());
                view.getDetailTitle().setText(theFse.getName());
                view.getDetailSubTitle().setText(theFse.getAddress().getShortValue());
                StringBuilder details = new StringBuilder();
                details.append("Address: ");
                details.append(theFse.getAddress().toString());
                details.append("\n");
                details.append("Hours:\n");
                for(int i = 1; i < 8; i++)
                {
                    switch(i)
                    {
                        case 1:
                            details.append("Sunday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.SUNDAY));
                            details.append("\n");
                            break;
                        case 2:
                            details.append("Monday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.MONDAY));
                            details.append("\n");
                            break;
                        case 3:
                            details.append("Tuesday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.TUESDAY));
                            details.append("\n");
                            break;
                        case 4:
                            details.append("Wednesday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.WEDNESDAY));
                            details.append("\n");
                            break;
                        case 5:
                            details.append("Thursday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.THURSDAY));
                            details.append("\n");
                            break;
                        case 6:
                            details.append("Friday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.FRIDAY));
                            details.append("\n");
                            break;
                        case 7:
                            details.append("Saturday: ");
                            details.append(theFse.getDayHours(DayOfTheWeek.SATURDAY));
                            details.append("\n");
                            break;
                            
                    }
                }
                view.getDetailDetails().setText(details + "");
                break;
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
    
}
