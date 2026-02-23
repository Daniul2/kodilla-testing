package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        // Requirement: use IntStream.range to display elements
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        // Requirement: use IntStream.range and average() to return the result
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(0.0);
    }
}

