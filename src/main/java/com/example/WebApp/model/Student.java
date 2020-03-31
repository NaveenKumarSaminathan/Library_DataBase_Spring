package com.example.WebApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int sid;
    private String sname;
    private String dept;
    private String gender;
    private int booksno;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBooksno() {
        return booksno;
    }

    public void setbooksno(int booksno) {
        this.booksno = booksno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", dept='" + dept + '\'' +
                ", gender='" + gender + '\'' +
                ", booksno=" + booksno +
                '}';
    }
}
