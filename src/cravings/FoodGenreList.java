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
public class FoodGenreList implements Serializable{
    
    private static ArrayList<FoodGenre> theFoodGenreList;
    private static ArrayList<String> theFoodGenreStringList;
    
    public FoodGenreList()
    {
        theFoodGenreList = new ArrayList();
        theFoodGenreStringList = new ArrayList();
    }
    public int getNextCode()
    {
        int temp = 0;
        for(int i = 0; i < theFoodGenreList.size(); i++)
        {
            if(theFoodGenreList.get(i).getCode() > temp)
            {
                temp = theFoodGenreList.get(i).getCode();
            }
        }
        temp+=1;
        return temp;
    }
    public FoodGenre getGenreByCode(int code)
    {
        FoodGenre temp = null;
        for(int i = 0; i < theFoodGenreList.size(); i++)
        {
            if(theFoodGenreList.get(i).getCode() == code)
            {
                temp = theFoodGenreList.get(i);
            }
        }
        return temp;
    }
    /**
     * @return the theFoodGenreList
     */
    public ArrayList<FoodGenre> getTheFoodGenreList() {
        return theFoodGenreList;
    }

    /**
     * @param theFoodGenreList the theFoodGenreList to set
     */
    public void setTheFoodGenreList(ArrayList<FoodGenre> theNewFoodGenreList) {
        theFoodGenreList = theNewFoodGenreList;
    }

    /**
     * @return the theFoodGenreStringList
     */
    public ArrayList<String> getTheFoodGenreStringList() {
        return theFoodGenreStringList;
    }

    /**
     * @param theFoodGenreStringList the theFoodGenreStringList to set
     */
    public void setTheFoodGenreStringList(ArrayList<String> theNewFoodGenreStringList) {
        theFoodGenreStringList = theNewFoodGenreStringList;
    }
    
}
