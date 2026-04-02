package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Weekly shopping", "Milk", 2.0);
            case PAINTING -> new PaintingTask("Renovation", "Blue", "Bedroom");
            case DRIVING -> new DrivingTask("Trip", "Cracow", "Car");
            default -> null;
        };
    }
}
