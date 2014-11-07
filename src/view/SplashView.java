/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.*;

/**
 *
 * @author Jack
 */
public class SplashView extends JPanel{
    
    private ImageIcon splashImage;
    private JLabel splashLabel;
    /**
     * Constructor, does nothing as of right now.
     */
    public SplashView()
    {
        
    }
    /**
     * Returns the current splashImage.
     * If splashImage hasn't been initialized it returns a new ImageIcon with a blank image.
     * @return splashImage Current splash image as an ImageIcon.
     */
    public ImageIcon getSplashImage()
    {
        if(splashImage == null)
        {
            return new ImageIcon("images/blank.png");
        }
        return splashImage;
    }
    /**
     * Sets the splashImage to image.
     * @param image ImageIcon that is set to be the splashImage.
     */
    public void setSplashImage(ImageIcon image)
    {
        splashImage = image;
    }
    /**
     * Sets the splashLabel to a new JLabel.
     * This will set splashLabel to a new JLabel with the text label.
     * @param label The string that will be displayed on the JLabel.
     */
    public void setSplashLabel(String label)
    {
        splashLabel = new JLabel(label);
    }
    /**
     * Sets the SplashLabel to an already existing JLabel.
     * @param label The pre-existing JLabel that splashLabel is being set to.
     */
    public void setSplashLabel(JLabel label)
    {
        splashLabel = label;
    }
    /**
     * Returns the current splashLabel.
     * @return splashLabel as a JLable
     */
    public JLabel getSplashLabel()
    {
        return splashLabel;
    }
    /**
     * Sets the views LayoutManager
     * @param layout as a LayoutManager
     */
    public void setViewLayout(LayoutManager layout)
    {
        SplashView.this.setLayout(layout);
    }
}
