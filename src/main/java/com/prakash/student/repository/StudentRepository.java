package com.prakash.student.repository;

import com.prakash.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByStudentRollNo(Integer studentRollNo);

    Student findByStudentClassAndStudentRollNo(Integer studentClass, Integer studentRoll);

    List<Student> findAllByStudentClass(Integer studentClass);

}
