/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChitTietPhongHoaDon;
import entity.LoaiPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public boolean capNhatGhiChu(String maPhong,String maHoaDon,String GhiChu) {
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {

            statement = con.prepareStatement("update ChiTietPhongHoaDon\n" +
                                                "set ghiChu = ?" +
                                                "where maPhong = ? and maHoaDon = ?    ");

            statement.setString(1, GhiChu);

            statement.setString(2, maPhong);
             statement.setString(3, maHoaDon);
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
    
    public entity.ChitTietPhongHoaDon layChiTietPhongHoaDonDuaTrenMaPhong(String maPhong){
        entity.ChitTietPhongHoaDon ctphd = null;

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "select * from ChiTietPhongHoaDon \n" +
                        "where maPhong = ? and  ghiChu like N'%Đang sử dụng%'";
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {	
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime thoiGianNhanPhong = LocalDateTime.parse(rs.getString(1),formatter);
                
                ctphd = new ChitTietPhongHoaDon(thoiGianNhanPhong, null, rs.getString(3), I_CRUD.findById(rs.getString(4), new entity.HoaDon()), I_CRUD.findById(rs.getString(5),new entity.Phong()));
            }
             
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
        return ctphd;
        
    }
}
