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
public class Ca {
    private String maCa, tenCa, moTa;

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Ca(String maCa, String tenCa, String moTa) {
        this.maCa = maCa;
        this.tenCa = tenCa;
        this.moTa = moTa;
    }

    public Ca() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.maCa);
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
        final Ca other = (Ca) obj;
        return Objects.equals(this.maCa, other.maCa);
    }

    @Override
    public String toString() {
        return "Ca{" + "maCa=" + maCa + ", tenCa=" + tenCa + ", moTa=" + moTa + '}';
    }
    
}
