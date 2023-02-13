package org.annotations.exercises.sport;

import org.annotations.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("teacherOfFeets")
public class FootballCoach implements Coach {
    private final AdviceService advice;

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
