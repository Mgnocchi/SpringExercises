package org.autowiring.exercises.sport;

import org.autowiring.exercises.advice.AdviceService;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
    private final AdviceService advice;

    // when only a single constructor is present the Autowiring happens automatically. Of course the bean must be recognized by Spring (here the Component annotation)
    public LifeCoach(AdviceService advice) {
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
