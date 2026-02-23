package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Array Operations Test Suite")
public class ArrayOperationsTestSuite {

    @Test
    @DisplayName("Test getAverage() with an array of 20 elements")
    void testGetAverage() {
        // Given
        int[] numbers = {
                10, 20, 10, 20, 10, 20, 10, 20, 10, 20,
                30, 40, 30, 40, 30, 40, 30, 40, 30, 40
        };
        double expectedAverage = 25.0;

        // When
        double resultAverage = ArrayOperations.getAverage(numbers);

        // Then
        assertEquals(expectedAverage, resultAverage, 0.001);
    }

    @Test
    @DisplayName("Test getAverage() with an empty array")
    void testGetAverageEmptyArray() {
        // Given
        int[] numbers = {};
        double expectedAverage = 0.0;

        // When
        double resultAverage = ArrayOperations.getAverage(numbers);

        // Then
        assertEquals(expectedAverage, resultAverage, 0.001);
    }
}
