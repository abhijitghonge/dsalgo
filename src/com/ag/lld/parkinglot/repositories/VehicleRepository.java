package com.ag.lld.parkinglot.repositories;

import com.ag.lld.parkinglot.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleRepository {

    private final Map<String, Vehicle> vehicleRepo = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(0L);

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber){
        return vehicleRepo.containsKey(vehicleNumber)?Optional.ofNullable(vehicleRepo.get(vehicleNumber)):Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(idCounter.incrementAndGet());
        vehicleRepo.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
