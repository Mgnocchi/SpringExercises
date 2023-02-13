package org.qualifier.exercises.sport;

import org.qualifier.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Setter / method injection
@Component("teacherOfFeet")
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
    @Qualifier("basicAdvice") //this is the bean name, which is default here
    public void theSetterDoesntNeedAConventionalName(AdviceService advice) {
        this.advice = advice;
    }

}
