package org.annotations.exercises.advice;

import org.springframework.stereotype.Service;

@Service("basicAdvice")
public class DefaultAdvice  implements AdviceService {
    @Override
    public String getAdvice() {
        return "Drink water";
    }
}
