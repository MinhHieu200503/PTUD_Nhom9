package gui;


import dao.I_CRUD;
import entity.PhieuDatPhong;
import entity.ThongTinPhongDangChon;
import entity.UuDai;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class GD_XuLy_TraPhong_HoaDon extends javax.swing.JFrame implements dao.I_CRUD{
    boolean check = false;
    /**
     * Creates new form GD_XuLy_TraPhong_TinhTien
     */
    DefaultTableModel model =  new DefaultTableModel(new String [] {"Tên hàng và dịch vụ", "Đơn giá", "Số lượng", "Tổng", "Ghi chú"}, 0);
    double tongTienCanThanhToan = 3000;
    ArrayList<entity.ThongTinPhongDangChon> data;
    entity.UuDai uuDai = null;
    
    public GD_XuLy_TraPhong_HoaDon(ArrayList<entity.ThongTinPhongDangChon> data) throws FileNotFoundException {
        initComponents();
        this.data = data;
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(975, 952));
        if(data != null){
             loadData(data);
        }
        rSTableMetro1.setModel(model);
        
        
        //
        jCheckBox1.setVisible(false);
    }
    
     public ArrayList<int[]> loadFileTextField() throws FileNotFoundException{
        File file = new File("src\\SettingVoucher.txt");

        ArrayList<int[]> diemTichLuy = new ArrayList<>();
        // file tồn tại -> đọc
        if (file.exists()){   
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                String[] temp = sc.nextLine().split(";");
                diemTichLuy.add(new int[]{Integer.valueOf(temp[0]), Integer.valueOf(temp[1])});
            }
        }
        // file không tồn tại-> tạo
        else{
            Formatter createFile = new Formatter(file);
            //DATA TEMP
            diemTichLuy = new ArrayList<>();
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            
            
            writeFile(diemTichLuy);
            createFile.close();
        }
        return diemTichLuy;
     }
     
    public void writeFile(ArrayList<int[]> data) throws FileNotFoundException{
        File file = new File("src\\SettingVoucher.txt");
        Formatter f = new Formatter(file);
        for (int[] is : data) {
            f.format("%d;%d\n", is[0], is[1]);
        }
        f.close();
    }
    public void loadData(ArrayList<entity.ThongTinPhongDangChon> data) throws FileNotFoundException{
        LocalDateTime resultTGDP = LocalDateTime.now();
        
        double tongDichVu = 0.0;
        double tongTienPhong = 0.0;
        int thoiGianSuDung = 0;
        double datCoc = 0.0;
        
        for (ThongTinPhongDangChon thongTinPhongDangChon : data) {
            LocalDateTime resultTGDP1 = thongTinPhongDangChon.danhSachPhong.getLast().getChiTietPhongHoaDon().getThoiGianNhanPhong();
            if (resultTGDP1.isBefore(resultTGDP)){
                resultTGDP = resultTGDP1;
            }
            thoiGianSuDung = thoiGianSuDung + Integer.valueOf((int) thongTinPhongDangChon.tongThoiGianSuDung());
            for (ThongTinPhongDangChon.PhongVaDichVu phongVaDichVu : thongTinPhongDangChon.danhSachPhong) {
                String tenPhong = phongVaDichVu.getChiTietPhongHoaDon().getPhong().getTenPhong();
                String giaPhong = String.format("%,.3f ",  Double.valueOf(phongVaDichVu.getChiTietPhongHoaDon().getPhong().getGiaPhongTheoGio() / 60 )) +"Đ/p";
                
              Duration timeResult = Duration.between(phongVaDichVu.getChiTietPhongHoaDon().getThoiGianTraPhong(), phongVaDichVu.getChiTietPhongHoaDon().getThoiGianNhanPhong());
              long minutes = Math.abs(timeResult.toMinutes());              
                String soLuong = String.valueOf(minutes);
                double tong = minutes * (phongVaDichVu.getChiTietPhongHoaDon().getPhong().getGiaPhongTheoGio() / 60);
                model.addRow(new String[] {tenPhong, giaPhong, String.valueOf(minutes), String.format("%,.3f ", tong) + "Đ",phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().contains("MP000")? "":( "Chuyển phòng "+ phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().substring(2,5))});

                for (ThongTinPhongDangChon.PhongVaDichVu.DichVu dichVu : phongVaDichVu.dichVu) {
                    String tenDichVu = dichVu.getChiTietDichVu().getDichVu().getTenDichVu();
                    Double donGiaDichVu = dichVu.getChiTietDichVu().getDichVu().getGia();
                    int soLuongDichVu = dichVu.getChiTietDichVu().getSoLuong();
                    double tongTienDichVu = donGiaDichVu * soLuongDichVu;
                    
                    model.addRow(new String[] {tenDichVu, 
                        String.format("%,.3f ", donGiaDichVu) +"Đ", 
                        String.valueOf(soLuongDichVu),
                        String.format("%,.3f ", tong) +"Đ", ""
                    });
                }
                
            }
            datCoc = datCoc + thongTinPhongDangChon.getDatCoc();
            tongDichVu = tongDichVu + thongTinPhongDangChon.tongTienDichVu();
            tongTienPhong = tongTienPhong + thongTinPhongDangChon.tongTienPhong();
        }
        
        
        
        jLabel4.setText(resultTGDP.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        jLabel6.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        ArrayList<int[]> chuongTrinhKhuyenMai = loadFileTextField();

        double tongTien = tongDichVu + tongTienPhong;

        jLabel27.setText(String.format("%,.3f", tongDichVu+tongTienPhong) + "Đ");
        
        coc.setText("- "+String.format("%,.3f", datCoc) + "Đ");
        
        thue.setText(String.format("(%d", (chuongTrinhKhuyenMai.get(0)[0])) + "%) " + "- " + String.format("%,.3fĐ", (chuongTrinhKhuyenMai.get(0)[0]/100.0)*tongTien));
        chuongTrinh.setText(String.format("(%d", (chuongTrinhKhuyenMai.get(0)[1])) + "%) " + "- " + String.format("%,.3fĐ", (chuongTrinhKhuyenMai.get(0)[1]/100.0)*tongTien));

                
        tongTienCanThanhToan = tongTien - datCoc - (chuongTrinhKhuyenMai.get(0)[0]/100*tongTien);
        
        jLabel22.setText(String.format("%,.3f", tongTienCanThanhToan) + "Đ");
         
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        thue = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        chuongTrinh = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        coc = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rSMetroTextPlaceHolder1 = new rojerusan.RSMetroTextPlaceHolder();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jCheckBox1 = new javax.swing.JCheckBox();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 1000));
        setMinimumSize(new java.awt.Dimension(990, 1000));
        setPreferredSize(new java.awt.Dimension(990, 1000));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(975, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(975, 102));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KARAOKE ECHO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("157/18 Trần Bá Giao, Phường 5, Gò Vấp, TP.Hồ Chí Minh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(975, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(975, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(975, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel3.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Thời gian đặt phòng:");
        jPanel3.add(jLabel3, java.awt.BorderLayout.WEST);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("11:30 02/12/2003");
        jPanel3.add(jLabel4, java.awt.BorderLayout.EAST);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel4.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Thời gian trả phòng:");
        jPanel4.add(jLabel5, java.awt.BorderLayout.WEST);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("12:30 02/12/2003");
        jPanel4.add(jLabel6, java.awt.BorderLayout.EAST);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel5.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Tổng thời gian sử dụng:");
        jPanel5.add(jLabel7, java.awt.BorderLayout.WEST);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("1 Giờ 40 Phút");
        jPanel5.add(jLabel8, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(993, 89));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ád", "ád", "ád", "d", "áád"},
                {"d", "áád", null, "ád", "ád"},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên hàng và dịch vụ", "Đơn giá", "Số lượng", "Tổng", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setAltoHead(35);
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 204, 0));
        rSTableMetro1.setColorBordeFilas(new java.awt.Color(204, 204, 204));
        rSTableMetro1.setColorBordeHead(new java.awt.Color(0, 153, 51));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        rSTableMetro1.setColumnSelectionAllowed(true);
        rSTableMetro1.setEnabled(false);
        rSTableMetro1.setGridColor(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setMultipleSeleccion(false);
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);
        rSTableMetro1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(200);
            rSTableMetro1.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(10);
            rSTableMetro1.getColumnModel().getColumn(2).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(30);
            rSTableMetro1.getColumnModel().getColumn(3).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(100);
            rSTableMetro1.getColumnModel().getColumn(4).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(975, 184));
        jPanel6.setMinimumSize(new java.awt.Dimension(975, 184));
        jPanel6.setPreferredSize(new java.awt.Dimension(975, 184));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel17.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel17.setName(""); // NOI18N
        jPanel17.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setText("Tổng tiền:");
        jPanel17.add(jLabel26, java.awt.BorderLayout.WEST);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setText("300.000Đ");
        jPanel17.add(jLabel27, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel17);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel11.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel11.setName(""); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("Thuế (Vat):");
        jPanel11.add(jLabel15, java.awt.BorderLayout.WEST);

        thue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        thue.setText("null");
        jPanel11.add(thue, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel12.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel12.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("Chương trình:");
        jPanel12.add(jLabel17, java.awt.BorderLayout.WEST);

        chuongTrinh.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        chuongTrinh.setText("null");
        jPanel12.add(chuongTrinh, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel12);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel15.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel15.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setText("Đặt cọc:");
        jPanel15.add(jLabel23, java.awt.BorderLayout.WEST);

        coc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        coc.setText("-350.000Đ");
        jPanel15.add(coc, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel15);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel13.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel13.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("Hội viên:");
        jPanel13.add(jLabel19, java.awt.BorderLayout.WEST);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel20.setText("null");
        jPanel13.add(jLabel20, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel13);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(957, 53));
        jPanel16.setMinimumSize(new java.awt.Dimension(957, 53));
        jPanel16.setPreferredSize(new java.awt.Dimension(957, 53));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Mã ưu đãi:");
        jPanel16.add(jLabel25, java.awt.BorderLayout.WEST);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 32));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-find-40 (1).png"))); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel9.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVoucher(evt);
            }
        });
        jPanel8.add(jLabel9, java.awt.BorderLayout.WEST);

        rSMetroTextPlaceHolder1.setForeground(new java.awt.Color(0, 0, 0));
        rSMetroTextPlaceHolder1.setBorderColor(new java.awt.Color(0, 0, 0));
        rSMetroTextPlaceHolder1.setBotonColor(new java.awt.Color(255, 255, 255));
        rSMetroTextPlaceHolder1.setPreferredSize(new java.awt.Dimension(250, 38));
        rSMetroTextPlaceHolder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVoucher(evt);
            }
        });
        rSMetroTextPlaceHolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMetroTextPlaceHolder1ActionPerformed(evt);
            }
        });
        jPanel8.add(rSMetroTextPlaceHolder1, java.awt.BorderLayout.EAST);

        jPanel16.add(jPanel8, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel16);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel14.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel14.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Tổng tiền cần thanh toán:");
        jPanel14.add(jLabel21, java.awt.BorderLayout.WEST);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("300.000Đ");
        jPanel14.add(jLabel22, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel14);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(975, 83));
        jPanel7.setMinimumSize(new java.awt.Dimension(975, 83));
        jPanel7.setPreferredSize(new java.awt.Dimension(975, 83));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 204, 0));
        rSMaterialButtonRectangle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle1.setText("Thanh Toán");
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCheckBox1.setText("In hóa đơn");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(204, 204, 204));
        rSMaterialButtonRectangle2.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle2.setText("Hủy");
        rSMaterialButtonRectangle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void huyButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyButton
        this.dispose();
    }//GEN-LAST:event_huyButton

    private void rSMetroTextPlaceHolder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMetroTextPlaceHolder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMetroTextPlaceHolder1ActionPerformed

    private void click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click
        int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thanh toán ?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            updateBill();
            this.dispose();
        } else {
            
        }
    }//GEN-LAST:event_click

    public void updateBill(){
        ArrayList<ThongTinPhongDangChon> result = this.data;
        
        for (ThongTinPhongDangChon thongTinPhongDangChon : result) {
            if (thongTinPhongDangChon.getPhieuDatPhong() != null){
               new dao.DAO_PhieuDatPhong().updateBill(thongTinPhongDangChon.getPhieuDatPhong());
            }
                ThongTinPhongDangChon.PhongVaDichVu phongVaDichVu = thongTinPhongDangChon.getDanhSachPhong().getFirst();
                new dao.DAO_ChiTietPhong_HoaDon().updateBill(phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().substring(0, 5)+" Đã hoàn thành", phongVaDichVu.getChiTietPhongHoaDon().getHoaDon().getMaHoaDon(), phongVaDichVu.getChiTietPhongHoaDon().getPhong().getMaPhong(), this.uuDai.getMaUuDai());
            
        }
    }
    
    private void checkVoucher(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkVoucher
        ArrayList<entity.UuDai> temp = getAll(UuDai.class);
        
        for (UuDai uuDai : temp) {
                if (rSMetroTextPlaceHolder1.getText().equalsIgnoreCase(uuDai.getTenUuDai())){
                    rSMetroTextPlaceHolder1.setBorderColor(new Color(0,204,0));
                    rSMetroTextPlaceHolder1.setBackground(new Color(204,204,204));
                    rSMetroTextPlaceHolder1.setEditable(false);
                    double value = (tongTienCanThanhToan * uuDai.getGiamGia());
                    rSMetroTextPlaceHolder1.setText(String.valueOf("- " + String.format("%,.3f", value)));
                    if (check == false){
                                            tongTienCanThanhToan = tongTienCanThanhToan - (tongTienCanThanhToan * uuDai.getGiamGia());
                                            jLabel22.setText(String.format("%,.3f", tongTienCanThanhToan) + "Đ");
                                            check = true;
                                            this.uuDai = uuDai;
                                            
                    }

                    
                    return;
                }
        }
        rSMetroTextPlaceHolder1.setBorderColor(new Color(255,0,0));
        return;
        
        
        
       
    }//GEN-LAST:event_checkVoucher

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
            java.util.logging.Logger.getLogger(GD_XuLy_TraPhong_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_TraPhong_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_TraPhong_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_TraPhong_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try  {
                    new GD_XuLy_TraPhong_HoaDon(null).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GD_XuLy_TraPhong_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chuongTrinh;
    private javax.swing.JLabel coc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMetroTextPlaceHolder rSMetroTextPlaceHolder1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private javax.swing.JLabel thue;
    // End of variables declaration//GEN-END:variables
}
