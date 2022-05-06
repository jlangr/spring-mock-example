package com.ford.ev.kafkastream.eventrouter.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class AddressService implements CacheService{
    public static int count = 0;

    @Override
    @Cacheable("address")
    public Address retrieveAddress(String prox) {
        count++;
        var address = new Address();
        address.address1 = "the address 1";
        return address;
    }
}
