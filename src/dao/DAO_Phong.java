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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */
public class DAO_Phong implements I_CRUD<Phong>{
    
    public boolean capNhatTrangThaiPhong(String maPhong, int TrangThai) {
        JOptionPane.showMessageDialog(null,TrangThai);
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
    
    
    public  ArrayList<entity.Phong> getPhongTheoDieuKien(String loaiPhong,int sucChua,int trangThai,String date){
        ArrayList<entity.Phong> dsphong = new ArrayList<entity.Phong>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        String sqlLoaiPhong = " ";
        String sqlSucChua = " ";
        String inOrNotin = "not in";
        // khoi tao new date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date newDate = new Date();
        String formattedDate = sdf.format(newDate);
        String day = formattedDate.substring(0, 2);
        String month = formattedDate.substring(3, 5);
        String year = formattedDate.substring(6, 10);
        String selectedDate = day+"/"+month+"/"+year;
        // if else
        boolean dateNow = true;
        if(loaiPhong != null){
            sqlLoaiPhong = "  and loaiPhong = ?  ";
        }
        if(sucChua !=0){
            sqlSucChua = "  and sucChuaToiDa = ? ";
        }
        if(trangThai == 1){
            inOrNotin = "in";
        }
        
        
        if(!selectedDate.trim().equalsIgnoreCase(date.trim())){
            selectedDate = date;
            dateNow = false;
                if(loaiPhong != null){
                sqlLoaiPhong = "  loaiPhong = ? and ";
                }
                if(sucChua !=0){
                 sqlSucChua = "   sucChuaToiDa = ? and  ";
                }
        }
        
//        
        try {
            
                if(dateNow == true){
                        String sql = "select * from Phong JOIN LoaiPhong\n" +
                            "on Phong.maLoaiPhong = LoaiPhong.maLoaiPhong\n" +
                            "where trangThai = ? " + sqlLoaiPhong + sqlSucChua;
            
                        statement = con.prepareStatement(sql);
                        statement.setInt(1, trangThai);
                        if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")){
                            statement.setInt(2, sucChua);
                        }
                        else if(sqlSucChua.trim().equals("")&&!sqlLoaiPhong.trim().equals("")){
                            statement.setString(2, loaiPhong);

                        }
                        else if(sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")){
                            
                        }
                        else{
                            statement.setString(2, loaiPhong);
                            statement.setInt(3, sucChua);
                        }
            }
                
                else{
                     String sql = "select * from Phong JOIN LoaiPhong\n" +
"                    on Phong.maLoaiPhong = LoaiPhong.maLoaiPhong \n" +
"                    where " + sqlLoaiPhong + sqlSucChua +" phong.maPhong " + inOrNotin+ " (select maPhong from Phong \n" +
"                    where Phong.maPhong in (select maPhong from PhieuDatPhong where CONVERT(VARCHAR, thoiGianNhanPhong, 103) = ?))";

                    statement = con.prepareStatement(sql);
                    
                    if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")){

                        statement.setInt(1, sucChua);
                        statement.setString(2, selectedDate);
                    }
                    else if(sqlSucChua.trim().equals("")&&!sqlLoaiPhong.trim().equals("")){

                        statement.setString(1, loaiPhong);
                        statement.setString(2, selectedDate);

                    }
                    else if(sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")){
                        statement.setString(1, selectedDate);
                    }
                    else{
                        statement.setString(1, loaiPhong);
                        statement.setInt(2, sucChua);
                        statement.setString(3, selectedDate);
                    }
                }
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
		 if(dateNow == false){
                    dsphong.add(new entity.Phong(rs.getString(1).trim(), rs.getString(2), trangThai, I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) ));

                 }
                 else{
                   dsphong.add(new entity.Phong(rs.getString(1).trim(), rs.getString(2), rs.getInt(3), I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) ));

                 }
                 
                    

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
        return dsphong;
    }
    
    public  ArrayList<entity.Phong> getPhongTheoDieuKien(String loaiPhong,int sucChua,int trangThai){
        ArrayList<entity.Phong> dsphong = new ArrayList<entity.Phong>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        String sqlLoaiPhong = " ";
        String sqlSucChua = " ";
        String sqlTrangThai = "  ";
        if(loaiPhong != null){
            sqlLoaiPhong = "   loaiPhong = ?  ";
        }
        if(sucChua !=0){
            sqlSucChua = " and  sucChuaToiDa = ?  ";
        }
//        
       
        
                    if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai!=-1){
                       sqlTrangThai = "  trangThai = ?  ";
                       sqlSucChua = "  and sucChuaToiDa = ?  ";
                        
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai!=-1){
                       sqlTrangThai = "  trangThai = ?  ";
                       sqlLoaiPhong = "  and loaiPhong = ?  ";
                        
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai==-1){
                        sqlLoaiPhong = "  loaiPhong = ?  ";
                        sqlSucChua = "  and sucChuaToiDa = ?  ";
                        
                    }
                    else if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai==-1){                      
                        sqlSucChua = "   sucChuaToiDa = ?  ";
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai==-1){                      
                         sqlLoaiPhong = "  loaiPhong = ?  ";
                    }
                    else if(sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai!=-1){                      
                        sqlTrangThai = "  trangThai = ?  ";
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai!=-1){
                       sqlTrangThai = "  trangThai = ?  ";
                       sqlLoaiPhong = "  and loaiPhong = ?  ";
                        sqlSucChua = "  and sucChuaToiDa = ?  ";
                    }
        try {
            
                
                if(loaiPhong == null &&sucChua ==0 && trangThai ==-1){
                     String sql = "select * from Phong";
                     statement = con.prepareStatement(sql);
                }
                else{
                    String sql = "select * from Phong JOIN LoaiPhong\n" +
                            "on Phong.maLoaiPhong = LoaiPhong.maLoaiPhong \n" +
                            "where " +sqlTrangThai +sqlLoaiPhong + sqlSucChua   ;
                            statement = con.prepareStatement(sql);
                    if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai!=-1){
                        statement.setInt(1, trangThai);
                        statement.setInt(2, sucChua);
                        
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai!=-1){
                        statement.setInt(1, trangThai);
                        statement.setString(2, loaiPhong);
                        
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai==-1){
                        statement.setString(1, loaiPhong);
                        statement.setInt(2, sucChua);
                        
                    }
                    else if(sqlLoaiPhong.trim().equals("")&&!sqlSucChua.trim().equals("")&&trangThai==-1){                      
                        statement.setInt(1, sucChua);
                    }
                    else if(!sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai==-1){                      
                        statement.setString(1, loaiPhong);
                    }
                    else if(sqlLoaiPhong.trim().equals("")&&sqlSucChua.trim().equals("")&&trangThai!=-1){                      
                        statement.setInt(1, trangThai);
                    }
                    else{
                        statement.setInt(1, trangThai);
                        statement.setString(2, loaiPhong);
                        statement.setInt(3, sucChua);
                    }
                    
                    
                    
                }
                
                ResultSet rs = statement.executeQuery();
                
                
                 while (rs.next()) {	
                dsphong.add(new entity.Phong(rs.getString(1).trim(), rs.getString(2), rs.getInt(3), I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) ));
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
        return dsphong;
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
                dsphong.add(new entity.Phong(rs.getString(1).trim(), rs.getString(2), rs.getInt(3), I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) ));
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
        return dsphong;
    }
    @SuppressWarnings("empty-statement")
    public String[] getThongTinDatPhong (String maPhong){
        String[] thongTin = {"","","","", ""};
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "select top 1 p.maPhong, thoiGianNhanPhong, kh.soDienThoai, tenKhachHang, hd.maHoaDon from ChiTietPhongHoaDon ct_p_hd \n" +
                        "inner join Phong p on ct_p_hd.maPhong = p.maPhong  \n" +
                        "inner join HoaDon hd on ct_p_hd.maHoaDon = hd.maHoaDon\n" +
                        "inner join KhachHang kh on hd.maKhachHang = kh.soDienThoai\n" +
                        "where p.maPhong = ?\n" +
                        "order by thoiGianNhanPhong desc";
            
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            ResultSet rs = statement.executeQuery();
            rs.next();
            thongTin[0] = rs.getString("maPhong");
            thongTin[1] = rs.getString("thoiGianNhanPhong");
            thongTin[2] = rs.getString("soDienThoai");
            thongTin[3] = rs.getString("tenKhachHang");
            thongTin[4] = rs.getString("maHoaDon");
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
        return thongTin;}
        
    public entity.Phong getPhongTheoOnlyMaPhong(String maPhong) {
        
        entity.Phong phong = new entity.Phong();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "Select * from Phong where maPhong=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maPhong);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
//			
                phong = new entity.Phong(rs.getString(1).trim(), rs.getString(2), rs.getInt(3), I_CRUD.findById(rs.getString(4), new LoaiPhong()), rs.getInt(5), rs.getDouble(6) );
                    
            }
             System.out.println(phong);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return phong;
    }
    
}


