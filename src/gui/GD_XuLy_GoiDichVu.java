/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DAO_ChiTietDichVu_HoaDon;
import dao.DAO_ChiTietPhong_HoaDon;
import dao.DAO_DichVu;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_Phong;
import dao.I_CRUD;
import entity.ChiTietDichVuHoaDon;
import entity.ChitTietPhongHoaDon;
import entity.DichVu;
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
import static gui.GD_XuLy_DatPhongNgay.model;
import static gui.GD_XuLy_DatPhongNgay.tablePhongDatNgay;
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
import raven.cell.TableActionCellEditorDichVu;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionCellRenderDichVu;
import raven.cell.TableActionEvent;


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
        loadDSTatCaDichVu();
        
        
//        editTable();
        
        
       TableActionEvent event = new TableActionEvent() {
            

            @Override
            public void onDelete(int row) {
                if (table_dvPhongDangSuDung.isEditing()) {
                    table_dvPhongDangSuDung.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
 
                   model.removeRow(row);
                   
                   
            }

//            @Override
//            public void onView(int row) {
//                System.out.println("View row : " + row);
//            }

            @Override
            public void onSubtract(int row) {
               DefaultTableModel model = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
               int sl = Integer.parseInt(model.getValueAt(row, 2).toString()) -1;
               model.setValueAt( sl, row, 2);
            }

            @Override
            public void onAdd(int row) {
                DefaultTableModel model = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
               int sl = Integer.parseInt(model.getValueAt(row, 2).toString()) +1;
               model.setValueAt( sl, row, 2);
            }

  
        };
        
       
        
        
        
        table_dvPhongDangSuDung.getColumnModel().getColumn(3).setCellRenderer( new TableActionCellRenderDichVu());
        table_dvPhongDangSuDung.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditorDichVu(event));
