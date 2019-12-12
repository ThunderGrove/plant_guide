package logic;

import persistence.DBLightTolerance;
import persistence.DBPlantType;
import persistence.DBSoilType;

public class DummyData{
    static boolean dummyDataCreated=false;
    static DBPlantType dbPlantType=new DBPlantType();
    static DBSoilType dbSoilType=new DBSoilType();
    static DBLightTolerance dbLightTolerance=new DBLightTolerance();
    static PlantHandler ph=new PlantHandler();

    public static void createDummyData(){
        persistence.DB.createTables();
        dbSoilType.create(new SoilType(1,"1"));
        dbSoilType.create(new SoilType(2,"2"));
        dbSoilType.create(new SoilType(3,"3"));
        dbSoilType.create(new SoilType(4,"4"));
        dbPlantType.create(new PlantType(1,"1"));
        dbPlantType.create(new PlantType(2,"2"));
        dbPlantType.create(new PlantType(3,"3"));
        dbLightTolerance.create(new LightTolerance(1,"1"));
        ph.createPlant("Hortensia",1,4,1,"Hydrangéa");

        dummyDataCreated=true;
    }
}