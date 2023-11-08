/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author quang
 */
public class DAO_ChucVu implements I_CRUD<ChucVu>{
    public ChucVu getChucVuTheoTen(String name) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        ChucVu cv = null;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select * from ChucVu where tenChucVu = ?");
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cv = new ChucVu(rs.getString(1), name, rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChucVu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cv;
    }
}
