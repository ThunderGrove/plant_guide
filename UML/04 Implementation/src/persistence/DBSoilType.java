package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.SoilType;

public class DBSoilType {

    public SoilType get(int id) {
        SoilType st = null;

        String query = "SELECT * FROM soiltype WHERE id = ? LIMIT 1";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                st = new SoilType(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return st;

    }

    public void create(SoilType st) {

        String query = "INSERT INTO soiltype(name) VALUES(?)";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, st.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void edit(SoilType st) {

        String query = "UPDATE soiltype SET name = ? " +
                "WHERE id = ?";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, st.getName());
            ps.setInt(2, st.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SoilType st) {

        String query = "DELETE FROM plant WHERE id = ?";

        try (Connection conn = DB.connect();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, st.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
