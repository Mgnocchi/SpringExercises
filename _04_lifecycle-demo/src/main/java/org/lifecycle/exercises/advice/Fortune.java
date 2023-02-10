package org.lifecycle.exercises.advice;

import org.lifecycle.exercises.commons.DataSource;

public class Fortune implements AdviceService {
    private final DataSource<String> fortunes;

    public Fortune(DataSource<String> fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public String getAdvice() {
        return fortunes.getData();
    }


}
