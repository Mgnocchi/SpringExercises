package org.di.exercises.sport;

import org.di.exercises.fortune.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    private String email;

    @Override
    public String getWorkout() {
        return "RUUUUN!!!";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
    @Override
    public String getEmail() {
        return email;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
