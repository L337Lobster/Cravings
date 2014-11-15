/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AuthenticationCntl;
import cravings.DayOfTheWeek;
import cravings.FSE;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jackson Hofmann
 */
public class FseTableModel extends AbstractTableModel{
    
    private ArrayList<FSE> theData = new ArrayList();
    private String[] theColumns = new String[]{"Name", "Address", "Hours"}; 
    private AuthenticationCntl theAuthenticationCntl;
    
    public FseTableModel()
    {
        
    }
    public FseTableModel(ArrayList<FSE> theFseList, AuthenticationCntl auth)
    {
        theAuthenticationCntl = auth;
        theData = theFseList;
    }
    public void addFse(FSE theFSE)
    {
        theData.add(theFSE);
        fireTableDataChanged();
    }
    public void updateFseList(ArrayList<FSE> theFseList)
    {
        theData = theFseList;
        fireTableDataChanged();
    }
    public FSE removesedAt(int row)
    {
        return theData.remove(row);
    }
    public FSE getFseAt(int row)
    {
        return theData.get(row);
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
    public String getColumnName(int col) {
        return theColumns[col];
     }

    @Override
    public Object getValueAt(int row, int col) {
        FSE theFSE = (FSE) theData.get(row);
        switch(col)
        {
            case 0:
                return theFSE.getName();
            case 1:
                return theFSE.getAddress().getShortValue();
            case 2:
                Calendar c = Calendar.getInstance();
                c.setTime(c.getTime());
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                return String.format("%04d", theFSE.getDayOpenHour(dayOfWeek)) + " - " + String.format("%04d", theFSE.getDayCloseHour(dayOfWeek));
        }
        return null;
    }
    
}
