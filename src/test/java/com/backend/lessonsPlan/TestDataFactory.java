package com.backend.lessonsPlan;

import com.backend.lessonsPlan.Entities.IntervalEntity;
import com.backend.lessonsPlan.Model.Day;
import com.backend.lessonsPlan.Model.NumberOfLesson;

public class TestDataFactory {
    public static IntervalEntity createInterval() {
        return IntervalEntity.builder().id(1L).intervalDay(Day.MON).numberOfLesson(NumberOfLesson.LESSON_1).build();
    }
}
