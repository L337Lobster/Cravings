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
    
    public MainFrameCntl(MainFrameView view, MainFrameModel model)
    {
        this.view = view;
        this.model = model;
    }
    public void initView()
    {
        view.setTitle(model.getTitle());
        view.setSize(model.getWidth(), model.getHeight());
        view.setHeight(model.getHeight());
        view.setWidth(model.getWidth());
        view.setMainFrameCntl(this);
    }
    public void initCustomComponents()
    {
        SplashView splashScreen = new SplashView();
        SplashModel theSplashModel = new SplashModel();
        SplashCntl theSplashCntl = new SplashCntl(splashScreen, theSplashModel, view);
    }
    public void replacePanel(JPanel oldPanel, JPanel newPanel)
    {
        view.remove(oldPanel);
        view.add(newPanel);
        view.revalidate();
        view.repaint();
    }
    public void addPanel(JPanel panel)
    {
        view.add(panel);
        view.revalidate();
        view.repaint();
    }
    
}
