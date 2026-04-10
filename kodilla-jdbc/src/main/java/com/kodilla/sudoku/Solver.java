package com.kodilla.sudoku;

public class Solver {

    public boolean solve(Board board) {
        for (int r = 0; r < Board.SIZE; r++) {
            for (int c = 0; c < Board.SIZE; c++) {
                if (board.get(r, c).isEmpty()) {
                    for (int v = 1; v <= 9; v++) {
                        if (isValid(board, r, c, v)) {
                            board.set(r, c, v);
                            if (solve(board)) return true;
                            board.set(r, c, Cell.EMPTY);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(Board board, int row, int col, int val) {
        for (int i = 0; i < Board.SIZE; i++) {
            if (board.get(row, i).getValue() == val) return false;
            if (board.get(i, col).getValue() == val) return false;
        }

        int br = (row / 3) * 3;
        int bc = (col / 3) * 3;

        for (int r = br; r < br + 3; r++)
            for (int c = bc; c < bc + 3; c++)
                if (board.get(r, c).getValue() == val) return false;

        return true;
    }
}
