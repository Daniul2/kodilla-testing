package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }


    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            // We call the method that might throw an exception
            double result = firstChallenge.divide(3, 0);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle the division by zero exception
            System.out.println("Error: Division by zero is not allowed.");

        } finally {
            // This block will always run
            System.out.println("The process has been completed.");
        }
    }
}
