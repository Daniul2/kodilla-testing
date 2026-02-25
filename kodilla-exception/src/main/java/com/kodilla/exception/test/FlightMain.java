package com.kodilla.exception.test;

public class FlightMain {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();


        // Scenario 1: Airport exists and is available
        Flight flight1 = new Flight("Warsaw", "London");

        // Scenario 2: Airport DOES NOT exist (exception)
        Flight flight2 = new Flight("Warsaw", "New York");
        try {
            System.out.println("Searching for flight 1...");
            flightSearch.findFlight(flight1);

            System.out.println("\nSearching for flight 2...");
            flightSearch.findFlight(flight2);

        } catch (RouteNotFoundException e) {
            System.out.println("Search Error: " + e.getMessage());
        } finally {
            System.out.println("\nThank you for using our flight search engine.");
        }
    }

    }
