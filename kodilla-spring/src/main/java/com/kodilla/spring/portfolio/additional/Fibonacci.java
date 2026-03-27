package com.kodilla.spring.portfolio.additional;

import org.springframework.stereotype.Component;

@Component
public class Fibonacci {
    public long calculateFibonacci(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;


        long prev = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        return current;

    }
}
