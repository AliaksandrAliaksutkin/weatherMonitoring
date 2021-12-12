package org.example.weathermonitoring.service;

import org.example.weathermonitoring.model.City;
import org.example.weathermonitoring.model.Weather;

import java.time.LocalDateTime;

public interface WeatherService {

    void saveWeather();
    Weather weatherAdd(City city);
    Weather findWeatherByCityAndDate(City city, LocalDateTime date);

}

