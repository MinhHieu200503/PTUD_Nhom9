/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietDichVuHoaDon;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DAO_ChiTietDichVu_HoaDon implements I_CRUD<ChiTietDichVuHoaDon>{

    @Override
    public ArrayList<ChiTietDichVuHoaDon> search(String key, Class<ChiTietDichVuHoaDon> c) {
        return I_CRUD.super.search(key, c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean update(ChiTietDichVuHoaDon entity) {
        return I_CRUD.super.update(entity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<ChiTietDichVuHoaDon> getAll(Class<ChiTietDichVuHoaDon> clazz) {
        return I_CRUD.super.getAll(clazz); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean create(ChiTietDichVuHoaDon entity) {
        return I_CRUD.super.create(entity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public ChiTietDichVuHoaDon findbyID(String id) {
        return null;
    }
    
}
