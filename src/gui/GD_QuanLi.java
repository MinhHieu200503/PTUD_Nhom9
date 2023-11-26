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
//        if (GD_DangNhap.taiKhoan.getVaiTro()) { // quản lí
//            jTabbedPane1.addTab("Quản lí Phòng", p.getContentPane());
//            jTabbedPane1.addTab("Quản lí Loại phòng", lp.getContentPane());
//            jTabbedPane1.addTab("Quản lí Dịch vụ", dv.getContentPane());
//            jTabbedPane1.addTab("Quản lí Ưu đãi", ud.getContentPane());
//            jTabbedPane1.addTab("Quản lí Khách hàng", kh.getContentPane());
//            jTabbedPane1.addTab("Quản lí Nhân viên", nv.getContentPane());
//            jTabbedPane1.addTab("Quản lí Ca", ca.getContentPane());
//        } else { // nhân viên
//            jTabbedPane1.addTab("Quản lí Khách hàng", kh.getContentPane());
//        }
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
        setMaximumSize(new java.awt.Dimension(1900, 800));
        setMinimumSize(new java.awt.Dimension(1900, 800));
        setPreferredSize(new java.awt.Dimension(1900, 800));

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTabbedPane1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTabbedPane1HierarchyChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1905, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTabbedPane1HierarchyChanged
        // TODO add your handling code here:
        if (jTabbedPane1.isShowing()) {
            if (GD_DangNhap.taiKhoan.getVaiTro()) { // quản lí
                jTabbedPane1.addTab("Quản lí Phòng", p.getContentPane());
                jTabbedPane1.addTab("Quản lí Loại phòng", lp.getContentPane());
                jTabbedPane1.addTab("Quản lí Dịch vụ", dv.getContentPane());
                jTabbedPane1.addTab("Quản lí Ưu đãi", ud.getContentPane());
                jTabbedPane1.addTab("Quản lí Khách hàng", kh.getContentPane());
                jTabbedPane1.addTab("Quản lí Nhân viên", nv.getContentPane());
                jTabbedPane1.addTab("Quản lí Ca", ca.getContentPane());
            } else { // nhân viên
                jTabbedPane1.addTab("Quản lí Khách hàng", kh.getContentPane());
            }
        }
        
    }//GEN-LAST:event_jTabbedPane1HierarchyChanged

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

/*
    SỰ KIỆN QUẢN LÍ: Đảm bảo toàn bộ thao tác không dẫn đến lỗi
    nhấn vào nút thêm:
        Xoá rỗng nhập liệu
        Thêm
            Tạo id (trừ khách hàng)
            Mở nhập liệu
            Xoá chọn dòng trên bảng
            setEnable false cho bảng
            Đổi tên nút -> Huỷ. setIcon lại
            Đổi trạng thái các nút
        Huỷ
            Đóng nhập liệu
            setEnable true cho bảng
            Đổi tên nút -> Thêm. setIcon lại
            Đổi trạng thái các nút
            Xoá rỗng nhập liệu
    nhấn vào nút sửa:
        Kiểm tra chọn dòng
            Sửa
                Mở nhập liệu
                setEnable false cho bảng
                Đổi tên nút -> Huỷ. setIcon lại
                Đổi trạng thái các nút
            Huỷ
                Đóng nhập liệu
                Xoá chọn dòng trên bảng
                setEnable true cho bảng
                Đổi tên nút -> Huỷ. setIcon lại
                Đổi trạng thái các nút
                Xoá rỗng nhập liệu
    nhân vào nút lưu:
        Thêm
            validate
                Tạo thực thể từ các ô nhập liệu
                chạy lệnh SQL tạo thực thể
                    Thông báo thêm thành công
                    load lại bảng
                    set lại trạng thái các nút. đổi tên nút -> thêm.
                    đóng nhập liệu
                    xoá rỗng nhập liệu
                    setEnable true cho bảng
        Sửa
            validate
                Tạo thực thể từ các ô nhập liệu
                chạy lệnh SQL update thực thể
                    Thông báo sửa thành công
                    load lại bảng
                    set lại trạng thái các nút. đổi tên nút -> sửa.
                    đóng nhập liệu
                    xoá rỗng nhập liệu
                    setEnable true cho bảng

                
        
*/