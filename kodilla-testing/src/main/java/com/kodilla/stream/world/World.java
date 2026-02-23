package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the world containing a collection of continents.
 */
public final class World {
    private final List<Continent>continents = new ArrayList<>();
    public void addContinent(Continent continent){
        continents.add(continent);
    }

    /**
     * Calculates the total population of all countries across all continents.
     * Uses flatMap to reach countries and reduce to sum BigDecimals.
     */
    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream()) // Flattens continents into a stream of countries
                .map(Country::getPeopleQuantity)                        // Maps each country to its population quantity
                .reduce(BigDecimal.ZERO, BigDecimal::add);              // Sums up all population values
    }
}
