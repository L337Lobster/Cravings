/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cravings;

import controller.AuthenticationCntl;

/**
 *
 * @author srh10
 */
public class Cravings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AuthenticationCntl theAuthenticationCntl = new AuthenticationCntl();
        
        theAuthenticationCntl.showLoginUI();
        
        
    }
    
}
