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
import model.LoginModel;
import model.SplashModel;
import view.LoginView;
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
    /**
     * Constructor for the Splash controller.
     * Sets the view, model, and parent frame.<br>
     * Creates a timer used to display the splash panel for a certain amount of time.<br>
     * Initializes the view<br>
     * Adds the view to the frame.<br>
     * Starts the display timer.
     * @param view View being controlled.
     * @param model Model being controlled.
     * @param frame Parent JFrame.
     */
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
    /**
     * Initializes the View.
     * Set the LayoutManager to null.<br>
     * Set the following to match the model:
     * <ul>
     * <li>SplashImage
     * <li>SplashLabel
     * <li>SplashLabel Icon
     * </ul>
     * Adds the SplashLabel to the view.<br>
     * Sets the bounds of the Label.
     */
    public void initView()
    {
        view.setViewLayout(null);
        view.setSplashImage(model.getSplashImage());
        view.setSplashLabel(model.getSplashLabel());
        view.getSplashLabel().setIcon(model.getSplashImage());
        view.add(view.getSplashLabel());
        view.getSplashLabel().setBounds(new Rectangle(20,75, 550, 550));
    }
    /**
     * Anonymous class used to listen to the timer.
     * Once the timer delay finishes once the timer is stopped.<br>
     * The SplashView is then replaced with the LoginView
     */
    public class TimerListener implements ActionListener
    {

        /**
         * Triggered when the timer delay is finished.
         * @param ae ActionEvent for the timer.
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            displayTime.stop();
            LoginView theLoginView = new LoginView();
            LoginModel theLoginModel = new LoginModel();
            LoginCntl theLoginCntl = new LoginCntl(theLoginView, theLoginModel, frame);
            theLoginCntl.initView();
        }
        
        
    }
}
