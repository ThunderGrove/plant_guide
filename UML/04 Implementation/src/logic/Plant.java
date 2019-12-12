package logic;

public class Plant{
    private int plantID;
    private PlantType plantType;
    private SoilType soilType;
    private LightTolerance lighttolerance;
    private String comment;
    private String plantName;

    public Plant(){}

    public Plant(int plantID,
                 String plantName,
                 SoilType soilType,
                 PlantType plantType,
                 LightTolerance lightTolerance,
                 String comment
            ){
        this.plantID=plantID;
        this.comment=comment;
        this.plantName=plantName;
        this.plantType=plantType;
        this.soilType=soilType;
        this.lighttolerance=lightTolerance;
    }

    public PlantType getPlantType(){
        return plantType;
    }

    public void setPlantType(PlantType plantType){
        this.plantType = plantType;
    }

    public SoilType getSoilType(){
        return soilType;
    }

    public void setSoilType(SoilType soilType){
        this.soilType = soilType;
    }

    public LightTolerance getLighttolerance(){
        return lighttolerance;
    }

    public void setLighttolerance(LightTolerance lighttolerance){
        this.lighttolerance = lighttolerance;
    }

    public String getExtra(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getName(){
        return plantName;
    }

    public void setPlantName(String plantName){
        this.plantName = plantName;
    }

    public int getPlantID(){
        return plantID;
    }

    public void setPlantID(int plantID){
        this.plantID = plantID;
    }
}
