package org.qualifier.exercises;

import org.qualifier.exercises.sport.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource(value = "classpath:sport.properties")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.qualifier.exercises");
        // if a bean name is not specified the default is the name of the class with the first letter made lowercase
        Coach lifeCoach = context.getBean("lifeCoach", Coach.class);
        System.out.println("Life:");
        System.out.println(lifeCoach.getAdvice());
        System.out.println(lifeCoach.getTraining());
        System.out.println(lifeCoach.getEmail());
        System.out.println();

        // autowired with setter with the same fortune service object
        Coach footballCoach = context.getBean("teacherOfFeet", Coach.class);
        System.out.println("Feet:");
        System.out.println(footballCoach.getAdvice());
        System.out.println(footballCoach.getTraining());
        System.out.println(footballCoach.getEmail());
        System.out.println();

        // autowired with field injection WHICH IS NOT RECOMMENDED
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println("Tennis is boring:");
        System.out.println(tennisCoach.getAdvice());
        System.out.println(tennisCoach.getTraining());
        System.out.println(tennisCoach.getEmail());

    }

}