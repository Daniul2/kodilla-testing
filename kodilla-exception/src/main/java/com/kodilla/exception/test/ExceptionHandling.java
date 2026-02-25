package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            // Testing with values that should work
            String result = secondChallenge.probablyIWillThrowException(1.5,2.0);
            System.out.println(result);
        } catch (Exception e) {
            // Handling the exception
            System.out.println("Error: An exception occurred due to invalid arguments.");
        }finally {
            // Always executes
            System.out.println("The process has been finished.");
        }
    }
}
