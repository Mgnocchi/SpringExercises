package org.lifecycleannotations.exercises.sport;

import org.lifecycleannotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
    private final AdviceService advice;
    // Could be implicit
    @Autowired
    public LifeCoach(@Qualifier("fortune") AdviceService advice) {
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
