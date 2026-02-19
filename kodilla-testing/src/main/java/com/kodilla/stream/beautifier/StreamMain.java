package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier beautifier = new PoemBeautifier();

        beautifier.beautify("hello world", String::toUpperCase);
        beautifier.beautify("Java", text -> "ABC " + text + " ABC");
        beautifier.beautify("Kodilla", text -> new StringBuilder(text).reverse().toString());
    }
}
