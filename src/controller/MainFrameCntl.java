/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.SerializedDataCntl;
import cravings.ViewType;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.MainFrameModel;
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
    private JPanel close;
    private JButton exit;
    private JLabel title;
    private AuthenticationCntl theAuthenticationCntl;
    public int mouseX, mouseY, mouseX2,mouseY2;
    private CloseListener closeListen = new CloseListener();
    /**
     * Sets the instance variables to the model and view that were passed.
     * @param view The MainFrameView that is being controlled.
     * @param model The MainFrameModel that is being controlled.
     */
    public MainFrameCntl(MainFrameView view, MainFrameModel model)
    {
        this.view = view;
        this.model = model;
        initView();
        initClosePanel();
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
        view.setSize(model.getWidth(), model.getHeight());
        view.setHeight(model.getHeight());
        view.setWidth(model.getWidth());
        view.setMainFrameCntl(this);
        
    }
    public void refreshCloseSize()
    {
        exit.setBounds(new Rectangle(view.getWidth()-44, 0, 45,17));
        title.setBounds(new Rectangle(0, 0, view.getWidth()-25, 25));
    }
    /**
     * Creates the title bar and adds it to the North of the frame.
     */
    public void initClosePanel()
    {
        //Create a JPanel to replace the top bar.
        close = new JPanel();
        //Set the background color of the panel so it's noticible
        close.setBackground(new Color(200,61,255));
        //Create the close listener and the move listener
        MoveWindowListener moveWindow = new MoveWindowListener();
        
        //Create a JLabel to replace the title and a button to replace the close button
        title = new JLabel("<html><center>"+model.getTitle()+"</center></html>", JLabel.CENTER);
        exit = new JButton("<html><center>X</center></html>");
        
        //add the listeners to the panel and the button
        close.addMouseMotionListener(moveWindow);
        exit.addActionListener(closeListen);
        
        //remove the margins from the button so that the X is centered
        exit.setMargin(new Insets(0,-30, 0,-30));
        
        //set the size of the X
        exit.setFont(exit.getFont().deriveFont(10.0f));
        title.setFont(new java.awt.Font("Segoe UI", 0, 15));
        
        //make the button red and the text white
        exit.setBackground(new Color(199,80,80));
        exit.setForeground(Color.white);
        
        //make the panel use a null layout
        close.setLayout(null);
        
        //add the exit button and title
        close.add(exit);
        close.add(title);
        
        //set the size of the panel so it's exactly what I want.
        close.setPreferredSize(new Dimension(view.getWidth(),21));
        
        //position the button and label on the panel
        exit.setBounds(new Rectangle(view.getWidth()-44, 0, 45,17));
        title.setBounds(new Rectangle(0, 0, view.getWidth()-25, 25));
        
        //add the panel to the frame
        view.add(close, "North");
        
    }
    public CloseListener getCloseListener()
    {
        return closeListen;
    }
    public void setAuthenticationCntl(AuthenticationCntl controller)
    {
        theAuthenticationCntl = controller;
    }
    /**
     * Returns this authentication controller
     * @return 
     */
    public AuthenticationCntl getAuthenticationCntl()
    {
        return theAuthenticationCntl;
    }
    /**
     * Set the title of the frame.
     * @param title String value for the new title
     */
    public void setTitle(String title)
    {
        if(title.equalsIgnoreCase("Cravings"))
        {
            this.title.setText(title);
        }
        else
        {
            this.title.setText("Cravings - "+title);
        }
    }
    public MainFrameView getView()
    {
        return view;
    }
    public MainFrameModel getModel()
    {
        return model;
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
            view.dispose();
            System.out.println("Writing Data, please wait!");
            SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().setFoodGenreList(view.getMainFrameCntl().getAuthenticationCntl().getFGList());
            SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().setTheFoodList(view.getMainFrameCntl().getAuthenticationCntl().getFoodList());
            SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().setTheFseList(view.getMainFrameCntl().getAuthenticationCntl().getFseList());
            SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
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
