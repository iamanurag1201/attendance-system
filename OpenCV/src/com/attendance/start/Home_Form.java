package com.attendance.start;

import com.attendance.attendance.Attendance_Form;
import com.attendance.student.AddStudentForm;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Anurag
 */
public class Home_Form extends JFrame {

    public Home_Form() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {

        btnAddStudent = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        btnAddStudent.setText("Add Student");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentForm studentForm = new AddStudentForm();
                studentForm.setTitle("Add New Student");
                studentForm.setVisible(true);
                Home_Form.this.setVisible(false);
            }
        });
        getContentPane().add(btnAddStudent);
        btnAddStudent.setBounds(90, 30, 110, 30);

        jButton2.setText("Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attendance_Form af = new Attendance_Form();
                af.setSize(600, 600);
                af.setTitle("Attendance Form");
                af.setVisible(true);
                Home_Form.this.setVisible(false);

            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 30, 100, 30);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main_Form hf = new Main_Form();
                hf.setTitle("Main Form");
                hf.setVisible(true);
                Home_Form.this.setVisible(false);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(430, 30, 80, 30);

        pack();
    }// </editor-fold>                        
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton2;

}
