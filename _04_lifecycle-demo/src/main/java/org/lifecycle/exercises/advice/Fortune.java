package org.lifecycle.exercises.advice;

import org.lifecycle.exercises.commons.FortuneSource;

public class Fortune implements AdviceService {
    private final FortuneSource fortunes;

    public Fortune(FortuneSource fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public String getAdvice() {
        return fortunes.getData();
    }


}
