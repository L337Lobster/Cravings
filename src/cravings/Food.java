/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cravings;

/**
 *
 * @author srh10
 */
public abstract class Food {
    
    protected String foodName;
    private double price;
    private int calories;
    
    
    public String getName(){
        return foodName;
    }
    
    public abstract double getSize();
    
    
}
