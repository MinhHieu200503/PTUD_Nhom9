/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_Phong;
import entity.Phong;
import java.awt.BorderLayout;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.I_CRUD;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.UuDai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static smallPanel.Panel_DanhSachPhongFullCol.codePhong;
/**
 *
 * @author Minh Hieu
 */
public class GD_XuLy_DatPhongTruoc extends javax.swing.JFrame {

    /**
     * Creates new form GD_XuLy_DatPhongTruoc
     */
    public GD_XuLy_DatPhongTruoc() {
//        thread = new Thread((Runnable) this);
//        thread.start();
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
        tuDongTimKiemKhachHang();
    }
    
    private void loadDSPhongTrong(String loaiPhong,int sucChua,String date){
        ContainerListPhong.removeAll();
        
         dao.DAO_Phong dao_phong = new DAO_Phong();
         ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
         ArrayList<entity.Phong> listPhong1 = new ArrayList<entity.Phong>();
         listPhong = dao_phong.getAll(Phong.class);
        
        if(loaiPhong == null && sucChua == 0&&date==null){
            listPhong1 = dao_phong.getPhongTheoTrangThai(0);
            danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_DatPhongTruoc.class);
            ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
            ContainerListPhong.getComponent(0).setBackground(Color.white);
        }
        else{
            listPhong1 = dao_phong.getPhongTheoDieuKien(loaiPhong,sucChua,0,date);
            danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_DatPhongTruoc.class);
            ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
            ContainerListPhong.getComponent(0).setBackground(Color.white);
        }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container_DatPhongNgay = new javax.swing.JPanel();
        ContainerListPhong = new javax.swing.JPanel();
        Panel_ThongTinKhachHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_GioNhanPhong = new javax.swing.JComboBox<>();
        txt_TienCoc = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        Panel_ThongTinKhachHang1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_SoDT = new javax.swing.JComboBox<>();
        txt_khachHang = new app.bolivia.swing.JCTextField();
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
        ContainerListPhong.setLayout(new java.awt.BorderLayout());
        Container_DatPhongNgay.add(ContainerListPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 900, 860));

        Panel_ThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Giờ nhận phòng:");

        cb_GioNhanPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", " ", " " }));

        txt_TienCoc.setEditable(false);
        txt_TienCoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Tiền cọc : ");

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_TienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_GioNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_ThongTinKhachHangLayout.setVerticalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_GioNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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

        txt_SoDT.setEditable(true);
        txt_SoDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_SoDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", " " }));

        txt_khachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                    .addComponent(txt_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(txt_SoDT, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Panel_ThongTinKhachHang1Layout.setVerticalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 650, 210));

        btn_HuyDat.setBackground(new java.awt.Color(0, 204, 204));
        btn_HuyDat.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_HuyDat.setForeground(new java.awt.Color(255, 255, 255));
        btn_HuyDat.setText("ĐẶT PHÒNG NGAY");
        btn_HuyDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click_DatPhong(evt);
            }
        });
        Container_DatPhongNgay.add(btn_HuyDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 480, 420, 60));

        locPanel.setBackground(new java.awt.Color(255, 255, 255));
        locPanel.setMaximumSize(new java.awt.Dimension(1080, 84));
        locPanel.setMinimumSize(new java.awt.Dimension(1080, 84));
        locPanel.setPreferredSize(new java.awt.Dimension(1080, 84));

        locPanel1.setBackground(new java.awt.Color(255, 255, 255));
        locPanel1.setMaximumSize(new java.awt.Dimension(330, 73));
        locPanel1.setMinimumSize(new java.awt.Dimension(330, 73));
        locPanel1.setPreferredSize(new java.awt.Dimension(330, 73));

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
        locPanel2.setPreferredSize(new java.awt.Dimension(330, 73));

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
        locPanel3.setPreferredSize(new java.awt.Dimension(330, 73));

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
                .addComponent(locPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void click_DatPhong(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click_DatPhong
        JOptionPane.showMessageDialog(rootPane, "Bam Dat");
        int soLuongHoaDon = 0;
        dao.DAO_HoaDon DAOHoaDon = new DAO_HoaDon();
        dao.DAO_KhachHang DAOKhachHang = new DAO_KhachHang();
        soLuongHoaDon = DAOHoaDon.laySoLuongHoaDon()+1;
        ArrayList<entity.KhachHang> listKH = DAOKhachHang.getAllKhachHang();
        entity.HoaDon hoaDon = new HoaDon();
        String maHoaDon = null;
        if(soLuongHoaDon<10){
            maHoaDon = ("HD00"+soLuongHoaDon);
        }
        else if(soLuongHoaDon<100){
            maHoaDon=("HD0"+soLuongHoaDon);
        }
        else{
            maHoaDon=("HD"+soLuongHoaDon);
        }
        hoaDon.setMaHoaDon(maHoaDon);
        hoaDon.setNgayLapHoaDon( LocalDateTime.now());
        hoaDon.setNhanVien(I_CRUD.findById("NV001",new NhanVien()));
        hoaDon.setTrangThai(0);
        hoaDon.setUuDai(I_CRUD.findById("UD001", new UuDai()));
        boolean isHasKH = false;
        for(int i = 0;i<listKH.size();i++){
            if(listKH.get(i).getSoDienThoai().trim().equals( String.valueOf(txt_SoDT.getSelectedItem()).trim())){
                hoaDon.setKhachHang(listKH.get(i));
                isHasKH = true;
            }
        }
        if(isHasKH == false){
            DAOKhachHang.create(new KhachHang( String.valueOf(txt_SoDT.getSelectedItem()).trim(),txt_khachHang.getText()));
        }

        boolean taoHoaDonStatus = DAOHoaDon.create(hoaDon);
        if(taoHoaDonStatus==true){
            PhieuDatPhong pdp = new PhieuDatPhong();
            
            //tao ma phieu
            ArrayList<PhieuDatPhong> lsPdp = new ArrayList<>();
            dao.DAO_PhieuDatPhong daoPdp = new  dao.DAO_PhieuDatPhong();
            lsPdp = daoPdp.getAll(PhieuDatPhong.class);
            ArrayList<String> dsId = new ArrayList<>();
            for(PhieuDatPhong PhieuDat: lsPdp){
                dsId.add(PhieuDat.getMaPhieuDatPhong());
            }
            String lastID = dsId.get(lsPdp.size() - 1).toString();
                // tách chuỗi để lấy số thứ tự
            int index = Integer.parseInt(lastID.substring(3)) + 1;
            //tự động tạo mã hóa đơn mới
            String newID = "DPT" + String.format("%03d", index);
            // lay thoi gian nhan phong
            
            String dateChooser = getDateChooser();
            String[] date = dateChooser.split("/");
            String cbtimetext = cb_GioNhanPhong.getSelectedItem().toString().trim();
            int hour = Integer.parseInt(cbtimetext.split(":")[0]);
            int minus = Integer.parseInt(cbtimetext.split(":")[1]);
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            int second = 0;
            // tiep tuc insert8
            pdp.setMaPhieuDatPhong(newID);
            pdp.setThoiGianTaoPhieu(LocalDateTime.now());
            pdp.setThoiGianNhanPhong( LocalDateTime.of(year, month, day, hour, minus,second));
            pdp.setTrangThai(0);
            pdp.setDatCoc(Double.valueOf(txt_TienCoc.getText()));
            pdp.setHoaDon(I_CRUD.findById(maHoaDon, new HoaDon()));
            pdp.setNhanVien(I_CRUD.findById("NV001",new NhanVien()));
            pdp.setKhachHang(I_CRUD.findById(String.valueOf(txt_SoDT.getSelectedItem()).trim(), new KhachHang()));
            pdp.setPhong(I_CRUD.findById(smallPanel.Panel_DanhSachPhongFullCol.codePhong, new Phong()));
            
            daoPdp.create(pdp);
            if(CheckDateNow()==true){
                dao.DAO_Phong daoPhong = new DAO_Phong();
                daoPhong.capNhatTrangThaiPhong(pdp.getPhong().getMaPhong(), 1);
            }
        }
        loadDSPhongTrong(null, 0,getDateChooser() );
    }//GEN-LAST:event_click_DatPhong

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
            JOptionPane.showMessageDialog(null, " ngày hiện tại");
            return true;
        }
        return false;
    }
    
    private String getDateChooser(){
        
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = sdf.format(FilterDate.getDate());
            String day = formattedDate.substring(0, 2);
            String month = formattedDate.substring(3, 5);
            String year = formattedDate.substring(6, 10);
            return day+"/"+month+"/"+year;
    }
   
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
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_DatPhongTruoc().setVisible(true);
            }
        });
    }
    smallPanel.Panel_DanhSachPhongFullCol danhSachPhong;
  
    public static void setTienCoc(String maPhong){
        dao.DAO_Phong DAOphong = new  DAO_Phong();
        txt_TienCoc.setText(String.valueOf(DAOphong.getPhongTheoOnlyMaPhong(maPhong).getGiaPhongTheoGio()));
    }
    
    public void tuDongTimKiemKhachHang(){
        txt_SoDT.removeAllItems();
        txt_SoDT.addItem("");
        DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		// tự động kiểm tra
        AutoCompleteDecorator.decorate(txt_SoDT);
        txt_SoDT.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        if (txt_SoDT.getSelectedItem() != null) {
                                String soDT = txt_SoDT.getSelectedItem().toString().trim();
                                kiemTraSDT(soDT);
                        }
                }
        });
        for (KhachHang kH : dao_KhachHang.getAll(KhachHang.class)) {
                txt_SoDT.addItem(kH.getSoDienThoai());
        }
    }
    
     public boolean kiemTraSDT(String soDT) {
            
		KhachHang khachHang = I_CRUD.findById(soDT, new KhachHang());
		if (khachHang != null) {
			
			txt_khachHang.setText(khachHang.getTenKhachHang());
			
			return false;
		}
		
		txt_khachHang.setText("");
		
		return true;
	}
    
private Thread thread = null;
private ArrayList<entity.Phong> listPhongLoc;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilterOption1;
    private javax.swing.JComboBox<String> ComboFilterOption2;
    private javax.swing.JPanel ContainerListPhong;
    private javax.swing.JPanel Container_DatPhongNgay;
    private com.toedter.calendar.JDateChooser FilterDate;
    private javax.swing.JPanel Panel_ThongTinKhachHang;
    private javax.swing.JPanel Panel_ThongTinKhachHang1;
    private javax.swing.JButton btn_HuyDat;
    private javax.swing.JComboBox<String> cb_GioNhanPhong;
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
    private javax.swing.JComboBox<String> txt_SoDT;
    private static app.bolivia.swing.JCTextField txt_TienCoc;
    private app.bolivia.swing.JCTextField txt_khachHang;
    // End of variables declaration//GEN-END:variables
}
