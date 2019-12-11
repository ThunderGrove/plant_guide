package logic;

public class PlantType{
    private int id;
    private String name;

    public PlantType(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}