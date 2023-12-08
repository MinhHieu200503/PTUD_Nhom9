package gui;


import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entity.ChiTietPhongHoaDon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import static java.lang.Math.abs;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class GD_Thongke extends javax.swing.JFrame {
    DecimalFormat formatter = new DecimalFormat("###,###,### Đ");
    boolean buildComponent = false;
    /**
     * Creates new form GD
     */
    public GD_Thongke() {
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 10 );
        UIManager.put( "Component.arc", 10 );
        UIManager.put( "ProgressBar.arc", 10 );
        UIManager.put( "TextComponent.arc", 10 );
        initComponents();
        this.setBackground(Color.white);
        load_comboBox();
        load_TongDoanhThu();
        load_SoSanh();
        load_comboBox_DoanhThuThang();
        
        load_comboBox_DoanhThuThang();
        load_ThongKeThang();
        buildComponent = true;
    }
    
    public void load_comboBox(){
        comboBoxDoanhThu.removeAllItems();
        comboBoxSoSanh.removeAllItems();
        dao.DAO_HoaDon dao_HoaDon = new dao.DAO_HoaDon();
        ArrayList<String> doanhThuTheoNam = dao_HoaDon.tongDoanhThu_NamDoanhThu_ComboBox();
        boolean skip = false;
        for (String string : doanhThuTheoNam) {
            comboBoxDoanhThu.addItem(string);
            if (skip == true){
                comboBoxSoSanh.addItem(string);
            }
            skip = true;
        }
    }
    
    public void load_TongDoanhThu(){
        chart.removeAll();
        dao.DAO_HoaDon dao_HoaDon = new dao.DAO_HoaDon();
        
        textTongSoHoaDon.setText(String.valueOf(dao_HoaDon.tongDoanhThu_TongSoHoaDon(String.valueOf(comboBoxDoanhThu.getSelectedItem()))));
        textTongSoDichVu.setText(String.valueOf(dao_HoaDon.tongDoanhThu_TongSoDichVu(String.valueOf(comboBoxDoanhThu.getSelectedItem()))));
        
        double[] tongTienPhongVaDichVu = dao_HoaDon.tongDoanhThu_PhongVaDichVu(String.valueOf(comboBoxDoanhThu.getSelectedItem()), "");
        
        textTongDoanhThuDichVu.setText(formatter.format(tongTienPhongVaDichVu[1]));
        textTongDoanhThuPhong.setText(formatter.format(tongTienPhongVaDichVu[0]));
        textTongDoanhThuPhong2.setText(formatter.format(tongTienPhongVaDichVu[0] + tongTienPhongVaDichVu[1]));
        
        ArrayList<String[]> phongSuDungNhieuNhat = dao_HoaDon.tongDoanhThu_PhongSuDungNhieuNhat(String.valueOf(comboBoxDoanhThu.getSelectedItem()));
        ArrayList<String[]> dichVuSuDungNhieuNhat = dao_HoaDon.tongDoanhThu_DichVuSuDungNhieuNhat(String.valueOf(comboBoxDoanhThu.getSelectedItem()));
        
        DefaultTableModel model = (DefaultTableModel) rSTableMetro1.getModel();
        model.setRowCount(0);
        for (String[] strings : phongSuDungNhieuNhat) {
            model.addRow(new String[] {strings[0], strings[1]});
        }
        
        model = (DefaultTableModel) rSTableMetro2.getModel();
        model.setRowCount(0);
        for (String[] strings : dichVuSuDungNhieuNhat) {
            model.addRow(new String[] {strings[0], strings[1]});
        }
        
        ArrayList<Double> chart_tongDoanhThu = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            double[] temp = dao_HoaDon.tongDoanhThu_PhongVaDichVu(String.valueOf(comboBoxDoanhThu.getSelectedItem()), String.valueOf(i));
            chart_tongDoanhThu.add(temp[0] + temp[1]);
        }
        display(chart_tongDoanhThu);
        load_SoSanh();
    }
    
    public void load_SoSanh(){
        panel_Chart_SoSanh.removeAll();
        dao.DAO_HoaDon dao_HoaDon = new dao.DAO_HoaDon();
        double[] tongTienPhongVaDichVu = dao_HoaDon.tongDoanhThu_PhongVaDichVu(String.valueOf(comboBoxDoanhThu.getSelectedItem()), "");
        double[] tongTienPhongVaDichVuSoSanh = dao_HoaDon.tongDoanhThu_PhongVaDichVu(String.valueOf(comboBoxSoSanh.getSelectedItem()), "");
        panel_Chart_SoSanh.add(createDataset(tongTienPhongVaDichVuSoSanh, tongTienPhongVaDichVu), BorderLayout.CENTER);
        
        jLabel1.setText(String.valueOf(comboBoxSoSanh.getSelectedItem()) + " <-> " + String.valueOf(comboBoxDoanhThu.getSelectedItem()));
        
        double[] phanTram = {tongTienPhongVaDichVu[0] + tongTienPhongVaDichVuSoSanh[0], tongTienPhongVaDichVu[1] + tongTienPhongVaDichVuSoSanh[1]};
        
        double[] tongTienCua1Nam = {tongTienPhongVaDichVu[0] + tongTienPhongVaDichVu[1], tongTienPhongVaDichVuSoSanh[0] + tongTienPhongVaDichVuSoSanh[1]};
        
        if (tongTienPhongVaDichVuSoSanh[0] < tongTienPhongVaDichVu[0]){
            iconDoanhThuSoSanhPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-up-20.png"))); // NOI18N
        }else if (tongTienPhongVaDichVuSoSanh[0] > tongTienPhongVaDichVu[0]){
            iconDoanhThuSoSanhPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        }else{
            iconDoanhThuSoSanhPhong.setIcon(null); // NOI18N
        }
        
        if (tongTienPhongVaDichVuSoSanh[1] < tongTienPhongVaDichVu[1]){
            iconDoanhThuSoSanhPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-up-20.png"))); // NOI18N
        }else if (tongTienPhongVaDichVuSoSanh[1] > tongTienPhongVaDichVu[1]){
            iconDoanhThuSoSanhPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        }else{
            iconDoanhThuSoSanhPhong2.setIcon(null); // NOI18N
        }
        
        if (tongTienCua1Nam[1] < tongTienCua1Nam[0]){
            iconDoanhThuSoSanhPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-up-20.png"))); // NOI18N
        }else if (tongTienCua1Nam[1] > tongTienCua1Nam[0]){
            iconDoanhThuSoSanhPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        }else{
            iconDoanhThuSoSanhPhong3.setIcon(null); // NOI18N
        }
        
        double[] resultPhanTram = {0,0,0};
        double tong = tongTienCua1Nam[0] + tongTienCua1Nam[1];

        resultPhanTram[0] = ((tongTienPhongVaDichVuSoSanh[0] - tongTienPhongVaDichVu[0]) / phanTram[0]) * 100;
        resultPhanTram[1] = ((tongTienPhongVaDichVuSoSanh[1] - tongTienPhongVaDichVu[1]) / phanTram[1]) * 100;
        resultPhanTram[2] = ((tongTienCua1Nam[1] - tongTienCua1Nam[0]) / tong) * 100;
        
        if (Double.isNaN(resultPhanTram[0])){
            resultPhanTram[0] = 0.0;
        }
        
        if (Double.isNaN(resultPhanTram[1])){
            resultPhanTram[1] = 0.0;
        }
        
        if (Double.isNaN(resultPhanTram[2])){
            resultPhanTram[2] = 0.0;
        }
        
        textDoanhThuSoSanhPhong.setText(String.format("%.3f", abs(resultPhanTram[0])) + " %");
        textDoanhThuSoSanhPhong2.setText(String.format("%.3f", abs(resultPhanTram[1])) + " %");
        textDoanhThuSoSanhPhong3.setText(String.format("%.3f", abs(resultPhanTram[2])) + " %");
        
        
    }
    
    public void load_comboBox_DoanhThuThang(){
        comboBoxDoanhThu1.removeAllItems();
        comboBoxSoSanh1.removeAllItems();
        dao.DAO_HoaDon dao_HoaDon = new dao.DAO_HoaDon();
        ArrayList<String> doanhThuTheoThang = dao_HoaDon.DoanhThuThang_ComboBox();
        boolean skip = false;
        for (String string : doanhThuTheoThang) {
            comboBoxDoanhThu1.addItem(string);
            if (skip == true){
                comboBoxSoSanh1.addItem(string);
            }
            skip = true;
        }
    }
    
    public void load_ThongKeThang(){
        dao.DAO_HoaDon hoaDon = new dao.DAO_HoaDon();
        textTongSoHoaDon1.setText(String.valueOf(        hoaDon.doanhThuThang_TongSoHoaDon(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()))));
        
        textTongSoDichVu1.setText(String.valueOf(        hoaDon.doanhThuThang_TongSoDichVu(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()))));
        
       double[] tongTienPhongVaDichVu = hoaDon.tongDoanhThu_PhongVaDichVu(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));

       textTongDoanhThuPhong1.setText(formatter.format(tongTienPhongVaDichVu[0]));
       textTongDoanhThuDichVu1.setText(formatter.format(tongTienPhongVaDichVu[1]));
       textTongDoanhThuPhong3.setText(formatter.format(tongTienPhongVaDichVu[0]+ tongTienPhongVaDichVu[1]));
       
       ArrayList<String[]> phongSuDungNhieuNhat = hoaDon.doanhThuThang_PhongSuDungNhieuNhat(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));
       
       ArrayList<String[]> dichVuSuDungNhieuNhat = hoaDon.doanhThuThang_DichVuSuDungNhieuNhat(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));
    
       DefaultTableModel model = (DefaultTableModel) rSTableMetro3.getModel();
       model.setRowCount(0);
       for (String[] strings : phongSuDungNhieuNhat) {
           model.addRow(new String[] {strings[0], strings[1]});
       }
       
       model = (DefaultTableModel) rSTableMetro4.getModel();
       model.setRowCount(0);
       for (String[] strings : dichVuSuDungNhieuNhat) {
           model.addRow(new String[] {strings[0], strings[1]});
       }
       
        ArrayList<Integer> trungBinhDichVu = hoaDon.doanhThuThang_DichVuTheoNgay(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));
        
        int avg_DichVu = 0;
        for (Integer integer : trungBinhDichVu) {
            avg_DichVu += integer;
        }
        avg_DichVu = avg_DichVu/trungBinhDichVu.size();
        jLabel34.setText(String.valueOf(avg_DichVu) + " Lần/Ngày");
        
        ArrayList<Integer> trungBinhKhachHang = hoaDon.doanhThuThang_TrungBinhKhachHang(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));
        
        double avg_khachHang = 0;
        for (Integer integer : trungBinhKhachHang) {
            avg_khachHang += integer;
        }
        
        avg_khachHang = avg_khachHang/trungBinhKhachHang.size();
        jLabel26.setText(String.format("%.3f",avg_khachHang) + " Người/Ngày");
        
        ArrayList<entity.ChiTietPhongHoaDon> avg_thoiGianSuDung = hoaDon.doanhThuThang_TrungBinhSuDungPhong(String.valueOf(
                checkMonth(String.valueOf(comboBoxDoanhThu1.getSelectedItem()))), String.valueOf(comboBoxDoanhThu1.getSelectedItem()));
        
        double avg_trungBinhKhachHang = 0;
        for (ChiTietPhongHoaDon chiTietPhongHoaDon : avg_thoiGianSuDung) {
            Duration timeResult = Duration.between(chiTietPhongHoaDon.getThoiGianTraPhong(), chiTietPhongHoaDon.getThoiGianNhanPhong());
            long minutes = Math.abs(timeResult.toMinutes());
            avg_trungBinhKhachHang += minutes;
        }
        avg_trungBinhKhachHang = avg_trungBinhKhachHang/trungBinhKhachHang.size();
        jLabel28.setText(String.format("%.3f",avg_trungBinhKhachHang) + " Giờ/Phòng");
        
        String[] xuHuong;

        if (phongSuDungNhieuNhat.isEmpty()){
            xuHuong = new String[]{"...", "..."};
        }else{
            xuHuong = new String[]{phongSuDungNhieuNhat.getFirst()[3], phongSuDungNhieuNhat.getFirst()[2]};
        }
        
        
        jLabel31.setText("- Xu hướng khách hàng chọn phòng có sức chứa tối đa " + xuHuong[0] + " người là nhiều nhất");
        jLabel33.setText("- Xu hướng khách hàng hay chọn phòng " + xuHuong[1] +" là nhiều nhất");
        
        double tiLePhongVip = 0.0;
        for (String[] strings : phongSuDungNhieuNhat) {
            if (strings[4].contains("Vip")){
                tiLePhongVip++;
            }
        }
        
        tiLePhongVip = tiLePhongVip/ phongSuDungNhieuNhat.size();
        jLabel35.setText("- Tỉ lệ khách hàng chọn phòng VIP là " + String.format("%.1f", tiLePhongVip) + " %");
    }
    
    public int checkMonth(String input){
        if (Integer.valueOf(input) > LocalDateTime.now().getMonthValue()){
            return LocalDateTime.now().getYear()-1;
        }
        return LocalDateTime.now().getYear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab_TongDoanhThu = new javax.swing.JPanel();
        panel_TongDoanhThu = new javax.swing.JPanel();
        tongDoanhThu = new javax.swing.JLabel();
        line1 = new javax.swing.JPanel();
        line2 = new javax.swing.JPanel();
        doanhThuTheoNam = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxDoanhThu = new javax.swing.JComboBox<>();
        tongDoanhThuPhong = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textTongDoanhThuPhong = new javax.swing.JLabel();
        tongDoanhThuDichVu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        textTongDoanhThuDichVu = new javax.swing.JLabel();
        tongSoHoaDon = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textTongSoHoaDon = new javax.swing.JLabel();
        tongSoDichVu = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        textTongSoDichVu = new javax.swing.JLabel();
        tongDoanhThuPhong2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        textTongDoanhThuPhong2 = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        panel_SoSanh = new javax.swing.JPanel();
        tongDoanhThu1 = new javax.swing.JLabel();
        panel_soSanhDoanhThuTheoNam = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxSoSanh = new javax.swing.JComboBox<>();
        line3 = new javax.swing.JPanel();
        panel_Chart_SoSanh = new javax.swing.JPanel();
        line4 = new javax.swing.JPanel();
        soSanh = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong2 = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong2 = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong3 = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        jLabel6 = new javax.swing.JLabel();
        tab_ThongKeDoanhThuThang = new javax.swing.JPanel();
        panel_TongDoanhThu1 = new javax.swing.JPanel();
        tongDoanhThu2 = new javax.swing.JLabel();
        line5 = new javax.swing.JPanel();
        line6 = new javax.swing.JPanel();
        doanhThuTheoNam1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxDoanhThu1 = new javax.swing.JComboBox<>();
        tongDoanhThuPhong1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textTongDoanhThuPhong1 = new javax.swing.JLabel();
        tongDoanhThuDichVu1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        textTongDoanhThuDichVu1 = new javax.swing.JLabel();
        tongSoHoaDon1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        textTongSoHoaDon1 = new javax.swing.JLabel();
        tongSoDichVu1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        textTongSoDichVu1 = new javax.swing.JLabel();
        tongDoanhThuPhong3 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        textTongDoanhThuPhong3 = new javax.swing.JLabel();
        chart1 = new javax.swing.JPanel();
        panel_SoSanh1 = new javax.swing.JPanel();
        tongDoanhThu3 = new javax.swing.JLabel();
        panel_soSanhDoanhThuTheoNam1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        comboBoxSoSanh1 = new javax.swing.JComboBox<>();
        line7 = new javax.swing.JPanel();
        panel_Chart_SoSanh1 = new javax.swing.JPanel();
        line8 = new javax.swing.JPanel();
        soSanh1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong1 = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong1 = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong4 = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong4 = new javax.swing.JLabel();
        panel_doanhThuSoSanhPhong5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        textDoanhThuSoSanhPhong5 = new javax.swing.JLabel();
        iconDoanhThuSoSanhPhong5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rSTableMetro3 = new rojeru_san.complementos.RSTableMetro();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rSTableMetro4 = new rojeru_san.complementos.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1920, 964));

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N

        panel_TongDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        panel_TongDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_TongDoanhThu.setMaximumSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu.setMinimumSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu.setName(""); // NOI18N
        panel_TongDoanhThu.setPreferredSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu.setLayout(new java.awt.GridBagLayout());

        tongDoanhThu.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        tongDoanhThu.setText("TỔNG DOANH THU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        panel_TongDoanhThu.add(tongDoanhThu, gridBagConstraints);

        line1.setBackground(new java.awt.Color(102, 102, 102));
        line1.setMaximumSize(new java.awt.Dimension(462, 2));
        line1.setMinimumSize(new java.awt.Dimension(462, 2));
        line1.setPreferredSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line1Layout = new javax.swing.GroupLayout(line1);
        line1.setLayout(line1Layout);
        line1Layout.setHorizontalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        line1Layout.setVerticalGroup(
            line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        panel_TongDoanhThu.add(line1, gridBagConstraints);

        line2.setBackground(new java.awt.Color(102, 102, 102));
        line2.setMaximumSize(new java.awt.Dimension(462, 2));
        line2.setMinimumSize(new java.awt.Dimension(462, 2));
        line2.setPreferredSize(new java.awt.Dimension(462, 2));
        line2.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout line2Layout = new javax.swing.GroupLayout(line2);
        line2.setLayout(line2Layout);
        line2Layout.setHorizontalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        line2Layout.setVerticalGroup(
            line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu.add(line2, gridBagConstraints);

        doanhThuTheoNam.setBackground(new java.awt.Color(255, 255, 255));
        doanhThuTheoNam.setMaximumSize(new java.awt.Dimension(418, 53));
        doanhThuTheoNam.setMinimumSize(new java.awt.Dimension(418, 53));
        doanhThuTheoNam.setLayout(new javax.swing.BoxLayout(doanhThuTheoNam, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setText("Doanh thu theo năm:");
        jLabel2.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel2.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 30));
        doanhThuTheoNam.add(jLabel2);

        comboBoxDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxDoanhThu.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxDoanhThu.setMinimumSize(new java.awt.Dimension(200, 30));
        comboBoxDoanhThu.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxDoanhThu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                doanhThuTheoNamChange(evt);
            }
        });
        doanhThuTheoNam.add(comboBoxDoanhThu);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu.add(doanhThuTheoNam, gridBagConstraints);

        tongDoanhThuPhong.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuPhong.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong.setPreferredSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Tổng doanh thu dịch vụ:");
        jLabel3.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel3.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel3.setPreferredSize(new java.awt.Dimension(250, 30));
        tongDoanhThuPhong.add(jLabel3, java.awt.BorderLayout.WEST);

        textTongDoanhThuPhong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuPhong.setText("150.000.000.000Đ");
        textTongDoanhThuPhong.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuPhong.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuPhong.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuPhong.add(textTongDoanhThuPhong, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu.add(tongDoanhThuPhong, gridBagConstraints);

        tongDoanhThuDichVu.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuDichVu.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuDichVu.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuDichVu.setPreferredSize(new java.awt.Dimension(418, 53));
        tongDoanhThuDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel9.setText("Tổng doanh thu phòng:");
        jLabel9.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel9.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel9.setPreferredSize(new java.awt.Dimension(220, 30));
        tongDoanhThuDichVu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 53));

        textTongDoanhThuDichVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuDichVu.setText("150.000.000.000Đ");
        textTongDoanhThuDichVu.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuDichVu.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuDichVu.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuDichVu.add(textTongDoanhThuDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 0, -1, 53));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        panel_TongDoanhThu.add(tongDoanhThuDichVu, gridBagConstraints);

        tongSoHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        tongSoHoaDon.setMaximumSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon.setMinimumSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon.setPreferredSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setText("Tổng số hóa đơn:");
        jLabel10.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel10.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel10.setPreferredSize(new java.awt.Dimension(220, 30));
        tongSoHoaDon.add(jLabel10, java.awt.BorderLayout.WEST);

        textTongSoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongSoHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongSoHoaDon.setText("30");
        textTongSoHoaDon.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongSoHoaDon.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongSoHoaDon.setPreferredSize(new java.awt.Dimension(190, 30));
        tongSoHoaDon.add(textTongSoHoaDon, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu.add(tongSoHoaDon, gridBagConstraints);

        tongSoDichVu.setBackground(new java.awt.Color(255, 255, 255));
        tongSoDichVu.setMaximumSize(new java.awt.Dimension(418, 53));
        tongSoDichVu.setMinimumSize(new java.awt.Dimension(418, 53));
        tongSoDichVu.setPreferredSize(new java.awt.Dimension(418, 53));
        tongSoDichVu.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel11.setText("Tổng số dịch vụ:");
        jLabel11.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel11.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel11.setPreferredSize(new java.awt.Dimension(220, 30));
        tongSoDichVu.add(jLabel11, java.awt.BorderLayout.WEST);

        textTongSoDichVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongSoDichVu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongSoDichVu.setText("15");
        textTongSoDichVu.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongSoDichVu.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongSoDichVu.setPreferredSize(new java.awt.Dimension(190, 30));
        tongSoDichVu.add(textTongSoDichVu, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 23, 0);
        panel_TongDoanhThu.add(tongSoDichVu, gridBagConstraints);

        tongDoanhThuPhong2.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuPhong2.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong2.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong2.setPreferredSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong2.setLayout(new java.awt.BorderLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel38.setText("Tổng doanh thu:");
        jLabel38.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel38.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel38.setPreferredSize(new java.awt.Dimension(250, 30));
        tongDoanhThuPhong2.add(jLabel38, java.awt.BorderLayout.WEST);

        textTongDoanhThuPhong2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuPhong2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuPhong2.setText("150.000.000.000Đ");
        textTongDoanhThuPhong2.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuPhong2.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuPhong2.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuPhong2.add(textTongDoanhThuPhong2, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu.add(tongDoanhThuPhong2, gridBagConstraints);

        chart.setBackground(new java.awt.Color(255, 255, 255));
        chart.setMaximumSize(new java.awt.Dimension(1427, 440));
        chart.setMinimumSize(new java.awt.Dimension(0, 0));
        chart.setPreferredSize(new java.awt.Dimension(0, 0));
        chart.setLayout(new java.awt.BorderLayout());

        panel_SoSanh.setBackground(new java.awt.Color(255, 255, 255));
        panel_SoSanh.setMaximumSize(new java.awt.Dimension(475, 506));
        panel_SoSanh.setMinimumSize(new java.awt.Dimension(475, 506));

        tongDoanhThu1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        tongDoanhThu1.setText("SO SÁNH");

        panel_soSanhDoanhThuTheoNam.setBackground(new java.awt.Color(255, 255, 255));
        panel_soSanhDoanhThuTheoNam.setMaximumSize(new java.awt.Dimension(418, 53));
        panel_soSanhDoanhThuTheoNam.setMinimumSize(new java.awt.Dimension(418, 53));
        panel_soSanhDoanhThuTheoNam.setLayout(new javax.swing.BoxLayout(panel_soSanhDoanhThuTheoNam, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setText("Doanh thu theo năm:");
        jLabel4.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel4.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_soSanhDoanhThuTheoNam.add(jLabel4);

        comboBoxSoSanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxSoSanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSoSanh.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxSoSanh.setMinimumSize(new java.awt.Dimension(200, 30));
        comboBoxSoSanh.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxSoSanh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                soSanhChange(evt);
            }
        });
        panel_soSanhDoanhThuTheoNam.add(comboBoxSoSanh);

        line3.setBackground(new java.awt.Color(102, 102, 102));
        line3.setMaximumSize(new java.awt.Dimension(462, 2));
        line3.setMinimumSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line3Layout = new javax.swing.GroupLayout(line3);
        line3.setLayout(line3Layout);
        line3Layout.setHorizontalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        line3Layout.setVerticalGroup(
            line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_Chart_SoSanh.setLayout(new java.awt.BorderLayout());

        line4.setBackground(new java.awt.Color(102, 102, 102));
        line4.setMaximumSize(new java.awt.Dimension(462, 2));
        line4.setMinimumSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line4Layout = new javax.swing.GroupLayout(line4);
        line4.setLayout(line4Layout);
        line4Layout.setHorizontalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line4Layout.setVerticalGroup(
            line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        soSanh.setBackground(new java.awt.Color(255, 255, 255));
        soSanh.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("2023<-> 2024");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        soSanh.add(jLabel1, gridBagConstraints);

        panel_doanhThuSoSanhPhong.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel12.setText("Doanh thu Phòng:");
        jLabel12.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel12.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel12.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong.add(jLabel12, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong.setText("20%");
        textDoanhThuSoSanhPhong.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong.add(textDoanhThuSoSanhPhong, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-up-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong.add(iconDoanhThuSoSanhPhong, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh.add(panel_doanhThuSoSanhPhong, gridBagConstraints);

        panel_doanhThuSoSanhPhong2.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong2.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong2.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong2.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong2.setLayout(new java.awt.GridBagLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel13.setText("Doanh thu Dịch Vụ:");
        jLabel13.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel13.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel13.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong2.add(jLabel13, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong2.setText("15%");
        textDoanhThuSoSanhPhong2.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong2.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong2.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong2.add(textDoanhThuSoSanhPhong2, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong2.add(iconDoanhThuSoSanhPhong2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh.add(panel_doanhThuSoSanhPhong2, gridBagConstraints);

        panel_doanhThuSoSanhPhong3.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong3.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong3.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong3.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong3.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setText("Tổng doanh thu");
        jLabel14.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel14.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel14.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong3.add(jLabel14, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong3.setText("22%");
        textDoanhThuSoSanhPhong3.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong3.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong3.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong3.add(textDoanhThuSoSanhPhong3, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-horizontal-line-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong3.add(iconDoanhThuSoSanhPhong3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh.add(panel_doanhThuSoSanhPhong3, gridBagConstraints);

        javax.swing.GroupLayout panel_SoSanhLayout = new javax.swing.GroupLayout(panel_SoSanh);
        panel_SoSanh.setLayout(panel_SoSanhLayout);
        panel_SoSanhLayout.setHorizontalGroup(
            panel_SoSanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                .addGroup(panel_SoSanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_SoSanhLayout.createSequentialGroup()
                        .addGroup(panel_SoSanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(tongDoanhThu1))
                            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(line3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(panel_soSanhDoanhThuTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_Chart_SoSanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_SoSanhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_SoSanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soSanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel_SoSanhLayout.setVerticalGroup(
            panel_SoSanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SoSanhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tongDoanhThu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_soSanhDoanhThuTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Chart_SoSanh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soSanh, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(670, 509));
        jPanel4.setMinimumSize(new java.awt.Dimension(670, 509));
        jPanel4.setPreferredSize(new java.awt.Dimension(670, 509));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setText("Phòng Sử Dụng Nhiều Nhất");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Phòng", "Số lần"
            }
        ));
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(1000);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 700, 410));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(670, 509));
        jPanel5.setMinimumSize(new java.awt.Dimension(670, 509));

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dịch Vụ", "Số lần"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setRowHeight(40);
        jScrollPane2.setViewportView(rSTableMetro2);
        if (rSTableMetro2.getColumnModel().getColumnCount() > 0) {
            rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(1000);
            rSTableMetro2.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setText("Dịch Vụ Sử Dụng Nhiều Nhất");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel6)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tab_TongDoanhThuLayout = new javax.swing.GroupLayout(tab_TongDoanhThu);
        tab_TongDoanhThu.setLayout(tab_TongDoanhThuLayout);
        tab_TongDoanhThuLayout.setHorizontalGroup(
            tab_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_TongDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_TongDoanhThuLayout.createSequentialGroup()
                        .addComponent(panel_TongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 1427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab_TongDoanhThuLayout.createSequentialGroup()
                        .addComponent(panel_SoSanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab_TongDoanhThuLayout.setVerticalGroup(
            tab_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_TongDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_TongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(tab_TongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_SoSanh, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tổng Doanh Thu ", tab_TongDoanhThu);

        panel_TongDoanhThu1.setBackground(new java.awt.Color(255, 255, 255));
        panel_TongDoanhThu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_TongDoanhThu1.setMaximumSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu1.setMinimumSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu1.setName(""); // NOI18N
        panel_TongDoanhThu1.setPreferredSize(new java.awt.Dimension(475, 440));
        panel_TongDoanhThu1.setLayout(new java.awt.GridBagLayout());

        tongDoanhThu2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        tongDoanhThu2.setText("DOANH THU THÁNG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        panel_TongDoanhThu1.add(tongDoanhThu2, gridBagConstraints);

        line5.setBackground(new java.awt.Color(102, 102, 102));
        line5.setMaximumSize(new java.awt.Dimension(462, 2));
        line5.setMinimumSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line5Layout = new javax.swing.GroupLayout(line5);
        line5.setLayout(line5Layout);
        line5Layout.setHorizontalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        line5Layout.setVerticalGroup(
            line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        panel_TongDoanhThu1.add(line5, gridBagConstraints);

        line6.setBackground(new java.awt.Color(102, 102, 102));
        line6.setMaximumSize(new java.awt.Dimension(462, 2));
        line6.setMinimumSize(new java.awt.Dimension(462, 2));
        line6.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout line6Layout = new javax.swing.GroupLayout(line6);
        line6.setLayout(line6Layout);
        line6Layout.setHorizontalGroup(
            line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        line6Layout.setVerticalGroup(
            line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(line6, gridBagConstraints);

        doanhThuTheoNam1.setBackground(new java.awt.Color(255, 255, 255));
        doanhThuTheoNam1.setMaximumSize(new java.awt.Dimension(418, 53));
        doanhThuTheoNam1.setMinimumSize(new java.awt.Dimension(418, 53));
        doanhThuTheoNam1.setPreferredSize(new java.awt.Dimension(418, 30));
        doanhThuTheoNam1.setLayout(new javax.swing.BoxLayout(doanhThuTheoNam1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setText("Doanh thu theo tháng:");
        jLabel7.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel7.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 30));
        doanhThuTheoNam1.add(jLabel7);

        comboBoxDoanhThu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxDoanhThu1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thongKeThang_Combo1(evt);
            }
        });
        doanhThuTheoNam1.add(comboBoxDoanhThu1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(doanhThuTheoNam1, gridBagConstraints);

        tongDoanhThuPhong1.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuPhong1.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong1.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong1.setPreferredSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong1.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setText("Tổng doanh thu dịch vụ:");
        jLabel8.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel8.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel8.setPreferredSize(new java.awt.Dimension(250, 30));
        tongDoanhThuPhong1.add(jLabel8, java.awt.BorderLayout.WEST);

        textTongDoanhThuPhong1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuPhong1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuPhong1.setText("150.000.000.000Đ");
        textTongDoanhThuPhong1.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuPhong1.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuPhong1.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuPhong1.add(textTongDoanhThuPhong1, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(tongDoanhThuPhong1, gridBagConstraints);

        tongDoanhThuDichVu1.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuDichVu1.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuDichVu1.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuDichVu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel15.setText("Tổng doanh thu phòng:");
        jLabel15.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel15.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel15.setPreferredSize(new java.awt.Dimension(220, 30));
        tongDoanhThuDichVu1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 53));

        textTongDoanhThuDichVu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuDichVu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuDichVu1.setText("150.000.000.000Đ");
        textTongDoanhThuDichVu1.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuDichVu1.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuDichVu1.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuDichVu1.add(textTongDoanhThuDichVu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 0, -1, 53));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(tongDoanhThuDichVu1, gridBagConstraints);

        tongSoHoaDon1.setBackground(new java.awt.Color(255, 255, 255));
        tongSoHoaDon1.setMaximumSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon1.setMinimumSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon1.setPreferredSize(new java.awt.Dimension(418, 53));
        tongSoHoaDon1.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel16.setText("Tổng số hóa đơn:");
        jLabel16.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel16.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel16.setPreferredSize(new java.awt.Dimension(220, 30));
        tongSoHoaDon1.add(jLabel16, java.awt.BorderLayout.WEST);

        textTongSoHoaDon1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongSoHoaDon1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongSoHoaDon1.setText("30");
        textTongSoHoaDon1.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongSoHoaDon1.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongSoHoaDon1.setPreferredSize(new java.awt.Dimension(190, 30));
        tongSoHoaDon1.add(textTongSoHoaDon1, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(tongSoHoaDon1, gridBagConstraints);

        tongSoDichVu1.setBackground(new java.awt.Color(255, 255, 255));
        tongSoDichVu1.setMaximumSize(new java.awt.Dimension(418, 53));
        tongSoDichVu1.setMinimumSize(new java.awt.Dimension(418, 53));
        tongSoDichVu1.setPreferredSize(new java.awt.Dimension(418, 53));
        tongSoDichVu1.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel17.setText("Tổng số dịch vụ:");
        jLabel17.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel17.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel17.setPreferredSize(new java.awt.Dimension(220, 30));
        tongSoDichVu1.add(jLabel17, java.awt.BorderLayout.WEST);

        textTongSoDichVu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongSoDichVu1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongSoDichVu1.setText("15");
        textTongSoDichVu1.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongSoDichVu1.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongSoDichVu1.setPreferredSize(new java.awt.Dimension(190, 30));
        tongSoDichVu1.add(textTongSoDichVu1, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(tongSoDichVu1, gridBagConstraints);

        tongDoanhThuPhong3.setBackground(new java.awt.Color(255, 255, 255));
        tongDoanhThuPhong3.setMaximumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong3.setMinimumSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong3.setPreferredSize(new java.awt.Dimension(418, 53));
        tongDoanhThuPhong3.setLayout(new java.awt.BorderLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel39.setText("Tổng doanh thu:");
        jLabel39.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel39.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel39.setPreferredSize(new java.awt.Dimension(250, 30));
        tongDoanhThuPhong3.add(jLabel39, java.awt.BorderLayout.WEST);

        textTongDoanhThuPhong3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTongDoanhThuPhong3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textTongDoanhThuPhong3.setText("150.000.000.000Đ");
        textTongDoanhThuPhong3.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textTongDoanhThuPhong3.setMinimumSize(new java.awt.Dimension(1, 1));
        textTongDoanhThuPhong3.setPreferredSize(new java.awt.Dimension(190, 30));
        tongDoanhThuPhong3.add(textTongDoanhThuPhong3, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        panel_TongDoanhThu1.add(tongDoanhThuPhong3, gridBagConstraints);

        chart1.setBackground(new java.awt.Color(255, 255, 255));
        chart1.setMaximumSize(new java.awt.Dimension(1427, 440));
        chart1.setLayout(new java.awt.BorderLayout());

        panel_SoSanh1.setBackground(new java.awt.Color(255, 255, 255));
        panel_SoSanh1.setMaximumSize(new java.awt.Dimension(475, 506));
        panel_SoSanh1.setMinimumSize(new java.awt.Dimension(475, 506));

        tongDoanhThu3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        tongDoanhThu3.setText("SO SÁNH");

        panel_soSanhDoanhThuTheoNam1.setBackground(new java.awt.Color(255, 255, 255));
        panel_soSanhDoanhThuTheoNam1.setMaximumSize(new java.awt.Dimension(450, 30));
        panel_soSanhDoanhThuTheoNam1.setMinimumSize(new java.awt.Dimension(450, 30));
        panel_soSanhDoanhThuTheoNam1.setPreferredSize(new java.awt.Dimension(450, 30));
        panel_soSanhDoanhThuTheoNam1.setLayout(new javax.swing.BoxLayout(panel_soSanhDoanhThuTheoNam1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setText("Doanh thu theo tháng:");
        jLabel18.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel18.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel18.setPreferredSize(new java.awt.Dimension(200, 30));
        panel_soSanhDoanhThuTheoNam1.add(jLabel18);

        comboBoxSoSanh1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxSoSanh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSoSanh1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thongKeThang_Combo2(evt);
            }
        });
        panel_soSanhDoanhThuTheoNam1.add(comboBoxSoSanh1);

        line7.setBackground(new java.awt.Color(102, 102, 102));
        line7.setMaximumSize(new java.awt.Dimension(462, 2));
        line7.setMinimumSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line7Layout = new javax.swing.GroupLayout(line7);
        line7.setLayout(line7Layout);
        line7Layout.setHorizontalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line7Layout.setVerticalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_Chart_SoSanh1.setLayout(new java.awt.BorderLayout());

        line8.setBackground(new java.awt.Color(102, 102, 102));
        line8.setMaximumSize(new java.awt.Dimension(462, 2));
        line8.setMinimumSize(new java.awt.Dimension(462, 2));

        javax.swing.GroupLayout line8Layout = new javax.swing.GroupLayout(line8);
        line8.setLayout(line8Layout);
        line8Layout.setHorizontalGroup(
            line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line8Layout.setVerticalGroup(
            line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        soSanh1.setBackground(new java.awt.Color(255, 255, 255));
        soSanh1.setLayout(new java.awt.GridBagLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setText("Tháng 2 <-> Tháng 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        soSanh1.add(jLabel19, gridBagConstraints);

        panel_doanhThuSoSanhPhong1.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong1.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong1.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong1.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong1.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel20.setText("Doanh thu Phòng:");
        jLabel20.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel20.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel20.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong1.add(jLabel20, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong1.setText("20%");
        textDoanhThuSoSanhPhong1.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong1.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong1.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong1.add(textDoanhThuSoSanhPhong1, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-up-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong1.add(iconDoanhThuSoSanhPhong1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh1.add(panel_doanhThuSoSanhPhong1, gridBagConstraints);

        panel_doanhThuSoSanhPhong4.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong4.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong4.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong4.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong4.setLayout(new java.awt.GridBagLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel21.setText("Doanh thu Dịch Vụ:");
        jLabel21.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel21.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel21.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong4.add(jLabel21, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong4.setText("15%");
        textDoanhThuSoSanhPhong4.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong4.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong4.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong4.add(textDoanhThuSoSanhPhong4, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong4.add(iconDoanhThuSoSanhPhong4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh1.add(panel_doanhThuSoSanhPhong4, gridBagConstraints);

        panel_doanhThuSoSanhPhong5.setBackground(new java.awt.Color(255, 255, 255));
        panel_doanhThuSoSanhPhong5.setMaximumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong5.setMinimumSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong5.setPreferredSize(new java.awt.Dimension(418, 30));
        panel_doanhThuSoSanhPhong5.setLayout(new java.awt.GridBagLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel22.setText("Tổng doanh thu");
        jLabel22.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jLabel22.setMinimumSize(new java.awt.Dimension(1, 1));
        jLabel22.setPreferredSize(new java.awt.Dimension(184, 30));
        panel_doanhThuSoSanhPhong5.add(jLabel22, new java.awt.GridBagConstraints());

        textDoanhThuSoSanhPhong5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDoanhThuSoSanhPhong5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textDoanhThuSoSanhPhong5.setText("22%");
        textDoanhThuSoSanhPhong5.setMaximumSize(new java.awt.Dimension(9999, 9999));
        textDoanhThuSoSanhPhong5.setMinimumSize(new java.awt.Dimension(1, 1));
        textDoanhThuSoSanhPhong5.setPreferredSize(new java.awt.Dimension(190, 30));
        panel_doanhThuSoSanhPhong5.add(textDoanhThuSoSanhPhong5, new java.awt.GridBagConstraints());

        iconDoanhThuSoSanhPhong5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-horizontal-line-20.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        panel_doanhThuSoSanhPhong5.add(iconDoanhThuSoSanhPhong5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        soSanh1.add(panel_doanhThuSoSanhPhong5, gridBagConstraints);

        javax.swing.GroupLayout panel_SoSanh1Layout = new javax.swing.GroupLayout(panel_SoSanh1);
        panel_SoSanh1.setLayout(panel_SoSanh1Layout);
        panel_SoSanh1Layout.setHorizontalGroup(
            panel_SoSanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                .addGroup(panel_SoSanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                        .addGroup(panel_SoSanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(tongDoanhThu3))
                            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(line7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(panel_soSanhDoanhThuTheoNam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel_Chart_SoSanh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_SoSanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soSanh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel_SoSanh1Layout.setVerticalGroup(
            panel_SoSanh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SoSanh1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tongDoanhThu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_soSanhDoanhThuTheoNam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Chart_SoSanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(line8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soSanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(670, 509));
        jPanel6.setMinimumSize(new java.awt.Dimension(670, 509));
        jPanel6.setPreferredSize(new java.awt.Dimension(670, 509));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel23.setText("Phòng Sử Dụng Nhiều Nhất");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(599, 210));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel25.setText("Trung bình số lượng khách hàng:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("15 Người / Ngày");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel27.setText("Trung bình thời gian sử dụng:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setText("4Giờ / Phòng");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8);

        jPanel1.add(jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setText("- Xu hướng khách hàng chọn phòng có sức chứa tối đa 15 người là nhiều nhất");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("- Xu hướng khách hàng chọn phòng theo chủ đề Alexcia là nhiều nhất");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setText("- Tỉ lệ khách hàng chọn phòng VIP là 30%");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel13);

        jPanel1.add(jPanel10);

        rSTableMetro3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Phòng", "Số lần"
            }
        ));
        rSTableMetro3.setRowHeight(25);
        jScrollPane3.setViewportView(rSTableMetro3);
        if (rSTableMetro3.getColumnModel().getColumnCount() > 0) {
            rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(1000);
            rSTableMetro3.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(670, 509));
        jPanel7.setMinimumSize(new java.awt.Dimension(670, 509));

        rSTableMetro4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dịch Vụ", "Số lần"
            }
        ));
        rSTableMetro4.setRowHeight(25);
        jScrollPane4.setViewportView(rSTableMetro4);
        if (rSTableMetro4.getColumnModel().getColumnCount() > 0) {
            rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(1000);
            rSTableMetro4.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel24.setText("Dịch Vụ Sử Dụng Nhiều Nhất");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(599, 210));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.Y_AXIS));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel32.setText("Trung bình khách gọi dịch vụ:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setText("15 Người / Ngày");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(26, 26, 26))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel36.setText("Tổng tiền trung bình cho mỗi hóa đơn:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setText("4Giờ / Phòng");
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel17);

        jPanel14.add(jPanel15);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.PAGE_AXIS));
        jPanel14.add(jPanel19);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel24))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(383, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout tab_ThongKeDoanhThuThangLayout = new javax.swing.GroupLayout(tab_ThongKeDoanhThuThang);
        tab_ThongKeDoanhThuThang.setLayout(tab_ThongKeDoanhThuThangLayout);
        tab_ThongKeDoanhThuThangLayout.setHorizontalGroup(
            tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_ThongKeDoanhThuThangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_TongDoanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_SoSanh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tab_ThongKeDoanhThuThangLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab_ThongKeDoanhThuThangLayout.setVerticalGroup(
            tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_ThongKeDoanhThuThangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_ThongKeDoanhThuThangLayout.createSequentialGroup()
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(tab_ThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tab_ThongKeDoanhThuThangLayout.createSequentialGroup()
                        .addComponent(panel_TongDoanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_SoSanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê theo tháng", tab_ThongKeDoanhThuThang);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(1952, 929));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doanhThuTheoNamChange(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_doanhThuTheoNamChange
        if (buildComponent == true){
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                    load_TongDoanhThu();
            }
        }
    }//GEN-LAST:event_doanhThuTheoNamChange

    private void soSanhChange(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_soSanhChange
        if (buildComponent == true){
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                load_SoSanh();
            }
        }
    }//GEN-LAST:event_soSanhChange

    private void thongKeThang_Combo1(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thongKeThang_Combo1
        if (buildComponent == true){
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                load_ThongKeThang();
            }
        }
    }//GEN-LAST:event_thongKeThang_Combo1

    private void thongKeThang_Combo2(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thongKeThang_Combo2
        if (buildComponent == true){
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                
            }
        }
    }//GEN-LAST:event_thongKeThang_Combo2

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_Thongke().setVisible(true);
            }
        });
    }
    
    private void display(ArrayList<Double> input) {
        XYSeries series = new XYSeries("Tổng doanh thu");
        for (int i = 0; i < 12; i++) {
            series.add(i, input.get(i));
        }
        XYDataset dataset = new XYSeriesCollection(series);
        String[] labels = new String[series.getItemCount()];
        labels[0] = "1";
        labels[1] = "2";
        labels[2] = "3";
        labels[3] = "4";
        labels[4] = "5";
        labels[5] = "6";
        labels[6] = "7";
        labels[7] = "8";
        labels[8] = "9";
        labels[9] = "10";
        labels[10] = "11";
        labels[11] = "12";
        NumberAxis domain = new SymbolAxis("Tháng", labels);
        NumberAxis range = new NumberAxis("Tổng Doanh Thu");
        XYSplineRenderer r = new XYSplineRenderer(12);
        XYPlot xyplot = new XYPlot(dataset, domain, range, r);
        JFreeChart chart = new JFreeChart(xyplot);
        ChartPanel chartPanel = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1427, 440);
            }
        };
        this.chart.add(chartPanel, BorderLayout.WEST);
    }
        
    public ChartPanel createDataset(double[] first, double[] last) {

        // row keys...
        final String series1 = "Tiền phòng";
        final String series2 = "Tiền dịch vụ";


        // column keys...
        final String category1 = "Năm 2022";
        final String category2 = "Năm 2023";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(first[0], series1, category1);
        dataset.addValue(last[0], series1, category2);


        dataset.addValue(first[1], series2, category1);
        dataset.addValue(last[1], series2, category2);
        
        
        JFreeChart chart = ChartFactory.createBarChart(
            "",        // chart title
            "",               // domain axis label
            "Triệu",                  // range axis label
            dataset,                 // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips?
            false                     // URL generator?  Not required...
        );
        ChartPanel chartPanel2 = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(474, 900);
            }
        };
        return chartPanel2;
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart;
    private javax.swing.JPanel chart1;
    private javax.swing.JComboBox<String> comboBoxDoanhThu;
    private javax.swing.JComboBox<String> comboBoxDoanhThu1;
    private javax.swing.JComboBox<String> comboBoxSoSanh;
    private javax.swing.JComboBox<String> comboBoxSoSanh1;
    private javax.swing.JPanel doanhThuTheoNam;
    private javax.swing.JPanel doanhThuTheoNam1;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong1;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong2;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong3;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong4;
    private javax.swing.JLabel iconDoanhThuSoSanhPhong5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line2;
    private javax.swing.JPanel line3;
    private javax.swing.JPanel line4;
    private javax.swing.JPanel line5;
    private javax.swing.JPanel line6;
    private javax.swing.JPanel line7;
    private javax.swing.JPanel line8;
    private javax.swing.JPanel panel_Chart_SoSanh;
    private javax.swing.JPanel panel_Chart_SoSanh1;
    private javax.swing.JPanel panel_SoSanh;
    private javax.swing.JPanel panel_SoSanh1;
    private javax.swing.JPanel panel_TongDoanhThu;
    private javax.swing.JPanel panel_TongDoanhThu1;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong1;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong2;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong3;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong4;
    private javax.swing.JPanel panel_doanhThuSoSanhPhong5;
    private javax.swing.JPanel panel_soSanhDoanhThuTheoNam;
    private javax.swing.JPanel panel_soSanhDoanhThuTheoNam1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    private rojeru_san.complementos.RSTableMetro rSTableMetro3;
    private rojeru_san.complementos.RSTableMetro rSTableMetro4;
    private javax.swing.JPanel soSanh;
    private javax.swing.JPanel soSanh1;
    private javax.swing.JPanel tab_ThongKeDoanhThuThang;
    private javax.swing.JPanel tab_TongDoanhThu;
    private javax.swing.JLabel textDoanhThuSoSanhPhong;
    private javax.swing.JLabel textDoanhThuSoSanhPhong1;
    private javax.swing.JLabel textDoanhThuSoSanhPhong2;
    private javax.swing.JLabel textDoanhThuSoSanhPhong3;
    private javax.swing.JLabel textDoanhThuSoSanhPhong4;
    private javax.swing.JLabel textDoanhThuSoSanhPhong5;
    private javax.swing.JLabel textTongDoanhThuDichVu;
    private javax.swing.JLabel textTongDoanhThuDichVu1;
    private javax.swing.JLabel textTongDoanhThuPhong;
    private javax.swing.JLabel textTongDoanhThuPhong1;
    private javax.swing.JLabel textTongDoanhThuPhong2;
    private javax.swing.JLabel textTongDoanhThuPhong3;
    private javax.swing.JLabel textTongSoDichVu;
    private javax.swing.JLabel textTongSoDichVu1;
    private javax.swing.JLabel textTongSoHoaDon;
    private javax.swing.JLabel textTongSoHoaDon1;
    private javax.swing.JLabel tongDoanhThu;
    private javax.swing.JLabel tongDoanhThu1;
    private javax.swing.JLabel tongDoanhThu2;
    private javax.swing.JLabel tongDoanhThu3;
    private javax.swing.JPanel tongDoanhThuDichVu;
    private javax.swing.JPanel tongDoanhThuDichVu1;
    private javax.swing.JPanel tongDoanhThuPhong;
    private javax.swing.JPanel tongDoanhThuPhong1;
    private javax.swing.JPanel tongDoanhThuPhong2;
    private javax.swing.JPanel tongDoanhThuPhong3;
    private javax.swing.JPanel tongSoDichVu;
    private javax.swing.JPanel tongSoDichVu1;
    private javax.swing.JPanel tongSoHoaDon;
    private javax.swing.JPanel tongSoHoaDon1;
    // End of variables declaration//GEN-END:variables
}
