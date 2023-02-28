package org.aop.exercises;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.aop.exercises")
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Doer doer = context.getBean("actualDoer", Doer.class);

        System.out.println("We are in the main. We did the thing: " + doer.getDidTheThing() + " time(s). Now we start doing the thing:\n");

        doer.doThing(true);

        System.out.println("\nAfter having done things we are back in the main. We did the thing: " + doer.getDidTheThing() + " time(s)");

    }
}
