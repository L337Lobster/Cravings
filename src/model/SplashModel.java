/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.*;

/**
 *
 * @author Jackson Hofmann
 */
public class SplashModel {
    
    private ImageIcon splashImage;
    private JLabel splashLabel;
    public SplashModel()
    {
        splashImage = new ImageIcon("images/splash.png");
        splashLabel = new JLabel("");
    }
    
    public ImageIcon getSplashImage()
    {
        return splashImage;
    }
    
    public JLabel getSplashLabel()
    {
        return splashLabel;
    }
    
}
