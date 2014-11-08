/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    }
    
    public void initView()
    {
        frame.getMainFrameCntl().getView().setSizeValues(frame.getMainFrameCntl().getModel().getWidth(), 400);
        frame.getMainFrameCntl().getView().refreshSize();
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
        
        view.add(view.getUsernameLabel());
        view.add(view.getPasswordLabel());
    }
}
