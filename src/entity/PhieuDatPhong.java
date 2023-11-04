/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author quang
 */
public class PhieuDatPhong {
    private String maPhieuDatPhong;
    private LocalDateTime thoiGianTaoPhieu, thoiGianNhanPhong;
    private int trangThai;
    private double datCoc;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private Phong phong;
    private HoaDon hoaDon;

    public String getMaPhieuDatPhong() {
        return maPhieuDatPhong;
    }

    public void setMaPhieuDatPhong(String maPhieuDatPhong) {
        this.maPhieuDatPhong = maPhieuDatPhong;
    }

    public LocalDateTime getThoiGianTaoPhieu() {
        return thoiGianTaoPhieu;
    }

    public void setThoiGianTaoPhieu(LocalDateTime thoiGianTaoPhieu) {
        this.thoiGianTaoPhieu = thoiGianTaoPhieu;
    }

    public LocalDateTime getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(LocalDateTime thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(double datCoc) {
        this.datCoc = datCoc;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public PhieuDatPhong(String maPhieuDatPhong, LocalDateTime thoiGianTaoPhieu, LocalDateTime thoiGianNhanPhong, int trangThai, double datCoc, NhanVien nhanVien, KhachHang khachHang, Phong phong, HoaDon hoaDon) {
        this.maPhieuDatPhong = maPhieuDatPhong;
        this.thoiGianTaoPhieu = thoiGianTaoPhieu;
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.trangThai = trangThai;
        this.datCoc = datCoc;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.phong = phong;
        this.hoaDon = hoaDon;
    }

    

    public PhieuDatPhong() {
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maPhieuDatPhong);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhieuDatPhong other = (PhieuDatPhong) obj;
        return Objects.equals(this.maPhieuDatPhong, other.maPhieuDatPhong);
    }

    @Override
    public String toString() {
        return "PhieuDatPhong{" + "maPhieuDatPhong=" + maPhieuDatPhong + ", thoiGianTaoPhieu=" + thoiGianTaoPhieu + ", thoiGianNhanPhong=" + thoiGianNhanPhong + ", trangThai=" + trangThai + ", datCoc=" + datCoc + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", phong=" + phong + '}';
    }
    
}
