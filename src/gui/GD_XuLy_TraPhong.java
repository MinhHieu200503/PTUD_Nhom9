package gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */





import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.DAO_Phong;
import entity.ThongTinPhongDangChon;
import entity.UuDai;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author LENOVO
 */
public class GD_XuLy_TraPhong extends javax.swing.JFrame {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    

    /**
     * Creates new form GD_XuLyDanhSachPhong
     */
    public GD_XuLy_TraPhong() {
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 10 );
        UIManager.put( "Component.arc", 10 );
        UIManager.put( "ProgressBar.arc", 10 );
        UIManager.put( "TextComponent.arc", 10 );
        initComponents();
        // Create model
        fullLoad();
       
    }
    
    public void fullLoad(){
        jPanel12.removeAll();
        jPanel2.setVisible(false);
        jPanel2.setVisible(true);
        model = new DefaultTableModel(new String[] {"Phòng"}, 0);
        rSTableMetro1.setModel(model);
        
        //LoadData From SQL
        dao.DAO_Phong dao_Phong = new DAO_Phong();
        ArrayList<entity.Phong> entity_Phong = dao_Phong.getPhongTheoTrangThai(2);
        ArrayList<Panel_Phong> temp = new ArrayList<>();

        for (entity.Phong phong : entity_Phong) {
            temp.add(new Panel_Phong(phong));
        }   
        
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel8.setText("");
        jLabel10.setText("");
        jLabel12.setText("");
        jLabel14.setText("");
        jLabel16.setText("");
        jLabel18.setText("");
        loadData(temp);
        repaint();
        jPanel2.setVisible(false);
        jPanel2.setVisible(true);
    }
    
    public void loadData(ArrayList<Panel_Phong> temp){
        // Example = 7
        // Create row
        int dongChiaHetCho3 = temp.size()/3;
        
        JPanel rowBox = rowBox();

        for (int i = 0; i < dongChiaHetCho3*3; i++) {
            if(i%3 == 0){
                rowBox = rowBox();
            }
            rowBox.add(temp.get(i));
            if(i%3 == 2){
                jPanel12.add(rowBox);
            }
        }
                    
        for (int i = dongChiaHetCho3*3; i<temp.size();i++){
            if(i%3 == 0){
                rowBox = rowBox();
            }
            rowBox.add(temp.get(i));
        }
        jPanel12.add(rowBox);
        jPanel12.setPreferredSize(new Dimension(1012, (158+5)  * (dongChiaHetCho3)));
    }
    
    public JPanel rowBox(){
        JPanel rowBox = new JPanel();
        rowBox.setLayout(new FlowLayout());
        rowBox.setMaximumSize(new java.awt.Dimension(984, 170));
        rowBox.setMinimumSize(new java.awt.Dimension(984, 170));
        rowBox.setPreferredSize(new java.awt.Dimension(984, 170));
        rowBox.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 5));
        rowBox.setBackground(Color.white);
        return rowBox;
    }
    
    public ArrayList<entity.ThongTinPhongDangChon> loadThongTinChiTietHoaDon(){
        ArrayList<entity.ThongTinPhongDangChon> result = new ArrayList<>();
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel8.setText("");
        jLabel10.setText("");
        jLabel12.setText("");
        jLabel14.setText("");
        jLabel16.setText("");
        jLabel18.setText("");

        double tongDichVu = 0.0;
        double tongTienPhong = 0.0;
        String ghiChu = "";
        for (int i = 0; i < model.getRowCount(); i++) {
            result.add( new dao.DAO_HoaDon().getThongTinTraPhong(String.valueOf(model.getValueAt(i, 0))));
            if (i != model.getRowCount()-1){
                jLabel4.setText(checkString(jLabel4, result.get(i).getMaPhong() + ", "));
                jLabel6.setText(checkString(jLabel6, result.get(i).getTenKhachHang() + ", "));
                jLabel8.setText(checkString(jLabel8, result.get(i).thoiGianNhanPhong() +", "));
                jLabel10.setText(checkString(jLabel10, result.get(i).tongThoiGianSuDung() +"Phút, "));
                jLabel16.setText(checkString(jLabel16, result.get(i).ghiChu()+ ", "));
            }else{
                jLabel4.setText(checkString(jLabel4, result.get(i).getMaPhong()  ));
                jLabel6.setText(checkString(jLabel6, result.get(i).getTenKhachHang() ));
                jLabel8.setText(checkString(jLabel8, result.get(i).thoiGianNhanPhong() ));
                jLabel10.setText(checkString(jLabel10, result.get(i).tongThoiGianSuDung() +"Phút"));
                jLabel16.setText(checkString(jLabel16, result.get(i).ghiChu()));
            }
            
           
            tongDichVu = tongDichVu + result.get(i).tongTienDichVu();
            tongTienPhong = tongTienPhong + result.get(i).tongTienPhong();
        }
        
        jLabel12.setText(formatter.format(tongDichVu)+" VNĐ");
        
        jLabel14.setText(formatter.format(tongTienPhong)+" VNĐ");
        jLabel18.setText(formatter.format(tongDichVu + tongTienPhong)+" VNĐ");
        
      
        
        
        return result;
    }
    
    public String checkString(JLabel label, String value){
        if (label.getText().length() > 20){
            return label.getText().substring(0, label.getText().length()-2) + "...";
        }
        else{
            return label.getText() + value;
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

        rightPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1620, 964));

        rightPanel.setMaximumSize(new java.awt.Dimension(518, 964));
        rightPanel.setMinimumSize(new java.awt.Dimension(518, 964));
        rightPanel.setPreferredSize(new java.awt.Dimension(518, 964));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(506, 444));
        jPanel1.setMinimumSize(new java.awt.Dimension(506, 444));
        jPanel1.setPreferredSize(new java.awt.Dimension(506, 444));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("Phòng Đã Chọn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(506, 426));
        jPanel2.setMinimumSize(new java.awt.Dimension(506, 426));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setText("Chi Tiết Hóa Đơn");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 18, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel4.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Phòng:");
        jPanel4.add(jLabel3, java.awt.BorderLayout.WEST);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("203, 204, 205");
        jPanel4.add(jLabel4, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 68, 470, 44));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel5.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Khách hàng:");
        jPanel5.add(jLabel5, java.awt.BorderLayout.WEST);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Trần Thị Thúy Vy, Lại Dương Minh Hiếu ,...");
        jPanel5.add(jLabel6, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, 470, 44));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel6.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thời gian nhận phòng:");
        jPanel6.add(jLabel7, java.awt.BorderLayout.WEST);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("11:30PM, 12:30PM, 1:03AM");
        jPanel6.add(jLabel8, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 156, 470, 44));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel7.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Thời gian sử dụng:");
        jPanel7.add(jLabel9, java.awt.BorderLayout.WEST);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("90p, 150p, 200p");
        jPanel7.add(jLabel10, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 470, 44));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel8.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Tổng tiền dịch vụ:");
        jPanel8.add(jLabel11, java.awt.BorderLayout.WEST);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("500.000Đ");
        jPanel8.add(jLabel12, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 244, 470, 44));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel9.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tổng tiền phòng:");
        jPanel9.add(jLabel13, java.awt.BorderLayout.WEST);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("600.000.000Đ");
        jPanel9.add(jLabel14, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 288, 470, 44));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel10.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Ghi chú:");
        jPanel10.add(jLabel15, java.awt.BorderLayout.WEST);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("203 <- 001");
        jPanel10.add(jLabel16, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 332, 470, 44));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(392, 44));
        jPanel11.setMinimumSize(new java.awt.Dimension(392, 44));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Tổng tiền:");
        jPanel11.add(jLabel17, java.awt.BorderLayout.WEST);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("660.000.000Đ");
        jPanel11.add(jLabel18, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 376, 470, 44));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle1.setText("Trả Phòng");
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thanhToanHoaDonFrame(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1090, 952));
        jPanel3.setMinimumSize(new java.awt.Dimension(1090, 952));
        jPanel3.setPreferredSize(new java.awt.Dimension(1090, 952));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jPanel12);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(1012, 99999));
        jPanel12.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(1012, 99999));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));
        jScrollPane2.setViewportView(jPanel12);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 924, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 912, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thanhToanHoaDonFrame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thanhToanHoaDonFrame
        try {
            if (model.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng để trả");
            }
            else{
                new GD_XuLy_TraPhong_HoaDon(loadThongTinChiTietHoaDon()).setVisible(true);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GD_XuLy_TraPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_thanhToanHoaDonFrame

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_TraPhong().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel model;
            
            
    public class Panel_Phong extends javax.swing.JPanel {
        
    public Panel_Phong(entity.Phong data) {
        initComponents();
        this.setBorder(new RoundedBorder(90));
        this.entityPhong = data;
        setData(this.entityPhong);
        System.out.println(this.entityPhong.getTrangThai());
        if (this.entityPhong.getTrangThai() == 2){
            lb_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Status_Unvailable123.png")));
        }

        if (this.entityPhong.getLoaiPhong().getMaLoaiPhong().equals("LP001")){
            logoVip.setVisible(false);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#A1FFCE"), w, h, Color.decode("#FAFFD1"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,40,40);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   private void initComponents() {

        lb_Icon = new javax.swing.JLabel();
        lb_TenPhong = new javax.swing.JLabel();
        lb_SucChua = new javax.swing.JLabel();
        lb_Gia = new javax.swing.JLabel();
        logoVip = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 153), new java.awt.Color(0, 51, 204), new java.awt.Color(0, 204, 0), new java.awt.Color(255, 102, 255)));
        setMaximumSize(new java.awt.Dimension(262, 135));
        setMinimumSize(new java.awt.Dimension(262, 135));
        setPreferredSize(new java.awt.Dimension(262, 135));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Status_Available.png"))); // NOI18N
        add(lb_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 49));

        lb_TenPhong.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lb_TenPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_TenPhong.setText("Phòng: 101 - Ha");
        add(lb_TenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        lb_SucChua.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lb_SucChua.setText("Sức chứa: 20");
        add(lb_SucChua, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        lb_Gia.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lb_Gia.setText("Giá : 150.000 VND ");
        add(lb_Gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        logoVip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vip-Mini.gif"))); // NOI18N
        add(logoVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickPanel(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredPanel(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedPanel(evt);
            }
        });
    }                        

    private void clickPanel(java.awt.event.MouseEvent evt) {                            
            if (evt.getClickCount() == 2) {
                if(this.getFlag() == false){
                    Border border = new LineBorder(Color.GREEN, 4, true);
                    this.setBorder(border);
                    flag = true;
                    model.addRow(new String[] {String.valueOf(this.entityPhong.getMaPhong())});
                    loadThongTinChiTietHoaDon();
                }
                else{
                   this.setBorder(new RoundedBorder(90));
                   flag = false;
                   for (int i = 0; i < model.getRowCount(); i++){
                       if (String.valueOf(this.entityPhong.getMaPhong()).equals(model.getValueAt(i, 0))){
                           model.removeRow(i);
                           loadThongTinChiTietHoaDon();
                           return;
                       }
                   }
                   
            }
            }
            
    }
    
    private void enteredPanel(java.awt.event.MouseEvent evt) {
                if (this.getFlag() != true){
                    Border border = new LineBorder(Color.ORANGE, 4, true);
                    this.setBorder(border);
                }

    }                             

    private void exitedPanel(java.awt.event.MouseEvent evt) {        
                if (this.getFlag() != true){
                       this.setBorder(new Panel_Phong.RoundedBorder(90));
                }

    }      
    
    public void setData(entity.Phong data){
        lb_TenPhong.setText(data.getTenPhong() + " - " + data.getMaPhong());
        lb_SucChua.setText("Sức chứa: " + String.valueOf(data.getLoaiPhong().getSucChua()));
        lb_Gia.setText("Giá: " + formatter.format(data.getLoaiPhong().getGia()) + " VNĐ");
    }
    
    public boolean getFlag(){
        return flag;
    }
     
    protected entity.Phong entityPhong;
    private boolean flag = false;
    // Variables declaration - do not modify                     
    private javax.swing.JLabel lb_Gia;
    private javax.swing.JLabel lb_Icon;
    private javax.swing.JLabel lb_SucChua;
    private javax.swing.JLabel lb_TenPhong;
    private javax.swing.JLabel logoVip;
    // End of variables declaration                   
    //RoundBorder
    private static class RoundedBorder implements Border {
        
        private int radius;
        
        RoundedBorder(int radius) {
            this.radius = radius;
            
            
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
            
//            c.setForeground(Color.red);
            
        }
    }
}
    

    
public class GD_XuLy_TraPhong_HoaDon extends javax.swing.JFrame implements dao.I_CRUD{
    boolean check = false;
    /**
     * Creates new form GD_XuLy_TraPhong_TinhTien
     */
    DefaultTableModel model =  new DefaultTableModel(new String [] {"Tên hàng và dịch vụ", "Đơn giá", "Số lượng", "Tổng", "Ghi chú"}, 0);
    double tongTienCanThanhToan;
    ArrayList<entity.ThongTinPhongDangChon> data;
    entity.UuDai uuDai = new UuDai("", null, 0.0, null, null);
    double tongKhongUuDai = 0.0;
    LocalDateTime thoiGianTraPhongButton;
    
    public GD_XuLy_TraPhong_HoaDon(ArrayList<entity.ThongTinPhongDangChon> data) throws FileNotFoundException {
        initComponents();
        this.data = data;
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(975, 952));
        if(data != null){
             loadData(data);
        }
        rSTableMetro1.setModel(model);
        
        
        //
        jCheckBox1.setVisible(true);
    }
    
     public ArrayList<int[]> loadFileTextField() throws FileNotFoundException{
        File file = new File("SettingVoucher.txt");

        ArrayList<int[]> diemTichLuy = new ArrayList<>();
        if (file.exists()){   
            Scanner sc = new Scanner(file);
            
            diemTichLuy.add(new int[]{Integer.valueOf(sc.nextLine())});
            while (sc.hasNextLine()){
                String[] temp = sc.nextLine().split(";");
                diemTichLuy.add(new int[]{Integer.valueOf(temp[0]), Integer.valueOf(temp[1])});
            }
        }
        // file không tồn tại-> tạo
        else{
            Formatter createFile = new Formatter(file);
            //DATA TEMP
            diemTichLuy = new ArrayList<>();
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            diemTichLuy.add(new int[]{0, 0});
            
            
            writeFile(diemTichLuy);
            createFile.close();
        }
        return diemTichLuy;
     }
     
    public void writeFile(ArrayList<int[]> data) throws FileNotFoundException{
        File file = new File("SettingVoucher.txt");
        Formatter f = new Formatter(file);
        for (int[] is : data) {
            if (is.length == 1 ){
                f.format("%d\n", is[0]);
            }
            else{
                f.format("%d;%d\n", is[0], is[1]);
            }
        }
        f.close();
    }
    public void loadData(ArrayList<entity.ThongTinPhongDangChon> data) throws FileNotFoundException{
        LocalDateTime resultTGDP = LocalDateTime.now();
        
        double tong=0.0;
        
        int thoiGianSuDung = 0;
        double datCoc = 0.0;
        double tienGiamDiemTichLuy = 0.0;
        

        
        boolean choPhepNhapMa = false;
        
        ArrayList<int[]> chuongTrinhKhuyenMai = loadFileTextField();
        
        for (ThongTinPhongDangChon thongTinPhongDangChon : data) {
            double tongDichVu = 0.0;
            double tongTienPhong = 0.0;
            LocalDateTime resultTGDP1 = thongTinPhongDangChon.danhSachPhong.getLast().getChiTietPhongHoaDon().getThoiGianNhanPhong();
            System.out.println(thongTinPhongDangChon.toString());
            if (resultTGDP1.isBefore(resultTGDP)){
                resultTGDP = resultTGDP1;
            }
            thoiGianSuDung = thoiGianSuDung + Integer.valueOf((int) thongTinPhongDangChon.tongThoiGianSuDung());
            boolean flagMain = false;
            for (ThongTinPhongDangChon.PhongVaDichVu phongVaDichVu : thongTinPhongDangChon.danhSachPhong) {
                String tenPhong = phongVaDichVu.getChiTietPhongHoaDon().getPhong().getTenPhong();
                String giaPhong = formatter.format(Double.valueOf(phongVaDichVu.getChiTietPhongHoaDon().getPhong().getLoaiPhong().getGia() / 60 )) +"Đ/p";
                
                Duration timeResult = Duration.between(phongVaDichVu.getChiTietPhongHoaDon().getThoiGianTraPhong(), phongVaDichVu.getChiTietPhongHoaDon().getThoiGianNhanPhong());
                long minutes = Math.abs(timeResult.toMinutes());              
                String soLuong = String.valueOf(minutes);
                double tong2 = minutes * (phongVaDichVu.getChiTietPhongHoaDon().getPhong().getLoaiPhong().getGia()/ 60);
                model.addRow(new String[] {tenPhong, giaPhong, String.valueOf(minutes) + " Phút", formatter.format(tong2)+" VNĐ",
                            phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().contains("MP000")?
                            (thongTinPhongDangChon.getMaUuDai()==null?"":"Đã áp mã giảm giá"):
                            ( "Chuyển phòng "+ phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().substring(2,5))});
                    for (ThongTinPhongDangChon.PhongVaDichVu.DichVu dichVu : phongVaDichVu.dichVu) {
                        String tenDichVu = dichVu.getChiTietDichVu().getDichVu().getTenDichVu();
                        Double donGiaDichVu = dichVu.getChiTietDichVu().getDichVu().getGia();
                        int soLuongDichVu = dichVu.getChiTietDichVu().getSoLuong();
                        double tongTienDichVu = donGiaDichVu * soLuongDichVu;

                        model.addRow(new String[] {tenDichVu, 
                            formatter.format(donGiaDichVu)+" VNĐ",
                            String.valueOf(soLuongDichVu),
                            formatter.format(tongTienDichVu)+" VNĐ", ""
                        });
}
                
            }

            datCoc = datCoc + thongTinPhongDangChon.getDatCoc();

            
            // Tích điểm
        
            if (chuongTrinhKhuyenMai.get(3)[0] < thongTinPhongDangChon.getThoiGianSuDungTichLuy()){
                tienGiamDiemTichLuy = tienGiamDiemTichLuy +( (tongDichVu + tongTienPhong) * chuongTrinhKhuyenMai.get(3)[1]/100.0);
            }
            else if (chuongTrinhKhuyenMai.get(2)[0] < thongTinPhongDangChon.getThoiGianSuDungTichLuy()){
                tienGiamDiemTichLuy = tienGiamDiemTichLuy +( (tongDichVu + tongTienPhong) * chuongTrinhKhuyenMai.get(2)[1]/100.0);
            }
            else if (chuongTrinhKhuyenMai.get(1)[0] < thongTinPhongDangChon.getThoiGianSuDungTichLuy()){
                tienGiamDiemTichLuy = tienGiamDiemTichLuy +( (tongDichVu + tongTienPhong) * chuongTrinhKhuyenMai.get(1)[1]/100.0);
            }
            else{
                tienGiamDiemTichLuy = tienGiamDiemTichLuy;
            }
            
            
            double tongTemp = 0.0;
            double giamGia = 0.0;

            if (thongTinPhongDangChon.getMaUuDai()!=null){
                giamGia = dao.I_CRUD.findById(thongTinPhongDangChon.getMaUuDai(), new UuDai()).getGiamGia();

            }
            if (thongTinPhongDangChon.getMaUuDai()==null){
                choPhepNhapMa = true;
                tongKhongUuDai += thongTinPhongDangChon.tongTienDichVu() + thongTinPhongDangChon.tongTienPhong() - ((thongTinPhongDangChon.tongTienDichVu() + thongTinPhongDangChon.tongTienPhong()) * giamGia);
            }

            if (thongTinPhongDangChon.getMaUuDai() != null){
                model.addRow(new String[] {"", "", "", formatter.format(tongTemp)+" VNĐ",""});
            }
            tongTemp = thongTinPhongDangChon.tongTienDichVu() + thongTinPhongDangChon.tongTienPhong() - ((thongTinPhongDangChon.tongTienDichVu() + thongTinPhongDangChon.tongTienPhong()) * giamGia);

            tong += tongTemp;
        }
        
        if (choPhepNhapMa == false){
                    check = true;
                    rSMetroTextPlaceHolder1.setBorderColor(new Color(0,204,0));
                    rSMetroTextPlaceHolder1.setBackground(new Color(204,204,204));
                    rSMetroTextPlaceHolder1.setEditable(false);
        }
        
        jLabel4.setText(resultTGDP.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        jLabel6.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        Duration timeResult = Duration.between( LocalDateTime.now(), resultTGDP);

        jLabel8.setText(String.valueOf(Math.abs(timeResult.toMinutes()))+ " Phút");
        


        jLabel20.setText("- " + formatter.format(tienGiamDiemTichLuy) + " VNĐ");
        
        jLabel27.setText(formatter.format(tong)+" VNĐ");
        
        coc.setText("- " + formatter.format(datCoc)+" VNĐ");
        
        thue.setText(String.format("(%d", (chuongTrinhKhuyenMai.get(0)[0])) + "%) " + "+ " + formatter.format((chuongTrinhKhuyenMai.get(0)[0]/100.0)*tong)+" VNĐ");
        chuongTrinh.setText("- 0.000Đ");
 
        this.tongTienCanThanhToan = tong - datCoc + (chuongTrinhKhuyenMai.get(0)[0]/100.0*tong)  - tienGiamDiemTichLuy;

            if (tongTienCanThanhToan > 0){
                jLabel22.setText(formatter.format(this.tongTienCanThanhToan)+" VNĐ");
            }else{
                jLabel22.setText(formatter.format(0)+" VNĐ");
            }
       thoiGianTraPhongButton = LocalDateTime.now();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        thue = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        chuongTrinh = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        coc = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rSMetroTextPlaceHolder1 = new rojerusan.RSMetroTextPlaceHolder();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jCheckBox1 = new javax.swing.JCheckBox();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(990, 1000));
        setMinimumSize(new java.awt.Dimension(990, 1000));
        setPreferredSize(new java.awt.Dimension(990, 1000));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(975, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(975, 102));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KARAOKE ECHO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("157/18 Trần Bá Giao, Phường 5, Gò Vấp, TP.Hồ Chí Minh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(975, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(975, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(975, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel3.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Thời gian đặt phòng:");
        jPanel3.add(jLabel3, java.awt.BorderLayout.WEST);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("11:30 02/12/2003");
        jPanel3.add(jLabel4, java.awt.BorderLayout.EAST);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel4.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Thời gian trả phòng:");
        jPanel4.add(jLabel5, java.awt.BorderLayout.WEST);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("12:30 02/12/2003");
        jPanel4.add(jLabel6, java.awt.BorderLayout.EAST);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(975, 46));
        jPanel5.setMinimumSize(new java.awt.Dimension(975, 46));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Tổng thời gian sử dụng:");
        jPanel5.add(jLabel7, java.awt.BorderLayout.WEST);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("1 Giờ 40 Phút");
        jPanel5.add(jLabel8, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(993, 89));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ád", "ád", "ád", "d", "áád"},
                {"d", "áád", null, "ád", "ád"},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên hàng và dịch vụ", "Đơn giá", "Số lượng", "Tổng", "Ghi chú"
            }
        ));
        rSTableMetro1.setAltoHead(35);
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(0, 204, 0));
        rSTableMetro1.setColorBordeFilas(new java.awt.Color(204, 204, 204));
        rSTableMetro1.setColorBordeHead(new java.awt.Color(0, 153, 51));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        rSTableMetro1.setColumnSelectionAllowed(true);
        rSTableMetro1.setEnabled(false);
        rSTableMetro1.setGridColor(new java.awt.Color(0, 0, 0));
        rSTableMetro1.setMultipleSeleccion(false);
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);
        rSTableMetro1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(200);
            rSTableMetro1.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(10);
            rSTableMetro1.getColumnModel().getColumn(2).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(30);
            rSTableMetro1.getColumnModel().getColumn(3).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(100);
            rSTableMetro1.getColumnModel().getColumn(4).setResizable(false);
            rSTableMetro1.getColumnModel().getColumn(4).setPreferredWidth(300);
        }

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(975, 184));
        jPanel6.setMinimumSize(new java.awt.Dimension(975, 184));
        jPanel6.setPreferredSize(new java.awt.Dimension(975, 184));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel17.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel17.setName(""); // NOI18N
        jPanel17.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setText("Tổng tiền:");
        jPanel17.add(jLabel26, java.awt.BorderLayout.WEST);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setText("300.000Đ");
        jPanel17.add(jLabel27, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel17);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel11.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel11.setName(""); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("Thuế (Vat):");
        jPanel11.add(jLabel15, java.awt.BorderLayout.WEST);

        thue.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        thue.setText("null");
        jPanel11.add(thue, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel12.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel12.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("Ưu đãi:");
        jPanel12.add(jLabel17, java.awt.BorderLayout.WEST);

        chuongTrinh.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        chuongTrinh.setText("0Đ");
        jPanel12.add(chuongTrinh, java.awt.BorderLayout.EAST);

        

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel15.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel15.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setText("Đặt cọc:");
        jPanel15.add(jLabel23, java.awt.BorderLayout.WEST);

        coc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        coc.setText("-350.000Đ");
        jPanel15.add(coc, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel15);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel13.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel13.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("Hội viên:");
        jPanel13.add(jLabel19, java.awt.BorderLayout.WEST);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel20.setText("null");
        jPanel13.add(jLabel20, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel13);
        jPanel6.add(jPanel12);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(957, 53));
        jPanel16.setMinimumSize(new java.awt.Dimension(957, 53));
        jPanel16.setPreferredSize(new java.awt.Dimension(957, 53));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Mã ưu đãi:");
        jPanel16.add(jLabel25, java.awt.BorderLayout.WEST);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 32));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-find-40 (1).png"))); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel9.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVoucher(evt);
            }
        });
        jPanel8.add(jLabel9, java.awt.BorderLayout.WEST);

        rSMetroTextPlaceHolder1.setForeground(new java.awt.Color(0, 0, 0));
        rSMetroTextPlaceHolder1.setBorderColor(new java.awt.Color(0, 0, 0));
        rSMetroTextPlaceHolder1.setBotonColor(new java.awt.Color(255, 255, 255));
        rSMetroTextPlaceHolder1.setPreferredSize(new java.awt.Dimension(250, 38));
        rSMetroTextPlaceHolder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVoucher(evt);
            }
        });
        rSMetroTextPlaceHolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMetroTextPlaceHolder1ActionPerformed(evt);
            }
        });
        jPanel8.add(rSMetroTextPlaceHolder1, java.awt.BorderLayout.EAST);

        jPanel16.add(jPanel8, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel16);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(957, 33));
        jPanel14.setMinimumSize(new java.awt.Dimension(957, 33));
        jPanel14.setPreferredSize(new java.awt.Dimension(957, 33));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Tổng tiền cần thanh toán:");
        jPanel14.add(jLabel21, java.awt.BorderLayout.WEST);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("300.000Đ");
        jPanel14.add(jLabel22, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel14);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(975, 83));
        jPanel7.setMinimumSize(new java.awt.Dimension(975, 83));
        jPanel7.setPreferredSize(new java.awt.Dimension(975, 83));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 204, 0));
        rSMaterialButtonRectangle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle1.setText("Thanh Toán");
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCheckBox1.setText("In hóa đơn");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(204, 204, 204));
        rSMaterialButtonRectangle2.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle2.setText("Hủy");
        rSMaterialButtonRectangle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void huyButton(java.awt.event.MouseEvent evt) {                           
        this.dispose();
    }                          

    private void rSMetroTextPlaceHolder1ActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void click(java.awt.event.MouseEvent evt) {      
        int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thanh toán ?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            updateBill();
            fullLoad();
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");  
            if (jCheckBox1.isSelected()){
                jPanel16.setVisible(false);

                    JPanel frame = (JPanel) this.getContentPane();

                    frame.remove(frame.getComponentCount()-1);

                    frame.setSize(frame.getSize().width, frame.getSize().height-60);
                    frame.setBackground(Color.white);
                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setJobName("Print Data");

                    job.setPrintable(new Printable(){
                    public int print(Graphics pg,PageFormat pf, int pageNum){
                            pf.setOrientation(PageFormat.LANDSCAPE);
                         if(pageNum>0){
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.24,0.24);
                        g2.setBackground(Color.white);

                        frame.paint(g2);            
                        return Printable.PAGE_EXISTS;


                    }
            });

                boolean ok = job.printDialog();
                if(ok){
                    try{
                        job.print();
                    }
                    catch (PrinterException ex){}
                    }
                    jPanel16.setVisible(true);
            }
            this.dispose();
        } else {
            
        }
    }                      

    public void updateBill(){
        ArrayList<ThongTinPhongDangChon> result = this.data;
        ArrayList<int[]> fileSetting = null;
        try {
            fileSetting = loadFileTextField();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GD_XuLy_TraPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (ThongTinPhongDangChon thongTinPhongDangChon : result) {
            System.out.println("asdasdasd" + thongTinPhongDangChon.toString());
            if (thongTinPhongDangChon.getPhieuDatPhong() != null){
               new dao.DAO_PhieuDatPhong().updateBill(thongTinPhongDangChon.getPhieuDatPhong());
            }
                ThongTinPhongDangChon.PhongVaDichVu phongVaDichVu = thongTinPhongDangChon.getDanhSachPhong().getFirst();
                new dao.DAO_ChiTietPhong_HoaDon().updateBill(
                        phongVaDichVu.getChiTietPhongHoaDon().getGhiChu().substring(0, 5)+" Đã hoàn thành",
                        phongVaDichVu.getChiTietPhongHoaDon().getHoaDon().getMaHoaDon(), 
                        phongVaDichVu.getChiTietPhongHoaDon().getPhong().getMaPhong(),
                        thongTinPhongDangChon.getMaUuDai()==null?this.uuDai.getMaUuDai():thongTinPhongDangChon.getMaUuDai(), fileSetting,
                        thoiGianTraPhongButton,
                        thongTinPhongDangChon.getThoiGianSuDungTichLuy()
                );
            
        }
    }
    
    private void checkVoucher(java.awt.event.MouseEvent evt) {                              
        ArrayList<entity.UuDai> temp = getAll(UuDai.class);
        
        if (check == false){
            for (UuDai uuDai : temp) {
                if (rSMetroTextPlaceHolder1.getText().equalsIgnoreCase(uuDai.getTenUuDai())){
                    if (LocalDate.now().isAfter(uuDai.getNgayBatDauApDung()) && LocalDate.now().isBefore(uuDai.getNgayKetThucApDung())){
                        rSMetroTextPlaceHolder1.setBorderColor(new Color(0,204,0));
                        rSMetroTextPlaceHolder1.setBackground(new Color(204,204,204));
                        rSMetroTextPlaceHolder1.setEditable(false);
                        double value = (tongTienCanThanhToan * uuDai.getGiamGia());
                        if (check == false){
                                                tongTienCanThanhToan = tongTienCanThanhToan - (tongKhongUuDai * uuDai.getGiamGia());
                                                chuongTrinh.setText("("+ Integer.valueOf((int) (uuDai.getGiamGia()*100)) + "%) - " + formatter.format((tongKhongUuDai * uuDai.getGiamGia()))+" VNĐ");
                                                    if (tongTienCanThanhToan > 0){
                                                        jLabel22.setText(formatter.format(this.tongTienCanThanhToan)+" VNĐ");
                                                    }else{
                                                        jLabel22.setText(formatter.format(0)+" VNĐ");
                                                    }
                                                check = true;
                                                this.uuDai = uuDai;
                        }
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Đã hết ưu đãi hoặc chưa tới ngày ưu đãi");
                    }
                }
            }
                    rSMetroTextPlaceHolder1.setBorderColor(new Color(255,0,0));
        }


        
        

        return;

    }                             
    // Variables declaration - do not modify                     
    private javax.swing.JLabel chuongTrinh;
    private javax.swing.JLabel coc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMetroTextPlaceHolder rSMetroTextPlaceHolder1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private javax.swing.JLabel thue;
    // End of variables declaration                   
    }

    public class Printer implements Printable {
        final Component comp;

        public Printer(Component comp){
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) 
                throws PrinterException {
            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // get the bounds of the component
            Dimension dim = comp.getSize();
            double cHeight = dim.getHeight();
            double cWidth = dim.getWidth();

            // get the bounds of the printable area
            double pHeight = format.getImageableHeight();
            double pWidth = format.getImageableWidth();

            double pXStart = format.getImageableX();
            double pYStart = format.getImageableY();

            double xRatio = pWidth / cWidth;
            double yRatio = pHeight / cHeight;


            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pXStart, pYStart);
            g2.scale(xRatio, yRatio);
            comp.paint(g2);

            return Printable.PAGE_EXISTS;
        }
    }
    
}
