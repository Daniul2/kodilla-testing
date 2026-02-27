package com.kodilla.exception.test;

public class PowerCalculator {
    public long calculatePower(int base,int exponent){
        if (exponent == 0){
            return 1;
        }
        if (base == 0){
            return 0;
        }
        if (base == 1){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }


    public static void main(String[] args) {
        PowerCalculator calculator = new PowerCalculator();

       // different cases
        System.out.println("Result (2^3): " + calculator.calculatePower(2, 3));
        System.out.println("Result (5^0): " + calculator.calculatePower(5, 0));
        System.out.println("Result (0^5): " + calculator.calculatePower(0, 5));
    }
}
