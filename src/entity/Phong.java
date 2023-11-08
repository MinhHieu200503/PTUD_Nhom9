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
public class Phong {
    private String maPhong, tenPhong;
    private int trangThai;
    private LoaiPhong loaiPhong;
    private int sucChuaToiDa;
    private double giaPhongTheoGio;

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSucChuaToiDa() {
        return sucChuaToiDa;
    }

    public void setSucChuaToiDa(int sucChuaToiDa) {
        this.sucChuaToiDa = sucChuaToiDa;
    }

    public double getGiaPhongTheoGio() {
        return giaPhongTheoGio;
    }

    public void setGiaPhongTheoGio(double giaPhongTheoGio) {
        this.giaPhongTheoGio = giaPhongTheoGio;
    }

    public Phong(String maPhong, String tenPhong, int trangThai, LoaiPhong loaiPhong, int sucChuaToiDa, double giaPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.trangThai = trangThai;
        this.loaiPhong = loaiPhong;
        this.sucChuaToiDa = sucChuaToiDa;
        this.giaPhongTheoGio = giaPhong;
    }

    public Phong() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.maPhong);
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
        final Phong other = (Phong) obj;
        return Objects.equals(this.maPhong, other.maPhong);
    }

    @Override
    public String toString() {
        return "Phong{" + "maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", trangThai=" + trangThai + ", loaiPhong=" + loaiPhong + ", sucChuaToiDa=" + sucChuaToiDa + ", giaPhong=" + giaPhongTheoGio + '}';
    }
    
}
