/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginCntl;
import java.awt.LayoutManager;
import javax.swing.*;

/**
 *
 * @author Jackson Hofmann
 */
public class LoginView extends JPanel{
    private JButton loginButton;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private LoginCntl theLoginCntl;
    /**
     * Constructor, currently does nothing.
     */
    public LoginView()
    {
        
    }
    /**
     * Returns the label used for the Username Field.
     * @return usernameLabel JLabel
     */
    public JLabel getUsernameLabel()
    {
        return usernameLabel;
    }
    /**
     * Returns the label used for the password field.
     * @return passwordLabel JLabel
     */
    public JLabel getPasswordLabel()
    {
        return passwordLabel;
    }
    /**
     * Set usernameLabel to the JLabel label
     * @param label The new JLabel used for the password field.
     */
    public void setUsernameLabel(JLabel label)
    {
        usernameLabel = label;
    }
    /**
     * Set passwordLabel to the JLabel label
     * @param label The new JLabel used for the password field
     */
    public void setPasswordLabel(JLabel label)
    {
        passwordLabel = label;
    }
    /**
     * Returns the submit button.
     * @return LoginButton The submit button for the login panel.
     */
    public JButton getLoginButton()
    {
        return loginButton;
    }
    public void setLoginButton(JButton button)
    {
        loginButton = button;
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
    /**
     * Sets the password field.
     * @param field JPasswordField used for the password.
     */
    public void setPasswordField(JPasswordField field)
    {
        passwordField = field;
    }
    /**
     * Sets the username field.
     * @param field JTextField used for the username.
     */
    public void setUsernameField(JTextField field)
    {
        usernameField = field;
    }
    /**
     * Sets the Login controller for this.
     * @param controller LoginCntl
     */
    public void setLoginCntl(LoginCntl controller)
    {
        theLoginCntl = controller;
    }
    /**
     * Returns the current login controller.
     * @return theLoginCntl LoginCntl.
     */
    public LoginCntl getLoginCntl()
    {
        return theLoginCntl;
    }
    public void setLayoutManager(LayoutManager layout)
    {
        this.setLayout(layout);
    }
    
    
}
