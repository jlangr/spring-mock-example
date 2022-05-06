package com.ford.ev.kafkastream.eventrouter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ErMessageConsumer {

    private final AddressService service;

    public ErMessageConsumer(@Autowired AddressService service) {
        this.service = service;
    }

    public static int count = 0;

    @Cacheable("address")
    public Address retrieveAddress(String prox) {
        count++;
        var address = new Address();
        address.address1 = "the address 1";
        return address;
    }

    private String getProx(GeoJsonPoint point) {
        return String.format("%s", point.y);
    }

    public void run(GeoJsonPoint geoJsonPoint) {
        var result = /* service. */retrieveAddress(getProx(geoJsonPoint));

        System.out.println("Result: " + result.address1);
        System.out.println("actual calls: " + ErMessageConsumer.count);
    }
}
