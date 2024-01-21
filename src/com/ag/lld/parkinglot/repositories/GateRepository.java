package com.ag.lld.parkinglot.repositories;

import com.ag.lld.parkinglot.model.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class GateRepository {
    private final Map<Long, Gate> gateRepo = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(0L);
    public Optional<Gate> findGateById(long id){
        return gateRepo.containsKey(id)? Optional.ofNullable(gateRepo.get(id)):Optional.empty();
    }

    public Gate save(Gate gate){
        long id = counter.incrementAndGet();
        gate.setId(id);
        gateRepo.put(id, gate);
        return gate;
    }
}
