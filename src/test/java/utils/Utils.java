package utils;

import java.util.Random;

public class Utils {

    public static Long randomNumbers() {
        Random random = new Random();
        long value = Long.MAX_VALUE;
        long randomNumber = random.nextLong(value);
        return randomNumber;
    }
}
