package org.autowiring.exercises.sport;

import org.autowiring.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    // private field
    @Autowired
    private AdviceService advice;

    // empty constructor
    public TennisCoach() {
    }
    @Override
    public String getTraining() {
        return "Tennis some balls";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }

    // no setter
}
