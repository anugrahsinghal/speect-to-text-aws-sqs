package com.cogito.hackerearth.service.internal;

public record NonRepeatableHash(String hash) {
    public String value() {
        return hash;
    }
}
