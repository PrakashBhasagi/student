package com.prakash.student.service;

import com.prakash.student.entity.Marks;
import com.prakash.student.entity.Student;
import com.prakash.student.repository.MarksRepository;
import com.prakash.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

    @Autowired
    MarksRepository marksRepository;
    
    @Autowired
    StudentRepository studentRepository;

    public Marks save(Marks m) {
        return marksRepository.save(m);
    }

    public Marks getMarks(Student s) {
        return marksRepository.findByStudent(s);
    }

    public void deleteMarksById(Integer id) {
        marksRepository.deleteById(id);
    }


    public void updateMarks(Marks m) {
        marksRepository.save(m);
    }

    public List<Marks> getTopMarks1() {
        Double top = marksRepository.findMaxMarks1();
        return marksRepository.findAllByMarks1(top);
    }

    public List<Marks> getTopMarks2() {
        Double top = marksRepository.findMaxMarks2();
        return marksRepository.findAllByMarks2(top);
    }
    public List<Marks> getTopMarks3() {
        Double top = marksRepository.findMaxMarks3();
        return marksRepository.findAllByMarks3(top);
    }
    public List<Marks> getTopMarks4() {
        Double top = marksRepository.findMaxMarks4();
        return marksRepository.findAllByMarks4(top);
    }
    public List<Marks> getTopMarks5() {
        Double top = marksRepository.findMaxMarks5();
        return marksRepository.findAllByMarks5(top);
    }
    public List<Marks> getTopMarks6() {
        Double top = marksRepository.findMaxMarks6();
        return marksRepository.findAllByMarks6(top);
    }

    public List<Student> getAggregate(Integer aggregate) {
        
        List<Marks> allMarksList = marksRepository.findAll();
        Double sum = 0.0;
        Double finalAggregate = 0.0;
        List<Student> topAggreegateStudents = new ArrayList<>();
        for(Marks m: allMarksList){
            sum = m.getMarks1()+m.getMarks2()+m.getMarks3()+m.getMarks4()+m.getMarks5()+m.getMarks6();
            finalAggregate = (sum/6);
            
            if(finalAggregate >= aggregate){
                Student s = studentRepository.findById(m.getStudent().getId()).get();
                topAggreegateStudents.add(s);
            }
        }
        return topAggreegateStudents;
    }
}
