/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author quang
 */
public class GD_TraCuu extends javax.swing.JFrame {

    /**
     * Creates new form GD_TraCuu
     */
    GD_TraCuu_KhachHang gdkh = new GD_TraCuu_KhachHang();
    GD_TraCuu_HoaDon gdhd = new GD_TraCuu_HoaDon();
    GD_TraCuu_Phong gdp = new GD_TraCuu_Phong();
    GD_TraCuu_DichVu gddv = new GD_TraCuu_DichVu();
    GD_TraCuu_PhieuDatPhong gdpdp = new GD_TraCuu_PhieuDatPhong();
    GD_TraCuu_NhanVien gdnv = new GD_TraCuu_NhanVien();
    
    public GD_TraCuu() {
        initComponents();
//        setExtendedState(6);
        
        pnlRight.add(gdkh.getContentPane(), BorderLayout.CENTER);
        choice= pnlLeft_1;
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        pnlLeft_title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlLeft_1 = new javax.swing.JPanel();
        pnlLeft_1_labelKhachHang = new javax.swing.JLabel();
        pnlLeft_2 = new javax.swing.JPanel();
        pnlLeft_2_lableHoaDon = new javax.swing.JLabel();
        pnlLeft_3 = new javax.swing.JPanel();
        pnlLeft_3_labelPhong = new javax.swing.JLabel();
        pnlLeft_4 = new javax.swing.JPanel();
        pnlLeft_4_labelDichVu = new javax.swing.JLabel();
        pnlLeft_5 = new javax.swing.JPanel();
        pnlLeft_5_labelPhieuDatPhong = new javax.swing.JLabel();
        pnlLeft_6 = new javax.swing.JPanel();
        pnlLeft_6_labelNhanVien = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlLeft.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft.setPreferredSize(new java.awt.Dimension(270, 835));

        pnlLeft_title.setBackground(new java.awt.Color(23, 45, 79));
        pnlLeft_title.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRA CỨU");
        jLabel1.setToolTipText("");
        pnlLeft_title.add(jLabel1, java.awt.BorderLayout.CENTER);

        pnlLeft_1.setBackground(new java.awt.Color(44, 85, 180));
        pnlLeft_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_1MousePressed(evt);
            }
        });

        pnlLeft_1_labelKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_1_labelKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_1_labelKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_khachhang.png"))); // NOI18N
        pnlLeft_1_labelKhachHang.setText("Khách hàng");

        javax.swing.GroupLayout pnlLeft_1Layout = new javax.swing.GroupLayout(pnlLeft_1);
        pnlLeft_1.setLayout(pnlLeft_1Layout);
        pnlLeft_1Layout.setHorizontalGroup(
            pnlLeft_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlLeft_1_labelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlLeft_1Layout.setVerticalGroup(
            pnlLeft_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_1_labelKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        pnlLeft_2.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_2MousePressed(evt);
            }
        });

        pnlLeft_2_lableHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_2_lableHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_2_lableHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_hoadon.png"))); // NOI18N
        pnlLeft_2_lableHoaDon.setText("Hoá đơn");

        javax.swing.GroupLayout pnlLeft_2Layout = new javax.swing.GroupLayout(pnlLeft_2);
        pnlLeft_2.setLayout(pnlLeft_2Layout);
        pnlLeft_2Layout.setHorizontalGroup(
            pnlLeft_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlLeft_2_lableHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeft_2Layout.setVerticalGroup(
            pnlLeft_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_2_lableHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLeft_3.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_3MousePressed(evt);
            }
        });

        pnlLeft_3_labelPhong.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_3_labelPhong.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_3_labelPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_phong.png"))); // NOI18N
        pnlLeft_3_labelPhong.setText("Phòng");

        javax.swing.GroupLayout pnlLeft_3Layout = new javax.swing.GroupLayout(pnlLeft_3);
        pnlLeft_3.setLayout(pnlLeft_3Layout);
        pnlLeft_3Layout.setHorizontalGroup(
            pnlLeft_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlLeft_3_labelPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeft_3Layout.setVerticalGroup(
            pnlLeft_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_3_labelPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLeft_4.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_4MousePressed(evt);
            }
        });

        pnlLeft_4_labelDichVu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_4_labelDichVu.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_4_labelDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_dichvu.png"))); // NOI18N
        pnlLeft_4_labelDichVu.setText("Dịch vụ");

        javax.swing.GroupLayout pnlLeft_4Layout = new javax.swing.GroupLayout(pnlLeft_4);
        pnlLeft_4.setLayout(pnlLeft_4Layout);
        pnlLeft_4Layout.setHorizontalGroup(
            pnlLeft_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlLeft_4_labelDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeft_4Layout.setVerticalGroup(
            pnlLeft_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_4_labelDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLeft_5.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_5MousePressed(evt);
            }
        });

        pnlLeft_5_labelPhieuDatPhong.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_5_labelPhieuDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_5_labelPhieuDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_phieudatphong.png"))); // NOI18N
        pnlLeft_5_labelPhieuDatPhong.setText("Phiếu đặt phòng");

        javax.swing.GroupLayout pnlLeft_5Layout = new javax.swing.GroupLayout(pnlLeft_5);
        pnlLeft_5.setLayout(pnlLeft_5Layout);
        pnlLeft_5Layout.setHorizontalGroup(
            pnlLeft_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnlLeft_5_labelPhieuDatPhong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeft_5Layout.setVerticalGroup(
            pnlLeft_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_5_labelPhieuDatPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLeft_6.setBackground(new java.awt.Color(40, 77, 133));
        pnlLeft_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLeft_6MousePressed(evt);
            }
        });

        pnlLeft_6_labelNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pnlLeft_6_labelNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        pnlLeft_6_labelNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/serach_NhanVien.png"))); // NOI18N
        pnlLeft_6_labelNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout pnlLeft_6Layout = new javax.swing.GroupLayout(pnlLeft_6);
        pnlLeft_6.setLayout(pnlLeft_6Layout);
        pnlLeft_6Layout.setHorizontalGroup(
            pnlLeft_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeft_6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlLeft_6_labelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeft_6Layout.setVerticalGroup(
            pnlLeft_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_6_labelNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addComponent(pnlLeft_title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLeft_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeft_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeft_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeft_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeft_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLeft_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        pnlMain.add(pnlLeft, java.awt.BorderLayout.WEST);

        pnlRight.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlRight, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void chinhMauKhiNhanVaoMenu(JPanel pnl) {
        pnl.setBackground(new Color(44, 85, 180)); // Đánh dấu khi được chọn
        for (Component com : pnlLeft.getComponents()) {
            if (com instanceof JPanel && !com.equals(pnl) &&!com.equals(pnlLeft_title)) {
                com.setBackground(new Color(40, 77, 133)); // Chỉnh về màu mặc định                
            }
        }
        choice = pnl;
    }
    public void chuyenPanel(JFrame fr)   {
        pnlRight.removeAll();
        pnlRight.add(fr.getContentPane(), BorderLayout.CENTER);
        pack();
        repaint();
        
    }
    
    private void pnlLeft_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_1MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_1);
        chuyenPanel(gdkh);
    }//GEN-LAST:event_pnlLeft_1MousePressed

    private void pnlLeft_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_2MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_2);
        chuyenPanel(gdhd);
    }//GEN-LAST:event_pnlLeft_2MousePressed

    private void pnlLeft_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_4MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_4);
        chuyenPanel(gddv);
    }//GEN-LAST:event_pnlLeft_4MousePressed

    private void pnlLeft_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_5MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_5);
        chuyenPanel(gdpdp);
    }//GEN-LAST:event_pnlLeft_5MousePressed

    private void pnlLeft_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_3MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_3);
        chuyenPanel(gdp);
    }//GEN-LAST:event_pnlLeft_3MousePressed

    private void pnlLeft_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeft_6MousePressed
        chinhMauKhiNhanVaoMenu(pnlLeft_6);
        chuyenPanel(gdnv);
    }//GEN-LAST:event_pnlLeft_6MousePressed

    private void exitMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenu
        Object a = evt.getSource();
        exitedMenu((JPanel) a);
    }//GEN-LAST:event_exitMenu

    private void enterMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterMenu
        Object a = evt.getSource();
        enteredMenu((JPanel) a);
    }//GEN-LAST:event_enterMenu
    public void enteredMenu(javax.swing.JPanel panel){
        if (!choice.equals(panel)){
           panel.setBackground(new Color(40,94,178));
           repaint();
        }
    }
    
    public void exitedMenu(javax.swing.JPanel panel){
        if (!choice.equals(panel)){
            panel.setBackground(new Color(40,77,133));
            repaint();
        }
    }
    /**
     * EVENT
     */
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
            java.util.logging.Logger.getLogger(GD_TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_TraCuu().setVisible(true);
            }
        });
    }
    private javax.swing.JPanel choice;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlLeft_1;
    private javax.swing.JLabel pnlLeft_1_labelKhachHang;
    private javax.swing.JPanel pnlLeft_2;
    private javax.swing.JLabel pnlLeft_2_lableHoaDon;
    private javax.swing.JPanel pnlLeft_3;
    private javax.swing.JLabel pnlLeft_3_labelPhong;
    private javax.swing.JPanel pnlLeft_4;
    private javax.swing.JLabel pnlLeft_4_labelDichVu;
    private javax.swing.JPanel pnlLeft_5;
    private javax.swing.JLabel pnlLeft_5_labelPhieuDatPhong;
    private javax.swing.JPanel pnlLeft_6;
    private javax.swing.JLabel pnlLeft_6_labelNhanVien;
    private javax.swing.JPanel pnlLeft_title;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRight;
    // End of variables declaration//GEN-END:variables
}
