/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.Ca;
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
public class DAO_Ca implements I_CRUD<Ca>{
    public Ca getCaTheoTen(String name) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        Ca ca = null;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select * from Ca where tenCa = ?");
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ca = new Ca(rs.getString(1), name, rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Ca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ca;
    }

}
