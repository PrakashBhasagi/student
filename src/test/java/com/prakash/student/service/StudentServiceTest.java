package com.prakash.student.service;

import static org.mockito.Mockito.verify;

import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.repository.StudentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepositoryTest;

    private StudentService studentServiceTest;

    @BeforeEach
    void setUp() {
        this.studentServiceTest = new StudentService(studentRepositoryTest);
        Student s = new Student(5, "testname", 7);
        studentServiceTest.saveStudent(s);
    }

    @Test
    void testSaveStudent() {

        Student s = new Student(10, "testname", 7);
        studentServiceTest.saveStudent(s);
        verify(studentRepositoryTest).save(s);
    }

    @Test
    void testDeleteStudent() throws ResourceNotFoundException {
        Student s = new Student(5, "testname", 7);
        studentRepositoryTest.save(s);

        studentServiceTest.deleteStudent(7, 5);
        verify(studentRepositoryTest).deleteById(1);

    }

    @Test
    void testEditStudent() {

    }

    @Test
    void testGetAllStudents() {
        // Student s = new Student(10, "testname", 7);
        // studentServiceTest.saveStudent(s);

        studentServiceTest.getAllStudents();
        verify(studentRepositoryTest).findAll();
    }

    @Test
    void testGetStudentByClass() {

    }

    @Test
    void testGetStudentByClassAndRollNo() {

    }

    @Test
    void testGetStudentsByRollNo() {

    }

}
