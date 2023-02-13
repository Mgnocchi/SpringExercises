package org.qualifier.exercises.sport;

import org.qualifier.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Setter / method injection
@Component("teacherOfFeet")
public class FootballCoach implements Coach {
    private AdviceService advice;
    private String email;

    @Override
    public String getTraining() {
        return "Kick some balls! ... Not those!";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Autowired
    @Qualifier("basicAdvice") //this is the bean name, which is default here
    public void theSetterDoesntNeedAConventionalName(AdviceService advice) {
        this.advice = advice;
    }

    @Value("${coach.franco.email}")
    public void setEmail(String email) {
        this.email = email;
    }
}
