package com.ag.lld.parkinglot.model;

import com.ag.lld.parkinglot.model.enums.ParkingSlotStatus;
import com.ag.lld.parkinglot.model.enums.VehicleType;

public class ParkingSlot extends BaseModel{
    private int slotNumber;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private ParkingFloor parkingFloor;

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
