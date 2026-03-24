package com.kodilla.blackjack;

import com.kodilla.blackjack.logic.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BlackjackFX extends Application {

    private final BlackjackLogic engine = new BlackjackLogic();
    private Deck deck = new Deck();
    private List<Card> playerHand = new ArrayList<>();
    private List<Card> dealerHand = new ArrayList<>();

    private int balance = 1000;
    private int currentBet = 0;
    private boolean dealerCardHidden = true;

    private final HBox playerCardBox = new HBox(15);
    private final HBox dealerCardBox = new HBox(15);
    private final Label statusLabel = new Label("Place your bet and click Deal!");
    private final Label balanceLabel = new Label("Balance: $1000");
    private final TextField betInput = new TextField("50");

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Background
        try {
            Image bgImage = new Image(getClass().getResourceAsStream("/table.jpg"));
            root.setBackground(new Background(new BackgroundImage(bgImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true))));
        } catch (Exception e) { root.setStyle("-fx-background-color: #013220;"); }

        // Styling
        statusLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: gold;");
        balanceLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");
        betInput.setMaxWidth(70);

        Label dLabel = new Label("Dealer's Hand:"); dLabel.setTextFill(Color.WHITE);
        Label pLabel = new Label("Your Hand:"); pLabel.setTextFill(Color.WHITE);

        Button btnHit = new Button("Hit");
        Button btnStand = new Button("Stand");
        Button btnDeal = new Button("Deal");
        Button btnSave = new Button("Save Game");
        Button btnLoad = new Button("Load Game");

        btnHit.setDisable(true);
        btnStand.setDisable(true);

        // --- Event Handlers ---
        btnDeal.setOnAction(e -> {
            try {
                int bet = Integer.parseInt(betInput.getText());
                if (bet > balance || bet <= 0) { statusLabel.setText("Invalid Bet!"); return; }
                currentBet = bet;
                balance -= bet;
                startRound();
                btnHit.setDisable(false); btnStand.setDisable(false); btnDeal.setDisable(true);
            } catch (Exception ex) { statusLabel.setText("Enter a number!"); }
        });

        btnHit.setOnAction(e -> {
            drawCard(playerHand, playerCardBox, false);
            if (engine.calculateScore(playerHand) > 21) {
                showResult("PLAYER BUSTED!");
                endRound(btnHit, btnStand, btnDeal);
            }
        });

        btnStand.setOnAction(e -> {
            dealerCardHidden = false;
            refreshDealerUI();
            while (engine.calculateScore(dealerHand) < 17) drawCard(dealerHand, dealerCardBox, false);
            checkWinner();
            endRound(btnHit, btnStand, btnDeal);
        });

        btnSave.setOnAction(e -> saveGame());
        btnLoad.setOnAction(e -> { if(loadGame()) { btnHit.setDisable(false); btnStand.setDisable(false); btnDeal.setDisable(true); } });

        // --- Layout ---
        HBox topBar = new HBox(15, new Label("Bet:"), betInput, balanceLabel, btnSave, btnLoad);
        topBar.setAlignment(Pos.CENTER);
        topBar.setStyle("-fx-background-color: rgba(0,0,0,0.7); -fx-padding: 10; -fx-background-radius: 10;");

        playerCardBox.setAlignment(Pos.CENTER); dealerCardBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(topBar, dLabel, dealerCardBox, pLabel, playerCardBox, statusLabel, new HBox(15, btnDeal, btnHit, btnStand));
        root.getChildren().forEach(n -> { if(n instanceof HBox) ((HBox)n).setAlignment(Pos.CENTER); });

        primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.setTitle("Kodilla Blackjack - Choice B Placeholder Mode");
        primaryStage.show();
    }

    private void startRound() {
        deck = new Deck(); playerHand.clear(); dealerHand.clear();
        dealerCardHidden = true; playerCardBox.getChildren().clear(); dealerCardBox.getChildren().clear();
        drawCard(playerHand, playerCardBox, false); drawCard(playerHand, playerCardBox, false);
        drawCard(dealerHand, dealerCardBox, false); drawCard(dealerHand, dealerCardBox, true);
        showResult("Good Luck!");
    }

    private void drawCard(List<Card> hand, HBox box, boolean hidden) {
        Card card = deck.drawCard();
        if (card != null) { hand.add(card); displayCard(box, card, hidden); }
    }

    private void displayCard(HBox box, Card card, boolean hidden) {
        String path = hidden ? "/cards/back.gif" : "/" + card.getImagePath();
        InputStream is = getClass().getResourceAsStream(path);

        if (is != null) {
            ImageView view = new ImageView(new Image(is));
            view.setFitHeight(150); view.setPreserveRatio(true);
            box.getChildren().add(view);
        } else {
            StackPane cardShape = new StackPane();
            cardShape.setPrefSize(100, 145);

            Rectangle bg = new Rectangle(100, 145);
            bg.setArcHeight(15); bg.setArcWidth(15);
            bg.setFill(hidden ? Color.DARKBLUE : Color.WHITE);
            bg.setStroke(Color.BLACK);

            Label text = new Label(hidden ? "?" : card.getRank().toUpperCase() + "\n" + card.getSuit().toUpperCase());
            text.setTextFill(hidden ? Color.WHITE : (card.getSuit().equals("h") || card.getSuit().equals("d") ? Color.RED : Color.BLACK));
            text.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-alignment: center;");

            cardShape.getChildren().addAll(bg, text);
            box.getChildren().add(cardShape);
        }
    }

    private void refreshDealerUI() {
        dealerCardBox.getChildren().clear();
        for (Card c : dealerHand) displayCard(dealerCardBox, c, false);
    }

    private void checkWinner() {
        int p = engine.calculateScore(playerHand);
        int d = engine.calculateScore(dealerHand);
        String result = engine.determineWinner(p, d);
        if (result.contains("PLAYER WINS")) balance += currentBet * 2;
        else if (result.contains("PUSH")) balance += currentBet;
        showResult(result);
    }

    private void showResult(String msg) {
        statusLabel.setText(msg);
        balanceLabel.setText("Balance: $" + balance + " | Your Score: " + engine.calculateScore(playerHand));
    }

    private void endRound(Button h, Button s, Button d) { h.setDisable(true); s.setDisable(true); d.setDisable(false); }

    private void saveGame() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"))) {
            oos.writeObject(new GameState(playerHand, dealerHand, deck.getRemainingCards(), balance, currentBet));
            statusLabel.setText("GAME SAVED");
        } catch (Exception e) { statusLabel.setText("SAVE ERROR"); }
    }

    private boolean loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.dat"))) {
            GameState s = (GameState) ois.readObject();
            this.playerHand = s.playerHand; this.dealerHand = s.dealerHand;
            this.balance = s.balance; this.currentBet = s.bet; this.deck.setCards(s.deckCards);
            playerCardBox.getChildren().clear(); dealerCardBox.getChildren().clear();
            for (Card c : playerHand) displayCard(playerCardBox, c, false);
            for (int i=0; i<dealerHand.size(); i++) displayCard(dealerCardBox, dealerHand.get(i), i==1 && dealerCardHidden);
            showResult("GAME LOADED"); return true;
        } catch (Exception e) { statusLabel.setText("NO SAVE"); return false; }
    }

    public static void main(String[] args) { launch(args); }
}
