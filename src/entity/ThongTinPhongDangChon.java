package entity;


import entity.ChiTietDichVuHoaDon;
import entity.ChiTietPhongHoaDon;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class ThongTinPhongDangChon {
            //result
            ////0: mã phòng
            ////1: tên khách hàng
            ////2: thời gian nhận (mã phòng '0')
            ////3: thời gian sử dụng
            //4: tổng tiền dịch vụ
            //5: tổng tiền phòng
            ////6: ghi chú
            //7: tổng tiền
    private String maPhong;
    private String tenKhachHang;
    private Double datCoc = 0.0;
    private String phieuDatPhong = null;
    private int thoiGianSuDungTichLuy;
    private String maUuDai;
    public ArrayList<PhongVaDichVu> danhSachPhong;
    
    public PhongVaDichVu createPhongVaDichVu(){
        return new PhongVaDichVu();
    }
 
    public ThongTinPhongDangChon() {
        this.danhSachPhong = new ArrayList<>();
    }
    
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getPhieuDatPhong() {
        return phieuDatPhong;
    }

    public void setPhieuDatPhong(String phieuDatPhong) {
        this.phieuDatPhong = phieuDatPhong;
    }

    public ArrayList<PhongVaDichVu> getDanhSachPhong() {
        return danhSachPhong;
    }

    public void setDanhSachPhong(ArrayList<PhongVaDichVu> danhSachPhong) {
        this.danhSachPhong = danhSachPhong;
    }

    public Double getDatCoc() {
        return datCoc;
    }

    public void setDatCoc(Double datCoc) {
        this.datCoc = datCoc;
    }

    public int getThoiGianSuDungTichLuy() {
        return thoiGianSuDungTichLuy;
    }

    public void setThoiGianSuDungTichLuy(int thoiGianSuDungTichLuy) {
        this.thoiGianSuDungTichLuy = thoiGianSuDungTichLuy;
    }

    public String getMaUuDai() {
        return maUuDai;
    }

    public void setMaUuDai(String maUuDai) {
        this.maUuDai = maUuDai;
    }
    
    
    
    
        public class PhongVaDichVu{
            private entity.ChiTietPhongHoaDon chiTietPhongHoaDon;
            public ArrayList<DichVu> dichVu;

            public DichVu createDichVu(){
                return new DichVu();
            }
            
                public class DichVu{
                    private entity.ChiTietDichVuHoaDon chiTietDichVu;

                    public DichVu() {
                        this.chiTietDichVu = null;
                    }

                    public ChiTietDichVuHoaDon getChiTietDichVu() {
                        return chiTietDichVu;
                    }

                    public void setChiTietDichVu(ChiTietDichVuHoaDon chiTietDichVu) {
                        this.chiTietDichVu = chiTietDichVu;
                    }

                    public double tongTien(){
                        return chiTietDichVu.getSoLuong() * chiTietDichVu.getDichVu().getGia();
                    }

                @Override
                public String toString() {
                    return "DichVu{" + "chiTietDichVu=" + chiTietDichVu +'}';
                }     
            }

            public PhongVaDichVu() {
                this.chiTietPhongHoaDon = null;
                this.dichVu = new ArrayList<>();
            }

            public ChiTietPhongHoaDon getChiTietPhongHoaDon() {
                return chiTietPhongHoaDon;
            }

            public void setChiTietPhongHoaDon(ChiTietPhongHoaDon chiTietPhongHoaDon) {
                this.chiTietPhongHoaDon = chiTietPhongHoaDon;
            }

            public ArrayList<DichVu> getDichVu() {
                return dichVu;
            }

            public void setDichVu(ArrayList<DichVu> dichVu) {
                this.dichVu = dichVu;
            }

            @Override
            public String toString() {
                return "PhongVaDichVu{" + "chiTietPhongHoaDon=" + chiTietPhongHoaDon + ", dichVu=" + dichVu + '}';
            }
            
        }

    @Override
    public String toString() {
        return "ThongTinPhongDangChon{" + "maPhong=" + maPhong + ", tenKhachHang=" + tenKhachHang + ", datCoc=" + datCoc + ", phieuDatPhong=" + phieuDatPhong + ", thoiGianSuDungTichLuy=" + thoiGianSuDungTichLuy + ", maUuDai=" + maUuDai + ", danhSachPhong=" + danhSachPhong + '}';
    }

        
        


    
    public Double tongTienPhong(){
       Double result = 0.0;
        for (PhongVaDichVu phongVaDichVu : danhSachPhong) {
            double gia = phongVaDichVu.getChiTietPhongHoaDon().getPhong().getLoaiPhong().getGia() / 60;
              Duration timeResult = Duration.between(phongVaDichVu.getChiTietPhongHoaDon().getThoiGianTraPhong(), phongVaDichVu.chiTietPhongHoaDon.getThoiGianNhanPhong());
              long minutes = Math.abs(timeResult.toMinutes());
              result = result + (gia*minutes);

        }
        return result;
    }
    
    public Double tongTienDichVu(){
        Double result = 0.0;
        for (PhongVaDichVu phongVaDichVu : danhSachPhong) {
            for (PhongVaDichVu.DichVu dichVu : phongVaDichVu.dichVu) {
                result = result + dichVu.tongTien();
            }
            
        }
        return result;
    }
    
    public long tongThoiGianSuDung(){
        long result = 0;
        for (PhongVaDichVu phongVaDichVu : danhSachPhong) {
              Duration timeResult = Duration.between(phongVaDichVu.chiTietPhongHoaDon.getThoiGianTraPhong(), phongVaDichVu.chiTietPhongHoaDon.getThoiGianNhanPhong());
              result = result + Math.abs(timeResult.toMinutes());
        }
        return result;
    }
    
    public String thoiGianNhanPhong(){
        String result;
        
        LocalDateTime temp = danhSachPhong.getLast().chiTietPhongHoaDon.getThoiGianNhanPhong();
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.valueOf(temp.format(CUSTOM_FORMATTER).substring(11,16));
    }
    
    public String ghiChu(){
        String result = "";
        
        for (PhongVaDichVu phongVaDichVu : danhSachPhong) {
            if (!phongVaDichVu.chiTietPhongHoaDon.getGhiChu().substring(0,5).contains("MP000"))
            result = result + phongVaDichVu.chiTietPhongHoaDon.getGhiChu().substring(0,5) + "<-";
            
        }
        if (result.length()>0){
            return result.substring(0, result.length()-2);
        }
        if (result.contains("000")){
            return "";
        }
        return result;
    }
    
}
