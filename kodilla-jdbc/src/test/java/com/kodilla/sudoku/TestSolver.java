package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolver {

    @Test
    void testSimpleSudoku() {
        Board board = new Board();
        Solver solver = new Solver();

        int[][] puzzle = {
                {5,3,0, 0,7,0, 0,0,0},
                {6,0,0, 1,9,5, 0,0,0},
                {0,9,8, 0,0,0, 0,6,0},

                {8,0,0, 0,6,0, 0,0,3},
                {4,0,0, 8,0,3, 0,0,1},
                {7,0,0, 0,2,0, 0,0,6},

                {0,6,0, 0,0,0, 2,8,0},
                {0,0,0, 4,1,9, 0,0,5},
                {0,0,0, 0,8,0, 0,7,9}
        };

        // Load puzzle
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (puzzle[r][c] != 0)
                    board.set(r, c, puzzle[r][c]);

        boolean solved = solver.solve(board);

        assertTrue(solved, "Solver should solve this puzzle");
        assertTrue(board.isSolved(), "Board should be fully filled");
    }
}
