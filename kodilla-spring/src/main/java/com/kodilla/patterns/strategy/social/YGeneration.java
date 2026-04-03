package com.kodilla.patterns.strategy.social;

public final class YGeneration extends User {
    public YGeneration(String username) {
        super(username,new TwitterPublisher());
    }
}
