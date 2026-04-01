package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void setUp(){
        logger = Logger.INSTANCE;

    }
    @Test
    void testGetLastLog(){

        //When
        logger.log("Log for test 1");

        // When
        String result = logger.getLastLog();

        // Then
        assertEquals("Log for test 1", result);

    }
    @Test
    void testNewLog(){
        logger.log("User login: admin");

        // When
        String result = logger.getLastLog();

        // Then
        assertEquals("User login: admin", result);
    }
}
