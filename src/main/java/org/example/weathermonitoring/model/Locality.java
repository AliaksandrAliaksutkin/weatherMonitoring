package org.example.weathermonitoring.model;

import lombok.Getter;

@Getter
public enum Locality {
    SPOROVO("52.4249; 25.3202"),
    BERYOZA("52.5203, 24.9643"),
    MINSK("53.8980, 27.5606"),
    BREST("52.1096, 23.7182"),
    KOBRIN("52.2163, 24.3602");

    private final String locality;

    Locality(String locality) {
        this.locality = locality;
    }
}
