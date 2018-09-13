package com.attendance.student;

import javax.swing.JOptionPane;
import org.opencv.core.Core;

public class AddStudentForm extends javax.swing.JFrame {

    public AddStudentForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEr = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter ER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 190, 120, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 140, 120, 30);
        getContentPane().add(txtEr);
        txtEr.setBounds(260, 190, 260, 30);
        getContentPane().add(txtName);
        txtName.setBounds(260, 140, 260, 30);

        jLabel5.setBackground(new java.awt.Color(255, 255, 153));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Student Registration Form");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 102), null, null));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 50, 220, 40);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(425, 240, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        StudentDTO sdto = new StudentDTO();
        String num = txtEr.getText();
        String name = txtName.getText().trim();
        if (name == null || name.length() == 0) {
            JOptionPane.showMessageDialog(null, "please enter name");
            return;
        }

        if (num == null || num.length() == 0) {
            JOptionPane.showMessageDialog(null, "please enter enrolment number");
            return;
        }
        int er = Integer.parseInt(num);
        if (new StudentDAO().chekEr(er)) {
            JOptionPane.showMessageDialog(null, "enrolment number already exist");
            return;
        }
        sdto.setName(name);
        sdto.setStudent_er(er);
        sdto.setImage(null);
        int rno = new StudentDAO().addStudent(sdto);
        if (rno != 0) {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new gui.AddPhoto(rno).setVisible(true);
                }
            });
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Student Registration Failed");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEr;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
