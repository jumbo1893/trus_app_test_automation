package com.jumbo.trus.util;

import java.time.LocalDate;
import java.util.Random;

public class RandomStringGenerator {
    public RandomStringGenerator() {
    }

    public LocalDate getRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.now().toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public String getRandomName() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return "Automation" + number;
    }

    public LocalDate getRandomDateForSeasonStart() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1992, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(1992, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public LocalDate getRandomDateForSeasonEnd() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1993, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(1993, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
