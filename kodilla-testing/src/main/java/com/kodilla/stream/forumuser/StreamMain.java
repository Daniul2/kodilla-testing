package com.kodilla.stream.forumuser;

import java.util.Map;

/**
 * Main application class.
 * No imports for Forum, ForumUser, or ForumProcessor needed as they are in the same package.
 */
public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        ForumProcessor processor = new ForumProcessor();

        // Process the data using the centralized logic
        Map<Integer, ForumUser> resultMap = processor.filterCorrectUsers(forum.getUserList());

        // Print results to console
        System.out.println("Users matching criteria: " + resultMap.size());
        resultMap.entrySet().stream()
                .map(entry -> "ID: " + entry.getKey() + " -> " + entry.getValue())
                .forEach(System.out::println);
    }
}
