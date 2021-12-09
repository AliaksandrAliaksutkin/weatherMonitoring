package org.example.weathermonitoring.service;


import lombok.RequiredArgsConstructor;
import org.example.weathermonitoring.model.Locality;
import org.example.weathermonitoring.model.Weather;
import org.example.weathermonitoring.repository.LocalityWeatherRepo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@EnableScheduling
public class WeatherServiceImpl implements WeatherService {
    private final LocalityWeatherRepo localityWeatherRepo;
    private final WebClient webClient;

    @Override
    @Scheduled(fixedRate = 300000)
    public void saveWeather() {
        weatherAdded(Locality.SPOROVO);
        weatherAdded(Locality.BERYOZA);
        weatherAdded(Locality.BREST);
        weatherAdded(Locality.KOBRIN);
        weatherAdded(Locality.MINSK);
    }

    @Override
    public Weather weatherAdded(Locality locality) {
//        Weather weather  = webClient
//                .get()
//                .uri(locality.getUri() + data + token)
//                .retrieve()
//                .bodyToMono(Weather.class)
//                .block();
//        weather.setLocality(locality.name());
//        weather.setDateTime(LocalDateTime.now());
//        LocalityWeatherRepo.save();
        return null;
    }


    @Override
    public Weather findWeatherByLocalityAndDate(Locality locality, LocalDateTime dateTime) {
        return null;
    }
}

