/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jackson Hofmann
 */
public class MainFrameModel {
    
    private String title;
    private int width, height;
    public MainFrameModel()
    {
        title = "Default";
        width = 600;
        height = 800;
    }
    public MainFrameModel(String title)
    {
        this.title = title;
        width = 600;
        height = 800;
    }
    public MainFrameModel(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
    }
    public MainFrameModel(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}
