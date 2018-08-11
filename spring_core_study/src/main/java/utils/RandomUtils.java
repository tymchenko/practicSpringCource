package utils;

import java.util.Random;

class RandomUtils {
    private Random random = new Random();
//    private RandomUtils(){}

    public Long getRandomLong() {
        return random.nextLong();
    }
}
