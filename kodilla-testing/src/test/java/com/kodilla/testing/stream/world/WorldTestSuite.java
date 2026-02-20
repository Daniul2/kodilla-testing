package com.kodilla.testing.stream.world;

import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("World Population Test Suite")
class WorldTestSuite {

    @Test
    @DisplayName("Test getPeopleQuantity() calculating sum of all countries in the world")
    void testGetPeopleQuantity() {
        // Given: Create countries with population (using Strings for BigDecimal precision)
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));
        Country france = new Country("France", new BigDecimal("67000000"));

        Country china = new Country("China", new BigDecimal("1400000000"));
        Country india = new Country("India", new BigDecimal("1300000000"));

        Country usa = new Country("USA", new BigDecimal("330000000"));
        Country canada = new Country("Canada", new BigDecimal("38000000"));

        // Given: Create continents and add countries
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);

        // Given: Create world and add continents
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        // When: Calculate total population
        BigDecimal totalPopulation = world.getPeopleQuantity();

        // Then: Verify expected sum
        // 38M + 83M + 67M + 1400M + 1300M + 330M + 38M = 3,256,000,000
        BigDecimal expectedPopulation = new BigDecimal("3256000000");
        assertEquals(expectedPopulation, totalPopulation);
    }
}
