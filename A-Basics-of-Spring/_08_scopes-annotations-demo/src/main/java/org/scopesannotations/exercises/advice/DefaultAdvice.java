package org.scopesannotations.exercises.advice;

import org.springframework.stereotype.Service;

@Service
public class DefaultAdvice  implements AdviceService {
    @Override
    public String getAdvice() {
        return "Drink water";
    }
}
