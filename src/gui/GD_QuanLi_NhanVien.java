/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_Ca;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import entity.Ca;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author quang 
 */
public class GD_QuanLi_NhanVien extends javax.swing.JFrame implements I_TraCuu_QuanLi<NhanVien>{

    /**
     * Creates new form GD_QuanLiNhanVien
     */
    public GD_QuanLi_NhanVien() {
        initComponents();
        model = (DefaultTableModel) tbl_danhSach.getModel();
        setEnableInput(false, jPanel2);
        loadTable(daonv.getAll(NhanVien.class), model);;
    }
    public GD_QuanLi_NhanVien( int row) {
        initComponents();
        jPanel1.removeHierarchyListener(jPanel1.getHierarchyListeners()[0]);
        model = (DefaultTableModel) tbl_danhSach.getModel();
        setEnableInput(false, jPanel2);
        loadTable(daonv.getAll(NhanVien.class), model);
        tbl_danhSach.setRowSelectionInterval(row, row);
        showDetailInput(jPanel2, model, row);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_ten = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        datechooser_ngaySinh = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_gioiTinh = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_cmnd = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_diaChi = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tf_phone = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cb_trangThai = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_gmail = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_ca = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cb_vaiTro = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel21 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pf_matKhau = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhSach = new rojeru_san.complementos.RSTableMetro();
        jPanel20 = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_xoaTrang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 763));
        jPanel1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jPanel1HierarchyChanged(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 10, 10, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(290, 1141));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Mã nhân viên:");
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        tf_id.setBackground(new java.awt.Color(153, 255, 204));
        tf_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel3.add(tf_id, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(281, 75));
        jPanel6.setMinimumSize(new java.awt.Dimension(281, 75));
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 83));
        jPanel6.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Tên nhân viên:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.NORTH);

        tf_ten.setBackground(new java.awt.Color(153, 255, 204));
        tf_ten.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel6.add(tf_ten, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel7.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Ngày sinh:");
        jPanel7.add(jLabel3, java.awt.BorderLayout.NORTH);

        datechooser_ngaySinh.setDateFormatString("yyyy-MM-dd");
        datechooser_ngaySinh.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        datechooser_ngaySinh.setPreferredSize(new java.awt.Dimension(160, 38));
        jPanel7.add(datechooser_ngaySinh, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(281, 38));
        jPanel8.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Giới tính");
        jPanel8.add(jLabel4, java.awt.BorderLayout.WEST);

        cb_gioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cb_gioiTinh.setPreferredSize(new java.awt.Dimension(160, 38));
        jPanel8.add(cb_gioiTinh, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(141, 46));
        jPanel9.setPreferredSize(new java.awt.Dimension(281, 47));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("CMND:");
        jPanel9.add(jLabel5, java.awt.BorderLayout.WEST);

        tf_cmnd.setBackground(new java.awt.Color(153, 255, 204));
        tf_cmnd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_cmnd.setPreferredSize(new java.awt.Dimension(200, 38));
        jPanel9.add(tf_cmnd, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel10.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Địa chỉ:");
        jPanel10.add(jLabel6, java.awt.BorderLayout.NORTH);

        tf_diaChi.setBackground(new java.awt.Color(153, 255, 204));
        tf_diaChi.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel10.add(tf_diaChi, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel11.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Số điện thoại:");
        jPanel11.add(jLabel7, java.awt.BorderLayout.NORTH);

        tf_phone.setBackground(new java.awt.Color(153, 255, 204));
        tf_phone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel11.add(tf_phone, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel11);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(281, 38));
        jPanel13.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Trạng thái:");
        jPanel13.add(jLabel9, java.awt.BorderLayout.WEST);

        cb_trangThai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Đã nghỉ" }));
        cb_trangThai.setPreferredSize(new java.awt.Dimension(160, 38));
        jPanel13.add(cb_trangThai, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel13);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(281, 47));
        jPanel12.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("gmail:");
        jPanel12.add(jLabel8, java.awt.BorderLayout.WEST);

        tf_gmail.setBackground(new java.awt.Color(153, 255, 204));
        tf_gmail.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel12.add(tf_gmail, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel12);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(281, 38));
        jPanel15.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Ca:");
        jPanel15.add(jLabel11, java.awt.BorderLayout.WEST);

        cb_ca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_ca.setPreferredSize(new java.awt.Dimension(160, 38));
        jPanel15.add(cb_ca, java.awt.BorderLayout.EAST);
        ArrayList<Ca> dsca = daoca.getAll(Ca.class);
        dsca.forEach(e -> {
            cb_ca.addItem(e.getTenCa());
        });

        jPanel2.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(281, 38));
        jPanel16.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Vai trò:");
        jPanel16.add(jLabel12, java.awt.BorderLayout.WEST);

        cb_vaiTro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_vaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lí" }));
        jPanel16.add(cb_vaiTro, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel16);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 204));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 204));
        jSeparator2.setPreferredSize(new java.awt.Dimension(281, 3));
        jPanel2.add(jSeparator2);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel21.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Mật khẩu:");
        jPanel21.add(jLabel15, java.awt.BorderLayout.PAGE_START);

        pf_matKhau.setBackground(new java.awt.Color(153, 255, 204));
        pf_matKhau.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel21.add(pf_matKhau, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel21);

        jPanel4.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("DANH SÁCH NHÂN VIÊN");
        jPanel18.add(jLabel14);

        jPanel5.add(jPanel18, java.awt.BorderLayout.NORTH);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));
        jPanel19.setPreferredSize(new java.awt.Dimension(1511, 1200));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setColumnHeaderView(null);

        tbl_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "CMND", "Địa chỉ", "Số điện thoại", "Trạng thái", "Gmail", "Ca"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_danhSach.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tbl_danhSach.setColorBordeFilas(new java.awt.Color(0, 153, 153));
        tbl_danhSach.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tbl_danhSach.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tbl_danhSach.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_danhSach.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_danhSach.setRowHeight(30);
        tbl_danhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_danhSach.getTableHeader().setReorderingAllowed(false);
        tbl_danhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_danhSach);

        jPanel19.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel20.setPreferredSize(new java.awt.Dimension(1520, 80));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        btn_them.setBackground(new java.awt.Color(0, 153, 153));
        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_add30.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jPanel20.add(btn_them);

        btn_sua.setBackground(new java.awt.Color(0, 153, 153));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_edit30.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jPanel20.add(btn_sua);

        btn_luu.setBackground(new java.awt.Color(0, 153, 153));
        btn_luu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_save30.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.setEnabled(false);
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jPanel20.add(btn_luu);

        btn_xoaTrang.setBackground(new java.awt.Color(0, 153, 153));
        btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_xoaTrang.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_clear30.png"))); // NOI18N
        btn_xoaTrang.setText("Xoá trắng");
        btn_xoaTrang.setEnabled(false);
        btn_xoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jPanel20.add(btn_xoaTrang);

        jPanel5.add(jPanel20, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformed
        // TODO add your handling code here:
        Object o = evt.getSource();
        if (o.equals(btn_them)) {
            ArrayList<String> dsid = new ArrayList<>();
                for (NhanVien i : daonv.getAll(NhanVien.class)) {
                    dsid.add(i.getMaNhanVien());
                }
            createID(tf_id, dsid, "NV");
            clearInput(jPanel2);
            if (btn_them.getText().equals("Thêm")) {
                tbl_danhSach.clearSelection();
                tbl_danhSach.setEnabled(false);
                setEnableInput(true, jPanel2);
                btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chuyenPhong_huy30.png")));
                btn_them.setText("Huỷ");
                btn_sua.setEnabled(false);
                btn_luu.setEnabled(true);
                btn_xoaTrang.setEnabled(true);
            } else {
                clearInput(jPanel2);
                tbl_danhSach.setEnabled(true);
                tf_id.setText("");
                setEnableInput(false, jPanel2);
                btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_add30.png")));
                btn_them.setText("Thêm");
                btn_sua.setEnabled(true);
                btn_luu.setEnabled(false);
                btn_xoaTrang.setEnabled(false);
            }
        } else if (o.equals(btn_sua)) {
            int r = tbl_danhSach.getSelectedRow();
            if (r != -1) {
                if (btn_sua.getText().equals("Sửa")) {
                    tbl_danhSach.setEnabled(false);
                    setEnableInput(true, jPanel2);
                    btn_sua.setText("Huỷ");
                    btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chuyenPhong_huy30.png")));
                    btn_them.setEnabled(false);
                    btn_luu.setEnabled(true);
                    btn_xoaTrang.setEnabled(true);
                } else {
                    tbl_danhSach.clearSelection();
                    tbl_danhSach.setEnabled(true);
                    clearInput(jPanel2);
                    tf_id.setText("");
                    setEnableInput(false, jPanel2);
                    btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_edit30.png")));
                    btn_sua.setText("Sửa");
                    btn_them.setEnabled(true);
                    btn_luu.setEnabled(false);
                    btn_xoaTrang.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hãy chọn dòng");
            }
        } else if (o.equals(btn_luu)) {
            if (btn_them.getText().equals("Huỷ")) {
                if (validateInput(btn_luu)) { // để nhét regex vào
                    String id = tf_id.getText().trim();
                    String ten = tf_ten.getText().trim();
                    SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
                    String d = date.format(datechooser_ngaySinh.getDate());
                    LocalDate ngaySinh = LocalDate.parse( d);
                    boolean gioiTinh = cb_gioiTinh.getSelectedItem().toString().equals("Nam");
                    String cmnd = tf_cmnd.getText().trim();
                    String diaChi = tf_diaChi.getText().trim();
                    String sdt = tf_phone.getText().trim();
                    boolean trangThai = cb_trangThai.getSelectedItem().toString().equals("Đang làm");
                    String gmail = tf_gmail.getText().trim();
//                    ChucVu chucVu = daocv.getChucVuTheoTen(cb_chucVu.getSelectedItem().toString());
                    Ca ca = daoca.getCaTheoTen(cb_ca.getSelectedItem().toString());
                    
                    NhanVien nv = new NhanVien(id, ten, ngaySinh, gioiTinh, cmnd, diaChi, sdt, trangThai, gmail, ca);
                    TaiKhoan tk = new TaiKhoan(sdt, String.valueOf(pf_matKhau.getPassword()), cb_vaiTro.getSelectedItem().equals("Quản lí"), nv);
                    if (daonv.create(nv)&& daotk.create(tk)) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        loadTable(daonv.getAll(NhanVien.class), model);
                        clearInput(jPanel2);
                        tbl_danhSach.setEnabled(true);
                        tf_id.setText("");
                        setEnableInput(false, jPanel2);
                        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_add30.png")));
                        btn_them.setText("Thêm");
                        btn_sua.setEnabled(true);
                        btn_luu.setEnabled(false);
                        btn_xoaTrang.setEnabled(false);
                    }
                }
            }
            if (btn_sua.getText().equals("Huỷ")) {
                if (validateInput(btn_sua)) {
                    String id = tf_id.getText().trim();
                    String ten = tf_ten.getText().trim();
                    SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
                    String d = date.format(datechooser_ngaySinh.getDate());
                    LocalDate ngaySinh = LocalDate.parse( d);
                    boolean gioiTinh = cb_gioiTinh.getSelectedItem().toString().equals("Nam");
                    String cmnd = tf_cmnd.getText().trim();
                    String diaChi = tf_diaChi.getText().trim();
                    String sdt = tf_phone.getText().trim();
                    boolean trangThai = cb_trangThai.getSelectedItem().toString().equals("Đang làm");
                    String gmail = tf_gmail.getText().trim();
//                    ChucVu chucVu = daocv.getChucVuTheoTen(cb_chucVu.getSelectedItem().toString());
                    Ca ca = daoca.getCaTheoTen(cb_ca.getSelectedItem().toString());
                    
                    NhanVien nv = new NhanVien(id, ten, ngaySinh, gioiTinh, cmnd, diaChi, sdt, trangThai, gmail, ca);
                    TaiKhoan tk = new TaiKhoan(sdt, String.valueOf(pf_matKhau.getPassword()), cb_vaiTro.getSelectedItem().equals("Quản lí"), nv);
                    if (daonv.update(nv) && daotk.updateTK(tk)) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                        loadTable(daonv.getAll(NhanVien.class), model);
                        tbl_danhSach.clearSelection();
                        tbl_danhSach.setEnabled(true);
                        clearInput(jPanel2);
                        tf_id.setText("");
                        setEnableInput(false, jPanel2);
                        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_edit30.png")));
                        btn_sua.setText("Sửa");
                        btn_them.setEnabled(true);
                        btn_luu.setEnabled(false);
                        btn_xoaTrang.setEnabled(false);
                    }
                }
            }
        } else if (o.equals(btn_xoaTrang)) {
            clearInput(jPanel2);
        }
        
    }//GEN-LAST:event_ActionPerformed

    private void tbl_danhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachMouseClicked
        // TODO add your handling code here:
        int i = tbl_danhSach.getSelectedRow();
        if (i != -1) {
            showDetailInput(jPanel2, model, i);
        }
    }//GEN-LAST:event_tbl_danhSachMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (GD_TraCuu_NhanVien.model != null)
            loadTable(daonv.getAll(NhanVien.class), GD_TraCuu_NhanVien.model);
        else 
            System.out.println("chưa mở giao diện tra cứu nhân viên");
    }//GEN-LAST:event_formWindowClosing

    private void jPanel1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel1HierarchyChanged
        // TODO add your handling code here:
        if (model != null)
            loadTable(daonv.getAll(NhanVien.class), model);
        ArrayList<Ca> dsca = daoca.getAll(Ca.class);
        cb_ca.removeAllItems();
        dsca.forEach(e -> {
            cb_ca.addItem(e.getTenCa());
        });
    }//GEN-LAST:event_jPanel1HierarchyChanged
    private boolean validateInput(Object o) {
        String ten = tf_ten.getText().trim();
        Date ngaysinh = datechooser_ngaySinh.getDate();
        String cmnd = tf_cmnd.getText().trim();
        String diachi = tf_diaChi.getText().trim();
        String phone = tf_phone.getText().trim();
        String gmail = tf_gmail.getText().trim();
        String pw = String.valueOf(pf_matKhau.getPassword());
        if (ten.isEmpty()) {
            showRegexError(tf_ten, "Tên không được rỗng");
            return false;
        }
        if (ten.length() > 30) {
            showRegexError(tf_ten, "Tên không được quá 30 kí tự");
            return false;
        }
        if (!ten.matches("^[A-ZÀ-Ỹ][a-zà-ỹ]+(\\s[A-ZÀ-Ỹ][a-zà-ỹ]+)+$")) {
            showRegexError(tf_ten, "Mỗi kí tự đầu của từ phải viết Hoa, không bao gồm chữ số và kí tự đặc biệt");
            return false;
        }
        if (ngaysinh == null) {
            JOptionPane.showMessageDialog(null, "Phải chọn ngày sinh", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
        String d = date.format(ngaysinh);
        LocalDate namsinh = LocalDate.parse(d);
        if (LocalDate.now().getYear() - namsinh.getYear() < 18) {
            JOptionPane.showMessageDialog(null, "Phải từ 18 tuổi trở lên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cmnd.isEmpty()) {
            showRegexError(tf_cmnd, "CMND không được rỗng");
            return false;
        }
        if (!cmnd.matches("^0\\d{11}$")) {
            showRegexError(tf_cmnd, "CMND bắt đầu bằng số 0, phải đủ 12 chữ số");
            return false;
        }
        if (diachi.isEmpty()) {
            showRegexError(tf_diaChi, "Địa chỉ không được rỗng");
            return false;
        }
        if (phone.isEmpty()) {
            showRegexError(tf_phone, "Vui lòng nhập số điện thoại");
            return false;
        }
        if (!phone.matches("^0[1-9]\\d{8}$")) {
            showRegexError(tf_phone, "Số điện thoại bắt đầu bằng chữ số 0 và có tối đa 10 chữ số");
            return false;
        }
        if (o.equals(btn_sua)) {
            int row = tbl_danhSach.getSelectedRow();
            ArrayList<NhanVien> ds = daonv.getAll(NhanVien.class);
            for (NhanVien i : ds) {
                if (!i.getSoDienThoai().equals(model.getValueAt(row, 6)) && i.getSoDienThoai().equals(phone)) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không được trùng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } else {
            ArrayList<NhanVien> ds = daonv.getAll(NhanVien.class);
            for (NhanVien i : ds) {
                if (i.getSoDienThoai().equals(phone)) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không được trùng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        
        if (gmail.isEmpty()) {
            showRegexError(tf_gmail, "Gmail không được rỗng");
            return false;
        }
        if (!gmail.matches("^[a-zA-Z0-9.]+@gmail\\.com$")) {
            showRegexError(tf_gmail, "Tên gmail chứa số, các chữ cái từ a - z, không chứa kí tự đặc biệt và tên miền phải là @gmail.com");
            return false;
        }
        if (pw.isEmpty()) {
            showRegexError(pf_matKhau, "Vui lòng nhập mật khẩu");
            return false;
        }
        if (!pw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$#!%*?&]{6,}$")) { // (?=...x) tìm chuỗi đứng trước x, "..." là định dạng khớp vs chuỗi cần tìm
            showRegexError(pf_matKhau, "Mật khẩu có ít nhất 6 kí tự, bao gồm chữ Hoa, chữ thường, chữ số và kí tự đặc biệt");
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(GD_QuanLi_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLi_NhanVien().setVisible(true);
            }
        });
    }
    private DAO_NhanVien daonv = new DAO_NhanVien();
    private DAO_Ca daoca = new DAO_Ca();
    private DAO_TaiKhoan daotk = new DAO_TaiKhoan();
    private ArrayList<NhanVien> dsnv = daonv.getAll(NhanVien.class);
    private DefaultTableModel model;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoaTrang;
    private javax.swing.JComboBox<String> cb_ca;
    private javax.swing.JComboBox<String> cb_gioiTinh;
    private javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JComboBox<String> cb_vaiTro;
    private com.toedter.calendar.JDateChooser datechooser_ngaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField pf_matKhau;
    private rojeru_san.complementos.RSTableMetro tbl_danhSach;
    private javax.swing.JTextField tf_cmnd;
    private javax.swing.JTextField tf_diaChi;
    private javax.swing.JTextField tf_gmail;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_phone;
    private javax.swing.JTextField tf_ten;
    // End of variables declaration//GEN-END:variables
}
