package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        FlightSearch searcher = new FlightSearch();

        Flight flight1 = new Flight("Warsaw", "London");
        Flight flight2 = new Flight("Warsaw", "Tokyo");
        Flight flight3 = new Flight("Warsaw", "Berlin");
        try {
            searcher.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("System Error: " + e.getMessage());
        }

        try {
            searcher.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println("System Error: " + e.getMessage());
        }

        try {
            searcher.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }
}
