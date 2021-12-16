package org.example.weathermonitoring.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "temp")
    @JsonProperty("t")
    private double temp;

    @Column(name = "pressure")
    @JsonProperty("sp")
    private String pressure;

    @Column(name = "wind")
    @JsonProperty("speed10")
    private String wind;

    @Column(name = "rain")
    @JsonProperty("crain")
    private String rain;

}
