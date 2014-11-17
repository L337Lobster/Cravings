/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jackson Hofmann
 */
public class FoodList implements Serializable{
    
    private ArrayList<Food> theFoodList;
    private ArrayList<String> theFoodStringList;
    
    public FoodList()
    {
        theFoodList = new ArrayList();
        theFoodStringList = new ArrayList();
    }
    /**
     * @return the theFoodList
     */
    public ArrayList<Food> getTheFoodList() {
        return theFoodList;
    }
    public Food getFoodByCode(int code)
    {
        Food temp = null;
        for(int i = 0; i < theFoodList.size(); i++)
        {
            if(theFoodList.get(i).getCode() == code)
            {
                temp = theFoodList.get(i);
            }
        }
        return temp;
    }
    /**
     * @param theFoodList the theFoodList to set
     */
    public void setTheFoodList(ArrayList<Food> theFoodList) {
        this.theFoodList = theFoodList;
    }

    /**
     * @return the theFoodStringList
     */
    public ArrayList<String> getTheFoodStringList() {
        return theFoodStringList;
    }
    public int getNextCode()
    {
        int temp = 0;
        for(int i = 0; i < theFoodList.size(); i++)
        {
            if(theFoodList.get(i).getCode() > temp)
            {
                temp = theFoodList.get(i).getCode();
            }
        }
        temp++;
        return temp;
    }
    /**
     * @param theFoodStringList the theFoodStringList to set
     */
    public void setTheFoodStringList(ArrayList<String> theFoodStringList) {
        this.theFoodStringList = theFoodStringList;
    }
    
    
    
}
