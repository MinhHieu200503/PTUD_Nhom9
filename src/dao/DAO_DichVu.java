/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.*;
import connectDB.ConnectDB;
import entity.DichVu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_DichVu implements I_CRUD<DichVu>{
        
    public static String timMatheoTenDV (String tenDV){
        String maDV = "";
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            System.out.println("đã làm tới đây trước select");
            String sql = "select maDichVu from DichVu \n" +
                "where tenDichVu = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, tenDV);
            ResultSet rs = statement.executeQuery();
            System.out.println("sau sql, trc rs.next");
            rs.next();
            maDV += rs.getString("maDichVu");
            
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return maDV;
    }
    
    
}
