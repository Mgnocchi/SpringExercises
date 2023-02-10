package org.di.exercises.sport;

import org.di.exercises.fortune.FortuneService;

public class BaseballCoach implements Coach {
    private final FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkout() {
        return "idk, swing you bat or smth";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
