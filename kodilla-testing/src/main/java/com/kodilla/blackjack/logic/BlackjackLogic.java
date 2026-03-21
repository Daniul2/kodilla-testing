package com.kodilla.blackjack.logic;

import java.util.List;

public class BlackjackLogic {

    public int calculateScore(List<Card> hand) {
        int score = 0;
        int aces = 0;

        for (Card card : hand) {
            score += card.getValue();
            if (card.getRank().equalsIgnoreCase("a")) {
                aces++;
            }
        }

        // Logic for Aces: Change 11 to 1 if score > 21
        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }
        return score;
    }

    public String determineWinner(int playerScore, int dealerScore) {
        if (playerScore > 21) return "Dealer Wins";
        if (dealerScore > 21) return "Player Wins";
        if (playerScore > dealerScore) return "Player Wins";
        if (dealerScore > playerScore) return "Dealer Wins";
        return "Push";
    }
}
