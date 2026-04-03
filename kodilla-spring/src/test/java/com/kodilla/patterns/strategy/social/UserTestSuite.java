package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User mark = new Millenials("Mark Millenial");
        User john = new YGeneration("John Y");
        User zoe = new ZGeneration("Zoe Z");

        //When
        String markShares = mark.sharePost();
        String johnShares = john.sharePost();
        String zoeShares = zoe.sharePost();

        //Then
        assertEquals("[Facebook] Sharing post on Facebook", markShares);
        assertEquals("[Twitter] Sharing post on Twitter", johnShares);
        assertEquals("[Snapchat] Sharing post on Snapchat", zoeShares);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User mark = new Millenials("Mark Millenial");

        //When
        mark.setSocialPublisher(new TwitterPublisher());
        String markNew = mark.sharePost();

        //Then
        assertEquals("[Twitter] Sharing post on Twitter", markNew);
    }
}
