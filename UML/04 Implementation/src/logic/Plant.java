package logic;

public class Plant{
    private int plantType;
    private int soilType;
    private int lighttolerance;
    private String comment;
    private String plantName;

    public int getPlanttype() {
        return plantType;
    }

    public void setPlantType(int plantType) {
        this.plantType = plantType;
    }

    public int getSoiltype() {
        return soilType;
    }

    public void setSoilType(int soilType) {
        this.soilType = soilType;
    }

    public int getLighttolerance() {
        return lighttolerance;
    }

    public void setLighttolerance(int lighttolerance) {
        this.lighttolerance = lighttolerance;
    }

    public String getExtra() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}
