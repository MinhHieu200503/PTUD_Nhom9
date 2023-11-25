/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package smallPanel;

import gui.GD_DangNhap;
import gui.GD_XuLy;
import gui.GD_QuanLi;
import gui.GD_TraCuu;
import gui.GD_TrangChu;
import gui.GD_Thongke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class NavBar extends javax.swing.JPanel implements Runnable{

private GD_TrangChu trangChu = new GD_TrangChu();
    private GD_XuLy xuLy = new GD_XuLy();
    private GD_TraCuu traCuu = new GD_TraCuu();
    private GD_Thongke thongKe = new GD_Thongke();
    private GD_QuanLi quanLi = new GD_QuanLi();
    
    /**
     * Creates new form navBar
     */
    public NavBar() {
        
        //Tạo Luồng Để run() thread được Implements với Runnable
        thread = new Thread(this);
        thread.start();
        initComponents();
        clickMenuUnderline(home);
        this.add.add(new GD_TrangChu().getContentPane());
        jPanel7.setVisible(false);
        this.add.add(trangChu.getContentPane());
        this.add.add(xuLy.getContentPane());
        this.add.add(traCuu.getContentPane());
        this.add.add(thongKe.getContentPane());
        this.add.add(quanLi.getContentPane());
        
//        xuLy.setVisible(false);
//        traCuu.setVisible(false);
//        thongKe.setVisible(false);
//        quanLi.setVisible(false);
        
        navBarChoice(0);
//        name_Account.setText(GD_DangNhap.taiKhoan.getNhanVien().getTenNhanVien());

    }
    
    public void loadNameUser(){
        if (GD_DangNhap.taiKhoan.getNhanVien() != null){
            name_Account.setText(GD_DangNhap.taiKhoan.getNhanVien().getTenNhanVien());
        }
    }
    
    public void navBarChoice(int index){
        this.add.getComponent(index).setVisible(true);
        for (int i = 0 ; i< this.add.getComponentCount(); i++){
            if (i != index){
                this.add.getComponent(i).setVisible(false);
            }
        }
    }
    
    
    public void run(){
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
                                time_Account.setText(
                                        sdf_Gio.format(thoiGianHienTai) + " " + ngayTrongTuan +
                                        sdf_Ngay.format(thoiGianHienTai)
                                        );
                                
			}
                        
		} catch (InterruptedException e) {
			e.printStackTrace();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        layout = new javax.swing.JPanel();
        icon_Account = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        name_Account = new javax.swing.JLabel();
        time_Account = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        label_TrangChu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        room = new javax.swing.JPanel();
        label_XuLy = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        label_TraCuu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        statistical = new javax.swing.JPanel();
        label_ThongKe = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        manage = new javax.swing.JPanel();
        label_QuanLy = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        add = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        rSButtonMetro4 = new rojerusan.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setMaximumSize(new java.awt.Dimension(1920, 1030));
        setMinimumSize(new java.awt.Dimension(1920, 1030));
        setPreferredSize(new java.awt.Dimension(1920, 1030));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(40, 77, 133));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 66));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        leftPanel.setBackground(new java.awt.Color(0, 153, 153));
        leftPanel.setMaximumSize(new java.awt.Dimension(423, 66));
        leftPanel.setMinimumSize(new java.awt.Dimension(423, 66));
        leftPanel.setPreferredSize(new java.awt.Dimension(423, 66));
        leftPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 5));

        layout.setBackground(new java.awt.Color(0, 153, 153));
        layout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pressMenu(evt);
            }
        });
        layout.setLayout(new java.awt.BorderLayout(10, 0));

        icon_Account.setBackground(new java.awt.Color(0, 0, 0));
        icon_Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-account-60.png"))); // NOI18N
        layout.add(icon_Account, java.awt.BorderLayout.WEST);

        userPanel.setBackground(new java.awt.Color(0, 153, 153));
        userPanel.setLayout(new javax.swing.BoxLayout(userPanel, javax.swing.BoxLayout.PAGE_AXIS));

        name_Account.setBackground(new java.awt.Color(0, 0, 0));
        name_Account.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        name_Account.setForeground(new java.awt.Color(255, 255, 255));
        name_Account.setText("Loading...");
        userPanel.add(name_Account);

        time_Account.setBackground(new java.awt.Color(0, 0, 0));
        time_Account.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time_Account.setForeground(new java.awt.Color(255, 255, 255));
        time_Account.setText("Loading...");
        userPanel.add(time_Account);

        layout.add(userPanel, java.awt.BorderLayout.EAST);

        leftPanel.add(layout);

        jPanel1.add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(0, 153, 153));
        rightPanel.setAlignmentX(0.0F);
        rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rightPanel.setMaximumSize(new java.awt.Dimension(944, 66));
        rightPanel.setMinimumSize(new java.awt.Dimension(944, 66));
        rightPanel.setPreferredSize(new java.awt.Dimension(944, 66));
        rightPanel.setRequestFocusEnabled(false);
        rightPanel.setLayout(new java.awt.GridBagLayout());

        home.setBackground(new java.awt.Color(0, 153, 153));
        home.setMaximumSize(new java.awt.Dimension(191, 66));
        home.setMinimumSize(new java.awt.Dimension(191, 66));
        home.setPreferredSize(new java.awt.Dimension(191, 66));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedMenu(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
        });
        home.setLayout(new java.awt.GridBagLayout());

        label_TrangChu.setBackground(new java.awt.Color(204, 255, 51));
        label_TrangChu.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label_TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        label_TrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_TrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-40.png"))); // NOI18N
        label_TrangChu.setText("TRANG CHỦ");
        label_TrangChu.setAlignmentY(0.0F);
        label_TrangChu.setMaximumSize(new java.awt.Dimension(191, 66));
        label_TrangChu.setMinimumSize(new java.awt.Dimension(191, 66));
        label_TrangChu.setPreferredSize(new java.awt.Dimension(191, 66));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        home.add(label_TrangChu, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(191, 5));
        jPanel2.setMinimumSize(new java.awt.Dimension(191, 5));
        jPanel2.setPreferredSize(new java.awt.Dimension(191, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        home.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        rightPanel.add(home, gridBagConstraints);

        room.setBackground(new java.awt.Color(0, 153, 153));
        room.setMaximumSize(new java.awt.Dimension(191, 66));
        room.setMinimumSize(new java.awt.Dimension(191, 66));
        room.setPreferredSize(new java.awt.Dimension(191, 66));
        room.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedMenu(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
        });
        room.setLayout(new java.awt.GridBagLayout());

        label_XuLy.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label_XuLy.setForeground(new java.awt.Color(255, 255, 255));
        label_XuLy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_XuLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-micro-40.png"))); // NOI18N
        label_XuLy.setText("XỬ LÝ");
        label_XuLy.setAlignmentY(0.0F);
        label_XuLy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_XuLy.setPreferredSize(new java.awt.Dimension(191, 66));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        room.add(label_XuLy, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(191, 5));
        jPanel3.setMinimumSize(new java.awt.Dimension(191, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        room.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        rightPanel.add(room, gridBagConstraints);

        search.setBackground(new java.awt.Color(0, 153, 153));
        search.setMaximumSize(new java.awt.Dimension(191, 66));
        search.setMinimumSize(new java.awt.Dimension(191, 66));
        search.setPreferredSize(new java.awt.Dimension(191, 66));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedMenu(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
        });
        search.setLayout(new java.awt.GridBagLayout());

        label_TraCuu.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label_TraCuu.setForeground(new java.awt.Color(255, 255, 255));
        label_TraCuu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_TraCuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-find-40.png"))); // NOI18N
        label_TraCuu.setText("TRA CỨU");
        label_TraCuu.setMaximumSize(new java.awt.Dimension(191, 66));
        label_TraCuu.setMinimumSize(new java.awt.Dimension(191, 66));
        label_TraCuu.setPreferredSize(new java.awt.Dimension(191, 66));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        search.add(label_TraCuu, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(191, 5));
        jPanel4.setMinimumSize(new java.awt.Dimension(191, 5));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        search.add(jPanel4, gridBagConstraints);

        rightPanel.add(search, new java.awt.GridBagConstraints());

        statistical.setBackground(new java.awt.Color(0, 153, 153));
        statistical.setMaximumSize(new java.awt.Dimension(191, 66));
        statistical.setMinimumSize(new java.awt.Dimension(191, 66));
        statistical.setPreferredSize(new java.awt.Dimension(191, 66));
        statistical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedMenu(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
        });
        statistical.setLayout(new java.awt.GridBagLayout());

        label_ThongKe.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label_ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        label_ThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_ThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-statistics-40.png"))); // NOI18N
        label_ThongKe.setText("THỐNG KÊ");
        label_ThongKe.setMaximumSize(new java.awt.Dimension(191, 66));
        label_ThongKe.setMinimumSize(new java.awt.Dimension(191, 66));
        label_ThongKe.setPreferredSize(new java.awt.Dimension(191, 66));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        statistical.add(label_ThongKe, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(191, 5));
        jPanel5.setMinimumSize(new java.awt.Dimension(191, 5));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        statistical.add(jPanel5, gridBagConstraints);

        rightPanel.add(statistical, new java.awt.GridBagConstraints());

        manage.setBackground(new java.awt.Color(0, 153, 153));
        manage.setMaximumSize(new java.awt.Dimension(191, 66));
        manage.setMinimumSize(new java.awt.Dimension(191, 66));
        manage.setPreferredSize(new java.awt.Dimension(191, 66));
        manage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickedMenu(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enteredMenu(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitedMenu(evt);
            }
        });
        manage.setLayout(new java.awt.GridBagLayout());

        label_QuanLy.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label_QuanLy.setForeground(new java.awt.Color(255, 255, 255));
        label_QuanLy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_QuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-manage-40.png"))); // NOI18N
        label_QuanLy.setText("QUẢN LÝ");
        label_QuanLy.setMaximumSize(new java.awt.Dimension(191, 66));
        label_QuanLy.setMinimumSize(new java.awt.Dimension(191, 66));
        label_QuanLy.setPreferredSize(new java.awt.Dimension(191, 66));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        manage.add(label_QuanLy, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(191, 5));
        jPanel6.setMinimumSize(new java.awt.Dimension(191, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        manage.add(jPanel6, gridBagConstraints);

        rightPanel.add(manage, new java.awt.GridBagConstraints());

        jPanel1.add(rightPanel);

        add.setMaximumSize(new java.awt.Dimension(1920, 964));
        add.setMinimumSize(new java.awt.Dimension(1920, 964));
        add.setLayout(new org.jdesktop.swingx.HorizontalLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel8);
        jPanel8.setBounds(0, 0, 1920, 1030);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                moveMenu(evt);
            }
        });

        rSButtonMetro2.setBackground(new java.awt.Color(0, 153, 153));
        rSButtonMetro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-50.png"))); // NOI18N
        rSButtonMetro2.setText("Cài đặt thanh toán");
        rSButtonMetro2.setAlignmentX(0.5F);
        rSButtonMetro2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSButtonMetro2.setIconTextGap(30);
        rSButtonMetro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pressThanhToan(evt);
            }
        });

        rSButtonMetro3.setBackground(new java.awt.Color(0, 153, 153));
        rSButtonMetro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-book-50.png"))); // NOI18N
        rSButtonMetro3.setText("Hướng dẫn sử dụng");
        rSButtonMetro3.setAlignmentX(0.5F);
        rSButtonMetro3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSButtonMetro3.setIconTextGap(30);
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });

        rSButtonMetro4.setBackground(new java.awt.Color(0, 153, 153));
        rSButtonMetro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-log-out-50.png"))); // NOI18N
        rSButtonMetro4.setText("Thoát");
        rSButtonMetro4.setAlignmentX(0.5F);
        rSButtonMetro4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rSButtonMetro4.setIconTextGap(30);
        rSButtonMetro4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitApp(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonMetro2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(rSButtonMetro3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(rSButtonMetro4, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonMetro3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonMetro4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        add(jPanel7);
        jPanel7.setBounds(0, 67, 470, 190);
    }// </editor-fold>//GEN-END:initComponents

    private void enteredMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enteredMenu
        enterMenu((JPanel) evt.getSource());
    }//GEN-LAST:event_enteredMenu

    public void enterMenu(javax.swing.JPanel panel){

        panel.setBackground(new Color(127, 233, 222));
        repaint();
        
        
    }
    
    
    private void exitedMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitedMenu
        exitMenu((JPanel) evt.getSource());
    }//GEN-LAST:event_exitedMenu
    
    public void exitMenu(javax.swing.JPanel panel){
        panel.setBackground(new Color(0,153,153));
        repaint();
    }
    
    private void clickedMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedMenu
        Object a = evt.getSource();
        clickMenuUnderline((JPanel) a);
        if (a.equals(home)){
            clickMenuUnderline((JPanel) a);
            navBarChoice(1);
        }
        else if (a.equals(room)){
            clickMenuUnderline((JPanel) a);
            navBarChoice(2);

        }
        else if (a.equals(search)){
            clickMenuUnderline((JPanel) a);
            navBarChoice(3);
        }
        else if (a.equals(statistical)){
            navBarChoice(4);

        }
        else if (a.equals(manage)){
            clickMenuUnderline((JPanel) a);
            navBarChoice(5);

        }
        repaint();
    }//GEN-LAST:event_clickedMenu

    
    private void pressMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pressMenu
        if(visibleMenu == false){
            jPanel7.setVisible(true);
            visibleMenu = true;
        }
        else{
            jPanel7.setVisible(false);
            visibleMenu = false;
        }
        
    }//GEN-LAST:event_pressMenu

    private void moveMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveMenu
        jPanel7.repaint();
    }//GEN-LAST:event_moveMenu

    private void exitApp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitApp
        String[] options = {"Thoát chương trình", "Đăng xuất", "Hủy"};
        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
            "Click a button",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0){
            System.exit(0);
        }
        else if (x == 1){
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();
            new gui.GD_DangNhap().setVisible(true);
        }
        else{

        }

    }//GEN-LAST:event_exitApp

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void pressThanhToan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pressThanhToan
        try {
            new gui.GD_CaiDat().setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_pressThanhToan

    
    public void clickMenuUnderline(JPanel panel){
        panel.getComponent(1).setVisible(true);
        
            for (Component a: rightPanel.getComponents()){
                JPanel temp = (JPanel) a;
                if(!temp.equals(panel)){
                    temp.getComponent(1).setVisible(false);
                }
            }
        choice = panel;
            repaint();
    }
    private javax.swing.JPanel choice;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JPanel home;
    private javax.swing.JLabel icon_Account;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel label_QuanLy;
    private javax.swing.JLabel label_ThongKe;
    private javax.swing.JLabel label_TraCuu;
    private javax.swing.JLabel label_TrangChu;
    private javax.swing.JLabel label_XuLy;
    private javax.swing.JPanel layout;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel manage;
    private javax.swing.JLabel name_Account;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojerusan.RSButtonMetro rSButtonMetro4;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel room;
    private javax.swing.JPanel search;
    private javax.swing.JPanel statistical;
    private javax.swing.JLabel time_Account;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
    private Thread thread = null; // khởi tạo luồng
    private Color mainColor = new Color(40,77,133);
    private boolean visibleMenu = false;
}
