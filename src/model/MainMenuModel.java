/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MainMenuCntl;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jackson Hofmann
 */
public class MainMenuModel {
    
    private JButton foodButton, fseButton, findFoodButton, quitButton;
    private String title;
    private Dimension size;
    public MainMenuModel(Dimension size)
    {
        this.size = size;
        initModel();
    }
    
    public void initModel()
    {
        foodButton = new JButton("Food");
        fseButton = new JButton("FSE");
        findFoodButton = new JButton("Find Food");
        quitButton = new JButton("Quit");
    }
    
    public void setSizeValue(Dimension x)
    {
        size = x;
    }
    public Dimension getSizeValue()
    {
        return size;
    }
    public JButton getFoodButton()
    {
        return foodButton;
    }
    public JButton getFseButton()
    {
        return fseButton;
    }
    public JButton getFindFoodButton()
    {
        return findFoodButton;
    }
    public JButton getQuitButton()
    {
        return quitButton;
    }
    
}
