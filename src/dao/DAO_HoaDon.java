/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChiTietDichVuHoaDon;
import entity.ChitTietPhongHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.ThongTinPhongDangChon;
import entity.UuDai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author quang
 */
public class DAO_HoaDon implements I_CRUD<HoaDon>{
    public void taoHoaDon(entity.HoaDon hoaDon){
//        private String maHoaDon;
    //    private LocalDateTime ngayLapHoaDon;
    //    private int trangThai;
    //    private KhachHang khachHang;
    //    private UuDai uuDai;
    //    private NhanVien nhanVien;
            
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            
            PreparedStatement statementInsert = null;
            
            String insetHoaDon = "insert into HoaDon(maHoaDon,ngayLapHoaDon,trangThai,maKhachHang,maUuDai,maNhanVien)";
          try {
            
            // tao hoa don
            statementInsert = con.prepareStatement(insetHoaDon);
            statementInsert.setString(1, hoaDon.getMaHoaDon());
            statementInsert.setTimestamp(2, java.sql.Timestamp.valueOf(hoaDon.getNgayLapHoaDon()));
            statementInsert.setInt(3, hoaDon.getTrangThai());
            statementInsert.setString(4, hoaDon.getKhachHang().getSoDienThoai());
            statementInsert.setString(5, hoaDon.getUuDai().getMaUuDai());
            statementInsert.setString(6,hoaDon.getNhanVien().getMaNhanVien())  ;
            statementInsert.executeQuery();
             
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statementInsert.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
    
    public int laySoLuongHoaDon(){
            int soLuongHoaDon = 0;
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            PreparedStatement statementSelect = null;
            String countHoaDon = "select count(*) from HoaDon";
          try {
            // lay so luong hoa đon
            statementSelect = con.prepareStatement(countHoaDon);
            ResultSet rs = statementSelect.executeQuery();
              while (rs.next()) {
                  soLuongHoaDon = rs.getInt(1);
             }    
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statementSelect.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return soLuongHoaDon;
    }
    
    public String getHoaDonByPhongDangSuDung(String input_MaPhong){
        String result = null;
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            //FINAL
//            statement = con.prepareStatement("Select * from ChiTietPhongHoaDon ct inner join Phong p on ct.maPhong= p.maPhong where p.trangThai = 3 and ct.ghiChu like N'Đang sử dụng'  and ct.maPhong = ?");
            //TEST
            statement = con.prepareStatement("Select * from ChiTietPhongHoaDon ct inner join Phong p on ct.maPhong= p.maPhong where p.trangThai = 2  and ct.maPhong = ?");

            statement.setString(1, input_MaPhong);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {		
                result = rs.getString(4);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return result;
    }

    public ThongTinPhongDangChon getThongTinTraPhong(String maPhong){
        ThongTinPhongDangChon result = new ThongTinPhongDangChon();
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            //result
            ////0: mã phòng
            ////1: tên khách hàng
            ////2: thời gian nhận (mã phòng '0')
            ////3: thời gian sử dụng
            //4: tổng tiền dịch vụ
            //5: tổng tiền phòng
            ////6: ghi chú
            //7: tổng tiền
            //Lấy Mã Hóa Đơn
            String maHD = getHoaDonByPhongDangSuDung(maPhong);
//           System.out.println("MaHoaDon: " + maHD);
            
//0 mã phòng
            result.setMaPhong(maPhong);
//            System.out.println("MaPhongDangChon: " + result.getMaPhong());
            
            // Tên Khách hàng
            statement = con.prepareStatement("Select * from HoaDon hd inner join KhachHang kh on hd.maKhachHang = kh.soDienThoai where maHoaDon = ?");
            statement.setString(1, maHD);
            rs = statement.executeQuery();
            
            
            
            
            while (rs.next()) {
//1 tên khách hàng
                result.setTenKhachHang(rs.getString(8));
//                System.out.println("TenKhachHang: " + result.getTenKhachHang());
            }

//2 3 6  Thời gian nhận, thời gian sử dụng tạm tính, ghi chú
            statement = con.prepareStatement("select * from HoaDon hd inner join ChiTietPhongHoaDon ctp on hd.maHoaDon = ctp.maHoaDon inner join Phong p on ctp.maPhong = p.maPhong where hd.maHoaDon = ? and ctp.maPhong = ?");
            statement.setString(1, maHD);
            statement.setString(2, maPhong);
            rs = statement.executeQuery();
            
            entity.ChitTietPhongHoaDon phongDangChon = null;
            entity.HoaDon tempHoaDon = null;
            entity.Phong tempPhong = null;
            
            while (rs.next()) {
                
                tempHoaDon = new HoaDon(maHD, rs.getTimestamp(2).toLocalDateTime(), rs.getInt(3), null, null, null);
                tempPhong = new Phong(maPhong, rs.getString(13), 2, null, rs.getInt(16), rs.getDouble(17));
                
                
                phongDangChon = new ChitTietPhongHoaDon(rs.getTimestamp(7).toLocalDateTime(), LocalDateTime.now(), rs.getString(9) , tempHoaDon, tempPhong);
            }
//            System.out.println("PhongDangChon: " + phongDangChon.toString());
            // có được chi tiết phòng đang chọn (Mã hóa đơn, mã phòng ) -> đi lấy các phòng chuyển của phòng đang được chọn cho vào ghi chú
                
                
            statement = con.prepareStatement("select * from HoaDon hd inner join PhieuDatPhong pdp on hd.maHoaDon = pdp.maHoaDon \n" +
"\n" +
"where hd.maHoaDon = ?");
            statement.setString(1, maHD);
            rs = statement.executeQuery();
            while (rs.next()) {                
                result.setDatCoc(rs.getDouble(11));
                result.setPhieuDatPhong(rs.getString("maPhieuDatPhong"));
            }     
                Duration timeResult = Duration.between(LocalDateTime.now(), phongDangChon.getThoiGianNhanPhong());
                 long minutes = Math.abs(timeResult.toMinutes());
                result.danhSachPhong.add(result.createPhongVaDichVu());
                result.danhSachPhong.get(0).setChiTietPhongHoaDon(phongDangChon);                
                
                
                statement = con.prepareStatement("SELECT * FROM ChiTietDichVuHoaDon  ct\n" +
                                                             "inner join DichVu dv on ct.maDichVu = dv.maDichVu\n" +
                                                             "WHERE maHoaDon = ? and maPhong = ?");
                            statement.setString(1, maHD);
                            statement.setString(2, maPhong);
                            ResultSet rs2 = statement.executeQuery();
                            int j = 0;
                           
                            while(rs2.next()){
                                result.danhSachPhong.get(0).dichVu.add(result.createPhongVaDichVu().createDichVu());
                                result.danhSachPhong.get(0).dichVu.get(j).setChiTietDichVu(new ChiTietDichVuHoaDon(rs2.getInt(1), new DichVu(rs2.getString(5), rs2.getString(6), rs2.getDouble(7), 0, 0, null), null, null));
                                j++;
                            }            
                String pre = phongDangChon.getGhiChu().substring(0, 5);
                String tempResult = "";  
                int i = 0;
                
                do{
                    statement = con.prepareStatement("select * from HoaDon hd inner join ChiTietPhongHoaDon ctp on hd.maHoaDon = ctp.maHoaDon inner join Phong p on ctp.maPhong = p.maPhong where hd.maHoaDon = ? and ctp.maPhong = ?");
                    statement.setString(1, maHD);
                    statement.setString(2, pre);

                    rs = statement.executeQuery();
                    while(rs.next()){
                        i++;
                        result.danhSachPhong.add(result.createPhongVaDichVu());
                        tempPhong = new Phong(rs.getString(11), rs.getString(13), 2, null, rs.getInt(16), rs.getDouble(17));
                        result.danhSachPhong.get(i).setChiTietPhongHoaDon(new ChitTietPhongHoaDon(rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(), rs.getString(9) , tempHoaDon, tempPhong));
                        
                            //DỊch vụ
                            
                            statement = con.prepareStatement("SELECT * FROM ChiTietDichVuHoaDon  ct\n" +
                                                             "inner join DichVu dv on ct.maDichVu = dv.maDichVu\n" +
                                                             "WHERE maHoaDon = ? and maPhong = ?");
                            statement.setString(1, maHD);
                            statement.setString(2, rs.getString(11));
                             rs2 = statement.executeQuery();
                            int k = 0;
                            while(rs2.next()){
                                result.danhSachPhong.get(i).dichVu.add(result.createPhongVaDichVu().createDichVu());
                                result.danhSachPhong.get(i).dichVu.get(k).setChiTietDichVu(new ChiTietDichVuHoaDon(rs2.getInt(1), new DichVu(rs2.getString(5), rs2.getString(6), rs2.getDouble(7), 0, 0, null), null, null));
                                k++;
                            }
                        
                        
                        //next Phong Chuyen Phong
                        tempResult = rs.getString(9);
                        pre = tempResult.substring(0,5);
                        
                    }
                }
                while (tempResult.contains("MP000") == false);
                return result;
                
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return null;
    }
    
}
