package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String text,PoemDecorator decorator){
        String result = decorator.decorate(text);
        System.out.println("Result of beautification: " + result);
    }
}
