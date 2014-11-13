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
    public FoodGenre(int code, String name)
    {
        this.code = code;
        this.name = name;
    }
    public FoodGenre(String importString){
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        code =  Integer.parseInt(tokens[1]); // From the file format at the FDA site position 1 is the code.
        name = tokens[3]; // From the file format at the FDA site position 3 is the description.
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
    
}
