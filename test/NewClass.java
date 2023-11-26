
import dao.DAO_HoaDon;
import dao.I_CRUD;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import gui.I_TraCuu_QuanLi;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quang
 */
public class NewClass {
    public static void main(String[] args) {
        DAO_HoaDon daohd = new DAO_HoaDon();
//        HoaDon a = new HoaDon(I_TraCuu_QuanLi.createIdForHoaDon(daohd.getDsIdTheoNgayHienTai(), "HD"), LocalDateTime.now(), 1, null, 
//                I_CRUD.findById("0398242144", new KhachHang()), 
//                null, 
//                I_CRUD.findById("NV001", new NhanVien()));
//        daohd.update(a);
        
    }
}
