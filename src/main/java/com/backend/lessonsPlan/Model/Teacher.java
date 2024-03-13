package com.backend.lessonsPlan.Model;

import java.util.Set;

public class Teacher extends Person {

    @Override
    public void printInformation() {
        System.out.println("Teacher:");
        super.printInformation();
    }
    public Teacher(Set<Interval> freeIntervals, String name) {
        super(freeIntervals, name);
    }
}