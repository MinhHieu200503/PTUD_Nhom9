/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author quang
 */
public class ChiTietDichVuHoaDon {
    private int soLuong;
    private DichVu dichVu;
    private HoaDon hoaDon;
    private Phong phong;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
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

    public ChiTietDichVuHoaDon(int soLuong, DichVu dichVu, HoaDon hoaDon, Phong phong) {
        this.soLuong = soLuong;
        this.dichVu = dichVu;
        this.hoaDon = hoaDon;
        this.phong = phong;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.dichVu);
        hash = 13 * hash + Objects.hashCode(this.hoaDon);
        hash = 13 * hash + Objects.hashCode(this.phong);
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
        final ChiTietDichVuHoaDon other = (ChiTietDichVuHoaDon) obj;
        if (!Objects.equals(this.dichVu, other.dichVu)) {
            return false;
        }
        if (!Objects.equals(this.hoaDon, other.hoaDon)) {
            return false;
        }
        return Objects.equals(this.phong, other.phong);
    }

    @Override
    public String toString() {
        return "ChiTietDichVuHoaDon{" + "soLuong=" + soLuong + ", dichVu=" + dichVu + ", hoaDon=" + hoaDon + ", phong=" + phong + '}';
    }
    
}
