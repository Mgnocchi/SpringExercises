package org.lifecycleannotations.exercises.advice;

import org.lifecycleannotations.exercises.commons.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Fortune implements AdviceService {
    private final DataSource<String> fortunes;

    // Could be implicit
    @Autowired
    public Fortune(DataSource<String> fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public String getAdvice() {
        return fortunes.getData();
    }


}
