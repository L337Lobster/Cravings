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
    private int theFoodGenreCode;
    private String foodDescription;
    
    public Food(int foodCode, String name, int genreCode, String foodDescription)
    {
        code = foodCode;
        theFoodGenreCode = genreCode;
        foodName = name;
        this.foodDescription = foodDescription;
    }
    public Food(String importString)
    {
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        code = Integer.parseInt(tokens[1]);
        theFoodGenreCode = Integer.parseInt(tokens[3]);
        foodDescription = tokens[7];
        foodName = tokens[5];
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
    
}
