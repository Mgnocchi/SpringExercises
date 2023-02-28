package org.aop.exercises;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicLoggingAspect {
    Doer doer;
    @Autowired //superfluous as it's the only constructor
    public BasicLoggingAspect(Doer doer) {
        this.doer = doer;
    }

    @Before("execution(public String doThing())")                                        //pointcut expression: were the aspect is inserted
    public void beforeDoThing() {
        int did = doer.getDidTheThing(); //this is to show the workflow, to tangle the object in the cross-cutting concerns like this might not be ideal
        System.out.println("we are before the doThing call. Did the thing " + did + " times");
    }

//    @Before(value = "execution(public String doThing(bool))",
//            argNames = "bool")                                        //pointcut expression: were the aspect is inserted
//    public void beforeDoThing(Boolean bool) {
//        int did = doer.getDidTheThing(); //this is to show the workflow, to tangle the object in the cross-cutting concerns like this might not be ideal
//        System.out.println("we are before the doThing call. Did the thing " + did + " times");
//        System.out.println("we can retrieve the parameter, which is " + bool);
//    }

//    @AfterReturning(
//            value = "execution(public String doThing(bool))",
//            returning = "output",
//            argNames = "bool,output") //pointcut expression: were the aspect is inserted
//    public void afterDoThing (Boolean bool, String output) {
//        int did = doer.getDidTheThing(); //this is to show the workflow, to tangle the object in the cross-cutting concerns like this might not be ideal
//        System.out.println("we are after the doThing call. Did the thing " + did + " times");
//        System.out.println("we can retrieve the parameter, which is " + bool);
//        System.out.println("and the output which is " + output);
//    }
}
