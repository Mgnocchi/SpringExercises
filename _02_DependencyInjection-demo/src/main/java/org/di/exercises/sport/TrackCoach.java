package org.di.exercises.sport;

import org.di.exercises.fortune.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    @Override
    public String getWorkout() {
        return "RUUUUN!!!";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
