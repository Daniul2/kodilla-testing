package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {
    private final char[][]board;
    private final int size;
    private final int winCondition;

    public TicTacToeBoard(int size, int winCondition) {
        this.size = size;
        this.winCondition = winCondition;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) board[i][j] = ' ';
        }
    }
    public boolean makeMove(int row, int col, char symbol) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }
    public boolean checkWin(char symbol) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (checkDirection(r, c, 0, 1, symbol) ||  // Horizontal
                        checkDirection(r, c, 1, 0, symbol) ||  // Vertical
                        checkDirection(r, c, 1, 1, symbol) ||  // Diagonal \
                        checkDirection(r, c, 1, -1, symbol)) { // Diagonal /
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDirection(int row, int col, int dRow, int dCol, char sym) {
        int count = 0;
        for (int i = 0; i < winCondition; i++) {
            int r = row + (i * dRow);
            int c = col + (i * dCol);
            if (r >= 0 && r < size && c >= 0 && c < size && board[r][c] == sym) {
                count++;
            } else {
                break;
            }
        }
        return count == winCondition;
    }
    public List<int[]> getEmptyCells() {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') empty.add(new int[]{i, j});
            }
        }
        return empty;
    }
    public boolean isFull(){
        return getEmptyCells().isEmpty();
    }

    public int getSize() { return size; }
    public char getCell(int r, int c) { return board[r][c]; }
}
