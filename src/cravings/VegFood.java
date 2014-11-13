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
public class VegFood extends Food{
    
    private boolean isVegan;
    private boolean isVegitarian;
    
    public VegFood(int code, String name, int theGenreCode, String description, boolean vegan, boolean vegitarian)
    {
        super(code, name,theGenreCode,description);
        isVegan = vegan;
        isVegitarian = vegitarian;
    }

    /**
     * @return the isVegan
     */
    public boolean isVegan() {
        return isVegan;
    }

    /**
     * @param isVegan the isVegan to set
     */
    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    /**
     * @return the isVegitarian
     */
    public boolean isVegitarian() {
        return isVegitarian;
    }

    /**
     * @param isVegitarian the isVegitarian to set
     */
    public void setIsVegitarian(boolean isVegitarian) {
        this.isVegitarian = isVegitarian;
    }
    
    
    
}
