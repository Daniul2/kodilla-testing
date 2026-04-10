package com.kodilla.sudoku;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            boolean again = game.runOneBoard();
            if (!again) break;
        }
        System.out.println("Program finished. Goodbye.");
    }
}
