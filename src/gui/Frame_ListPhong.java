/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import smallPanel.Phong;

/**
 *
 * @author Minh Hieu
 */
public class Frame_ListPhong extends javax.swing.JFrame {

    // tạo frame
    public Frame_ListPhong() {
        initComponents();
         addPhongToList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Container_Fram = new javax.swing.JPanel();
        lableFilterOption1 = new javax.swing.JLabel();
        lableFilterOption2 = new javax.swing.JLabel();
        lableFilterOption3 = new javax.swing.JLabel();
        ComboFilterOption1 = new javax.swing.JComboBox<>();
        ComboFilterOption2 = new javax.swing.JComboBox<>();
        ComboFilterOption3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_Container_ListPhong = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 964));
        setMinimumSize(new java.awt.Dimension(1920, 964));
        setPreferredSize(new java.awt.Dimension(1920, 964));

        Panel_Container_Fram.setBackground(new java.awt.Color(204, 204, 255));
        Panel_Container_Fram.setMaximumSize(new java.awt.Dimension(108, 108));

        lableFilterOption1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lableFilterOption1.setText("Lọc theo loại phòng");

        lableFilterOption2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lableFilterOption2.setText("Lọc theo trạng thái:");

        lableFilterOption3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lableFilterOption3.setText("Lọc theo sức chứa:");

        ComboFilterOption1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboFilterOption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ComboFilterOption1MouseExited(evt);
            }
        });
        ComboFilterOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboFilterOption1ActionPerformed(evt);
            }
        });

        ComboFilterOption2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboFilterOption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboFilterOption2MouseClicked(evt);
            }
        });

        ComboFilterOption3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(330, 160));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(330, 160));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(330, 160));

        panel_Container_ListPhong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Container_ListPhong.setMaximumSize(new java.awt.Dimension(330, 160));
        panel_Container_ListPhong.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        jScrollPane1.setViewportView(panel_Container_ListPhong);

        javax.swing.GroupLayout Panel_Container_FramLayout = new javax.swing.GroupLayout(Panel_Container_Fram);
        Panel_Container_Fram.setLayout(Panel_Container_FramLayout);
        Panel_Container_FramLayout.setHorizontalGroup(
            Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Container_FramLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_Container_FramLayout.createSequentialGroup()
                        .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lableFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179)
                        .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lableFilterOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboFilterOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lableFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        Panel_Container_FramLayout.setVerticalGroup(
            Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Container_FramLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lableFilterOption1)
                    .addComponent(lableFilterOption3)
                    .addComponent(lableFilterOption2))
                .addGap(15, 15, 15)
                .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_Container_FramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboFilterOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboFilterOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboFilterOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Container_Fram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 822, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Container_Fram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboFilterOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboFilterOption1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboFilterOption1ActionPerformed

    private void ComboFilterOption2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboFilterOption2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboFilterOption2MouseClicked

    private void ComboFilterOption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboFilterOption1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboFilterOption1MouseExited

    private void A_Phong_Mouse_Entered(java.awt.event.MouseEvent evt) {                                                
       
    }    
    // du liệu test
    private String[] dataTmp(){
        return new String[] {" 1","2","3"," 4","5","6","7","8","9","10","11","12"};
    }
    // tạo 1 phòng trong ds phòng
    private JPanel CreateGUI_A_Phong(String Status_Phong,String SucChua,String CodePhong){
        GUI_A_Phong = new javax.swing.JPanel();
        icon_Status = new javax.swing.JLabel();
        label_PhongCode = new javax.swing.JLabel();
        label_SucChua = new javax.swing.JLabel();
        txt_SucChua = new javax.swing.JLabel();
        label_Nguoi = new javax.swing.JLabel();
        txt_PhongCode = new javax.swing.JLabel();
        
        txt_PhongCode.setName("PhongCode");
        txt_SucChua.setName("SucChua");
        if(Status_Phong.equalsIgnoreCase("Empty")){
            icon_Status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Status_Available.png"))); // NOI18N
        }
        else if(Status_Phong.equalsIgnoreCase("Waiting")){
            icon_Status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Status_Wating.png"))); // NOI18N
        }
        else{
           icon_Status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Status_Unvailable123.png"))); // NOI18N 
        }
         
        
        label_PhongCode.setText("Phòng:");

        label_SucChua.setText("Sức chứa: ");

        txt_SucChua.setText(SucChua);

        label_Nguoi.setText("Người");

        txt_PhongCode.setText(CodePhong);

        javax.swing.GroupLayout GUI_A_PhongLayout = new javax.swing.GroupLayout(GUI_A_Phong);
        GUI_A_Phong.setLayout(GUI_A_PhongLayout);
        GUI_A_PhongLayout.setHorizontalGroup(
            GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(icon_Status)
                .addGap(47, 47, 47)
                .addGroup(GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                        .addComponent(label_SucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SucChua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Nguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                        .addComponent(label_PhongCode, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_PhongCode)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        GUI_A_PhongLayout.setVerticalGroup(
            GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_PhongCode)
                    .addComponent(txt_PhongCode))
                .addGroup(GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon_Status))
                    .addGroup(GUI_A_PhongLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(GUI_A_PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_SucChua)
                            .addComponent(txt_SucChua)
                            .addComponent(label_Nguoi))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        
        // set background của 1 phòng và cái viền border
        GUI_A_Phong.setBackground(Color.WHITE);
        GUI_A_Phong.setBorder(new RoundedBorder(50));
        
        return GUI_A_Phong;
    }
    // thêm phòng vào danh sách phòng
    public void addPhongToList(){
//        panel_Container_ListPhong.setLayout(new GridLayout(0,3,20,20));
         panel_Container_ListPhong.setBorder(new EmptyBorder(20,20,20,20));
          jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
         dataPhong=new Phong[5];
         for(int i = 0;i<dataPhong.length;i++){
             dataPhong[i] = new Phong();
             dataPhong[i].addData(i, i*10, "00"+i, 5, 150.000, 2);
//             Border border = new LineBorder(Color.ORANGE, 4, true);
//             dataPhong[i].setBorder(border);
//             dataPhong[i].setBackground(Color.red);
             panel_Container_ListPhong.add(dataPhong[i]);
         }
    }
    
    // hàm main
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
            java.util.logging.Logger.getLogger(Frame_ListPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_ListPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_ListPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ListPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_ListPhong().setVisible(true);
            }
        });
    }
    // Khởi tạo các biến 
    private javax.swing.JPanel GUI_A_Phong;
    private javax.swing.JLabel icon_Status;
    private javax.swing.JLabel label_Nguoi;
    private javax.swing.JLabel label_PhongCode;
    private javax.swing.JLabel label_SucChua;
    
    private javax.swing.JLabel txt_PhongCode;
    private javax.swing.JLabel txt_SucChua;
    protected Phong dataPhong[];
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboFilterOption1;
    private javax.swing.JComboBox<String> ComboFilterOption2;
    private javax.swing.JComboBox<String> ComboFilterOption3;
    private javax.swing.JPanel Panel_Container_Fram;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lableFilterOption1;
    private javax.swing.JLabel lableFilterOption2;
    private javax.swing.JLabel lableFilterOption3;
    private javax.swing.JPanel panel_Container_ListPhong;
    // End of variables declaration//GEN-END:variables

    
 
   private Dimension Dimension(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   // class config bo góc ở mỗi phòng
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
//            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }
    
    // EVENT 
    
    
    
    
    
}
