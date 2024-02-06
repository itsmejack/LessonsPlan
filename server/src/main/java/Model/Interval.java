package Model;

import java.util.Objects;

public class Interval {
    private Day day = Day.NONE;
    private NumberOfLesson hour = NumberOfLesson.NONE;

    protected String name = "XXX";

    public Interval(Day day, NumberOfLesson hour) {
        this.day = day;
        this.hour = hour;
        this.name = "---";
    }
    public Interval() {
        //
    }

    public void printInformation() {
        System.out.println("Model.Interval day " + day + " hour " + hour);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return day == interval.day && hour == interval.hour && occupied == interval.occupied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, hour, occupied);
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }

    public void setHour(NumberOfLesson hour) {
        this.hour = hour;
    }

    public NumberOfLesson getHour() {
        return hour;
    }

    public String getName() {
        return name;
    }
    protected boolean occupied = false;

    public boolean isOccupied() {
        return occupied;
    }
}
