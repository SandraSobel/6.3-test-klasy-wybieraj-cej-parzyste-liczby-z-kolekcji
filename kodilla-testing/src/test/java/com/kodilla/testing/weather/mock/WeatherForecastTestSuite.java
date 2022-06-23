package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("Test sprawdzający ilość czujników")
    void testCalculateForecastWithMock(){
        //given

        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);


        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //when
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //then
        Assertions.assertEquals(5,quantityOfSensors);

    }
    @Test
    @DisplayName("Test sprawdzający średnią")
    void testTemperatureAverageWithMock(){
        //given
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //when
        double testedAverage = weatherForecast.temperatureAverage();
        double expectedResult = (25.5+26.2+24.8+25.2+26.1)/5;
        //then
        Assertions.assertEquals(testedAverage,expectedResult);

    }
    @Test
    @DisplayName("Test sprawdzający medianę - nieparzysta liczba czujników")
    void testTemperatureMedianWithMockForOddNumberOfTemperatures(){
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //when
        double testedMedian = weatherForecast.temperatureMedian();
        double expectedResult = 25.5;
        //then
        Assertions.assertEquals(testedMedian,expectedResult);
    }

    @Test
    @DisplayName("Test sprawdzający medianę - parzysta liczba czujników")
    void testTemperatureMedianWithMockForEvenNumberOfTemperatures(){
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //when
        double testedMedian = weatherForecast.temperatureMedian();
        double expectedResult = (25.5+26.1)/2;
        //then
        Assertions.assertEquals(testedMedian,expectedResult);
    }
}
