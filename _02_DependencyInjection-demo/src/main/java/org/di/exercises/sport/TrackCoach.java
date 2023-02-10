package org.di.exercises.sport;

import org.di.exercises.fortune.FortuneService;

public class TrackCoach implements Coach {
    private final FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkout() {
        return "RUUUUN!!!";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
