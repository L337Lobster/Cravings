/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.SerializedDataCntl;
import cravings.Food;
import cravings.FoodGenre;
import cravings.FoodGenreList;
import cravings.FoodList;
import cravings.ViewType;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author srh10
 */
public class ExternalDataCntl {
    
    private final String EXTERNAL_DATA_PATH = "cravings_data\\";
    private final String FOOD_GENRE_FILE_NAME = "FD_GENRE.TXT";
    private final String FOOD_FILE_NAME = "FOOD_DES.txt";
    
    private FoodList theFoodList;
    private FoodGenreList theFoodGenreList;
    public ExternalDataCntl(){
        if(confirmImport()){
            getExternalFood();
        }
    }
    public void getExternalFood(){
        getFoodGenre();
        getFood();
        theFoodList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getTheFoodList();
        theFoodGenreList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodGenreList();
    }
    
    public void getFoodGenre(){
        String filePath = EXTERNAL_DATA_PATH+FOOD_GENRE_FILE_NAME;
        File foodGroupFile = new File(filePath);
        try{
            Scanner in = new Scanner(foodGroupFile);
            String nextLine = "";
        
            while(in.hasNextLine()){
                nextLine = in.nextLine();
               // System.out.println(nextLine);
                FoodGenre tmpFoodGenre = new FoodGenre(nextLine);
                SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodGenreList().getTheFoodGenreList().add(tmpFoodGenre);
            }
            // Simply prints the size of the newly imported FoodGroupList
            //System.out.println(SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getFoodGenreList().getTheFoodGenreList().size());
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        // Write the newly imported FoodGroupList to disk.
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
        // Read it back in.
        SerializedDataCntl.getSerializedDataCntl().readSerializedDataModel();
        // Test print to see if it worked.
        SerializedDataCntl.getSerializedDataCntl().testPrintSerializedDataModel(ViewType.FOOD_GENRE);
        
    }
    public void getFood(){
        String filePath = EXTERNAL_DATA_PATH+FOOD_FILE_NAME;
        File foodFile = new File(filePath);
        try{
            Scanner in = new Scanner(foodFile);
            String nextLine = "";
        
            while(in.hasNextLine()){
                nextLine = in.nextLine();
                //System.out.println(nextLine);
                Food tmpFood = new Food(nextLine);
                SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getTheFoodList().getTheFoodList().add(tmpFood);
            }
            // Simply prints the size of the newly imported FoodGroupList
            //System.out.println(SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getTheFoodList().getTheFoodList().size());
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        // Write the newly imported FoodList to disk.
        SerializedDataCntl.getSerializedDataCntl().writeSerializedDataModel();
        // Read it back in.
        SerializedDataCntl.getSerializedDataCntl().readSerializedDataModel();
        // Test print to see if it worked.
        SerializedDataCntl.getSerializedDataCntl().testPrintSerializedDataModel(ViewType.FOOD);
        
    }
    
    public boolean confirmImport(){
            boolean importConfirmed = false;
            String message = "Are you sure you want to import foods?";
            String title = "Import Foods";
            // display the JOptionPane showConfirmDialog
            int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                importConfirmed = true;
            }
            return importConfirmed;
    }

    /**
     * @return the theFoodList
     */
    public FoodList getTheFoodList() {
        return theFoodList;
    }

    /**
     * @return the theFoodGenreList
     */
    public FoodGenreList getTheFoodGenreList() {
        return theFoodGenreList;
    }
    
}
