package com.kodilla.sudoku;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public boolean runOneBoard() {
        Board board = new Board();
        System.out.println("New 9x9 Sudoku. Enter col,row,value (1-9). Type SUDOKU to solve, EXIT to quit.");
        while (true) {
            board.print();
            System.out.print("Input (col,row,value) or command: ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("EXIT")) return false;
            if (line.equalsIgnoreCase("SUDOKU")) {
                Board copy = board.deepCopy();
                Solver solver = new Solver();
                boolean solved = solver.solve(copy);
                if (solved) {
                    System.out.println("Solution:");
                    copy.print();
                } else {
                    System.out.println("No solution found. Puzzle may be invalid.");
                    board.print();
                }
                System.out.println("Press ENTER to start a new board or type EXIT.");
                String next = scanner.nextLine();
                if (next.equalsIgnoreCase("EXIT")) return false;
                return true;
            }
            try {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.out.println("Invalid format. Use col,row,value.");
                    continue;
                }
                int col = Integer.parseInt(parts[0].trim()) - 1;
                int row = Integer.parseInt(parts[1].trim()) - 1;
                int val = Integer.parseInt(parts[2].trim());
                if (!inRange(row) || !inRange(col) || val < 1 || val > 9) {
                    System.out.println("Values must be 1-9.");
                    continue;
                }
                if (!board.get(row, col).isEmpty()) {
                    System.out.println("Cell already filled.");
                    continue;
                }
                Solver validator = new Solver();
                if (!validator.isValid(board, row, col, val)) {
                    System.out.println("Placement violates Sudoku rules.");
                    continue;
                }
                board.set(row, col, val);
            } catch (NumberFormatException ex) {
                System.out.println("Number parse error. Try again.");
            }
        }
    }

    private boolean inRange(int x) { return x >= 0 && x < Board.SIZE; }
}
