/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cravings;

/**
 *
 * @author srh10
 */
public class User implements Printable{
    
    private String username = "";
    private char[] password;
    
    public User(){
        username = "Undefined";   
     
    }
    
    public User(String newUsername){
        username = newUsername;   
    }
    
    public void format(){
        
    }
    
    public void preview(){
        
    }
    
    public void print(){
        
    }
    
    
    
    /*
    Class:
    Responsibilities:               Collaborators:
    
    
    */
    
    
    /* Public interface of this class
        public String getUsername();
        public char[] getPassword();
        public void setUsername(String newUserName);
    */
    
    public String getUsername(){
        return this.username;
    }
    
    public char[] getPassword(){
        return this.password;
    }
    
    public void setUsername(String newUsername){
        username = newUsername;
    }
    
    public void setUsername(StringBuffer newUsername){
        username = new String(newUsername);
    }
}
