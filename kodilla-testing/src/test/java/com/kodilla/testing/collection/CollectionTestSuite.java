package com.kodilla.testing.collection;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When exterminate is called with an empty list, then it should return an empty list")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();

        List<Integer> resultList = exterminator.exterminate(emptyList);

        Assertions.assertTrue(resultList.isEmpty());
    }

    @DisplayName("When exterminate is called with a normal list, then it should return only even numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 11);
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 10);

        List<Integer> resultList = exterminator.exterminate(inputList);

        Assertions.assertEquals(expectedList, resultList);
    }
}
