package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SecondChallenge Test Suite")
class SecondChallengeTestSuite {

    private final SecondChallenge challenge = new SecondChallenge();

    @Test
    @DisplayName("Should NOT throw exception when arguments are valid (x=1.5, y=1.0)")
    void testProbablyIWillThrowExceptionSuccess() {
        // given & when & then
        assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.5, 1.0));
    }

    @Test
    @DisplayName("Boundary Test: Should NOT throw exception exactly at x=1.0")
    void testXBoundaryLow() {
        // given & when & then
        assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.0, 2.0));
    }

    @Test
    @DisplayName("Boundary Test: Should throw exception exactly at x=2.0")
    void testXBoundaryHigh() {
        // given & when & then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2.0, 1.0));
    }

    @Test
    @DisplayName("Should throw exception when x is below 1.0")
    void testXBelowOne() {
        // given & when & then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0.9, 1.0));
    }

    @Test
    @DisplayName("Should throw exception when x is greater than 2.0")
    void testXAboveTwo() {
        // given & when & then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2.1, 1.0));
    }

    @Test
    @DisplayName("Boundary Test: Should throw exception exactly when y=1.5")
    void testYEqualsOneAndHalf() {
        // given & when & then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1.5, 1.5));
    }

    @ParameterizedTest
    @CsvSource({
            "2.0, 1.0",
            "0.9, 1.0",
            "1.5, 1.5"
    })
    @DisplayName("Parameterized Test for multiple failure cases")
    void testAllExceptionConditions(double x, double y) {
        // given & when & then
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(x, y));
    }
}
