package persistence;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPlant {

    public static boolean checkName(String name) {
        boolean nameExists = false;
        int size = 0;

        // sql query to be executed
        String query = "SELECT count(id) FROM plant" +
                    "WHERE name = ?";

        // try block with connection and prepared statement resources
        // resources are automatically terminated at the end of the block
        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // set first value in prepared statement to the name parameter
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            // go to the last row of the result set
            rs.last();
            size = rs.getRow();

            if (size > 0) {
                nameExists = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nameExists;
    }

    public static void createPlant(Plant p) {

        // set query string
        String query = "INSERT INTO plant(name, soiltype, planttype, lighttolerance, extra) VALUES(?,?,?,?,?)";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            // set prepared statement values
            ps.setString(1, p.getName());
            ps.setInt(2, p.getSoiltype());
            ps.setInt(3, p.getPlanttype());
            ps.setInt(4, p.getLighttolerance());
            ps.setString(5, p.getExtra());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }

    }

}
