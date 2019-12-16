package persistence;

import logic.LightTolerance;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBLightTolerance{
    boolean testMode=false;

    public DBLightTolerance(boolean testMode){
        this.testMode=testMode;
    }

    public LightTolerance get(int id) {
        LightTolerance lt=null;

        String query="SELECT * FROM lighttolerance WHERE id = ? LIMIT 1";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)) {

                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    lt=new LightTolerance(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)) {

                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    lt = new LightTolerance(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return lt;
    }

    public ArrayList<LightTolerance>getAll(){
        ArrayList<LightTolerance> lts=new ArrayList<>();

        String query="SELECT * FROM lighttolerance";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 Statement st=conn.createStatement()){

                ResultSet rs=st.executeQuery(query);

                while(rs.next()){
                    LightTolerance lt=new LightTolerance(
                            rs.getInt("id"),
                            rs.getString("name")
                    );

                    lts.add(lt);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                Statement st=conn.createStatement()){

                ResultSet rs=st.executeQuery(query);

                while(rs.next()){
                    LightTolerance lt=new LightTolerance(
                            rs.getInt("id"),
                            rs.getString("name")
                    );

                    lts.add(lt);
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return lts;
    }

    public void create(LightTolerance lt) {
        String query="INSERT INTO lighttolerance(name) VALUES(?)";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,lt.getName());

                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1, lt.getName());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void edit(LightTolerance lt) {
        String query = "UPDATE lighttolerance SET name = ? " +
                "WHERE id = ?";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,lt.getName());
                ps.setInt(2,lt.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setString(1,lt.getName());
                ps.setInt(2,lt.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(LightTolerance lt) {
        String query = "DELETE FROM lighttolerance WHERE id = ?";

        if(testMode){
            try(Connection conn=DB.connect(testMode);
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setInt(1,lt.getId());

                ps.executeUpdate();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else{
            try(Connection conn=DB.connect();
                 PreparedStatement ps=conn.prepareStatement(query)){

                ps.setInt(1,lt.getId());

                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}