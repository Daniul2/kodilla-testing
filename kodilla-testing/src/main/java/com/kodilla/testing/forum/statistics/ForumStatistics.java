package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        if (usersCount != 0) {
            avgPostsPerUser = (double) postsCount / usersCount;
            avgCommentsPerUser = (double) commentsCount / usersCount;
        } else {
            avgPostsPerUser = 0;
            avgCommentsPerUser = 0;
        }

        if (postsCount != 0) {
            avgCommentsPerPost = (double) commentsCount / postsCount;
        } else {
            avgCommentsPerPost = 0;
        }
    }

    public void showStatistics() {
        System.out.println("Forum Statistics:");
        System.out.println("Users count: " + usersCount);
        System.out.println("Posts count: " + postsCount);
        System.out.println("Comments count: " + commentsCount);
        System.out.println("Average posts per user: " + avgPostsPerUser);
        System.out.println("Average comments per user: " + avgCommentsPerUser);
        System.out.println("Average comments per post: " + avgCommentsPerPost);
    }

    // Getter-и для тестів
    public int getUsersCount() { return usersCount; }
    public int getPostsCount() { return postsCount; }
    public int getCommentsCount() { return commentsCount; }
    public double getAvgPostsPerUser() { return avgPostsPerUser; }
    public double getAvgCommentsPerUser() { return avgCommentsPerUser; }
    public double getAvgCommentsPerPost() { return avgCommentsPerPost; }
}
