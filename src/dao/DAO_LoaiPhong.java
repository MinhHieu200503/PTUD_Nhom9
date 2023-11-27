/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_LoaiPhong implements I_CRUD<LoaiPhong>{
    public LoaiPhong getLoaiPhongTheoTen(String name) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        LoaiPhong lp = null;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select * from LoaiPhong where loaiPhong = ?");
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lp = new LoaiPhong(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    
}
