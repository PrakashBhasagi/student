package com.prakash.student.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.prakash.student.entity.Marks;
import com.prakash.student.entity.Student;
import com.prakash.student.repository.MarksRepository;

import org.assertj.core.api.Assertions;
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

        Mockito.when(marksRepositoryTest.findByStudent(s)).thenReturn(m);

        Marks actual = marksServiceTest.getMarks(s);
        Assertions.assertThat(actual).isEqualTo(m);
    }

    @Test
    void testGetTopMarks1() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 95.0, 20.0, 30.0, 40.0, 50.0, 60.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks1()).thenReturn(98.0);
        Mockito.when(marksRepositoryTest.findAllByMarks1(98.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks1();
        Assertions.assertThat(actual).isEqualTo(all);

    }

    @Test
    void testGetTopMarks2() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 85.0, 30.0, 40.0, 50.0, 60.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks2()).thenReturn(85.0);
        Mockito.when(marksRepositoryTest.findAllByMarks2(85.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks2();
        Assertions.assertThat(actual).isEqualTo(all);

    }

    @Test
    void testGetTopMarks3() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 77.0, 40.0, 50.0, 60.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks3()).thenReturn(77.0);
        Mockito.when(marksRepositoryTest.findAllByMarks3(77.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks3();
        Assertions.assertThat(actual).isEqualTo(all);

    }

    @Test
    void testGetTopMarks4() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 89.0, 50.0, 60.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks4()).thenReturn(89.0);
        Mockito.when(marksRepositoryTest.findAllByMarks4(89.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks4();
        Assertions.assertThat(actual).isEqualTo(all);

    }

    @Test
    void testGetTopMarks5() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 100.0, 60.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks5()).thenReturn(100.0);
        Mockito.when(marksRepositoryTest.findAllByMarks5(100.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks5();
        Assertions.assertThat(actual).isEqualTo(all);
    }

    @Test
    void testGetTopMarks6() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 69.0);

        List<Marks> all = new ArrayList<>();
        all.add(m);

        Mockito.when(marksRepositoryTest.findMaxMarks6()).thenReturn(69.0);
        Mockito.when(marksRepositoryTest.findAllByMarks6(69.0)).thenReturn(all);
        List<Marks> actual = marksServiceTest.getTopMarks6();
        Assertions.assertThat(actual).isEqualTo(all);

    }

    @Test
    void testSave() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0);

        Mockito.when(marksRepositoryTest.save(m)).thenReturn(m);

        Marks actual = marksServiceTest.save(m);
        Assertions.assertThat(actual).isEqualTo(m);

    }

    @Test
    void testUpdateMarks() {
        Student s = new Student(1, 8, "testname", 7);
        Marks m = new Marks(2, s, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0);

        Mockito.when(marksRepositoryTest.save(m)).thenReturn(m);

        Marks actual = marksServiceTest.updateMarks(m);
        Assertions.assertThat(actual).isEqualTo(m);
    }
}
