package UseCase;

import Model.Interval;
import Model.Lesson;
import Model.Student;
import Model.Teacher;

import java.util.Collections;
import java.util.List;

public class PlanLessonsUC {

    private static int failedMatchesCounter = 0;
    private static int rescheduledTrialsCounter = 0;
    private static int rescheduledPerformedCounter = 0;
    public static void buildPlan(List<Lesson> todoLessons) {
        for(Lesson lesson : todoLessons) {
            planLesson(lesson, Collections.emptyList());
        }
    }

    private static boolean planLesson(Lesson lesson, List<Interval> excludedIntervals) {
        Interval foundInterval = findMatchingInterval(lesson, excludedIntervals);
        if(foundInterval != null) {
            lesson.setLesson(foundInterval);
            return true;
        } else{
            //try to find another spot for already planned lessons
            //pick a lesson (either from teacher or student)
            //find a new spot for it
            boolean useFallback = true;
            if(useFallback) {
                rescheduledTrialsCounter++;
                for(Lesson plannedLesson : lesson.getTeacher().getLessons()) {
                    Interval interval = new Interval(plannedLesson.getDay(), plannedLesson.getHour());
                    if(lesson.getStudent().getFreeIntervals().contains(interval)) {
                        if(planLesson(plannedLesson, Collections.emptyList())) {
                            rescheduledPerformedCounter++;
                            lesson.setLesson(interval);
                            return true;
                        }
                    }
                }
            }

            failedMatchesCounter++;
            System.out.println("Model.Lesson " + lesson.getName() + " with teacher " + lesson.getTeacher().getName() + " and Model.Student " + lesson.getStudent().getName() + " cannot be placed");
            return false;
        }
    }
    private static Interval findMatchingInterval(Lesson lesson, List<Interval> excludedIntervals) {
        Interval foundInterval = null;
        Teacher teacher = lesson.getTeacher();
        Student student = lesson.getStudent();
        for(Interval teachersInterval : teacher.getFreeIntervals()) {
            for (Interval studentsInterval : student.getFreeIntervals()) {
                if(teachersInterval.equals(studentsInterval) && !excludedIntervals.contains(teachersInterval)) {
                    foundInterval = teachersInterval;
                    break;
                }
            }
            if(foundInterval != null) {
                break;
            }
        }
        return foundInterval;
    }

    public static void getFailedMatchesCounter() {
        System.out.println("failedMatchesCounter = " + failedMatchesCounter);;
    }

    public static void getRescheduledTrialsCounter() {
        System.out.println("rescheduledTrialsCounter = " + rescheduledTrialsCounter);;
    }

    public static void getRescheduledPerformedCounter() {
        System.out.println("rescheduledPerformedCounter = " + rescheduledPerformedCounter);;
    }

}
