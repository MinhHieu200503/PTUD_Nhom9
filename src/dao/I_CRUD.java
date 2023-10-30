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
        return datetime.substring(0,   10) + " " + datetime.substring(11, 19);
    }
    /**
     * @param entity
     * @return
     */
    default boolean create(T entity) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        System.out.println(con);
        PreparedStatement pstm = null;
        int n = 0;
        
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
                    case "Phong":
                        pstm.setString(i, ((Phong) field.get(entity)).getMaPhong());
                        break;
                    case "LoaiPhong":
                        pstm.setString(i, ((LoaiPhong) field.get(entity)).getMaLoaiPhong());
                        break;
                    case "KhachHang":
                        pstm.setString(i, ((KhachHang) field.get(entity)).getSoDienThoai());
                        break;
                    case "NhanVien":
                        pstm.setString(i, ((NhanVien) field.get(entity)).getMaNhanVien());
                        break;
                    case "ChucVu":
                        pstm.setString(i, ((ChucVu) field.get(entity)).getMaChucVu());
                        break;
                    case "Ca":
                        pstm.setString(i, ((Ca) field.get(entity)).getMaCa());
                        break;
                    case "TaiKhoan":
                        pstm.setString(i, ((TaiKhoan) field.get(entity)).getTenTaiKhoan());
                        break;
                    case "UuDai":
                        pstm.setString(i, ((UuDai) field.get(entity)).getMaUuDai());
                        break;
                    case "DichVu":
                        pstm.setString(i, ((DichVu) field.get(entity)).getMaDichVu());
                        break;
                    case "HoaDon":
                        pstm.setString(i, ((HoaDon) field.get(entity)).getMaHoaDon());
                        break;
                    case "int":
                        pstm.setInt(i, (int) field.get(entity));
                        break;
                    case "double":
                        pstm.setDouble(i, (double) field.get(entity));
                        break;
                    case "float":
                        pstm.setFloat(i, (float) field.get(entity));
                        break;
                    case "long":
                        pstm.setLong(i, (long) field.get(entity));
                        break;
                    case "boolean":
                        pstm.setBoolean(i, (boolean) field.get(entity));
                        break;
                    case "LocalDate":
                        pstm.setDate(i, (Date.valueOf(field.get(entity).toString())));
                        break;
                    case "LocalDateTime":
                        pstm.setString(i, JavaToSQL((LocalDateTime) field.get(entity)));
                        break;
                    default:
                        pstm.setString(i, (String) field.get(entity));
                        break;
                }
                i++;
            }
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               pstm.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }    
    default ArrayList<T> getAll(Class<T> clazz) {
        ArrayList<T> ds = new ArrayList<T>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        System.out.println(con);
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
                        case "Phong":
                            field.set(entity1, findById(rs.getString("maPhong"), new Phong()));
                            break;
                        case "LoaiPhong":
                            field.set(entity1, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                            break;
                        case "KhachHang":
                            field.set(entity1, findById(rs.getString("soDienThoai"), new KhachHang()));
                            break;
                        case "NhanVien":
                            field.set(entity1, findById(rs.getString("maNhanVien"), new NhanVien()));
                            break;
                        case "ChucVu":
                            field.set(entity1, findById(rs.getString("maChucVu"), new ChucVu()));
                            break;
                        case "Ca":
                            field.set(entity1, findById(rs.getString("maCa"), new Ca()));
                            break;
                        case "TaiKhoan":
                            field.set(entity1, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                            break;
                        case "UuDai":
                            field.set(entity1, findById(rs.getString("maUuDai"), new UuDai()));
                            break;
                        case "DichVu":
                            field.set(entity1, findById(rs.getString("maDichVu"), new DichVu()));
                            break;
                        case "HoaDon":
                            field.set(entity1, findById(rs.getString("maHoaDon"), new HoaDon()));
                            break;
                        case "int":
                            field.set(entity1, rs.getInt(field.getName()));
                            break;
                        case "double":
                            field.set(entity1, rs.getDouble(field.getName()));
                            break;
                        case "float":
                            field.set(entity1, rs.getFloat(field.getName()));
                            break;
                        case "long":
                            field.set(entity1, rs.getLong(field.getName()));
                            break;
                        case "boolean":
                            field.set(entity1, rs.getBoolean(field.getName()));
                            break;
                        case "LocalDate":
                            field.set(entity1, LocalDate.parse(rs.getString(field.getName())));
                            break;
                        case "LocalDateTime":
                            field.set(entity1, SQLtoJava(rs.getString(field.getName())));
                            break;
                        default:
                            // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                            if (rs.getString(field.getName()) == null) 
                                field.set(entity1, rs.getString(field.getName()));
                            else
                                field.set(entity1, rs.getString(field.getName()).trim());
                            break;
                    }
                }
                ds.add(entity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               stm.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return ds;
    }
    static <T> T findById(String id, T entity) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        System.out.println(con);
        PreparedStatement pstm = null;
        try {
            String sql = "SELECT * FROM " + entity.getClass().getSimpleName() + " WHERE ";
            Field[] fields = entity.getClass().getDeclaredFields();
            sql += fields[0].getName() + " = ?"; // lấy tên cột đầu tiên
            System.out.println(sql);
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
                    case "Phong":
                        fields[i].set(entity, findById(rs.getString("maPhong"), new Phong()));
                        break;
                    case "LoaiPhong":
                        fields[i].set(entity, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                        break;
                    case "KhachHang":
                        fields[i].set(entity, findById(rs.getString("soDienThoai"), new KhachHang()));
                        break;
                    case "NhanVien":
                        fields[i].set(entity, findById(rs.getString("maNhanVien"), new NhanVien()));
                        break;
                    case "ChucVu":
                        fields[i].set(entity, findById(rs.getString("maChucVu"), new ChucVu()));
                        break;
                    case "Ca":
                        fields[i].set(entity, findById(rs.getString("maCa"), new Ca()));
                        break;
                    case "TaiKhoan":
                        fields[i].set(entity, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                        break;
                    case "UuDai":
                        fields[i].set(entity, findById(rs.getString("maUuDai"), new UuDai()));
                        break;
                    case "DichVu":
                        fields[i].set(entity, findById(rs.getString("maDichVu"), new DichVu()));
                        break;
                    case "HoaDon":
                        fields[i].set(entity, findById(rs.getString("maHoaDon"), new HoaDon()));
                        break;
                    case "int":
                        fields[i].set(entity, rs.getInt(fields[i].getName()));
                        break;
                    case "double":
                        fields[i].set(entity, rs.getDouble(fields[i].getName()));
                        break;
                    case "float":
                        fields[i].set(entity, rs.getFloat(fields[i].getName()));
                        break;
                    case "long":
                        fields[i].set(entity, rs.getLong(fields[i].getName()));
                        break;
                    case "boolean":
                        fields[i].set(entity, rs.getBoolean(fields[i].getName()));
                        break;
                    case "LocalDate":
                        fields[i].set(entity, LocalDate.parse(rs.getString(fields[i].getName())));
                        break;
                    case "LocalDateTime":
                        fields[i].set(entity, SQLtoJava(rs.getString(fields[i].getName())));
                        break;
                    default:
                        // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                        if (rs.getString(fields[i].getName()) == null) 
                            fields[i].set(entity, rs.getString(fields[i].getName()));
                        else
                            fields[i].set(entity, rs.getString(fields[i].getName()).trim());
                        break; 
                }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               pstm.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
                    case "Phong", "LoaiPhong", "KhachHang", "NhanVien", "ChucVu", "Ca", "TaiKhoan", "UuDai", "DichVu", "HoaDon":
                    // Lấy mã của thực thể phòng
                        // viết hoa chữ cái đầu
                        sql += "ma" + fields[j].getName().substring(0, 1).toUpperCase() + fields[j].getName().substring(1) + " = ?,";
                        break;
                    default:
                        sql += fields[j].getName() + " = ?,";
                        break;
                }
                
            }
            sql = sql.substring(0, sql.length() - 1) + " WHERE ";
            sql += fields[0].getName() + " = ?";
            System.out.println(sql);
            pstm = con.prepareStatement(sql);
            for (int i = 1; i < fields.length ;i++) {
                fields[i].setAccessible(true); // lấy quyền truy cập private trong class
                switch (fields[i].getType().getSimpleName()) {
                    case "Phong":
                        pstm.setString(i, ((Phong) fields[i].get(entity)).getMaPhong());
                        break;
                    case "LoaiPhong":
                        pstm.setString(i, ((LoaiPhong) fields[i].get(entity)).getMaLoaiPhong());
                        break;
                    case "KhachHang":
                        pstm.setString(i, ((KhachHang) fields[i].get(entity)).getSoDienThoai());
                        break;
                    case "NhanVien":
                        pstm.setString(i, ((NhanVien) fields[i].get(entity)).getMaNhanVien());
                        break;
                    case "ChucVu":
                        pstm.setString(i, ((ChucVu) fields[i].get(entity)).getMaChucVu());
                        break;
                    case "Ca":
                        pstm.setString(i, ((Ca) fields[i].get(entity)).getMaCa());
                        break;
                    case "TaiKhoan":
                        pstm.setString(i, ((TaiKhoan) fields[i].get(entity)).getTenTaiKhoan());
                        break;
                    case "UuDai":
                        pstm.setString(i, ((UuDai) fields[i].get(entity)).getMaUuDai());
                        break;
                    case "DichVu":
                        pstm.setString(i, ((DichVu) fields[i].get(entity)).getMaDichVu());
                        break;
                    case "HoaDon":
                        pstm.setString(i, ((HoaDon) fields[i].get(entity)).getMaHoaDon());
                        break;
                    case "int":
                        pstm.setInt(i, (int) fields[i].get(entity));
                        break;
                    case "double":
                        pstm.setDouble(i, (double) fields[i].get(entity));
                        break;
                    case "float":
                        pstm.setFloat(i, (float) fields[i].get(entity));
                        break;
                    case "long":
                        pstm.setLong(i, (long) fields[i].get(entity));
                        break;
                    case "boolean":
                        pstm.setBoolean(i, (boolean) fields[i].get(entity));
                        break;
                    case "LocalDate":
                        pstm.setDate(i, (Date.valueOf(fields[i].get(entity).toString())));
                        break;
                    case "LocalDateTime":
                        pstm.setString(i, JavaToSQL((LocalDateTime) fields[i].get(entity)));
                        break;
                    default:
                        pstm.setString(i, (String) fields[i].get(entity));
                        break;
                }
            }
            // Set giá trị cho cột đầu tiên
            fields[0].setAccessible(true);
            pstm.setString(fields.length, fields[0].get(entity).toString());
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               pstm.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;            
    }
    // Hàm search tất cả các cột và trả về danh sách các bản ghi
    // Dùng cho key release vì mấy sự kiện key kia phải nhấn space nó mới load table
    default ArrayList<T> search(String key, Class<T> c) {
        ArrayList<T> ds = new ArrayList<T>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        System.out.println(con);
        try {
            Field[] fields = c.getDeclaredFields();
            int so = -1;
            if (key.matches("^\\d+$"))
                so = Integer.parseInt(key);
            // Tạo câu truy vấn để lấy tất cả bản ghi trong bảng
            String sql = "SELECT * FROM " + c.getSimpleName() + " WHERE ";
            for (int i = 0; i < fields.length; i++) {
                // nếu tên cột là số thì dùng = thay vì like
                switch (fields[i].getType().getSimpleName()) {
                    case "trangThai", "soLuong", "gia", "datCoc", "giamGia", "gioiTinh":
                        sql += fields[i].getName() + " = "+ so + " OR ";
                        break;
                    default:
                        sql += fields[i].getName() + " LIKE N'%" + key + "%' OR ";
                        break;
                }
            }
            sql = sql.substring(0, sql.length() - 4); // loại bỏ " OR " ở cuối
//            System.out.println(sql);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                T entity = c.getDeclaredConstructor().newInstance(); // Tạo đối tượng mới
                for (Field field : fields) {
                    field.setAccessible(true);
                    switch (field.getType().getSimpleName()) {
                        case "Phong":
                            field.set(entity, findById(rs.getString("maPhong"), new Phong()));
                            break;
                        case "LoaiPhong":
                            field.set(entity, findById(rs.getString("maLoaiPhong"), new LoaiPhong()));
                            break;
                        case "KhachHang":
                            field.set(entity, findById(rs.getString("soDienThoai"), new KhachHang()));
                            break;
                        case "NhanVien":
                            field.set(entity, findById(rs.getString("maNhanVien"), new NhanVien()));
                            break;
                        case "ChucVu":
                            field.set(entity, findById(rs.getString("maChucVu"), new ChucVu()));
                            break;
                        case "Ca":
                            field.set(entity, findById(rs.getString("maCa"), new Ca()));
                            break;
                        case "TaiKhoan":
                            field.set(entity, findById(rs.getString("tenTaiKhoan"), new TaiKhoan()));
                            break;
                        case "UuDai":
                            field.set(entity, findById(rs.getString("maUuDai"), new UuDai()));
                            break;
                        case "DichVu":
                            field.set(entity, findById(rs.getString("maDichVu"), new DichVu()));
                            break;
                        case "HoaDon":
                            field.set(entity, findById(rs.getString("maHoaDon"), new HoaDon()));
                            break;
                        case "int":
                            field.set(entity, rs.getInt(field.getName()));
                            break;
                        case "double":
                            field.set(entity, rs.getDouble(field.getName()));
                            break;
                        case "float":
                            field.set(entity, rs.getFloat(field.getName()));
                            break;
                        case "long":
                            field.set(entity, rs.getLong(field.getName()));
                            break;
                        case "boolean":
                            field.set(entity, rs.getBoolean(field.getName()));
                            break;
                        case "LocalDate":
                            field.set(entity, LocalDate.parse(rs.getString(field.getName())));
                            break;
                        case "LocalDateTime":
                            field.set(entity, SQLtoJava(rs.getString(field.getName())));
                            break;
                        default:
                            // Nếu null thì giữ nguyên, không thì trim(). Vì null ko cho dùng trim()
                            if (rs.getString(field.getName()) == null) 
                                field.set(entity, rs.getString(field.getName()));
                            else
                                field.set(entity, rs.getString(field.getName()).trim());
                            break;
                    }
                }
                ds.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return ds;
    }
}
