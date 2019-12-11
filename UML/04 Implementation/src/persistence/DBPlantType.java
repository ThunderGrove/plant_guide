package persistence;

import logic.PlantType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPlantType {

    public static PlantType getPlantType(int id) {
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

}
