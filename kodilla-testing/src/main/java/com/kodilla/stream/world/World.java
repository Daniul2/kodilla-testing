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
    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream()) // Flattens List of Continents into Stream of Countries
                .map(Country::getPeopleQuantity)     // Maps each Country to its BigDecimal population
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current)); // Accumulates the sum
    }
}
