package com.backend.lessonsPlan.Model;

import java.util.Arrays;
import java.util.List;

public enum NumberOfLesson {
    LESSON_1, LESSON_2, LESSON_3, LESSON_4, LESSON_5, LESSON_6, NONE;

    public static List<NumberOfLesson> getLessonNumbers() {
        return Arrays.asList(LESSON_1, LESSON_2, LESSON_3, LESSON_4, LESSON_5, LESSON_6);
    }
}
