package com.mycompany.chen_ciftarslan_a2.db;

import static com.mycompany.chen_ciftarslan_a2.model.AvengerDb.conn;
import static com.mycompany.chen_ciftarslan_a2.model.AvengerDb.driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author  Hung-Han,Chen, Ali Cemilcan Ciftarslan

 */
public class DBConnector {

    private static Connection conn = null;


    public static Connection getConnection(String driver, String url, String databaseName, String username, String password) throws Exception {

        if (conn == null || conn.isClosed()) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url + databaseName, username, password);
            } catch (Exception e) {
                StringBuilder message = new StringBuilder(e.getMessage()).append("\n");
                if (e instanceof SQLException) {
                    message.append(((SQLException) e).getSQLState()).append("\n");
                    message.append(((SQLException) e).getErrorCode()).append("\n");
                    message.append(((SQLException) e).getMessage()).append("\n");
                }
                // throw the exception to the caller!
                throw new Exception(message.toString());
            }
        }
        return conn;
    }

    public static Connection getConnection(String driver, String herokuDbUrl) throws Exception {

        if (conn == null || conn.isClosed()) {
            // not set up yet...
            try {
                // load the class into the JVM. Doing runs the code that
                // registers the class as a JDBC driver
                Class.forName(driver);
                // get the connection from the DriverManager
                conn = DriverManager.getConnection(herokuDbUrl);

            } catch (Exception e) {
                // Build the error message
                StringBuilder message = new StringBuilder(e.getMessage()).append("\n");
                if (e instanceof SQLException) {
                    message.append(((SQLException) e).getSQLState()).append("\n");
                    message.append(((SQLException) e).getErrorCode()).append("\n");
                    message.append(((SQLException) e).getMessage()).append("\n");
                }
                // throw the exception to the caller!
                throw new Exception(message.toString());
            }
        }
        // return the connection
        return conn;
    }

    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ignored) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception ignored) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }

    }

    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        closeJDBCObjects(conn, stmt, null);
    }
}
