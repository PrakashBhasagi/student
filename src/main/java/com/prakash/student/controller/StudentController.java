package com.prakash.student.controller;

import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student Controller
 * Open EndPoint: http://localhost:8080/api/student
 */
@Api(tags = "Student Controller", value = "StudentController")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    /**
     * @EndPoint: http://localhost:8080/api/student/all
     * @return "All Student details"
     */
    @ApiOperation(value = "Find all students details")
    @GetMapping("/all")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    /**
     * EndPoint: http://localhost:8080/api/student/{class}/{roll}
     * @param studentClass
     * @param studentRoll
     * @return "Student details by class and roll number"
     */
    @ApiOperation(value = "Find students details by Class and Roll Number")
    @GetMapping("/{class}/{roll}")
    public Student getStudentByClassAndRollNo(@PathVariable(value = "class") Integer studentClass,
                                              @PathVariable(value = "roll") Integer studentRoll){
        return studentService.getStudentByClassAndRollNo(studentClass, studentRoll);
    }

    /**
     * @EndPoint: http://localhost:8080/api/student/{class}
     * @param studentClass
     * @return "all Student details by class"
     */
    @ApiOperation(value = "Find all students details by Class")
    @GetMapping("/{class}")
    public List<Student> getStudentByClass(@PathVariable(value = "class") Integer studentClass){
        return studentService.getStudentByClass(studentClass);
    }

    /**
     * @EndPoint: http://localhost:8080/api/student/add
     * @param student
     * @return "saves student details"
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "save student details")
    @PostMapping("/add")
    public Student savestudent(@RequestBody Student student) throws ResourceNotFoundException {

        List<Student> s = studentService.getStudentsByRollNo(student.getStudentRollNo());
        if(!s.isEmpty()) {
            for(Student x: s){
                if(student.getStudentClass() == x.getStudentClass()){
                    throw new ResourceNotFoundException("Student Already exists in database");
                }
            }
        }
        return studentService.saveStudent(student);
    }

    /**
     * @EndPoint: http://localhost:8080/api/student/edit
     * @param student
     * @return "updated details of student"
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Edit student details")
    @PutMapping("/edit")
    public Student updateStudent(@RequestBody Student student) throws ResourceNotFoundException {

        return studentService.editStudent(student);
    }

    /**
     * @EndPoint: http://localhost:8080/api/student/delete/{class}/{roll}
     * @param studentClass
     * @param studentRoll
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Delete student details")
    @DeleteMapping("/delete/{class}/{roll}")
    public void deleteStudentById(@PathVariable(value = "class") Integer studentClass,
                                  @PathVariable(value = "roll") Integer studentRoll) throws ResourceNotFoundException {

        studentService.deleteStudent(studentClass, studentRoll);
    }
}
