/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.ViewType;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MainMenuModel;
import view.MainFrameView;
import view.MainMenuView;

/**
 *
 * @author Jackson Hofmann
 */
public class MainMenuCntl {
    
    private MainMenuView view;
    private MainMenuModel model;
    private MainFrameView frame;
    /**
     * Constructor that sets the view and model.
     * @param view Controlled view
     * @param model Controlled model
     */
    public MainMenuCntl(MainMenuView view, MainMenuModel model, MainFrameView frame)
    {
        this.view = view;
        this.model = model;
        this.frame = frame;
        initView();
        initBounds();
    }
    
    public void initView()
    {
        frame.getMainFrameCntl().getView().setSizeValues(model.getSizeValue().width, model.getSizeValue().height);
        frame.getMainFrameCntl().getView().refreshSize();
        frame.getMainFrameCntl().refreshCloseSize();
        frame.getMainFrameCntl().setTitle("Main Menu");
        
        view.setFindFoodButton(model.getFindFoodButton());
        view.setFoodButton(model.getFoodButton());
        view.setFseButton(model.getFseButton());
        view.setQuitButton(model.getQuitButton());
        
        view.getQuitButton().addActionListener(frame.getMainFrameCntl().getCloseListener());
        
        view.setLayoutManager(null);
        
        frame.getRootPane().setDefaultButton(null);
        
        view.setMainMenuCntl(this);
        
        view.add(view.getFindFoodButton());
        view.add(view.getFoodButton());
        view.add(view.getFseButton());
        view.add(view.getQuitButton());
        
        FoodButtonListener theFoodListener = new FoodButtonListener();
        view.getFoodButton().addActionListener(theFoodListener);
        FseButtonListener theFseListener = new FseButtonListener();
        view.getFseButton().addActionListener(theFseListener);
        FindFoodButtonListener theFindListener = new FindFoodButtonListener();
        view.getFindFoodButton().addActionListener(theFindListener);
    }
    
    public void initBounds()
    {
        view.getFoodButton().setBounds(new Rectangle(0,0,model.getSizeValue().width/2,model.getSizeValue().height/2));
        view.getFseButton().setBounds(new Rectangle(model.getSizeValue().width/2,0,model.getSizeValue().width/2,model.getSizeValue().height/2));
        view.getFindFoodButton().setBounds(new Rectangle(0,model.getSizeValue().height/2,model.getSizeValue().width/2,model.getSizeValue().height/2));
        view.getQuitButton().setBounds(new Rectangle(model.getSizeValue().width/2,model.getSizeValue().height/2,model.getSizeValue().width/2,model.getSizeValue().height/2));
    }
    public class FindFoodButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.getMainFrameCntl().getAuthenticationCntl().showFindFoodView(view);
        }
        
    }
    public class FoodButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.getMainFrameCntl().getAuthenticationCntl().showListView(ViewType.FOOD, view);
        }
    }
    public class FseButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.getMainFrameCntl().getAuthenticationCntl().showListView(ViewType.FSE, view);
        }
    }
    
}
