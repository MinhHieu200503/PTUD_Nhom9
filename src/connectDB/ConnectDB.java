/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectDB;
import java.sql.*;
        

/**
 *
 * @author quang
 */
public class ConnectDB {
    public static Connection con = null;
    public static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        connect();
        return instance;
    } 
    public static void connect()  {
        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=KaraokeEcho";
        String user = "sa";
        String password = "123";
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(url, user, password);

        } catch(SQLException | ClassNotFoundException e) {
        }        
    }
    public static void disconnect() {
        if(con != null) {
            try {
                con.close();
            } catch(SQLException e) {
            }
        }
    }
    public static Connection getConnection() {
        return con;
    }
}
