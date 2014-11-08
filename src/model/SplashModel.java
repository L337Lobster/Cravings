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
    /**
     * Set the new splash image.
     * @param path The path without the ending slash.
     * @param image The name of the image file without the extension.
     * @param extension The extension of the image file.
     */
    public void setSplashImage(String path, String image, String extension)
    {
        splashImage = new ImageIcon(path+"/"+image+"."+extension);
    }
    /**
     * Returns the JLabel splashLabel.
     * This is used for the splash image by setting the icon to the image.
     * @return splashLabel JLabel
     */
    public JLabel getSplashLabel()
    {
        return splashLabel;
    }
    
    public void setSplashLabel(JLabel label)
    {
        splashLabel = label;
    }
    
}
