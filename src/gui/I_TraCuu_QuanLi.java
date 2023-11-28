package gui;

import com.toedter.calendar.JDateChooser;
import dao.I_CRUD;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import entity.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public interface I_TraCuu_QuanLi<T> {
    DecimalFormat df = new DecimalFormat("#,###.###"); // Định dạng cho tiền tệ
    
    // Thường bên model, nhập liệu xử lí LocalDate dùng SimpleDateFormat. Còn LocalDateTime dùng DateTimeFormatter

    // Loadtbale cho tra cứu
    default void load(ArrayList<ArrayList<String>> ds, DefaultTableModel model) {
        model.setRowCount(0);
        ds.forEach(e -> {
            model.addRow(e.toArray());
        });
    }
    // Hàm search trên model
    // list là danh sách đầu tiên (chứa đầy đủ các dòng), mảng 2 chiều
    default ArrayList<ArrayList<String>> search(String text, ArrayList<ArrayList<String>> list) {
        // ds là danh sách chứa các dòng có trường khớp vs text
        ArrayList<ArrayList<String>> ds = new ArrayList<>();
        // duyệt qua các dòng của list
        for (int i = 0; i < list.size(); i++) {
            // duyệt qua các cột của list
            for (int j = 0; j < list.get(i).size(); j++) {
               
                if (list.get(i).get(j) == null) { // giá trị cell là null 
                    continue;
                } else {  // nếu tìm thấy text trong list thì thêm vào ds
                    if (list.get(i).get(j).toLowerCase().contains(text.toLowerCase())) {
                        // thêm dòng vào ds
                        ds.add(list.get(i));
                        break;
                    }
                }
            }
        }
        return ds;
    }
    
    // ds là danh sách cần load vào model
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
//                    if (i != 0) {
                        // nếu trường là có tên là Phòng, thì lấy ra tên của phòng
                        switch (fields[i].getType().getSimpleName()) {
                            case "Phong":
                                row[i] = ((Phong) fields[i].get(e)).getTenPhong();
                                break;
                            case "LoaiPhong":
                                row[i] = ((LoaiPhong) fields[i].get(e)).getTenLoaiPhong();
                                break;
                            case "KhachHang":
                                row[i] = ((KhachHang) fields[i].get(e)).getTenKhachHang();
                                break;
                            case "NhanVien":
                                if (fields[i].get(e) != null)
                                    row[i] = ((NhanVien) fields[i].get(e)).getTenNhanVien();
                                else 
                                    row[i] = "";
                                break;
//                            case "ChucVu":
//                                row[i] = ((ChucVu) fields[i].get(e)).getTenChucVu();
//                                break;
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
                                if (fields[i].get(e) != null)
                                    row[i] = ((UuDai) fields[i].get(e)).getTenUuDai();
                                else 
                                    row[i] = "";
                                break;
                            case "HoaDon":
                                row[i] = ((HoaDon) fields[i].get(e)).getMaHoaDon();
                                break;
                            case "boolean":
                                // Nếu tên biến là gioiTinh thì lấy ra giới tính, còn không thì lấy ra trạng thái
                                if (fields[i].getName().equals("gioiTinh")) {
                                    row[i] = fields[i].get(e).equals(true) ? "Nam" : "Nữ";
                                } else {
                                    row[i] = fields[i].get(e).equals(true) ? "Đang làm" : "Đã nghỉ";
                                }
                                break;
                            case "LocalDateTime":
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                row[i] = formatter.format((LocalDateTime) fields[i].get(e));
                                break;
                            case "double":
                                if (fields[i].getName().equals("gia") || fields[i].getName().equals("datCoc")) {
                                    row[i] = df.format((Double) fields[i].get(e)) + "Đ";
                                } else {
                                    row[i] = fields[i].get(e);
                                }
                                break;
                            case "int":
                                // nếu fields[i] là trạng thái
                                if (fields[i].getName().equals("trangThai")) {
                                    // kiểm tra xem nó là trạng thái của phòng hay hóa đơn hay Phiếu đặt phòng hay nhân viên hay dịch vụ
                                    if (e instanceof Phong) {
                                        switch ((int) fields[i].get(e)) {
                                            case 0:
                                                row[i] = "Trống";
                                                break;
                                            case 1:
                                                row[i] = "Đang chờ";
                                                break;
                                            case 2: 
                                                row[i] = "Đang sử dụng";
                                                break;
                                            case 3:
                                                row[i] = "Trục trặc";
                                                break;
                                            default:
                                                row[i] = "Không sử dụng";
                                                break;
                                        }
                                        break;
                                    } else if (e instanceof HoaDon) {
                                        row[i] = (int) fields[i].get(e) == 1 ? "Đã thanh toán" : "Chưa thanh toán";
                                        break;
                                    } else if (e instanceof PhieuDatPhong) {
                                        switch ((int) fields[i].get(e)) {
                                            case 0: 
                                                row[i] = "Đang chờ";
                                                break;
                                            case 1:
                                                row[i] = "Đã nhận";
                                                break;
                                            default:
                                                row[i] = "Đã huỷ";
                                                break;
                                        }
                                        break;
                                    } else if (e instanceof DichVu) {
                                        row[i] = (int) fields[i].get(e) == 1 ? "Còn hàng" : "Hết hàng";
                                        break;
                                    }
                                } else {
                                    row[i] = fields[i].get(e);
                                    break;
                                }
                            default:
                                row[i] = fields[i].get(e);
                                break;
                        }
//                    } else {
//                        row[i] = fields[i].get(e);
//                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            // thêm dữ liệu của đối tượng vào model
            model.addRow(row);
        });
    }
    default void setEnableInput(boolean b, JPanel pnlInput) { // cái này phải nhìn design mới hiểu được
        int i = 0; // để xử lí panel đầu
        // Trong pnlInput là các panel con chứa các control nhập liệu
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) { // bỏ cái này bị dính lỗi JSeparator
                Component c1 = ((JPanel) c).getComponent(1); // lấy component thứ 2 trong panel
                // nếu là panel con đầu tiên thì không cho chỉnh
                if (i++ == 0) {
                    ((JTextField) c1).setEditable(false); // id không cho chỉnh 
                    continue;
                }
                if (c1 instanceof JScrollPane) {  // xử lí Text Area
                    JViewport viewport = ((JScrollPane) c1).getViewport();
                    JTextArea tmp = (JTextArea) viewport.getView();
                    tmp.setEditable(b);
                } else if (c1 instanceof JTextField || c1 instanceof JPasswordField) { // xử lí Text fild vs password
                    ((JTextComponent) c1).setEditable(b);
            
                } else { // Còn lại là Combobox
                    c1.setEnabled(b); // cb không chỉnh edit dc phải enable
                }
            }
        }
    }
    
    // Tương tự enableInput trên
    default void clearInput(JPanel pnlInput) {
        int i = 0;
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) {
                if (i++ == 0) {
                    continue;
                }
                Component c1 = ((JPanel) c).getComponent(1); // lấy component thứ 2 của panel
                if (c1 instanceof JScrollPane) { 
                    JViewport viewport = ((JScrollPane) c1).getViewport();
                    JTextArea tmp = (JTextArea) viewport.getView();
                    tmp.setText("");
                } else if (c1 instanceof JTextField || c1 instanceof JPasswordField) {
                    ((JTextComponent) c1).setText("");
                } else if (c1 instanceof JDateChooser) {
                    ((JDateChooser) c1).setDate(null);
                } else if (c1 instanceof JComboBox) {
                    ((JComboBox) c1).setSelectedIndex(0);
                }
            }
        }
    }
    // Load từ model lên chỗ nhập liệu
    // index là số dòng
    default void showDetailInput(JPanel pnlInput, DefaultTableModel model, int index) {
        int i = 0; // i là chỉ mục của component bên detail
        for (Component c : pnlInput.getComponents()) {
            if (c instanceof JPanel) {
                Component c1 = ((JPanel) c).getComponent(1);
                if (c1 instanceof JScrollPane) { // Text Area
                    JViewport viewport = ((JScrollPane) c1).getViewport();
                    JTextArea tmp = (JTextArea) viewport.getView();
                    // Thường mấy cột dùng Text Area nó null
                    tmp.setText(model.getValueAt(index, i) == null ? "" :model.getValueAt(index, i++).toString());
                } else if (c1 instanceof JTextField) {
                    if (i < model.getColumnCount()) { // khắc phục lỗi indexOutOfBound của Array, để chặn lại xử lí trường nhập liệu nằm ngoài model như pw, vai trò của nhân viên
                        ((JTextComponent) c1).setText(model.getValueAt(index, i++).toString());
              
                    } else { // password nó ko có nằm bên model phải truy vấn bên SQL
                        ((JPasswordField) c1).setText(I_CRUD.findById(model.getValueAt(index, 6).toString(), new TaiKhoan()).getMatKhau());
                    }
                } else if (c1 instanceof JDateChooser) {
//                    if (i < model.getColumnCount()) {
                        java.util.Date date;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, i++).toString());
                            ((JDateChooser) c1).setDate(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(I_TraCuu_QuanLi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
//                    }
                } else if (c1 instanceof JComboBox) {
                    if (i < model.getColumnCount()) {
                        ((JComboBox) c1).setSelectedItem(model.getValueAt(index, i++));
                    } else { // Xử lí vai trò, nó ko nằm trong model, truy vấn SQL
                        Component c2 = ((JPanel) c).getComponent(0); 
                        if (((JLabel) c2).getText().equals("Vai trò:")){
                            ((JComboBox) c1).setSelectedItem(I_CRUD.findById(model.getValueAt(index, 6).toString(), new TaiKhoan()).getVaiTro() ? "Quản lí": "Nhân viên");
                            i++;
                        }
                    }
                }
//                } else if (c1 instanceof JPasswordField) { // chả hiểu sao jpasswordfield mà nó lại tính luôn là jtextfield
//                    // Dùng hàm finbyid lấy ra mật khẩu dựa vào số điện thoại
////                    if (i < model.getColumnCount()) {
//                        ((JPasswordField) c1).setText(I_CRUD.findById(model.getValueAt(index, 6).toString(), new TaiKhoan()).getMatKhau());
//                        System.out.println(2333);
////                    }
//                } 
//                else {
////                    i++;
////                }
            }
        }
    } 
    // Show Lỗi regex
    default void showRegexError(JTextComponent tf, String message) {
        tf.requestFocus();
        tf.setText("");
        JOptionPane.showMessageDialog(null, message,"Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    default void createID(JTextField tf, ArrayList<String> dsid, String prefix) {
        // Kiểm tra xem ds có rỗng hay không nếu rỗng thì mã là prefix + '001' không thì lấy mã cuối cùng trong ds + 1
        if (dsid.isEmpty()) {
            tf.setText(prefix + "001");
        } else {
            // lấy mã cuối cùng trong ds
            String lastID = dsid.get(dsid.size() - 1);
            // tách chuỗi để lấy số thứ tự. Tách prefix
            int index = Integer.parseInt(lastID.substring(prefix.length())) + 1;
            // tạo mã mới
            String newID = prefix + String.format("%03d", index); // 0: thêm số 0 bên lề trái nếu ko đủ 3 chữ số. d là định dạng số nguyên
            tf.setText(newID); 
        }
    }

    /**
     *
     * @param dsid là danh sách các id 
     * @param prefix như HDddMMyyyy001 thì prefix là HD. 
     */
    public static String createIdForHoaDon_PDP(ArrayList<String> dsidTheoNgay, String prefix) {
        // Kiểm tra xem ds có rỗng hay không nếu rỗng thì mã là prefix + ngày hiện tại + '001' không thì lấy mã cuối cùng trong ds + 1
        if (dsidTheoNgay.isEmpty()) {
            prefix += LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
            prefix += "001";
        } else {
            // lấy mã cuối cùng trong ds
            String lastID = dsidTheoNgay.get(dsidTheoNgay.size() - 1);
            // tách chuỗi để lấy số thứ tự
            int index = Integer.parseInt(lastID.substring(prefix.length() + 8)) + 1;
            // tạo mã mới
            prefix += LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
            prefix += String.format("%03d", index);
        }
        return prefix;
    }
}
