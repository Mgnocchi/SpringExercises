package org.lifecycleannotations.exercises.sport;

import org.lifecycleannotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    private final AdviceService advice;

    // Could be implicit
    @Autowired
    public FootballCoach(@Qualifier("basicAdvice") AdviceService advice) {
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
