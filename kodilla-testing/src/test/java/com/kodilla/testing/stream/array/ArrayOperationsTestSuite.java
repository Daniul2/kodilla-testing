package com.kodilla.testing.stream.array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Array Operations Test Suite")
public class ArrayOperationsTestSuite {
    @Test
    @DisplayName("Test getAverage() with an array of 20 elements")
    void testGetAverage(){
        // Given: An array with 20 sample values
        int[] numbers = {
                10, 20, 10, 20, 10, 20, 10, 20, 10, 20,
                30, 40, 30, 40, 30, 40, 30, 40, 30, 40
        };
// Manual calculation for verification:
        // Sum: (10*5 + 20*5) + (30*5 + 40*5)
        // Sum: (50 + 100) + (150 + 200) = 150 + 350 = 500
        // Average: 500 / 20 = 25.0
        double expectedAverage = 25.0;

        // When: Executing the static method from the interface
        double resultAverage = ArrayOperations.getAverage(numbers);

        // Then: Verifying the correctness of the calculation
        assertEquals(expectedAverage, resultAverage, 0.001);
    }
}
