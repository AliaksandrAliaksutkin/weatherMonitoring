package org.example.weathermonitoring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum City {
    SPOROVO("/52.4249;25.3202"),
    BERYOZA("/52.5203;24.9643"),
    MINSK("/53.8980;27.5606"),
    BREST("/52.1096;23.7182"),
    EZERISHCHE("/55.8383;29.9833");

    private final String uri;

}

