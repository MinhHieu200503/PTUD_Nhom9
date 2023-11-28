
import dao.DAO_ChiTietPhong_HoaDon;
import dao.DAO_HoaDon;
import dao.I_CRUD;
import entity.ChitTietPhongHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
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
        HoaDon a = new HoaDon(I_TraCuu_QuanLi.createIdForHoaDon_PDP(daohd.getDsIdTheoNgayHienTai(), "HD"), LocalDateTime.now(), 1, null, 
                I_CRUD.findById("0398242144", new KhachHang()), 
                null, 
                I_CRUD.findById("NV001", new NhanVien()));
        daohd.create(a);
        DAO_ChiTietPhong_HoaDon daoctp = new DAO_ChiTietPhong_HoaDon();
        ChitTietPhongHoaDon b = new ChitTietPhongHoaDon(LocalDateTime.now(), null, "MP000 Đang sử dụng", a, I_CRUD.findById("MP001", new Phong()));
        daoctp.themCTHD_PMoi(b);
    }
}
