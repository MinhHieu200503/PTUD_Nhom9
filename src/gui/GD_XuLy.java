/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import static gui.GD_XuLy_DanhSachPhong.loadDSPhongTrong;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class GD_XuLy extends javax.swing.JFrame {

    private GD_XuLy_DanhSachPhong danhSachPhong = new GD_XuLy_DanhSachPhong();
//    private GD_XuLy_DatPhongNgay datPhongNgay = new GD_XuLy_DatPhongNgay();
    private GD_XuLy_DatPhongTruoc datPhongTruoc = new GD_XuLy_DatPhongTruoc();
    private GD_XuLy_NhanPhong nhanPhong = new GD_XuLy_NhanPhong();
//    private GD_XuLy_GoiDichVu goiDichVu = new GD_XuLy_GoiDichVu();
//    private GD_XuLy_ChuyenPhong chuyenPhong = new GD_XuLy_ChuyenPhong();
    private GD_XuLy_TraPhong traPhong = new GD_XuLy_TraPhong();
    
    /**
     * Creates new form GD_XuLy
     */
    public GD_XuLy() {
        initComponents();
        setSelectedItem(itemDanhSachPhong);
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========       
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========     
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========     
                rightPanel.remove(jPanel1);
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========       
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========     
//        ========------ IMPORTANT DEMO FRAME PROJECT ------========     
        
        rightPanel.add(danhSachPhong.getContentPane());
//        rightPanel.add(datPhongNgay.getContentPane());
        rightPanel.add(datPhongTruoc.getContentPane());
        rightPanel.add(nhanPhong.getContentPane());
//        rightPanel.add(goiDichVu.getContentPane());
//        rightPanel.add(chuyenPhong.getContentPane());
        rightPanel.add(traPhong.getContentPane());
        
        navBarChoice(0);
        danhSachPhong.loadDSPhongTrong(null,0,-1);
        repaint();
        
        
    }
    
    public void navBarChoice(int index){
        this.rightPanel.getComponent(index).setVisible(true);
        for (int i = 0 ; i < this.rightPanel.getComponentCount(); i++){
            if (i != index){
                this.rightPanel.getComponent(i).setVisible(false);
            }
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

        leftPanel = new javax.swing.JPanel();
        itemDanhSachPhong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itemDatPhongNgay = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        itemDatPhongTruoc = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        itemNhanPhong = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        itemGoiDichVu = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        itemChuyenPhong = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        itemTraPhong = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 964));

        leftPanel.setBackground(new java.awt.Color(165, 241, 233));
        leftPanel.setMaximumSize(new java.awt.Dimension(300, 964));
        leftPanel.setMinimumSize(new java.awt.Dimension(300, 964));

        itemDanhSachPhong.setBackground(new java.awt.Color(165, 241, 233));
        itemDanhSachPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemDanhSachPhong.setForeground(new java.awt.Color(51, 0, 102));
        itemDanhSachPhong.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemDanhSachPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-list-40.png"))); // NOI18N
        jLabel1.setText("Danh sách phòng");

        javax.swing.GroupLayout itemDanhSachPhongLayout = new javax.swing.GroupLayout(itemDanhSachPhong);
        itemDanhSachPhong.setLayout(itemDanhSachPhongLayout);
        itemDanhSachPhongLayout.setHorizontalGroup(
            itemDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemDanhSachPhongLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        itemDanhSachPhongLayout.setVerticalGroup(
            itemDanhSachPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDanhSachPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemDatPhongNgay.setBackground(new java.awt.Color(165, 241, 233));
        itemDatPhongNgay.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemDatPhongNgay.setForeground(new java.awt.Color(174, 210, 255));
        itemDatPhongNgay.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemDatPhongNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reception-40.png"))); // NOI18N
        jLabel8.setText("Đặt phòng ngay");

        javax.swing.GroupLayout itemDatPhongNgayLayout = new javax.swing.GroupLayout(itemDatPhongNgay);
        itemDatPhongNgay.setLayout(itemDatPhongNgayLayout);
        itemDatPhongNgayLayout.setHorizontalGroup(
            itemDatPhongNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemDatPhongNgayLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        itemDatPhongNgayLayout.setVerticalGroup(
            itemDatPhongNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDatPhongNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemDatPhongTruoc.setBackground(new java.awt.Color(165, 241, 233));
        itemDatPhongTruoc.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemDatPhongTruoc.setForeground(new java.awt.Color(51, 0, 102));
        itemDatPhongTruoc.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemDatPhongTruoc.setPreferredSize(new java.awt.Dimension(300, 76));
        itemDatPhongTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-calendar-40.png"))); // NOI18N
        jLabel9.setText("Đặt phòng trước");

        javax.swing.GroupLayout itemDatPhongTruocLayout = new javax.swing.GroupLayout(itemDatPhongTruoc);
        itemDatPhongTruoc.setLayout(itemDatPhongTruocLayout);
        itemDatPhongTruocLayout.setHorizontalGroup(
            itemDatPhongTruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemDatPhongTruocLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        itemDatPhongTruocLayout.setVerticalGroup(
            itemDatPhongTruocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemDatPhongTruocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemNhanPhong.setBackground(new java.awt.Color(165, 241, 233));
        itemNhanPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemNhanPhong.setForeground(new java.awt.Color(51, 0, 102));
        itemNhanPhong.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemNhanPhong.setPreferredSize(new java.awt.Dimension(300, 76));
        itemNhanPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-check-in-40.png"))); // NOI18N
        jLabel10.setText("Nhận phòng");

        javax.swing.GroupLayout itemNhanPhongLayout = new javax.swing.GroupLayout(itemNhanPhong);
        itemNhanPhong.setLayout(itemNhanPhongLayout);
        itemNhanPhongLayout.setHorizontalGroup(
            itemNhanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemNhanPhongLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        itemNhanPhongLayout.setVerticalGroup(
            itemNhanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemNhanPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemGoiDichVu.setBackground(new java.awt.Color(165, 241, 233));
        itemGoiDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemGoiDichVu.setForeground(new java.awt.Color(51, 0, 102));
        itemGoiDichVu.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemGoiDichVu.setPreferredSize(new java.awt.Dimension(300, 76));
        itemGoiDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(102, 0, 255));
        jLabel11.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-wine-40.png"))); // NOI18N
        jLabel11.setText("Gọi dịch vụ");

        javax.swing.GroupLayout itemGoiDichVuLayout = new javax.swing.GroupLayout(itemGoiDichVu);
        itemGoiDichVu.setLayout(itemGoiDichVuLayout);
        itemGoiDichVuLayout.setHorizontalGroup(
            itemGoiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemGoiDichVuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        itemGoiDichVuLayout.setVerticalGroup(
            itemGoiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemGoiDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemChuyenPhong.setBackground(new java.awt.Color(165, 241, 233));
        itemChuyenPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemChuyenPhong.setForeground(new java.awt.Color(51, 0, 102));
        itemChuyenPhong.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemChuyenPhong.setPreferredSize(new java.awt.Dimension(300, 76));
        itemChuyenPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(102, 0, 255));
        jLabel13.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-transfer-40.png"))); // NOI18N
        jLabel13.setText("Chuyển phòng");

        javax.swing.GroupLayout itemChuyenPhongLayout = new javax.swing.GroupLayout(itemChuyenPhong);
        itemChuyenPhong.setLayout(itemChuyenPhongLayout);
        itemChuyenPhongLayout.setHorizontalGroup(
            itemChuyenPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemChuyenPhongLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        itemChuyenPhongLayout.setVerticalGroup(
            itemChuyenPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemChuyenPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        itemTraPhong.setBackground(new java.awt.Color(165, 241, 233));
        itemTraPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        itemTraPhong.setForeground(new java.awt.Color(51, 0, 102));
        itemTraPhong.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        itemTraPhong.setPreferredSize(new java.awt.Dimension(300, 76));
        itemTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemSelectItem(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-check-out-40.png"))); // NOI18N
        jLabel12.setText("Trả phòng");

        javax.swing.GroupLayout itemTraPhongLayout = new javax.swing.GroupLayout(itemTraPhong);
        itemTraPhong.setLayout(itemTraPhongLayout);
        itemTraPhongLayout.setHorizontalGroup(
            itemTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemTraPhongLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        itemTraPhongLayout.setVerticalGroup(
            itemTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemDanhSachPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemDatPhongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemDatPhongTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemGoiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(itemDanhSachPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemDatPhongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemDatPhongTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemGoiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(itemTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.WEST);

        rightPanel.setMaximumSize(new java.awt.Dimension(1620, 964));
        rightPanel.setMinimumSize(new java.awt.Dimension(1620, 964));
        rightPanel.setPreferredSize(new java.awt.Dimension(1620, 964));
        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1096, 964));
        jPanel1.setMinimumSize(new java.awt.Dimension(1096, 964));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );

        rightPanel.add(jPanel1);

        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSelectItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSelectItem

        if (evt.getSource().equals(itemDanhSachPhong)){
            setSelectedItem(itemDanhSachPhong);
            navBarChoice(0);
            danhSachPhong.loadDSPhongTrong(null,0,-1);

            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemDatPhongNgay)){
            setSelectedItem(itemDatPhongNgay);
//            navBarChoice(1);
//            datPhongNgay.loadDSPhongTrong();
//            datPhongNgay.setTableDataNull();
            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemDatPhongTruoc)){
            setSelectedItem(itemDatPhongTruoc);
            navBarChoice(1); // => test (2)
            datPhongTruoc.loadDSPhongTrong(null,0,null);
            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemNhanPhong)){
            setSelectedItem(itemNhanPhong);
            navBarChoice(2);
            nhanPhong.loadDSPhongTrong(null,0,null);
            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemGoiDichVu)){
            setSelectedItem(itemGoiDichVu);
            navBarChoice(4);
//            goiDichVu.loadDSPhongDangSuDung();
//            goiDichVu.loadDSTatCaDichVu();
            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemChuyenPhong)){
            setSelectedItem(itemChuyenPhong);
            navBarChoice(5);
//            chuyenPhong.loadDSPhongDangSuDung();
            pack();
            repaint();
        }
        else if (evt.getSource().equals(itemTraPhong)){
            setSelectedItem(itemTraPhong);
            navBarChoice(6);
            traPhong.fullLoad();
            pack();
            repaint();
        }
    }//GEN-LAST:event_itemSelectItem

    // </editor-fold>                        

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
            java.util.logging.Logger.getLogger(GD_XuLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_XuLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy().setVisible(true);
            }
        });
    }

    private void enteredMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enteredMenu
        enterMenu((JPanel) evt.getSource());
    }//GEN-LAST:event_enteredMenu

    private void exitedMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitedMenu
        exitMenu((JPanel) evt.getSource());
    }//GEN-LAST:event_exitedMenu

     public void setSelectedItem(javax.swing.JPanel pnl){
        pnl.setBackground(new Color(0,153,153)); // Đánh dấu khi được chọn
        pnl.getComponent(0).setForeground(Color.WHITE);   

        for (Component com : leftPanel.getComponents()) {
            if (com instanceof JPanel && !com.equals(pnl)) {
                com.setBackground(new Color(165,241,233)); // Chỉnh về màu mặc định
                JPanel temp = (JPanel) com;
                temp.getComponent(0).setForeground(new Color(51,0,102));
                
            }
        }
         choice_Panel = pnl;
         repaint();
          
    }
    
    public void enterMenu(javax.swing.JPanel panel){
        if (!choice_Panel.equals(panel)){
            panel.setBackground(new Color(127, 233, 222));
            panel.getComponent(0).setForeground(Color.WHITE);
        }
        repaint();
       
    }
    
    

    public void exitMenu(javax.swing.JPanel panel){
        if (!choice_Panel.equals(panel)){
            panel.setBackground(new Color(165,241,233));
            panel.getComponent(0).setForeground( new Color(51,0,102));
        }
        repaint();
        
    }
    
    private javax.swing.JPanel choice_Panel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel itemChuyenPhong;
    private javax.swing.JPanel itemDanhSachPhong;
    private javax.swing.JPanel itemDatPhongNgay;
    private javax.swing.JPanel itemDatPhongTruoc;
    private javax.swing.JPanel itemGoiDichVu;
    private javax.swing.JPanel itemNhanPhong;
    private javax.swing.JPanel itemTraPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
}
