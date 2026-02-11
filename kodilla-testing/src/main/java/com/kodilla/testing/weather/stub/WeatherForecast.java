package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        if (temperatures.getTemperatures().isEmpty()) return 0.0;

        double sum = 0;
        for (Double temp : temperatures.getTemperatures().values()) {
            sum += temp;
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        if (temperatures.getTemperatures().isEmpty()) return 0.0;

        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temps);
        int size = temps.size();

        if (size % 2 == 0) {
            return (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2.0;
        } else {
            return temps.get(size / 2);
        }
    }
}
