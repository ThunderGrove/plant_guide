package logic;

import java.util.ArrayList;
import java.util.List;
import persistence.DBPlant;

public class PlantHandler{
    DBPlant persistence=new DBPlant();

    public ArrayList<String>getPlant(int plantId){
        return null;
    }

    public int createPlant(String plantName,int plantType,int soilType,int lighttolerance,String comment){

        return 0;
    }

    public int editPlant(String plantName,int plantType,int soilType,int lighttolerance,String comment){
        return 0;
    }

    public int deletePlant(int plantId){
        return 0;
    }

    public ArrayList<List>search(String request){
        return null;
    }

    public boolean checkName(String name){
        return persistence.checkName(name);
    }
}