package com.prakash.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
