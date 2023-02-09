package org.exercises;

public class Main {
    public static void main(String[] args) {
        // get object
        Coach coach = new TrackCoach();
        // use object
        System.out.printf("coach says: %s", coach.getWorkout());
    }
}