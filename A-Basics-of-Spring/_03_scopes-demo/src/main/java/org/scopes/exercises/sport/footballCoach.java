package org.scopes.exercises.sport;

import org.scopes.exercises.advice.AdviceService;

public class footballCoach implements Coach {
    private final AdviceService advice;

    public footballCoach(AdviceService advice) {
        this.advice = advice;
    }

    @Override
    public String getTraining() {
        return "Kick some balls! ... Not those!";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }
}
