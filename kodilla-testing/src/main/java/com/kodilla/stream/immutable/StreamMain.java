package com.kodilla.stream.immutable;

public class StreamMain {
    public static void main(String[] args) {
        ForumUser user = new ForumUser("mrsmith", "John Smith");

        System.out.println("User: " + user.getUsername());
        System.out.println("Real name: " + user.getRealName());

    }
}
