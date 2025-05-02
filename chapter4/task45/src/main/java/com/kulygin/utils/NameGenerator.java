package com.kulygin.utils;

import java.util.Random;

public class NameGenerator {
    private static final String[] NAMES = {
            "John", "Stan", "Mike", "Bob", "Alex", "Tom", "David", "Chris", "Steve", "Mark"
    };

    private static final Random random = new Random();

    public static String getRandomName() {
        int index = random.nextInt(NAMES.length);
        return NAMES[index];
    }
}
