package utils;

import java.util.Random;

class RandomUtils {
    private Random random = new Random();

    public Long getRandomLong() {
        return random.nextLong();
    }
}
