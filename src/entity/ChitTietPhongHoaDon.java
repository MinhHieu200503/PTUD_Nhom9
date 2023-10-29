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
public class ChitTietPhongHoaDon {
    private LocalDateTime thoiGianNhanPhong, thoiGianTraPhong;
    private String ghiChu;
    private HoaDon hoaDon;
    private Phong phong;

    public LocalDateTime getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(LocalDateTime thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public LocalDateTime getThoiGianTraPhong() {
        return thoiGianTraPhong;
    }

    public void setThoiGianTraPhong(LocalDateTime thoiGianTraPhong) {
        this.thoiGianTraPhong = thoiGianTraPhong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public ChitTietPhongHoaDon(LocalDateTime thoiGianNhanPhong, LocalDateTime thoiGianTraPhong, String ghiChu, HoaDon hoaDon, Phong phong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.thoiGianTraPhong = thoiGianTraPhong;
        this.ghiChu = ghiChu;
        this.hoaDon = hoaDon;
        this.phong = phong;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.hoaDon);
        hash = 31 * hash + Objects.hashCode(this.phong);
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
        final ChitTietPhongHoaDon other = (ChitTietPhongHoaDon) obj;
        if (!Objects.equals(this.hoaDon, other.hoaDon)) {
            return false;
        }
        return Objects.equals(this.phong, other.phong);
    }

    @Override
    public String toString() {
        return "ChitTietPhongHoaDon{" + "thoiGianNhanPhong=" + thoiGianNhanPhong + ", thoiGianTraPhong=" + thoiGianTraPhong + ", ghiChu=" + ghiChu + ", hoaDon=" + hoaDon + ", phong=" + phong + '}';
    }
    
}
