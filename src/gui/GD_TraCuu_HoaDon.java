/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author quang
 */
public class GD_TraCuu_HoaDon extends javax.swing.JFrame {

    /**
     * Creates new form GD_TraCuu_HoaDon
     */
    public GD_TraCuu_HoaDon() {
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

        pnlMain = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        pnlTop_title = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlThongTinTraCuu = new javax.swing.JPanel();
        lbl_TraCuu = new javax.swing.JLabel();
        tf_TraCuu = new javax.swing.JTextField();
        pnlData = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_TraCuu = new javax.swing.JTable();
        pnlBottom = new javax.swing.JPanel();
        btn_xemChiTiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setPreferredSize(new java.awt.Dimension(1650, 964));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setPreferredSize(new java.awt.Dimension(828, 100));
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlTop_title.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop_title.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        pnlTop_title.setForeground(new java.awt.Color(40, 77, 133));
        pnlTop_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlTop_title.setText("TRA CỨU HOÁ ĐƠN");
        pnlTop.add(pnlTop_title, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));

        pnlThongTinTraCuu.setBackground(new java.awt.Color(255, 255, 255));

        lbl_TraCuu.setFont(new java.awt.Font("Segoe UI Light", 0, 27)); // NOI18N
        lbl_TraCuu.setForeground(new java.awt.Color(40, 77, 133));
        lbl_TraCuu.setText("Nhập thông tin tra cứu:");

        tf_TraCuu.setBackground(new java.awt.Color(142, 172, 207));
        tf_TraCuu.setFont(new java.awt.Font("Segoe UI", 0, 27)); // NOI18N
        tf_TraCuu.setToolTipText("");
        tf_TraCuu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));

        javax.swing.GroupLayout pnlThongTinTraCuuLayout = new javax.swing.GroupLayout(pnlThongTinTraCuu);
        pnlThongTinTraCuu.setLayout(pnlThongTinTraCuuLayout);
        pnlThongTinTraCuuLayout.setHorizontalGroup(
            pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinTraCuuLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(lbl_TraCuu)
                .addGap(18, 18, 18)
                .addComponent(tf_TraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinTraCuuLayout.setVerticalGroup(
            pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinTraCuuLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlThongTinTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_TraCuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_TraCuu))
                .addGap(20, 20, 20))
        );

        pnlData.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setColumnHeaderView(null);

        table_TraCuu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        table_TraCuu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_TraCuu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, null, null},
                {"", null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hoá đơn", "Ngày lập hoá đơn", "Trạng thái", "Tên khách hàng", "Ưu đãi", "Tên nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_TraCuu.setGridColor(new java.awt.Color(153, 153, 153));
        table_TraCuu.setRowHeight(30);
        table_TraCuu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_TraCuu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_TraCuu.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_TraCuu);

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1590, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlThongTinTraCuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addComponent(pnlThongTinTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnlBottom.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 25));
        pnlBottom.setName(""); // NOI18N
        pnlBottom.setPreferredSize(new java.awt.Dimension(1650, 79));

        btn_xemChiTiet.setBackground(new java.awt.Color(40, 77, 133));
        btn_xemChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_xemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btn_xemChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanLi_XemChiTiet30.png"))); // NOI18N
        btn_xemChiTiet.setText("Xem chi tiết");
        btn_xemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemChiTietActionPerformed(evt);
            }
        });
        pnlBottom.add(btn_xemChiTiet);

        pnlMain.add(pnlBottom, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xemChiTietActionPerformed

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
            java.util.logging.Logger.getLogger(GD_TraCuu_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TraCuu_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_TraCuu_HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xemChiTiet;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_TraCuu;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlThongTinTraCuu;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JLabel pnlTop_title;
    private javax.swing.JTable table_TraCuu;
    private javax.swing.JTextField tf_TraCuu;
    // End of variables declaration//GEN-END:variables
}
