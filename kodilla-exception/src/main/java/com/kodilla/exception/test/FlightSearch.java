package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public void findFlight(Flight flight)throws RouteNotFoundException{
//        Key = Name of the City, for example, Warsaw,London...
//        Value = true if it's accessible or false if it's not
        Map<String,Boolean>airportMap = new HashMap<>();
        airportMap.put("Warsaw", true);
        airportMap.put("London", true);
        airportMap.put("Berlin", false);
        airportMap.put("Paris", true);

        String arrivalAirport = flight.getArrivalAirport();
        //Some tries for checking if the airport exists
        if (airportMap.containsKey(arrivalAirport)){
            boolean isAvailable = airportMap.get(arrivalAirport);
            if (isAvailable) {
                System.out.println("Flight to " + arrivalAirport + " is available.");
            } else {
                System.out.println("Flight to " + arrivalAirport + " is currently closed.");
            }
        } else {
            // Throw exception if airport is not in the map
            throw new RouteNotFoundException("Route not found: Airport '" + arrivalAirport + "' does not exist in our system!");
        }
    }
        }


