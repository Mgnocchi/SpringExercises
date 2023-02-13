package org.qualifier.exercises.advice;

import org.springframework.stereotype.Service;

@Service
public class BasicAdvice implements AdviceService {
    @Override
    public String getAdvice() {
        return "Wash your teeth";
    }
}
