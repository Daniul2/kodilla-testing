package com.kodilla.blackjack;

import com.kodilla.blackjack.logic.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BlackjackFX extends Application {

    private Deck deck;
    private final List<Card> playerHand = new ArrayList<>();
    private final List<Card> dealerHand = new ArrayList<>();

    private final HBox playerCardBox = new HBox(10);
    private final HBox dealerCardBox = new HBox(10);
    private final Label statusLabel = new Label("Welcome! Click Deal to start.");
    private final Label scoreLabel = new Label("Player: 0 | Dealer: 0");

    @Override
    public void start(Stage primaryStage) {
        // --- BACKGROUND LOADING (FIXED) ---
        Image imageback = new Image(getClass().getResourceAsStream("/table.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(imageback,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, false));

        GridPane grid = new GridPane();
        grid.setBackground(new Background(backgroundImage));
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(15);
        grid.setVgap(15);

        // Styling
        statusLabel.setTextFill(Color.GOLD);
        statusLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        scoreLabel.setTextFill(Color.WHITE);

        Button btnHit = new Button("Hit");
        Button btnStand = new Button("Stand");
        Button btnDeal = new Button("Deal New Game");

        // Logic
        btnHit.setDisable(true);
        btnStand.setDisable(true);

        btnDeal.setOnAction(e -> {
            startNewGame();
            btnHit.setDisable(false);
            btnStand.setDisable(false);
            btnDeal.setDisable(true);
        });

        btnHit.setOnAction(e -> {
            drawCard(playerHand, playerCardBox);
            updateScores();
            if (calculateScore(playerHand) > 21) {
                statusLabel.setText("BUST! Dealer wins.");
                endGame(btnHit, btnStand, btnDeal);
            }
        });

        btnStand.setOnAction(e -> {
            while (calculateScore(dealerHand) < 17) {
                drawCard(dealerHand, dealerCardBox);
            }
            checkWinner();
            endGame(btnHit, btnStand, btnDeal);
        });

        // Layout
        grid.add(new Label("Dealer's Hand:"), 0, 0);
        grid.add(dealerCardBox, 0, 1);
        grid.add(new Label("Your Hand:"), 0, 2);
        grid.add(playerCardBox, 0, 3);
        grid.add(scoreLabel, 0, 4);
        grid.add(statusLabel, 0, 5);
        grid.add(btnDeal, 0, 6);
        grid.add(btnHit, 1, 6);
        grid.add(btnStand, 2, 6);

        Scene scene = new Scene(grid, 1100, 750);
        primaryStage.setTitle("Kodilla Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startNewGame() {
        deck = new Deck();
        playerHand.clear();
        dealerHand.clear();
        playerCardBox.getChildren().clear();
        dealerCardBox.getChildren().clear();

        drawCard(playerHand, playerCardBox);
        drawCard(playerHand, playerCardBox);
        drawCard(dealerHand, dealerCardBox);

        statusLabel.setText("Your turn!");
        updateScores();
    }

    private void drawCard(List<Card> hand, HBox box) {
        Card card = deck.drawCard();
        hand.add(card);
        try {
            // --- CARD LOADING (FIXED) ---
            Image img = new Image(getClass().getResourceAsStream("/" + card.getImagePath()));
            ImageView view = new ImageView(img);
            view.setFitHeight(150);
            view.setPreserveRatio(true);
            box.getChildren().add(view);
        } catch (Exception e) {
            box.getChildren().add(new Label(card.getRank()));
        }
    }

    private int calculateScore(List<Card> hand) {
        int score = 0;
        int aces = 0;
        for (Card c : hand) {
            score += c.getValue();
            if (c.getRank().equals("a")) aces++;
        }
        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }
        return score;
    }

    private void updateScores() {
        scoreLabel.setText("Player: " + calculateScore(playerHand) + " | Dealer: " + calculateScore(dealerHand));
    }

    private void checkWinner() {
        int p = calculateScore(playerHand);
        int d = calculateScore(dealerHand);
        updateScores();

        if (d > 21 || p > d) {
            statusLabel.setText("YOU WIN!");
            ScoreManager.saveWin("Player1");
        } else if (d > p) {
            statusLabel.setText("DEALER WINS!");
        } else {
            statusLabel.setText("PUSH (DRAW)!");
        }
    }

    private void endGame(Button h, Button s, Button d) {
        h.setDisable(true);
        s.setDisable(true);
        d.setDisable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
