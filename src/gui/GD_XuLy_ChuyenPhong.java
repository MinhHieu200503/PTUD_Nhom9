/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_ChiTietPhong_HoaDon;
import dao.DAO_Phong;
import dao.I_CRUD;
import entity.ChitTietPhongHoaDon;
import entity.HoaDon;
import entity.Phong;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import smallPanel.Panel_DanhSachPhongFullCol;
import smallPanel.Panel_Phong;

/**
 *
 * @author quang
 */
public class GD_XuLy_ChuyenPhong extends javax.swing.JFrame {

    private ListSelectionModel SingleSelectionModel;

    /**
     * Creates new form GD_ChuyenPhong
     */
    public GD_XuLy_ChuyenPhong() {
        initComponents();
        model = (DefaultTableModel) tbl_phongTrong.getModel();
        
        loadDSPhongDangSuDung();
//        loadDSPhongTrong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlKhung = new javax.swing.JPanel();
        pnlData = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_phongTrong = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setPreferredSize(new java.awt.Dimension(1620, 964));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 944));

        pnl.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng đang sử dụng:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlKhung.setBackground(new java.awt.Color(255, 255, 255));

        pnlData.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 20));

        javax.swing.GroupLayout pnlKhungLayout = new javax.swing.GroupLayout(pnlKhung);
        pnlKhung.setLayout(pnlKhungLayout);
        pnlKhungLayout.setHorizontalGroup(
            pnlKhungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhungLayout.createSequentialGroup()
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlKhungLayout.setVerticalGroup(
            pnlKhungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhungLayout.createSequentialGroup()
                .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(700, 700, 700))
        );

        jScrollPane1.setViewportView(pnlKhung);

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_phongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Loại phòng", "Sức chứa", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_phongTrong.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tbl_phongTrong.setColorBordeFilas(new java.awt.Color(0, 153, 153));
        tbl_phongTrong.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tbl_phongTrong.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tbl_phongTrong.setRowHeight(30);
        tbl_phongTrong.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_phongTrong.getTableHeader().setReorderingAllowed(false);
        tbl_phongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_phongTrongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_phongTrong);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách phòng trống");
        jPanel4.add(jLabel1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chuyển phòng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1647, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_phongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_phongTrongMouseClicked
        // TODO add your handling code here:
        int row = tbl_phongTrong.getSelectedRow();
        idSelectedPhongMoi = model.getValueAt(row, 0).toString();
    }//GEN-LAST:event_tbl_phongTrongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (chuyenPhong()) {
            JOptionPane.showMessageDialog(null, "Chuyển phòng thành công");
//            dsP_fullCol.getPanel_Container_ListPhong().removeAll();
            loadDSPhongDangSuDung();
