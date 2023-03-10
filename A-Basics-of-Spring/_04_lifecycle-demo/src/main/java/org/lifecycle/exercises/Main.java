package org.lifecycle.exercises;

import org.lifecycle.exercises.sport.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Spring lets users customize some steps of a bean lifecycle. This helps (for example) with implementing preparation
 * and cleanup business logic whenever resources are accessed by an object or other similar things.
 * after the container is started, for each bean (in the order defined by the dependencies) what happens is:
 *
 * bean is instantiated -> dependencies are injected -> some processing by the framework -> custom init code
 *      then the bean is used for stuff
 * -> custom destroy method -> container is stopped
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach lifeCoach = context.getBean("lifeCoach", Coach.class);
        System.out.println("\t> " + lifeCoach.getAdvice());

        // the cleanup doesn't run if we don't close the context!
        // similarly it's not called for prototype scoped beans, but there is a workaround.
        context.close();

        /*
        For prototype scoped beans, if they implement the DisposableBean interface, and thus, a destroy() method, it is
        possible to create a custom bean processor that tracks those disposable beans and closes them.

        An example from the course has been added as a zip file to the resources of this module
         */
    }
}