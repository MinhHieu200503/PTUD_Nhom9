/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package smallPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import smallPanel.Phong.CustomMouseListener_A_Phong;

/**
 *
 * @author Minh Hieu
 */
public class Phong extends javax.swing.JPanel {


//
   

    /**
     * Creates new form ListPhong
     */
    public Phong() {
        initComponents();
        
        this.setBorder(new RoundedBorder(90));
        thisPhong = this;
        this.addMouseListener(new CustomMouseListener_A_Phong());
        
        
    }
    
    
    
    
    
    class CustomMouseListener_A_Phong implements MouseListener {
        public void mouseClicked(MouseEvent e) {
                Phong tmpPhong = thisPhong;
                JOptionPane.showConfirmDialog(null, "index: "+tmpPhong.getIndex()+"\nTen Phong: "+tmpPhong.getTenPhong()+
                        "\nid Phong: "+ tmpPhong.getId()+"\nSuc Chua: "+tmpPhong.getSucChua()+"\nTrang thai: "+tmpPhong.getTrangThai()
                        +"\nGia: "+tmpPhong.getGia()
                );
            
           
        }
 
        public void mousePressed(MouseEvent e) {
        }
 
        public void mouseReleased(MouseEvent e) {
        }
 
        public void mouseEntered(MouseEvent e) {
             e.getComponent().setBackground(Color.red);
            Phong tmpPhong = thisPhong;
             Border border = new LineBorder(Color.ORANGE, 4, true);
             tmpPhong.setBorder(border);
//              Border border = new LineBorder(Color.ORANGE, 4, true);
////             dataPhong[i].setBorder(border);
        }
 
        public void mouseExited(MouseEvent e) {
             
            e.getComponent().setBackground(Color.white);
            Phong tmpPhong = thisPhong;
            tmpPhong.setBorder(new RoundedBorder(90));
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

        lb_Icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb_TenPhong = new javax.swing.JLabel();
        lb_SucChua = new javax.swing.JLabel();
        lb_Gia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 153), new java.awt.Color(0, 51, 204), new java.awt.Color(0, 204, 0), new java.awt.Color(255, 102, 255)));
        setMaximumSize(new java.awt.Dimension(320, 150));
        setMinimumSize(new java.awt.Dimension(320, 150));
        setPreferredSize(new java.awt.Dimension(320, 150));
        setLayout(new java.awt.GridBagLayout());

        lb_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Group 59 (2).png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        add(lb_Icon, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lb_TenPhong.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb_TenPhong.setText("Phòng: 101 - Hawail ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lb_TenPhong, gridBagConstraints);

        lb_SucChua.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb_SucChua.setText("Sức chứa: 20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lb_SucChua, gridBagConstraints);

        lb_Gia.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lb_Gia.setText("Giá : 150.000 VND ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lb_Gia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
        public Phong  getPhong(){
            return this;
        }
    
        public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getTenPhong() {
			return tenPhong;
		}
		public void setTenPhong(String tenPhong) {
			this.tenPhong = tenPhong;
		}
		public int getSucChua() {
			return sucChua;
		}
		public void setSucChua(int sucChua) {
			this.sucChua = sucChua;
		}
		public Double getGia() {
			return gia;
		}
		public void setGia(Double gia) {
			this.gia = gia;
		}
		public int getTrangThai() {
			return trangThai;
		}
		public void setTrangThai(int trangThai) {
			this.trangThai = trangThai;
		}
		public javax.swing.JPanel getjPanel1() {
			return jPanel1;
		}
		public void setjPanel1(javax.swing.JPanel jPanel1) {
			this.jPanel1 = jPanel1;
		}
		public javax.swing.JLabel getLb_Gia() {
			return lb_Gia;
		}
		public void setLb_Gia(javax.swing.JLabel lb_Gia) {
			this.lb_Gia = lb_Gia;
		}
		public javax.swing.JLabel getLb_Icon() {
			return lb_Icon;
		}
		public void setLb_Icon(javax.swing.JLabel lb_Icon) {
			this.lb_Icon = lb_Icon;
		}
		public javax.swing.JLabel getLb_SucChua() {
			return lb_SucChua;
		}
		public void setLb_SucChua(javax.swing.JLabel lb_SucChua) {
			this.lb_SucChua = lb_SucChua;
		}
		public javax.swing.JLabel getLb_TenPhong() {
			return lb_TenPhong;
		}
		public void setLb_TenPhong(javax.swing.JLabel lb_TenPhong) {
			this.lb_TenPhong = lb_TenPhong;
		}
    
    
    
        
    
    public void addData(int index,int id,String tenPhong,int sucChua,Double gia,int trangThai){
        //set giá trị getter/setter cho các thành phần trong object Phong
        this.index = index;
        this.id = id;
        this.tenPhong = tenPhong;
        this.sucChua = sucChua;
        this.trangThai = trangThai;
        this.gia = gia;
        
        // set giá trị cho các label hiển thị
        this.lb_TenPhong.setText(tenPhong);
        this.lb_SucChua.setText("Sức chứa: "+ sucChua+" người");
        this.lb_Gia.setText("Giá: "+gia+ " VND ");
        
        this.lb_SucChua.setName("SucChua");
        this.lb_TenPhong.setName("PhongCode");
        
    }
    protected Phong thisPhong; 
    private int id;
    private int index;
    private String tenPhong;
    private int sucChua;
    private Double gia;
    private int trangThai;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_Gia;
    private javax.swing.JLabel lb_Icon;
    private javax.swing.JLabel lb_SucChua;
    private javax.swing.JLabel lb_TenPhong;
    // End of variables declaration//GEN-END:variables

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
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
            
//            c.setForeground(Color.red);
            
        }
    }
}
