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
        frame.getMainFrameCntl().setTitle("Login");
    }
}
