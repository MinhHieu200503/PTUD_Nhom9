/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_ChiTietPhong_HoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_Phong;
import dao.I_CRUD;
import entity.ChitTietPhongHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.UuDai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import smallPanel.Panel_DanhSachPhong;
import smallPanel.Panel_DanhSachPhongFullCol;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import gui.GD_XuLy;
import gui.GD_QuanLi;
import gui.GD_TraCuu;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import static smallPanel.Panel_DanhSachPhongFullCol.codePhong;

/**
 *
 * @author LENOVO
 */
public class GD_XuLy_GoiDichVu extends javax.swing.JFrame {

    /**
     * Creates new form GD_XuLy_DatPhongNgay
     */
    public GD_XuLy_GoiDichVu() {
        
        initComponents();

        
        loadDSPhongDangSuDung();
        
        
        
//        editTable();
        
        

		
    }
    
    
    public void editTable(){
        TableActionEvent event = new TableActionEvent() {
//            @Override
//            public void onEdit(int row) {
//                System.out.println("Edit row : " + row);
//            }

            @Override
            public void onDelete(int row) {
                if (tableTatCaDV.isEditing()) {
                    tableTatCaDV.getCellEditor().stopCellEditing();
                }
                int selectedRow = tableTatCaDV.getSelectedRow();
                    String maPhong = (String) tableTatCaDV.getValueAt(tableTatCaDV.getSelectedRow(), 0);
                    System.out.println("maPhong" + maPhong);
                    if (selectedRow != -1) { // Kiểm tra xem có dòng được chọn không
                        // Xóa dòng được chọn từ mô hình
                        
                        smallPanel.Panel_DanhSachPhongFullCol.setPhongDefault(maPhong);
                        model.removeRow(selectedRow);
                        
                        
                    }
            }

//            @Override
//            public void onView(int row) {
//                System.out.println("View row : " + row);
//            }
        };
        tableTatCaDV.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tableTatCaDV.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
//        tablePhongDatNgay.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//                setHorizontalAlignment(SwingConstants.RIGHT);
//                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
//            }
//        });
    }
    
    
    public static void fillData(String maPhong){
       txt_GioNhanPhong.setText("Vy cute");
        JOptionPane.showMessageDialog(null, maPhong);
    }
      
    
    public void loadDSPhongDangSuDung(){
        ContainerListPhong.removeAll();
        
         dao.DAO_Phong dao_phong = new DAO_Phong();
         ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
         ArrayList<entity.Phong> listPhong1 = new ArrayList<entity.Phong>();
         listPhong = dao_phong.getAll(Phong.class);
         // khoi tao chạy lần đầu
      
           
                
                listPhong1 = dao_phong.getPhongTheoTrangThai(1);
                
               
//       
        
        danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_GoiDichVu.class);
        ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
        ContainerListPhong.getComponent(0).setBackground(Color.white);
        
        
            
    }
    
    public void loadDSTatCaDichVu(){
        
       
    }
   
   
    
  
    
    public static void addRowToTable(Object[] rowData) {
        DefaultTableModel model = (DefaultTableModel) tableTatCaDV.getModel();
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

        Container_GoiDichVu = new javax.swing.JPanel();
        ContainerListPhong = new javax.swing.JPanel();
        Panel_ThongTinKhachHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_MaUuDai = new app.bolivia.swing.JCTextField();
        txt_GioNhanPhong = new app.bolivia.swing.JCTextField();
        txt_MaUuDai1 = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDvDangSuDung = new rojeru_san.complementos.RSTableMetro();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_XacNhanDichVu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTatCaDV = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1096, 964));
        setResizable(false);

        Container_GoiDichVu.setBackground(new java.awt.Color(255, 255, 255));
        Container_GoiDichVu.setMaximumSize(new java.awt.Dimension(1620, 964));
        Container_GoiDichVu.setMinimumSize(new java.awt.Dimension(1620, 964));
        Container_GoiDichVu.setPreferredSize(new java.awt.Dimension(1620, 964));
        Container_GoiDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContainerListPhong.setBackground(new java.awt.Color(255, 255, 255));
        ContainerListPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHÒNG ĐANG SỬ DỤNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N
        ContainerListPhong.setMaximumSize(new java.awt.Dimension(900, 500));
        ContainerListPhong.setMinimumSize(new java.awt.Dimension(900, 500));
        ContainerListPhong.setName(""); // NOI18N
        ContainerListPhong.setPreferredSize(new java.awt.Dimension(900, 500));
        ContainerListPhong.setVerifyInputWhenFocusTarget(false);
        ContainerListPhong.setLayout(new java.awt.BorderLayout());
        Container_GoiDichVu.add(ContainerListPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 890, 390));

        Panel_ThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Giờ nhận phòng:");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Số điện thoại:");

        txt_MaUuDai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_GioNhanPhong.setEditable(false);
        txt_GioNhanPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txt_MaUuDai1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Dịch vụ phòng đang sử dụng:");

        tableDvDangSuDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Giá", "Số lượng ", ""
            }
        ));
        tableDvDangSuDung.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tableDvDangSuDung.setColorBordeFilas(new java.awt.Color(0, 153, 153));
        tableDvDangSuDung.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tableDvDangSuDung.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tableDvDangSuDung.setRowHeight(30);
        tableDvDangSuDung.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tableDvDangSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDvDangSuDungxoaMotDongTable(evt);
            }
        });
        jScrollPane3.setViewportView(tableDvDangSuDung);

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Tên khách hàng:");

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                            .addComponent(txt_MaUuDai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_MaUuDai1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))))
        );
        Panel_ThongTinKhachHangLayout.setVerticalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_MaUuDai, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txt_MaUuDai1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Container_GoiDichVu.add(Panel_ThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 670, 730));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH DỊCH VỤ CỦA CỬA HÀNG:");
        Container_GoiDichVu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 400, -1));

        btn_XacNhanDichVu.setBackground(new java.awt.Color(0, 204, 204));
        btn_XacNhanDichVu.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_XacNhanDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btn_XacNhanDichVu.setText("XÁC NHẬN DỊCH VỤ");
        btn_XacNhanDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datPhongNgay(evt);
            }
        });
        Container_GoiDichVu.add(btn_XacNhanDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 770, 670, 60));

        tableTatCaDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng còn lại"
            }
        ));
        tableTatCaDV.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tableTatCaDV.setColorBordeFilas(new java.awt.Color(0, 153, 153));
        tableTatCaDV.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tableTatCaDV.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tableTatCaDV.setRowHeight(30);
        tableTatCaDV.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tableTatCaDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaMotDongTable(evt);
            }
        });
        jScrollPane2.setViewportView(tableTatCaDV);

        Container_GoiDichVu.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 890, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container_GoiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 1614, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container_GoiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xoaMotDongTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaMotDongTable
