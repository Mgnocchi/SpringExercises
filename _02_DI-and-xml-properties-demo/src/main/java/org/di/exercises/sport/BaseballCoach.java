package org.di.exercises.sport;

import org.di.exercises.fortune.FortuneService;

public class BaseballCoach implements Coach {
    private final FortuneService fortuneService;
    private final String email;

    public BaseballCoach(FortuneService fortuneService, String email) {
        this.fortuneService = fortuneService;
        this.email = email;
    }

    @Override
    public String getWorkout() {
        return "idk, swing you bat or smth";
    }
    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
    @Override
    public String getEmail() {
        return email;
    }
}
