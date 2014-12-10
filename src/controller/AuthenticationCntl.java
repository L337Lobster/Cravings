/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import cravings.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JPanel;
import model.*;
import view.*;

/**
 *
 * @author srh10
 */
public class AuthenticationCntl {
    private MainFrameView theMainFrameView;
    private SplashView splashScreen;
    private LoginView theLoginView;
    private UserList theUserList;
    private MainMenuView theMainMenuView;
    private ListView theListView;
    private DetailView theDetailView;
    private FseList theFseList;
    private FoodList theFoodList;
    private FoodGenreList theFoodGenreList;
    ExternalDataCntl theExternalDataCntl;
    private final Dimension defaultDimension = new Dimension(600,800);
    
    public AuthenticationCntl()
    {
        theUserList = new UserList();
        theExternalDataCntl = new ExternalDataCntl();
        theFoodList = theExternalDataCntl.getTheFoodList();
        theFoodGenreList = theExternalDataCntl.getTheFoodGenreList();
        theFseList = theExternalDataCntl.getTheFseList();
        for(int i = 0; i < theFoodGenreList.getTheFoodGenreList().size(); i++)
        {
            theFoodGenreList.getTheFoodGenreStringList().add(theFoodGenreList.getTheFoodGenreList().get(i).toString());
        }

        createMainFrame();
        showSplashUI();
    }
    
    public void showListView(ViewType listType, JPanel panel)
    {
        FoodTableModel theFoodTableModel = new FoodTableModel(theFoodList.getTheFoodList(), this);
        FseTableModel theFseTableModel = new FseTableModel(theFseList.getListOfFSEs(), this);
        switch(listType)
        {
            case FOOD:
                theListView = new ListView(theFoodTableModel, listType);
                break;
            case FSE:
                theListView = new ListView(theFseTableModel, listType);
                break;
        }
        
        ListViewCntl theListViewCntl = new ListViewCntl(theListView, theMainFrameView);
        theMainFrameView.getMainFrameCntl().replacePanel(panel, theListView);
    }
    public void showDetailView(ViewType detailType, Food theFood, JPanel panel)
    {
        theDetailView = new DetailView(ViewType.FOOD);
        DetailViewCntl foodDetailCntl = new DetailViewCntl(theDetailView, theMainFrameView, theFood);
        theMainFrameView.getMainFrameCntl().replacePanel(panel, theDetailView);
    }
    public void showDetailView(ViewType detailType, FSE theFse, JPanel panel)
    {
        HoursTableModel model = new HoursTableModel(theFse, this);
        theDetailView = new DetailView(ViewType.FSE, model);
        DetailViewCntl foodDetailCntl = new DetailViewCntl(theDetailView, theMainFrameView, theFse);
        theMainFrameView.getMainFrameCntl().replacePanel(panel, theDetailView);
    }
    
    /**
     * Shows the LoginUI
     */
    public void showLoginUI()
    {
        theLoginView = new LoginView();
        LoginModel theLoginModel = new LoginModel();
        LoginCntl theLoginCntl = new LoginCntl(theLoginView, theLoginModel, theMainFrameView);
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
    public void showMainMenuUI(JPanel panel)
    {
        theMainMenuView = new MainMenuView();
        theMainFrameView.getMainFrameCntl().replacePanel(panel, theMainMenuView);
        MainMenuModel theMainMenuModel = new MainMenuModel(defaultDimension);
        MainMenuCntl theMainMenuCntl = new MainMenuCntl(theMainMenuView, theMainMenuModel, theMainFrameView);
    }
    public boolean Authenticate(User testUser)
    {
        boolean authenticated = false;
        ArrayList<User> temp = getUserList().getTheListOfUser();
        if(temp.contains(testUser))
        {
            authenticated = true;
        }
        return authenticated;
    }
    public LoginView getLoginView()
    {
        return theLoginView;
    }
    public FoodGenreList getFGList()
    {
        return theFoodGenreList;
    }
    public FseList getFseList()
    {
        return theFseList;
    }
    /**
     * Gets the list of users.
     */
    public UserList getUserList(){
        return theUserList;
    }
    public FoodList getFoodList()
    {
        return theFoodList;
    }
    
    
}
