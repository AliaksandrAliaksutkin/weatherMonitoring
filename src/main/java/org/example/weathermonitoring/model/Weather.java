package org.example.weathermonitoring.model;


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
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "locality")
    private String locality;

    @Column(name = "temp")
//    @JsonProperty("t")
    private double temp;

    @Column(name = "pressure")
//    @JsonProperty("sp")
    private String pressure;

    @Column(name = "wind")
//    @JsonProperty("speed10")
    private String wind;

    @Column(name = "rain")
//    @JsonProperty("rain")
    private String rain;

}
