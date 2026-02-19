package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String text, PoemDecorator decorator) {
        String result = decorator.decorate(text);
        System.out.println("Result: " + result);
        return result; // Added return statement for testing purposes
    }
}
