/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cravings;

import java.util.ArrayList;

/**
 *
 * @author srh10
 */
public class UserList {
    
    private static ArrayList<User> theListOfUsers = new ArrayList();
    
    public static ArrayList<User> getTheListOfUser(){
        return theListOfUsers;
    }
}
