package org.lifecycleannotations.exercises.advice;

import org.springframework.stereotype.Component;

@Component("basicAdvice")
public class DefaultAdvice  implements AdviceService {
    @Override
    public String getAdvice() {
        return "Drink water";
    }
}
