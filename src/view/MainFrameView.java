/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainFrameCntl;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Jack
 */
public class MainFrameView extends JFrame{
    private int width, height;
    private MainFrameCntl theMainFrameCntl;
    /**
     * Constructor for the view.
     * Sets the default:
     * <ul>
     * <li>Close Operation
     * <li>Size
     * </ul>
     * Sets the frame to visible.<br>
     * Then finally centers the frame on the screen.
     */
    public MainFrameView()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (600, 800);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    /**
     * Returns the width variable.
     * @return width as an int.
     */
    @Override
    public int getWidth()
    {
        return width;
    }
    /**
     * Set the value of the class variable width.
     * @param width as an int
     */
    public void setWidth(int width)
    {
        this.width = width;
    }
    /**
     * Returns the height variable.
     * @return height as an int.
     */
    @Override
    public int getHeight()
    {
        return height;
    }
    /**
     * Set the value of the class variable height.
     * @param height as an int
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    /**
     * Sets both the with and the height values.
     * These values represent the width and height of the frame.
     * @param width int
     * @param height int
     */
    public void setSizeValues(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    /**
     * Returns both the width and the height as a Dimension.
     * This dimension is used to represent the dimension of the frame.
     * @return new Dimension(width, height)
     */
    public Dimension getSizeValues()
    {
        return new Dimension(width, height);
    }
    /**
     * Refresh the size of the window to the currently set values.
     * Values are the instance variables width and height.<br>
     * Then center the window again.
     */
    public void refreshSize()
    {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
    }
    /**
     * Returns the controller for this instance.
     * @return theMainFrameCntl as a MainFrameCntl.
     */
    public MainFrameCntl getMainFrameCntl()
    {
        return this.theMainFrameCntl;
    }
    /**
     * Sets the controller for this instance.
     * @param controller as a MainFrameCntl.
     */
    public void setMainFrameCntl(MainFrameCntl controller)
    {
        this.theMainFrameCntl = controller;
    }
    
}
