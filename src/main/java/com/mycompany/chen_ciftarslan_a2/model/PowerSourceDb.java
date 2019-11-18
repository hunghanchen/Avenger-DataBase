package com.mycompany.chen_ciftarslan_a2.model;

import com.mycompany.chen_ciftarslan_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * This class hold the powersources in an arrayList and return us to create new
 * avengers
 * @author Hung-Han, Chen & Ali Cemilcan, Ciftarslan
 */
public class PowerSourceDb {

    public static ArrayList<PowerSource> getPowerSources() throws Exception {
        //Creating an arrayList and holding the values
        ArrayList<PowerSource> powerSources = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String driver = "org.postgresql.Driver";

        //Initializing the database
        try {
            
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
                String connUrl = "jdbc:postgresql://localhost/";
                String database = "Chen_Ciftarslan_a2";
                String user = "postgres";
                String pass = "0316";

                conn = DBConnector.getConnection(driver, connUrl,
                        database, user, pass);
            }

            String sql = "SELECT * FROM powersource";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int powerSourceID = rs.getInt("id");
                String powerSourceName = rs.getString("description");
                powerSources.add(new PowerSource(powerSourceID, powerSourceName));
            }
            return powerSources;

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }

    }


    //use the another method store in powerSources arrayList first and catch directly
    public static PowerSource getPowerSource(int id) throws Exception {

        int amountOfPowerSource = getPowerSources().size();

        ArrayList<PowerSource> powerSources = getPowerSources();

        PowerSource powerSource = new PowerSource();

        for (int i = 0; i < amountOfPowerSource; i++) {
            if (id == powerSources.get(i).getId()) {
                powerSource = powerSources.get(i);
                return powerSource;
            }
        }
        return powerSource;
    }

}
