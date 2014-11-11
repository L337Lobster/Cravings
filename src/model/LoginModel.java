/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.LoginCntl;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jackson Hofmann
 */
public class LoginModel {
    
    private JButton loginButton;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private LoginCntl theLoginCntl;
    private int width, height;
    
    public LoginModel()
    {
        initModel();
        initFonts();
    }
    
    public void initModel()
    {
        loginButton = new JButton("Login");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
    }
    public void initFonts()
    {
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(20.0f));
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(20.f));
    }
    public void initBounds()
    {
        usernameLabel.setBounds(new Rectangle(width/8,height/4,150,25));
        passwordLabel.setBounds(new Rectangle(width/4+100,height/4,150,25));
        usernameField.setBounds(new Rectangle(width/8,(height/4)+35,110,25));
        passwordField.setBounds(new Rectangle(width/4+100,(height/4)+35,110,25));
        loginButton.setBounds(new Rectangle((width/4)+135, (height/4)+70, 75, 25));
    }
    public void setSizeValue(Dimension x)
    {
        width = x.width;
        height = x.height;
    }
    public Dimension getSizeValue()
    {
        return new Dimension(width, height);
    }
    public LoginCntl getLoginCntl()
    {
        return theLoginCntl;
    }
    public void setLoginCntl(LoginCntl login)
    {
        theLoginCntl = login;
    }
    public JButton getLoginButton()
    {
        return loginButton;
    }
    public void setLoginButton(JButton button)
    {
        loginButton = button;
    }
    public JLabel getUsernameLabel()
    {
        return usernameLabel;
    }
    public void setUsernameLabel(JLabel label)
    {
        usernameLabel = label;
    }
    public JLabel getPasswordLabel()
    {
        return passwordLabel;
    }
    public void setPasswordLabel(JLabel label)
    {
        passwordLabel = label;
    }
    public JTextField getUsernameField()
    {
        return usernameField;
    }
    public void setUsernameField(JTextField field)
    {
        usernameField = field;
    }
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }
    public void setPasswordField(JPasswordField field)
    {
        passwordField = field;
    }
    public void setPasswordEchoChar(char x)
    {
        passwordField.setEchoChar(x);
    }
}
