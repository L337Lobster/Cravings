/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import cravings.FoodGenreList;
import cravings.FoodList;
import cravings.FseList;
import java.io.Serializable;

/**
 *
 * @author SHaynes
 */
public class SerializedDataModel implements Serializable{
    
    private FoodGenreList theFoodGenreList;
    private FoodList theFoodList;
    private FseList theFseList;
    
    
    public SerializedDataModel(){

    }
    
    public void setFoodGenreList(FoodGenreList newFoodGroupList){
        theFoodGenreList = newFoodGroupList;
    }
    
    public FoodGenreList getFoodGenreList(){
        if(theFoodGenreList == null){
            theFoodGenreList = new FoodGenreList();
        }
        return theFoodGenreList;
    }

    /**
     * @return the theFoodList
     */
    public FoodList getTheFoodList() {
        if(theFoodList == null)
        {
            theFoodList = new FoodList();
        }
        return theFoodList;
    }

    /**
     * @param theFoodList the theFoodList to set
     */
    public void setTheFoodList(FoodList theFoodList) {
        this.theFoodList = theFoodList;
    }

    public FseList getFseList() {
        if(theFseList == null)
        {
            setTheFseList(new FseList());
        }
        return theFseList;
    }

    /**
     * @param theFseList the theFseList to set
     */
    public void setTheFseList(FseList theFseList) {
        this.theFseList = theFseList;
    }
    
}
