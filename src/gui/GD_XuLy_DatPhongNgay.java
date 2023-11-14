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
public class GD_XuLy_DatPhongNgay extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form GD_XuLy_DatPhongNgay
     */
    public GD_XuLy_DatPhongNgay() {
        thread = new Thread(this);
        thread.start();
        initComponents();

        
        loadDSPhongTrong();
        
        tuDongTimKiemKhachHang();
        
        editTable();
        
        

		
    }
    
    
    public void editTable(){
        TableActionEvent event = new TableActionEvent() {
//            @Override
//            public void onEdit(int row) {
//                System.out.println("Edit row : " + row);
//            }

            @Override
            public void onDelete(int row) {
                if (tablePhongDatNgay.isEditing()) {
                    tablePhongDatNgay.getCellEditor().stopCellEditing();
                }
                int selectedRow = tablePhongDatNgay.getSelectedRow();
                String maPhong = (String) tablePhongDatNgay.getValueAt(tablePhongDatNgay.getSelectedRow(), 0);
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

            @Override
            public void onSubtract(int row) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void onAdd(int row) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

  
        };
        
        TableActionCellRender tableActionCellRender = new TableActionCellRender();
        
        
        
        tablePhongDatNgay.getColumnModel().getColumn(4).setCellRenderer( tableActionCellRender);
        tablePhongDatNgay.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
//        tablePhongDatNgay.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
//                setHorizontalAlignment(SwingConstants.RIGHT);
//                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
//            }
//        });

    
    }
    
    public boolean datPhong(){
        DAO_HoaDon daoHD = new DAO_HoaDon();
        DAO_ChiTietPhong_HoaDon dao_ctP_HD = new DAO_ChiTietPhong_HoaDon();
        DAO_Phong daoPhong = new DAO_Phong();
        DAO_KhachHang dao_khachHang = new DAO_KhachHang();
        
        
       ////-------------
        ArrayList<HoaDon> lsHD = new ArrayList<>();
        lsHD = daoHD.getAll(HoaDon.class);
//        ArrayList<String> dsId = new ArrayList<>();
//        for(HoaDon hd: lsHD){
//            dsId.add(hd.getMaHoaDon());
//        }
//        String lastID = dsId.get(lsHD.size() - 1).toString();
//            // tách chuỗi để lấy số thứ tự
//        int index = Integer.parseInt(lastID.substring(2)) + 1;
//        //tự động tạo mã hóa đơn mới
//        String newID = "HD" + String.format("%03d", index);
//        
        
        //---Kiểm tra khách hàng 
        String sdtKhachHang = txt_SoDT.getEditor().getItem().toString();
        KhachHang khachHang = new KhachHang();
        
        if(I_CRUD.findById(sdtKhachHang, new KhachHang()).getSoDienThoai() != null){
            khachHang = I_CRUD.findById(txt_SoDT.getSelectedItem().toString().trim(), new KhachHang());
        }
        else {
            khachHang = new KhachHang(sdtKhachHang, txt_khachHang.getText());
            dao_khachHang.create(khachHang);
        }
        
        
        
        
        //---Tạo hóa đơn mới
        HoaDon hd = new HoaDon(I_TraCuu_QuanLi.createIdForHoaDon(daoHD.getDsIdTheoNgayHienTai(), "HD"), LocalDateTime.now(), 1, khachHang , 
                            txt_MaUuDai.getText().equals("")?I_CRUD.findById("UD001", new UuDai()):I_CRUD.findById(txt_MaUuDai.getText().trim(), new UuDai()), I_CRUD.findById("NV001", new NhanVien()));
        daoHD.create(hd);
        
        
        
        model = (DefaultTableModel) tablePhongDatNgay.getModel();
          
        int count = model.getRowCount();
        
          
        for(int i=0; i<count; i++){ 
            String maPhong = (String) model.getValueAt(i, 0);
            ChitTietPhongHoaDon ctPhongHD = new ChitTietPhongHoaDon(LocalDateTime.now(), null, "MP000 Đang sử dụng", hd, I_CRUD.findById(maPhong+"".trim(), new Phong()));
            dao_ctP_HD.themCTHD_PMoi(ctPhongHD);
            daoPhong.capNhatTrangThaiPhong(maPhong, 2); //Cập nhật trạng thái phòng
        }
        
        
        
        
        
        
        
        
        
          
        
        return true;
    }   
    
    public void loadDSPhongTrong(){
        ContainerListPhong.removeAll();
        dao.DAO_Phong dao_phong = new DAO_Phong();
         ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
        ArrayList<entity.Phong> listPhong1 = new ArrayList<entity.Phong>();
                listPhong = dao_phong.getAll(Phong.class);

                listPhong1 = dao_phong.getPhongTheoTrangThai(0);

                

//       
        
        danhSachPhong = new smallPanel.Panel_DanhSachPhongFullCol(listPhong1,GD_XuLy_DatPhongNgay.class);

                
        
        ContainerListPhong.add( danhSachPhong.getContentPane(), BorderLayout.WEST);
        ContainerListPhong.getComponent(0).setBackground(Color.white);
        String test = danhSachPhong.codePhong;
        
    }
    
    public void tuDongTimKiemKhachHang(){
        txt_SoDT.removeAllItems();
        txt_SoDT.addItem("");
        DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		// tự động kiểm tra
        AutoCompleteDecorator.decorate(txt_SoDT);
        txt_SoDT.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        if (txt_SoDT.getSelectedItem() != null) {
                                String soDT = txt_SoDT.getSelectedItem().toString().trim();
                                kiemTraSDT(soDT);
                        }
                }
        });
        for (KhachHang kH : dao_KhachHang.getAll(KhachHang.class)) {
                txt_SoDT.addItem(kH.getSoDienThoai());
        }
    }
    public boolean kiemTraSDT(String soDT) {
            
		KhachHang khachHang = I_CRUD.findById(soDT, new KhachHang());
		if (khachHang != null) {
			
			txt_khachHang.setText(khachHang.getTenKhachHang());
			
			return false;
		}
		
		txt_khachHang.setText("");
		
		return true;
	}
    
   public  void run(){
        try {
			Date thoiGianHienTai = new Date();
			SimpleDateFormat sdf_Gio = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat sdf_Ngay = new SimpleDateFormat("dd/MM/yyyy");
			while (true) {
				thoiGianHienTai = new Date(); // lấy thời gian hiện tại
				String ngayTrongTuan = "";
				if (thoiGianHienTai.getDay() == 0)
					ngayTrongTuan = "Chủ nhật, ";
				else
					ngayTrongTuan = "Thứ " + (thoiGianHienTai.getDay() + 1) + ", ";// do getDay() tính từ 1.
				thread.sleep(1000); // cho phép ngủ trong khoảng 1000 mns =1s
				// lấy thời gian hiện tại vào giờ vào
                                txt_GioNhanPhong.setText(
                                        sdf_Gio.format(thoiGianHienTai) + " " + ngayTrongTuan +
                                        sdf_Ngay.format(thoiGianHienTai)
                                        );
                                
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
        jLabel3 = new javax.swing.JLabel();
        txt_MaUuDai = new app.bolivia.swing.JCTextField();
        txt_GioNhanPhong = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_DatPhongNgay = new javax.swing.JButton();
        Panel_ThongTinKhachHang1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_SoDT = new javax.swing.JComboBox<>();
        txt_khachHang = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePhongDatNgay = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1096, 964));
        setResizable(false);

        Container_DatPhongNgay.setBackground(new java.awt.Color(255, 255, 255));
        Container_DatPhongNgay.setMaximumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setMinimumSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setPreferredSize(new java.awt.Dimension(1620, 964));
        Container_DatPhongNgay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContainerListPhong.setBackground(new java.awt.Color(255, 255, 255));
        ContainerListPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHÒNG TRỐNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N
        ContainerListPhong.setMaximumSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setMinimumSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setName(""); // NOI18N
        ContainerListPhong.setPreferredSize(new java.awt.Dimension(900, 964));
        ContainerListPhong.setVerifyInputWhenFocusTarget(false);
        ContainerListPhong.setLayout(new java.awt.BorderLayout());
        Container_DatPhongNgay.add(ContainerListPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 890, 964));

        Panel_ThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setText("Giờ nhận phòng:");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setText("Mã ưu đãi:");

        txt_MaUuDai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_GioNhanPhong.setEditable(false);
        txt_GioNhanPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout Panel_ThongTinKhachHangLayout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang);
        Panel_ThongTinKhachHang.setLayout(Panel_ThongTinKhachHangLayout);
        Panel_ThongTinKhachHangLayout.setHorizontalGroup(
            Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MaUuDai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_GioNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
                        .addGap(45, 45, 45))
                    .addGroup(Panel_ThongTinKhachHangLayout.createSequentialGroup()
                        .addGroup(Panel_ThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addContainerGap())
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 670, 200));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("PHÒNG ĐƯỢC CHỌN:");
        Container_DatPhongNgay.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, 210, -1));

        btn_DatPhongNgay.setBackground(new java.awt.Color(0, 204, 204));
        btn_DatPhongNgay.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btn_DatPhongNgay.setForeground(new java.awt.Color(255, 255, 255));
        btn_DatPhongNgay.setText("ĐẶT PHÒNG NGAY");
        btn_DatPhongNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datPhongNgay(evt);
            }
        });
        Container_DatPhongNgay.add(btn_DatPhongNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 780, 670, 60));

        Panel_ThongTinKhachHang1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_ThongTinKhachHang1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel5.setText("Tên khách hàng:");

        txt_SoDT.setEditable(true);
        txt_SoDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_SoDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", " " }));

        txt_khachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout Panel_ThongTinKhachHang1Layout = new javax.swing.GroupLayout(Panel_ThongTinKhachHang1);
        Panel_ThongTinKhachHang1.setLayout(Panel_ThongTinKhachHang1Layout);
        Panel_ThongTinKhachHang1Layout.setHorizontalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SoDT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        Panel_ThongTinKhachHang1Layout.setVerticalGroup(
            Panel_ThongTinKhachHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ThongTinKhachHang1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        Container_DatPhongNgay.add(Panel_ThongTinKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 670, 210));

        tablePhongDatNgay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng", "Loại Phòng", "Sức chứa", "Giá phòng", ""
            }
        ));
        tablePhongDatNgay.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        tablePhongDatNgay.setColorBordeFilas(new java.awt.Color(0, 102, 102));
        tablePhongDatNgay.setColorBordeHead(new java.awt.Color(0, 102, 102));
        tablePhongDatNgay.setColorFilasBackgound2(new java.awt.Color(153, 255, 204));
        tablePhongDatNgay.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablePhongDatNgay.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablePhongDatNgay.setColorSelBackgound(new java.awt.Color(0, 153, 153));
        tablePhongDatNgay.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablePhongDatNgay.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablePhongDatNgay.setRowHeight(36);
        tablePhongDatNgay.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablePhongDatNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaMotDongTable(evt);
            }
        });
        jScrollPane2.setViewportView(tablePhongDatNgay);

        Container_DatPhongNgay.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 490, 670, 270));

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
        if(datPhong()){
            JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
            loadDSPhongTrong();
            model.setRowCount(0);
            txt_SoDT.setSelectedIndex(0);
            txt_khachHang.setText("");
        }
    }//GEN-LAST:event_datPhongNgay

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

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
    private javax.swing.JButton btn_DatPhongNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    public static rojeru_san.complementos.RSTableMetro tablePhongDatNgay;
    private app.bolivia.swing.JCTextField txt_GioNhanPhong;
    private app.bolivia.swing.JCTextField txt_MaUuDai;
    private javax.swing.JComboBox<String> txt_SoDT;
    private app.bolivia.swing.JCTextField txt_khachHang;
    // End of variables declaration//GEN-END:variables
    public static DefaultTableModel model  =new DefaultTableModel();
    private Thread thread = null;
    public static void setTableData(String codePhong){
          model = (DefaultTableModel) tablePhongDatNgay.getModel();
          String ma = codePhong.substring(codePhong.length() - 5);
          
          int count = model.getRowCount();
          
          for(int i=0; i<count; i++){
              if(model.getValueAt(i, 0).equals(ma)){
                  JOptionPane.showMessageDialog(null, "Phòng đã được chọn");
                 return;
              }
              
          }
          
          Phong p = new Phong();
            
                    p = I_CRUD.findById(ma, new Phong());
                   String[] row = {ma, p.getLoaiPhong().getLoaiPhong(), p.getSucChuaToiDa()+"", p.getGiaPhongTheoGio()+""};
           
           
           
            model.addRow(row);
        // In kết quả
            
          
          
        
//        model.addColumn("Code phong");
//        tablePhongDatNgay = new JTable();
//        tablePhongDatNgay.setModel(model);
       
    }
    
    

}
