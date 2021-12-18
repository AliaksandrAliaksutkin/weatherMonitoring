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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@EnableScheduling
@EnableTransactionManagement
public class WeatherServiceImpl implements WeatherService {
    private final CityWeatherRepo cityWeatherRepo;
    private final WebClient webClient;
    @Value("${token.name}")
    private String token;
    @Value("${data.name}")
    private String data;

//    @Override
    @Transactional
    @Scheduled(fixedRate = 300000)
    protected void saveWeather() {
        weatherAdd(City.SPOROVO);
        weatherAdd(City.ROM);
        weatherAdd(City.BERYOZA);
        weatherAdd(City.BREST);
        weatherAdd(City.MINSK);
    }

//    @Override
    @Transactional
    protected Weather weatherAdd(City city) {
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
    @Transactional
    public Weather findWeatherByCityAndDate(City city, LocalDateTime date) {
        if (date == null) {
            return cityWeatherRepo.findFirstByCityOrderByDateDesc(
                    city.name()).orElse(weatherAdd(city));
        }
        return cityWeatherRepo.findFirstByCityAndDateBeforeOrderByDateDesc(
                city.name(), date).orElseThrow(() -> new NoEntityException("Данные отсутствует"));
    }
}

