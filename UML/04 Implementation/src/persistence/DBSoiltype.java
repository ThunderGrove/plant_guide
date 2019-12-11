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

}
