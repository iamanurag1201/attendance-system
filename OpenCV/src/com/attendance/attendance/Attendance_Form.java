package com.attendance.attendance;

import com.attendance.start.Home_Form;
import com.attendance.student.StudentDAO;
import com.attendance.student.StudentDTO;
import com.attendance.utility.AttendanceDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.opencv.core.Core;

public class Attendance_Form extends JFrame implements ActionListener {

    private int rno;
    private JMenuBar mb;
    private JMenu file;
    private JMenuItem open;
    private JTextArea ta;

    public Attendance_Form() {
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

    private void addTtendance(BufferedImage originalImage) {
        try {

            int width = originalImage.getWidth(null);
            int height = originalImage.getHeight(null);
            int[][] originalPic = new int[width][height];
            ArrayList<StudentDTO> list = new StudentDAO().getAllStudents();
            if (list != null) {
                int g = 0;
                for (StudentDTO bean : list) {
                    if (bean.getImage() != null) {
                        BufferedImage bufferedImage = ImageIO.read(bean.getImage().getBinaryStream());
                        int width2 = bufferedImage.getWidth(null);
                        int height2 = bufferedImage.getHeight(null);
                        int[][] adatabsePic = new int[width2][height2];
                        int smw = 0;
                        int smh = 0;
                        int p = 0;
                        if (width > width2) {
                            smw = width2;
                        } else {
                            smw = width;
                        }
                        if (height > height2) {
                            smh = height2;
                        } else {
                            smh = height;
                        }
                        for (int a = 0; a < smw; a++) {
                            for (int b = 0; b < smh; b++) {
                                originalPic[a][b] = originalImage.getRGB(a, b);
                                adatabsePic[a][b] = bufferedImage.getRGB(a, b);
                                if (originalPic[a][b] == adatabsePic[a][b]) {
                                    p++;
                                } else {
                                    g++;
                                }
                            }
                        }
                        float w, h = 0;
                        if (width > width2) {
                            w = width;
                        } else {
                            w = width2;
                        }
                        if (height > height2) {
                            h = height;
                        } else {
                            h = height2;
                        }
                        float s = (smw * smh);
                        float x = (100 * p) / s;
                        if (x >= 90) {
                            AttendanceBean ab = new AttendanceBean();
                            ab.setStudent_id(bean.getStudent_id());
                            ab.setStatus("P");
                            ab.setDate(AttendanceDate.getCurrentDate());
//                        JOptionPane.showMessageDialog(null, "Success");
                            new AttendanceDAO().addAttendance(ab);
                        } else {
                            AttendanceBean ab = new AttendanceBean();
                            ab.setStudent_id(bean.getStudent_id());
                            ab.setStatus("A");
                            ab.setDate(AttendanceDate.getCurrentDate());
//                        JOptionPane.showMessageDialog(null, "Failed");
                            new AttendanceDAO().addAttendance(ab);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Students Attendance have to Complete");
            } else {
                JOptionPane.showMessageDialog(null, "Students Not Available");
            }
            Home_Form hf = new Home_Form();
            hf.setTitle("Main Form");
            hf.setVisible(true);
            Attendance_Form.this.setVisible(false);
        } catch (IOException | SQLException ex) {
            System.out.println("addTtendance failed:" + ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage image = ImageIO.read(new File(fc.getSelectedFile().getPath()));
                    addTtendance(image);
                } catch (IOException ex) {
                    System.out.println("photo selection failed:" + e);
                }
            }
        }
    }

    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Attendance_Form af = new Attendance_Form();
                af.setSize(500, 500);
                af.setVisible(true);
            }
        });
    }
}
