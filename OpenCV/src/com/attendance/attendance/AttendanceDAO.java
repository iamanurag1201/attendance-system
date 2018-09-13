package com.attendance.attendance;

import com.attendance.utility.AttendanceConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean addAttendance(AttendanceBean bean) {
        boolean flag = false;
        if (conn == null) {
            conn = AttendanceConnection.getConnection();
        }
        try {
            ps = conn.prepareStatement("insert into attendance_master values(?,?,?)");
            ps.setInt(1, bean.getStudent_id());
            ps.setString(2, bean.getStatus());
            ps.setString(3, bean.getDate());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("addAttendance failed:" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

}
