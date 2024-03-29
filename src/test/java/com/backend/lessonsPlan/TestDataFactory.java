package com.backend.lessonsPlan;

import com.backend.lessonsPlan.Entities.IntervalEntity;
import com.backend.lessonsPlan.Entities.LessonEntity;
import com.backend.lessonsPlan.Entities.StudentEntity;
import com.backend.lessonsPlan.Entities.TeacherEntity;
import com.backend.lessonsPlan.Model.Day;
import com.backend.lessonsPlan.Model.NumberOfLesson;

public class TestDataFactory {
    public static IntervalEntity createInterval() {
        return IntervalEntity.builder().id(1L).intervalDay(Day.MON).numberOfLesson(NumberOfLesson.LESSON_1).build();
    }

    public static LessonEntity createLesson() {
        return LessonEntity.builder().lessonId(1L).lessonDay(Day.MON).numberOfLesson(NumberOfLesson.LESSON_1).build();
    }

    public static StudentEntity createStudent() {
        return StudentEntity.builder().name("name").build();
    }

    public static TeacherEntity createTeacher() {
        return TeacherEntity.builder().name("name").build();
    }
}
