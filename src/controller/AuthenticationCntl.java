/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.LoginModel;
import model.MainFrameModel;
import model.SplashModel;
import view.LoginView;
import view.MainFrameView;
import view.SplashView;

/**
 *
 * @author srh10
 */
public class AuthenticationCntl {
    private MainFrameView theMainFrameView;
    private SplashView splashScreen;
    private LoginView theLoginView;
    
    public AuthenticationCntl()
    {
        createMainFrame();
        showSplashUI();
    }
    
    /**
     * Shows the LoginUI
     */
    public void showLoginUI()
    {
        theLoginView = new LoginView();
        LoginModel theLoginModel = new LoginModel();
        LoginCntl theLoginCntl = new LoginCntl(theLoginView, theLoginModel, theMainFrameView);
        theLoginCntl.initView();
    }
    public void showSplashUI()
    {
        splashScreen = new SplashView();
        SplashModel theSplashModel = new SplashModel();
        SplashCntl theSplashCntl = new SplashCntl(splashScreen, theSplashModel, theMainFrameView);
    }
    /**
     * Creates the main JFrame.
     */
    public void createMainFrame(){
        theMainFrameView = new MainFrameView();
        MainFrameModel theMainFrameModel = new MainFrameModel("Cravings",600,800);
        MainFrameCntl theMainFrameCntl = new MainFrameCntl(theMainFrameView, theMainFrameModel);
        theMainFrameCntl.setAuthenticationCntl(this);
        
    }
    public LoginView getLoginView()
    {
        return theLoginView;
    }
    /**
     * Gets the list of users.
     */
    public void getUserList(){
        
    }
    
    
}
