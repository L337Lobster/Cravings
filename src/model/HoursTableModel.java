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
public class HoursTableModel extends AbstractTableModel{
    private ArrayList<String> theData = new ArrayList();
    private String[] theColumns = new String[]{"Day", "Hours"};
    private AuthenticationCntl theAuthenticationCntl;
    
    public HoursTableModel()
    {
        
    }
    
    public HoursTableModel(FSE theFSE, AuthenticationCntl auth)
    {
        theAuthenticationCntl = auth;
        for(int i = 1; i < 8; i++)
        {
            theData.add(theFSE.getDayHours(i));
        }
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
                int x = row+1;
                switch(x)
                {
                    case 1:
                        return "Sunday";
                    case 2:
                        return "Monday";
                    case 3:
                        return "Tuesday";
                    case 4:
                        return "Wednesday";
                    case 5:
                        return "Thursday";
                    case 6:
                        return "Friday";
                    case 7:
                        return "Staurday";
                }
            break;
            case 1:
                return theData.get(row);
        }
        return null;
    }
    
}
