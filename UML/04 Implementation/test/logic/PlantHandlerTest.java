package logic;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PlantHandlerTest{
    PlantHandler ph=new PlantHandler(true);

    @Test
    void checkName(){
        if(!DummyData.dummyDataCreated){
            DummyData.createDummyData();
        }

        assertEquals(true,ph.checkName("Hortensia"),"Hortensia not found");
        assertEquals(false,ph.checkName("Horsia"),"Horsia was found");
    }

    @Test
    void getPlant(){
        if(!DummyData.dummyDataCreated){
            DummyData.createDummyData();
        }

        Plant plantOne=ph.getPlant(1);

        assertEquals(1,plantOne.getPlantID(),"plantID should be 1.");
        assertEquals(1,plantOne.getPlantType().getId(),"Plant type should be 1.");
        assertEquals(4,plantOne.getSoilType().getId(),"Soil type should be 4.");
        assertEquals(1,plantOne.getLighttolerance().getId(),"Light tolerance should be 1.");
        assertEquals("Hortensia",plantOne.getName(),"Plant name should be Hortensia.");
        assertEquals("Hydrangéa",plantOne.getExtra(),"The expected data in extra was incorrect.");
    }

    @Test
    void search(){
        if(!DummyData.dummyDataCreated){
            DummyData.createDummyData();
        }

        ArrayList<Plant> searchOne=ph.search("Hydrangéa");
        assertEquals(1,searchOne.size(),"Number of search results should only be one");

        ArrayList<Plant> searchTwo=ph.search("monster");
        assertEquals(0,searchTwo.size(),"Number of search results should zero");
    }

    @Test
    void editPlant(){
        if(!DummyData.dummyDataCreated){
            DummyData.createDummyData();
        }

        ph.editPlant(1,"Hortensia",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"Navn på latin: Hydrangéa");
        Plant plantOne=ph.getPlant(1);
        assertEquals("Navn på latin: Hydrangéa",plantOne.getExtra(),"The expected data was not updated.");
        ph.editPlant(1,"Hortensia",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"Hydrangéa");
    }

    @Test
    void createPlant(){
        ph.createPlant("JustATest",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"This is just a test.");

        assertNotEquals(0,ph.search("JustATest").size(),"Unable to add a new row to db.");
    }

    @Test
    void createAndDeletePlant(){
        ph.createPlant("JustATest",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"This is just a test.");

        assertNotEquals(0,ph.search("JustATest").size(),"Unable to add a new row to db.");

        ArrayList<Plant> result=ph.search("JustATest");

        if(result.size()>0){
            ph.deletePlant(result.get(0).getPlantID());
            assertNotEquals(result.size(),ph.search("JustATest").size(),"Nothing was deleted.");
        }
    }
}