/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smallPanel;


import dao.DAO_Phong;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteLayout;

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
//        container_nho.setVisible(false);
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
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(1080, 698));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1080, 698));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 900));

        panel_Container_ListPhong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Container_ListPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOnePhong(evt);
            }
        });

        javax.swing.GroupLayout panel_Container_ListPhongLayout = new javax.swing.GroupLayout(panel_Container_ListPhong);
        panel_Container_ListPhong.setLayout(panel_Container_ListPhongLayout);
        panel_Container_ListPhongLayout.setHorizontalGroup(
            panel_Container_ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        panel_Container_ListPhongLayout.setVerticalGroup(
            panel_Container_ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tmpPhong.forEach(phong -> {
            phong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    this.setBackground(Color.red);
                    Border border = new LineBorder(Color.ORANGE, 4, true);
                    this.setBorder(border);
//                    phong.setf flag = true;
                System.out.println(".mouseClicked()");
                }

                private void setBackground(Color red) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                private void setBorder(Border border) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });
        });
        
    
        
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
            DAO_Phong dao_phong = new DAO_Phong();
            
            public void run() {

                ArrayList<entity.Phong> listPhong = new ArrayList<entity.Phong>();
               
                
                

                
                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
               temp.add(new entity.Phong("002", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));

//                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));

           
                new Panel_DanhSachPhong(listPhong).setVisible(true);

            }
        });
    }
    
    public ArrayList<smallPanel.Panel_Phong> setEntityPhongToPanelPhong(ArrayList<entity.Phong> dataPhong){
        smallPanel.Panel_Phong temp;
        tmpPhong = new ArrayList<smallPanel.Panel_Phong>();
        if (dataPhong != null){
            for (entity.Phong phong : dataPhong) {
                temp = new Panel_Phong(phong,1);
                tmpPhong.add(temp);
            }
        }
        return tmpPhong;
    }
    
    
    
    
    
     public JPanel loadData(ArrayList<smallPanel.Panel_Phong> list){

        JPanel panel_Dong =  taoPanel_1_Dong();
        JPanel container_ListPhong_minisize ;

        if(list.size()<=9){
                //tạo container con
                 container_ListPhong_minisize = new JPanel();
                container_ListPhong_minisize.setBackground(new java.awt.Color(255,255,255));
                container_ListPhong_minisize.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        clickOnePhong(evt);
                    }
                });
                container_ListPhong_minisize.setLayout(new java.awt.GridLayout(0, 1, 1, 1));
                for(int i = 1;i<=list.size();i++){
                smallPanel.Panel_Phong tmp = list.get(i-1);
                    System.out.println("asd: " + panel_mot_dong.toString());
                panel_Dong.add(tmp);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
                if(i%3 == 0  || (i ==  list.size() && list.size() % 3 != 0)){
                    if((i ==  list.size() && list.size() % 3 != 0)){
                        panel_Dong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,20,0));
                        panel_Dong.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 1, 1));
                        
                        panel_Dong.setPreferredSize(new java.awt.Dimension(1080, 170));
                        panel_Dong.setMaximumSize(new java.awt.Dimension(1080, 170));
                        panel_Dong.setMinimumSize(new java.awt.Dimension(1080, 170));
                        panel_Dong.setSize(new java.awt.Dimension(1080, 170));
//                        panel_mot_dong.setPreferredSize(new java.awt.Dimension(980, 170));
                        

                    }
                    container_ListPhong_minisize.add(panel_Dong);
                    panel_Dong =  taoPanel_1_Dong();
                    System.out.println(i + "\n");                
                }
                list.get(i-1).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) evt.getSource();
                        setAllPanelPhongFalse();
        //                System.out.println(".mouseClicked()" + tmp.getTenPhong()+ " "+ tmp.getFlag() + " "+ tmp.getSucChua() + " "+ tmp.getGia());
                        if(tmp.getBackground().equals(Color.WHITE)){
                        tmp.setBackground(Color.red);
                        Border border = new LineBorder(Color.ORANGE, 4, true);
                        tmp.setBorder(border);
                        tmp.setFlag(true);
                    }
                        else{

                           tmp.setBackground(Color.white);
                           tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                            tmp.setFlag(false);
                        }


                }

                    private void setBorder(Panel_Phong.RoundedBorder roundedBorder) {

                    }

                });
                }
                // add zo container cha
//                container_ListPhong_minisize.setSize(1080, 700);
                panel_Container_ListPhong.setLayout(new FlowLayout());
                panel_Container_ListPhong.add(container_ListPhong_minisize);
        }else{
            panel_Container_ListPhong.setBackground(new java.awt.Color(255, 255, 255));
            panel_Container_ListPhong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    clickOnePhong(evt);
                }
            });
            panel_Container_ListPhong.setLayout(new java.awt.GridLayout(0, 1, 1, 1));
            for(int i = 1;i<=list.size();i++){
            smallPanel.Panel_Phong tmp = list.get(i-1);

            panel_Dong.add(tmp);
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
            if(i%3 == 0  || (i ==  list.size() && list.size() % 3 != 0)){
                if((i ==  list.size() && list.size() % 3 != 0)){
                    panel_Dong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,20,0));
                    panel_Dong.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 1, 1));
                    
                    panel_mot_dong.setPreferredSize(new java.awt.Dimension(980, 170));
//                    panel_Dong.
                
                }
                panel_Container_ListPhong.add(panel_Dong);
                panel_Dong =  taoPanel_1_Dong();
                System.out.println(i + "\n");                
            }
            list.get(i-1).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) evt.getSource();
                    setAllPanelPhongFalse();
                    System.out.println(".mouseClicked()" + tmp.getTenPhong()+ " "+ tmp.getFlag() + " "+ tmp.getSucChua() + " "+ tmp.getGia());
                    if(tmp.getBackground().equals(Color.WHITE)){
                    tmp.setBackground(Color.red);
                    Border border = new LineBorder(Color.ORANGE, 4, true);
                    tmp.setBorder(border);
                    tmp.setFlag(true);
                }
                    else{

                       tmp.setBackground(Color.white);
                       tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                        tmp.setFlag(false);
                    }


            }

                private void setBorder(Panel_Phong.RoundedBorder roundedBorder) {
                     
                }
            
        });
        }
        }
        getList = panel_Container_ListPhong;
        return panel_Container_ListPhong;
    }
     
     
     
     
     public  void setAllPanelPhongFalse(){
         
         for(int i = 0;i<panel_Container_ListPhong.getComponentCount();i++){
             JPanel one_Row  = (JPanel) panel_Container_ListPhong.getComponent(i);
             for(int row = 0; row<one_Row.getComponentCount();row ++){
//                 System.out.println("smallPanel.Panel_DanhSachPhong.setAllPanelPhongFalse()" +i +" /" + row);
                   
                 smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) one_Row.getComponent(row);
                 tmp.setBackground(Color.white);
                 tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                 tmp.setFlag(false);
             }
         }
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
    private dao.DAO_Phong daophong;
    private javax.swing.JPanel panel_mot_dong;
    private ArrayList<smallPanel.Panel_Phong> tmpPhong;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Container_ListPhong;
    // End of variables declaration//GEN-END:variables
}
