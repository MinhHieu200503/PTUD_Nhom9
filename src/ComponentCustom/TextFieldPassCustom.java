package ComponentCustom;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldPassCustom extends JPanel {
    private final JLabel lbltitle;
    private final JPasswordField txttitle;
    private final JLabel lblicon;
    private int yLocate = 25;
    private boolean flag=false;
    public TextFieldPassCustom (String title) {
        setLayout(null);
        setOpaque(false);
        setBackground(null);
        FontCustom cus = new FontCustom();
        setBorder(new MatteBorder(0,0,1,0, Color.BLACK));
        
        // 340 60
        lbltitle = new JLabel(title);
        lbltitle.setFont(cus.customFont17);
        lbltitle.setBounds(0, yLocate, 150, 30);
        add(lbltitle);

        txttitle = new JPasswordField();
        txttitle.setFont(cus.customFont17);
        txttitle.setBounds(0, 30, 310, 30);
        txttitle.setOpaque(false);
        txttitle.setBackground(null);
        txttitle.setBorder(null);
        add(txttitle);

        lblicon = new JLabel();
//        lblicon.setIcon(new ImageIcon("img/icons8-eye-30.png"));
        lblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-hide-30.png")));
        lblicon.setBounds((340 - 30) ,  30, 30, 30);
        add(lblicon);
        
        
        lblicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(!flag){
                    flag=true;
                    lblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye-30.png")));
                    txttitle.setEchoChar((char)0);
                }
                else{
                    flag=false;
                    lblicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-hide-30.png")));
                    txttitle.setEchoChar('*');
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                
            }
        });

        txttitle.addFocusListener(new FocusListener() {
            private Timer t;

            @Override
            public void focusGained(FocusEvent e) {
                if (txttitle.getText().equals("")) {
                    t = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (yLocate > 5) {
                                yLocate --;
                                lbltitle.setBounds(0, yLocate, 150, 30);
                                invalidate();
                                validate();
                                repaint();
                            }else {
                                t.stop();
                            }
                        }
                    });
                    t.start();
                } else {
                    t.stop();
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txttitle.getText().equals("")) {
                    t = new Timer(1, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (yLocate < 25) {
                                yLocate ++;
                                lbltitle.setBounds(0, yLocate, 150, 30);
                                invalidate();
                                validate();
                                repaint();
                            } else {
                                t.stop();
                            }
                        }
                    });
                    t.start();
                }else {
                    t.stop();
                }

            }
        });
    }
}
