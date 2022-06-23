package com.kodilla.testing.weather.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;
    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;

    }
    public Map<String,Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String,Double> temperature: temperatures.getTemperatures().entrySet()){
            //adding 1 celcius degree to current value as a temporary weather forecast
            resultMap.put(temperature.getKey(),temperature.getValue()+1.0);
        }
        return resultMap;
    }
    public double temperatureAverage() {
        double sumOfTemperatures = 0.0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sumOfTemperatures += temperature.getValue();
        }
        return sumOfTemperatures / temperatures.getTemperatures().size();
    }
    public double temperatureMedian() {
        ArrayList<Double> temperaturesList = new ArrayList<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            temperaturesList.add(temperature.getValue());
        }
        double median = 0.0;
        Collections.sort(temperaturesList);
        if(temperaturesList.size()%2 != 0) {
            median = temperaturesList.get(temperaturesList.size() / 2);
        } else {
            median = (temperaturesList.get(temperaturesList.size()/2) +temperaturesList.get((temperaturesList.size()/2)-1))/2;
        }
        return median;

    }

}
