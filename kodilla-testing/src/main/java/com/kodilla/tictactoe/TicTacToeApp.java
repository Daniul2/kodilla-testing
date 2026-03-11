package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApp extends Application {
    private TicTacToeBoard board;
    private ComputerPlayer computer;
    private char userSymbol = 'X';
    private Button[][] buttons;
    private GridPane grid;

    @Override
    public void start(Stage primaryStage) {
        showStartDialog(primaryStage);
    }

    private void showStartDialog(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Settings");
        alert.setHeaderText("Choose your board variant");
        alert.setContentText("3x3 (Classic) or 10x10 (Win with 5)?");

        ButtonType btn3x3 = new ButtonType("3x3");
        ButtonType btn10x10 = new ButtonType("10x10");
        alert.getButtonTypes().setAll(btn3x3, btn10x10);

        alert.showAndWait().ifPresent(type -> {
            if (type == btn3x3) initGame(stage, 3, 3);
            else initGame(stage, 10, 5);
        });
    }

    private void initGame(Stage stage, int size, int winCond) {
        board = new TicTacToeBoard(size, winCond);
        computer = new ComputerPlayer('O');
        buttons = new Button[size][size];
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Button btn = new Button(" ");
                btn.setPrefSize(size == 3 ? 100 : 40, size == 3 ? 100 : 40);
                int finalR = r;
                int finalC = c;
                btn.setOnAction(e -> handleMove(finalR, finalC));
                buttons[r][c] = btn;
                grid.add(btn, c, r);
            }
        }

        stage.setScene(new Scene(grid, size * 50 + 50, size * 50 + 50));
        stage.setTitle("Tic Tac Toe - " + size + "x" + size);
        stage.show();
    }

    private void handleMove(int r, int c) {
        // User Turn
        if (board.makeMove(r, c, userSymbol)) {
            refreshBoard();
            if (checkEndGame(userSymbol)) return;

            // Computer Turn
            computer.makeRandomMove(board);
            refreshBoard();
            checkEndGame(computer.getSymbol());
        }
    }

    private void refreshBoard() {
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                buttons[r][c].setText(String.valueOf(board.getCell(r, c)));
            }
        }
    }

    private boolean checkEndGame(char sym) {
        if (board.checkWin(sym)) {
            System.out.println("Winner: " + sym);
            grid.setDisable(true);
            return true;
        }
        if (board.isFull()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) { launch(args); }
}
