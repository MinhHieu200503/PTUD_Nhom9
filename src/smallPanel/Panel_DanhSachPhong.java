/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smallPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Panel_DanhSachPhong extends javax.swing.JFrame {

    /**
     * Creates new form Panel_DanhSachPhong
     */
    public Panel_DanhSachPhong(ArrayList<entity.Phong> data) {
        initComponents();
        if (data != null){
            loadData(setEntityPhongToPanelPhong(data));
        }
        return;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_Container_ListPhong = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1080, 698));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1080, 698));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 698));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(1080, 698));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1080, 698));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 900));

        panel_Container_ListPhong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Container_ListPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOnePhong(evt);
            }
        });
        panel_Container_ListPhong.setLayout(new java.awt.GridLayout(0, 1, 1, 1));
        jScrollPane1.setViewportView(panel_Container_ListPhong);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickOnePhong(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickOnePhong
        ArrayList<Panel_Phong> tmpList = tmpPhong;
        
        
    }//GEN-LAST:event_clickOnePhong

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<entity.Phong> temp = new ArrayList<entity.Phong>();
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("002", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
           
                new Panel_DanhSachPhong(temp).setVisible(true);
            }
        });
    }
    
    public ArrayList<smallPanel.Panel_Phong> setEntityPhongToPanelPhong(ArrayList<entity.Phong> dataPhong){
        smallPanel.Panel_Phong temp;
        tmpPhong = new ArrayList<smallPanel.Panel_Phong>();
        if (dataPhong != null){
            for (entity.Phong phong : dataPhong) {
                temp = new Panel_Phong(phong,0);
                tmpPhong.add(temp);
            }
        }
        return tmpPhong;
    }
    
    
    
    
    
    
    
     public JPanel loadData(ArrayList<smallPanel.Panel_Phong> list){

        JPanel panel_Dong =  taoPanel_1_Dong();
        
        for(int i = 1;i<=list.size();i++){
            smallPanel.Panel_Phong tmp = list.get(i-1);

            panel_Dong.add(tmp);
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
            if(i%3 == 0  || (i ==  list.size() && list.size() % 3 != 0)){
                if((i ==  list.size() && list.size() % 3 != 0)){
                    panel_Dong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,20,0));
                    panel_Dong.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 1, 1));
                    System.out.println("djttttt");
                    panel_mot_dong.setPreferredSize(new java.awt.Dimension(980, 170));
//                    panel_Dong.
                }
                panel_Container_ListPhong.add(panel_Dong);
                panel_Dong =  taoPanel_1_Dong();
                System.out.println(i + "\n");
            }
        }
        getList = panel_Container_ListPhong;
        return panel_Container_ListPhong;
    }
     
     
    
    public  ArrayList<String>  getAllSelectPhong(){
        ArrayList<String> idAllPhong = new ArrayList<>();
        JPanel tmp = getList;
        for(int i = 0;i<tmp.getComponentCount();i++){
            JPanel tmp_panel_Row = (JPanel) tmp.getComponent(i);
            for(int phongIndex = 0;phongIndex<tmp_panel_Row.getComponentCount();phongIndex++){
                Panel_Phong tmpPhong = (Panel_Phong) tmp_panel_Row.getComponent(phongIndex);
                if(tmpPhong.getFlag() == true){
                    idAllPhong.add(tmpPhong.entityPhong.getMaPhong());
                }
            }
            
        }
        return idAllPhong;
    }
    
    public void mouseListPhongChoose(int choose){
        
    }
    
    private JPanel taoPanel_1_Dong(){
        panel_mot_dong = new javax.swing.JPanel();
        panel_mot_dong.setMaximumSize(new java.awt.Dimension(980, 160));
        panel_mot_dong.setPreferredSize(new java.awt.Dimension(980, 160));
        panel_mot_dong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER,20,0));
        panel_mot_dong.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 1));
        panel_mot_dong.setBackground(Color.white);
        return panel_mot_dong;
    }
    
    /**
     *
     * @return
     */

    public javax.swing.JPanel getPanel_Container_ListPhong() {
        return panel_Container_ListPhong;
    }
    public void setPanel_Container_ListPhong(javax.swing.JPanel panel_Container_ListPhong) {
        this.panel_Container_ListPhong = panel_Container_ListPhong;
    }
    
    public JPanel getList;
 
    private javax.swing.JPanel panel_mot_dong;
    private ArrayList<smallPanel.Panel_Phong> tmpPhong;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Container_ListPhong;
    // End of variables declaration//GEN-END:variables
}
