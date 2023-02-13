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
        Coach constructorCoach = context.getBean("constructorCoach", Coach.class);
        // use object
        System.out.printf("Coach says: %s\n", constructorCoach.getWorkout());
        System.out.printf("Coach says: %s\n", constructorCoach.getFortune());
        System.out.println("with e-mail: " + constructorCoach.getEmail());
        // get object
        Coach setterCoach = context.getBean("setterCoach", Coach.class);
        // use object
        System.out.printf("Coach says: %s\n", setterCoach.getWorkout());
        System.out.printf("Coach says: %s\n", setterCoach.getFortune());
        System.out.println("with e-mail: " + setterCoach.getEmail());
    }
}