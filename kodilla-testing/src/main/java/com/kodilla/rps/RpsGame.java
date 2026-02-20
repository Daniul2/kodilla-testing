package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class RpsGame {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String playerName;
    private int winsRequired;
    private int playerWins;
    private int computerWins;
    private boolean end = false;

    public void start() {
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.print("Enter your name: ");
        playerName = readString();

        resetGameSettings();

        while (!end) {
            playMatch();
            if (!end) {
                handleEndGameOptions();
            }
        }
        System.out.println("Thank you for playing!");
    }

    private void resetGameSettings() {
        System.out.print("Enter number of wins required for final victory: ");
        while (true) {
            try {
                String input = readString();
                winsRequired = Integer.parseInt(input);
                if (winsRequired > 0) break;
                System.out.print("Please enter a number greater than 0: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        showInstructions();
    }

    private void playMatch() {
        playerWins = 0;
        computerWins = 0;

        while (playerWins < winsRequired && computerWins < winsRequired && !end) {
            System.out.println("\n--- Current Score: " + playerName + " " + playerWins + " - " + computerWins + " Computer ---");
            System.out.print("Your move (1-3, x, n): ");

            String input = readString();

            switch (input) {
                case "x" -> {
                    if (confirmAction("terminate the game")) end = true;
                }
                case "n" -> {
                    if (confirmAction("restart the whole game")) {
                        resetGameSettings();
                        playerWins = 0;
                        computerWins = 0;
                    }
                }
                case "1", "2", "3" -> processRound(Integer.parseInt(input));
                default -> System.out.println("Invalid input! Use 1, 2, 3, x, or n.");
            }
        }

        if (!end) {
            showFinalResult();
        }
    }

    private void processRound(int playerMove) {
        int computerMove = random.nextInt(3) + 1; // 1-3
        System.out.println("You played: " + moveName(playerMove));
        System.out.println("Computer played: " + moveName(computerMove));

        if (playerMove == computerMove) {
            System.out.println("It's a tie!");
        } else if ((playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2)) {
            System.out.println("You win this round!");
            playerWins++;
        } else {
            System.out.println("Computer wins this round!");
            computerWins++;
        }
    }

    private void handleEndGameOptions() {
        boolean validChoice = false;
        while (!validChoice && !end) {
            System.out.print("\nGame Over. Press 'n' for new game or 'x' to exit: ");
            String choice = readString();
            if (choice.equals("x")) {
                if (confirmAction("exit")) {
                    end = true;
                    validChoice = true;
                }
            } else if (choice.equals("n")) {
                if (confirmAction("start a new game")) {
                    resetGameSettings();
                    validChoice = true;
                }
            }
        }
    }

    // Bezpieczne czytanie inputu
    private String readString() {
        try {
            if (scanner.hasNextLine()) {
                return scanner.nextLine().trim().toLowerCase();
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            return "x"; // W razie błędu strumienia, traktuj jak wyjście
        }
        return "x";
    }

    private boolean confirmAction(String message) {
        System.out.print("Are you sure you want to " + message + "? (y/n): ");
        return readString().equals("y");
    }

    private String moveName(int move) {
        return switch (move) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> "";
        };
    }

    private void showInstructions() {
        System.out.println("\nGame Controls:");
        System.out.println("1 - Rock | 2 - Paper | 3 - Scissors | x - Exit | n - Restart");
    }

    private void showFinalResult() {
        System.out.println("\n*******************************");
        if (playerWins > computerWins) {
            System.out.println("CONGRATULATIONS! " + playerName + " wins!");
        } else {
            System.out.println("GAME OVER! Computer wins!");
        }
        System.out.println("Final Score: " + playerWins + " - " + computerWins);
        System.out.println("*******************************");
    }
}
