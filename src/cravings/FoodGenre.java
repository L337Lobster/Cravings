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
public class FoodGenre implements Serializable{
    
    private String name;
    private int code;
    private String description;
    public FoodGenre(int code, String name, String desc)
    {
        this.code = code;
        this.name = name;
        description = desc;
    }
    public FoodGenre(int code, String name)
    {
        this.code = code;
        this.name = name;
        description = "";
    }
    public FoodGenre(String importString){
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        code =  Integer.parseInt(tokens[1]); // From the file format at the FDA site position 1 is the code.
        name = tokens[3]; // From the file format at the FDA site position 3 is the description.
        description = "";
    }
    public int getCode()
    {
        return code;
    }
    @Override
    public boolean equals(Object o)
    {
        boolean isEqual = false;
        if(o != null && o instanceof FoodGenre)
        {
            FoodGenre temp = (FoodGenre) o;
            if(temp.getCode() == this.getCode())
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
