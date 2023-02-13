package org.qualifier.exercises.sport;

import org.qualifier.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// field injection

@Component
public class TennisCoach implements Coach {
    // private field
    @Autowired
    @Qualifier("basicAdvice")//this is the bean name, which is default here
    private AdviceService advice;
    @Value("${coach.pippobbaudo.email}")
    private String email;

    // empty constructor
    public TennisCoach() {
    }
    @Override
    public String getTraining() {
        return "Tennis some balls";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    // no setter
}
