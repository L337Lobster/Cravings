/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

/**
 *
 * @author Jackson Hofmann
 */
public class Food {
    
    private String foodName;
    private int calories;
    private FSE theFSE;
    
    public Food(String name, int calories, FSE location)
    {
        foodName = name;
        this.calories = calories;
        theFSE = location;
    }
    
    public String getFoodName()
    {
        return foodName;
    }
    
    public void setFoodName(String name)
    {
        foodName = name;
    }
    
    public int getCalories()
    {
        return calories;
    }
    
    public void setCalories(int number)
    {
        calories = number;
    }
    
    public FSE getFSE()
    {
        return theFSE;
    }
    
}
