package com.attendance.student;

import java.io.Serializable;
import java.sql.Blob;

public class StudentDTO implements Serializable {

    private int student_id, student_er;
    private String name;
    private Blob image;

    public StudentDTO() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_er() {
        return student_er;
    }

    public void setStudent_er(int student_er) {
        this.student_er = student_er;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
