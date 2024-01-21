package com.ag.lld.parkinglot.model;

import com.ag.lld.parkinglot.model.enums.GateStatus;
import com.ag.lld.parkinglot.model.enums.GateType;

public class Gate extends BaseModel{
    private int gateNumber;
    private Operator currentOperator;
    private GateType gateType;
    private GateStatus gateStatus;
    private ParkingLot parkingLot;

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
