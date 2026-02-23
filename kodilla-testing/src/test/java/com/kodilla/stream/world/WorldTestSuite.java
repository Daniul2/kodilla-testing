package com.kodilla.stream.world;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the World class.
 */
class WorldTestSuite {

    @Test
    @DisplayName("Test if getPeopleQuantity correctly calculates the sum of population across all continents")
    void testGetPeopleQuantity() {
        // Given: Create a world with continents and countries
        World world = new World();

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany",new BigDecimal("83000000")));

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China",new BigDecimal("1400000000")));
        asia.addCountry(new Country("Japan",new BigDecimal("125000000")));

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Egypt", new BigDecimal("100000000")));

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        // When: Calculate total population
        BigDecimal totalPopulation = world.getPeopleQuantity();

        // Then: Compare with expected sum (38M + 83M + 1400M + 125M + 100M = 1,746,000,000)
        BigDecimal expectedPopulation = new BigDecimal("1746000000");
        assertEquals(expectedPopulation,totalPopulation);


    }
}
