package com.kodilla.testing.stream.forumuser;


import com.kodilla.stream.forumuser.ForumUser;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Forum User Filtering Tests")
class ForumTestSuite {

    @Test
    @DisplayName("Test filtering users with various criteria")
    void testForumUserFiltering() {
        // Given: Prepare a list of users with different data
        List<ForumUser> users = new ArrayList<>();
        users.add(new ForumUser(1, "Valid Male", 'M', LocalDate.of(1990, 1, 1), 10)); // Should pass
        users.add(new ForumUser(2, "Female User", 'F', LocalDate.of(1990, 1, 1), 10)); // Should fail (Sex)
        users.add(new ForumUser(3, "Young Male", 'M', LocalDate.of(2010, 1, 1), 10)); // Should fail (Age)
        users.add(new ForumUser(4, "Male No Posts", 'M', LocalDate.of(1990, 1, 1), 0)); // Should fail (Posts)
        users.add(new ForumUser(5, "Old Male One Post", 'M', LocalDate.of(1980, 5, 5), 1)); // Should pass

        // When: Apply the same stream logic as in StreamMain
        Map<Integer, ForumUser> resultMap = users.stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        // Then: Check if the results are correct
        assertEquals(2, resultMap.size(), "The map should contain exactly 2 users");
        assertTrue(resultMap.containsKey(1), "User with ID 1 should be present");
        assertTrue(resultMap.containsKey(5), "User with ID 5 should be present");
        assertFalse(resultMap.containsKey(2), "Female users should be filtered out");
        assertFalse(resultMap.containsKey(3), "Users younger than 20 should be filtered out");
        assertFalse(resultMap.containsKey(4), "Users with 0 posts should be filtered out");
    }

    @Test
    @DisplayName("Test behavior with an empty list")
    void testEmptyList() {
        // Given
        List<ForumUser> emptyList = new ArrayList<>();

        // When
        Map<Integer, ForumUser> result = emptyList.stream()
                .filter(user -> user.getSex() == 'M')
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        // Then
        assertTrue(result.isEmpty(), "Resulting map should be empty");
    }
}
