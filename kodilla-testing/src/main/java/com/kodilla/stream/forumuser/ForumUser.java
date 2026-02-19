package com.kodilla.stream.forumuser;

import java.time.LocalDate;

/**
 * Represents a user on the forum.
 * Marked as final to ensure immutability.
 */
public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex; // 'M' or 'F'
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(int userId, String username, char sex, LocalDate birthDate, int postsCount) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    // Standard getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public char getSex() { return sex; }
    public LocalDate getBirthDate() { return birthDate; }
    public int getPostsCount() { return postsCount; }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + userId +
                ", name='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", posts=" + postsCount +
                '}';
    }
}
