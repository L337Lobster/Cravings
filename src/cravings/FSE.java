/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravings;

import java.io.Serializable;

/**
 *
 * @author Jackson Hofmann
 */
public class FSE implements Serializable{
    private int code;
    private String name;
    private FSEAddress address;
    private int[] openHour = new int[8];
    private int[] closeHour = new int[8];
    
    public FSE(int code, String name, FSEAddress address, int[] open, int[] close)
    {
        this.name = name;
        this.address = address;
        openHour = open;
        closeHour = close;
    }
    public FSE(String importString)
    {
        String delimiter = "~";
        String[] tokens = importString.split(delimiter);
        code = Integer.parseInt(tokens[1]);
        name = tokens[3];
        int j = 1;
        openHour[0] = 0;
        closeHour[0] = 0;
        for(int i = 4; i < 11; i++)
        {
            String[] hours = tokens[i].split("-");
            openHour[j] = Integer.parseInt(hours[0]);
            closeHour[j] = Integer.parseInt(hours[1]);
            j++;
        }
        address = new FSEAddress(tokens[11]);
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
    public int getDayOpenHour(int day)
    {
        return openHour[day];
    }
    public int getDayCloseHour(int day)
    {
        return closeHour[day];
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
    public String getDayHours(DayOfTheWeek day)
    {
        
        return String.format("%04d", this.getDayOpenHour(day.toInt())) + " - " + String.format("%04d", this.getDayCloseHour(day.toInt()));
    }
    
    public String getDayHours(int day)
    {
        
        return String.format("%04d", this.getDayOpenHour(day)) + " - " + String.format("%04d", this.getDayCloseHour(day));
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
