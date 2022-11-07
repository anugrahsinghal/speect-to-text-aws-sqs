package com.cogito.hackerearth.service.internal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Profile({"default", "in-memory"})
@Service
public class UUIDGenerator implements HashGenerator {

    @Override
    public UUID getNonRepeatableHash() {
        return UUID.randomUUID();
    }
}
