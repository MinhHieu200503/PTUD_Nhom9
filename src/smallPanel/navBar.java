/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package smallPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class navBar extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form navBar
     */
    public navBar() {
        
        //Tạo Luồng Để run() thread được Implements với Runnable
        thread = new Thread(this);
        thread.start();
        
        initComponents();
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
        underline = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        homePageTextIcon = new javax.swing.JLabel();
        room = new javax.swing.JPanel();
        roomTextIcon = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        searchTextIcon = new javax.swing.JLabel();
        statistical = new javax.swing.JPanel();
        statisticalTextIcon = new javax.swing.JLabel();
        manage = new javax.swing.JPanel();
        manageTextIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sideBarXuLy1 = new smallPanel.SideBarXuLy();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1030));
        setMinimumSize(new java.awt.Dimension(1920, 1030));
        setPreferredSize(new java.awt.Dimension(1920, 1030));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(40, 77, 133));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 66));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 66));
        jPanel1.setLayout(new java.awt.BorderLayout());

        leftPanel.setBackground(new java.awt.Color(40, 77, 133));
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

        userPanel.setBackground(new java.awt.Color(40, 77, 133));
        userPanel.setLayout(new javax.swing.BoxLayout(userPanel, javax.swing.BoxLayout.PAGE_AXIS));

        name_Account.setBackground(new java.awt.Color(255, 255, 255));
        name_Account.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        name_Account.setForeground(new java.awt.Color(255, 255, 255));
        name_Account.setText("Loading...");
        userPanel.add(name_Account);

        time_Account.setBackground(new java.awt.Color(255, 255, 255));
        time_Account.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        time_Account.setForeground(new java.awt.Color(255, 255, 255));
        time_Account.setText("Loading...");
        userPanel.add(time_Account);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 84, 0, 0);
        leftPanel.add(userPanel, gridBagConstraints);

        jPanel1.add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setBackground(new java.awt.Color(40, 77, 133));
        rightPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rightPanel.setMaximumSize(new java.awt.Dimension(944, 66));
        rightPanel.setMinimumSize(new java.awt.Dimension(944, 66));
        rightPanel.setPreferredSize(new java.awt.Dimension(944, 66));
        rightPanel.setRequestFocusEnabled(false);
        rightPanel.setLayout(new java.awt.GridBagLayout());

        underline.setBackground(new java.awt.Color(0, 204, 255));
        underline.setMaximumSize(new java.awt.Dimension(191, 3));
        underline.setMinimumSize(new java.awt.Dimension(191, 3));
        underline.setPreferredSize(new java.awt.Dimension(191, 3));
        underline.setRequestFocusEnabled(false);

        javax.swing.GroupLayout underlineLayout = new javax.swing.GroupLayout(underline);
        underline.setLayout(underlineLayout);
        underlineLayout.setHorizontalGroup(
            underlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        underlineLayout.setVerticalGroup(
            underlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        rightPanel.add(underline, gridBagConstraints);

        home.setBackground(new java.awt.Color(40, 77, 133));
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

        homePageTextIcon.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        homePageTextIcon.setForeground(new java.awt.Color(255, 255, 255));
        homePageTextIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homePageTextIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-40.png"))); // NOI18N
        homePageTextIcon.setText("Trang chủ");
        homePageTextIcon.setAlignmentY(0.0F);
        homePageTextIcon.setMaximumSize(new java.awt.Dimension(191, 66));
        homePageTextIcon.setMinimumSize(new java.awt.Dimension(191, 66));
        homePageTextIcon.setPreferredSize(new java.awt.Dimension(191, 66));

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(homePageTextIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addComponent(homePageTextIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        rightPanel.add(home, gridBagConstraints);

        room.setBackground(new java.awt.Color(40, 77, 133));
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

        roomTextIcon.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        roomTextIcon.setForeground(new java.awt.Color(255, 255, 255));
        roomTextIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-micro-40.png"))); // NOI18N
        roomTextIcon.setText("Xử lý");
        roomTextIcon.setAlignmentY(0.0F);
        roomTextIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roomTextIcon.setMaximumSize(null);
        roomTextIcon.setMinimumSize(null);
        roomTextIcon.setPreferredSize(new java.awt.Dimension(191, 66));

        javax.swing.GroupLayout roomLayout = new javax.swing.GroupLayout(room);
        room.setLayout(roomLayout);
        roomLayout.setHorizontalGroup(
            roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(roomTextIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        roomLayout.setVerticalGroup(
            roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(roomTextIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        rightPanel.add(room, new java.awt.GridBagConstraints());

        search.setBackground(new java.awt.Color(40, 77, 133));
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

        searchTextIcon.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        searchTextIcon.setForeground(new java.awt.Color(255, 255, 255));
        searchTextIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-find-40.png"))); // NOI18N
        searchTextIcon.setText("Tra cứu");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
            .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchLayout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(searchTextIcon)
                    .addGap(0, 40, Short.MAX_VALUE)))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
            .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(searchTextIcon)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        rightPanel.add(search, new java.awt.GridBagConstraints());

        statistical.setBackground(new java.awt.Color(40, 77, 133));
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

        statisticalTextIcon.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statisticalTextIcon.setForeground(new java.awt.Color(255, 255, 255));
        statisticalTextIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-statistics-40.png"))); // NOI18N
        statisticalTextIcon.setText("Thống kê");

        javax.swing.GroupLayout statisticalLayout = new javax.swing.GroupLayout(statistical);
        statistical.setLayout(statisticalLayout);
        statisticalLayout.setHorizontalGroup(
            statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
            .addGroup(statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticalLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(statisticalTextIcon)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        statisticalLayout.setVerticalGroup(
            statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
            .addGroup(statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticalLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(statisticalTextIcon)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        rightPanel.add(statistical, new java.awt.GridBagConstraints());

        manage.setBackground(new java.awt.Color(40, 77, 133));
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

        manageTextIcon.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        manageTextIcon.setForeground(new java.awt.Color(255, 255, 255));
        manageTextIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-manage-40.png"))); // NOI18N
        manageTextIcon.setText("Quản lý");

        javax.swing.GroupLayout manageLayout = new javax.swing.GroupLayout(manage);
        manage.setLayout(manageLayout);
        manageLayout.setHorizontalGroup(
            manageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
            .addGroup(manageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(manageLayout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(manageTextIcon)
                    .addGap(0, 40, Short.MAX_VALUE)))
        );
        manageLayout.setVerticalGroup(
            manageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
            .addGroup(manageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(manageLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(manageTextIcon)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        rightPanel.add(manage, new java.awt.GridBagConstraints());

        jPanel1.add(rightPanel, java.awt.BorderLayout.LINE_END);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setMaximumSize(new java.awt.Dimension(1920, 964));
        jPanel2.setMinimumSize(new java.awt.Dimension(1920, 964));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sideBarXuLy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1620, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sideBarXuLy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 652, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void enteredMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enteredMenu
        if (evt.getSource().equals(home)){
            enterMenu(home);
        }
        else if (evt.getSource().equals(room)){
            enterMenu(room);
        }
        else if (evt.getSource().equals(search)){
            enterMenu(search);
        }
        else if (evt.getSource().equals(statistical)){
            enterMenu(statistical);
        }
        else if (evt.getSource().equals(manage)){
            enterMenu(manage);
        }
        
    }//GEN-LAST:event_enteredMenu

    public void enterMenu(javax.swing.JPanel panel){
        underline.setBackground(new Color(0, 204, 255));
        panel.setBackground(new Color(40,94,178));
        
    }
    
    
    private void exitedMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitedMenu
        if (evt.getSource().equals(home)){
            exitMenu(home);
        }
        else if (evt.getSource().equals(room)){
            exitMenu(room);
        }
        else if (evt.getSource().equals(search)){
            exitMenu(search);
        }
        else if (evt.getSource().equals(statistical)){
            exitMenu(statistical);
        }
        else if (evt.getSource().equals(manage)){
            exitMenu(manage);
        }
    }//GEN-LAST:event_exitedMenu
    
    public void exitMenu(javax.swing.JPanel panel){
        panel.setBackground(new Color(40,77,133));
         underline.setBackground(new Color(0, 204, 255));
        repaint();
    }
    
    private void clickedMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickedMenu
        if (evt.getSource().equals(home)){
            clickMenuUnderline(0);
        }
        else if (evt.getSource().equals(room)){
            clickMenuUnderline(1);
        }
        else if (evt.getSource().equals(search)){
            clickMenuUnderline(2);
        }
        else if (evt.getSource().equals(statistical)){
            clickMenuUnderline(3);
        }
        else if (evt.getSource().equals(manage)){
            clickMenuUnderline(4);
        }
    }//GEN-LAST:event_clickedMenu
    
    public int clickMenuUnderline(int index){
            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = index;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridheight = 2;
            gridBagConstraints.ipady = 4;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
            rightPanel.remove(underline);
            rightPanel.add(underline, gridBagConstraints,0);
            repaint();
            return index;
    }
    
    
 



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel home;
    private javax.swing.JLabel homePageTextIcon;
    private javax.swing.JLabel icon_Account;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel manage;
    private javax.swing.JLabel manageTextIcon;
    private javax.swing.JLabel name_Account;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel room;
    private javax.swing.JLabel roomTextIcon;
    private javax.swing.JPanel search;
    private javax.swing.JLabel searchTextIcon;
    private smallPanel.SideBarXuLy sideBarXuLy1;
    private javax.swing.JPanel statistical;
    private javax.swing.JLabel statisticalTextIcon;
    private javax.swing.JLabel time_Account;
    private javax.swing.JPanel underline;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
    private Thread thread = null; // khởi tạo luồng
    private Color mainColor = new Color(40,77,133);
    
}
