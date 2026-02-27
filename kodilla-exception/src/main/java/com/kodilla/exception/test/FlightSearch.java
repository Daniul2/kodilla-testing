package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {


    private final Map<String, Boolean> airportMap;

    public FlightSearch() {
        airportMap = new HashMap<>();
        airportMap.put("London", true);
        airportMap.put("Paris", true);
        airportMap.put("Berlin", false);
        airportMap.put("Warsaw", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String arrival = flight.getArrivalAirport();

        if (airportMap.containsKey(arrival)) {
            boolean available = airportMap.get(arrival);
            if (available) {
                System.out.println("Flight to " + arrival + " is available!");
            } else {
                System.out.println("Sorry, flights to " + arrival + " are currently suspended.");
            }
        } else {
            throw new RouteNotFoundException("The airport '" + arrival + "' was not found in our system.");
        }
    }
}
