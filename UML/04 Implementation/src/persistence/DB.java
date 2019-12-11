package persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static Connection connect() {

        Connection conn = null;

        try  {
            // db parameters
            String url = "jdbc:sqlite:UML/04 Implementation/db/plantguide.db";
            // create connection
            conn = DriverManager.getConnection(url);

            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            // will crash the program, maybe handle differently?
            throw new RuntimeException("Connection to db failed.");
        }
    }

    public static void createTables() {

        File dbFile = new File("UML/04 Implementation/db/plantguide.db");

        if (!dbFile.exists()) {

            String lighttoleranceQuery = "CREATE TABLE IF NOT EXISTS lighttolerance (" +
                    "id integer PRIMARY KEY NOT NULL, " +
                    "lighttolerance text NOT NULL);";

            String planttypeQuery = "CREATE TABLE IF NOT EXISTS planttype (" +
                    "id integer PRIMARY KEY NOT NULL, " +
                    "planttype text NOT NULL);";

            String soiltypeQuery = "CREATE TABLE IF NOT EXISTS soiltype (" +
                    "id integer PRIMARY KEY NOT NULL, " +
                    "soiltype text NOT NULL);";

            String plantQuery = "CREATE TABLE IF NOT EXISTS plant ( " +
                    "id integer PRIMARY KEY NOT NULL, " +
                    "name text NOT NULL, " +
                    "soiltype integer NOT NULL, " +
                    "FOREIGN KEY(soiltype) REFERENCES soiltype(id), " +
                    "planttype integer NOT NULL, " +
                    "FOREIGN KEY(planttype) REFERENCES planttype(id), " +
                    "lighttolerance integer NOT NULL, " +
                    "FOREIGN KEY(lighttolerance) REFERENCES lighttolerance(id), " +
                    "extra text);";

            try (Connection conn = connect();
                Statement st = conn.createStatement()) {

                st.addBatch(lighttoleranceQuery);
                st.addBatch(planttypeQuery);
                st.addBatch(soiltypeQuery);
                st.addBatch(plantQuery);

                st.executeBatch();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
