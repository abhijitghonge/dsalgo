package com.ag.lld.parkinglot.strategies;

import com.ag.lld.parkinglot.model.Gate;
import com.ag.lld.parkinglot.model.ParkingFloor;
import com.ag.lld.parkinglot.model.ParkingLot;
import com.ag.lld.parkinglot.model.ParkingSlot;
import com.ag.lld.parkinglot.model.enums.ParkingFloorStatus;
import com.ag.lld.parkinglot.model.enums.ParkingSlotStatus;
import com.ag.lld.parkinglot.model.enums.VehicleType;
import com.ag.lld.parkinglot.strategies.SlotAssignmentStrategy;

import java.util.List;
import java.util.Optional;

public class RandomSlotAssignStrategy implements SlotAssignmentStrategy {
    @Override
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for (ParkingFloor floor :
                parkingFloors) {
            if (floor.getParkingFloorStatus() == ParkingFloorStatus.OPEN) {
                List<ParkingSlot> parkingSlots = floor.getParkingSlots();
                for (ParkingSlot parkingslot :
                        parkingSlots) {
                    if (parkingslot.getParkingSlotStatus() == ParkingSlotStatus.UNFILLED) {
                        return Optional.ofNullable(parkingslot);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
