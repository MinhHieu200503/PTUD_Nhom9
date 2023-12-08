/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.ChiTietDichVuHoaDon;
import entity.ChiTietPhongHoaDon;
import entity.DichVu;
import entity.HoaDon;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.ThongTinPhongDangChon;
import entity.UuDai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;



/**
 *
 * @author quang
 */
public class DAO_HoaDon implements I_CRUD<HoaDon>{
    public ArrayList<String> getDsIdTheoNgayHienTai() {
        ArrayList<String> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "select mahoadon from hoadon where convert(date, ngayLapHoaDon) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ds.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public boolean updateNhanVienNhanPhong(String maNhanVien,String maHoaDon){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
          try {

              statement = con.prepareStatement("update HoaDon\n" +
                                                "set maNhanVien = ? \n" +
                                                "where maHoaDon = ? ");

              statement.setString(1, maNhanVien);

              statement.setString(2, maHoaDon);

              n = statement.executeUpdate();

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
          return n > 0;
    }
    
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
            statement = con.prepareStatement("Select * from ChiTietPhongHoaDon ct inner join Phong p on ct.maPhong= p.maPhong where p.trangThai = 2 and ct.ghiChu like N'%Đang sử dụng'  and ct.maPhong = ?");
            //TEST
//            statement = con.prepareStatement("Select * from ChiTietPhongHoaDon ct inner join Phong p on ct.maPhong= p.maPhong where p.trangThai = 2  and ct.maPhong = ?");

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
    
    public boolean updateTrangThaiHoaDonBangMaHoaDon(String maHoaDon, int TrangThai) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
          try {

              statement = con.prepareStatement("update HoaDon\n" +
                                                "set trangThai = ? \n" +
                                                "where maHoaDon = ? ");

              statement.setInt(1, TrangThai);

              statement.setString(2, maHoaDon);

              n = statement.executeUpdate();

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
          return n > 0;
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
            String soDienThoai = "";
//           System.out.println("MaHoaDon: " + maHD);
            
//0 mã phòng
            result.setMaPhong(maPhong);
//            System.out.println("MaPhongDangChon: " + result.getMaPhong());
            
            // Tên Khách hàng
            statement = con.prepareStatement("Select * from HoaDon hd inner join KhachHang kh on hd.maKhachHang = kh.soDienThoai where maHoaDon = ?");
            statement.setString(1, maHD);
            rs = statement.executeQuery();
            
            
            result.setMaUuDai(null);
            
            while (rs.next()) {
//1 tên khách hàng
                result.setTenKhachHang(rs.getString("tenKhachHang"));
                soDienThoai = rs.getString("soDienThoai");
                result.setMaUuDai(rs.getString("maUuDai"));
//                System.out.println("TenKhachHang: " + result.getTenKhachHang());
            }
            
            statement = con.prepareStatement("select tongThoiGian = sum((datediff(minute, thoiGianNhanPhong, thoiGianTraPhong))) from ChiTietPhongHoaDon ctphd inner join HoaDon hd on ctphd.maHoaDon = hd.maHoaDon\n" +
                                             "inner join KhachHang kh on kh.soDienThoai = hd.maKhachHang\n" +
                                             "where trangThai = 1 and kh.soDienThoai = ?");
            statement.setString(1, soDienThoai);
            rs = statement.executeQuery();
            
            while(rs.next()){
                System.out.println("thoiGIanTichLuy" + rs.getInt(1));
                if (rs.getString(1) != null){
                    result.setThoiGianSuDungTichLuy(rs.getInt(1));
                }
                else{
                    result.setThoiGianSuDungTichLuy(0);
                }
            }

//2 3 6  Thời gian nhận, thời gian sử dụng tạm tính, ghi chú
            statement = con.prepareStatement("select * from HoaDon hd inner join ChiTietPhongHoaDon ctp on hd.maHoaDon = ctp.maHoaDon inner join Phong p on ctp.maPhong = p.maPhong where hd.maHoaDon = ? and ctp.maPhong = ?");
            statement.setString(1, maHD);
            statement.setString(2, maPhong);
            rs = statement.executeQuery();
            
            entity.ChiTietPhongHoaDon phongDangChon = null;
            entity.HoaDon tempHoaDon = null;
            entity.Phong tempPhong = null;

            while (rs.next()) {
                // Quang: tui chỉnh lại entity hoá đơn, có tác động vào thêm tham số ghi chú là ""
                tempHoaDon = new HoaDon(maHD, rs.getTimestamp(2).toLocalDateTime(), rs.getInt(3),"", null, null, null); 
                tempPhong = I_CRUD.findById(maPhong, new Phong());
                
                phongDangChon = new ChiTietPhongHoaDon(rs.getTimestamp("thoiGianNhanPhong").toLocalDateTime(), LocalDateTime.now(), rs.getString(10) , tempHoaDon, tempPhong);
            }
//            System.out.println("PhongDangChon: " + phongDangChon.toString());
            // có được chi tiết phòng đang chọn (Mã hóa đơn, mã phòng ) -> đi lấy các phòng chuyển của phòng đang được chọn cho vào ghi chú
//            System.out.println("HoaDon: " + tempHoaDon.toString());
//            System.out.println("HoaDon: " + tempPhong.toString());  
//            System.out.println("HoaDon: " + phongDangChon.toString());
            

            // check Boolean Phiếu đặt phòng
            statement = con.prepareStatement("select * from HoaDon hd inner join PhieuDatPhong pdp on hd.maHoaDon = pdp.maHoaDon \n" +
                                            "\n" +
                                            "where hd.maHoaDon = ?");
            statement.setString(1, maHD);
            rs = statement.executeQuery();
            while (rs.next()) {                
                result.setDatCoc(rs.getDouble("datCoc"));
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
                
                
               if (!pre.contains("MP000")){
                    do{
                    statement = con.prepareStatement("select * from HoaDon hd inner join ChiTietPhongHoaDon ctp on hd.maHoaDon = ctp.maHoaDon inner join Phong p on ctp.maPhong = p.maPhong where hd.maHoaDon = ? and ctp.maPhong = ?");
                    statement.setString(1, maHD);
                    statement.setString(2, pre);

                    rs = statement.executeQuery();
                    while(rs.next()){
                        i++;
                        result.danhSachPhong.add(result.createPhongVaDichVu());
                        tempPhong = I_CRUD.findById(rs.getString(12), new Phong());
                        result.danhSachPhong.get(i).setChiTietPhongHoaDon(new ChiTietPhongHoaDon(rs.getTimestamp("thoiGianNhanPhong").toLocalDateTime(),
                                        rs.getTimestamp("thoiGianTraPhong").toLocalDateTime(), 
                                        rs.getString(10) , 
                                        tempHoaDon, tempPhong));
                        
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
                        tempResult = rs.getString(10);
                        pre = tempResult.substring(0,5);
                    }
                }
                while (tempResult.contains("MP000") == false);
               }
                       
                       
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
    
    
    public double[] tongTienPhongVaDichVuHoaDon(String idHoaDon){
        double[] result = {0.0, 0.0};
        
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        ResultSet rs;
        
        HoaDon hoaDon = I_CRUD.findById(idHoaDon, new HoaDon());
        
        String[] ghiChuHoaDon = hoaDon.getGhiChu().split(", ");
        

        
//------Test String
        try {
            for (String ghiChuHoaDonSplit : ghiChuHoaDon) {
                String[] ghiChuSplit2 = ghiChuHoaDonSplit.split(" ");
                    ArrayList<ChiTietPhongHoaDon> listPhong = new ArrayList<>();
                    statement = con.prepareStatement("SELECT * FROM ChiTietPhongHoaDon WHERE maHoaDon = ? and maPhong = ? and ghiChu like N'%Đã hoàn thành%'");
                    statement.setString(1, hoaDon.getMaHoaDon());
                    statement.setString(2, ghiChuSplit2[0]);
                    rs = statement.executeQuery();
                    while (rs.next()){
                        listPhong.add(new ChiTietPhongHoaDon(
                                rs.getTimestamp("thoiGianNhanPhong").toLocalDateTime(),
                                rs.getTimestamp("thoiGianTraPhong").toLocalDateTime(),
                                rs.getString("ghiChu"),
                                hoaDon,
                                I_CRUD.findById(rs.getString("maPhong"), new Phong()))
                        );
                        
                    statement = con.prepareStatement("SELECT * FROM ChiTietDichVuHoaDon  ct\n" +
                                                             "inner join DichVu dv on ct.maDichVu = dv.maDichVu\n" +
                                                             "WHERE maHoaDon = ? and maPhong = ?");
                    statement.setString(1, hoaDon.getMaHoaDon());
                    statement.setString(2, ghiChuSplit2[0]);
                    ResultSet rs2 = statement.executeQuery();
                        while(rs2.next()){
                            result[1] += rs2.getInt(1) * rs2.getDouble("gia");
                        }
                        
                        String pre = rs.getString("ghiChu").substring(0, 5);
                        String tempResult = "";
                        if (!pre.contains("MP000")){
                            do{
                                statement = con.prepareStatement("select * from HoaDon hd inner join ChiTietPhongHoaDon ctp on hd.maHoaDon = ctp.maHoaDon inner join Phong p on ctp.maPhong = p.maPhong where hd.maHoaDon = ? and ctp.maPhong = ?");
                                statement.setString(1, hoaDon.getMaHoaDon());
                                statement.setString(2, pre);

                                rs2 = statement.executeQuery();
                                while(rs2.next()){
                                    listPhong.add(new ChiTietPhongHoaDon(
                                            rs2.getTimestamp("thoiGianNhanPhong").toLocalDateTime(),
                                            rs2.getTimestamp("thoiGianTraPhong").toLocalDateTime(),
                                            rs2.getString(10),
                                            hoaDon,
                                            I_CRUD.findById(rs2.getString("maPhong"), new Phong()))
                                    );

                                    statement = con.prepareStatement("SELECT * FROM ChiTietDichVuHoaDon  ct\n" +
                                                                             "inner join DichVu dv on ct.maDichVu = dv.maDichVu\n" +
                                                                             "WHERE maHoaDon = ? and maPhong = ?");
                                    statement.setString(1, hoaDon.getMaHoaDon());
                                    statement.setString(2, ghiChuSplit2[0]);
                                    ResultSet rs3 = statement.executeQuery();
                                        while(rs3.next()){
                                            result[1] += rs3.getInt(1) * rs3.getDouble("gia");
                                        }
                                    //next Phong Chuyen Phong
                                    tempResult = rs2.getString(10);
                                    pre = tempResult.substring(0,5);
                                }
                            }
                            while (tempResult.contains("MP000") == false);
                        }
                    }

                for (ChiTietPhongHoaDon chiTietPhongHoaDon : listPhong) {
                                Duration timeResult = Duration.between(chiTietPhongHoaDon.getThoiGianTraPhong(), chiTietPhongHoaDon.getThoiGianNhanPhong());
                                long minutes = Math.abs(timeResult.toMinutes());              
                                result[0] += chiTietPhongHoaDon.getPhong().getLoaiPhong().getGia() * minutes;
                }
                if (ghiChuSplit2.length == 2){
                    result[0] = result[0] + (result[0] * Integer.valueOf(ghiChuSplit2[1])/100.0) ;
                    result[1] = result[1] + (result[1] * Integer.valueOf(ghiChuSplit2[1])/100.0) ;
                }else if (ghiChuSplit2.length ==3){
                    result[0] = result[0] + (result[0] * Integer.valueOf(ghiChuSplit2[1])/100.0) - (result[0] * Integer.valueOf(ghiChuSplit2[2])/100.0);
                    result[1] = result[1] + (result[1] * Integer.valueOf(ghiChuSplit2[1])/100.0) - (result[1] * Integer.valueOf(ghiChuSplit2[2])/100.0);
                }
                
                
                if (hoaDon.getUuDai() != null){
                    result[0] -= (result[0] * hoaDon.getUuDai().getGiamGia());
                    result[1] -= (result[1] * hoaDon.getUuDai().getGiamGia());
                }
            }

        }
        catch (SQLException ex) {
                    Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;    
       }
    
    public ArrayList<String> tongDoanhThu_NamDoanhThu_ComboBox(){
        ArrayList<String> result = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            PreparedStatement pstm = con.prepareStatement("SELECT nam = Year(ngayLapHoaDon) FROM HoaDon ORDER BY nam DESC");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("nam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }    
    
    public ArrayList<String> DoanhThuThang_ComboBox(){
        ArrayList<String> result = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            PreparedStatement pstm = con.prepareStatement("DECLARE @StartMonth INT;\n" +
                                                          "DECLARE @EndMonth INT;\n" +
                                                          "DECLARE @CurrentMonth INT;\n" +
                                                          "\n" +
                                                          "SET @CurrentMonth = MONTH(GETDATE());\n" +
                                                          "SET @StartMonth = @CurrentMonth;\n" +
                                                          "SET @EndMonth = @CurrentMonth - 6;\n" +
                                                          "\n" +
                                                          "WITH MonthList AS (\n" +
                                                          "    SELECT @StartMonth AS Thang\n" +
                                                          "    UNION ALL\n" +
                                                          "    SELECT Thang - 1\n" +
                                                          "    FROM MonthList\n" +
                                                          "    WHERE Thang > @EndMonth\n" +
                                                          ")\n" +
                                                          "\n" +
                                                          "SELECT\n" +
                                                          "    Thang AS Thang,\n" +
                                                          "    DATENAME(MONTH, DATEFROMPARTS(YEAR(GETDATE()), Thang, 1)) AS TenThang\n" +
                                                          "FROM MonthList");
            ResultSet rs = pstm.executeQuery(); 
            while (rs.next()) {
                result.add(rs.getString("Thang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int tongDoanhThu_TongSoHoaDon(String input_Year){
        int result = -1;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "SELECT soLuong = Count(maHoaDon) FROM HoaDon\n" +
                         "WHERE YEAR(ngayLapHoaDon) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, input_Year);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.wasNull()){
                    result = 0;
                }else{
                    result = rs.getInt("soLuong");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
        public int tongDoanhThu_TongSoDichVu(String input_Year){
        int result = -1;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "SELECT soLuong = Count(*) FROM HoaDon hd\n" +
                         "JOIN ChiTietDichVuHoaDon ctdv on hd.maHoaDon = ctdv.maHoaDon\n" +
                         "WHERE YEAR(ngayLapHoaDon) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, input_Year);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                result = rs.getInt("soLuong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
        
        public ArrayList<String> tongDoanhThu_LayHoaDonTheoNam(String input_Year, String input_Month){
            ArrayList<String> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM HoaDon WHERE year(ngayLapHoaDon) = ? and month(ngayLapHoaDon) like ?");
                pstm.setString(1, input_Year);
                if (input_Month.equals("")){
                    pstm.setString(2, "%"+input_Month);
                }
                else{
                    pstm.setString(2, input_Month);
                }
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    result.add(rs.getString("maHoaDon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public double[] tongDoanhThu_PhongVaDichVu(String input_Year, String input_Month){
            double[] result = {0.0, 0.0};
            ArrayList<String> temp_HoaDon = tongDoanhThu_LayHoaDonTheoNam(input_Year, input_Month);
            for (String string : temp_HoaDon) {
                double[] temp = tongTienPhongVaDichVuHoaDon(string);
                result[0] += temp[0];
                result[1] += temp[1];
            }

            return result;
        }
        
        public ArrayList<String[]> tongDoanhThu_PhongSuDungNhieuNhat(String input_Year){
            ArrayList<String[]> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                PreparedStatement pstm = con.prepareStatement("SELECT maPhong ,soLan = Count(maPhong) FROM ChiTietPhongHoaDon \n" +
                                                              "WHERE year(thoiGianNhanPhong) = ? and ghiChu like N'%MP000 Đã hoàn thành' \n" +
                                                              "group by maPhong\n" +
                                                              "order by solan desc");
                pstm.setString(1, input_Year);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    result.add(new String[] {rs.getString("maPhong"), rs.getString("soLan")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<String[]> tongDoanhThu_DichVuSuDungNhieuNhat(String input_Year){
            ArrayList<String[]> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                PreparedStatement pstm = con.prepareStatement("SELECT tenDichVu, soLan = sum(ctdv.soLuong) FROM ChiTietDichVuHoaDon ctdv\n" +
                                                              "join DichVu dv on dv.maDichVu = ctdv.maDichVu\n" +
                                                              "join HoaDon hd on ctdv.maHoaDon = hd.maHoaDon\n" +
                                                              "WHERE year(hd.ngayLapHoaDon) = ?\n" +
                                                              "group by ctdv.maDichVu, dv.tenDichVu\n" +
                                                              "order by solan desc");
                pstm.setString(1, input_Year);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    result.add(new String[] {rs.getString("tenDichVu"), rs.getString("soLan")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        
        public int doanhThuThang_TongSoHoaDon(String year, String month){
            int result = 0;
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                String sql = "SELECT soLuong = Count(maHoaDon) FROM HoaDon\n" +
                             "WHERE YEAR(ngayLapHoaDon) = ? and month(ngayLapHoaDon) like ?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, year);
                pstm.setString(2, month);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    if (rs.wasNull()){
                        result = 0;
                    }else{
                        result = rs.getInt("soLuong");
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public int doanhThuThang_TongSoDichVu(String year, String month){
            int result = 0;
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                String sql = "SELECT soLuong = Count(*) FROM HoaDon hd\n" +
                             "JOIN ChiTietDichVuHoaDon ctdv on hd.maHoaDon = ctdv.maHoaDon\n" +
                             "WHERE YEAR(ngayLapHoaDon) = ? and month(ngayLapHoaDon) like ?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, year);
                pstm.setString(2, month);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    if (rs.wasNull()){
                        result = 0;
                    }else{
                        result = rs.getInt("soLuong");
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<String[]> doanhThuThang_PhongSuDungNhieuNhat(String year, String month){
            ArrayList<String[]> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                PreparedStatement pstm = con.prepareStatement("SELECT sucChua ,p.maPhong, tenPhong, soLan = Count(p.maPhong), tenLoaiPhong FROM ChiTietPhongHoaDon\n" +
                                                              "join phong p on ChiTietPhongHoaDon.maPhong = p.maPhong\n" +
                                                              "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong \n" +
                                                              "WHERE year(thoiGianNhanPhong) = ? and month(thoiGianNhanPhong) like ? and ghiChu like N'%MP000 Đã hoàn thành' \n" +
                                                              "group by p.maPhong, p.tenPhong, sucChua, tenLoaiPhong\n" +
                                                              "order by solan desc");
                pstm.setString(1, year);
                pstm.setString(2, month);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    result.add(new String[] {rs.getString("maPhong"), rs.getString("soLan"), rs.getString("tenPhong"), rs.getString("sucChua"), rs.getString("tenLoaiPhong")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<String[]> doanhThuThang_DichVuSuDungNhieuNhat(String year, String month){
            ArrayList<String[]> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            try {
                PreparedStatement pstm = con.prepareStatement("SELECT tenDichVu, soLan = sum(ctdv.soLuong) FROM ChiTietDichVuHoaDon ctdv\n" +
                                                              "join DichVu dv on dv.maDichVu = ctdv.maDichVu\n" +
                                                              "join HoaDon hd on ctdv.maHoaDon = hd.maHoaDon\n" +
                                                              "WHERE year(hd.ngayLapHoaDon) = ? and month(hd.ngayLapHoaDon) like ?\n" +
                                                              "group by ctdv.maDichVu, dv.tenDichVu\n" +
                                                              "order by solan desc");
                pstm.setString(1, year);
                pstm.setString(2, month);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    result.add(new String[] {rs.getString("tenDichVu"), rs.getString("soLan")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<Integer> doanhThuThang_DichVuTheoNgay(String year, String month){
            ArrayList<Integer> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            LocalDate temp = LocalDate.now();
            YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));
            int lengthOfMonth = yearMonthObject.lengthOfMonth();

            if (temp.getMonthValue() == Integer.valueOf(month) && temp.getYear() == Integer.valueOf(year)){
                lengthOfMonth = temp.getDayOfMonth();
            }
            
            try {
                for(int i = 0; i < lengthOfMonth; i++){
                    PreparedStatement pstm = con.prepareStatement("SELECT sum(ctdv.soLuong) FROM ChiTietDichVuHoaDon ctdv\n" +
                                                                "join DichVu dv on dv.maDichVu = ctdv.maDichVu\n" +
                                                                "join HoaDon hd on ctdv.maHoaDon = hd.maHoaDon\n" +
                                                                "WHERE year(hd.ngayLapHoaDon) = ? and month(hd.ngayLapHoaDon) = ? and day(hd.ngayLapHoaDon) = ?");
                    pstm.setString(1, year);
                    pstm.setString(2, month);
                    pstm.setString(3, String.valueOf(i));
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<Integer> doanhThuThang_TrungBinhKhachHang(String year, String month){
            ArrayList<Integer> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            LocalDate temp = LocalDate.now();
            YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));
            int lengthOfMonth = yearMonthObject.lengthOfMonth();

            if (temp.getMonthValue() == Integer.valueOf(month) && temp.getYear() == Integer.valueOf(year)){
                lengthOfMonth = temp.getDayOfMonth();
            }
            
            try {
                for(int i = 0; i < lengthOfMonth; i++){
                    PreparedStatement pstm = con.prepareStatement("SELECT Count(maHoaDon) FROM HoaDon hd \n" +
                                                                  "WHERE year(hd.ngayLapHoaDon) = ? and month(hd.ngayLapHoaDon) like ? and day(hd.ngayLapHoaDon) = ?");
                    pstm.setString(1, year);
                    pstm.setString(2, month);
                    pstm.setString(3, String.valueOf(i));
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<entity.ChiTietPhongHoaDon> doanhThuThang_TrungBinhSuDungPhong(String year, String month){
            ArrayList<entity.ChiTietPhongHoaDon> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            LocalDate temp = LocalDate.now();
            YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));
            int lengthOfMonth = yearMonthObject.lengthOfMonth();

            if (temp.getMonthValue() == Integer.valueOf(month) && temp.getYear() == Integer.valueOf(year)){
                lengthOfMonth = temp.getDayOfMonth();
            }
            
            try {
                for(int i = 0; i < lengthOfMonth; i++){
                    PreparedStatement pstm = con.prepareStatement("SELECT * FROM HoaDon hd\n" +
                                                                    "join ChiTietPhongHoaDon ct on hd.maHoaDon = ct.maHoaDon\n" +
                                                                    "WHERE year(hd.ngayLapHoaDon) = ? and month(hd.ngayLapHoaDon) like ? and day(hd.ngayLapHoaDon) = ?\n" +
                                                                    "and ct.ghiChu like N'MP000 Đã hoàn thành'");
                    pstm.setString(1, year);
                    pstm.setString(2, month);
                    pstm.setString(3, String.valueOf(i));
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        result.add(new ChiTietPhongHoaDon(rs.getTimestamp("thoiGianNhanPhong").toLocalDateTime()
                                , rs.getTimestamp("thoiGianTraPhong").toLocalDateTime()
                                , rs.getString("ghiChu"), null, null));
                    }
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
        
        public ArrayList<entity.HoaDon> doanhThuThang_GioCaoDiem(String year, String month){
            ArrayList<entity.HoaDon> result = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            LocalDate temp = LocalDate.now();
            YearMonth yearMonthObject = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));
            int lengthOfMonth = yearMonthObject.lengthOfMonth();

            if (temp.getMonthValue() == Integer.valueOf(month) && temp.getYear() == Integer.valueOf(year)){
                lengthOfMonth = temp.getDayOfMonth();
            }
            
            try {
                for(int i = 0; i < lengthOfMonth; i++){
                    PreparedStatement pstm = con.prepareStatement("SELECT * FROM HoaDon hd \n" +
                                                                  "WHERE year(hd.ngayLapHoaDon) = ? and month(hd.ngayLapHoaDon) like ? and day(hd.ngayLapHoaDon) = ?");
                    pstm.setString(1, year);
                    pstm.setString(2, month);
                    pstm.setString(3, String.valueOf(i));
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        result.add(I_CRUD.findById(rs.getString("maHoaDon"), new HoaDon()));
                    }
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
    
}
