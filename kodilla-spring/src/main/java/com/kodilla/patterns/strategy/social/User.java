package com.kodilla.patterns.strategy.social;

public abstract sealed class User
        permits Millenials, YGeneration, ZGeneration {

    private final String username;
    private SocialPublisher socialPublisher;

    public User(String username, SocialPublisher socialPublisher) {
        this.username = username;
        this.socialPublisher = socialPublisher;
    }

    public String getUsername() {
        return username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
