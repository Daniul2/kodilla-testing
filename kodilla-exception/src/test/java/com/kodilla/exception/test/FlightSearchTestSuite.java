package com.kodilla.exception.test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightSearchTestSuite {

    @Test
    void testFindFlightWhenAirportExists() {
        // Given
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warsaw", "London");

        // When & Then
        // Airport "London" is in the map, so it should NOT throw an exception
        assertDoesNotThrow(() -> flightSearch.findFlight(flight));
    }

    @Test
    void testFindFlightWhenAirportDoesNotExist() {
        // Given
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warsaw", "New York");

        // When & Then
        // Airport "New York" is NOT in the map, so it SHOULD throw RouteNotFoundException
        assertThrows(RouteNotFoundException.class, () -> flightSearch.findFlight(flight));
    }

    @Test
    void testFindFlightWhenAirportIsClosed() {
        // Given
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warsaw", "Berlin");

        // When & Then
        // "Berlin" is in the map but marked as 'false'.
        // This should NOT throw the RouteNotFoundException because the airport exists.
        assertDoesNotThrow(() -> flightSearch.findFlight(flight));
    }
}
