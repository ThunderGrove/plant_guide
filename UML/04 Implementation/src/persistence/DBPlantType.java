package persistence;

import logic.LightTolerance;
import logic.PlantType;

import java.sql.*;
import java.util.ArrayList;

public class DBPlantType {

    public PlantType get(int id) {
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

    public ArrayList<PlantType> getAll() {
        ArrayList<PlantType> pts = new ArrayList<>();

        String query = "SELECT * FROM planttype";

        try (Connection conn = DB.connect();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                PlantType pt = new PlantType(
                        rs.getInt("id"),
                        rs.getString("name")
                );

                pts.add(pt);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pts;

    }

    public void create(PlantType pt) {
        String query = "INSERT INTO planttype(name) VALUES(?)";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, pt.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(PlantType pt) {
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

    public void delete(PlantType pt) {
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
