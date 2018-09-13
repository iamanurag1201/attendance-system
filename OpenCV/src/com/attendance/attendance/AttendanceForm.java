package com.attendance.attendance;

import com.attendance.student.StudentDAO;
import com.attendance.student.StudentDTO;
import com.attendance.utility.AttendanceDate;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AttendanceForm extends javax.swing.JFrame {

    public AttendanceForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTtendance(Blob blob) {
        try {
            BufferedImage originalImage = ImageIO.read(blob.getBinaryStream());
            int width = originalImage.getWidth(null);
            int height = originalImage.getHeight(null);
            int[][] originalPic = new int[width][height];
            ArrayList<StudentDTO> list = new StudentDAO().getAllStudents();
            if (list != null) {
                int g = 0;
                for (StudentDTO bean : list) {
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
                        JOptionPane.showMessageDialog(null, "Success");
                        // new AttendanceDAO().addAttendance(ab);
                    } else {
                        AttendanceBean ab = new AttendanceBean();
                        ab.setStudent_id(bean.getStudent_id());
                        ab.setStatus("A");
                        ab.setDate(AttendanceDate.getCurrentDate());
                        JOptionPane.showMessageDialog(null, "Failed");
                        //  new AttendanceDAO().addAttendance(ab);
                    }
                }
            }
        } catch (IOException | SQLException ex) {
            System.out.println("addTtendance failed:" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
