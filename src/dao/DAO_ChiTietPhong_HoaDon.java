/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChitTietPhongHoaDon;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DAO_ChiTietPhong_HoaDon implements I_CRUD<ChitTietPhongHoaDon>{

    @Override
    public ArrayList<ChitTietPhongHoaDon> search(String key, Class<ChitTietPhongHoaDon> c) {
        return I_CRUD.super.search(key, c); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean update(ChitTietPhongHoaDon entity) {
        return I_CRUD.super.update(entity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ArrayList<ChitTietPhongHoaDon> getAll(Class<ChitTietPhongHoaDon> clazz) {
        return I_CRUD.super.getAll(clazz); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean create(ChitTietPhongHoaDon entity) {
        return I_CRUD.super.create(entity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public ChitTietPhongHoaDon findByID(String id) {
        return null;
    }
}
