/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.UuDai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 *
 * @author quang
 */
public class DAO_HoaDon implements I_CRUD<HoaDon>{
    public void taoHoaDon(entity.HoaDon hoaDon){
//        private String maHoaDon;
    //    private LocalDateTime ngayLapHoaDon;
    //    private int trangThai;
    //    private KhachHang khachHang;
    //    private UuDai uuDai;
    //    private NhanVien nhanVien;
            
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            
            PreparedStatement statementInsert = null;
            
            String insetHoaDon = "insert into HoaDon(maHoaDon,ngayLapHoaDon,trangThai,maKhachHang,maUuDai,maNhanVien)";
          try {
            
            // tao hoa don
            statementInsert = con.prepareStatement(insetHoaDon);
            statementInsert.setString(1, hoaDon.getMaHoaDon());
            statementInsert.setTimestamp(2, java.sql.Timestamp.valueOf(hoaDon.getNgayLapHoaDon()));
            statementInsert.setInt(3, hoaDon.getTrangThai());
            statementInsert.setString(4, hoaDon.getKhachHang().getSoDienThoai());
            statementInsert.setString(5, hoaDon.getUuDai().getMaUuDai());
            statementInsert.setString(6,hoaDon.getNhanVien().getMaNhanVien())  ;
            statementInsert.executeQuery();
             
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statementInsert.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
    
    
    
    public int laySoLuongHoaDon(){
            int soLuongHoaDon = 0;
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            PreparedStatement statementSelect = null;
            String countHoaDon = "select count(*) from HoaDon";
          try {
            // lay so luong hoa đon
            statementSelect = con.prepareStatement(countHoaDon);
            ResultSet rs = statementSelect.executeQuery();
              while (rs.next()) {
                  soLuongHoaDon = rs.getInt(1);
             }    
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statementSelect.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return soLuongHoaDon;
    }
    
    
}
