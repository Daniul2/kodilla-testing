package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Portfolio Board Test Suite")
class BoardTestSuite {

    @Test
    @DisplayName("Test if average working time for tasks 'In progress' is calculated correctly")
    void testAddTaskListAverageWorkingOnTask() {
        // Given: Create a board with tasks that are 20, 10, and 0 days old
        Board project = prepareTestData();

        // When: Use Stream to calculate the average number of days since creation
        double averageDays = project.getTaskLists().stream()
                .filter(tl -> tl.getName().equals("In progress"))
                .flatMap(tl -> tl.getTasks().stream())
                .mapToLong(t -> ChronoUnit.DAYS.between(t.getCreated(), LocalDate.now()))
                .average()
                .orElse(0.0);

        // Then: The average of 20, 10, and 0 should be 10.0
        assertEquals(10.0, averageDays, 0.001);
    }

    @Test
    @DisplayName("Test if average working time returns 0.0 when 'In progress' list is empty")
    void testAddTaskListAverageWorkingOnTaskEmptyList() {
        // Given: A board with a list that has no tasks
        Board project = new Board("Empty Project");
        project.addTaskList(new TaskList("In progress"));

        // When: Calculating average on an empty stream
        double averageDays = project.getTaskLists().stream()
                .filter(tl -> tl.getName().equals("In progress"))
                .flatMap(tl -> tl.getTasks().stream())
                .mapToLong(t -> ChronoUnit.DAYS.between(t.getCreated(), LocalDate.now()))
                .average()
                .orElse(0.0);

        // Then: The result should be 0.0
        assertEquals(0.0, averageDays, 0.001);
    }

    private Board prepareTestData() {
        User user = new User("user1", "John Developer");

        Task task1 = new Task("T1", "D1", user, user, LocalDate.now().minusDays(20), LocalDate.now());
        Task task2 = new Task("T2", "D2", user, user, LocalDate.now().minusDays(10), LocalDate.now());
        Task task3 = new Task("T3", "D3", user, user, LocalDate.now(), LocalDate.now());

        TaskList listInProgress = new TaskList("In progress");
        listInProgress.addTask(task1);
        listInProgress.addTask(task2);
        listInProgress.addTask(task3);

        Board project = new Board("Project Board");
        project.addTaskList(listInProgress);

        return project;
    }
}

