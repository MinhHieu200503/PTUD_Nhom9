/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author quang
 */
public class DAO_TaiKhoan implements I_CRUD<TaiKhoan>{

    public int sendEmail(String email){
        final String from = "tathang253@gmail.com";
        final String password = "hscd sfem dcan hjng";
        
        
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        
        // create authenticator
        Authenticator auth;
        auth = new Authenticator() {
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,password);
            }       
        };
        
        // Phiên làm việc
        Session session = Session.getInstance(props, auth);
        
        //Gui email
       final String to = email;
       //tạo 1 tin nhắn mới
        MimeMessage msg = new MimeMessage(session);
        
        try {
            msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
            //người gửi
            msg.setFrom(from);
            // người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            //tiêu đề
            msg.setSubject("OTP quên mật khẩu");
            //Quy định ngày gửi
            msg.setSentDate(new java.util.Date());
            // nội dung
            Random generator = new Random();
            int OTP =  100000 + generator.nextInt(900000);
           
            if(OTP<0) OTP = OTP * (-1);
            msg.setText(String.valueOf(OTP),"UTF-8");
            
            //Gửi email
            Transport.send(msg);
            return OTP;
        } catch (Exception e) {
            
            e.printStackTrace();
            return -1;
        }
        
    }

    public int capNhatMatKhau(String gmail, String newPassword){
        
            ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {

            statement = con.prepareStatement("update TaiKhoan\n" +
                                            "set matKhau = ?\n" +
                                            "where  maNhanVien in  (select t.maNhanVien from TaiKhoan t join NhanVien n\n" +
                                            "on t.maNhanVien = n.maNhanVien where gmail = ?)");

            statement.setString(1, newPassword);
            statement.setString(2, gmail);
            
            n = statement.executeUpdate();

        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            return n;
        }
    }
    public boolean updateTK(TaiKhoan tk) { // dựa trên mã nhân viên: vì mã nhân viên nó bất biến
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement pstm;
        int n = 0;
        try {
            String sql = "update taikhoan set tentaikhoan = ?, matkhau = ?, vaitro = ? where manhanvien = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tk.getTenTaiKhoan());
            pstm.setString(2, tk.getMatKhau());
            pstm.setBoolean(3, tk.getVaiTro());
            pstm.setString(4, tk.getNhanVien().getMaNhanVien());
            n = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    public TaiKhoan findByNV(String id) { // id là id nhân viên
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            Statement stm = con.createStatement();
            String sql = "select * from taikhoan where maNhanVien = '" + id + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getBoolean(3), I_CRUD.findById(id, new NhanVien()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
