package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class responsible for processing user data using Stream API.
 * Centralizing logic here prevents code duplication in main and tests.
 */
public class ForumProcessor {

    /**
     * Filters users: must be Male, at least 20 years old, and have at least 1 post.
     * Returns results as a Map with User ID as Key.
     */
    public Map<Integer, ForumUser> filterCorrectUsers(List<ForumUser> users) {
        return users.stream()
                .filter(user -> user.getSex() == 'M') // Filter Men only
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20))) // Age check
                .filter(user -> user.getPostsCount() >= 1) // Post count check
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));
    }
}
