package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Forecast Test Suite")
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {
        // Initialize the class being tested with the mock once for all tests
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Nested
    @DisplayName("Tests with filled temperature list")
    class TestWithData {

        @BeforeEach
        void setUpMock() {
            Map<String, Double> temperaturesMap = new HashMap<>();
            temperaturesMap.put("Rzeszow", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        }

        @Test
        @DisplayName("Test: Calculate forecast")
        void testCalculateForecastWithMock() {
            // When
            int quantityOfSensors = weatherForecast.calculateForecast().size();
            // Then
            Assertions.assertEquals(5, quantityOfSensors);
        }

        @Test
        @DisplayName("Test: Calculate average temperature")
        void testCalculateAverageTemperatureWithMock() {
            // When
            // Sum: 25.5 + 26.2 + 24.8 + 25.2 + 26.1 = 127.8
            // Average: 127.8 / 5 = 25.56
            double average = weatherForecast.calculateAverageTemperature();
            // Then
            Assertions.assertEquals(25.56, average, 0.01);
        }

        @Test
        @DisplayName("Test: Calculate median temperature")
        void testCalculateMedianTemperatureWithMock() {
            // When
            // Data sorted: 24.8, 25.2, [25.5], 26.1, 26.2
            // Median is the middle element (25.5)
            double median = weatherForecast.calculateMedianTemperature();
            // Then
            Assertions.assertEquals(25.5, median);
        }
    }

    @Nested
    @DisplayName("Tests with empty temperature list")
    class TestWithEmptyData {

        @BeforeEach
        void setUpMock() {
            when(temperaturesMock.getTemperatures()).thenReturn(new HashMap<>());
        }

        @Test
        @DisplayName("Test: Average with empty map")
        void testCalculateAverageWithEmptyMap() {
            // When
            double average = weatherForecast.calculateAverageTemperature();
            // Then
            Assertions.assertEquals(0.0, average);
        }

        @Test
        @DisplayName("Test: Median with empty map")
        void testCalculateMedianWithEmptyMap() {
            // When
            double median = weatherForecast.calculateMedianTemperature();
            // Then
            Assertions.assertEquals(0.0, median);
        }
    }
}
