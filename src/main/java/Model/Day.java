package Model;

import java.util.Arrays;
import java.util.List;

public enum Day {
    MON, TUE, WED, THU, FRI, NONE;

    public static List<Day> getAllDays() {
        return Arrays.asList(MON, TUE, WED, THU, FRI);
    }
}
