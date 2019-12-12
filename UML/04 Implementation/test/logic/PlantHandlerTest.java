package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantHandlerTest{
    private boolean dummyDataCreated=false;
    PlantHandler ph=new PlantHandler();

    void createDummyData(){
        persistence.DB.createTables();
        persistence.DBSoilType.create(new SoilType(1,"1"));
        persistence.DBSoilType.create(new SoilType(2,"2"));
        persistence.DBSoilType.create(new SoilType(3,"3"));
        persistence.DBSoilType.create(new SoilType(4,"4"));
        persistence.DBPlantType.create(new PlantType(1,"1"));
        persistence.DBPlantType.create(new PlantType(2,"2"));
        persistence.DBPlantType.create(new PlantType(3,"3"));
        persistence.DBLightTolerance.createLightTolerance(new LightTolerance(1,"1"));
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
    }

    @Test
    void editPlant(){
    }

    @Test
    void deletePlant(){
    }

    @Test
    void search(){
    }

}