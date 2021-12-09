package org.example.weathermonitoring.repository;

import org.example.weathermonitoring.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalityWeatherRepo extends JpaRepository <Weather,Long> {
    Optional<Weather> findWeatherByLocalityAndDateTime (String locality);
//    Optional<Weather>


}
