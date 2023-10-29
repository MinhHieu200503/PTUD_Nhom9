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
public class UuDai {
    private String maUuDai, tenUuDai;
    private double giamGia;
    private LocalDateTime ngayBatDauApDung, ngayKetThucApDung;

    public String getMaUuDai() {
        return maUuDai;
    }

    public void setMaUuDai(String maUuDai) {
        this.maUuDai = maUuDai;
    }

    public String getTenUuDai() {
        return tenUuDai;
    }

    public void setTenUuDai(String tenUuDai) {
        this.tenUuDai = tenUuDai;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public LocalDateTime getNgayBatDauApDung() {
        return ngayBatDauApDung;
    }

    public void setNgayBatDauApDung(LocalDateTime ngayBatDauApDung) {
        this.ngayBatDauApDung = ngayBatDauApDung;
    }

    public LocalDateTime getNgayKetThucApDung() {
        return ngayKetThucApDung;
    }

    public void setNgayKetThucApDung(LocalDateTime ngayKetThucApDung) {
        this.ngayKetThucApDung = ngayKetThucApDung;
    }

    public UuDai(String maUuDai, String tenUuDai, double giamGia, LocalDateTime ngayBatDauApDung, LocalDateTime ngayKetThucApDung) {
        this.maUuDai = maUuDai;
        this.tenUuDai = tenUuDai;
        this.giamGia = giamGia;
        this.ngayBatDauApDung = ngayBatDauApDung;
        this.ngayKetThucApDung = ngayKetThucApDung;
    }

    public UuDai() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maUuDai);
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
        final UuDai other = (UuDai) obj;
        return Objects.equals(this.maUuDai, other.maUuDai);
    }

    @Override
    public String toString() {
        return "UuDai{" + "maUuDai=" + maUuDai + ", tenUuDai=" + tenUuDai + ", giamGia=" + giamGia + ", ngayBatDauApDung=" + ngayBatDauApDung + ", ngayKetThucApDung=" + ngayKetThucApDung + '}';
    }
    
}
