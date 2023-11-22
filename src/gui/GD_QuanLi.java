/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import gui.GD_QuanLi_Ca;
import gui.GD_QuanLi_DichVu;
import gui.GD_QuanLi_KhachHang;
import gui.GD_QuanLi_LoaiPhong;
import gui.GD_QuanLi_NhanVien;
import gui.GD_QuanLi_Phong;
import gui.GD_QuanLi_UuDai;

/**
 *
 * @author quang
 */
public class GD_QuanLi extends javax.swing.JFrame {

    GD_QuanLi_Phong p = new GD_QuanLi_Phong();
    GD_QuanLi_LoaiPhong lp = new GD_QuanLi_LoaiPhong();
    GD_QuanLi_KhachHang kh = new GD_QuanLi_KhachHang();
    GD_QuanLi_DichVu dv = new GD_QuanLi_DichVu();
    GD_QuanLi_NhanVien nv = new GD_QuanLi_NhanVien();
    GD_QuanLi_Ca ca = new GD_QuanLi_Ca();
    GD_QuanLi_UuDai ud = new GD_QuanLi_UuDai();
    /**
     * Creates new form GD_QuanLi
     */
    public GD_QuanLi() {
        initComponents();
        jTabbedPane1.addTab("Quản lí Phòng", p.getContentPane());
        jTabbedPane1.addTab("Quản lí Loại phòng", lp.getContentPane());
        jTabbedPane1.addTab("Quản lí Dịch vụ", dv.getContentPane());
        jTabbedPane1.addTab("Quản lí Ưu đãi", ud.getContentPane());
        jTabbedPane1.addTab("Quản lí Khách hàng", kh.getContentPane());
        jTabbedPane1.addTab("Quản lí Nhân viên", nv.getContentPane());
        jTabbedPane1.addTab("Quản lí Ca", ca.getContentPane());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GD_QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
