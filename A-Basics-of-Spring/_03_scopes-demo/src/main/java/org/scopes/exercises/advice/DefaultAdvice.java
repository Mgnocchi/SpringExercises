package org.scopes.exercises.advice;

public class DefaultAdvice  implements AdviceService {
    @Override
    public String getAdvice() {
        return "Drink water";
    }
}
