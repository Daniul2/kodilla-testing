package com.kodilla.blackjack.logic;

import java.io.Serializable;

public class Card implements Serializable {
    private final String suit; // c, d, h, s
    private final String rank; // 2, 3... a
    private final int value;
    private final String imagePath;

    public Card(String suit, String rank, int value, String imagePath) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.imagePath = imagePath;
    }

    public int getValue() { return value; }
    public String getRank() { return rank; }
    public String getSuit() { return suit; }
    public String getImagePath() { return imagePath; }

    @Override
    public String toString() { return rank + " of " + suit; }
}
