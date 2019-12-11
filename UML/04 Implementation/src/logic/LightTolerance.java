package logic;

public class LightTolerance{
    private int id;
    private String name;

    public LightTolerance(int id, String name){
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