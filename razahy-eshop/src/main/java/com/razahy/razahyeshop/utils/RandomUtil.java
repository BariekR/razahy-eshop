package com.razahy.razahyeshop.utils;

import java.math.BigDecimal;

public class RandomUtil {
    public static BigDecimal getRandomBigDecimal(int lowerBound, int upperBound) {
        double randomNumber = Math.random() * (upperBound - lowerBound) + lowerBound;
        return new BigDecimal(randomNumber);
    }
}
