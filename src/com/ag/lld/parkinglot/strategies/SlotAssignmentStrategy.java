package com.ag.lld.parkinglot.strategies;

import com.ag.lld.parkinglot.model.ParkingLot;
import com.ag.lld.parkinglot.model.ParkingSlot;
import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.model.enums.VehicleType;

import java.util.Optional;

public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType) ;
}
