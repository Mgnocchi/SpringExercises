package org.aop.exercises;

import org.springframework.stereotype.Component;

@Component
public class ActualDoer implements Doer {

    private int didTheThing = 0;

    @Override
    public String doThing(boolean bool) {
        didTheThing++;
        System.out.println("---------------------------------- DOING THINGS ----------------------------------");
        return "did the thing";
    }
    @Override
    public int getDidTheThing() {
        return didTheThing;
    }
}
