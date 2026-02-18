package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        // Mock data initialization
        userList.add(new ForumUser(1, "John Smith", 'M', LocalDate.of(1990, 5, 12), 12));
        userList.add(new ForumUser(2, "Dorothy Newman", 'F', LocalDate.of(2005, 1, 1), 5));
        userList.add(new ForumUser(3, "John Wolkowitz", 'M', LocalDate.of(1985, 12, 30), 0));
        userList.add(new ForumUser(4, "Lucy Riley", 'F', LocalDate.of(2000, 3, 14), 100));
        userList.add(new ForumUser(5, "Owen Rogers", 'M', LocalDate.of(2008, 10, 20), 50));
        userList.add(new ForumUser(6, "Matilda Davies", 'F', LocalDate.of(1995, 7, 5), 20));
        userList.add(new ForumUser(7, "Declan Booth", 'M', LocalDate.of(2001, 11, 2), 1));
    }

    // Returning a defensive copy to prevent original list modification from outside
    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
