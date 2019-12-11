package logic;

public class Plant{
    private int plantID;
    private int plantType;
    private int soilType;
    private int lighttolerance;
    private String comment;
    private String plantName;

    public Plant(int plantID,
                      String plantName,
                      int plantType,
                      int soilType,
                      int lighttolerance,
                      String comment
            ){
        this.plantID=plantID;
        this.comment=comment;
        this.plantName=plantName;
        this.plantType=plantType;
        this.soilType=soilType;
        this.lighttolerance=lighttolerance;
    }

    public int getPlanttype(){
        return plantType;
    }

    public void setPlantType(int plantType){
        this.plantType = plantType;
    }

    public int getSoiltype(){
        return soilType;
    }

    public void setSoilType(int soilType){
        this.soilType = soilType;
    }

    public int getLighttolerance(){
        return lighttolerance;
    }

    public void setLighttolerance(int lighttolerance){
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
