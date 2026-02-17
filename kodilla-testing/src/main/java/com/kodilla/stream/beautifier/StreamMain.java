package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("hello world", (text ) -> text.toUpperCase());
        poemBeautifier.beautify("Java", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Beautiful Day", (text) -> "🌟 " + text + " 🌟");
        poemBeautifier.beautify("Kodilla",(text) -> new StringBuilder(text).reverse().toString());
        poemBeautifier.beautify("Boom", (text) -> text.repeat(3));
        poemBeautifier.beautify("I like something", (text) -> text.replace('o', '0').replace('e', '3'));

    }
}
