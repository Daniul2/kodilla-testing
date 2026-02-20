package com.kodilla.stream.array;

import java.util.stream.IntStream;

/**
 * Interface providing static method for array operations using IntStream.
 */
public interface ArrayOperations {


//  Prints array elements and calculates their average.
// Uses two separate IntStream.range flows as per requirements.

    static double getAverage(int[] numbers){
        //IntStream.range to display elements
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

//        Use IntStream.range to calculate average

        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(0.0);
    }
 }
