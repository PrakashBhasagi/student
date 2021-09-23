package com.prakash.student.entity;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer studentRollNo;
    private String studentName;
    private Integer studentClass;

    public Student() {
    }

    public Student(Integer studentRollNo, String studentName, Integer studentClass) {
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public Student(Integer id, Integer studentRollNo, String studentName, Integer studentClass) {
        this.id = id;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Integer studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Integer studentClass) {
        this.studentClass = studentClass;
    }

}
