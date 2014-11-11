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

    /**
     * @param theFoodStringList the theFoodStringList to set
     */
    public void setTheFoodStringList(ArrayList<String> theFoodStringList) {
        this.theFoodStringList = theFoodStringList;
    }
    
    
    
}
