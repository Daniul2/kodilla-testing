package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        SecondChallenge challenge = new SecondChallenge();

        assertAll(
                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(2.0, 1.0)),

                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(0.9, 1.0)),

                () -> assertThrows(Exception.class, () -> challenge.probablyIWillThrowException(1.5, 1.5)),

                () -> assertDoesNotThrow(() -> challenge.probablyIWillThrowException(1.5, 1.0)),

                () -> assertEquals("Done!", challenge.probablyIWillThrowException(1.0, 1.0))
        );
    }
}
