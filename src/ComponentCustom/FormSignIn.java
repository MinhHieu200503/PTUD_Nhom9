package ComponentCustom;

import gui.GD_QuenMatKhau;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mainFrame.mainFrame;

public class FormSignIn extends JPanel {
    private final ExitButton btnExit;
    private final JLabel title;
    private final TextFieldCustom pUserName;
  
    private  TextFieldPassCustom pPassWord;
    private final Button btnConfirm;
    public final JLabel lblForgotPass;
    public GD_QuenMatKhau gd_quenMatKhau;

    public FormSignIn() {
        FontCustom cus = new FontCustom();
        setLayout(null);
        // 400 - 470


        btnExit = new ExitButton();
        btnExit.setBounds( (400 - 35) , 0, 35, 35);
        add(btnExit);
        
        title = new JLabel("Karaoke - Echo");
        title.setFont(cus.customFont23);
        title.setBounds(0, 40, 400, 40);
        title.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        add(title);
        
        pUserName = new TextFieldCustom("Username");
        pUserName.setBounds(30, 100, (400 - 30 * 2), 60);
        add(pUserName);

          
        pPassWord = new TextFieldPassCustom("Password");
        pPassWord.setBounds(30, 180, (400 - 30 * 2), 60);
        
        add(pPassWord);
        
        


//        pPassWord = new TextFieldCustom("Password", "pass.png");
//        pPassWord.setBounds(30, 180 + 80, (400 - 30 * 2), 60);
//        add(pPassWord);

        btnConfirm = new Button("Login");
        btnConfirm.setBounds(30, 180 + 120, 340, 50);
        add(btnConfirm);

        lblForgotPass = new JLabel("Forgot password ?!!");
        lblForgotPass.setFont(cus.customFont17);
        lblForgotPass.setBounds((400 - 178) / 2,180 + 200, 178, 30);
        add(lblForgotPass);

        lblForgotPass.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblForgotPass.setBorder(new MatteBorder(0,0,1,0,Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblForgotPass.setBorder(null);
            }
        });
        
        
    }

    // Paint Component
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#A1FFCE"), w, h, Color.decode("#FAFFD1"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,40,40);
    }
}


