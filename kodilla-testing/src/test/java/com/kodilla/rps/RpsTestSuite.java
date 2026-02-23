package com.kodilla.rps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RPS Round Logic Test Suite")

public class RpsTestSuite {
    @Test
    @DisplayName("Testing all 9 move combinations (Draws, Wins, Losses)")
    void testDetermineWinner(){
        // 1: Rock, 2: Paper, 3: Scissors
        // Result: 0: Draw, 1: Player Wins, 2: Computer Wins
        assertEquals(0, RpsLogic.determineWinner(1, 1));
        assertEquals(0, RpsLogic.determineWinner(2, 2));
        assertEquals(0, RpsLogic.determineWinner(3, 3));

        // Player Wins
        assertEquals(1, RpsLogic.determineWinner(1, 3));
        assertEquals(1, RpsLogic.determineWinner(2, 1));
        assertEquals(1, RpsLogic.determineWinner(3, 2));

        // Computer Wins
        assertEquals(2, RpsLogic.determineWinner(3, 1));
        assertEquals(2, RpsLogic.determineWinner(1, 2));
        assertEquals(2, RpsLogic.determineWinner(2, 3));
    }

}
