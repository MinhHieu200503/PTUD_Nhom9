/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smallPanel;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import gui.GD_XuLy_DatPhongNgay;
//import gui.GD_XuLy_DatPhongNgay;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class Panel_DanhSachPhongFullCol extends javax.swing.JFrame {

    /**
     * Creates new form Panel_DanhSachPhong
     */
//    public Panel_DanhSachPhongFullCol(ArrayList<entity.Phong> data) {
//        FlatMacLightLaf.setup();
//        UIManager.put( "Button.arc", 10 );
//        UIManager.put( "Component.arc", 10 );
//        UIManager.put( "ProgressBar.arc", 10 );
//        UIManager.put( "TextComponent.arc", 10 );
//        initComponents();
//        if (data != null){
//            loadData(setEntityPhongToPanelPhong(data));
//        }
//        
//       jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                System.out.println(".mouseClicked()");
//                clickPanel(evt);
//            }
//        });
//        return;
//    }
    
    public Panel_DanhSachPhongFullCol(ArrayList<entity.Phong> data, Class typeClass) {
        typeInterface = typeClass;
        FlatMacLightLaf.setup();
        UIManager.put( "Button.arc", 10 );
        UIManager.put( "Component.arc", 10 );
        UIManager.put( "ProgressBar.arc", 10 );
        UIManager.put( "TextComponent.arc", 10 );
        initComponents();
        if (data != null){
            loadData(setEntityPhongToPanelPhong(data));
        }

        
        System.out.println("Jscorll" + jScrollPane1.getSize().toString() + jScrollPane1.getMaximumSize().toString() + jScrollPane1.getMinimumSize().toString() + jScrollPane1.getPreferredSize().toString());

        
        
        
        
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
        setMinimumSize(new java.awt.Dimension(900, 964));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 964));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 964));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 964));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(900, 750));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(900, 750));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 750));
        jScrollPane1.setRequestFocusEnabled(false);

        panel_Container_ListPhong.setBackground(new java.awt.Color(255, 255, 255));
        panel_Container_ListPhong.setMaximumSize(new java.awt.Dimension(900, 964));
        panel_Container_ListPhong.setMinimumSize(new java.awt.Dimension(900, 964));

        javax.swing.GroupLayout panel_Container_ListPhongLayout = new javax.swing.GroupLayout(panel_Container_ListPhong);
        panel_Container_ListPhong.setLayout(panel_Container_ListPhongLayout);
        panel_Container_ListPhongLayout.setHorizontalGroup(
            panel_Container_ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        panel_Container_ListPhongLayout.setVerticalGroup(
            panel_Container_ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel_Container_ListPhong);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

     private void clickOnePhong(java.awt.event.MouseEvent evt) {                               
        ArrayList<Panel_Phong> tmpList = tmpPhong;
        tmpPhong.forEach(phong -> {
            phong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    this.setBackground(Color.red);
                    Border border = new LineBorder(Color.ORANGE, 4, true);
                    this.setBorder(border);
                    smallPanel.Panel_Phong phong = (smallPanel.Panel_Phong) evt.getSource();
                    maPhongGoiDVduocChon = phong.getCode();
//                    phong.setf flag = true;
                System.out.println(".mouseClicked()");
                }

                private void setBackground(Color red) {
                }

                private void setBorder(Border border) {
                }
            });
        });
        
        
        
    }                              

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
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường",12 ,5,"không")));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("LP001", "Thường",12 ,5,"không")));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường",12 ,5,"không")));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường",12 ,5,"không")));
                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường",12 ,5,"không")));

                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường",12 ,5,"không")));
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
//                        temp.add(new entity.Phong("003", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("004", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("005", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("006", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("007", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("008", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("009", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//                temp.add(new entity.Phong("001", "Minh", 1, new entity.LoaiPhong("001", "Thường", "không"), 15,5));
//           
//                
//                new Panel_DanhSachPhongFullCol(temp,GD_XuLy_DatPhongNgay.class).setVisible(true);
            }
        });
    }
    
    public ArrayList<smallPanel.Panel_Phong> setEntityPhongToPanelPhong(ArrayList<entity.Phong> dataPhong){
        smallPanel.Panel_Phong temp;
        tmpPhong = new ArrayList<smallPanel.Panel_Phong>();
        if (dataPhong != null){
            for (entity.Phong phong : dataPhong) {
                temp = new Panel_Phong(phong);
                tmpPhong.add(temp);
            }
        }
        return tmpPhong;
    }
    
    
    
    
    
     public JPanel loadData(ArrayList<smallPanel.Panel_Phong> list){

        JPanel panel_Dong =  taoPanel_1_Dong();
        JPanel container_ListPhong_minisize ;

        if(list.size()<=12){
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
                panel_Dong.add(tmp);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
                if(i%3 == 0  || (i ==  list.size() && list.size() % 3 != 0)){
                    
                    container_ListPhong_minisize.add(panel_Dong);
                    panel_Dong =  taoPanel_1_Dong();              
                }
                list.get(i-1).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) evt.getSource();
                        if(tmp.getBackground().equals(Color.WHITE)){
                            setAllPanelPhongFalse();
                            tmp.setBackground(Color.red);
                            Border border = new LineBorder(Color.ORANGE, 4, true);
                            tmp.setBorder(border);
                            tmp.setFlag(true);
                        
                    }
                        String classUse = typeInterface.getName().substring(12);
                        System.out.println(".mouseClicked() =>>>> " + classUse);
                    if(classUse.equalsIgnoreCase("DatPhongNgay")){
                        clickPanel(evt);
                        
                    }
                    else if(classUse.equalsIgnoreCase("GoiDichVu")){
//                        gui.GD_XuLy_GoiDichVu.fillData(tmp.getCode());
                    }
                    else if(classUse.equalsIgnoreCase("DatPhongTruoc")){
                        DatPhongTruoc(evt);
                    }
                    else if(classUse.equalsIgnoreCase("DanhSachPhong")){
                        DanhSachPhong(evt);
                    }
                    else if(classUse.equalsIgnoreCase("NhanPhong")){
                        NhanPhong(evt);
                    }
                        
               
                }

                    private void setBorder(Panel_Phong.RoundedBorder roundedBorder) {

                    }

                });
                }

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
                
                panel_Container_ListPhong.add(panel_Dong);
                panel_Dong =  taoPanel_1_Dong();              
            }
            list.get(i-1).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) evt.getSource();
                    
                    if(tmp.getBackground().equals(Color.WHITE)){
                    setAllPanelPhongFalse();
                    tmp.setBackground(Color.red);
                    Border border = new LineBorder(Color.ORANGE, 4, true);
                    tmp.setBorder(border);
                    tmp.setFlag(true);
                }

                    String classUse = typeInterface.getName().substring(12);
                        System.out.println(".mouseClicked() =>>>> " + classUse);
                    if(classUse.equalsIgnoreCase("DatPhongNgay")){
                        clickPanel(evt);
                        
                    }
                    else if(classUse.equalsIgnoreCase("GoiDichVu")){
//                        gui.GD_XuLy_GoiDichVu.fillData(tmp.getCode());
                    }
                    else if(classUse.equalsIgnoreCase("DatPhongTruoc")){
                        DatPhongTruoc(evt);
                    }
                    else if(classUse.equalsIgnoreCase("DanhSachPhong")){
                        DanhSachPhong(evt);
                    }
                    else if(classUse.equalsIgnoreCase("NhanPhong")){
                        NhanPhong(evt);
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
         int listPhongCount = tmpPhong.size();
         if(listPhongCount<=12)
         {
             JPanel panel_Con = (JPanel) panel_Container_ListPhong.getComponent(0);
             for(int i = 0;i<panel_Con.getComponentCount();i++){
             JPanel one_Row  = (JPanel) panel_Con.getComponent(i);
             for(int row = 0; row<one_Row.getComponentCount();row ++){
                   
                 smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) one_Row.getComponent(row);
                 if(!tmp.getBackground().equals(Color.BLUE)){
                    tmp.setBackground(Color.white);
                    tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                    tmp.setFlag(false);
                 }
             }
         }
         }
         else
         {
             for(int i = 0;i<panel_Container_ListPhong.getComponentCount();i++){
             JPanel one_Row  = (JPanel) panel_Container_ListPhong.getComponent(i);
             for(int row = 0; row<one_Row.getComponentCount();row ++){
                   smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) one_Row.getComponent(row);
                 if(!tmp.getBackground().equals(Color.BLUE)){
                    
                    tmp.setBackground(Color.white);
                    tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                    tmp.setFlag(false);
                 }
             }
         }
         }
         
     }
     
     public static void  setPhongDefault(String maPhong){
         listPhongCount  = tmpPhong.size();
         
         if(listPhongCount<=12)
         {
             
              panel_Con = (JPanel) panel_Container_ListPhong.getComponent(0);
             for(int i = 0;i<panel_Con.getComponentCount();i++){
             JPanel one_Row  = (JPanel) panel_Con.getComponent(i);
             for(int row = 0; row<one_Row.getComponentCount();row ++){   
                 smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) one_Row.getComponent(row); 
                 if(tmp.getCode().substring(tmp.getCode().length() - 5).equals(maPhong)){
                    tmp.setBackground(Color.white);
                    tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                    tmp.setFlag(false);
                 }
             }
         }
         }
         else
         {
             
             for(int i = 0;i<panel_Container_ListPhong.getComponentCount();i++){
             JPanel one_Row  = (JPanel) panel_Container_ListPhong.getComponent(i);
             for(int row = 0; row<one_Row.getComponentCount();++row ){
                   smallPanel.Panel_Phong tmp = (smallPanel.Panel_Phong) one_Row.getComponent(row);
                  String maPhongCSDL = tmp.getCode().substring(tmp.getCode().length() - 5);
                 if(maPhongCSDL.equals(maPhong)){
                    tmp.setBackground(Color.white);
                    tmp.setBorder(new Panel_Phong.RoundedBorder(90));
                    tmp.setFlag(false);
                 }
             }
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
        panel_mot_dong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,20,0));
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
    static int   listPhongCount;
    static JPanel panel_Con;
    private javax.swing.JPanel panel_mot_dong;
    private static ArrayList<smallPanel.Panel_Phong> tmpPhong;
    public Class typeInterface = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JPanel panel_Container_ListPhong;
    // End of variables declaration//GEN-END:variables

            public int clickPanel(MouseEvent evt) {
                if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                     evt.consume();
                     smallPanel.Panel_Phong temp = (smallPanel.Panel_Phong) evt.getSource();
                     codePhong = temp.getCode();
                      temp.setBackground(Color.BLUE);
                    Border border = new LineBorder(new Color(0,153,153), 4, true);
                    temp.setBorder(border);
                    GD_XuLy_DatPhongNgay.setTableData(codePhong);
                }
            return 1;

            }
            
            public void DatPhongTruoc(MouseEvent evt){
                evt.consume();
                smallPanel.Panel_Phong temp = (smallPanel.Panel_Phong) evt.getSource();
                gui.GD_XuLy_DatPhongTruoc.setTienCoc(temp.getCode().substring(temp.getCode().length() - 5));
                codePhong =temp.getCode().substring(temp.getCode().length() - 5);
                    
            }
            
            public void NhanPhong(MouseEvent evt){
                evt.consume();
                smallPanel.Panel_Phong temp = (smallPanel.Panel_Phong) evt.getSource();
                gui.GD_XuLy_NhanPhong.setTienCoc(temp.getCode().substring(temp.getCode().length() - 5));
                gui.GD_XuLy_NhanPhong.setTxtThongTinDatPhong(temp.getCode().substring(temp.getCode().length() - 5));             
                codePhong =temp.getCode().substring(temp.getCode().length() - 5);
   
            }
            
           public void DanhSachPhong(MouseEvent evt){
                evt.consume();
                smallPanel.Panel_Phong temp = (smallPanel.Panel_Phong) evt.getSource();
                gui.GD_XuLy_DanhSachPhong.clickPhong(temp.getCode().substring(temp.getCode().length() - 5));
                codePhong =temp.getCode().substring(temp.getCode().length() - 5);
   
            }
            
    public static String codePhong = "Chua nhan sk click dau";
    public static String maPhongGoiDVduocChon ="chua co";
}


