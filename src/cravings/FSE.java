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
    private String address;
    private int[] openHour;
    private int[] closeHour;
    
    public FSE(String name, String address, int[] open, int[] close)
    {
        this.name = name;
        this.address = address;
        openHour = open;
        closeHour = close;
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
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
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
