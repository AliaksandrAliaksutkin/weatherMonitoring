package org.example.weathermonitoring.service;

import org.example.weathermonitoring.model.Locality;
import org.example.weathermonitoring.model.Weather;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherService {

    void saveWeather();
    Weather weatherAdded(Locality locality);
    Weather findWeatherByLocalityAndDate(Locality locality, LocalDateTime dateTime);

}

