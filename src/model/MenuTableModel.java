/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AuthenticationCntl;
import cravings.FSE;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jackson Hofmann
 */
public class MenuTableModel extends AbstractTableModel{
    private ArrayList<String> theData;
    private String[] theColumns = new String[]{"Food"};
    private AuthenticationCntl theAuthenticationCntl;
    
    public MenuTableModel()
    {
        
    }
    
    public MenuTableModel(FSE theFSE, AuthenticationCntl auth)
    {
        theAuthenticationCntl = auth;
        ArrayList<String> temp = new ArrayList();
        for(int i = 0; i < theFSE.getMenu().getMenu().size(); i++)
        {
            temp.add(theFSE.getMenu().getMenu().get(i).getFoodName());
        }
        theData = temp;
    }
    @Override
    public String getColumnName(int col) {
        return theColumns[col];
     }
    @Override
    public int getRowCount() {
        return theData.size();
    }

    @Override
    public int getColumnCount() {
        return theColumns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col)
        {
            case 0:
                return theData.get(row);
        }
        return null;
    }
    
}
