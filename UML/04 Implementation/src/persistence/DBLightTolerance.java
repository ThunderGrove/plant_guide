package persistence;

import logic.LightTolerance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLightTolerance {

    public static LightTolerance getLightTolerance(int id) {
        LightTolerance lt = null;

        String query = "SELECT * FROM lighttolerance WHERE id = ? LIMIT 1";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lt = new LightTolerance(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lt;
    }

    public static void createLightTolerance(LightTolerance lt) {
        String query = "INSERT INTO lighttolerance(name) VALUES(?)";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, lt.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editLightTolerance(LightTolerance lt) {
        String query = "UPDATE lighttolerance SET name = ? " +
                "WHERE id = ?";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, lt.getName());
            ps.setInt(2, lt.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
