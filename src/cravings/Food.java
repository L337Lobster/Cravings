/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

import java.io.Serializable;

/**
 *
 * @author Jackson Hofmann
 */
public class Food implements Serializable{
    
    private int code;
    private String foodName;
    private FSE theFSE;
    private int theFoodGenreCode;
    
    public Food(String name, FSE location, int genreCode)
    {
        theFoodGenreCode = genreCode;
        theFSE = location;
        foodName = name;
    }
    public Food(String importString)
    {
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        code = Integer.parseInt(tokens[1]);
        theFoodGenreCode = Integer.parseInt(tokens[3]);
        foodName = tokens[5];
    }
    public FSE getFSE()
    {
        return theFSE;
    }
    public int getCode()
    {
        return code;
    }
    @Override
    public String toString()
    {
        return foodName;
    }
    public int getFoodGenreCode()
    {
        return theFoodGenreCode;
    }
    public void setFoodGenreCode(int genreCode)
    {
        theFoodGenreCode = genreCode;
    }
    public String getFoodName()
    {
        return foodName;
    }
    
    public void setFoodName(String name)
    {
        foodName = name;
    }
    public void setFSE(FSE newFse)
    {
        theFSE = newFse;
    }
    
}
