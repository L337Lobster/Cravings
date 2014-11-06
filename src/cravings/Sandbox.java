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
public class Sandbox {
    
    ArrayList<User> theListOfUsers = UserList.getTheListOfUser();
    
    ArrayList<Printable> printQueue = new ArrayList();
    
    
    User myUser = new User("ted");
    String theUsername = myUser.getUsername();
    
    //Food myfood = new Food();
    
    
}
