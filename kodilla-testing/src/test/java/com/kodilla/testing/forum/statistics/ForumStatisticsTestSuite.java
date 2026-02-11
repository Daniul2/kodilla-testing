package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        forumStatistics = new ForumStatistics();
    }

    private List<String> generateUsersList(int count) {
        List<String> users = new ArrayList<>();
        for (int n = 0; n < count; n++) {
            users.add("User" + n);
        }
        return users;
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(10));

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getPostsCount());
        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWith1000Posts() {
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(100));

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(1000, forumStatistics.getPostsCount());
        assertEquals(10.0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(10));

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getCommentsCount());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsLessCommentsThanPosts() {
        when(statisticsMock.commentsCount()).thenReturn(20);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(10));

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.2, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(10));

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2.0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.postsCount()).thenReturn(100);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWith100Users() {
        when(statisticsMock.usersNames()).thenReturn(generateUsersList(100));
        when(statisticsMock.postsCount()).thenReturn(500);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(5.0, forumStatistics.getAvgPostsPerUser());
    }
}
