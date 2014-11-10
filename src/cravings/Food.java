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
    private FoodGenre theFoodGenre;
    
    public Food(String name, int calories, FSE location, FoodGenre genre)
    {
        theFoodGenre = genre;
        foodName = name;
        this.calories = calories;
        theFSE = location;
    }
    public Food(String name, FSE location, FoodGenre genre)
    {
        foodName = name;
        theFSE = location;
        theFoodGenre = genre;
        calories = 9001;
    }
    @Override
    public String toString()
    {
        return foodName;
    }
    public FoodGenre getFoodGenre()
    {
        return theFoodGenre;
    }
    public void setFoodGenre(FoodGenre genre)
    {
        theFoodGenre = genre;
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
    public void setFSE(FSE newFse)
    {
        theFSE = newFse;
    }
    public FSE getFSE()
    {
        return theFSE;
    }
    
}
