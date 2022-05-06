package com.ford.ev.kafkastream.eventrouter.services;

import org.springframework.cache.annotation.Cacheable;

public interface CacheService {
    @Cacheable("address")
    Address retrieveAddress(String prox);
}
