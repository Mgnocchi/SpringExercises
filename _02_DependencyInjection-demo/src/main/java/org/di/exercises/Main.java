package org.di.exercises;


import org.di.exercises.sport.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Create application context (it makes all the beans, some lazily, some immediately.
        // Singletons are the default and immediate)
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        // get object
        Coach coach = context.getBean("coach", Coach.class);
        // use object
        System.out.printf("Coach says: %s\n", coach.getWorkout());
        System.out.printf("Coach says: %s\n", coach.getFortune());
    }
}