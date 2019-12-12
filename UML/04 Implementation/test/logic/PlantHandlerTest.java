package logic;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import persistence.DBLightTolerance;
import persistence.DBPlant;
import persistence.DBPlantType;
import persistence.DBSoilType;

class PlantHandlerTest{
    boolean dummyDataCreated=false;
    PlantHandler ph=new PlantHandler();
    DBPlantType dbPlantType=new DBPlantType();
    DBSoilType dbSoilType=new DBSoilType();
    DBLightTolerance dbLightTolerance=new DBLightTolerance();


    void createDummyData(){
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

    @Test
    void checkName(){
        if(!dummyDataCreated){
            createDummyData();
        }

        assertEquals(true,ph.checkName("Hortensia"),"Hortensia not found");
        assertEquals(false,ph.checkName("Horsia"),"Horsia was found");
    }

    @Test
    void getPlant(){
        if(!dummyDataCreated){
            createDummyData();
        }

        Plant plantOne=ph.getPlant(1);

        assertEquals(1,plantOne.getPlantID(),"plantID should be 1.");
        assertEquals(1,plantOne.getPlanttype(),"Plant type should be 1.");
        assertEquals(4,plantOne.getSoilType(),"Soil type should be 4.");
        assertEquals(1,plantOne.getLighttolerance(),"Light tolerance should be 1.");
        assertEquals("Hortensia",plantOne.getName(),"Plant name should be Hortensia.");
        assertEquals("Hydrangéa",plantOne.getExtra(),"The expected data in extra was incorrect.");
    }

    @Test
    void search(){
        if(!dummyDataCreated){
            createDummyData();
        }

        ArrayList<Plant> searchOne=ph.search("Hydrangéa");
        assertEquals(1,searchOne.size(),"Number of search results should only be one");

        ArrayList<Plant> searchTwo=ph.search("monster");
        assertEquals(0,searchTwo.size(),"Number of search results should zero");
    }

    @Test
    void editPlant(){
    }

    @Test
    void deletePlant(){
    }
}