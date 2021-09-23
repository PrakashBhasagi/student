package com.prakash.student.service;

import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    public Student getStudentByClassAndRollNo(Integer studentClass, Integer studentRoll) {

        return studentRepository.findByStudentClassAndStudentRollNo(studentClass, studentRoll);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer studentClass, Integer studentRoll) throws ResourceNotFoundException {
        Student s = studentRepository.findByStudentClassAndStudentRollNo(studentClass, studentRoll);
        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        }
        studentRepository.deleteById(s.getId());
    }

    public Student editStudent(Student student) throws ResourceNotFoundException {
        Student s = studentRepository.findByStudentClassAndStudentRollNo(student.getStudentClass(),
                student.getStudentRollNo());
        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        }
        s.setStudentName(student.getStudentName());
        s.setStudentClass(student.getStudentClass());
        s.setStudentRollNo(student.getStudentRollNo());

        return studentRepository.save(s);

    }

    public List<Student> getStudentsByRollNo(Integer studentRollNo) {

        return studentRepository.findAllByStudentRollNo(studentRollNo);
    }

    public List<Student> getStudentByClass(Integer studentClass) {
        return studentRepository.findAllByStudentClass(studentClass);
    }
}
