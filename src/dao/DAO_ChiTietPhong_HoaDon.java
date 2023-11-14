/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChitTietPhongHoaDon;
import entity.HoaDon;
import entity.Phong;
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
    public ArrayList<ChitTietPhongHoaDon> getDStheoMaPhong(String maphong) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getInstance().getConnection();
        PreparedStatement pstm = null;
        ArrayList<ChitTietPhongHoaDon> ds = new ArrayList<>();
        try {
            pstm = con.prepareStatement("select * from chitietphonghoadon where maphong = ?");
            pstm.setString(1, maphong);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = I_CRUD.findById(rs.getString("maHoaDon"), new HoaDon());
                Phong p = I_CRUD.findById(rs.getString("maPhong"), new Phong());
                LocalDateTime in = I_CRUD.SQLtoJava(rs.getString(1));
                LocalDateTime out = I_CRUD.SQLtoJava(rs.getString(2));
                String ghichu = rs.getString(3);
                ChitTietPhongHoaDon ctp = new ChitTietPhongHoaDon(in, out, ghichu, hd, p);
                ds.add(ctp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }
    public boolean updateGioRa(String map, String mahd, LocalDateTime giora, String ghiChu) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm = null;
        int n = 0;
        try {
            pstm = con.prepareStatement("update chitietphonghoadon set thoigiantraphong = ?, ghichu = ? where maphong = ? and mahoadon = ?");
            pstm.setString(1, I_CRUD.JavaToSQL(giora));
            pstm.setString(2, ghiChu);
            pstm.setString(3, map);
            pstm.setString(4, mahd);
            n = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    public ArrayList<String> getDsIdTheoMaHoaDon(String idhoadon) {
        ArrayList<String> dsidphong = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select maphong from chitietphonghoadon where maHoaDon = ?");
            pstm.setString(1, idhoadon);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                dsidphong.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsidphong;
    }
}
