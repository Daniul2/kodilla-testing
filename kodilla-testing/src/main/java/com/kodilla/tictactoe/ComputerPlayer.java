package com.kodilla.tictactoe;

import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    private final char symbol;
    private final Random random = new Random();

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
    }

    public void makeRandomMove(TicTacToeBoard board) {
        List<int[]> availableMoves = board.getEmptyCells();
        if (!availableMoves.isEmpty()) {
            int[] move = availableMoves.get(random.nextInt(availableMoves.size()));
            board.makeMove(move[0], move[1], symbol);
        }
    }

    public char getSymbol() {
        return symbol;
    }
}
