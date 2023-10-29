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
public class HoaDon {
    private String maHoaDon;
    private LocalDateTime ngayLapHoaDon;
    private int trangThai;
    private KhachHang khachHang;
    private UuDai uuDai;
    private NhanVien nhanVien;

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDateTime getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public UuDai getUuDai() {
        return uuDai;
    }

    public void setUuDai(UuDai uuDai) {
        this.uuDai = uuDai;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, int trangThai, KhachHang khachHang, UuDai uuDai, NhanVien nhanVien) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
        this.uuDai = uuDai;
        this.nhanVien = nhanVien;
    }

    public HoaDon() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.maHoaDon);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", trangThai=" + trangThai + ", khachHang=" + khachHang + ", uuDai=" + uuDai + ", nhanVien=" + nhanVien + '}';
    }
    
}