//            loadDSPhongTrong();
             model.setRowCount(0);
            
        } else {
//            JOptionPane.showMessageDialog(null, "Chuyển phòng thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public boolean chuyenPhong() {
        if (idSelectedPhongCu == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng đang sử dụng");
            return false;
        } else if (idSelectedPhongMoi == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng trống");
            return false;
        } else {
            // Phòng cũ là phòng đang sử dụng. Phòng mới là phòng sẽ chuyển. Đang sử dụng đồng nghĩa vs mới nhất luôn.
            ArrayList<ChitTietPhongHoaDon> dsctpTheoMa = daoctp.getDStheoMaPhong(idSelectedPhongCu); // Lấy all chi tiết phòng theo phòng
            hdPhongDSD_MoiNhat = dsctpTheoMa.getLast().getHoaDon(); // Lấy Hoá đơn mới nhất của chi tiết phòng theo mã phòng. Hoá đơn mới nhất là hoá đơn chứa các phòng đang dc sử dụng.
            LocalDateTime now = LocalDateTime.now(); // Thòi gian trả phòng | nhận phòng

            // Ghi chú chi tiết phòng cũ: mã phòng trước đó mã phòng mới. VD: MP001 MP002. cắt lấy MP001
            // Giả sử có chi tiết phòng của MP001. MP001 sang MP003.
            // Ghi chú theo quy luật: nếu là phòng vừa đặt thì ghi chú là MP000 Đang sử dụng.
            // Nếu chuyển sang phòng mới thì cập nhật lại ghi chú của node phía trước là MP000 MP003 
            // Chi tiết phòng mới: ghi chú là MP003 Đang sử dụng
            
            // Chặn vòng lặp khi chuyển từ phòng cũ sang mới rồi lại về cũ
            for (String i : daoctp.getDsIdTheoMaHoaDon(hdPhongDSD_MoiNhat.getMaHoaDon())) {
                if (idSelectedPhongMoi.equals(i.trim())) {
                    JOptionPane.showMessageDialog(null, "Không được chuyển lại phòng cũ");
                    return false;
                }
                    
            }
            // Lấy chi tiết phòng cũ
            ChitTietPhongHoaDon ctPhongCu = dsctpTheoMa.get(dsctpTheoMa.size() - 1); 
            String ghiChuPhongCu = ctPhongCu.getGhiChu().substring(0, 5) + " " + idSelectedPhongMoi;
            // Update giờ ra cho phòng cũ (ghi chú chi tiết phòng) 
            if (!daoctp.updateGioRa(idSelectedPhongCu, hdPhongDSD_MoiNhat.getMaHoaDon(), now, ghiChuPhongCu)) {
                return false;
            }
            // updqte trạng thái phòng cũ
            if (!daop.capNhatTrangThaiPhong(idSelectedPhongCu, 0)) {
                return false;
            }
            // tạo chi tiết phòng mới (ghi chú chi tiết phòng)
            Phong phongMoi = I_CRUD.findById(idSelectedPhongMoi, new Phong());
            // Ghi chú cho phòng mới
            String ghiChuPhongMoi = idSelectedPhongCu + " Đang sử dụng";
            ChitTietPhongHoaDon ctp_new = new ChitTietPhongHoaDon(now, null, ghiChuPhongMoi, hdPhongDSD_MoiNhat, phongMoi);
            if (!daoctp.themCTHD_PMoi(ctp_new)) {
                return false;
            }
            // update trạng thái phòng mới
            if (!daop.capNhatTrangThaiPhong(idSelectedPhongMoi, 1)) {
                return false;
            }
        }
        return true;
    }
    public void loadDSPhongDangSuDung(){
        // Xóa danh sách phòng trống cũ
        pnlData.removeAll();
        
        idSelectedPhongCu = null;
        
        // Lấy danh sách phòng trống từ CSDL
        ArrayList<entity.Phong> dspdsd = daop.getPhongTheoTrangThai(1); // 1 là ds phòng đang sử dụng
        
        int tongPhong = dspdsd.size();
        int soDong;
        if (tongPhong % 3 == 0) {
            soDong = tongPhong / 3;
        } else {
            soDong = tongPhong / 3 + 1; // cộng 1 vì số dư <= 2 và 1 dòng thì chứa dc 3 phòng
        }
        pnlKhung.setPreferredSize(new Dimension(890, soDong * 135 + (soDong + 1) * 20 )); // 20 là gap, 135 là chiều cao 1 phòng
        pnlData.setPreferredSize(new Dimension(890, soDong * 135 + (soDong + 1) * 20 )); 
        for (int i = 0; i < dspdsd.size(); i++) {
            Panel_Phong p = new Panel_Phong(dspdsd.get(i));
            pnlData.add(p);
//            if (p.getMouseListeners().length > 0) 
//                System.out.println("Đã xoá dc");
//            else
//                System.out.println("chưa dc");
            p.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    
                    Border border = new LineBorder(Color.ORANGE, 4, true);
//                    for (Panel_Phong i : dspnlp) {
//                        if (i.equals(p))
//                            i.setBorder(border);
//                        else
//                            i.setBorder(null);
//                    }
                    if (previousSelectedRoom != null) {
                        previousSelectedRoom.setBorder(null); // Cập nhật viền cho phần tử trước đó
                    }
                    p.setBorder(border); // Cập nhật viền cho phần tử mới
                    previousSelectedRoom = p; 
                    idSelectedPhongCu = p.getId();
                    ArrayList<ChitTietPhongHoaDon> dsctpTheoMa = daoctp.getDStheoMaPhong(idSelectedPhongCu);
                    hdPhongDSD_MoiNhat = dsctpTheoMa.getLast().getHoaDon();
                    loadDSPhongTrong();
                }
            });
//            repaint();
        }
    }
    public void loadDSPhongTrong() {
        model.setRowCount(0);
        idSelectedPhongMoi = null;
        int row = tbl_phongTrong.getSelectedRow();
        ArrayList<Phong> dspt = daop.getPhongTheoTrangThai(0);
        ArrayList<String> dsid_phong = daoctp.getDsIdTheoMaHoaDon(hdPhongDSD_MoiNhat.getMaHoaDon());
        for (Phong i : dspt) {
            if (!dsid_phong.contains(i.getMaPhong())) {
                String maphong = i.getMaPhong();
                String loaiphong = (i.getLoaiPhong()).getLoaiPhong();
                System.out.println(i.getLoaiPhong());
                String succhua = String.valueOf(i.getSucChuaToiDa());
                String gia = String.valueOf(i.getGiaPhongTheoGio());
                Object[] rowData = {maphong, loaiphong, succhua, gia};
                model.addRow(rowData);
            }
        }
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GD_XuLy_ChuyenPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GD_XuLy_ChuyenPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GD_XuLy_ChuyenPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GD_XuLy_ChuyenPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_ChuyenPhong().setVisible(true);
            }
        });
    }
private DAO_Phong daop = new DAO_Phong();
private DAO_ChiTietPhong_HoaDon daoctp = new DAO_ChiTietPhong_HoaDon();
ArrayList<entity.Phong> dspdsd = new ArrayList<>();
private String  idSelectedPhongCu = null;
private String idSelectedPhongMoi = null;
private Panel_Phong previousSelectedRoom = null;
private DefaultTableModel model;
private HoaDon hdPhongDSD_MoiNhat;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnl;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlKhung;
    private rojeru_san.complementos.RSTableMetro tbl_phongTrong;
    // End of variables declaration//GEN-END:variables
}
