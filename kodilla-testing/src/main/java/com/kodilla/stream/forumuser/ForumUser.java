package com.kodilla.stream.forumuser;

import java.time.LocalDate;

// Final class prevents inheritance, ensuring immutability
public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(int userId, String username, char sex, LocalDate birthDate, int postsCount) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    // Standard getters used by Stream to access private data
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public char getSex() { return sex; }
    public LocalDate getBirthDate() { return birthDate; }
    public int getPostsCount() { return postsCount; }

    // Overriding toString to display user data instead of memory address in console
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
