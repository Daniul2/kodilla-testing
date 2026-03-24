package com.kodilla.blackjack.logic;
import java.util.List;

public class BlackjackLogic {
    public int calculateScore(List<Card> hand) {
        int score = 0, aces = 0;
        for (Card c : hand) {
            score += c.getValue();
            if (c.getRank().equalsIgnoreCase("a")) aces++;
        }
        while (score > 21 && aces > 0) { score -= 10; aces--; }
        return score;
    }

    public String determineWinner(int p, int d) {
        if (p > 21) return "DEALER WINS!";
        if (d > 21) return "PLAYER WINS!";
        if (p > d) return "PLAYER WINS!";
        if (d > p) return "DEALER WINS!";
        return "PUSH (DRAW)";
    }
}
