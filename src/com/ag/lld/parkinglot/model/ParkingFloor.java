package com.ag.lld.parkinglot.model;

import com.ag.lld.parkinglot.model.enums.ParkingFloorStatus;
import com.ag.lld.parkinglot.model.enums.VehicleType;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSlot> parkingSlots;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
    private List<VehicleType> allowedVehicleTypes;

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
