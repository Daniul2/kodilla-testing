package com.kodilla.spring.portfolio.additional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FibonacciTestSuite {

    @Autowired
    private Fibonacci fibonacci;

    @Test
    void testFibonacciElements() {
        //Given
        //When & Then
        assertEquals(0, fibonacci.calculateFibonacci(0));
        assertEquals(1, fibonacci.calculateFibonacci(1));
        assertEquals(1, fibonacci.calculateFibonacci(2));
        assertEquals(2, fibonacci.calculateFibonacci(3));
        assertEquals(3, fibonacci.calculateFibonacci(4));
        assertEquals(5, fibonacci.calculateFibonacci(5));
        assertEquals(8, fibonacci.calculateFibonacci(6));
        assertEquals(13, fibonacci.calculateFibonacci(7));
        assertEquals(21, fibonacci.calculateFibonacci(8));
    }

    @Test
    void testLargeFibonacciElement() {
        //Given
        //When
        long result = fibonacci.calculateFibonacci(12);

        //Then
        assertEquals(144, result);
    }
}
