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
public class FSE {
    
    private String name;
    private FSEAddress address;
    private int[] openHour = new int[7];
    private int[] closeHour = new int[7];
    
    public FSE(String name, FSEAddress address, int[] open, int[] close)
    {
        this.name = name;
        this.address = address;
        openHour = open;
        closeHour = close;
    }
    public FSE(String name)
    {
        this.name = name;
        address = new FSEAddress();
        for(int i = 0; i < 7; i++)
        {
            openHour[i] = 0;
            closeHour[i] = 0;
        }
    }
    @Override
    public boolean equals(Object o)
    {
        boolean isEqual = false;
        if(o != null && o instanceof FSE)
        {
            FSE temp = (FSE) o;
            if(temp.name.equals(this.name) && temp.address.equals(this.address) && temp.openHour == this.openHour && temp.closeHour == this.closeHour)
            {
                isEqual = true;
            }
        }
        else if(o != null && o instanceof String)
        {
            String temp = (String) o;
            if(temp.equals(this.name))
            {
                isEqual = true;
            }
        }
        return isEqual;
    }
    @Override
    public String toString()
    {
        return name;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public FSEAddress getAddress()
    {
        return address;
    }
    public void FSEAddress(FSEAddress address)
    {
        this.address = address;
    }
    
    public int[] getOpenHours()
    {
        return openHour;
    }
    public void setOpenHours(int[] open)
    {
        this.openHour = open;
    }
    public void setOpenHours(DayOfTheWeek day, int hour)
    {
        this.openHour[day.toInt()] = hour;
    }
    public int[] getCloseHours()
    {
        return this.closeHour;
    }
    public void setCloseHours(int[] close)
    {
        this.closeHour = close;
    }
    public void setCloseHours(DayOfTheWeek day, int hour)
    {
        this.closeHour[day.toInt()] = hour;
    }
}
