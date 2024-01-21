package com.ag.lld.parkinglot.services;

import com.ag.lld.parkinglot.exceptions.InvalidTokenException;
import com.ag.lld.parkinglot.model.Gate;
import com.ag.lld.parkinglot.model.ParkingSlot;
import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.model.Vehicle;
import com.ag.lld.parkinglot.model.enums.VehicleType;
import com.ag.lld.parkinglot.patterns.ParkingLotFactory;
import com.ag.lld.parkinglot.repositories.GateRepository;
import com.ag.lld.parkinglot.repositories.TokenRepository;
import com.ag.lld.parkinglot.repositories.VehicleRepository;
import com.ag.lld.parkinglot.strategies.SlotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TokenService {
    private final VehicleRepository vehicleRepository;
    private final GateRepository gateRepository;
    private TokenRepository tokenRepository;

    TokenService(VehicleRepository vehicleRepository, GateRepository gateRepository,  TokenRepository tokenRepository){
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.tokenRepository = tokenRepository;
    }

    public Token issueToken(String vehicleNumber, Long gateId, VehicleType vehicleType) throws InvalidTokenException {

        Token token = new Token();

        //get vehicle using respository
        Optional<Vehicle> byVehicleNumber = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if(byVehicleNumber.isPresent()){
            token.setVehicle(byVehicleNumber.get());
        }else{
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setCreatedAt(new Date());
            vehicle = vehicleRepository.save(vehicle);
            token.setVehicle(vehicle);
        }
        //get Gate using repository
        Optional<Gate> byGateId = gateRepository.findGateById(gateId);
        if(byGateId.isPresent()){
            Gate gate = byGateId.get();
            token.setGeneratedAt(gate);
            token.setEntryTime(new Date());
            token.setGeneratedBy(gate.getCurrentOperator());
            SlotAssignmentStrategy slotAssignStrategy = ParkingLotFactory.getSlotAssignmentStrategy(gate.getParkingLot().getSlotAssignmentStrategyType());
            Optional<ParkingSlot> slotOptional = slotAssignStrategy.assignSlot(gate.getParkingLot(), vehicleType);
            if(slotOptional.isPresent()){
                token.setParkingSlot(slotOptional.get());
                return tokenRepository.save(token);
            }else{
                throw new InvalidTokenException("Parking Full!");
            }
        }else{
            throw new InvalidTokenException("Gate Not Found for gate Id:"+gateId);
        }

    }
}
