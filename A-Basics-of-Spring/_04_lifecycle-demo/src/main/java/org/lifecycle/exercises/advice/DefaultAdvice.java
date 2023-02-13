package org.lifecycle.exercises.advice;

public class DefaultAdvice  implements AdviceService {
    @Override
    public String getAdvice() {
        return "Drink water";
    }
}
