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
public class FSEAddress implements Serializable{
    
    private String city, street;
    private char[] state = new char[2];
    private int houseNum, zipCode;
    
    public FSEAddress(String city, String street, char[] state, int houseNum, int zipCode)
    {
        this.city = city;
        this.street = street;
        this.state = state;
        this.houseNum = houseNum;
        this.zipCode = zipCode;
        
    }
    public FSEAddress()
    {
        houseNum = 123;
        street = "Default Street";
        city = "Default Street";
        state = new char[]{'P', 'A'};
        zipCode = 12345;
    }
    public FSEAddress(String importString)
    {
        String delimiter = "-";
        String[] tokens = importString.split(delimiter);
        houseNum = Integer.parseInt(tokens[0]);
        street = tokens[1];
        city = tokens[2];
        state = tokens[3].toCharArray();
        zipCode = Integer.parseInt(tokens[4]);
        
    }
    
    @Override
    public String toString()
    {
        return houseNum + " " + street + ", " + city + ", " + state + " " + zipCode;
    }
    public String getShortValue()
    {
        return houseNum + " " + street;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public char[] getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(char[] state) {
        this.state = state;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the houseNum
     */
    public int getHouseNum() {
        return houseNum;
    }

    /**
     * @param houseNum the houseNum to set
     */
    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    /**
     * @return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    
}
