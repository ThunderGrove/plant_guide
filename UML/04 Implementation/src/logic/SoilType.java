package logic;

public class SoilType{
    private int id;
    private String name;

    public SoilType(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}