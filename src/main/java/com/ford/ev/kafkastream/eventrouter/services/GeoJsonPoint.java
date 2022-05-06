package com.ford.ev.kafkastream.eventrouter.services;

import java.io.Serializable;

public class GeoJsonPoint implements Serializable {
    double x;
    double y;

    public GeoJsonPoint(double longitude, double latitude) {
        this.x = longitude;
        this.y = latitude;
    }
}
