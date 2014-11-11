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
    
    private static ArrayList<FSE> theFseList;
    private static ArrayList<String> theFseStringList;
    
    public FseList(){
        theFseList = new ArrayList<FSE>();
        theFseStringList = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
        {
            int[] open = {0, 1, 2, 3, 4, 5, 6};
            int[] close = {0, 1, 2, 3, 4, 5, 6};
            FSEAddress address = new FSEAddress();
            String name = "FSE"+i;
            FSE tempFse = new FSE(i, name,address, open, close);
            theFseList.add(tempFse);
        }
        for(int i =0; i < theFseList.size(); i++)
        {
            theFseStringList.add(theFseList.get(i).toString());
        }
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
