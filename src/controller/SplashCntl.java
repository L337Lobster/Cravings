/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.SplashModel;
import view.MainFrameView;
import view.SplashView;

/**
 *
 * @author Jackson Hofmann
 */
public class SplashCntl {
    Timer displayTime;
    private MainFrameView frame;
    private SplashView view;
    private SplashModel model;
    public SplashCntl(SplashView view, SplashModel model, MainFrameView frame)
    {
        this.view = view;
        this.model = model;
        this.frame = frame;
        TimerListener tick = new TimerListener();
        displayTime = new Timer(5000, tick);
        initView();
        //initTest();
        this.frame.getMainFrameCntl().addPanel(this.view);
        displayTime.start();
        
    }
    public void initView()
    {
        view.setViewLayout(null);
        view.setSplashImage(model.getSplashImage());
        view.setSplashLabel(model.getSplashLabel());
        view.getSplashLabel().setIcon(model.getSplashImage());
        view.add(view.getSplashLabel());
        view.getSplashLabel().setBounds(new Rectangle(20,75, 550, 550));
    }
    public class TimerListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            displayTime.stop();
            JPanel panel = new JPanel();
            JLabel test = new JLabel("Test");
            panel.add(test);
            frame.getMainFrameCntl().replacePanel(view, panel);
            
        }
        
        
    }
}
