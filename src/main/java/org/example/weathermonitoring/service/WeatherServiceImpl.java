package org.example.weathermonitoring.service;

import lombok.RequiredArgsConstructor;
import org.example.weathermonitoring.exception.NoEntityException;
import org.example.weathermonitoring.model.City;
import org.example.weathermonitoring.model.Weather;
import org.example.weathermonitoring.repository.CityWeatherRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@EnableScheduling
public class WeatherServiceImpl implements WeatherService {
    private final CityWeatherRepo cityWeatherRepo;
    private final WebClient webClient;
    @Value("${token.name}")
    private String token;
    @Value("${data.name}")
    private String data;

    @Override
    @Scheduled(fixedRate = 300000)
    public void saveWeather() {
        weatherAdd(City.SPOROVO);
//        weatherAdd(City.EZERISHCHE);
        weatherAdd(City.BERYOZA);
        weatherAdd(City.BREST);
        weatherAdd(City.MINSK);
    }

    @Override
    public Weather weatherAdd(City city) {
        Weather weather = webClient
                .get()
                .uri(city.getUri() + data + token)
                .retrieve()
                .bodyToMono(Weather.class)
                .block();
        Objects.requireNonNull(weather).setCity(city.name());
        weather.setDate(LocalDateTime.now());
        cityWeatherRepo.save(weather);

        return weather;
    }

    @Override
    public Weather findWeatherByCityAndDate(City city, LocalDateTime date) {
        if (date == null) {
            return cityWeatherRepo.findFirstByCityOrderByDateDesc(
                    city.name()).orElse(weatherAdd(city));
        }
        return cityWeatherRepo.findFirstByCityAndDateBeforeOrderByDateDesc(
                city.name(), date).orElseThrow(() -> new NoEntityException("Данные отсутствует"));
    }
}

