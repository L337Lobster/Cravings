/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author Jackson Hofmann
 */
public class LoginView {
    private JButton LoginButton;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    /**
     * Constructor, currently does nothing.
     */
    public LoginView()
    {
        
    }
    /**
     * Returns the submit button.
     * @return LoginButton The submit button for the login panel.
     */
    public JButton getLoginButton()
    {
        return LoginButton;
    }
    /**
     * Returns the username text field.
     * @return usernameText The username text field.
     */
    public JTextField getUsernameField()
    {
        return usernameField;
    }
    /**
     * Returns the password text field.
     * @return passwordText The password text field.
     */
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }
    public void setPasswordField(JPasswordField field)
    {
        passwordField = field;
    }
    
    
}
