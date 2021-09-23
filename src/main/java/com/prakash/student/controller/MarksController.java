package com.prakash.student.controller;

import com.prakash.student.entity.Marks;
import com.prakash.student.entity.Student;
import com.prakash.student.exception.ResourceNotFoundException;
import com.prakash.student.service.MarksService;
import com.prakash.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Marks Controller Open EndPoint: http://localhost:8080/api/marks
 */
@Api(tags = "Marks Controller", value = "MarksController")
@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    MarksService marksService;

    @Autowired
    StudentService studentService;

    /**
     * @EndPoint: http://localhost:8080/api/marks/{class}/{roll}
     * @param studentClass
     * @param studentRoll
     * @param marks
     * @return "Details of students details saved"
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Save marks of students by Class and Roll Number")
    @PostMapping("/{class}/{roll}")
    public Marks savemarks(@PathVariable(value = "class") Integer studentClass,
            @PathVariable(value = "roll") Integer studentRoll, @RequestBody Marks marks)
            throws ResourceNotFoundException {

        Student s = studentService.getStudentByClassAndRollNo(studentClass, studentRoll);
        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        } else {
            marks.setStudent(s);
            return marksService.save(marks);
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/{class}/{roll}
     * @param studentClass
     * @param studentRoll
     * @return "Details of Students by class and roll number"
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Find students marks and details by Class and Roll Number")
    @GetMapping("/{class}/{roll}")
    public Marks getMarks(@PathVariable(value = "class") Integer studentClass,
            @PathVariable(value = "roll") Integer studentRoll) throws ResourceNotFoundException {

        Student s = studentService.getStudentByClassAndRollNo(studentClass, studentRoll);

        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        } else {
            return marksService.getMarks(s);
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/delete/{class}/{roll}/all
     * @param studentClass
     * @param studentRoll
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Delete marks of students by Class and Roll Number")
    @DeleteMapping("/delete/{class}/{roll}/all")
    public void deleteMarks(@PathVariable(value = "class") Integer studentClass,
            @PathVariable(value = "roll") Integer studentRoll) throws ResourceNotFoundException {

        Student s = studentService.getStudentByClassAndRollNo(studentClass, studentRoll);

        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        } else {
            marksService.deleteMarksById(s.getId());
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/edit/{class}/{roll}
     * @param studentClass
     * @param studentRoll
     * @param marks
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Edit all marks of students by Class and Roll Number")
    @PutMapping("/edit/{class}/{roll}")
    public void editMarks(@PathVariable(value = "class") Integer studentClass,
            @PathVariable(value = "roll") Integer studentRoll, @RequestBody Marks marks)
            throws ResourceNotFoundException {

        Student s = studentService.getStudentByClassAndRollNo(studentClass, studentRoll);

        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        } else {
            Marks m = marksService.getMarks(s);
            m.setMarks1(marks.getMarks1());
            m.setMarks2(marks.getMarks2());
            m.setMarks3(marks.getMarks3());
            m.setMarks4(marks.getMarks4());
            m.setMarks5(marks.getMarks5());
            m.setMarks6(marks.getMarks6());

            marksService.updateMarks(m);
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/delete/{class}/{roll}/{subject}
     * @param studentClass
     * @param studentRoll
     * @param subject
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Edit marks of students by Class and Roll Number by specifying subject number")
    @DeleteMapping("/delete/{class}/{roll}/{subject}")
    public void deleteMarks(@PathVariable(value = "class") Integer studentClass,
            @PathVariable(value = "roll") Integer studentRoll, @PathVariable(value = "subject") Integer subject)
            throws ResourceNotFoundException {

        Student s = studentService.getStudentByClassAndRollNo(studentClass, studentRoll);
        if (s == null) {
            throw new ResourceNotFoundException("Student not found");
        } else {
            Marks m = marksService.getMarks(s);

            switch (subject) {
                case 1:
                    m.setMarks1(null);
                    break;
                case 2:
                    m.setMarks2(null);
                    break;
                case 3:
                    m.setMarks3(null);
                    break;
                case 4:
                    m.setMarks4(null);
                    break;
                case 5:
                    m.setMarks5(null);
                    break;
                case 6:
                    m.setMarks6(null);
                    break;
                default:
                    System.out.println("subject does not exists");
                    throw new ResourceNotFoundException("subject does not exists");
            }
            marksService.updateMarks(m);
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/top-score/{subject}
     * @param sub
     * @return
     * @throws ResourceNotFoundException
     */
    @ApiOperation(value = "Top scorer of each subject")
    @GetMapping("/top-score/{subject}")
    public List<Marks> topScorer(@PathVariable("subject") Integer sub) throws ResourceNotFoundException {

        switch (sub) {
            case 1:
                return marksService.getTopMarks1();
            case 2:
                return marksService.getTopMarks2();
            case 3:
                return marksService.getTopMarks3();
            case 4:
                return marksService.getTopMarks4();
            case 5:
                return marksService.getTopMarks5();
            case 6:
                return marksService.getTopMarks6();
            default:
                System.out.println("subject does not exists");
                throw new ResourceNotFoundException("subject does not exists");
        }
    }

    /**
     * @EndPoint: http://localhost:8080/api/marks/aggregate/{ag}
     * @param aggregate
     * @return
     */
    @ApiOperation(value = "Find Aggregate details of students by Class and Roll Number")
    @GetMapping("/aggregate/{ag}")
    public List<Student> getAgrregate(@PathVariable(value = "ag") Integer aggregate) {
        return marksService.getAggregate(aggregate);
    }
}
