/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietDichVuHoaDon;
import entity.ChitTietPhongHoaDon;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import connectDB.ConnectDB;
import entity.DichVu;
import entity.HoaDon;
import entity.Phong;
/**
 *
 * @author quang
 */
public class DAO_ChiTietDichVu_HoaDon implements I_CRUD<ChiTietDichVuHoaDon>{

    public ArrayList<ChiTietDichVuHoaDon> getDSDVdangSuDung(String maPhong, String maHoaDon) {
        ArrayList<ChiTietDichVuHoaDon> dsCTDV = new ArrayList<ChiTietDichVuHoaDon>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "select * from ChiTietDichVuHoaDon\n" +
                    "where maPhong = ? and maHoaDon = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            statement.setString(2, maHoaDon);
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                dsCTDV.add(new ChiTietDichVuHoaDon(rs.getInt("soLuong"), I_CRUD.findById(rs.getString("maDichVu"), new DichVu()), 
                        I_CRUD.findById(maHoaDon, new HoaDon()), I_CRUD.findById(maPhong, new Phong())));

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
        return dsCTDV;
    }
    
    public ChiTietDichVuHoaDon timChiTietDichVuHoaDon(String maPhong, String maHoaDon, String maDichVu) {
        
        ChiTietDichVuHoaDon cthd = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "select * from ChiTietDichVuHoaDon\n" +
                        "where maPhong = ? and maHoaDon = ? and maDichVu = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            statement.setString(2, maHoaDon);
            statement.setString(3, maDichVu);
            ResultSet rs = statement.executeQuery();
            rs.next();
            cthd = new ChiTietDichVuHoaDon(rs.getInt("soLuong"), I_CRUD.findById(rs.getString("maDichVu"), new DichVu()), 
                        I_CRUD.findById(maHoaDon, new HoaDon()), I_CRUD.findById(maPhong, new Phong()));
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
        return cthd;
    }
    
     public boolean themCTHD_DvMoi(ChiTietDichVuHoaDon cTDV) {
		ConnectDB.getInstance().connect();
		Connection con = (Connection) ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into ChiTietDichVuHoaDon \n" +
                                        "values(?, ?, ?, ?)");
                        pstm.setInt(1, cTDV.getSoLuong());
			
                        pstm.setString(2, cTDV.getDichVu().getMaDichVu());
                        pstm.setString(3, cTDV.getHoaDon().getMaHoaDon());
			pstm.setString(4, cTDV.getPhong().getMaPhong());
			
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
     
     
     public boolean upDateSoLuong(ChiTietDichVuHoaDon cTDV) {
		ConnectDB.getInstance().connect();
		Connection con = (Connection) ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("update ChiTietDichVuHoaDon\n" +
                            "set soLuong = ?\n" +
                            "where maDichVu = ? and maHoaDon = ? and maPhong = ?");
                        pstm.setInt(1, cTDV.getSoLuong());
			
                        pstm.setString(2, cTDV.getDichVu().getMaDichVu());
                        pstm.setString(3, cTDV.getHoaDon().getMaHoaDon());
			pstm.setString(4, cTDV.getPhong().getMaPhong());
			
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
     
     
      public boolean xoaMotCTDV(String maDV, String maHD, String maPhong) {
		ConnectDB.getInstance().connect();
		Connection con = (Connection) ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("delete from ChiTietDichVuHoaDon\n" +
                                    "where maDichVu = ? and maHoaDon = ? and maPhong = ?");
                        
			
                        pstm.setString(1, maDV);
                        pstm.setString(2, maHD);
			pstm.setString(3, maPhong);
			
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
     
     
    
    
    
}
