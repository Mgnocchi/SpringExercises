package org.scopesannotations.exercises.sport;

import org.scopesannotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class lifeCoach implements Coach {
    private final AdviceService advice;

    public lifeCoach(@Qualifier("fortune") AdviceService advice) {
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
