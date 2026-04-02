package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User mark = new Millenials("Mark Millenial");
        User john = new YGeneration("John Y");
        User zoe = new ZGeneration("Zoe Z");

        //When
        String markShares = mark.sharePost();
        System.out.println(mark.getUsername() + " uses: " + markShares);
        String johnShares = john.sharePost();
        System.out.println(john.getUsername() + " uses: " + johnShares);
        String zoeShares = zoe.sharePost();
        System.out.println(zoe.getUsername() + " uses: " + zoeShares);

        //Then
        assertEquals("[Facebook] Sharing post on Facebook", markShares);
        assertEquals("[Twitter] Sharing post on Twitter", johnShares);
        assertEquals("[Snapchat] Sharing post on Snapchat", zoeShares);
    }
    @Test
    void testIndividualSharingStrategy(){
        //Given
        User mark = new Millenials("Mark Millenial");

        //When
        String markDefault = mark.sharePost();
        System.out.println("Default: " + markDefault);
        mark.setSocialPublisher(new FacebookPublisher());
        mark.setSocialPublisher(new com.kodilla.patterns.strategy.social.TwitterPublisher());
        String markNew = mark.sharePost();
        System.out.println("New strategy: " + markNew);

        //Then
        assertEquals("[Twitter] Sharing post on Twitter", markNew);

    }
}
