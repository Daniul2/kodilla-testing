package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a single country with its population quantity.
 */
public final class Country {
    private final String countryName;
    private final BigDecimal peopleQuantity;

    public Country(String countryName, BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Country country)) return false;
        return Objects.equals(getCountryName(), country.getCountryName()) && Objects.equals(getPeopleQuantity(), country.getPeopleQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryName(), getPeopleQuantity());
    }
}
