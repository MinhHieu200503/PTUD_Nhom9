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
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class NavBar extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form navBar
     */
    public NavBar() {
        
        //Tạo Luồng Để run() thread được Implements với Runnable
        thread = new Thread(this);
        thread.start();
        initComponents();
        clickMenuUnderline(home);
        this.remove(1);
        this.add(new GD_TrangChu().getContentPane());
        name_Account.setText(GD_DangNhap.taiKhoan.getNhanVien().getTenNhanVien());
        
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

        jPanel1 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
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

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setMaximumSize(new java.awt.Dimension(1920, 1030));
        setMinimumSize(new java.awt.Dimension(1920, 1030));
        setPreferredSize(new java.awt.Dimension(1920, 1030));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(40, 77, 133));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 66));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        leftPanel.setBackground(new java.awt.Color(0, 153, 153));
        leftPanel.setMaximumSize(new java.awt.Dimension(423, 66));
        leftPanel.setMinimumSize(new java.awt.Dimension(423, 66));
        leftPanel.setPreferredSize(new java.awt.Dimension(423, 66));
        leftPanel.setLayout(new java.awt.GridBagLayout());

        icon_Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-account-60.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        leftPanel.add(icon_Account, gridBagConstraints);

        userPanel.setBackground(new java.awt.Color(0, 153, 153));
        userPanel.setLayout(new javax.swing.BoxLayout(userPanel, javax.swing.BoxLayout.PAGE_AXIS));

        name_Account.setBackground(new java.awt.Color(0, 0, 0));
        name_Account.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        name_Account.setText("Loading...");
        userPanel.add(name_Account);

        time_Account.setBackground(new java.awt.Color(0, 0, 0));
        time_Account.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time_Account.setText("Loading...");
        userPanel.add(time_Account);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 84, 0, 0);
        leftPanel.add(userPanel, gridBagConstraints);

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

        add(jPanel1, java.awt.BorderLayout.NORTH);

        add.setMaximumSize(new java.awt.Dimension(1920, 964));
        add.setMinimumSize(new java.awt.Dimension(1920, 964));

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );

        add(add, java.awt.BorderLayout.CENTER);
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
            this.remove(1);
            this.add(new GD_TrangChu().getContentPane());
        }
        else if (a.equals(room)){
            clickMenuUnderline((JPanel) a);
            this.remove(1);
            this.add(new GD_XuLy().getContentPane());
        }
        else if (a.equals(search)){
            clickMenuUnderline((JPanel) a);
            this.remove(1);
            this.add(new GD_TraCuu().getContentPane());
        }
        else if (a.equals(statistical)){
            this.remove(1);
            this.add(new GD_Thongke().getContentPane());
        }
        else if (a.equals(manage)){
            clickMenuUnderline((JPanel) a);
            this.remove(1);
            this.add(new GD_QuanLi().getContentPane());
        }
        repaint();
    }//GEN-LAST:event_clickedMenu

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
    private javax.swing.JLabel label_QuanLy;
    private javax.swing.JLabel label_ThongKe;
    private javax.swing.JLabel label_TraCuu;
    private javax.swing.JLabel label_TrangChu;
    private javax.swing.JLabel label_XuLy;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel manage;
    public static javax.swing.JLabel name_Account;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel room;
    private javax.swing.JPanel search;
    private javax.swing.JPanel statistical;
    private javax.swing.JLabel time_Account;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
    private Thread thread = null; // khởi tạo luồng
    private Color mainColor = new Color(40,77,133);
    
}
