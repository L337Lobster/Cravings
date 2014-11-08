/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainMenuCntl;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jack
 */
public class MainMenuView extends JPanel{
    private JButton foodButton, fseButton, findFoodButton, quitButton;
    private MainMenuCntl theMainMenuCntl;
    
    public MainMenuView()
    {
        
    }
    public MainMenuCntl getMainMenuCntl()
    {
        return theMainMenuCntl;
    }
    public void setMainMenuCntl(MainMenuCntl controller)
    {
        theMainMenuCntl = controller;
    }
    public void setLayoutManager(LayoutManager manager)
    {
        setLayout(manager);
    }
    public JButton getFoodButton()
    {
        return foodButton;
    }
    public void setFoodButton(JButton button)
    {
        foodButton = button;
    }
    public JButton getFseButton()
    {
        return fseButton;
    }
    public void setFseButton(JButton button)
    {
        fseButton = button;
    }
    public JButton getFindFoodButton()
    {
        return findFoodButton;
    }
    public void setFindFoodButton(JButton button)
    {
        findFoodButton = button;
    }
    public JButton getQuitButton()
    {
        return quitButton;
    }
    public void setQuitButton(JButton button)
    {
        quitButton = button;
    }
    
    
}
