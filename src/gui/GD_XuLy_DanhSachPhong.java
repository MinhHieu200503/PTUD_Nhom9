/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import dao.DAO_Phong;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import smallPanel.Panel_FullOptionDanhSachPhong;

/**
 *
 * @author LENOVO
 */
public class GD_XuLy_DanhSachPhong extends javax.swing.JFrame {

    /**
     * Creates new form GD_XuLyDanhSachPhong
     */
    public GD_XuLy_DanhSachPhong() {
        
        initComponents();
        
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========

                this.remove(panel_FullOptionDanhSachPhong1);
        
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========       
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========
//        ========------ DELETE IMPORTANT FINAL PROJECT ------========

//      DATE ENTITY.PHONG
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
           
                
        panel_FullOptionDanhSachPhong = new Panel_FullOptionDanhSachPhong();
        this.add(panel_FullOptionDanhSachPhong, java.awt.BorderLayout.WEST );
        
        
        //FUNCITON LOAD LIST 
        panel_FullOptionDanhSachPhong.setListPhong(temp);
        panel_FullOptionDanhSachPhong.load();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_FullOptionDanhSachPhong1 = new smallPanel.Panel_FullOptionDanhSachPhong();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1620, 964));
        getContentPane().add(panel_FullOptionDanhSachPhong1, java.awt.BorderLayout.WEST);
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_XuLy_DanhSachPhong().setVisible(true);
            }
        });
    }
    
    
     public Panel_FullOptionDanhSachPhong panel_FullOptionDanhSachPhong;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private smallPanel.Panel_FullOptionDanhSachPhong panel_FullOptionDanhSachPhong1;
    // End of variables declaration//GEN-END:variables
}
