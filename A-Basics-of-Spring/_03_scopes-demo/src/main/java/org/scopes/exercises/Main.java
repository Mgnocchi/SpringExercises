package org.scopes.exercises;

import org.scopes.exercises.sport.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach first = context.getBean("footballCoach", Coach.class);
        Coach same = context.getBean("footballCoach", Coach.class);
        System.out.println("We get twice the same singleton coach bean and check if it's the same one: ");
        System.out.println("\t> "  + (first == same) );

        Coach second = context.getBean("lifeCoach", Coach.class);
        Coach another = context.getBean("lifeCoach", Coach.class);
        System.out.println("We get twice the same prototype coach bean and check if it's the same one: ");
        System.out.println("\t> "  + (second == another) );

    }
}