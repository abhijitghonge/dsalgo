package com.ag.lld.parkinglot.strategies;

import com.ag.lld.parkinglot.model.ParkingFloor;
import com.ag.lld.parkinglot.model.ParkingLot;
import com.ag.lld.parkinglot.model.ParkingSlot;
import com.ag.lld.parkinglot.model.enums.ParkingFloorStatus;
import com.ag.lld.parkinglot.model.enums.ParkingSlotStatus;
import com.ag.lld.parkinglot.model.enums.VehicleType;

import java.util.*;
import java.util.stream.Collectors;

public class RandomSlotAssignStrategy implements SlotAssignmentStrategy {
    @Override
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        ParkingFloor leastFilledFloor = getLeastFilledFloor(parkingFloors);
        List<ParkingSlot> parkingSlots = leastFilledFloor.getParkingSlots();
        for (ParkingSlot parkingslot :
                parkingSlots) {
            if (parkingslot.getParkingSlotStatus() == ParkingSlotStatus.UNFILLED) {
                return Optional.of(parkingslot);
            }
        }

        return Optional.empty();
    }

    private ParkingFloor getLeastFilledFloor(List<ParkingFloor> parkingFloors) {
        Comparator<ParkingFloor> byLeastFilledOrder = (o1, o2) -> {
            Long o1Size = o1.getParkingSlots()
                    .stream()
                    .filter(slot -> slot.getParkingSlotStatus() == ParkingSlotStatus.UNFILLED)
                    .count();
            Long o2Size = o2.getParkingSlots()
                    .stream()
                    .filter(slot -> slot.getParkingSlotStatus() == ParkingSlotStatus.UNFILLED)
                    .count();
            if(o2Size.equals(o1Size)){
                return Integer.compare(o1.getFloorNumber(), o2.getFloorNumber());
            }else{
                return o1Size.compareTo(o2Size);
            }
        };

        PriorityQueue<ParkingFloor> leastFilled = new PriorityQueue<>(byLeastFilledOrder);
        ;
        leastFilled.addAll(parkingFloors
                .stream()
                .filter(floor-> floor.getParkingFloorStatus() == ParkingFloorStatus.OPEN)
                .collect(Collectors.toList()));
        return leastFilled.poll();
    }
}
