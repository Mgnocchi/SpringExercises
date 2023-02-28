package org.aop.exercises;

import org.springframework.stereotype.Component;

@Component
public class ActualDoer implements Doer {

    private int didTheThing = 0;

    @Override
    public String doThing() {
        didTheThing++;
        return "did the thing";
    }
    @Override
    public int getDidTheThing() {
        return didTheThing;
    }
}
