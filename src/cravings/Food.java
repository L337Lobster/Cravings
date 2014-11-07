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
public abstract class Food {
    
    protected String foodName;
    protected String foodDescription;
    protected int foodID;
    private double price;
    private int calories;
    
    /**
     * Returns the name of the food.
     * @return foodName The food name as a String.
     */
    public String getName(){
        return foodName;
    }
    /**
     * Returns the ID of the food.
     * @return foodID The food ID as an int.
     */
    public int getFoodID()
    {
        return this.foodID;
    }
    /**
     * Return the description of the food.
     * @return foodDescription The description of the food as a String.
     */
    public String getFoodDescription()
    {
        return this.foodDescription;
    }
    /**
     * Returns the size of the food.
     * This value is specific to each food type.
     * @return size The size of the food.
     */
    public abstract double getSize();
    
    
}
