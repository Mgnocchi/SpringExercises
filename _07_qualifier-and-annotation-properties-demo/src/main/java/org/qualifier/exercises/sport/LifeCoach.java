package org.qualifier.exercises.sport;

import org.qualifier.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// constructor injection
@Component
public class LifeCoach implements Coach {
    private final AdviceService advice;
    private final String email;

    // when only a single constructor is present the Autowiring happens automatically. Of course the bean must be recognized by Spring (here the Component annotation)
    // The Qualifier is the bean name, which is default here
    public LifeCoach(@Qualifier("fortune") AdviceService advice, @Value("${coach.roberto.email}") String email) {
        this.advice = advice;
        this.email = email;
    }
    @Override
    public String getTraining() {
        return "Meditate about meditation for half an hour";
    }

    @Override
    public String getAdvice() {
        return advice.getAdvice();
    }
    @Override
    public String getEmail() {
        return this.email;
    }
}
