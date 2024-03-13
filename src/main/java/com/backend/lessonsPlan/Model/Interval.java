package com.backend.lessonsPlan.Model;

import lombok.*;

import java.util.Objects;
@Data
@NoArgsConstructor
public class Interval {
    private Day day = Day.NONE;
    private NumberOfLesson hour = NumberOfLesson.NONE;

    protected String name = "XXX";

    public Interval(Day day, NumberOfLesson hour) {
        this.day = day;
        this.hour = hour;
        this.name = "---";
    }

    public void printInformation() {
        System.out.println("Interval day " + day + " hour " + hour);
    }

    protected boolean occupied = false;

}
