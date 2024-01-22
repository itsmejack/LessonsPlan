package Model;

import java.util.Set;

public class Student extends Person {
    @Override
    public void printInformation() {
        System.out.println("Model.Student:");
        super.printInformation();
    }
    public Student(Set<Interval> freeIntervals, String name) {
        super(freeIntervals, name);
    }
}
