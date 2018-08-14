package utils;

import java.util.Random;

public class RandomUtils {
    private Random random = new Random();

    public Long getRandomLong() {
        return random.nextLong();
    }
}
