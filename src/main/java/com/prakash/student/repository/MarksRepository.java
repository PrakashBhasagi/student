package com.prakash.student.repository;

import com.prakash.student.entity.Marks;
import com.prakash.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

    @Query("Select max(m.marks1) from Marks m")
    Double findMaxMarks1();

    @Query("Select max(m.marks2) from Marks m")
    Double findMaxMarks2();

    @Query("Select max(m.marks3) from Marks m")
    Double findMaxMarks3();

    @Query("Select max(m.marks4) from Marks m")
    Double findMaxMarks4();

    @Query("Select max(m.marks5) from Marks m")
    Double findMaxMarks5();

    @Query("Select max(m.marks6) from Marks m")
    Double findMaxMarks6();

    List<Marks> findAllByMarks1(Double top);

    List<Marks> findAllByMarks2(Double top);

    List<Marks> findAllByMarks3(Double top);

    List<Marks> findAllByMarks4(Double top);

    List<Marks> findAllByMarks5(Double top);

    List<Marks> findAllByMarks6(Double top);

    Marks findByStudent(Student s);
}
