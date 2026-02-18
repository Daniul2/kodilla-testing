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
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @Test
    @DisplayName("Test: Calculate forecast with mock")
    void testCalculateForecastWithMock() {
        // Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        int quantityOfSensors = weatherForecast.calculateForecast().size();
        // Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("Test: Calculate average temperature")
    void testCalculateAverageTemperatureWithMock() {
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        // When
        double average = weatherForecast.calculateAverageTemperature();
        // Then
        Assertions.assertEquals(25.56, average, 0.01);
    }

    @Test
    @DisplayName("Test: Calculate median temperature")
    void testCalculateMedianTemperatureWithMock() {
        // Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        // When
        double median = weatherForecast.calculateMedianTemperature();
        // Then
        // Дані після сортування: 24.8, 25.2, 25.5, 26.1, 26.2. Середнє - 25.5
        Assertions.assertEquals(25.5, median);
    }
}
