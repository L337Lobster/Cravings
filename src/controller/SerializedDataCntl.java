/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FoodGenreList;
import cravings.FoodList;
import cravings.ViewType;
import java.io.*;
import model.SerializedDataModel;

/**
 *
 * @author SHaynes
 */
public class SerializedDataCntl {
    
    private SerializedDataModel theSerializedDataModel;
    private static SerializedDataCntl theSerializedDataCntl;
    private final String EXTERNAL_DATA_PATH = "cravings_data\\";
    private final String CRAVINGS_DATA_FILE_NAME = "CravingsData.ser";
    
    //Private to prevent instantiation.
    private SerializedDataCntl(){
        getSerializedDataModel();
    }
    
    //Singleton design pattern ensures there is only ever one SerializedCollectionCntl.
    public static SerializedDataCntl getSerializedDataCntl(){
        if(theSerializedDataCntl == null){
            theSerializedDataCntl = new SerializedDataCntl();
        }
        return theSerializedDataCntl;
    }
    
    // Returns the serialized data model
    // Creates test data if it is null
    public SerializedDataModel getSerializedDataModel(){
        if(theSerializedDataModel == null){
            readSerializedDataModel();
            if(theSerializedDataModel == null)
            {
                theSerializedDataModel = new SerializedDataModel();
            }
        }
        return theSerializedDataModel;
    }
    
     public void readSerializedDataModel(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String filePath = EXTERNAL_DATA_PATH+CRAVINGS_DATA_FILE_NAME;
        try
        {
            File f = new File(filePath);
            if(f.exists())
            {
                fis = new FileInputStream(filePath);
                in = new ObjectInputStream(fis);
                theSerializedDataModel = (SerializedDataModel) in.readObject();
                in.close();
            }
        }
        catch(IOException ex)
            {
            ex.printStackTrace();
            }
        catch(ClassNotFoundException ex)
            {
            ex.printStackTrace();
            }
       }

    
     public void writeSerializedDataModel(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        String filePath = EXTERNAL_DATA_PATH+CRAVINGS_DATA_FILE_NAME;
        try
            {
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(theSerializedDataModel);
            out.close();
            }
        catch(IOException ex)
            {
            ex.printStackTrace();
            }
       }
     
     
     public void testPrintSerializedDataModel(ViewType type){
         if(type == ViewType.FOOD_GENRE)
         {
             System.out.println("Test");
            FoodGenreList testFGL = theSerializedDataModel.getFoodGenreList();
            for(int i = 0; i < testFGL.getTheFoodGenreList().size(); i++)
            {
               String tempString = testFGL.getTheFoodGenreList().get(i).getName();
               System.out.println(tempString);
            }
         }
         if(type == ViewType.FOOD)
         {
            FoodList testFGL = theSerializedDataModel.getTheFoodList();
            for(int i = 0; i < testFGL.getTheFoodList().size(); i++)
            {
               String tempString = testFGL.getTheFoodList().get(i).toString();
               System.out.println(tempString);
            }
         }
     }
    
}
