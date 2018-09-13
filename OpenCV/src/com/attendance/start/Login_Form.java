package com.attendance.start;

import com.attendance.utility.AdminData;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anurag
 */
public class Login_Form extends JFrame {

    JLabel jLabel1, jLabel2, jLabel3, jLabel5, jLabel4;
    JButton btnLogin;
    JTextField txtUname;
    JPasswordField txtPwd;

    public Login_Form() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        btnLogin.setText("Login");
        btnLogin.addActionListener((java.awt.event.ActionEvent evt) -> {
            String uname = txtUname.getText().trim();
            String pwd = txtPwd.getText().trim();
            if (uname.equals(AdminData.UNAME) && pwd.equals(AdminData.PWD)) {
                Home_Form hf = new Home_Form();
                hf.setTitle("Home Form");
                hf.setVisible(true);
                Login_Form.this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Enter Valid Username & Password");
                txtUname.setText("");
                txtPwd.setText("");
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(410, 220, 110, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Faculty Login Form");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 20, 250, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 160, 150, 30);
        getContentPane().add(txtUname);
        txtUname.setBounds(300, 110, 220, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 114, 150, 20);
        getContentPane().add(txtPwd);
        txtPwd.setBounds(300, 160, 220, 30);

        pack();
    }// </editor-fold>                        

}