//        tablePhongDatNgay.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//                setHorizontalAlignment(SwingConstants.RIGHT);
//                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
//            }
//        });
		
    }
    
    
    
    
    
    public static void fillData(String maPhong){
       
       
        String ma = maPhong.substring(maPhong.length() - 5);
        
        DAO_Phong dao_phong = new DAO_Phong();
        
        String[] thongTin = dao_phong.getThongTinDatPhong(ma);
        
        txt_maPhong.setText(thongTin[0]);
        txt_GioNhanPhong.setText(thongTin[1]);
        txt_soDT.setText(thongTin[2]);
        txt_khachHang.setText(thongTin[3]);
        txt_maHD.setText(thongTin[4]);
        
        
        DAO_ChiTietDichVu_HoaDon dao_ctdv = new DAO_ChiTietDichVu_HoaDon();
        
        ArrayList<ChiTietDichVuHoaDon> dsCTDV_dangSuDung = new ArrayList<>();
        dsCTDV_dangSuDung = dao_ctdv.getDSDVdangSuDung(thongTin[0], thongTin[4]);
        
        DefaultTableModel model_dv_dangSuDung = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
        
        model_dv_dangSuDung.setRowCount(0);
        for(ChiTietDichVuHoaDon ctdv: dsCTDV_dangSuDung){
            String[] row = { ctdv.getDichVu().getTenDichVu(), ctdv.getDichVu().getGia()+"", ctdv.getSoLuong()+""};
            model_dv_dangSuDung.addRow(row);
        }
        
    }
    
    
      
    
    public void loadDSPhongDangSuDung(){
        ContainerListPhong.removeAll();
        
         dao.DAO_Phong dao_phong = new DAO_Phong();
         ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
         ArrayList<entity.Phong> listPhong1 = new ArrayList<entity.Phong>();
         listPhong = dao_phong.getAll(Phong.class);
         // khoi tao chạy lần đầu
      
           
                
                listPhong1 = dao_phong.getPhongTheoTrangThai(2);
                
               
//       
        
        danhSachPhong = new smallPanel.Panel_DanhSachPhongFullColMini(listPhong1,GD_XuLy_GoiDichVu.class);
        ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
        ContainerListPhong.getComponent(0).setBackground(Color.white);
        
        
            
    }
    
    public void loadDSTatCaDichVu(){
        DefaultTableModel model_allDV= (DefaultTableModel) tableTatCaDV.getModel();
        
        model_allDV.setRowCount(0);
        
        DAO_DichVu dao_dichvu = new DAO_DichVu();
        ArrayList<DichVu> listAllDV = new ArrayList<>();
        listAllDV = dao_dichvu.getAll(DichVu.class);
        
        for(DichVu dv: listAllDV){
            String[] row = {dv.getMaDichVu(), dv.getTenDichVu(), dv.getGia() +""};
            model_allDV.addRow(row);
        }
        
           
           
           
            
       
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
        txt_soDT = new app.bolivia.swing.JCTextField();
        txt_GioNhanPhong = new app.bolivia.swing.JCTextField();
        txt_khachHang = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_dvPhongDangSuDung = new rojeru_san.complementos.RSTableMetro();
        jLabel4 = new javax.swing.JLabel();
        txt_maPhong = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_maHD = new app.bolivia.swing.JCTextField();
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

        txt_soDT.setEditable(false);
        txt_soDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_GioNhanPhong.setEditable(false);
        txt_GioNhanPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txt_khachHang.setEditable(false);
        txt_khachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setText("Dịch vụ phòng đang sử dụng:");

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel7.setText("Tên khách hàng:");

        table_dvPhongDangSuDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Giá", "Số lượng", ""
            }
        ));
        table_dvPhongDangSuDung.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        table_dvPhongDangSuDung.setColorBordeFilas(new java.awt.Color(0, 102, 102));
        table_dvPhongDangSuDung.setColorBordeHead(new java.awt.Color(0, 102, 102));
        table_dvPhongDangSuDung.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        table_dvPhongDangSuDung.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        table_dvPhongDangSuDung.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        table_dvPhongDangSuDung.setColorSelBackgound(new java.awt.Color(0, 153, 153));
        table_dvPhongDangSuDung.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_dvPhongDangSuDung.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_dvPhongDangSuDung.setRowHeight(36);
        table_dvPhongDangSuDung.setSelectionBackground(new java.awt.Color(0, 204, 204));
        table_dvPhongDangSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dvPhongDangSuDungxoaMotDongTable(evt);
            }
        });
        jScrollPane5.setViewportView(table_dvPhongDangSuDung);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Mã phòng:");

        txt_maPhong.setEditable(false);
        txt_maPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Mã hóa đơn:");

        txt_maHD.setEditable(false);
        txt_maHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                            .addComponent(txt_soDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_khachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_maHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        Panel_ThongTinKhachHangLayout.setVerticalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txt_soDT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txt_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        Container_GoiDichVu.add(Panel_ThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 670, 740));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH DỊCH VỤ CỦA CỬA HÀNG:");
        Container_GoiDichVu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 400, -1));

        btn_XacNhanDichVu.setBackground(new java.awt.Color(0, 204, 204));
        btn_XacNhanDichVu.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_XacNhanDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btn_XacNhanDichVu.setText("XÁC NHẬN DỊCH VỤ");
        btn_XacNhanDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xacNhanDichVu(evt);
            }
        });
        Container_GoiDichVu.add(btn_XacNhanDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 770, 670, 60));

        tableTatCaDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTatCaDV.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tableTatCaDV.setColorBordeFilas(new java.awt.Color(0, 102, 102));
        tableTatCaDV.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tableTatCaDV.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tableTatCaDV.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tableTatCaDV.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tableTatCaDV.setColorSelBackgound(new java.awt.Color(0, 153, 153));
        tableTatCaDV.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableTatCaDV.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableTatCaDV.setRowHeight(36);
        tableTatCaDV.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tableTatCaDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTatCaDVxoaMotDongTable(evt);
                themDichVu(evt);
            }
        });
        jScrollPane2.setViewportView(tableTatCaDV);

        Container_GoiDichVu.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 890, 370));

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

    private void tableTatCaDVxoaMotDongTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTatCaDVxoaMotDongTable
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
    }//GEN-LAST:event_tableTatCaDVxoaMotDongTable

    private void table_dvPhongDangSuDungxoaMotDongTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dvPhongDangSuDungxoaMotDongTable
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
    }//GEN-LAST:event_table_dvPhongDangSuDungxoaMotDongTable

    private void themDichVu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themDichVu
        if (evt.getClickCount() == 2) { // Kiểm tra xem là double click
            int selectedRow = tableTatCaDV.getSelectedRow();
            String maDV = (String) tableTatCaDV.getValueAt(tableTatCaDV.getSelectedRow(), 0);
            
            DichVu dv = new DichVu();
            dv = I_CRUD.findById(maDV, new DichVu());
            
            String sl = JOptionPane.showInputDialog(null, "Nhập số lượng dịch vụ: ");
            
            String[] row = {dv.getTenDichVu(), dv.getGia()+"", sl +""};
            
            DefaultTableModel model_dv_dangsudung = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
            model_dv_dangsudung.addRow(row);

        }
    }//GEN-LAST:event_themDichVu

    private void xacNhanDichVu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xacNhanDichVu
        
        model = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
          
        
        
        DAO_ChiTietDichVu_HoaDon dao_ctdv = new DAO_ChiTietDichVu_HoaDon();
                
        
        
        String maPhong = txt_maPhong.getText();
        String maHD = txt_maHD.getText();
       
        
        
       
        
        for(int i=0; i<model.getRowCount(); i++){
             String maDV = DAO_DichVu.timMatheoTenDV(model.getValueAt(i, 0).toString());
            int sl = Integer.parseInt(model.getValueAt(i, 2).toString());
            
            DichVu dv = I_CRUD.findById(maDV, new DichVu());
            
            HoaDon hd = I_CRUD.findById(maHD, new HoaDon());
            
            Phong p = I_CRUD.findById(maPhong, new Phong());
           
            
            ChiTietDichVuHoaDon newCTDV = new ChiTietDichVuHoaDon(sl, dv, hd, p);
            
            if(dao_ctdv.timChiTietDichVuHoaDon(maPhong, maHD, maDV)!=null){
                dao_ctdv.upDateSoLuong(newCTDV);
            }
            else{
                dao_ctdv.themCTHD_DvMoi(newCTDV);
            }
            
        }
              
        

        
               
                 

        ArrayList<String> listXoa;
        listXoa = new ArrayList<>();      
        DefaultTableModel model_dvDangSd = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
        
        
       for(ChiTietDichVuHoaDon ct: dao_ctdv.getDSDVdangSuDung(maPhong, maHD)){
           if(isBiXoa(ct.getDichVu().getTenDichVu())){
//               
               JOptionPane.showMessageDialog(null, "Đã bị xóa: " + ct.getDichVu().getTenDichVu());
               listXoa.add(ct.getDichVu().getTenDichVu());
           }
       }
