/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.AbstractTableModel;
import model.FoodTableModel;

/**
 *
 * @author Jackson Hofmann
 */
public class FindFoodView extends javax.swing.JPanel {

    /**
     * Creates new form FindFoodView
     */
    private AbstractTableModel theTableModel;
    public FindFoodView(FoodTableModel foodModel) {
        initComponents();
        this.findFoodTable.setModel(foodModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        findFoodField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        findFoodTable = new javax.swing.JTable();
        findFoodTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 800));
        setMinimumSize(new java.awt.Dimension(600, 800));
        setLayout(new java.awt.GridBagLayout());

        findFoodField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        findFoodField.setMaximumSize(new java.awt.Dimension(200, 25));
        findFoodField.setMinimumSize(new java.awt.Dimension(200, 25));
        findFoodField.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(findFoodField, gridBagConstraints);

        findButton.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(findButton, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 600));

        findFoodTable.setAutoCreateRowSorter(true);
        findFoodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(findFoodTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        add(jScrollPane1, gridBagConstraints);

        findFoodTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        findFoodTitle.setText("Find A Food");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(findFoodTitle, gridBagConstraints);

        jButton1.setText("Find");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findButton;
    private javax.swing.JTextField findFoodField;
    private javax.swing.JTable findFoodTable;
    private javax.swing.JLabel findFoodTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the theTableModel
     */
    public AbstractTableModel getTheTableModel() {
        return theTableModel;
    }

    /**
     * @param theTableModel the theTableModel to set
     */
    public void setTheTableModel(AbstractTableModel theTableModel) {
        this.theTableModel = theTableModel;
    }

    /**
     * @return the findButton
     */
    public javax.swing.JButton getFindButton() {
        return findButton;
    }

    /**
     * @param findButton the findButton to set
     */
    public void setFindButton(javax.swing.JButton findButton) {
        this.findButton = findButton;
    }

    /**
     * @return the findFoodField
     */
    public javax.swing.JTextField getFindFoodField() {
        return findFoodField;
    }

    /**
     * @param findFoodField the findFoodField to set
     */
    public void setFindFoodField(javax.swing.JTextField findFoodField) {
        this.findFoodField = findFoodField;
    }

    /**
     * @return the findFoodTable
     */
    public javax.swing.JTable getFindFoodTable() {
        return findFoodTable;
    }

    /**
     * @param findFoodTable the findFoodTable to set
     */
    public void setFindFoodTable(javax.swing.JTable findFoodTable) {
        this.findFoodTable = findFoodTable;
    }

    /**
     * @return the findFoodTitle
     */
    public javax.swing.JLabel getFindFoodTitle() {
        return findFoodTitle;
    }

    /**
     * @param findFoodTitle the findFoodTitle to set
     */
    public void setFindFoodTitle(javax.swing.JLabel findFoodTitle) {
        this.findFoodTitle = findFoodTitle;
    }
}
