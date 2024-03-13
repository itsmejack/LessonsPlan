package com.backend.lessonsPlan.Model;

import lombok.*;

@Data
public class Lesson extends Interval {
    private Teacher teacher;
    private Student student;

    public Lesson(Teacher teacher, Student student, String name) {
        //?? do we need this info here?
        this.teacher = teacher;
        this.student = student;
        this.name = name;
        this.occupied = true;
    }

    public Lesson(Lesson lesson) {
        this(lesson.getTeacher(), lesson.getStudent(), lesson.getName());
    }

    @Override
    public void printInformation() {
        System.out.println("Lesson day " + getDay() + " hour " + getHour());
    }

    public void setLesson(Interval interval) {
        if(getDay() != Day.NONE || getHour() != NumberOfLesson.NONE) {
            //lesson is already planned, so the old interval needs to be added again for teacher and student
            Interval oldInterval = new Interval(getDay(), getHour());
            teacher.getFreeIntervals().add(oldInterval);
            student.getFreeIntervals().add(oldInterval);
        } else {
            //lesson was not yet planned so needs to be added for teacher and student
            teacher.addLesson(this);
            student.addLesson(this);
        }
        setDay(interval.getDay());
        setHour(interval.getHour());
        teacher.getFreeIntervals().remove(interval);
        student.getFreeIntervals().remove(interval);
    }
    public boolean isLessonSet() {
        return getDay() != Day.NONE && getHour() != NumberOfLesson.NONE;
    }
}
