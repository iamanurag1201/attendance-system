package com.attendance.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AttendanceConnection implements AttendanceData {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                //driver register 
                Class.forName(DRIVER);
                //connection open
                conn = DriverManager.getConnection(URL, UNAME, PWD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("connection failed:" + e);
        } finally {
            return conn;
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
