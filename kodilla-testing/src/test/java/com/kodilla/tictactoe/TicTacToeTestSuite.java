package com.kodilla.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tic Tac Toe Logic Tests")
class TicTacToeTestSuite {

    @Nested
    @DisplayName("Tests for Classic 3x3 Board")
    class ClassicTests {
        @Test
        @DisplayName("Should detect horizontal win for X")
        void testHorizontalWin() {
            TicTacToeBoard board = new TicTacToeBoard(3, 3);
            board.makeMove(1, 0, 'X');
            board.makeMove(1, 1, 'X');
            board.makeMove(1, 2, 'X');
            assertTrue(board.checkWin('X'), "X should win on row 1");
        }

        @Test
        @DisplayName("Should detect vertical win for O")
        void testVerticalWin() {
            TicTacToeBoard board = new TicTacToeBoard(3, 3);
            board.makeMove(0, 2, 'O');
            board.makeMove(1, 2, 'O');
            board.makeMove(2, 2, 'O');
            assertTrue(board.checkWin('O'), "O should win on column 2");
        }

        @Test
        @DisplayName("Should detect diagonal win (Top-Left to Bottom-Right)")
        void testDiagonalWin() {
            TicTacToeBoard board = new TicTacToeBoard(3, 3);
            board.makeMove(0, 0, 'X');
            board.makeMove(1, 1, 'X');
            board.makeMove(2, 2, 'X');
            assertTrue(board.checkWin('X'), "X should win on main diagonal");
        }
    }

    @Nested
    @DisplayName("Tests for Advanced 10x10 Board (5-in-a-row)")
    class AdvancedTests {
        @Test
        @DisplayName("Should detect win with 5 symbols in a 10x10 grid")
        void testWinFiveInARow() {
            TicTacToeBoard board = new TicTacToeBoard(10, 5);
            // Move: (5,5), (5,6), (5,7), (5,8), (5,9)
            for (int i = 5; i < 10; i++) {
                board.makeMove(5, i, 'X');
            }
            assertTrue(board.checkWin('X'), "X should win with 5 in a row on 10x10 board");
        }

        @Test
        @DisplayName("Should NOT detect win with only 4 symbols when 5 are required")
        void testNoWinWithFour() {
            TicTacToeBoard board = new TicTacToeBoard(10, 5);
            for (int i = 0; i < 4; i++) {
                board.makeMove(0, i, 'X');
            }
            assertFalse(board.checkWin('X'), "4 symbols should not count as a win if condition is 5");
        }
    }

    @Nested
    @DisplayName("Tests for Illegal Moves and Draws")
    class RulesTests {
        @Test
        @DisplayName("Should not allow moving to an occupied cell")
        void testOccupiedCell() {
            TicTacToeBoard board = new TicTacToeBoard(3, 3);
            board.makeMove(0, 0, 'X');
            boolean result = board.makeMove(0, 0, 'O'); // Trying to overwrite X
            assertFalse(result, "Should return false when moving to an occupied cell");
            assertEquals('X', board.getCell(0, 0), "Cell should still contain X");
        }

        @Test
        @DisplayName("Should detect a full board (Draw)")
        void testIsFull() {
            TicTacToeBoard board = new TicTacToeBoard(2, 2); // Small board for quick test
            board.makeMove(0, 0, 'X');
            board.makeMove(0, 1, 'O');
            board.makeMove(1, 0, 'X');
            board.makeMove(1, 1, 'O');
            assertTrue(board.isFull(), "Board should be reported as full");
        }
    }
}
