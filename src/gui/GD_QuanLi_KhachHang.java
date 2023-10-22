/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author quang
 */
public class GD_QuanLi_KhachHang extends javax.swing.JFrame {

    /**
     * Creates new form GD_QuanLiKhachHang
     */
    public GD_QuanLi_KhachHang() {
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

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_phone = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_ten = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhSach = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_xoaTrang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(142, 172, 207));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel9.setPreferredSize(new java.awt.Dimension(1920, 763));

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel11.setPreferredSize(new java.awt.Dimension(290, 1141));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 7));

        jPanel12.setPreferredSize(new java.awt.Dimension(283, 75));
        jPanel12.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Số điện thoại:");
        jPanel12.add(jLabel3, java.awt.BorderLayout.NORTH);

        tf_phone.setBackground(new java.awt.Color(142, 172, 207));
        tf_phone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_phone.setText(".......");
        tf_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_phoneActionPerformed(evt);
            }
        });
        jPanel12.add(tf_phone, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Tên khách hàng:");
        jPanel13.add(jLabel4, java.awt.BorderLayout.NORTH);

        tf_ten.setBackground(new java.awt.Color(142, 172, 207));
        tf_ten.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_ten.setText("Nguyễn Hồ Đăng Quang");
        jPanel13.add(tf_ten, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel13);

        jPanel10.add(jPanel11);

        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(40, 77, 133));
        jLabel15.setText("DANH SÁCH KHÁCH HÀNG");
        jPanel25.add(jLabel15);

        jPanel24.add(jPanel25, java.awt.BorderLayout.NORTH);

        jPanel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 20));
        jPanel26.setPreferredSize(new java.awt.Dimension(1511, 1200));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {".....", "Nguyễn Hồ Đăng Quang"},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Số điện thoại", "Tên khách hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_danhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_danhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tbl_danhSach);

        jPanel26.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel27.setPreferredSize(new java.awt.Dimension(1520, 80));
        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

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
        jPanel27.add(btn_them);

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
        jPanel27.add(btn_sua);

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
        jPanel27.add(btn_luu);

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
        jPanel27.add(btn_xoaTrang);

        jPanel24.add(jPanel27, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_phoneActionPerformed

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
            java.util.logging.Logger.getLogger(GD_QuanLi_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi_KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLi_KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoaTrang;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_danhSach;
    private javax.swing.JTextField tf_phone;
    private javax.swing.JTextField tf_ten;
    // End of variables declaration//GEN-END:variables
}
