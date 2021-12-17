package org.example.weathermonitoring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.weathermonitoring.exception.NoEntityException;
import org.example.weathermonitoring.model.City;
import org.example.weathermonitoring.model.Weather;
import org.example.weathermonitoring.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@Log
public class ForecastWeatherController {
    private final WeatherService weatherService;

    @GetMapping("/get/{city}")
    public Weather getWeather(@PathVariable City city,
                              @RequestParam(required = false)
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      LocalDateTime date) throws NoEntityException {
        return weatherService.findWeatherByCityAndDate(city, date);
    }
}
