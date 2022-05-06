package com.ford.ev.kafkastream.eventrouter.services;

public class Address {

    public String address1;

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (obj.getClass() != Address.class) return false;
        var that = (Address)obj;
        return this.address1.equals(that.address1);
    }
}
