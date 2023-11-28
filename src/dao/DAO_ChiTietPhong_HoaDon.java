/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChiTietPhongHoaDon;

import entity.LoaiPhong;

import entity.HoaDon;
import entity.Phong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author quang
 */
public class DAO_ChiTietPhong_HoaDon implements I_CRUD<ChiTietPhongHoaDon>{

    public boolean themCTHD_PMoi(ChiTietPhongHoaDon cTHD_P) {
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
    
    public void updateBill(String ghiChu, String maHD, String maPhong, String maUuDai, ArrayList<int[]> fileSetting){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try{
            
                        
            statement = con.prepareStatement("update ChiTietPhongHoaDon set thoiGianTraPhong = ?, ghiChu = ? where maHoaDon = ? and maPhong = ?");
            statement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(2, ghiChu);
            statement.setString(3, maHD);
            statement.setString(4, maPhong);
            statement.executeUpdate();
            
            statement = con.prepareStatement("update Phong set trangThai = 0 where maPhong = ?");
            statement.setString(1, maPhong);
            statement.executeUpdate();
 
            statement = con.prepareStatement("select * from ChiTietPhongHoaDon ctphd inner join HoaDon hd on ctphd.maHoaDon = hd.maHoaDon where ctphd.ghiChu like N'%Đang sử dụng'\n" +
                                             "and hd.maHoaDon = ?");
            statement.setString(1, maHD);
            ResultSet rs = statement.executeQuery();
            
            boolean flag = false;
            
            while (rs.next()){
                flag = true;
            }
            
            if (maUuDai.trim().equals("")){
                maUuDai = null;
            }
            
            statement = con.prepareStatement("Select * From HoaDon where maHoaDon = ?");
            statement.setString(1, maHD);
            rs = statement.executeQuery();
            
            String ghiChuHoaDon = "";
            while (rs.next()){
                ghiChuHoaDon = rs.getString("ghiChu");
            }

             ghiChuHoaDon += ", "+ maPhong + " " + fileSetting.get(0)[0];
            
            if (flag == false){
                statement = con.prepareStatement("update HoaDon set trangThai = 1, maUuDai = ?, ghiChu = ? where maHoaDon = ?");
                statement.setString(1, maUuDai);
                statement.setString(2, ghiChuHoaDon);
                statement.setString(3, maHD);
                
                statement.executeUpdate();
            }
            else{
                statement = con.prepareStatement("update HoaDon set trangThai = 0, maUuDai = ?, ghiChu = ? where maHoaDon = ?");
                statement.setString(1, maUuDai);
                statement.setString(2, ghiChuHoaDon);
                statement.setString(3, maHD);
                statement.executeUpdate();
            }

            
            

            
            


        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public entity.ChiTietPhongHoaDon layChiTietPhongHoaDonDuaTrenMaPhong(String maPhong){
        entity.ChiTietPhongHoaDon ctphd = null;

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
                
                ctphd = new ChiTietPhongHoaDon(thoiGianNhanPhong, null, rs.getString(3), I_CRUD.findById(rs.getString(4), new entity.HoaDon()), I_CRUD.findById(rs.getString(5),new entity.Phong()));
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
        

    public ChiTietPhongHoaDon getCTPtheoMP(String maphong) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select * from chitietphonghoadon where maphong = ? and thoigiantraphong is null");
            pstm.setString(1, maphong);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = I_CRUD.findById(rs.getString("maHoaDon"), new HoaDon());
                Phong p = I_CRUD.findById(rs.getString("maPhong"), new Phong());
                LocalDateTime in = I_CRUD.SQLtoJava(rs.getString(1));
                LocalDateTime out = I_CRUD.SQLtoJava(rs.getString(2));
                String ghichu = rs.getString(3);
                ChiTietPhongHoaDon ctp = new ChiTietPhongHoaDon(in, out, ghichu, hd, p);
               return ctp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
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
    
     public ArrayList<ChiTietPhongHoaDon> getThongCTPhongbyKhachHang(String sdt){
        ArrayList<ChiTietPhongHoaDon> ls = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql ="select  thoiGianNhanPhong, thoiGianTraPhong, ct.ghiChu, h.maHoaDon, maPhong from HoaDon h \n" +
                        "inner join ChiTietPhongHoaDon ct on h.maHoaDon = ct.maHoaDon\n" +
                        "where trangThai = 0 and ct.ghiChu != N'Đã hoàn thành' and maKhachHang= ? order by thoiGianNhanPhong";
            
            statement = con.prepareStatement(sql);
            statement.setString(1, sdt);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               
                ls.add(new ChiTietPhongHoaDon(I_CRUD.SQLtoJava(rs.getString("thoiGianNhanPhong")), I_CRUD.SQLtoJava(rs.getString("thoiGianTraPhong")), 
                        rs.getString("ghiChu"), I_CRUD.findById(rs.getString("maHoaDon"), new HoaDon()) , I_CRUD.findById(rs.getString("maPhong"), new Phong())));
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
        return ls;
    }
      public ArrayList<String> getMaKHtheoPhongDangSuDung() {
        ArrayList<String> dsid = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            Statement stm = con.createStatement();
            String sql = "select distinct maKhachHang " +
                        " from HoaDon h inner join chiTietphonghoadon c on h.maHoaDon = c.maHoaDon" +
                        " where thoiGianTraPhong is null";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                dsid.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsid;
    }
    public ArrayList<String> getMaPhongTheoKH(String makh) { // phòng đang sử dụng
        ArrayList<String> dsid = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("select maphong from chitietphonghoadon c inner join hoadon h on c.mahoadon = h.mahoadon where thoigiantraphong is null and makhachhang = ?");
            pstm.setString(1, makh);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                dsid.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_ChiTietPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsid;
    }
}
    