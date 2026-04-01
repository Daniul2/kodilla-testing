package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void setUp(){
        logger = Logger.INSTANCE;
        logger.log("First log message");

    }
    @Test
    void testGetLastLog(){

        //When
        String result = logger.getLastLog();

        //Then
        assertEquals("First log message", result);

    }
    @Test
    void testNewLog(){
        String newLog = "User login: admin";

        //When
        logger.log(newLog);
        String result = logger.getLastLog();

        //Then
        assertEquals(newLog, result);
    }
}
