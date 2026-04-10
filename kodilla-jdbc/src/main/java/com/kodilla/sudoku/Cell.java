package com.kodilla.sudoku;

public class Cell {
    public static final int EMPTY = 0;
    private int value;

    public Cell() { this.value = EMPTY; }

    public Cell(int value) { this.value = value; }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public boolean isEmpty() { return value == EMPTY; }

    public Cell copy() { return new Cell(this.value); }

    @Override
    public String toString() { return isEmpty() ? "." : Integer.toString(value); }
}
