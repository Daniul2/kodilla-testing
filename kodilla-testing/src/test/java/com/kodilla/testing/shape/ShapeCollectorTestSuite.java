package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: ShapeCollector Test Suite")
class ShapeCollectorTestSuite {

    private ShapeCollector collector;

    @BeforeEach
    void setUp() {
        collector = new ShapeCollector();
    }

    @Nested
    @DisplayName("Tests for adding and removing")
    class TestAddRemove {
        @Test
        void testAddFigure() {
            // Given
            Shape shape = new Circle(10);
            // When
            collector.addFigure(shape);
            // Then
            assertEquals(shape, collector.getFigure(0));
        }

        @Test
        void testRemoveFigureExisting() {
            // Given
            Shape shape = new Square(5);
            collector.addFigure(shape);
            // When
            boolean result = collector.removeFigure(shape);
            // Then
            assertTrue(result);
            assertNull(collector.getFigure(0));
        }

        @Test
        @DisplayName("Case: Remove figure that is not in the list")
        void testRemoveFigureNotExisting() {
            // Given
            Shape shape = new Triangle(4, 5);
            // When
            boolean result = collector.removeFigure(shape);
            // Then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Tests for retrieving figures")
    class TestRetrieval {
        @Test
        void testGetFigureValidIndex() {
            // Given
            Shape shape = new Circle(2);
            collector.addFigure(shape);
            // When
            Shape retrieved = collector.getFigure(0);
            // Then
            assertEquals(shape, retrieved);
        }

        @Test
        @DisplayName("Case: Index below zero")
        void testGetFigureNegativeIndex() {
            // When
            Shape result = collector.getFigure(-1);
            // Then
            assertNull(result);
        }

        @Test
        @DisplayName("Case: Index out of bounds (too high)")
        void testGetFigureIndexOutOfBounds() {
            // Given
            collector.addFigure(new Square(4));
            // When
            Shape result = collector.getFigure(1);
            // Then
            assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tests for displaying figures")
    class TestDisplay {
        @Test
        void testShowFiguresMultiple() {
            // Given
            collector.addFigure(new Circle(2));
            collector.addFigure(new Square(3));
            // When
            String result = collector.showFigures();
            // Then
            assertEquals("Circle, Square", result);
        }

        @Test
        @DisplayName("Case: Show figures when collection is empty")
        void testShowFiguresEmpty() {
            // When
            String result = collector.showFigures();
            // Then
            assertEquals("", result);
        }
    }
}
