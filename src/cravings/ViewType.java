/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

/**
 *
 * @author Jackson Hofmann
 */
public enum ViewType {
    
    FOOD
    {
        @Override
        public String toString()
        {
            return "food";
        }
    },
    FSE
    {
        @Override
        public String toString()
        {
            return "fse";
        }
    },
    FOOD_GENRE
    {
        @Override
        public String toString()
        {
            return "Food Genre";
        }
    }
    
}
