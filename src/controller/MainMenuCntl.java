/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MainMenuModel;
import view.MainMenuView;

/**
 *
 * @author Jackson Hofmann
 */
public class MainMenuCntl {
    
    private MainMenuView view;
    private MainMenuModel model;
    public MainMenuCntl(MainMenuView view, MainMenuModel model)
    {
        this.view = view;
        this.model = model;
    }
    
}
