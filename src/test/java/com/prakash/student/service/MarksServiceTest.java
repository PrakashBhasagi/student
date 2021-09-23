package com.prakash.student.service;

import static org.mockito.Mockito.verify;

import com.prakash.student.entity.Marks;
import com.prakash.student.entity.Student;
import com.prakash.student.repository.MarksRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MarksServiceTest {

    @Mock
    private MarksRepository marksRepositoryTest;

    @InjectMocks
    private MarksService marksServiceTest;

    @Test
    void testDeleteMarksById() {

        marksServiceTest.deleteMarksById(1);
        verify(marksRepositoryTest).deleteById(1);
    }

    @Test
    void testGetMarks() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0);
        marksServiceTest.getMarks(s);
        verify(marksRepositoryTest).findByStudent(s);
    }

    @Test
    void testGetTopMarks1() {
        Mockito.when(marksRepositoryTest.findMaxMarks1()).thenReturn(98.0);
        marksServiceTest.getTopMarks1();
        verify(marksRepositoryTest).findAllByMarks1(98.0);

    }

    @Test
    void testGetTopMarks2() {
        Mockito.when(marksRepositoryTest.findMaxMarks2()).thenReturn(98.0);
        marksServiceTest.getTopMarks2();
        verify(marksRepositoryTest).findAllByMarks2(98.0);

    }

    @Test
    void testGetTopMarks3() {
        Mockito.when(marksRepositoryTest.findMaxMarks3()).thenReturn(98.0);
        marksServiceTest.getTopMarks3();
        verify(marksRepositoryTest).findAllByMarks3(98.0);

    }

    @Test
    void testGetTopMarks4() {
        Mockito.when(marksRepositoryTest.findMaxMarks4()).thenReturn(98.0);
        marksServiceTest.getTopMarks4();
        verify(marksRepositoryTest).findAllByMarks4(98.0);

    }

    @Test
    void testGetTopMarks5() {
        Mockito.when(marksRepositoryTest.findMaxMarks5()).thenReturn(98.0);
        marksServiceTest.getTopMarks5();
        verify(marksRepositoryTest).findAllByMarks5(98.0);

    }

    @Test
    void testGetTopMarks6() {
        Mockito.when(marksRepositoryTest.findMaxMarks6()).thenReturn(98.0);
        marksServiceTest.getTopMarks6();
        verify(marksRepositoryTest).findAllByMarks6(98.0);

    }

    @Test
    void testSave() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0);
        marksServiceTest.save(m);
        verify(marksRepositoryTest).save(m);

    }

    @Test
    void testUpdateMarks() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0);
        marksServiceTest.updateMarks(m);
        verify(marksRepositoryTest).save(m);
    }
}
