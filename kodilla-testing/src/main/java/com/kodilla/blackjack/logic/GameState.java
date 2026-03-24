package com.kodilla.blackjack.logic;
import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    public List<Card> playerHand, dealerHand, deckCards;
    public int balance, bet;

    public GameState(List<Card> ph, List<Card> dh, List<Card> dc, int bal, int b) {
        playerHand = ph; dealerHand = dh; deckCards = dc; balance = bal; bet = b;
    }
}
