package com.kodilla.testing.stream.portfolio;

import com.kodilla.stream.portfolio.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTestSuite {

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        // Given
        Board project = prepareTestData();

        // When
        double averageDays = project.getTaskLists().stream()
                .filter(tl -> tl.getName().equals("In progress"))
                .flatMap(tl -> tl.getTasks().stream())
                .mapToLong(t -> ChronoUnit.DAYS.between(t.getCreated(), LocalDate.now()))
                .average()
                .orElse(0.0);

        // Then
        assertEquals(10.0, averageDays, 0.001);
    }

    private Board prepareTestData() {
        User user = new User("user", "name");

        // Task created 20 days ago
        Task task1 = new Task("T1", "D", user, user, LocalDate.now().minusDays(20), LocalDate.now());
        // Task created 10 days ago
        Task task2 = new Task("T2", "D", user, user, LocalDate.now().minusDays(10), LocalDate.now());
        // Task created today (0 days ago)
        Task task3 = new Task("T3", "D", user, user, LocalDate.now(), LocalDate.now());

        TaskList listInProgress = new TaskList("In progress");
        listInProgress.addTask(task1);
        listInProgress.addTask(task2);
        listInProgress.addTask(task3);

        Board project = new Board("Project");
        project.addTaskList(listInProgress);

        return project;
    }
}
