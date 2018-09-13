package com.attendance.student;

import com.attendance.utility.AttendanceConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int addStudent(StudentDTO sdto) {
        int rno = 0;
        if (conn == null) {
            conn = AttendanceConnection.getConnection();
        }
        try {
            ps = conn.prepareStatement("insert into student_master(student_er, name, image) values(?,?,?)");
            ps.setInt(1, sdto.getStudent_er());
            ps.setString(2, sdto.getName());
            ps.setBlob(3, sdto.getImage());
            if (ps.executeUpdate() > 0) {
                ps = null;
                ps = conn.prepareStatement("SELECT MAX(student_id) AS rno FROM student_master");
                rs = ps.executeQuery();
                if (rs.next()) {
                    rno = rs.getInt("rno");
                }
            }
        } catch (SQLException e) {
            System.out.println("addStudent failed:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return rno;
        }
    }

    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<StudentDTO> list = new ArrayList<>();
        StudentDTO sdto;
        if (conn == null) {
            conn = AttendanceConnection.getConnection();
        }
        try {
            ps = conn.prepareStatement("SELECT * FROM student_master");
            rs = ps.executeQuery();
            while (rs.next()) {
                sdto = new StudentDTO();
                sdto.setImage(rs.getBlob("image"));
                sdto.setName(rs.getString("name"));
                sdto.setStudent_id(rs.getInt("student_id"));
                sdto.setStudent_er(rs.getInt("student_er"));
                list.add(sdto);
            }
        } catch (SQLException e) {
            System.out.println("getAllStudents failed:" + e);
        } finally {
            if (list.isEmpty()) {
                list = null;
            }
            rs = null;
            ps = null;
            conn = null;
            return list;
        }
    }

    public boolean chekEr(int er) {
        boolean flag = false;
        if (conn == null) {
            conn = AttendanceConnection.getConnection();
        }
        try {
            ps = conn.prepareStatement("SELECT * FROM student_master where student_er=?");
            ps.setInt(1, er);
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("getAllStudents failed:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return flag;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StudentDAO().getAllStudents());
    }
}
