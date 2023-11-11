/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import smallPanel.Panel_DanhSachPhong;
import smallPanel.Panel_DanhSachPhongFullCol;


/**
 *
 * @author LENOVO
 */
public class GD_XuLy_DatPhongNgay extends javax.swing.JFrame {

    /**
     * Creates new form GD_XuLy_DatPhongNgay
     */
    public GD_XuLy_DatPhongNgay() {
        initComponents();
        temp = new ArrayList<entity.Phong>();
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("002", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
        
        danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(temp);
                
        
        ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
        ContainerListPhong.getComponent(0).setBackground(Color.white);
        String test = danhSachPhong.codePhong;
        
        System.out.println("gui.GD_XuLy_DatPhongNgay.<init>() " + test);
    }
    
    public static void addRowToTable(Object[] rowData) {
        DefaultTableModel model = (DefaultTableModel) tablePhongDatNgay.getModel();
        model.addRow(rowData);
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Panel_ThongTinKhachHang1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCTextField1 = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePhongDatNgay = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1096, 964));
        setMinimumSize(new java.awt.Dimension(1096, 964));
        setResizable(false);

        Container_DatPhongNgay.setBackground(new java.awt.Color(255, 255, 255));
        Container_DatPhongNgay.setMaximumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setMinimumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setPreferredSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContainerListPhong.setBackground(new java.awt.Color(255, 255, 255));
        ContainerListPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHÒNG TRỐNG:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N
        ContainerListPhong.setMaximumSize(new java.awt.Dimension(1080, 698));
        ContainerListPhong.setMinimumSize(new java.awt.Dimension(1080, 698));
        ContainerListPhong.setName(""); // NOI18N
        ContainerListPhong.setPreferredSize(new java.awt.Dimension(1080, 698));
        ContainerListPhong.setVerifyInputWhenFocusTarget(false);
        ContainerListPhong.setLayout(new java.awt.BorderLayout());
        Container_DatPhongNgay.add(ContainerListPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1110, 820));

        Panel_ThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Giờ nhận phòng:");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mã ưu đãi:");

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Panel_ThongTinKhachHangLayout.setVerticalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 250, 470, 200));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("PHÒNG ĐƯỢC CHỌN:");
        Container_DatPhongNgay.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 460, 210, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ĐẶT PHÒNG NGAY");
        Container_DatPhongNgay.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 780, 470, 60));

        Panel_ThongTinKhachHang1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tên khách hàng:");

        jCTextField1.setText("jCTextField1");

        javax.swing.GroupLayout Panel_ThongTinKhachHang1Layout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang1);
        Panel_ThongTinKhachHang1.setLayout(Panel_ThongTinKhachHang1Layout);
        Panel_ThongTinKhachHang1Layout.setHorizontalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Panel_ThongTinKhachHang1Layout.setVerticalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 470, 210));

        tablePhongDatNgay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng", "Loại Phòng", "Sức chứa", "Giá phòng"
            }
        ));
        tablePhongDatNgay.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tablePhongDatNgay.setColorBordeFilas(new java.awt.Color(0, 153, 153));
        tablePhongDatNgay.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tablePhongDatNgay.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tablePhongDatNgay.setRowHeight(30);
        jScrollPane2.setViewportView(tablePhongDatNgay);

        Container_DatPhongNgay.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1132, 490, 470, 270));

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
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongNgay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongNgay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongNgay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy_DatPhongNgay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_DatPhongNgay().setVisible(true);
            }
        });
    }
    private ArrayList<entity.Phong> temp;
    smallPanel.Panel_DanhSachPhongFullCol danhSachPhong;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContainerListPhong;
    private javax.swing.JPanel Container_DatPhongNgay;
    private javax.swing.JPanel Panel_ThongTinKhachHang;
    private javax.swing.JPanel Panel_ThongTinKhachHang1;
    private javax.swing.JButton jButton1;
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static rojeru_san.complementos.RSTableMetro tablePhongDatNgay;
    // End of variables declaration//GEN-END:variables
    public static DefaultTableModel model  =new DefaultTableModel();
    
    public static void setTableData(String codePhong){
          model = (DefaultTableModel) tablePhongDatNgay.getModel();
          
           String[] row = {codePhong, "2", "3", "4"};
            model.addRow(row);
          
          
        
//        model.addColumn("Code phong");
//        tablePhongDatNgay = new JTable();
//        tablePhongDatNgay.setModel(model);
       
    }
    
    

}
