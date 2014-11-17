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
 * @author Jackson Hofmann
 */
public class FseList implements Serializable{
    
    private ArrayList<FSE> theFseList;
    private ArrayList<String> theFseStringList;
    
    public FseList(){
        theFseList = new ArrayList<FSE>();
        theFseStringList = new ArrayList<String>();
        for(int i =0; i < theFseList.size(); i++)
        {
            theFseStringList.add(theFseList.get(i).toString());
        }
    }
    public void refreshStringList()
    {
        for(int i = 0; i < theFseList.size(); i++)
        {
            if(!theFseStringList.contains(theFseList.get(i).toString()))
            {
                theFseStringList.add(theFseList.get(i).toString());
            }
        }
    }
    public FSE getFseByCode(int code)
    {
        FSE temp = null;
        for(int i = 0; i < theFseList.size(); i++)
        {
            if(theFseList.get(i).getCode() == code)
            {
                temp = theFseList.get(i);
            }
        }
        return temp;
    }
    public int getNextCode()
    {
        int temp = 0;
        for(int i = 0; i < theFseList.size(); i++)
        {
            if(theFseList.get(i).getCode() > temp)
            {
                temp = theFseList.get(i).getCode();
            }
        }
        temp+=1;
        return temp;
    }
    public ArrayList<String> getStringListOfFSEs()
    {
        return theFseStringList;
    }
    public ArrayList<FSE> getListOfFSEs(){
        return theFseList;
    }
    
    public void setListOfFSEs(ArrayList<FSE> theNewFseList){
        theFseList = theNewFseList;
    }
    
}
