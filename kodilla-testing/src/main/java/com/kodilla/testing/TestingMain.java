package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int addResult = calculator.add(10, 5);
        if (addResult == 15) {
            System.out.println("Calculator test add: OK");
        } else {
            System.out.println("Calculator test add: Error!");
        }

        int subtractResult = calculator.subtract(10, 5);
        if (subtractResult == 5) {
            System.out.println("Calculator test subtract: OK");
        } else {
            System.out.println("Calculator test subtract: Error!");
        }
    }
}
