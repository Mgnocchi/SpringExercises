package org.autowiring.exercises;

import org.autowiring.exercises.sport.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.autowiring.exercises");
        // if a bean name is not specified the default is the name of the class with the first letter made lowercase
        Coach lifeCoach = context.getBean("lifeCoach", Coach.class);
        System.out.println("Life:");
        System.out.println(lifeCoach.getAdvice());
        System.out.println(lifeCoach.getTraining());

        // autowired with setter with the same fortune service object
        Coach footballCoach = context.getBean("teacherOfFeet", Coach.class);
        System.out.println("Feet:");
        System.out.println(footballCoach.getAdvice());
        System.out.println(footballCoach.getTraining());

        // autowired with field injection WHICH IS NOT RECOMMENDED
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println("Tennis is boring:");
        System.out.println(tennisCoach.getAdvice());
        System.out.println(tennisCoach.getTraining());
    }
}