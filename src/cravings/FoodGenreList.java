/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

import java.util.ArrayList;

/**
 *
 * @author Jackson Hofmann
 */
public class FoodGenreList {
    
    private static ArrayList<FoodGenre> theFoodGenreList;
    private static ArrayList<String> theFoodGenreStringList;
    
    public FoodGenreList()
    {
        theFoodGenreList = new ArrayList();
        theFoodGenreStringList = new ArrayList();
        for(int i = 0; i < 10; i++)
        {
            FoodGenre temp = new FoodGenre("Genre"+i, "Description"+i);
            theFoodGenreList.add(temp);
            theFoodGenreStringList.add(temp.toString());
        }
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
