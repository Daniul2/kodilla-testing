package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Starting all tests for ShapeCollector.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests for ShapeCollector are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for adding and removing figures")
    class TestAddRemove {
        @Test
        @DisplayName("Test adding a figure to the collector")
        void testAddFigure() {
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Circle(4.0);
            collector.addFigure(shape);
            Assertions.assertEquals(shape, collector.getFigure(0));
        }

        @Test
        @DisplayName("Test removing a figure from the collector")
        void testRemoveFigure() {
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Square(5.0);
            collector.addFigure(shape);
            boolean result = collector.removeFigure(shape);
            Assertions.assertTrue(result);
            Assertions.assertNull(collector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for retrieving and showing figures")
    class TestGetShow {
        @Test
        @DisplayName("Test getting a figure by index")
        void testGetFigure() {
            ShapeCollector collector = new ShapeCollector();
            Shape shape = new Triangle(3.0, 4.0);
            collector.addFigure(shape);
            Shape result = collector.getFigure(0);
            Assertions.assertEquals(shape, result);
        }

        @Test
        @DisplayName("Test showing all figure names as one String")
        void testShowFigures() {
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(new Circle(2.0));
            collector.addFigure(new Square(3.0));
            collector.addFigure(new Triangle(2.0, 5.0));
            String result = collector.showFigures();
            String expected = "Circle, Square, Triangle";
            Assertions.assertEquals(expected, result);
        }
    }
}
