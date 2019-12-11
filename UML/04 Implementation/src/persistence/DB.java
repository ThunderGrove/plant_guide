package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
