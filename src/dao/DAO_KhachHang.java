/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_KhachHang implements I_CRUD<KhachHang>{
    // Vì phone là khoá chính và cho chỉnh trên phone nên phải viết hàm mới
    public boolean update(KhachHang entity, String oldPhone) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm = null;
        int n = 0;
        try {
            if(entity.getSoDienThoai().equals(oldPhone)){
                String sql = "update khachhang set tenKhachHang = ? where soDienThoai = " + oldPhone;
                pstm = con.prepareStatement(sql);
                pstm.setString(1, entity.getTenKhachHang());
                n = pstm.executeUpdate();
                return n > 0;
            } else {
                String sql = "update khachhang set soDienThoai = ? , tenKhachHang = ? where soDienThoai = " + oldPhone;
                pstm = con.prepareStatement(sql);
                pstm.setString(1, entity.getSoDienThoai());
                pstm.setString(2, entity.getTenKhachHang());
                n = pstm.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    
}
