package persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB{
    static Connection connect(){
        Connection conn=null;

        try{
            // db parameters
            String url="jdbc:sqlite:UML/04 Implementation/db/plantguide.db";
            // create connection
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());

            // will crash the program, maybe handle differently?
            throw new RuntimeException("Connection to db failed.");
        }
        return conn;
    }

    static Connection connect(boolean testMode){
        Connection conn=null;
        if(testMode){
            try{
                // db parameters
                String url="jdbc:sqlite:UML/04 Implementation/db/test.db";
                // create connection
                conn=DriverManager.getConnection(url);
            }catch (SQLException e){
                System.out.println(e.getMessage());
                // will crash the program, maybe handle differently?
                throw new RuntimeException("Connection to db failed.");
            }

        }
        return conn;
    }

    public static void createTables(){
        File dbFile=new File("UML/04 Implementation/db/plantguide.db");

        if(!dbFile.exists()){
            String lighttoleranceQuery="CREATE TABLE IF NOT EXISTS lighttolerance (" +
                    "id integer PRIMARY KEY AUTOINCREMENT, " +
                    "name text NOT NULL);";

            String planttypeQuery="CREATE TABLE IF NOT EXISTS planttype (" +
                    "id integer PRIMARY KEY AUTOINCREMENT, " +
                    "name text NOT NULL);";

            String soiltypeQuery="CREATE TABLE IF NOT EXISTS soiltype (" +
                    "id integer PRIMARY KEY AUTOINCREMENT, " +
                    "name text NOT NULL);";

            String plantQuery="CREATE TABLE IF NOT EXISTS plant (" +
                    "id integer PRIMARY KEY AUTOINCREMENT, " +
                    "name text NOT NULL, " +
                    "soiltype integer NOT NULL, " +
                    "planttype integer NOT NULL, " +
                    "lighttolerance integer NOT NULL, " +
                    "extra text, " +
                    "FOREIGN KEY(soiltype) REFERENCES soiltype(id), " +
                    "FOREIGN KEY(planttype) REFERENCES planttype(id), " +
                    "FOREIGN KEY(lighttolerance) REFERENCES lighttolerance(id));";

            try(Connection conn = connect();
                Statement st = conn.createStatement()){

                st.addBatch(lighttoleranceQuery);
                st.addBatch(planttypeQuery);
                st.addBatch(soiltypeQuery);
                st.addBatch(plantQuery);

                st.executeBatch();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createTables(boolean testMode){
        if(testMode){
            File dbFile=new File("UML/04 Implementation/db/test.db");

            if(!dbFile.exists()){
                String lighttoleranceQuery="CREATE TABLE IF NOT EXISTS lighttolerance ( " +
                        "id integer PRIMARY KEY AUTOINCREMENT, " +
                        "name text NOT NULL);";

                String planttypeQuery="CREATE TABLE IF NOT EXISTS planttype ( " +
                        "id integer PRIMARY KEY AUTOINCREMENT, " +
                        "name text NOT NULL);";

                String soiltypeQuery="CREATE TABLE IF NOT EXISTS soiltype ( " +
                        "id integer PRIMARY KEY AUTOINCREMENT, " +
                        "name text NOT NULL);";

                String plantQuery="CREATE TABLE IF NOT EXISTS plant ( " +
                        "id integer PRIMARY KEY AUTOINCREMENT, " +
                        "name text NOT NULL, " +
                        "soiltype integer NOT NULL, " +
                        "planttype integer NOT NULL, " +
                        "lighttolerance integer NOT NULL, " +
                        "extra text, " +
                        "FOREIGN KEY(soiltype) REFERENCES soiltype(id), " +
                        "FOREIGN KEY(planttype) REFERENCES planttype(id), " +
                        "FOREIGN KEY(lighttolerance) REFERENCES lighttolerance(id));";

                try(Connection conn = connect(true);
                     Statement st = conn.createStatement()){

                    st.addBatch(lighttoleranceQuery);
                    st.addBatch(planttypeQuery);
                    st.addBatch(soiltypeQuery);
                    st.addBatch(plantQuery);

                    st.executeBatch();
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}