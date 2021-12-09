package org.example.weathermonitoring.controllers;

import lombok.RequiredArgsConstructor;
import org.example.weathermonitoring.model.Locality;
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
public class ForecastWeatherController {
    private final WeatherService weatherService;

    @GetMapping("get/{locality}")
    public Weather getWeather (@PathVariable Locality locality,
                               @RequestParam (required = false)
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                               LocalDateTime dateTime){
        return weatherService.findWeatherByLocalityAndDate(locality, dateTime);

    }
}
