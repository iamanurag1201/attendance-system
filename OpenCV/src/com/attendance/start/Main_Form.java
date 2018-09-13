package com.attendance.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Anurag
 */
public class Main_Form extends JFrame implements ActionListener {
    
    JLabel jLabel1, jLabel2, jLabel3, jLabel5, jLabel4;
    JButton jButton1;
    
    public Main_Form() {
        initComponents();
    }    
    
    private void initComponents() {
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("AUTOMATIC ATTENDANCE SYSTEM");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 110, 330, 40);
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("To");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 60, 30, 40);
        
       /* jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Anurag Richharia");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 230, 220, 40);*/
        
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Welcome");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 10, 120, 40);
        
      /*  jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Submited By");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 180, 170, 40);*/
        
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 102));
        jButton1.setText("Next");
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 310, 200, 40);
        jButton1.addActionListener(this);
        pack();
    } 

    public static void main(String[] args) {
        Main_Form mf = new Main_Form();
        mf.setSize(600, 600);
        mf.setTitle("Main Form");
        mf.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Login_Form mf = new Login_Form();
        mf.setSize(600, 600);
        mf.setTitle("Login Form");
        mf.setVisible(true);
        this.setVisible(false);    
    }
}
