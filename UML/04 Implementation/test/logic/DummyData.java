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
        dbSoilType.create(new SoilType(1,"Ler/Silt"));
        dbSoilType.create(new SoilType(2,"Sand"));
        dbSoilType.create(new SoilType(3,"Kalk"));
        dbSoilType.create(new SoilType(4,"Sur"));
        dbPlantType.create(new PlantType(1,"Busk"));
        dbPlantType.create(new PlantType(2,"Stauder"));
        dbPlantType.create(new PlantType(3,"Slyngplanter"));
        dbLightTolerance.create(new LightTolerance(1,"Sol"));
        dbLightTolerance.create(new LightTolerance(2,"Skygge"));
        dbLightTolerance.create(new LightTolerance(3,"Tolerant"));

        ph.createPlant("Hortensia",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"Hydrangéa");

        dummyDataCreated=true;
    }
}