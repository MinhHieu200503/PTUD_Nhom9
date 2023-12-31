/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import ComponentCustom.ExitButton;
import ComponentCustom.FormSignIn;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.DAO_TaiKhoan;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 *
 * @author LENOVO
 */
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        btnXacNhan1.setText("Xác nhận");
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
    }// </editor-fold>//GEN-END:initComponents

    private void txtOPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOPTActionPerformed

    private void txtNhapMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapMailActionPerformed

    private void btnXacNhanOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanOTPActionPerformed
        
    }//GEN-LAST:event_btnXacNhanOTPActionPerformed

    private void btnNhanOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhanOTPActionPerformed

    private void btnNhanOTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanOTPMouseClicked
        // TODO add your handling code here:
        dao.DAO_TaiKhoan taiKhoan = new DAO_TaiKhoan();
        OTP = taiKhoan.sendEmail(txtNhapMail.getText());
        if(OTP == -1){
            JOptionPane.showMessageDialog(null,"Gmail không hợp lệ !!! Vui lòng nhập lại");
        }
        else{
            btnXacNhanOTP.setEnabled(true);
        }
        
    }//GEN-LAST:event_btnNhanOTPMouseClicked

    private void btnXacNhanOTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanOTPMouseClicked
        // TODO add your handling code here:
        if(OTP == Integer.parseInt(txtOPT.getText())){
            btnXacNhan.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "OTP không đúng !!! Xin vui lòng thử lại");
        }
    }//GEN-LAST:event_btnXacNhanOTPMouseClicked

    private void btnXacNhan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhan1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXacNhan1MouseClicked

    private void btnXacNhan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXacNhan1ActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnXacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanMouseClicked
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

    }//GEN-LAST:event_btnXacNhanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 10 );
        
        UIManager.put( "TextComponent.arc", 10 );
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuenMatKhau().setVisible(true);
            }
        });
    }
    
    

    public ExitButton btnExit;
    public int OTP;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
