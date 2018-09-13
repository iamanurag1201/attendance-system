package com.attendance.student;

import com.attendance.start.Home_Form;
import com.attendance.utility.AttendanceConnection;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPhoto extends JFrame implements ActionListener {

    private int rno;
    private JMenuBar mb;
    private JMenu file;
    private JMenuItem open;
    private JTextArea ta;

    public AddPhoto() {
        open = new JMenuItem("Select Photo");
        open.addActionListener(this);
        file = new JMenu("Upload Photo");
        file.add(open);
        mb = new JMenuBar();
        mb.setBounds(0, 0, 800, 20);
        mb.add(file);
        ta = new JTextArea(800, 800);
        ta.setBounds(0, 20, 800, 800);
        add(mb);
        add(ta);
    }

    public AddPhoto(int rno) {
        this.rno = rno;
        open = new JMenuItem("Select Photo");
        open.addActionListener(this);
        file = new JMenu("Upload Photo");
        file.add(open);
        mb = new JMenuBar();
        mb.setBounds(0, 0, 800, 20);
        mb.add(file);
        ta = new JTextArea(800, 800);
        ta.setBounds(0, 20, 800, 800);
        add(mb);
        add(ta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                try {
                    FileInputStream fin = new FileInputStream(fc.getSelectedFile().getPath());
                    Connection conn = AttendanceConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement("update student_master set image=? where student_id=?");
                    ps.setBinaryStream(1, fin, fin.available());
                    ps.setInt(2, rno);
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "success");
                        Home_Form hf = new Home_Form();
                        hf.setTitle("Home Form");
                        hf.setVisible(true);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "failed");
                    }
                } catch (FileNotFoundException | SQLException ex) {
                    System.out.println("photo upload:" + ex);
                } catch (IOException ex) {
                    System.out.println("photo upload:" + ex);
                }
            }
        }
    }
}
