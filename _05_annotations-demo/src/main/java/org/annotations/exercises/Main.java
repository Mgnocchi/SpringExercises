package org.annotations.exercises;

import org.annotations.exercises.sport.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach footballCoach = context.getBean("teacherOfFeets" , Coach.class);
        System.out.println("Football:");
        System.out.println(footballCoach.getAdvice());
        System.out.println(footballCoach.getTraining());

        // if a bean name is not specified the default is the name of the class with the first letter made lowercase
        Coach lifeCoach = context.getBean("lifeCoach", Coach.class);
        System.out.println("Life:");
        System.out.println(lifeCoach.getAdvice());
        System.out.println(lifeCoach.getTraining());
    }
}