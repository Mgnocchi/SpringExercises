package org.scopes.exercises.sport;

import org.scopes.exercises.advice.AdviceService;

public class lifeCoach implements Coach {
    private final AdviceService advice;

    public lifeCoach(AdviceService advice) {
        this.advice = advice;
    }
    @Override
    public String getTraining() {
        return "Meditate about meditation for half an hour";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }
}
