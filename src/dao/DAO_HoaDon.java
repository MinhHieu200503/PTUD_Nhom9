/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_HoaDon implements I_CRUD<HoaDon>{
    public ArrayList<String> getDsIdTheoNgayHienTai() {
        ArrayList<String> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "select mahoadon from hoadon where convert(date, ngayLapHoaDon) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ds.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
}
