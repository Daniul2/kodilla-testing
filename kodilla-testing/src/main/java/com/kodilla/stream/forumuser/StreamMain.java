package com.kodilla.stream.forumuser;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        // Processing the list using Stream API
        Map<Integer, ForumUser> theResultMapOfUsers = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M') // Step 1: Filter only men
                // Step 2: Filter users at least 20 years old
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getPostsCount() >= 1) // Step 3: Filter users with at least 1 post
                // Step 4: Collect results into a Map (Key = ID, Value = Object)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        // Printing results from the Map
        System.out.println("# Elements in the map: " + theResultMapOfUsers.size());

        // Converting Map entries back to stream for formatted output
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue()) // Formatting each entry to String
                .forEach(System.out::println); // Printing each formatted String
    }
}