//        if (evt.getClickCount() == 2) { // Kiểm tra xem là double click
//                    int selectedRow = tablePhongDatNgay.getSelectedRow();
//                    String maPhong = (String) tablePhongDatNgay.getValueAt(tablePhongDatNgay.getSelectedRow(), 0);
//                    System.out.println("maPhong" + maPhong);
//                    if (selectedRow != -1) { // Kiểm tra xem có dòng được chọn không
//                        // Xóa dòng được chọn từ mô hình
//                        
//                        smallPanel.Panel_DanhSachPhongFullCol.setPhongDefault(maPhong);
//                        model.removeRow(selectedRow);
//                        
//                        
//                    }
//                     
//        }
    }//GEN-LAST:event_xoaMotDongTable

    private void datPhongNgay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datPhongNgay
//        if(datPhong()){
//            JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
//            loadDSPhongTrong();
//            model.setRowCount(0);
//            txt_SoDT.setSelectedIndex(0);
//            txt_khachHang.setText("");
//        }
    }//GEN-LAST:event_datPhongNgay

    private void tableDvDangSuDungxoaMotDongTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDvDangSuDungxoaMotDongTable
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDvDangSuDungxoaMotDongTable
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_GoiDichVu().setVisible(true);
            }
        });
    }
    private ArrayList<entity.Phong> temp;
    smallPanel.Panel_DanhSachPhongFullCol danhSachPhong;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContainerListPhong;
    private javax.swing.JPanel Container_GoiDichVu;
    private javax.swing.JPanel Panel_ThongTinKhachHang;
    private javax.swing.JButton btn_XacNhanDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static rojeru_san.complementos.RSTableMetro tableDvDangSuDung;
    public static rojeru_san.complementos.RSTableMetro tableTatCaDV;
    public static app.bolivia.swing.JCTextField txt_GioNhanPhong;
    private app.bolivia.swing.JCTextField txt_MaUuDai;
    private app.bolivia.swing.JCTextField txt_MaUuDai1;
    // End of variables declaration//GEN-END:variables
    public static DefaultTableModel model  =new DefaultTableModel();
    public static DefaultTableModel modelTableTatCaDV;
    
    public String maPhongDangDuocChon = "";
    
    public static void setThongTinDatPhong(String codePhong){
//          model = (DefaultTableModel) tableTatCaDV.getModel();
//          String ma = codePhong.substring(codePhong.length() - 5);
//          
//          int count = model.getRowCount();
//          
//          for(int i=0; i<count; i++){
//              if(model.getValueAt(i, 0).equals(ma)){
//                  JOptionPane.showMessageDialog(null, "Bà chọn rồi bà ơi");
//                 return;
//              }
//              
//          }
//          
//          Phong p = new Phong();
//            
//                    p = I_CRUD.findById(ma, new Phong());
//                   String[] row = {ma, p.getLoaiPhong().getLoaiPhong(), p.getSucChuaToiDa()+"", p.getGiaPhongTheoGio()+""};
//           
//           
//           
//            model.addRow(row);
            
        String maPhongDangChon = smallPanel.Panel_DanhSachPhongFullCol.maPhongGoiDVduocChon;
        JOptionPane.showMessageDialog(null, "Phong dang chon: "+maPhongDangChon);

        // In kết quả
            
          
          
        
//        model.addColumn("Code phong");
//        tablePhongDatNgay = new JTable();
//        tablePhongDatNgay.setModel(model);
       
    }
    
    

}
