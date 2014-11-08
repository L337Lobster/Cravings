/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import view.LoginView;
import view.MainFrameView;

/**
 *
 * @author Jackson Hofmann
 */
public class LoginCntl {
    private LoginView view;
    private LoginModel model;
    private MainFrameView frame;
    
    public LoginCntl(LoginView view, LoginModel model, MainFrameView frame)
    {
        this.view = view;
        this.model = model;
        this.frame = frame;
        initView();
    }
    
    public void initView()
    {
        
        frame.getMainFrameCntl().getView().setSizeValues(frame.getMainFrameCntl().getModel().getWidth()-200, 200);
        frame.getMainFrameCntl().getView().refreshSize();
        frame.getMainFrameCntl().refreshCloseSize();
        frame.getMainFrameCntl().setTitle("Login");
        model.setSizeValue(frame.getSizeValues());
        model.initBounds();
        view.setLayoutManager(null);
        
        view.setPasswordLabel(model.getPasswordLabel());
        view.setPasswordField(model.getPasswordField());
        
        view.setUsernameLabel(model.getUsernameLabel());
        view.setUsernameField(model.getUsernameField());
        
        view.setLoginButton(model.getLoginButton());
        
        view.setLoginCntl(this);
        
        frame.getRootPane().setDefaultButton(view.getLoginButton());
        
        view.add(view.getUsernameLabel());
        view.add(view.getPasswordLabel());
        view.add(view.getUsernameField());
        view.add(view.getPasswordField());
        view.add(view.getLoginButton());
        LoginListener theLoginListener = new LoginListener();
        view.getLoginButton().addActionListener(theLoginListener);
    }
    public class LoginListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String username = view.getUsernameField().getText();
            char[] password = view.getPasswordField().getText().toCharArray();
            if(frame.getMainFrameCntl().getAuthenticationCntl().Authenticate(new User(username, password)))
            {
                frame.getMainFrameCntl().getAuthenticationCntl().showMainMenuUI(view);
            }
            else
            {
                JOptionPane.showMessageDialog(view,"Login FAILURE!!");
            }
        }
        
    }
}
