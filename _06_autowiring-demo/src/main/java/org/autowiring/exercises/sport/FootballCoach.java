package org.autowiring.exercises.sport;

import org.autowiring.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("teacherOfFeets")
public class FootballCoach implements Coach {
    private AdviceService advice;

    @Override
    public String getTraining() {
        return "Kick some balls! ... Not those!";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }

    @Autowired
    public void theSetterDoesntNeedAConventionalName(AdviceService advice) {
        this.advice = advice;
    }

}
