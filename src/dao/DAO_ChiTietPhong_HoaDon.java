/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChitTietPhongHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_ChiTietPhong_HoaDon implements I_CRUD<ChitTietPhongHoaDon>{

    public boolean themCTHD_PMoi(ChitTietPhongHoaDon cTHD_P) {
		ConnectDB.getInstance().connect();
		Connection con = (Connection) ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into ChiTietPhongHoaDon values(?,null,?,?,?)");
                        pstm.setString(1, I_CRUD.JavaToSQL(cTHD_P.getThoiGianNhanPhong()));
			
                        pstm.setString(2, cTHD_P.getGhiChu());
                        pstm.setString(3, cTHD_P.getHoaDon().getMaHoaDon());
			pstm.setString(4, cTHD_P.getPhong().getMaPhong());
			
//			pstm.setString(4, chuyenLocalSangDateTime(cTHD_P.getGioRa()));
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
    
    public void updateBill(String ghiChu, String maHD, String maPhong, String maUuDai){
               ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try {
 
            statement = con.prepareStatement("update HoaDon set trangThai = 1, maUuDai = ? where maHoaDon = ?");
            statement.setString(1, maUuDai);
            statement.setString(2, maHD);
            statement.executeUpdate();
            
            
            
            statement = con.prepareStatement("update ChiTietPhongHoaDon set thoiGianTraPhong = ?, ghiChu = ? where maHoaDon = ? and maPhong = ?");
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(2, ghiChu);
            statement.setString(3, maHD);
            statement.setString(4, maPhong);
            statement.executeUpdate();
            
            statement = con.prepareStatement("update Phong set trangThai = 0 where maPhong = ?");
            statement.setString(1, maPhong);
            statement.executeUpdate();
            
            


        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
