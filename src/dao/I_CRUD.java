/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import connectDB.ConnectDB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import entity.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public interface I_CRUD<T> {
    public static LocalDateTime SQLtoJava(String sql) {
        if (sql == null)
			return null;
		String dateSQL = sql.substring(0, 10);
		String timeSQL = sql.substring(11, 19);
		LocalDate date = LocalDate.parse(dateSQL);
		LocalTime time = LocalTime.parse(timeSQL);
		return LocalDateTime.of(date, time);
    }
    public static String JavaToSQL(LocalDateTime java) {
        if (java == null)
            return null;
        String datetime = java.toString();
        System.out.println(datetime);
        return datetime.substring(0,   10) + " " + datetime.substring(11, 16);
    }
    /**
     * @param entity
     * @return
     */
    default boolean create(T entity) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        PreparedStatement pstm = null;
        int n = 0; // trả về số dòng ảnh hưởng
        try { 
            String sql = "INSERT INTO " + entity.getClass().getSimpleName() + " VALUES (";
            Field[] fields = entity.getClass().getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                sql += "?,";
            }
            pstm = con.prepareStatement(sql.substring(0, sql.length() - 1) + ")");
            int i = 1;
            for (Field field : fields) {
                field.setAccessible(true); // lấy quyền truy cập private trong class
                // System.out.println(field.getName());
                switch (field.getType().getSimpleName()) {
                    case "Phong" -> pstm.setString(i, ((Phong) field.get(entity)).getMaPhong());
                    case "LoaiPhong" -> pstm.setString(i, ((LoaiPhong) field.get(entity)).getMaLoaiPhong());
                    case "KhachHang" -> pstm.setString(i, ((KhachHang) field.get(entity)).getSoDienThoai());
                    case "NhanVien" -> pstm.setString(i, ((NhanVien) field.get(entity)).getMaNhanVien());
                    case "ChucVu" -> pstm.setString(i, ((ChucVu) field.get(entity)).getMaChucVu());
                    case "Ca" -> pstm.setString(i, ((Ca) field.get(entity)).getMaCa());
                    case "TaiKhoan" -> pstm.setString(i, ((TaiKhoan) field.get(entity)).getTenTaiKhoan());
                    case "UuDai" -> pstm.setString(i, ((UuDai) field.get(entity)).getMaUuDai());
                    case "DichVu" -> pstm.setString(i, ((DichVu) field.get(entity)).getMaDichVu());
                    case "HoaDon" -> pstm.setString(i, ((HoaDon) field.get(entity)).getMaHoaDon());
                    case "int" -> pstm.setInt(i, (int) field.get(entity));
                    case "double" -> pstm.setDouble(i, (double) field.get(entity));
                    case "float" -> pstm.setFloat(i, (float) field.get(entity));
                    case "long" -> pstm.setLong(i, (long) field.get(entity));
                    case "boolean" -> pstm.setBoolean(i, (boolean) field.get(entity));
                    case "LocalDate" -> pstm.setDate(i, (Date.valueOf(field.get(entity).toString())));
                    case "LocalDateTime" -> pstm.setString(i, JavaToSQL((LocalDateTime) field.get(entity)));
                    default -> pstm.setString(i, (String) field.get(entity));
                }
                i++;
            }
            n = pstm.executeUpdate();
        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(I_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }    
    default ArrayList<T> getAll(Class<T> clazz) {
        ArrayList<T> ds = new ArrayList<T>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        Statement stm = null;
        try {    
            Field[] fields = clazz.getDeclaredFields();
            String sql = "SELECT * FROM " + clazz.getSimpleName();
//            System.out.println(sql);
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                T entity1 = clazz.getDeclaredConstructor().newInstance(); // Tạo đối tượng mới
                for (Field field : fields) {
                    field.setAccessible(true);
                    switch (field.getType().getSimpleName()) {
                        case "Phong" -> field.set(entity1, findById(rs.getString("maPhong"), new Phong()));
                        case "LoaiPhong" -> field.set(entity1, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                        case "KhachHang" -> {
                            // Kiểm tra xem nếu class là phiếu đặt phòng thì lấy maKhachHang
                            if (clazz.getSimpleName().equals("PhieuDatPhong") || clazz.getSimpleName().equals("HoaDon")) {
                                field.set(entity1, findById(rs.getString("maKhachHang"), new KhachHang()));
                            } else {
                                field.set(entity1, findById(rs.getString("soDienThoai"), new KhachHang()));
                            }
                        }
                        case "NhanVien" -> field.set(entity1, findById(rs.getString("maNhanVien"), new NhanVien()));
                        case "ChucVu" -> field.set(entity1, findById(rs.getString("maChucVu"), new ChucVu()));
                        case "Ca" -> field.set(entity1, findById(rs.getString("maCa"), new Ca()));
                        case "TaiKhoan" -> field.set(entity1, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                        case "UuDai" -> field.set(entity1, findById(rs.getString("maUuDai"), new UuDai()));
                        case "DichVu" -> field.set(entity1, findById(rs.getString("maDichVu"), new DichVu()));
                        case "HoaDon" -> field.set(entity1, findById(rs.getString("maHoaDon"), new HoaDon()));
                        case "int" -> field.set(entity1, rs.getInt(field.getName()));
                        case "double" -> field.set(entity1, rs.getDouble(field.getName()));
                        case "float" -> field.set(entity1, rs.getFloat(field.getName()));
                        case "long" -> field.set(entity1, rs.getLong(field.getName()));
                        case "boolean" -> field.set(entity1, rs.getBoolean(field.getName()));
                        case "LocalDate" -> field.set(entity1, LocalDate.parse(rs.getString(field.getName())));
                        case "LocalDateTime" -> field.set(entity1, SQLtoJava(rs.getString(field.getName())));
                        default -> {
                            // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                            if (rs.getString(field.getName()) == null)
                                field.set(entity1, rs.getString(field.getName()));
                            else
                                field.set(entity1, rs.getString(field.getName()).trim()); // phải trim() vì trong db có tới 10 kí tự.
                        }
                    }
                }
                ds.add(entity1);
            }
        } catch (SQLException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InstantiationException | InvocationTargetException ex) {
            Logger.getLogger(I_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    static <T> T findById(String id, T entity) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        PreparedStatement pstm = null;
        try {   
            String sql = "SELECT * FROM " + entity.getClass().getSimpleName() + " WHERE ";
            Field[] fields = entity.getClass().getDeclaredFields();
            sql += fields[0].getName() + " = ?"; // lấy tên cột đầu tiên
            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            // Gán từng field trong entity với các giá trị nhận được từ csdl
            // int i = 0;
            while (rs.next()) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                  
                    System.out.println(fields[i].getName());
                    switch (fields[i].getType().getSimpleName()) {
                        case "Phong" -> fields[i].set(entity, findById(rs.getString("maPhong"), new Phong()));
                        case "LoaiPhong" -> fields[i].set(entity, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                        case "KhachHang" -> {
                            if (entity.getClass().getSimpleName().equals("PhieuDatPhong") || entity.getClass().getSimpleName().equals("HoaDon")) {
                                fields[i].set(entity, findById(rs.getString("maKhachHang"), new KhachHang()));
                            } else {
                                fields[i].set(entity, findById(rs.getString("soDienThoai"), new KhachHang()));
                            }
                        }
                        case "NhanVien" -> fields[i].set(entity, findById(rs.getString("maNhanVien"), new NhanVien()));
                        case "ChucVu" -> fields[i].set(entity, findById(rs.getString("maChucVu"), new ChucVu()));
                        case "Ca" -> fields[i].set(entity, findById(rs.getString("maCa"), new Ca()));
                        case "TaiKhoan" -> fields[i].set(entity, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                        case "UuDai" -> fields[i].set(entity, findById(rs.getString("maUuDai"), new UuDai()));
                        case "DichVu" -> fields[i].set(entity, findById(rs.getString("maDichVu"), new DichVu()));
                        case "HoaDon" -> fields[i].set(entity, findById(rs.getString("maHoaDon"), new HoaDon()));
                        case "int" -> fields[i].set(entity, rs.getInt(fields[i].getName()));
                        case "double" -> fields[i].set(entity, rs.getDouble(fields[i].getName()));
                        case "float" -> fields[i].set(entity, rs.getFloat(fields[i].getName()));
                        case "long" -> fields[i].set(entity, rs.getLong(fields[i].getName()));
                        case "boolean" -> fields[i].set(entity, rs.getBoolean(fields[i].getName()));
                        case "LocalDate" -> fields[i].set(entity, LocalDate.parse(rs.getString(fields[i].getName())));
                        case "LocalDateTime" -> fields[i].set(entity, SQLtoJava(rs.getString(fields[i].getName())));
                        default -> {
                            // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                            if (rs.getString(fields[i].getName()) == null)
                                fields[i].set(entity, rs.getString(fields[i].getName()));
                            else
                                fields[i].set(entity, rs.getString(fields[i].getName()).trim());
                        } 
                    }
                }
            }
        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(I_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    default boolean update(T entity) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        System.out.println(con);
        PreparedStatement pstm = null;
        int n = 0;
        try {    
            String sql = "UPDATE " + entity.getClass().getSimpleName() + " SET ";
            Field[] fields = entity.getClass().getDeclaredFields();
            for (int j = 1; j < fields.length; j++) {
                // nếu là thực thể thì lấy mã thực thể
                switch (fields[j].getType().getSimpleName()) {
                    case "Phong", "LoaiPhong", "KhachHang", "NhanVien", "ChucVu", "Ca", "TaiKhoan", "UuDai", "DichVu", "HoaDon" -> 
                        // Lấy mã của thực thể phòng
                        // viết hoa chữ cái đầu
                        sql += "ma" + fields[j].getName().substring(0, 1).toUpperCase() + fields[j].getName().substring(1) + " = ?,";
                    default -> sql += fields[j].getName() + " = ?,";
                }
                
            }
            sql = sql.substring(0, sql.length() - 1) + " WHERE ";
            sql += fields[0].getName() + " = ?";
            System.out.println(sql);
            pstm = con.prepareStatement(sql);
            for (int i = 1; i < fields.length ;i++) {
                fields[i].setAccessible(true); // lấy quyền truy cập private trong class
                switch (fields[i].getType().getSimpleName()) {
                    case "Phong" -> pstm.setString(i, ((Phong) fields[i].get(entity)).getMaPhong());
                    case "LoaiPhong" -> pstm.setString(i, ((LoaiPhong) fields[i].get(entity)).getMaLoaiPhong());
                    case "KhachHang" -> pstm.setString(i, ((KhachHang) fields[i].get(entity)).getSoDienThoai());
                    case "NhanVien" -> pstm.setString(i, ((NhanVien) fields[i].get(entity)).getMaNhanVien());
                    case "ChucVu" -> pstm.setString(i, ((ChucVu) fields[i].get(entity)).getMaChucVu());
                    case "Ca" -> pstm.setString(i, ((Ca) fields[i].get(entity)).getMaCa());
                    case "TaiKhoan" -> pstm.setString(i, ((TaiKhoan) fields[i].get(entity)).getTenTaiKhoan());
                    case "UuDai" -> pstm.setString(i, ((UuDai) fields[i].get(entity)).getMaUuDai());
                    case "DichVu" -> pstm.setString(i, ((DichVu) fields[i].get(entity)).getMaDichVu());
                    case "HoaDon" -> pstm.setString(i, ((HoaDon) fields[i].get(entity)).getMaHoaDon());
                    case "int" -> pstm.setInt(i, (int) fields[i].get(entity));
                    case "double" -> pstm.setDouble(i, (double) fields[i].get(entity));
                    case "float" -> pstm.setFloat(i, (float) fields[i].get(entity));
                    case "long" -> pstm.setLong(i, (long) fields[i].get(entity));
                    case "boolean" -> pstm.setBoolean(i, (boolean) fields[i].get(entity));
                    case "LocalDate" -> pstm.setDate(i, (Date.valueOf(fields[i].get(entity).toString())));
                    case "LocalDateTime" -> pstm.setString(i, JavaToSQL((LocalDateTime) fields[i].get(entity)));
                    default -> pstm.setString(i, (String) fields[i].get(entity));
                }
            }
            // Set giá trị cho cột đầu tiên
            fields[0].setAccessible(true);
            pstm.setString(fields.length, fields[0].get(entity).toString());
            n = pstm.executeUpdate();       
        } catch (SQLException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(I_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    // Hàm search tất cả các cột và trả về danh sách các bản ghi
    // Dùng cho key release vì mấy sự kiện key kia phải nhấn space nó mới load table
    default ArrayList<T> search(String key, Class<T> c) {
            ArrayList<T> ds = new ArrayList<>();
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            System.out.println(con);
        try {
            Field[] fields = c.getDeclaredFields();
            int so = -1;
            if (key.matches("^\\d+$"))
                so = Integer.parseInt(key);
            // Tạo câu truy vấn để lấy tất cả bản ghi trong bảng
            String sql = "SELECT";
            for (Field f : fields) {
                switch (f.getType().getSimpleName()) {
                    case "NhanVien", "Phong", "LoaiPhong", "KhachHang", "ChucVu", "Ca", "TaiKhoan", "UuDai", "DichVu", "HoaDon":
                        // lấy mã
                        sql += " a.ma" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) + ",";
                        break;
                    default:
                        // lấy tên cột
                        sql += " a."+  f.getName() + ",";
                        break;
                }
            }
            sql = sql.substring(0, sql.length() - 1); // loại bỏ dấu , ở cuối
            sql += " FROM " + c.getSimpleName() + " a";
            for (Field f : fields) {
                switch (f.getType().getSimpleName()) {
                    case "Phong", "LoaiPhong", "NhanVien", "ChucVu", "Ca", "TaiKhoan", "UuDai", "DichVu", "HoaDon":
                    
                        sql += " INNER JOIN " + f.getType().getSimpleName() 
                        + " ON " + "a.ma" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1) 
                        + " = " + f.getType().getSimpleName() + ".ma" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                        break;
                    case "KhachHang": // soDienThoai
                        sql += " INNER JOIN " + f.getType().getSimpleName() 
                        + " ON " + "a.ma" + f.getName().substring(0, 1) + f.getName().substring(1) 
                        + " = " + f.getType().getSimpleName() + ".soDienThoai";
                        break;
                    default:

                        break;
                }
            }
            sql += " WHERE ";
            for (int i = 0; i < fields.length; i++) {
                // nếu tên cột là số thì dùng = thay vì like
                switch (fields[i].getName()) {
                    // nếu là thực thể thì lấy tên thực thể
                    case "phong", "nhanVien", "khachHang", "chucVu", "ca", "taiKhoan", "uuDai", "dichVu" -> 
                        // thêm ten vào và viết hoa chữ cái đầu
                        sql +=  "ten" + fields[i].getType().getSimpleName() + " LIKE N'%" + key + "%' OR ";
                    case "hoaDon" -> sql += "a.maHoaDon LIKE N'%" + key + "%' OR ";
                    case "loaiPhong" -> sql += "loaiPhong LIKE N'%" + key + "%' OR ";
                    case "trangThai", "soLuong", "gia", "datCoc", "giamGia", "gioiTinh", "sucChuaToiDa" -> sql += "a." + fields[i].getName() + " = "+ so + " OR ";
                    default -> sql += "a."+ fields[i].getName() + " LIKE N'%" + key + "%' OR ";
                }
            }
            sql = sql.substring(0, sql.length() - 4); // loại bỏ " OR " ở cuối
            System.out.println(sql);
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                T entity = c.getDeclaredConstructor().newInstance(); // Tạo đối tượng mới
                for (Field field : fields) {
                    field.setAccessible(true);
                    switch (field.getType().getSimpleName()) {
                        case "Phong" -> field.set(entity, findById(rs.getString("maPhong"), new Phong()));
                        case "LoaiPhong" -> field.set(entity, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                        case "KhachHang" -> {
                            if (c.getSimpleName().equals("PhieuDatPhong") || c.getSimpleName().equals("HoaDon")) {
                                field.set(entity, findById(rs.getString("maKhachHang"), new KhachHang()));
                            } else {
                                field.set(entity, findById(rs.getString("soDienThoai"), new KhachHang()));
                            }
                        }
                        case "NhanVien" -> field.set(entity, findById(rs.getString("maNhanVien"), new NhanVien()));
                        case "ChucVu" -> field.set(entity, findById(rs.getString("maChucVu"), new ChucVu()));
                        case "Ca" -> field.set(entity, findById(rs.getString("maCa"), new Ca()));
                        case "TaiKhoan" -> field.set(entity, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                        case "UuDai" -> field.set(entity, findById(rs.getString("maUuDai"), new UuDai()));
                        case "DichVu" -> field.set(entity, findById(rs.getString("maDichVu"), new DichVu()));
                        case "HoaDon" -> field.set(entity, findById(rs.getString("maHoaDon"), new HoaDon()));
                        case "int" -> field.set(entity, rs.getInt(field.getName()));
                        case "double" -> field.set(entity, rs.getDouble(field.getName()));
                        case "float" -> field.set(entity, rs.getFloat(field.getName()));
                        case "long" -> field.set(entity, rs.getLong(field.getName()));
                        case "boolean" -> field.set(entity, rs.getBoolean(field.getName()));
                        case "LocalDate" -> field.set(entity, LocalDate.parse(rs.getString(field.getName())));
                        case "LocalDateTime" -> field.set(entity, SQLtoJava(rs.getString(field.getName())));
                        default -> {
                            // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                            if (rs.getString(field.getName()) == null)
                                field.set(entity, rs.getString(field.getName()));
                            else
                                field.set(entity, rs.getString(field.getName()).trim());
                        }
                    }
                }
                ds.add(entity);
            }
        } catch (SQLException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(I_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
}
