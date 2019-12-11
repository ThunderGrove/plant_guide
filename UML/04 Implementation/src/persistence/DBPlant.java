package persistence;

import logic.PlantHandler;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import logic.Plant;

public class DBPlant {

    public static boolean checkName(String name) {
        boolean nameExists = false;
        int size = 0;

        // sql query to be executed
        String query = "SELECT count(id) as count FROM plant " +
                "WHERE name = ?";

        // try block with connection and prepared statement resources
        // resources are automatically terminated at the end of the block
        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // set first value in prepared statement to the name parameter
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            // go to the next row of the result set
            rs.next();
            size = rs.getInt("count");
            if (size > 0) {
                nameExists = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nameExists;
    }

    public static Plant getPlant(int id) {
        Plant plant = null;

        String query = "SELECT * FROM plant WHERE id = ? LIMIT 1";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                plant = new Plant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("soiltype"),
                        rs.getInt("planttype"),
                        rs.getInt("lighttolerance"),
                        rs.getString("extra")

                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return plant;

    }

    public static ArrayList<Plant> getPlants() {
        ArrayList<Plant> plants = new ArrayList<Plant>();

        String query = "SELECT * FROM plant";

        try (Connection conn = DB.connect();
            Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Plant plant = new Plant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("soiltype"),
                        rs.getInt("planttype"),
                        rs.getInt("lighttolerance"),
                        rs.getString("extra")
                );

                plants.add(plant);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return plants;

    }

    public static ArrayList<Plant> getPlants(String request) {
        ArrayList<Plant> plants = new ArrayList<Plant>();

        String query = "SELECT * FROM plant AS p " +
                "INNER JOIN soiltype AS st ON p.soiltype=st.id " +
                "INNER JOIN planttype AS pt ON p.planttype=pt.id " +
                "INNER JOIN lighttolerance AS lt ON p.lighttolerance=lt.id " +
                "WHERE plant MATCH '?' " +
                "ORDER BY rank";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, request);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plant plant = new Plant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("planttype"),
                        rs.getInt("soiltype"),
                        rs.getInt("lighttolerance"),
                        rs.getString("extra")
                );

                plants.add(plant);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return plants;
    }

    public static void createPlant(Plant p) {

        // set query string
        String query = "INSERT INTO plant(name, soiltype, planttype, lighttolerance, extra) VALUES(?,?,?,?,?)";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            // set prepared statement values
            ps.setString(1, p.getName());
            ps.setInt(2, p.getSoilType());
            ps.setInt(3, p.getPlanttype());
            ps.setInt(4, p.getLighttolerance());
            ps.setString(5, p.getExtra());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void editPlant(Plant p) {

        String query = "UPDATE plant SET name = '?' , " +
                "soiltype = ? , " +
                "planttype = ? , " +
                "lighttolerance = ? , " +
                "extra = '?' " +
                "WHERE id = ?;";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            // set prepared statement values
            ps.setString(1, p.getName());
            ps.setInt(2, p.getSoilType());
            ps.setInt(3, p.getPlanttype());
            ps.setInt(4, p.getLighttolerance());
            ps.setString(5, p.getExtra());
            ps.setInt(6, p.getPlantID());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void deletePlant(Plant p) {

        String query = "DELETE FROM plant WHERE id = ?";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            // set prepared statement values
            ps.setInt(1, p.getPlantID());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
