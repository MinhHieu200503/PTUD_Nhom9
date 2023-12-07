/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_UuDai;
import entity.UuDai;
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
public class GD_QuanLi_UuDai extends javax.swing.JFrame implements I_TraCuu_QuanLi<UuDai>{

    /**
     * Creates new form GD_QuanLi_UuDai
     */
    public GD_QuanLi_UuDai() {
        initComponents();
        model = (DefaultTableModel) tbl_danhSach.getModel();
        setEnableInput(false, jPanel2);
        loadTable(dsud, model);
    }
    public GD_QuanLi_UuDai(int row) {
        initComponents();
        jPanel1.removeHierarchyListener(jPanel1.getHierarchyListeners()[0]);
        model = (DefaultTableModel) tbl_danhSach.getModel();
        setEnableInput(false, jPanel2);
        loadTable(dsud, model);
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
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_chietKhau = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        datechooser_ngayBatDau = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        datechooser_ngayKetThuc = new com.toedter.calendar.JDateChooser();
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
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(290, 1141));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 7));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Mã ưu đãi:");
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        tf_id.setBackground(new java.awt.Color(153, 255, 204));
        tf_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel3.add(tf_id, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel6.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Tên ưu đãi:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.NORTH);

        tf_ten.setBackground(new java.awt.Color(153, 255, 204));
        tf_ten.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel6.add(tf_ten, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(283, 83));
        jPanel13.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Chiết khấu:");
        jPanel13.add(jLabel9, java.awt.BorderLayout.NORTH);

        tf_chietKhau.setBackground(new java.awt.Color(153, 255, 204));
        tf_chietKhau.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel13.add(tf_chietKhau, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel14.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Ngày bắt đầu áp dụng:");
        jPanel14.add(jLabel10, java.awt.BorderLayout.NORTH);

        datechooser_ngayBatDau.setDateFormatString("yyyy-MM-dd");
        datechooser_ngayBatDau.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        datechooser_ngayBatDau.setPreferredSize(new java.awt.Dimension(88, 38));
        jPanel14.add(datechooser_ngayBatDau, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel15.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Ngày kết thúc áp dụng:");
        jPanel15.add(jLabel11, java.awt.BorderLayout.NORTH);

        datechooser_ngayKetThuc.setDateFormatString("yyyy-MM-dd");
        datechooser_ngayKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        datechooser_ngayKetThuc.setPreferredSize(new java.awt.Dimension(88, 38));
        jPanel15.add(datechooser_ngayKetThuc, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel15);

        jPanel4.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("DANH SÁCH ƯU ĐÃI");
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
                "Mã ưu đãi", "Tên ưu đãi", "Giảm giá", "Ngày áp dụng", "Ngày kết thúc áp dụng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                GD_QuanLi_UuDai.this.actionPerformed(evt);
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
                GD_QuanLi_UuDai.this.actionPerformed(evt);
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
                GD_QuanLi_UuDai.this.actionPerformed(evt);
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
                GD_QuanLi_UuDai.this.actionPerformed(evt);
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

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        // TODO add your handling code here:
        Object o = evt.getSource();
        if (o.equals(btn_them)) {
            clearInput(jPanel2);
            if (btn_them.getText().equals("Thêm")) {
                ArrayList<String> dsid = new ArrayList<>();
                for (UuDai i : daoud.getAll(UuDai.class)) {
                    dsid.add(i.getMaUuDai());
                }
                createID(tf_id, dsid, "UD");
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
                if (validateInput()) { // để nhét regex vào
                    String id = tf_id.getText().trim();
                    String ten = tf_ten.getText().trim();
                    Double giamgia = Double.parseDouble(tf_chietKhau.getText().trim());
                    SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
                    String date = d.format(datechooser_ngayBatDau.getDate());
                    LocalDate batdau = LocalDate.parse(date);
                    date = d.format(datechooser_ngayKetThuc.getDate());
                    LocalDate ketthuc = LocalDate.parse(date);
                    
                    UuDai ud = new UuDai(id, ten, giamgia, batdau, ketthuc);
                    if (daoud.create(ud)) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        loadTable(daoud.getAll(UuDai.class), model);
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
                if (validateInput()) {
                    String id = tf_id.getText().trim();
                    String ten = tf_ten.getText().trim();
                    Double giamgia = Double.parseDouble(tf_chietKhau.getText().trim());
                    SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
                    String date = d.format(datechooser_ngayBatDau.getDate());
                    LocalDate batdau = LocalDate.parse(date);
                    date = d.format(datechooser_ngayKetThuc.getDate());
                    LocalDate ketthuc = LocalDate.parse(date);
                    
                    UuDai ud = new UuDai(id, ten, giamgia, batdau, ketthuc);
                    if (daoud.update(ud)) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                        loadTable(daoud.getAll(UuDai.class), model);
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
    }//GEN-LAST:event_actionPerformed

    private void tbl_danhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachMouseClicked
        // TODO add your handling code here:
        int i = tbl_danhSach.getSelectedRow();
        if (i != -1) {
            showDetailInput(jPanel2, model, i);
        }
    }//GEN-LAST:event_tbl_danhSachMouseClicked

    private void jPanel1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanel1HierarchyChanged
        // TODO add your handling code here:
        if (model != null)
            loadTable(daoud.getAll(UuDai.class), model);
    }//GEN-LAST:event_jPanel1HierarchyChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (GD_TraCuu_UuDai.model != null) 
            loadTable(daoud.getAll(UuDai.class), GD_TraCuu_UuDai.model);
        else
            System.out.println("chưa mở giao diện tra cứu ưu đãi");
    }//GEN-LAST:event_formWindowClosing
    private boolean validateInput() {
        String ten = tf_ten.getText().trim();
        String chietkhau = tf_chietKhau.getText().trim();
        Date start = datechooser_ngayBatDau.getDate();
        Date end = datechooser_ngayKetThuc.getDate();
        if (ten.isEmpty()) {
            showRegexError(tf_ten, "Tên không được rỗng");
            return false;
        }
        if (ten.length() > 30) {
            showRegexError(tf_ten, "Tên không được quá 30 kí tự");
            return false;
        }
        if (!ten.matches("^[A-ZÀ-Ỹ]([A-ZÀ-Ỹa-zà-ỹ\\d]*\\s?)+$")) {
            showRegexError(tf_ten, "Viết hoa kí tự đầu, không bao gồm kí tự đặc biệt");
            return false;
        }
        if (chietkhau.isEmpty()) {
            showRegexError(tf_chietKhau, "Chiết khấu không được rỗng");
            return false;
        }
        if (!chietkhau.matches("^[0-1](\\.[0-9]+)?$")) {
            showRegexError(tf_chietKhau, "Chiết khấu nằm trong đoạn 0 tới 1");
            return false;
        }
        SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
        String d;
        if (start == null) {
            JOptionPane.showMessageDialog(null, "Phải chọn ngày bắt đầu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        d = date.format(start);
        LocalDate ngaybatdau = LocalDate.parse(d);
        if (ngaybatdau.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải sau ngày hiện tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (end == null) {
            JOptionPane.showMessageDialog(null, "Phải chọn ngày kết thúc", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        d = date.format(end);
        LocalDate ngayketthuc = LocalDate.parse(d);
        if (ngayketthuc.isBefore(ngaybatdau)) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc phải sau ngày bắt đầu", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(GD_QuanLi_UuDai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_UuDai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_UuDai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_UuDai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLi_UuDai().setVisible(true);
            }
        });
    }
    
    private DAO_UuDai daoud = new DAO_UuDai();
    private ArrayList<UuDai> dsud = daoud.getAll(UuDai.class);
    private DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoaTrang;
    private com.toedter.calendar.JDateChooser datechooser_ngayBatDau;
    private com.toedter.calendar.JDateChooser datechooser_ngayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_danhSach;
    private javax.swing.JTextField tf_chietKhau;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_ten;
    // End of variables declaration//GEN-END:variables
}
