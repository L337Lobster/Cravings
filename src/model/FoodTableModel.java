/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import cravings.Food;
import cravings.VegFood;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jackson Hofmann
 */
public class FoodTableModel extends AbstractTableModel{
    
    private ArrayList<Food> theData = new ArrayList();
    private String[] theColumns = new String[]{"Name", "Genre", "VegLevel", "Location"}; 
    
    public FoodTableModel()
    {
        
    }
    public FoodTableModel(ArrayList<Food> theFoodList)
    {
        theData = theFoodList;
    }
    public void addFood(Food theFood)
    {
        theData.add(theFood);
        fireTableDataChanged();
    }
    public void updateFoodList(ArrayList<Food> theFoodList)
    {
        theData = theFoodList;
        fireTableDataChanged();
    }
    public Food removeFoodAt(int row)
    {
        return theData.remove(row);
    }
    public Food getFoodAt(int row)
    {
        return theData.get(row);
    }
    @Override
    public int getRowCount() {
        return theData.size();
    }

    @Override
    public int getColumnCount() {
        return theColumns.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return theColumns[col];
     }

    @Override
    public Object getValueAt(int row, int col) {
        Food theFood = (Food) theData.get(row);
        switch(col)
        {
            case 0:
                return theFood.getFoodName();
            case 1:
                return theFood.getFoodGenre().getName();
            case 2:
                if(theFood instanceof VegFood)
                {
                    VegFood theVegFood = (VegFood) theFood;
                    if(theVegFood.isVegan())
                    {
                        return "Vegan";
                    }
                    if(theVegFood.isVegitarian())
                    {
                        return "Vegitarian";
                    }
                }
                return "Neither";
            case 3:
                return theFood.getFSE().getName();
        }
        return null;
    }
    
}
