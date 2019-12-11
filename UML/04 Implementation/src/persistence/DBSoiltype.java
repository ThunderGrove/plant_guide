package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBSoiltype {

    public static void createSoiltype(Soiltype st) {

        String query = "INSERT INTO soiltype(name) VALUES(?)";

        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, st.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void editSoiltype(Soiltype st) {

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

}
