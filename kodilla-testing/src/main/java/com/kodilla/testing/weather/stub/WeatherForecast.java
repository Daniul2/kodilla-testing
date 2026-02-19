package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

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
       Map<String,Double>tempsMap = temperatures.getTemperatures();
       if (tempsMap.isEmpty())return 0.0;

       double sum = 0;

        for (Double temp : tempsMap.values()) {
            sum += temp;
        }
        return sum / tempsMap.size();
    }

    public double calculateMedianTemperature() {
        Map<String,Double>tempsMap = temperatures.getTemperatures();
        if (tempsMap.isEmpty())return 0.0;

        List<Double> tempsList = new ArrayList<>(tempsMap.values());
        Collections.sort(tempsList);
        int size = tempsList.size();

        if (size % 2 == 0) {
            return (tempsList.get(size / 2 - 1) + tempsList.get(size / 2)) / 2.0;
        } else {
            return tempsList.get(size / 2);
        }
    }
}
