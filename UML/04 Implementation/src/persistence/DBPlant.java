package persistence;

import logic.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBPlant{
    private boolean testMode=false;

    public DBPlant(boolean testMode){
        this.testMode=testMode;
    }

    public boolean checkName(String name) {
        boolean nameExists=false;
        int size=0;

        // sql query to be executed
        String query="SELECT count(id) as count FROM plant " +
                "WHERE name = ?";

        // try block with connection and prepared statement resources
        // resources are automatically terminated at the end of the block
        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                // set first value in prepared statement to the name parameter
                ps.setString(1,name);
                ResultSet rs=ps.executeQuery();
                // go to the next row of the result set
                rs.next();
                size=rs.getInt("count");
                if(size>0){
                    nameExists=true;
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                PreparedStatement ps=conn.prepareStatement(query)){

                // set first value in prepared statement to the name parameter
                ps.setString(1,name);
                ResultSet rs=ps.executeQuery();
                // go to the next row of the result set
                rs.next();
                size=rs.getInt("count");
                if(size>0){
                    nameExists=true;
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return nameExists;
    }

    public Plant getPlant(int id){
        Plant plant=null;
        PlantType plantType=null;
        SoilType soilType=null;
        LightTolerance lightTolerance=null;

        String query="SELECT p.id," +
                "p.name," +
                "pt.id AS ptid," +
                "pt.name AS planttype," +
                "st.id AS stid," +
                "st.name AS soiltype," +
                "lt.id AS ltid," +
                "lt.name AS lighttolerance," +
                "p.extra FROM plant AS p " +
                "INNER JOIN planttype AS pt ON p.planttype=pt.id " +
                "INNER JOIN soiltype AS st ON p.soiltype=st.id " +
                "INNER JOIN lighttolerance AS lt ON p.lighttolerance=lt.id " +
                "WHERE p.id = ? LIMIT 1";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                PreparedStatement ps=conn.prepareStatement(query)) {
                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    plantType=new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    soilType=new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    lightTolerance=new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    plant=new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")

                    );
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                PreparedStatement ps=conn.prepareStatement(query)){
                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();
                if (rs.next()){
                    plantType=new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    soilType=new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    lightTolerance=new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    plant=new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")
                    );
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return plant;
    }

    public ArrayList<Plant>getPlants() {
        ArrayList<Plant>plants=new ArrayList<>();

        String query="SELECT p.id," +
                "p.name," +
                "pt.id AS ptid," +
                "pt.name AS planttype," +
                "st.id AS stid," +
                "st.name AS soiltype," +
                "lt.id AS ltid," +
                "lt.name AS lighttolerance," +
                "p.extra FROM plant AS p " +
                "INNER JOIN planttype AS pt ON p.planttype=pt.id " +
                "INNER JOIN soiltype AS st ON p.soiltype=st.id " +
                "INNER JOIN lighttolerance AS lt ON p.lighttolerance=lt.id";
        if(testMode){
            try (Connection conn = DB.connect(testMode);
                 Statement st = conn.createStatement()) {

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    PlantType plantType = new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    SoilType soilType = new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    LightTolerance lightTolerance = new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    Plant plant = new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")
                    );
                    plants.add(plant);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn = DB.connect();
                 Statement st = conn.createStatement()){

                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    PlantType plantType = new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    SoilType soilType = new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    LightTolerance lightTolerance = new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    Plant plant = new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")
                    );
                    plants.add(plant);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return plants;
    }

    public ArrayList<Plant>getPlants(String request) {
        ArrayList<Plant> plants = new ArrayList<>();

        String query="SELECT p.id," +
                "p.name," +
                "pt.id AS ptid," +
                "pt.name AS planttype," +
                "st.id AS stid," +
                "st.name AS soiltype," +
                "lt.id AS ltid," +
                "lt.name AS lighttolerance," +
                "p.extra FROM plant AS p " +
                "INNER JOIN soiltype AS st ON p.soiltype=st.id " +
                "INNER JOIN planttype AS pt ON p.planttype=pt.id " +
                "INNER JOIN lighttolerance AS lt ON p.lighttolerance=lt.id " +
                "WHERE (p.name||st.name||pt.name||lt.name||extra) LIKE ? " +
                "ORDER BY p.name";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,"%"+request+"%");
                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    PlantType plantType=new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    SoilType soilType=new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    LightTolerance lightTolerance=new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    Plant plant=new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")
                    );
                    plants.add(plant);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,"%"+request+"%");
                ResultSet rs=ps.executeQuery();

                while(rs.next()){
                    PlantType plantType=new PlantType(
                            rs.getInt("ptid"),
                            rs.getString("planttype")
                    );
                    SoilType soilType=new SoilType(
                            rs.getInt("stid"),
                            rs.getString("soiltype")
                    );
                    LightTolerance lightTolerance=new LightTolerance(
                            rs.getInt("ltid"),
                            rs.getString("lighttolerance")
                    );
                    Plant plant=new Plant(
                            rs.getInt("id"),
                            rs.getString("name"),
                            soilType,
                            plantType,
                            lightTolerance,
                            rs.getString("extra")
                    );
                    plants.add(plant);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return plants;
    }

    public void create(Plant p){
        // set query string
        String query="INSERT INTO plant(name, soiltype, planttype, lighttolerance, extra) VALUES(?,?,?,?,?)";

        if(testMode){
            try(Connection conn = DB.connect(testMode);
                 PreparedStatement ps = conn.prepareStatement(query)) {

                // set prepared statement values
                ps.setString(1, p.getName());
                ps.setInt(2, p.getSoilType().getId());
                ps.setInt(3, p.getPlantType().getId());
                ps.setInt(4, p.getLighttolerance().getId());
                ps.setString(5, p.getExtra());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn = DB.connect();
                 PreparedStatement ps = conn.prepareStatement(query)){

                // set prepared statement values
                ps.setString(1, p.getName());
                ps.setInt(2, p.getSoilType().getId());
                ps.setInt(3, p.getPlantType().getId());
                ps.setInt(4, p.getLighttolerance().getId());
                ps.setString(5, p.getExtra());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void edit(Plant p) {
        String query="UPDATE plant SET name = ?, " +
                "soiltype = ?, " +
                "planttype = ?, " +
                "lighttolerance = ?, " +
                "extra = ? " +
                "WHERE id = ?;";
        if(testMode) {
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps = conn.prepareStatement(query)) {

                // set prepared statement values
                ps.setString(1,p.getName());
                ps.setInt(2,p.getSoilType().getId());
                ps.setInt(3,p.getPlantType().getId());
                ps.setInt(4,p.getLighttolerance().getId());
                ps.setString(5,p.getExtra());
                ps.setInt(6,p.getPlantID());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)) {

                // set prepared statement values
                ps.setString(1,p.getName());
                ps.setInt(2,p.getSoilType().getId());
                ps.setInt(3,p.getPlantType().getId());
                ps.setInt(4,p.getLighttolerance().getId());
                ps.setString(5,p.getExtra());
                ps.setInt(6,p.getPlantID());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(Plant p){
        String query="DELETE FROM plant WHERE id = ?";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps = conn.prepareStatement(query)) {

                // set prepared statement values
                ps.setInt(1,p.getPlantID());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try (Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)) {

                // set prepared statement values
                ps.setInt(1,p.getPlantID());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }
}