package com.ag.lld.parkinglot.dtos;

import com.ag.lld.parkinglot.model.enums.VehicleType;

public class IssueTokenRequestDto {
    private String vehicleNumber;
    private long gateId;
    private VehicleType vehicleType;


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
