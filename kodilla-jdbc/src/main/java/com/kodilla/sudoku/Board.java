package com.kodilla.sudoku;

public class Board {
    public static final int SIZE = 9;
    private final Cell[][] grid = new Cell[SIZE][SIZE];

    public Board() {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                grid[r][c] = new Cell();
    }

    public Cell get(int row, int col) { return grid[row][col]; }

    public void set(int row, int col, int value) { grid[row][col].setValue(value); }

    public Board deepCopy() {
        Board copy = new Board();
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                copy.grid[r][c] = this.grid[r][c].copy();
        return copy;
    }

    public boolean isSolved() {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                if (grid[r][c].isEmpty()) return false;
        return true;
    }

    public void print() {
        String hr = "+-------+-------+-------+";
        System.out.println(hr);
        for (int r = 0; r < SIZE; r++) {
            System.out.print("| ");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(grid[r][c].toString() + " ");
                if ((c + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((r + 1) % 3 == 0) System.out.println(hr);
        }
    }
}
