/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author quang
 */
public class GD_QuanLi_Phong extends javax.swing.JFrame {

    /**
     * Creates new form GD_QuanLi_Phong
     */
    public GD_QuanLi_Phong() {
        initComponents();
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
        cb_trangThai = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cb_loai = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_sucChua = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        tf_gia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhSach = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_xoaTrang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(142, 172, 207));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 763));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel2.setPreferredSize(new java.awt.Dimension(290, 1141));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 7));

        jPanel3.setPreferredSize(new java.awt.Dimension(283, 75));
        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Mã phòng:");
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        tf_id.setBackground(new java.awt.Color(142, 172, 207));
        tf_id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_id.setText(".......");
        tf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idActionPerformed(evt);
            }
        });
        jPanel3.add(tf_id, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel6.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel6.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Tên phòng:");
        jPanel6.add(jLabel2, java.awt.BorderLayout.NORTH);

        tf_ten.setBackground(new java.awt.Color(142, 172, 207));
        tf_ten.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel6.add(tf_ten, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel13.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel13.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Trạng thái:");
        jPanel13.add(jLabel9, java.awt.BorderLayout.NORTH);

        cb_trangThai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Đang hoạt động", "Chưa sẵn sàng, ", "Đang chờ, ", "Không sử dụng.", " " }));
        cb_trangThai.setPreferredSize(new java.awt.Dimension(160, 38));
        cb_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_trangThaiActionPerformed(evt);
            }
        });
        jPanel13.add(cb_trangThai, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel13);

        jPanel14.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel14.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Loại:");
        jPanel14.add(jLabel10, java.awt.BorderLayout.NORTH);

        cb_loai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thường", "VIP" }));
        cb_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_loaiActionPerformed(evt);
            }
        });
        jPanel14.add(cb_loai, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel14);

        jPanel15.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel15.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Sức chứa:");
        jPanel15.add(jLabel11, java.awt.BorderLayout.NORTH);

        cb_sucChua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cb_sucChua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", " ", " " }));
        cb_sucChua.setPreferredSize(new java.awt.Dimension(160, 38));
        jPanel15.add(cb_sucChua, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel15);

        jPanel16.setPreferredSize(new java.awt.Dimension(281, 75));
        jPanel16.setLayout(new java.awt.BorderLayout(0, 5));

        tf_gia.setBackground(new java.awt.Color(142, 172, 207));
        tf_gia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_gia.setText("30.000");
        tf_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_giaActionPerformed(evt);
            }
        });
        jPanel16.add(tf_gia, java.awt.BorderLayout.CENTER);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Giá mỗi giờ:");
        jPanel16.add(jLabel12, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel16);

        jPanel4.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(40, 77, 133));
        jLabel14.setText("DANH SÁCH PHÒNG");
        jPanel18.add(jLabel14);

        jPanel5.add(jPanel18, java.awt.BorderLayout.NORTH);

        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));
        jPanel19.setPreferredSize(new java.awt.Dimension(1511, 1200));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {".....", "", "", "", "", "VN"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Trạng thái", "Loại phòng ", "Sức chứa", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_danhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_danhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_danhSach.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_danhSach);

        jPanel19.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel20.setPreferredSize(new java.awt.Dimension(1520, 80));
        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        btn_them.setBackground(new java.awt.Color(40, 77, 133));
        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_add30.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel20.add(btn_them);

        btn_sua.setBackground(new java.awt.Color(40, 77, 133));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_edit30.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel20.add(btn_sua);

        btn_luu.setBackground(new java.awt.Color(40, 77, 133));
        btn_luu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_save30.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });
        jPanel20.add(btn_luu);

        btn_xoaTrang.setBackground(new java.awt.Color(40, 77, 133));
        btn_xoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_xoaTrang.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_clear30.png"))); // NOI18N
        btn_xoaTrang.setText("Xoá trắng");
        btn_xoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaTrangActionPerformed(evt);
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

    private void tf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idActionPerformed

    private void cb_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_trangThaiActionPerformed

    private void cb_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_loaiActionPerformed

    private void tf_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_giaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_xoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaTrangActionPerformed

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
            java.util.logging.Logger.getLogger(GD_QuanLi_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLi_Phong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoaTrang;
    private javax.swing.JComboBox<String> cb_loai;
    private javax.swing.JComboBox<String> cb_sucChua;
    private javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_danhSach;
    private javax.swing.JTextField tf_gia;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_ten;
    // End of variables declaration//GEN-END:variables
}
