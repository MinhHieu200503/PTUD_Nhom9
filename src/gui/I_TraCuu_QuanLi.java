package gui;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import entity.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public interface I_TraCuu_QuanLi<T> {

    // viết hàm loadData() để add dữ liệu vào bảng từ model
    default void loadTable(ArrayList<T> ds, DefaultTableModel model) {
        model.setRowCount(0);
        ds.forEach(e -> {
            // lấy ra các trường của đối tượng
            Field[] fields = e.getClass().getDeclaredFields();
            // tạo mảng để chứa dữ liệu của đối tượng
            Object[] row = new Object[fields.length];
            // duyệt qua các trường của đối tượng
            for (int i = 0; i < fields.length; i++) {
                // cho phép truy cập vào các trường private
                fields[i].setAccessible(true);
                try {
                    if (i != 0) {
                        // nếu trường là có tên là Phòng, thì lấy ra tên của phòng
                        switch (fields[i].getType().getSimpleName()) {
                            case "Phong":
                                row[i] = ((Phong) fields[i].get(e)).getTenPhong();
                                break;
                            case "LoaiPhong":
                                row[i] = ((LoaiPhong) fields[i].get(e)).getLoaiPhong();
                                break;
                            case "KhachHang":
                                row[i] = ((KhachHang) fields[i].get(e)).getTenKhachHang();
                                break;
                            case "NhanVien":
                                row[i] = ((NhanVien) fields[i].get(e)).getTenNhanVien();
                                break;
                            case "ChucVu":
                                row[i] = ((ChucVu) fields[i].get(e)).getTenChucVu();
                                break;
                            case "Ca":
                                row[i] = ((Ca) fields[i].get(e)).getTenCa();
                                break;
                            case "TaiKhoan":
                                row[i] = ((TaiKhoan) fields[i].get(e)).getTenTaiKhoan();
                                break;
                            case "DichVu":
                                row[i] = ((DichVu) fields[i].get(e)).getTenDichVu();
                                break;
                            case "UuDai":
                                row[i] = ((UuDai) fields[i].get(e)).getTenUuDai();
                                break;
                            case "HoaDon":
                                row[i] = ((HoaDon) fields[i].get(e)).getMaHoaDon();
                                break;
                            case "vaiTro":
                                // nếu vai trò là 1 thì quản lí, 0 thì nhân viên
                                row[i] = ((TaiKhoan) fields[i].get(e)).getVaiTro() == true ? "Quản lí" : "Nhân viên";
                                break;
                            case "trangThai":
                                // kiểm tra xem nó là trạng thái của phòng hay hóa đơn hay Phiếu đặt phòng hay nhân viên hay dịch vụ
                                if (e instanceof Phong) {
                                    switch (((Phong) fields[i].get(e)).getTrangThai()) {
                                        case 0:
                                            row[i] = "Trống";
                                            break;
                                        case 1:
                                            row[i] = "Đang hoạt động";
                                            break;
                                        case 2: 
                                            row[i] = "Chưa sẵn sàng";
                                            break;
                                        case 3:
                                            row[i] = "Đang chờ";
                                            break;
                                        default:
                                            row[i] = "Không sử dụng";
                                            break;
                                    }
                                } else if (e instanceof HoaDon) {
                                    row[i] = ((HoaDon) fields[i].get(e)).getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán";
                                } else if (e instanceof PhieuDatPhong) {
                                    switch (((PhieuDatPhong) fields[i].get(e)).getTrangThai()) {
                                        case 0: 
                                            row[i] = "Đã huỷ";
                                            break;
                                        case 1:
                                            row[i] = "Đã nhận";
                                            break;
                                        default:
                                            row[i] = "Đang chờ";
                                            break;
                                    }
                                } else if (e instanceof NhanVien) {
                                    row[i] = ((NhanVien) fields[i].get(e)).getTrangThai() == true ? "Đang làm" : "Đã nghỉ";
                                } else if (e instanceof DichVu) {
                                    row[i] = ((DichVu) fields[i].get(e)).getTrangThai() == 1 ? "Còn hàng" : "Hết hàng";
                                }
                            default:
                                row[i] = fields[i].get(e);
                                break;
                        }
                    } else {
                        row[i] = fields[i].get(e);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            // thêm dữ liệu của đối tượng vào model
            model.addRow(row);
        });
    }
    default void setEnableInput(boolean b, JPanel pnlInput) {
        // Trong pnlInput là các panel con chứa các control nhập liệu
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) { // bỏ cái này bị dính lỗi JSeparator
                Component c1 = ((JPanel) c).getComponent(1);
                if (c1 instanceof JTextField || c1 instanceof JTextArea || c1 instanceof JPasswordField) {
                    ((JTextComponent) c1).setEditable(b);
                } else {
                    c1.setEnabled(b);
                }
            }
        }
    }
    default void clearInput(JPanel pnlInput) {
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) {
                Component c1 = ((JPanel) c).getComponent(1); // lấy component thứ 2 của panel
                if (c1 instanceof JTextField || c1 instanceof JTextArea || c1 instanceof JPasswordField) {
                    ((JTextComponent) c1).setText("");
                } else if (c1 instanceof JDateChooser) {
                    ((JDateChooser) c1).setDate(null);
                } else if (c1 instanceof JComboBox) {
                    ((JComboBox) c1).setSelectedIndex(0);
                }
            }
        }
    }
    default void showDetailInput(JPanel pnlInput, DefaultTableModel model, int index) {
        int i = 0;
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) {
                Component c1 = ((JPanel) c).getComponent(1);
                if (c1 instanceof JTextField || c1 instanceof JTextArea) {
                    ((JTextComponent) c1).setText(model.getValueAt(index, i++).toString());
                } else if (c1 instanceof JDateChooser) {
                    java.util.Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, i++).toString());
                        ((JDateChooser) c1).setDate(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(I_TraCuu_QuanLi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (c1 instanceof JComboBox) {
                    ((JComboBox) c1).setSelectedItem(model.getValueAt(index, i++).toString());
                } else {
                    continue;
                }
            }
        }
    } 
}
