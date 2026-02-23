package com.kodilla.stream.beautifier;


import com.kodilla.stream.beautifier.PoemBeautifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoemBeautifierTestSuite {

    @Test
    void testBeautifyLambdas() {
        // Given
        PoemBeautifier beautifier = new PoemBeautifier();

        // When & Then
        assertEquals("HELLO", beautifier.beautify("hello", String::toUpperCase));
        assertEquals("ABC Java ABC", beautifier.beautify("Java", t -> "ABC " + t + " ABC"));
        assertEquals("dlroW", beautifier.beautify("World", t -> new StringBuilder(t).reverse().toString()));
        assertEquals("TestTest", beautifier.beautify("Test", t -> t.repeat(2)));
        assertEquals("H3ll0", beautifier.beautify("Hello", t -> t.replace('e', '3').replace('o', '0')));
    }
}
