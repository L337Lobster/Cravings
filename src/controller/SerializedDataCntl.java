/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cravings.FoodGroupList;
import model.SerializedDataModel;
import java.io.*;

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
            //readSerializedCollectionFile();
            theSerializedDataModel = new SerializedDataModel();
        }
        return theSerializedDataModel;
    }
    
     public void readSerializedDataModel(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String filePath = EXTERNAL_DATA_PATH+CRAVINGS_DATA_FILE_NAME;
        try
            {
            fis = new FileInputStream(filePath);
            in = new ObjectInputStream(fis);
            theSerializedDataModel = (SerializedDataModel) in.readObject();
            in.close();
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
     
     
     public void testPrintSerializedDataModel(){
         FoodGroupList testFGL = theSerializedDataModel.getFoodGroupList();
         for(int i = 0; i < testFGL.getListOfFoodGroups().size(); i++){
             String tempString = testFGL.getListOfFoodGroups().get(i).getFoodGroupDesc();
             System.out.println(tempString);
         }
     }
    
}