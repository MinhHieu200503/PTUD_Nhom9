/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import ComponentCustom.ExitButton;
import ComponentCustom.FormSignIn;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.DAO_TaiKhoan;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.UIManager;
import dao.I_CRUD;
import entity.TaiKhoan;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import mainFrame.mainFrame;

/**
 *
 * @author LENOVO
 */
public class GD_DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form GD_DangNhap
     */
    public mainFrame main;
    public static TaiKhoan taiKhoan  = new TaiKhoan();
    
    public GD_DangNhap() {
//        FlatMacLightLaf.setup();
//        UIManager.put( "Button.arc", 10 );
//        UIManager.put( "Component.arc", 10 );
//        UIManager.put( "ProgressBar.arc", 10 );
//        UIManager.put( "TextComponent.arc", 10 );
//        setUndecorated(true);
//        setSize(400, 470);
//        setShape(new RoundRectangle2D.Double(0,0, 400, 470, 40, 40));
//        setLocationRelativeTo(null);
//        FormSignIn form = new FormSignIn();
//        add(form);
//        form.lblForgotPass.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                gdQuenMK = new GD_QuenMatKhau();
//                setVisible(false);
//                gdQuenMK.setVisible(true);
////         setUndecorated(true);
////        setSize(400, 470);
////        setShape(new RoundRectangle2D.Double(0,0, 400, 470, 40, 40));
////        setLocationRelativeTo(null);
////        FormSignIn form = new FormSignIn();
////        add(form);
////        form.lblForgotPass.addMouseListener(new MouseListener() {
////            @Override
////            public void mouseClicked(MouseEvent e) {
////                gdQuenMK = new GD_QuenMatKhau();
////                setVisible(false);
////                gdQuenMK.setVisible(true);
////            }
////
////            @Override
////            public void mousePressed(MouseEvent e) {
////
////            }
////
////            @Override
////            public void mouseReleased(MouseEvent e) {
////
////            }
////
////            @Override
////            public void mouseEntered(MouseEvent e) {
////                
////            }
////
////            @Override
////            public void mouseExited(MouseEvent e) {
////                
////            }
//}
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        });

            initComponents();
            setLocationRelativeTo(null);
            
            
 
        
            
            
        
        
        lb_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!flag){
                    flag=true;
                    lb_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye-30.png")));
                    txt_matKhau.setEchoChar((char)0);
                }
                else{
                    flag=false;
                    lb_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-hide-30.png")));
                    txt_matKhau.setEchoChar('*');
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                
            }
        });
        btn_dangNhap.setBackground(new Color(204, 204, 204));      
        btn_dangNhap.setText("Vui lòng đợi...");
        Thread thread2 = new Thread(() -> {
        try {
                Thread.sleep(0);
                main = new mainFrame();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            btn_dangNhap.setBackground(new Color(0,102,102));
            btn_dangNhap.setText("Đăng nhập");
        });
                
        thread2.start();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_taiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_dangNhap = new javax.swing.JButton();
        lb_show = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txt_matKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        kGradientPanel2.setkEndColor(new java.awt.Color(250, 255, 209));
        kGradientPanel2.setkStartColor(new java.awt.Color(161, 255, 206));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anhMicroDangNhap.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("KARAOKE ECHO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Tài khoản:");
        jLabel3.setToolTipText("");

        txt_taiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Mật khẩu:");
        jLabel4.setToolTipText("");

        btn_dangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btn_dangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_dangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_dangNhap.setText("Đăng nhập");
        btn_dangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dangNhap(evt);
            }
        });

        lb_show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-hide-30.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Quên mật khẩu?");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clickQuenMatKhau(evt);
            }
        });

        txt_matKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(txt_taiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_matKhau)
                                        .addGap(12, 12, 12)))
                                .addComponent(lb_show))
                            .addComponent(btn_dangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_taiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_show, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(txt_matKhau))
                        .addGap(30, 30, 30)
                        .addComponent(btn_dangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public gui.GD_DangNhap.GD_QuenMatKhau quenMatKhau = new GD_QuenMatKhau();
    private void dangNhap(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dangNhap
        if (btn_dangNhap.getBackground().equals(new Color(0,102,102))){
             this.taiKhoan = I_CRUD.findById(txt_taiKhoan.getText(), new TaiKhoan());
                if(txt_taiKhoan.getText().equals("") || txt_matKhau.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thông tin");
                }
                else if(taiKhoan.getTenTaiKhoan() != null){
                    if(txt_matKhau.getText().equals(taiKhoan.getMatKhau())){
                        main.nav.loadNameUser();
                        this.dispose();
                        main.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Thông tin không chính xác");
                    }
                }
                else JOptionPane.showMessageDialog(null, "Thông tin không chính xác");
        }
        else{
        
        }

    }//GEN-LAST:event_dangNhap

    private void clickQuenMatKhau(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickQuenMatKhau

        quenMatKhau.setVisible(true);
    }//GEN-LAST:event_clickQuenMatKhau

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_DangNhap().setVisible(true);
            }
        });
    }
    
    public GD_QuenMatKhau gdQuenMK;
    private boolean flag = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lb_show;
    private javax.swing.JPasswordField txt_matKhau;
    private javax.swing.JTextField txt_taiKhoan;
    // End of variables declaration//GEN-END:variables

