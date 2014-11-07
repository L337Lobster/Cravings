/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MainFrameModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.SplashModel;
import view.MainFrameView;
import view.SplashView;

/**
 *
 * @author Jackson Hofmann
 */
public class MainFrameCntl {
    private MainFrameView view;
    private MainFrameModel model;
    /**
     * Sets the instance variables to the model and view that were passed.
     * @param view The MainFrameView that is being controlled.
     * @param model The MainFrameModel that is being controlled.
     */
    public MainFrameCntl(MainFrameView view, MainFrameModel model)
    {
        this.view = view;
        this.model = model;
    }
    /**
     * Initializes the view.
     * Does the following:
     * <ul>
     * <li>Set the view's title to the model's title
     * <li>Set the view's size to the model's size
     * <li>Sets the view's width and height to the model's width and height
     * <li>Sets this as the controller for the view.
     * </ul>
     */
    public void initView()
    {
        view.setTitle(model.getTitle());
        view.setSize(model.getWidth(), model.getHeight());
        view.setHeight(model.getHeight());
        view.setWidth(model.getWidth());
        view.setMainFrameCntl(this);
    }
    /**
     * Initalizes the splash screen.
     * Creates the SplashView<br>
     * Creates the SplashModel<br>
     * Creates the SplashCntl
     */
    public void initCustomComponents()
    {
        SplashView splashScreen = new SplashView();
        SplashModel theSplashModel = new SplashModel();
        SplashCntl theSplashCntl = new SplashCntl(splashScreen, theSplashModel, view);
    }/**
     * Replaces the old panel with the new panel.
     * @param oldPanel old JPanel
     * @param newPanel new JPanel
     */
    public void replacePanel(JPanel oldPanel, JPanel newPanel)
    {
        view.remove(oldPanel);
        view.add(newPanel);
        view.revalidate();
        view.repaint();
    }
    /**
     * Adds the JPanel panel to the frame
     * @param panel A JPanel to add to the frame.
     */
    public void addPanel(JPanel panel)
    {
        view.add(panel);
        view.revalidate();
        view.repaint();
    }
    
}
