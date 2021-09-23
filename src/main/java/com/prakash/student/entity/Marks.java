package com.prakash.student.entity;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class Marks {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Double marks1;
    private Double marks2;
    private Double marks3;
    private Double marks4;
    private Double marks5;
    private Double marks6;

    public Marks() {
    }

    public Marks(Student student, Double marks1, Double marks2, Double marks3, Double marks4, Double marks5,
            Double marks6) {
        this.student = student;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
        this.marks6 = marks6;
    }

    public Marks(Integer id, Student student, Double marks1, Double marks2, Double marks3, Double marks4, Double marks5,
            Double marks6) {
        this.id = id;
        this.student = student;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
        this.marks6 = marks6;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getMarks1() {
        return marks1;
    }

    public void setMarks1(Double marks1) {
        this.marks1 = marks1;
    }

    public Double getMarks2() {
        return marks2;
    }

    public void setMarks2(Double marks2) {
        this.marks2 = marks2;
    }

    public Double getMarks3() {
        return marks3;
    }

    public void setMarks3(Double marks3) {
        this.marks3 = marks3;
    }

    public Double getMarks4() {
        return marks4;
    }

    public void setMarks4(Double marks4) {
        this.marks4 = marks4;
    }

    public Double getMarks5() {
        return marks5;
    }

    public void setMarks5(Double marks5) {
        this.marks5 = marks5;
    }

    public Double getMarks6() {
        return marks6;
    }

    public void setMarks6(Double marks6) {
        this.marks6 = marks6;
    }

}
