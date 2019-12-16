package persistence;

import java.sql.*;
import java.util.ArrayList;

import logic.LightTolerance;
import logic.SoilType;

public class DBSoilType{
    boolean testMode=false;

    public DBSoilType(boolean testMode){
        this.testMode=testMode;
    }

    public SoilType get(int id) {
        SoilType st = null;

        String query = "SELECT * FROM soiltype WHERE id = ? LIMIT 1";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    st=new SoilType(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn = DB.connect();
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
        }

        return st;
    }

    public void create(SoilType st){
        String query="INSERT INTO soiltype(name) VALUES(?)";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1, st.getName());

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,st.getName());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public ArrayList<SoilType> getAll() {
        ArrayList<SoilType> sts = new ArrayList<>();

        String query = "SELECT * FROM soiltype";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 Statement st=conn.createStatement()) {

                ResultSet rs=st.executeQuery(query);

                while(rs.next()){
                    SoilType soilType=new SoilType(
                            rs.getInt("id"),
                            rs.getString("name")
                    );

                    sts.add(soilType);
                }

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 Statement st=conn.createStatement()){

                ResultSet rs=st.executeQuery(query);

                while(rs.next()){
                    SoilType soilType=new SoilType(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                    sts.add(soilType);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return sts;
    }

    public void edit(SoilType st){
        String query="UPDATE soiltype SET name = ? " +
                "WHERE id = ?";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)) {

                ps.setString(1,st.getName());
                ps.setInt(2,st.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,st.getName());
                ps.setInt(2,st.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(SoilType st) {
        String query="DELETE FROM soiltype WHERE id = ?";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setInt(1,st.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)) {

                ps.setInt(1,st.getId());

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}