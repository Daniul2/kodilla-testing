package com.kodilla.exception.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("SecondChallenge Test Suite")
class SecondChallengeTestSuite {

    private SecondChallenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new SecondChallenge();
    }

    @Test
    @DisplayName("Test: Should NOT throw exception for valid input (x=1.5, y=1.0)")
    void testSuccess() {
        assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.5, 1.0));
    }

    @Test
    @DisplayName("Boundary Test: Exactly at x=1.0 (Should NOT throw)")
    void testBoundaryXLower() {
        assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.0, 1.0));
    }

    @Test
    @DisplayName("Boundary Test: Exactly at x=2.0 (Should throw)")
    void testBoundaryXUpper() {
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2.0, 1.0));
    }

    @Test
    @DisplayName("Test: x below 1.0 (Should throw)")
    void testXBelowOne() {
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0.99, 1.0));
    }

    @Test
    @DisplayName("Test: x above 2.0 (Should throw)")
    void testXAboveTwo() {
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2.1, 1.0));
    }

    @Test
    @DisplayName("Test: y exactly 1.5 (Should throw)")
    void testYEqualsOneAndHalf() {
        assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1.5, 1.5));
    }
}
