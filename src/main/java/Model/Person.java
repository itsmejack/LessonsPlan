package Model;

import java.util.HashSet;
import java.util.Set;

public class Person {

    private Set<Interval> freeIntervals = new HashSet<>();
    private Set<Lesson> lessons = new HashSet<>();

    private String name;

    public String getName() {
        return name;
    }

    public void printInformation() {
        freeIntervals.forEach(Interval::printInformation);
        lessons.forEach(Lesson::printInformation);
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void printTimetable() {
        System.out.println(name);
        Interval[][] intervals = initWeek();
        freeIntervals.stream().forEach(interval -> intervals[interval.getDay().ordinal()][interval.getHour().ordinal()] = interval);
        lessons.stream().forEach(lesson -> intervals[lesson.getDay().ordinal()][lesson.getHour().ordinal()] = lesson);

        for(Day day : Day.getAllDays()) {
            System.out.print(day + "\t\t\t");
        }
        System.out.println();
        System.out.println("===================================================");
        for(NumberOfLesson hour : NumberOfLesson.getLessonNumbers()) {
            for(Day day : Day.getAllDays()) {
                System.out.print(intervals[day.ordinal()][hour.ordinal()].getName() + "\t\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private Interval[][] initWeek() {
        Interval[][] intervals = new Interval[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                intervals[i][j] = new Interval();
            }
        }
        return intervals;
    }
    public Person(Set<Interval> freeIntervals, String name) {
        this.freeIntervals = freeIntervals;
        this.name = name;
    }

    public Set<Interval> getFreeIntervals() {
        return freeIntervals;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
}