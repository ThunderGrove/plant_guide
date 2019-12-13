package logic;

import java.util.ArrayList;
import persistence.DBPlant;
import persistence.DBSoilType;
import persistence.DBLightTolerance;
import persistence.DBPlantType;

public class PlantHandler{
    DBPlant persistence=new DBPlant();

    public Plant getPlant(int plantId){
        return persistence.getPlant(plantId);
    }

    public void createPlant(String plantName,
                            PlantType plantType,
                            SoilType soilType,
                            LightTolerance lighttolerance,
                            String comment){
        Plant plant=new Plant();
        plant.setPlantName(plantName);
        plant.setPlantType(plantType);
        plant.setSoilType(soilType);
        plant.setLighttolerance(lighttolerance);
        plant.setComment(comment);

        persistence.create(plant);
    }

    public void editPlant(int plantId,
                          String plantName,
                          PlantType plantType,
                          SoilType soilType,
                          LightTolerance lighttolerance,
                          String comment){
        Plant plant=new Plant();
        plant.setPlantID(plantId);
        plant.setPlantName(plantName);
        plant.setPlantType(plantType);
        plant.setSoilType(soilType);
        plant.setLighttolerance(lighttolerance);
        plant.setComment(comment);
        persistence.edit(plant);
    }

    public void deletePlant(int plantId){
        Plant plant=new Plant();;
        plant.setPlantID(plantId);
        persistence.delete(plant);
    }

    public ArrayList<Plant>search(String request){
        return persistence.getPlants(request);
    }

    public ArrayList<Plant>search(){
        return persistence.getPlants();
    }

    public boolean checkName(String name){
        return persistence.checkName(name);
    }

    public ArrayList<SoilType>getAllSoilTypes(){
        DBSoilType dbSoilType=new DBSoilType();
        return dbSoilType.getAll();
    }

    public ArrayList<PlantType>getAllPlantTypes(){
        DBPlantType dbPlantType=new DBPlantType();
        return dbPlantType.getAll();
    }

    public ArrayList<LightTolerance>getAllLightTolerances(){
        DBLightTolerance dbLightTolerance=new DBLightTolerance();
        return dbLightTolerance.getAll();
    }
}