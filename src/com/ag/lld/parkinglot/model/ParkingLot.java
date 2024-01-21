package com.ag.lld.parkinglot.model;

import com.ag.lld.parkinglot.model.enums.ParkingFeeCalcStrategyType;
import com.ag.lld.parkinglot.model.enums.ParkingLotStatus;
import com.ag.lld.parkinglot.model.enums.SlotAssignmentStrategyType;
import com.ag.lld.parkinglot.model.enums.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;

    public ParkingFeeCalcStrategyType getFeeCalcStrategyType() {
        return feeCalcStrategyType;
    }

    public void setFeeCalcStrategyType(ParkingFeeCalcStrategyType feeCalcStrategyType) {
        this.feeCalcStrategyType = feeCalcStrategyType;
    }

    private ParkingFeeCalcStrategyType feeCalcStrategyType;

    public SlotAssignmentStrategyType getSlotAssignmentStrategyType() {
        return slotAssignmentStrategyType;
    }

    public void setSlotAssignmentStrategyType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategyType = slotAssignmentStrategyType;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
