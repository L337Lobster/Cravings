/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import java.awt.event.*;
import model.MainFrameModel;
import javax.swing.*;
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
    public int mouseX, mouseY, mouseX2,mouseY2;
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
        initClosePanel();
        
    }
    public void initClosePanel()
    {
        JPanel close = new JPanel();
        close.setBackground(Color.blue);
        CloseListener closeListen = new CloseListener();
        MoveWindowListener moveWindow = new MoveWindowListener();
        close.addMouseMotionListener(moveWindow);
        JButton exit = new JButton("<html><center>X</center></html>");
        exit.setMargin(new Insets(0,-30, 0,-30));
        exit.setFont(exit.getFont().deriveFont(20.0f));
        exit.setBackground(Color.red);
        exit.addActionListener(closeListen);
        close.setLayout(null);
        close.add(exit);
        close.setPreferredSize(new Dimension(view.getWidth(),25));
        exit.setBounds(new Rectangle(view.getWidth()-25, 0, 25,25));
        view.add(close, "North");
        
    }
    /**
     * Initializes the splash screen.
     * Creates the SplashView<br>
     * Creates the SplashModel<br>
     * Creates the SplashCntl
     */
    public void initCustomComponents()
    {
        SplashView splashScreen = new SplashView();
        SplashModel theSplashModel = new SplashModel();
        SplashCntl theSplashCntl = new SplashCntl(splashScreen, theSplashModel, view);
    }
    /**
     * Replaces the old panel with the new panel.
     * @param oldPanel old JPanel
     * @param newPanel new JPanel
     */
    public void replacePanel(JPanel oldPanel, JPanel newPanel)
    {
        view.remove(oldPanel);
        view.add(newPanel,"Center");
        view.revalidate();
        view.repaint();
    }
    /**
     * Adds the JPanel panel to the frame at a specific position.
     * @param panel A JPanel to add to the frame.
     * @param position A String for the BorderLayout position.
     */
    public void addPanel(JPanel panel, String position)
    {
        view.add(panel, position);
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
    
    public class CloseListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    public class MoveWindowListener implements MouseMotionListener
    {
        boolean test = true;
        int differenceX, differenceY;
        @Override
        public void mouseDragged(MouseEvent me) {
            if(test)
            {
                mouseX = me.getX();
                mouseY = me.getY();
                test = false;
            }
            else
            {
                mouseX2 = me.getX();
                mouseY2 = me.getY();
                test = true;
            }
            differenceX = mouseX - mouseX2;
            differenceY = mouseY - mouseY2;
            Point current = view.getLocation();
            if(test)
            {
            view.setLocation(current.x-differenceX, current.y-differenceY);
            
            }
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            if(test)
            {
                mouseX = me.getX();
                mouseY = me.getY();
                test = false;
            }
            else
            {
                mouseX2 = me.getX();
                mouseY2 = me.getY();
                test = true;
            }
        }
        
    }
    
}
