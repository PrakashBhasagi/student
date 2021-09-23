package com.prakash.student.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.repository.StudentRepository;

import org.assertj.core.api.Assertions;
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

        Student s = new Student(1, 10, "testname", 7);
        Mockito.when(studentRepositoryTest.save(s)).thenReturn(s);

        Student actual = studentServiceTest.saveStudent(s);
        Assertions.assertThat(actual).isEqualTo(s);

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
        Mockito.when(studentRepositoryTest.save(s)).thenReturn(s);

        Student actual = studentServiceTest.editStudent(s);
        Assertions.assertThat(actual).isEqualTo(s);
    }

    @Test
    void testGetAllStudents() {
        Student s1 = new Student(1, 7, "testname", 5);
        Student s2 = new Student(2, 8, "testname", 6);
        Student s3 = new Student(3, 8, "testname", 7);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);

        Mockito.when(studentRepositoryTest.findAll()).thenReturn(allStudents);

        List<Student> actual = studentServiceTest.getAllStudents();
        Assertions.assertThat(actual).isEqualTo(allStudents);
    }

    @Test
    void testGetStudentByClass() {
        Student s1 = new Student(1, 7, "testname", 6);
        Student s2 = new Student(2, 8, "testname", 6);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);

        Mockito.when(studentRepositoryTest.findAllByStudentClass(6)).thenReturn(allStudents);

        List<Student> actual = studentServiceTest.getStudentByClass(6);
        Assertions.assertThat(actual).isEqualTo(allStudents);
    }

    @Test
    void testGetStudentByClassAndRollNo() {
        Student s1 = new Student(1, 8, "testname", 6);
        Mockito.when(studentRepositoryTest.findByStudentClassAndStudentRollNo(6, 8)).thenReturn(s1);
        Student actual = studentServiceTest.getStudentByClassAndRollNo(6, 8);
        Assertions.assertThat(actual).isEqualTo(s1);
    }

    @Test
    void testGetStudentsByRollNo() {

        Student s1 = new Student(1, 7, "testname", 8);
        Student s2 = new Student(2, 7, "testname", 9);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);

        Mockito.when(studentRepositoryTest.findAllByStudentRollNo(6)).thenReturn(allStudents);

        List<Student> actual = studentServiceTest.getStudentsByRollNo(6);
        Assertions.assertThat(actual).isEqualTo(allStudents);
    }

}