//       
       for(String ten: listXoa){
           dao_ctdv.xoaMotCTDV(DAO_DichVu.timMatheoTenDV(ten), maHD, maPhong);
             JOptionPane.showMessageDialog(null, ten);
       }
       
        JOptionPane.showMessageDialog(null, "Cập nhật dịch vụ thành công");
          

    }//GEN-LAST:event_xacNhanDichVu
    
    public boolean isBiXoa(String ten){
        DefaultTableModel model = (DefaultTableModel) table_dvPhongDangSuDung.getModel();
        for(int i=0; i<model.getRowCount(); i++){
            if(model.getValueAt(i, 0).equals(ten))
                return false;
        }
        return true;
    }
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
    smallPanel.Panel_DanhSachPhongFullColMini danhSachPhong;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContainerListPhong;
    private javax.swing.JPanel Container_GoiDichVu;
    private javax.swing.JPanel Panel_ThongTinKhachHang;
    private javax.swing.JButton btn_XacNhanDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    public static rojeru_san.complementos.RSTableMetro tableTatCaDV;
    public static rojeru_san.complementos.RSTableMetro table_dvPhongDangSuDung;
    public static app.bolivia.swing.JCTextField txt_GioNhanPhong;
    private static app.bolivia.swing.JCTextField txt_khachHang;
    public static app.bolivia.swing.JCTextField txt_maHD;
    public static app.bolivia.swing.JCTextField txt_maPhong;
    private static app.bolivia.swing.JCTextField txt_soDT;
    // End of variables declaration//GEN-END:variables
    public static DefaultTableModel model  =new DefaultTableModel();
    public static DefaultTableModel modelTableTatCaDV;
    private ArrayList<ChiTietDichVuHoaDon> mangXoa = new ArrayList<>();
    
    public String maPhongDangDuocChon = "";
    
    public static void setThongTinDatPhong(String codePhong){
//          
            
        String maPhongDangChon = smallPanel.Panel_DanhSachPhongFullCol.maPhongGoiDVduocChon;
//        JOptionPane.showMessageDialog(null, "Phong dang chon: "+maPhongDangChon);
        
        String ma = codePhong.substring(codePhong.length() - 5);
        
        DAO_Phong dao_phong = new DAO_Phong();
        
        String[] thongTin = dao_phong.getThongTinDatPhong(ma);
        JOptionPane.showMessageDialog(null, "Vy"+thongTin);

        
       
    }
    
    

}
