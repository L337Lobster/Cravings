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
public class FoodGenre {
    
    private String name;
    private String description;
    
    public FoodGenre(String name, String desc)
    {
        this.name = name;
        description = desc;
    }
    public FoodGenre(String name)
    {
        this.name = name;
        description = "";
    }
    @Override
    public boolean equals(Object o)
    {
        boolean isEqual = false;
        if(o != null && o instanceof FoodGenre)
        {
            FoodGenre temp = (FoodGenre) o;
            if(temp.name.equals(this.name) && temp.description.equals(this.description))
            {
                isEqual = true;
            }
        }
        else if(o != null && o instanceof String)
        {
            String temp = (String) o;
            if(temp.equals(this.name))
            {
                isEqual = true;
            }
        }
        return isEqual;
    }
    @Override
    public String toString()
    {
        return name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
