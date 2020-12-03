package edu.upc.eetac.dsa.utils;

import net.moznion.random.string.RandomStringGenerator;

public class RandomUtils {
    public static String getRandID() {
        RandomStringGenerator gen = new RandomStringGenerator();
        String randS = gen.generateByRegex("\\w+\\d*[0-9]{0,8}");

        return randS;
    }
}
