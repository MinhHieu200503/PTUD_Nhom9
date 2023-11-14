/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.KhachHang;
import entity.NhanVien;
import entity.UuDai;


/**
 *
 * @author quang
 */
public class DAO_HoaDon implements I_CRUD<HoaDon>{
    public ArrayList<String> getDsIdTheoNgayHienTai() {
        ArrayList<String> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "select mahoadon from hoadon where convert(date, ngayLapHoaDon) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ds.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
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
