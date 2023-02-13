package org.annotations.exercises.sport;

import org.annotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
    private final AdviceService advice;

    public LifeCoach(@Qualifier("fortuneAdvice") AdviceService advice) {
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
