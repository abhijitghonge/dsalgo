package com.ag.lld.parkinglot.services;

import com.ag.lld.parkinglot.exceptions.InvalidBillException;
import com.ag.lld.parkinglot.model.Bill;
import com.ag.lld.parkinglot.model.Gate;
import com.ag.lld.parkinglot.model.ParkingLot;
import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.patterns.ParkingLotFactory;
import com.ag.lld.parkinglot.repositories.BillRepository;
import com.ag.lld.parkinglot.repositories.GateRepository;
import com.ag.lld.parkinglot.repositories.TokenRepository;
import com.ag.lld.parkinglot.strategies.ParkingFeeCalculationStrategy;

import java.util.Date;
import java.util.Optional;

public class BillingService {
    private final GateRepository gateRepository;
    private final TokenRepository tokenRepository;
    private final BillRepository billRepository;

    public BillingService(GateRepository gateRepository, TokenRepository tokenRepository, BillRepository billRepository){
        this.tokenRepository = tokenRepository;
        this.gateRepository = gateRepository;
        this.billRepository = billRepository;
    }

    public Bill generateBill(String tokenNumber, Long gateId) throws InvalidBillException{
        Bill bill = new Bill();
        bill.setExitTime(new Date());
        Optional<Token> tokenByNumber = tokenRepository.findTokenByNumber(tokenNumber);

        if(tokenByNumber.isPresent()){
            Token token = tokenByNumber.get();
            bill.setToken(token);
        }else {
            throw new InvalidBillException("Token is Invalid: "+tokenNumber);
        }

        Optional<Gate> exitGate = gateRepository.findGateById(gateId);
        if(exitGate.isPresent()){
            Gate exit = exitGate.get();
            bill.setGeneratedAt(exit);
            bill.setGeneratedBy(exit.getCurrentOperator());

            ParkingLot parkingLot = exit.getParkingLot();
            ParkingFeeCalculationStrategy feeCalculationStrategy = ParkingLotFactory.getFeeCalcStrategy(parkingLot.getFeeCalcStrategyType());
            Long fees = feeCalculationStrategy.calculateFees(bill.getToken(), exit);
            bill.setTotalAmount(fees);

        }else{
            throw new InvalidBillException("Gate is Invalid: "+gateId);
        }

        return billRepository.save(bill);

    }
}
