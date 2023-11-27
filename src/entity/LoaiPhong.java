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
public class LoaiPhong {
    private String maLoaiPhong, tenLoaiPhong;
    private int sucChua;
    private double gia;
    private String moTa;

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int sucChua, double gia, String moTa) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.sucChua = sucChua;
        this.gia = gia;
        this.moTa = moTa;
    }

    public LoaiPhong() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maLoaiPhong);
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
        final LoaiPhong other = (LoaiPhong) obj;
        return Objects.equals(this.maLoaiPhong, other.maLoaiPhong);
    }

    @Override
    public String toString() {
        return "LoaiPhong{" + "maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + ", sucChua=" + sucChua + ", gia=" + gia + ", moTa=" + moTa + '}';
    }
}
