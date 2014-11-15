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
public enum DayOfTheWeek {
    
    
    SUNDAY(1)
    {
        @Override
        public String toString()
        {
            return "Sunday";
        }
    },
    MONDAY(2)
    {
        @Override
        public String toString()
        {
            return "Monday";
        }
    },
    TUESDAY(3)
    {
        @Override
        public String toString()
        {
            return "Tuesday";
        }
    },
    WEDNESDAY(4)
    {
        @Override
        public String toString()
        {
            return "Wednesday";
        }
    },
    THURSDAY(5)
    {
        @Override
        public String toString()
        {
            return "Thursday";
        }
    },
    FRIDAY(6)
    {
        @Override
        public String toString()
        {
            return "Friday";
        }
    },
    SATURDAY(7)
    {
        @Override
        public String toString()
        {
            return "Saturday";
        }
    };
    
    private int day;
    
    private DayOfTheWeek(int x)
    {
        day = x;
    }
    
    public int toInt()
    {
        return day;
    }
    
}
