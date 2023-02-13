package org.scopesannotations.exercises.sport;

import org.scopesannotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class footballCoach implements Coach {
    private final AdviceService advice;

    public footballCoach(@Qualifier("defaultAdvice") AdviceService advice) {
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
