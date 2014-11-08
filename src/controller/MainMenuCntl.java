/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    }
    
    public void initBounds()
    {
        view.getFoodButton();
    }
    
    
}
