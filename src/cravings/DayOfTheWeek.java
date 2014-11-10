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
    
    MONDAY(0)
    {
        @Override
        public String toString()
        {
            return "Monday";
        }
    },
    TUESDAY(1)
    {
        @Override
        public String toString()
        {
            return "Tuesday";
        }
    },
    WEDNESDAY(2)
    {
        @Override
        public String toString()
        {
            return "Wednesday";
        }
    },
    THURSDAY(3)
    {
        @Override
        public String toString()
        {
            return "Thursday";
        }
    },
    FRIDAY(4)
    {
        @Override
        public String toString()
        {
            return "Friday";
        }
    },
    SATURDAY(5)
    {
        @Override
        public String toString()
        {
            return "Saturday";
        }
    },
    SUNDAY(6)
    {
        @Override
        public String toString()
        {
            return "Sunday";
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
