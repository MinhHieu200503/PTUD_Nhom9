/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_ChiTietPhong_HoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_PhieuDatPhong;
import dao.DAO_Phong;
import dao.I_CRUD;
import entity.ChitTietPhongHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.UuDai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Minh Hieu
 */
public class GD_XuLy_NhanPhong extends javax.swing.JFrame {

    /**
     * Creates new form GD_XuLy_NhanPhong
     */
    public GD_XuLy_NhanPhong() {
        initComponents();
        FilterDate.setDate(new Date());
        FilterDate.getDateEditor().addPropertyChangeListener(
        new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    chooserDate();
                    
                }

                
            }
        });
        
        loadDSPhongTrong(null,0,null);
        
    }
    
    private void loadDSPhongTrong(String loaiPhong,int sucChua,String date){
        ContainerListPhong.removeAll();
        
         dao.DAO_Phong dao_phong = new DAO_Phong();
         ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
         ArrayList<entity.Phong> listPhong1 = new ArrayList<entity.Phong>();
         
         listPhong = dao_phong.getAll(Phong.class);
        
        if(loaiPhong == null && sucChua == 0&&date==null){
            listPhong1 = dao_phong.getPhongTheoTrangThai(1);
            danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_NhanPhong.class);
            ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
            ContainerListPhong.getComponent(0).setBackground(Color.white);
        }
        else{
            listPhong1 = dao_phong.getPhongTheoDieuKien(loaiPhong,sucChua,1,date);
            danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_NhanPhong.class);
            ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
            ContainerListPhong.getComponent(0).setBackground(Color.white);
        }
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container_DatPhongNgay = new javax.swing.JPanel();
        ContainerListPhong = new javax.swing.JPanel();
        Panel_ThongTinKhachHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_TienCoc = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_GioNhanPhong = new javax.swing.JTextField();
        Panel_ThongTinKhachHang1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_SoDT = new app.bolivia.swing.JCTextField();
        txt_khachHang1 = new app.bolivia.swing.JCTextField();
        btn_HuyDat = new javax.swing.JButton();
        locPanel = new javax.swing.JPanel();
        locPanel1 = new javax.swing.JPanel();
        lableFilterOption1 = new javax.swing.JLabel();
        ComboFilterOption1 = new javax.swing.JComboBox<>();
        locPanel2 = new javax.swing.JPanel();
        lableFilterOption2 = new javax.swing.JLabel();
        ComboFilterOption2 = new javax.swing.JComboBox<>();
        locPanel3 = new javax.swing.JPanel();
        lableFilterOption3 = new javax.swing.JLabel();
        FilterDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container_DatPhongNgay.setBackground(new java.awt.Color(255, 255, 255));
        Container_DatPhongNgay.setMaximumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setMinimumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setPreferredSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContainerListPhong.setBackground(new java.awt.Color(255, 255, 255));
        ContainerListPhong.setMaximumSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setMinimumSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setName(""); // NOI18N
        ContainerListPhong.setPreferredSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setVerifyInputWhenFocusTarget(false);
        ContainerListPhong.setLayout(new java.awt.GridLayout());
        Container_DatPhongNgay.add(ContainerListPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 900, 964));

        Panel_ThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Giờ nhận phòng:");

        txt_TienCoc.setEditable(false);
        txt_TienCoc.setEnabled(false);
        txt_TienCoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Tiền cọc đã nhận: ");

        txt_GioNhanPhong.setEditable(false);
        txt_GioNhanPhong.setEnabled(false);
        txt_GioNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GioNhanPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_GioNhanPhong)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_TienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_ThongTinKhachHangLayout.setVerticalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 650, 200));

        Panel_ThongTinKhachHang1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Tên khách hàng:");

        txt_SoDT.setEditable(false);
        txt_SoDT.setEnabled(false);
        txt_SoDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_khachHang1.setEditable(false);
        txt_khachHang1.setEnabled(false);
        txt_khachHang1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout Panel_ThongTinKhachHang1Layout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang1);
        Panel_ThongTinKhachHang1.setLayout(Panel_ThongTinKhachHang1Layout);
        Panel_ThongTinKhachHang1Layout.setHorizontalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_SoDT, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txt_khachHang1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        Panel_ThongTinKhachHang1Layout.setVerticalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
            .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                    .addContainerGap(132, Short.MAX_VALUE)
                    .addComponent(txt_khachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)))
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 650, 210));

        btn_HuyDat.setBackground(new java.awt.Color(0, 204, 204));
        btn_HuyDat.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_HuyDat.setForeground(new java.awt.Color(255, 255, 255));
        btn_HuyDat.setText("Nhận phòng");
        btn_HuyDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click_NhanPhong(evt);
            }
        });
        Container_DatPhongNgay.add(btn_HuyDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 480, 420, 60));

        locPanel.setBackground(new java.awt.Color(255, 255, 255));
        locPanel.setMaximumSize(new java.awt.Dimension(1080, 84));
        locPanel.setMinimumSize(new java.awt.Dimension(1080, 84));

        locPanel1.setBackground(new java.awt.Color(255, 255, 255));
        locPanel1.setMaximumSize(new java.awt.Dimension(330, 73));
        locPanel1.setMinimumSize(new java.awt.Dimension(330, 73));

        lableFilterOption1.setBackground(new java.awt.Color(255, 255, 255));
        lableFilterOption1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lableFilterOption1.setText("Lọc theo loại phòng:");

        ComboFilterOption1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ComboFilterOption1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Vip", "Thường" }));
        ComboFilterOption1.setMaximumSize(new java.awt.Dimension(101, 32));
        ComboFilterOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFilterOption1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locPanel1Layout = new javax.swing.GroupLayout(locPanel1);
        locPanel1.setLayout(locPanel1Layout);
        locPanel1Layout.setHorizontalGroup(
            locPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel1Layout.createSequentialGroup()
                .addGroup(locPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        locPanel1Layout.setVerticalGroup(
            locPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel1Layout.createSequentialGroup()
                .addComponent(lableFilterOption1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        locPanel2.setBackground(new java.awt.Color(255, 255, 255));
        locPanel2.setMaximumSize(new java.awt.Dimension(330, 73));
        locPanel2.setMinimumSize(new java.awt.Dimension(330, 73));

        lableFilterOption2.setBackground(new java.awt.Color(255, 255, 255));
        lableFilterOption2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lableFilterOption2.setText("Lọc theo sức chứa tối đa :");

        ComboFilterOption2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ComboFilterOption2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "5", "10", "15", "20" }));
        ComboFilterOption2.setMaximumSize(new java.awt.Dimension(101, 32));
        ComboFilterOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFilterOption2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locPanel2Layout = new javax.swing.GroupLayout(locPanel2);
        locPanel2.setLayout(locPanel2Layout);
        locPanel2Layout.setHorizontalGroup(
            locPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(locPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lableFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        locPanel2Layout.setVerticalGroup(
            locPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel2Layout.createSequentialGroup()
                .addComponent(lableFilterOption2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        locPanel3.setBackground(new java.awt.Color(255, 255, 255));
        locPanel3.setMaximumSize(new java.awt.Dimension(330, 73));
        locPanel3.setMinimumSize(new java.awt.Dimension(330, 73));

        lableFilterOption3.setBackground(new java.awt.Color(255, 255, 255));
        lableFilterOption3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lableFilterOption3.setText("Lọc theo ngày:");

        FilterDate.setDateFormatString("dd-MM-yyyy");
        FilterDate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        FilterDate.setPreferredSize(new java.awt.Dimension(88, 38));

        javax.swing.GroupLayout locPanel3Layout = new javax.swing.GroupLayout(locPanel3);
        locPanel3.setLayout(locPanel3Layout);
        locPanel3Layout.setHorizontalGroup(
            locPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel3Layout.createSequentialGroup()
                .addGroup(locPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableFilterOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        locPanel3Layout.setVerticalGroup(
            locPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanel3Layout.createSequentialGroup()
                .addComponent(lableFilterOption3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout locPanelLayout = new javax.swing.GroupLayout(locPanel);
        locPanel.setLayout(locPanelLayout);
        locPanelLayout.setHorizontalGroup(
            locPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(locPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(locPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        locPanelLayout.setVerticalGroup(
            locPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(locPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(locPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Container_DatPhongNgay.add(locPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 910, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container_DatPhongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 1614, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container_DatPhongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboFilterOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilterOption1ActionPerformed
        String loaiPhong = ComboFilterOption1.getSelectedItem().toString();
        if(loaiPhong.equalsIgnoreCase("Không")){
            loaiPhong = null;
        }
        String sucChua = ComboFilterOption2.getSelectedItem().toString();

        if(sucChua.equalsIgnoreCase("Không")){
            sucChua = "0";
        }
        String date = getDateChooser();
        loadDSPhongTrong(loaiPhong,Integer.parseInt(sucChua),date);
    }//GEN-LAST:event_ComboFilterOption1ActionPerformed

    private void ComboFilterOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilterOption2ActionPerformed
        String loaiPhong = ComboFilterOption1.getSelectedItem().toString();
        if(loaiPhong.equalsIgnoreCase("Không")){
            loaiPhong = null;
        }
        String sucChua = ComboFilterOption2.getSelectedItem().toString();

        if(sucChua.equalsIgnoreCase("Không")){
            sucChua = "0";
        }
        String date  =getDateChooser();
        loadDSPhongTrong(loaiPhong,Integer.parseInt(sucChua),date);
    }//GEN-LAST:event_ComboFilterOption2ActionPerformed

    private void txt_GioNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GioNhanPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GioNhanPhongActionPerformed

    private void click_NhanPhong(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click_NhanPhong
       LocalDateTime timeNow = LocalDateTime.now();
        String dateChooser = getDateChooser();
            String[] date = dateChooser.split("/");
//            String cbtimetext = txt_GioNhanPhong.getSelectedItem().toString().trim();
//            int hour = Integer.parseInt(cbtimetext.split(":")[0]);
//            int minus = Integer.parseInt(cbtimetext.split(":")[1]);
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
       int hour = Integer.parseInt(txt_GioNhanPhong.getText().split(":")[0]);
       int minus = Integer.parseInt(txt_GioNhanPhong.getText().split(":")[1]);
       LocalDateTime thoiGianDatPhong = LocalDateTime.of(year, month, day, hour, minus);
       // so sanh ngay
       int result = timeNow.compareTo(thoiGianDatPhong);
       PhieuDatPhong pdp =  getPhieuDatPhong();
       dao.DAO_ChiTietPhong_HoaDon dao_ctP_HD = new  DAO_ChiTietPhong_HoaDon();
       DAO_Phong daoPhong = new DAO_Phong();
       entity.HoaDon hd = new HoaDon();
       hd =  I_CRUD.findById(pdp.getHoaDon().getMaHoaDon(), new HoaDon());
       ChitTietPhongHoaDon ctPhongHD = null;
       int isConfirm;
       if(result<0){
            isConfirm = JOptionPane.showConfirmDialog(null, "Xác nhận nhận phòng đặt vào lúc " +LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
            if(isConfirm == 0 ){
                 ctPhongHD = new ChitTietPhongHoaDon(LocalDateTime.now(), null, "Đang sử dụng", hd, I_CRUD.findById(pdp.getPhong().getMaPhong().trim(), new Phong()));
            }
       }
       else{
           isConfirm = JOptionPane.showConfirmDialog(null, "Xác nhận nhận phòng đã đặt trước " +thoiGianDatPhong.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
           if(isConfirm ==0){
            ctPhongHD = new ChitTietPhongHoaDon(thoiGianDatPhong, null, "Đang sử dụng", hd, I_CRUD.findById(pdp.getPhong().getMaPhong().trim(), new Phong()));
           }
       }
        if(isConfirm == 0){
            dao_ctP_HD.themCTHD_PMoi(ctPhongHD);
            
            daoPhong.capNhatTrangThaiPhong(smallPanel.Panel_DanhSachPhongFullCol.codePhong, 2);
       
        }
        
       chooserDate();
    }//GEN-LAST:event_click_NhanPhong

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
            java.util.logging.Logger.getLogger(GD_XuLy_NhanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_NhanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_NhanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_NhanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_NhanPhong().setVisible(true);
            }
        });
    }
                               

    private void chooserDate(){
        // Lấy ngày hiện tại
        Date now = new Date();

        // Lấy ngày từ FilterDate (assumed to be a JDateChooser)
        Date selectedDate = FilterDate.getDate();

        // Chuyển đổi thành LocalDate
        java.time.LocalDate nowLocalDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.time.LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // So sánh chỉ ngày mà không tính thời gian
        if (!selectedLocalDate.equals(nowLocalDate)&&selectedDate.before(now)) {
            JOptionPane.showMessageDialog(null, "Không chọn được ngày trước ngày hiện tại");
            FilterDate.setDate(new Date());
        }
        else{
            
            // call dao
            String loaiPhong = ComboFilterOption1.getSelectedItem().toString();
         if(loaiPhong.equalsIgnoreCase("Không")){
             loaiPhong = null;
         }
         String sucChua = ComboFilterOption2.getSelectedItem().toString();
         
         if(sucChua.equalsIgnoreCase("Không")){
            sucChua = "0";
         }
          String selectDate = getDateChooser();
          loadDSPhongTrong(loaiPhong,Integer.parseInt(sucChua),selectDate);
        }  
    }
    
    public boolean CheckDateNow(){
        // Lấy ngày hiện tại
        Date now = new Date();

        // Lấy ngày từ FilterDate (assumed to be a JDateChooser)
        Date selectedDate = FilterDate.getDate();
        // Chuyển đổi thành LocalDate
        java.time.LocalDate nowLocalDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.time.LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (selectedLocalDate.equals(nowLocalDate)) {
            return true;
        }
        return false;
    }
    
    private static String getDateChooser(){
        
             sdf = new SimpleDateFormat("dd-MM-yyyy");
            formattedDate = sdf.format(FilterDate.getDate());
            day = formattedDate.substring(0, 2);
             month = formattedDate.substring(3, 5);
             year = formattedDate.substring(6, 10);
            return day+"/"+month+"/"+year;
    }
   
    
    smallPanel.Panel_DanhSachPhongFullCol danhSachPhong;
  
    public static void setTienCoc(String maPhong){
        dao.DAO_Phong DAOphong = new  DAO_Phong();
        txt_TienCoc.setText(String.valueOf(DAOphong.getPhongTheoOnlyMaPhong(maPhong).getGiaPhongTheoGio()));
    }
    
    
    
    public static void setTxtThongTinDatPhong(String maPhong){
        dao.DAO_PhieuDatPhong daoPDP = new DAO_PhieuDatPhong();
        PhieuDatPhong pdp = new PhieuDatPhong();
        
        pdp= daoPDP.getPhieuDatPhongByMaPhong(maPhong, getDateChooser());
        txt_SoDT.setText(pdp.getKhachHang().getSoDienThoai());
        txt_khachHang1.setText(pdp.getKhachHang().getTenKhachHang());
        txt_GioNhanPhong.setText(String.format("%02d",pdp.getThoiGianNhanPhong().getHour())+ ":"+String.format("%02d", pdp.getThoiGianNhanPhong().getMinute()));
     }
    
    public PhieuDatPhong getPhieuDatPhong(){
        
        dao.DAO_PhieuDatPhong daoPDP = new DAO_PhieuDatPhong();
        PhieuDatPhong pdp = new PhieuDatPhong();
        pdp= daoPDP.getPhieuDatPhongByMaPhong(smallPanel.Panel_DanhSachPhongFullCol.codePhong, getDateChooser());
        return pdp;
    }
    

     
     
    
private Thread thread = null;
private ArrayList<entity.Phong> listPhongLoc;

private static String formattedDate ;
private static String day ;
private static String  month ;
private static String  year ;
private static SimpleDateFormat sdf;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilterOption1;
    private javax.swing.JComboBox<String> ComboFilterOption2;
    private javax.swing.JPanel ContainerListPhong;
    private javax.swing.JPanel Container_DatPhongNgay;
    private static com.toedter.calendar.JDateChooser FilterDate;
    private javax.swing.JPanel Panel_ThongTinKhachHang;
    private javax.swing.JPanel Panel_ThongTinKhachHang1;
    private javax.swing.JButton btn_HuyDat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lableFilterOption1;
    private javax.swing.JLabel lableFilterOption2;
    private javax.swing.JLabel lableFilterOption3;
    private javax.swing.JPanel locPanel;
    private javax.swing.JPanel locPanel1;
    private javax.swing.JPanel locPanel2;
    private javax.swing.JPanel locPanel3;
    private static javax.swing.JTextField txt_GioNhanPhong;
    private static app.bolivia.swing.JCTextField txt_SoDT;
    private static app.bolivia.swing.JCTextField txt_TienCoc;
    private static app.bolivia.swing.JCTextField txt_khachHang1;
    // End of variables declaration//GEN-END:variables
}
