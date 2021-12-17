package org.example.weathermonitoring.repository;

import org.example.weathermonitoring.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CityWeatherRepo extends JpaRepository<Weather, Long> {
    Optional<Weather> findFirstByCityOrderByDateDesc(String city);

    Optional<Weather> findFirstByCityAndDateBeforeOrderByDateDesc(String city, LocalDateTime date);


}
