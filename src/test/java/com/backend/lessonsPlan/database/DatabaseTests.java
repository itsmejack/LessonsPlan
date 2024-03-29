package com.backend.lessonsPlan.database;

import com.backend.lessonsPlan.Entities.IntervalEntity;
import com.backend.lessonsPlan.Entities.LessonEntity;
import com.backend.lessonsPlan.Entities.StudentEntity;
import com.backend.lessonsPlan.Entities.TeacherEntity;
import com.backend.lessonsPlan.Repositories.IntervalRepository;
import com.backend.lessonsPlan.Repositories.LessonRepository;
import com.backend.lessonsPlan.Repositories.StudentRepository;
import com.backend.lessonsPlan.Repositories.TeacherRepository;
import com.backend.lessonsPlan.TestDataFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DatabaseTests {

    private final IntervalRepository intervalRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public DatabaseTests(IntervalRepository intervalRepository, LessonRepository lessonRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.intervalRepository = intervalRepository;
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    @Test
    public void assertInterval() {
        IntervalEntity intervalEntity = TestDataFactory.createInterval();
        assertInternal(intervalEntity, intervalEntity.getId(), intervalRepository);
    }

    @Test
    public void assertLesson() {
        LessonEntity lessonEntity = TestDataFactory.createLesson();
        assertInternal(lessonEntity, lessonEntity.getLessonId(), lessonRepository);
    }

    @Test
    public void assertStudent() {
        StudentEntity studentEntity = TestDataFactory.createStudent();
        assertInternal(studentEntity, studentEntity.getName(), studentRepository);
    }

    @Test
    public void assertTeacher() {
        TeacherEntity teacherEntity = TestDataFactory.createTeacher();
        assertInternal(teacherEntity, teacherEntity.getName(), teacherRepository);
    }

    @Test
    public void assertStudentIntervalRelation() {
        StudentEntity student = TestDataFactory.createStudent();
        IntervalEntity interval = TestDataFactory.createInterval();

        studentRepository.save(student);
        intervalRepository.save(interval);

        student.setFreeIntervals(Collections.singleton(interval));
        interval.setStudent(student);

        studentRepository.save(student);
        intervalRepository.save(interval);

         StudentEntity resultStudent = studentRepository.findById(student.getName()).orElse(null);
         IntervalEntity resultInterval = intervalRepository.findById(interval.getId()).orElse(null);

        assertEquals(student, resultStudent);
        assertEquals(interval, resultInterval);
    }
    private void assertInternal(Object objectEntity, Object id, CrudRepository repository) {
        repository.save(objectEntity);
        Optional<?> result = repository.findById(id);
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(objectEntity);
    }
}
