/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.PhieuDatPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_PhieuDatPhong implements I_CRUD<PhieuDatPhong>{

    public PhieuDatPhong getPhieuDatPhongByID(String id){
        PhieuDatPhong result = null;
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try {
 
            statement = con.prepareStatement("SELECT * FROM PhieuDatPhong Where maPhieuDatPhong = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {		
                result = new PhieuDatPhong(id, rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4), rs.getDouble(5), null, null, null, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
 
    }
    
    public void updateBill(String id){
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try {
 
            statement = con.prepareStatement("update PhieuDatPhong set trangThai = 1 where maPhieuDatPhong = ?");
            statement.setString(1, id);
            statement.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


