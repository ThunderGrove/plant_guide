package logic;

import java.util.ArrayList;
import persistence.DBPlant;

public class PlantHandler{
    DBPlant persistence=new DBPlant();

    public Plant getPlant(int plantId){
        return persistence.getPlant(plantId);
    }

    public void createPlant(String plantName,int plantType,int soilType,int lighttolerance,String comment){
        Plant plant=null;
        plant.setPlantName(plantName);
        plant.setPlantType(plantType);
        plant.setSoilType(soilType);
        plant.setLighttolerance(lighttolerance);
        plant.setComment(comment);

        persistence.createPlant(plant);
    }

    public void editPlant(int plantId,String plantName,int plantType,int soilType,int lighttolerance,String comment){
        Plant plant=null;
        plant.setPlantID(plantId);
        plant.setPlantName(plantName);
        plant.setPlantType(plantType);
        plant.setSoilType(soilType);
        plant.setLighttolerance(lighttolerance);
        plant.setComment(comment);
        persistence.editPlant(plant);
    }

    public void deletePlant(int plantId){
        Plant plant=null;
        plant.setPlantID(plantId);
        persistence.deletePlant(plant);
    }

    public ArrayList<Plant>search(String request){
        return null;
    }

    public ArrayList<Plant>search(){
        return persistence.getPlants();
    }

    public boolean checkName(String name){
        return persistence.checkName(name);
    }
}