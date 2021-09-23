package com.prakash.student.service;

import static org.mockito.Mockito.verify;

import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepositoryTest;

    @InjectMocks
    private StudentService studentServiceTest;

    @Test
    void testSaveStudent() {

        Student s = new Student(10, "testname", 7);
        studentServiceTest.saveStudent(s);
        verify(studentRepositoryTest).save(s);
    }

    @Test
    void testDeleteStudent() throws ResourceNotFoundException {
        Student s = new Student(1, 8, "testname", 7);

        Mockito.when(studentRepositoryTest.findByStudentClassAndStudentRollNo(7, 8)).thenReturn(s);

        studentServiceTest.deleteStudent(7, 8);
        verify(studentRepositoryTest).deleteById(1);

    }

    @Test
    void testEditStudent() throws ResourceNotFoundException {
        Student s = new Student(1, 8, "testname", 7);

        Mockito.when(studentRepositoryTest.findByStudentClassAndStudentRollNo(7, 8)).thenReturn(s);

        studentServiceTest.editStudent(s);
        verify(studentRepositoryTest).save(s);
    }

    @Test
    void testGetAllStudents() {

        studentServiceTest.getAllStudents();
        verify(studentRepositoryTest).findAll();
    }

    @Test
    void testGetStudentByClass() {

        studentServiceTest.getStudentByClass(6);
        verify(studentRepositoryTest).findAllByStudentClass(6);
    }

    @Test
    void testGetStudentByClassAndRollNo() {
        studentServiceTest.getStudentByClassAndRollNo(6, 8);
        verify(studentRepositoryTest).findByStudentClassAndStudentRollNo(6, 8);
    }

    @Test
    void testGetStudentsByRollNo() {
        studentServiceTest.getStudentsByRollNo(6);
        verify(studentRepositoryTest).findAllByStudentRollNo(6);
    }

}
