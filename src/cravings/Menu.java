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
 * @author jph5321
 */
public class Menu implements Serializable{
    
    private ArrayList<Food> menu;
    
    public Menu()
    {
        menu = new ArrayList();
    }
    
    public ArrayList<Food> getMenu()
    {
        return this.menu;
    }
    
    public void setMenu(ArrayList<Food> theMenu)
    {
        menu = theMenu;
    }
    
    public void clearMenu()
    {
        menu.clear();
    }
}
