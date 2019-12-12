package persistence;

import logic.PlantType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPlantType {

    public static PlantType get(int id) {
        PlantType pt = null;

        String query = "SELECT * FROM planttype WHERE id = ? LIMIT 1";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pt = new PlantType(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pt;

    }

    public static void create(PlantType pt) {
        String query = "INSERT INTO planttype(name) VALUES(?)";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, pt.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void edit(PlantType pt) {
        String query = "UPDATE planttype SET name = ? " +
                "WHERE id = ?";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, pt.getName());
            ps.setInt(2, pt.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(PlantType pt) {
        String query = "DELETE FROM plant WHERE id = ?";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, pt.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
