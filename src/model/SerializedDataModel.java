/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import cravings.FoodGroupList;
import java.io.Serializable;

/**
 *
 * @author SHaynes
 */
public class SerializedDataModel implements Serializable{
    
    private FoodGroupList theFoodGroupList;
    
    
    public SerializedDataModel(){

    }
    
    public void setFoodGroupList(FoodGroupList newFoodGroupList){
        theFoodGroupList = newFoodGroupList;
    }
    
    public FoodGroupList getFoodGroupList(){
        if(theFoodGroupList == null){
            theFoodGroupList = new FoodGroupList();
        }
        return theFoodGroupList;
    }
    
}
