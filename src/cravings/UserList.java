/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cravings;

import java.util.ArrayList;
/**
 * 
 * @author Jackson Hofmann
 */
public class UserList {
    
    private static ArrayList<User> theListOfUsers = new ArrayList();
    public UserList()
    {
        for(int i =0; i < 100; i++)
        {
            String username = "test"+i;
            char[] password = username.toCharArray();
            User newUser = new User(username, password);
            theListOfUsers.add(newUser);
            
        }
    }
    public static ArrayList<User> getTheListOfUser(){
        return theListOfUsers;
    }
}
