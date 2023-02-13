package org.qualifier.exercises.sport;

import org.qualifier.exercises.advice.AdviceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// constructor injection
@Component
public class LifeCoach implements Coach {
    private final AdviceService advice;

    // when only a single constructor is present the Autowiring happens automatically. Of course the bean must be recognized by Spring (here the Component annotation)
    // The Qualifier is the bean name, which is default here
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
