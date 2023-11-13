/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql = "update khachhang set soDienThoai = ? , tenKhachHang = ? where soDienThoai = " + oldPhone;
            pstm = con.prepareStatement(sql);
            pstm.setString(1, entity.getSoDienThoai());
            pstm.setString(2, entity.getTenKhachHang());
            n = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    
    public ArrayList<entity.KhachHang> getAllKhachHang(){
        ArrayList<entity.KhachHang> dsKhachHang =new ArrayList<entity.KhachHang>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "select * from KhachHang";
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
//			
                dsKhachHang.add(new entity.KhachHang(rs.getString(1).trim(), rs.getString(2) ));
            }
        } catch (Exception e) {
        } finally {
        }
        return dsKhachHang;
    }
    
    
    
    
}
