package com.kodilla.stream.forumuser;

import com.kodilla.stream.forumuser.ForumProcessor;
import com.kodilla.stream.forumuser.ForumUser;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for verifying forum user filtering logic.
 * Tests the ForumProcessor service directly.
 */
@DisplayName("Forum User Filtering Tests")
class ForumTestSuite {

    @Test
    @DisplayName("Test filtering users using centralized ForumProcessor logic")
    void testForumUserFiltering() {
        // Given: Prepare a custom list for testing
        ForumProcessor processor = new ForumProcessor();
        List<ForumUser> users = new ArrayList<>();
        users.add(new ForumUser(1, "Valid Male", 'M', LocalDate.of(1990, 1, 1), 10)); // Should pass
        users.add(new ForumUser(2, "Female", 'F', LocalDate.of(1990, 1, 1), 10));      // Should fail (Sex)
        users.add(new ForumUser(3, "Too Young", 'M', LocalDate.of(2015, 1, 1), 10));  // Should fail (Age)
        users.add(new ForumUser(4, "No Posts", 'M', LocalDate.of(1990, 1, 1), 0));     // Should fail (Posts)

        // When: Execute the filtering logic
        Map<Integer, ForumUser> resultMap = processor.filterCorrectUsers(users);

        // Then: Verify results
        assertEquals(1, resultMap.size(), "Result map size should be 1");
        assertTrue(resultMap.containsKey(1), "Result should contain user with ID 1");
        assertFalse(resultMap.containsKey(2), "Female users should be excluded");
        assertFalse(resultMap.containsKey(3), "Users younger than 20 should be excluded");
        assertFalse(resultMap.containsKey(4), "Users with 0 posts should be excluded");
    }
}
