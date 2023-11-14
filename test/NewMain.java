

import dao.DAO_HoaDon;
import entity.ThongTinPhongDangChon;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templat es/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dao.DAO_HoaDon tmp = new DAO_HoaDon();
        ThongTinPhongDangChon temp =  tmp.getThongTinTraPhong("MP004");
        
        ArrayList<ThongTinPhongDangChon.PhongVaDichVu> temp2 = temp.danhSachPhong;
       
        System.out.println(temp.toString());
        System.out.println("");
        
        for (ThongTinPhongDangChon.PhongVaDichVu phongVaDichVu : temp2) {
            System.out.println("");
            System.out.println("Phong" + phongVaDichVu.getChiTietPhongHoaDon());
            
            ArrayList<ThongTinPhongDangChon.PhongVaDichVu.DichVu> temp3 = phongVaDichVu.dichVu;
            for (ThongTinPhongDangChon.PhongVaDichVu.DichVu dichVu : temp3) {
                System.out.println("    DichVu" + dichVu.toString());
            }
        }
        
        
        
        
    }
    
}
