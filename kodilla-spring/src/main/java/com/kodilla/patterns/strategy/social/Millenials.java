package com.kodilla.patterns.strategy.social;

public final class Millenials extends User{
    public Millenials(String username) {
        super(username,new FacebookPublisher());

    }
}

