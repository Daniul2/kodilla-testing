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
        assertDoesNotThrow(() -> flightSearch.findFlight(flight));
    }

    @Test
    void testFindFlightWhenAirportDoesNotExist() {
        // Given
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warsaw", "New York");

        // When & Then
        assertThrows(RouteNotFoundException.class, () -> flightSearch.findFlight(flight));
    }


    @Test
    void testFindFlightWhenAirportIsClosed() {
        // Given
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warsaw", "Berlin");

        // When & Then

        assertDoesNotThrow(() -> flightSearch.findFlight(flight));
    }
}
