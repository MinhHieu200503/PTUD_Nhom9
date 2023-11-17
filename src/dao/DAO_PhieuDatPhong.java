/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.PhieuDatPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class DAO_PhieuDatPhong implements I_CRUD<PhieuDatPhong>{
    public PhieuDatPhong getPhieuDatPhongByID(String id){
        PhieuDatPhong result = null;
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try {
            statement = con.prepareStatement("SELECT * FROM PhieuDatPhong Where maPhieuDatPhong = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {		
                result = new PhieuDatPhong(id, rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4), rs.getDouble(5), null, null, null, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<entity.PhieuDatPhong> getAllPDPTheoTrangThai(int trangThai){
        ArrayList<entity.PhieuDatPhong> dsPDP = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

              statement = con.prepareStatement("select * from PhieuDatPhong\n" +
                                                "where trangThai = ? order by thoiGianNhanPhong asc");
              
              statement.setInt(1, trangThai);
              ResultSet rs = statement.executeQuery();
              while(rs.next()){
                 dsPDP.add(new PhieuDatPhong(rs.getString(1), rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4), rs.getDouble(5), I_CRUD.findById(rs.getString(6),new NhanVien()), I_CRUD.findById(rs.getString(7),new KhachHang()),I_CRUD.findById(rs.getString(8),new Phong()), I_CRUD.findById(rs.getString(9), new HoaDon())));
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
        return dsPDP;
    }
    
    public boolean updateTrangThaiPhieuDatPhongBangMaHoaDon(String maHoaDon, int TrangThai) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
          try {

              statement = con.prepareStatement("update PhieuDatPhong\n" +
                                                  "set trangThai = ? \n" +
                                                  "where maHoaDon = ?");

              statement.setInt(1, TrangThai);

              statement.setString(2, maHoaDon);

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
        
   public PhieuDatPhong getPhieuDatPhongByMaPhong(String maPhong,String ngayNhan){
       entity.PhieuDatPhong phieuDatPhong = new entity.PhieuDatPhong();
    
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "select * from PhieuDatPhong\n" +
                          "where maPhong = ? and   CONVERT(VARCHAR, thoiGianNhanPhong, 103) = ? and trangThai = 0";
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            statement.setString(2,ngayNhan);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {	
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                LocalDateTime thoiGianTaoPhieu = LocalDateTime.parse(rs.getString(2),formatter);
                LocalDateTime thoiGianNhanPhong = LocalDateTime.parse(rs.getString(3),formatter);
                phieuDatPhong = new entity.PhieuDatPhong(rs.getString(1).trim(),thoiGianTaoPhieu,thoiGianNhanPhong,rs.getInt(4),rs.getDouble(5),I_CRUD.findById(rs.getString(6), new NhanVien()),
                        I_CRUD.findById(rs.getString(7), new KhachHang()),I_CRUD.findById(rs.getString(8),new Phong()),I_CRUD.findById(rs.getString(9),new HoaDon()));
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
        return phieuDatPhong;
    }
    
    public void updateBill(String id){
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
     
        try {
 
            statement = con.prepareStatement("update PhieuDatPhong set trangThai = 1 where maPhieuDatPhong = ?");
            statement.setString(1, id);
            statement.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(DAO_PhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


