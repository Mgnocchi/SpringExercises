package org.annotations.exercises.advice;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
@Service("fortuneAdvice")
public class Fortune implements AdviceService {
    private static final Map<Integer,String> fortunes = Map.ofEntries(
            Map.entry(0,"BRING HIM THE PHOTO"),
            Map.entry(1,"YOU WILL DIE ALONE"),
            Map.entry(2,"YOU ARE THROWING YOUR LIFE AWAY"),
            Map.entry(3,"GO OUTSIDE!"),
            Map.entry(4,"ASK AGAIN LATER"),
            Map.entry(5,"THINK FOR YOURSELF"),
            Map.entry(6,"QUESTION AUTHORITY"),
            Map.entry(7,"YOU ARE WORSHIPING A SUN GOD"),
            Map.entry(8,"DON'T LEAVE THE HOUSE TODAY"),
            Map.entry(9,"GIVE UP!"),
            Map.entry(10,"MARRY AND REPRODUCE"),
            Map.entry(11,"STAY ASLEEP")
    );

    private static final Random random = new Random();
    @Override
    public String getAdvice() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }
}
