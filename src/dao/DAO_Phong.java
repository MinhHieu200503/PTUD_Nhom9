/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

/**
 *
 * @author quang
 */
public class DAO_Phong implements I_CRUD<Phong>{
    
    public boolean capNhatTrangThaiPhong(String maPhong, int TrangThai) {

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {

            statement = con.prepareStatement("update Phong set trangThai =?  "
                    + "						where maPhong=?");

            statement.setInt(1, TrangThai);

            statement.setString(2, maPhong);

            n = statement.executeUpdate();

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
        return n > 0;
    }
    
    public ArrayList<entity.Phong> getPhongTheoTrangThai(int trangthai) {
        
        ArrayList<entity.Phong> dsphong = new ArrayList<entity.Phong>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "Select * from Phong where trangThai=?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, trangthai);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
//			
                dsphong.add(new entity.Phong(rs.getString(1).trim(), rs.getString(2), rs.getInt(3), I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) ));
                    

            }
             System.out.println(dsphong);
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
        return dsphong;
    }
    
}
