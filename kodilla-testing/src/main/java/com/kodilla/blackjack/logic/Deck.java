package com.kodilla.blackjack.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"c", "d", "h", "s"}; // Clubs, Diamonds, Hearts, Spades
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                // Important: Matches your "cards/2c.gif" structure
                String path = "cards/" + ranks[i] + suit + ".gif";
                cards.add(new Card(suit, ranks[i], values[i], path));
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
}
