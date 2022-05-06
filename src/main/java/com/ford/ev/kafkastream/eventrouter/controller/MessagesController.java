package com.ford.ev.kafkastream.eventrouter.controller;

import com.ford.ev.kafkastream.eventrouter.services.ErMessageConsumer;
import com.ford.ev.kafkastream.eventrouter.services.GeoJsonPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/electrification/v1")
public class MessagesController {
    @Autowired
    ErMessageConsumer consumer;

    @RequestMapping(value = "/consumeChargeStationPayload", method = RequestMethod.POST)
    public String go(@RequestParam(value="lat") Double latitude, @RequestParam(value="lng") Double longitude) {
        if (latitude == null) latitude = 42.0d;
        if (longitude == null) longitude = -83.0d;
        consumer.run(new GeoJsonPoint(longitude, latitude));
        return "success";
    }
}