public class GD_QuenMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form GD_QuenMatKhau
     */
    public GD_QuenMatKhau() {
        setUndecorated(true);
        setSize(400, 470);
        setShape(new RoundRectangle2D.Double(0,0, 628, 411, 40, 40));
        setLocationRelativeTo(null);
        FormSignIn form = new FormSignIn();
        add(form);
        
        initComponents();
        
         panelGradient1.setLayout(null);
        // 400 - 470
        

        btnExit = new ExitButton();
        btnExit.setBounds( (628 - 35) , 0, 35, 35);
        panelGradient1.add(btnExit);
        btnXacNhanOTP.setEnabled(false);        
        btnXacNhan.setEnabled(false);

        
       
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelGradient1 = new smallPanel.PanelGradient();
        btnXacNhan = new javax.swing.JButton();
        txtOPT = new javax.swing.JTextField();
        txtNhapMail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhanOTP = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnNhanOTP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNhapMatKhauMoi = new javax.swing.JPasswordField();
        btnXacNhan1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradient1.setMaximumSize(new java.awt.Dimension(400, 470));
        panelGradient1.setMinimumSize(new java.awt.Dimension(400, 470));
        panelGradient1.setPreferredSize(new java.awt.Dimension(400, 470));
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnXacNhan.setBackground(new java.awt.Color(0, 0, 0));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXacNhanMouseClicked(evt);
            }
        });
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        panelGradient1.add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 160, 40));

        txtOPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOPTActionPerformed(evt);
            }
        });
        panelGradient1.add(txtOPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 340, 40));

        txtNhapMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapMailActionPerformed(evt);
            }
        });
        panelGradient1.add(txtNhapMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 340, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Quên mật khẩu");
        panelGradient1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, -1));

        btnXacNhanOTP.setBackground(new java.awt.Color(0, 0, 0));
        btnXacNhanOTP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacNhanOTP.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanOTP.setText("Xác nhận OTP");
        btnXacNhanOTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXacNhanOTPMouseClicked(evt);
            }
        });
        btnXacNhanOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanOTPActionPerformed(evt);
            }
        });
        panelGradient1.add(btnXacNhanOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nhập mật khẩu mới:");
        panelGradient1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 180, -1));

        btnNhanOTP.setBackground(new java.awt.Color(0, 0, 0));
        btnNhanOTP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanOTP.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanOTP.setText("Nhận OTP");
        btnNhanOTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhanOTPMouseClicked(evt);
            }
        });
        btnNhanOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanOTPActionPerformed(evt);
            }
        });
        panelGradient1.add(btnNhanOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nhập mail:");
        panelGradient1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Nhập mã OTP:");
        panelGradient1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 130, -1));
        panelGradient1.add(txtNhapMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 340, 40));

        btnXacNhan1.setBackground(new java.awt.Color(0, 0, 0));
        btnXacNhan1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacNhan1.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan1.setText("Quay lại");
        btnXacNhan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXacNhan1MouseClicked(evt);
            }
        });
        btnXacNhan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhan1ActionPerformed(evt);
            }
        });
        panelGradient1.add(btnXacNhan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>                        

    private void txtOPTActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void txtNhapMailActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnXacNhanOTPActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    }                                             

    private void btnNhanOTPActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnNhanOTPMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        dao.DAO_TaiKhoan taiKhoan = new DAO_TaiKhoan();
        OTP = taiKhoan.sendEmail(txtNhapMail.getText());
        if(OTP == -1){
            JOptionPane.showMessageDialog(null,"Gmail không hợp lệ !!! Vui lòng nhập lại");
        }
        else{
            btnXacNhanOTP.setEnabled(true);
        }
        
    }                                       

    private void btnXacNhanOTPMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        if(OTP == Integer.parseInt(txtOPT.getText())){
            btnXacNhan.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "OTP không đúng !!! Xin vui lòng thử lại");
        }
    }                                          

    private void btnXacNhan1MouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        quenMatKhau.setVisible(false);
    }                                        

    private void btnXacNhan1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnXacNhanMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        boolean valid = true;
        if(txtNhapMatKhauMoi.getText().trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng không để trống mật khẩu !!!!");
            valid = false;
        }
        if (!txtNhapMatKhauMoi.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$#!%*?&]{6,}$")) {
            JOptionPane.showMessageDialog(null, "Mật khẩu có ít nhất 6 kí tự, bao gồm chữ Hoa, chữ thường, chữ số và kí tự đặc biệt");
            valid = false;
        }
        if(valid == true){
            DAO_TaiKhoan daoTK = new DAO_TaiKhoan();
            int result = daoTK.capNhatMatKhau(txtNhapMail.getText(), txtNhapMatKhauMoi.getText());
            if(result>0){
                JOptionPane.showMessageDialog(null,"Cập nhật mật khẩu thành công !!!");
                txtNhapMail.setText("");
                txtNhapMatKhauMoi.setText("");
                txtOPT.setText("");
                btnXacNhan.setEnabled(false);
                btnXacNhanOTP.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Không có nhân viên có gmail như trên, Vui lòng kiểm tra và thử lại");
                txtNhapMatKhauMoi.setText("");
                txtOPT.setText("");
            }
        }

    }                                       

    /**
     * @param args the command line arguments
     */

    
    

    public ExitButton btnExit;
    public int OTP;
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnNhanOTP;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXacNhan1;
    private javax.swing.JButton btnXacNhanOTP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private smallPanel.PanelGradient panelGradient1;
    private javax.swing.JTextField txtNhapMail;
    private javax.swing.JPasswordField txtNhapMatKhauMoi;
    private javax.swing.JTextField txtOPT;
    // End of variables declaration                   
}

}

