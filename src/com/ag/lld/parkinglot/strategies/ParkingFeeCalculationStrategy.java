package com.ag.lld.parkinglot.strategies;

import com.ag.lld.parkinglot.model.Bill;
import com.ag.lld.parkinglot.model.Gate;
import com.ag.lld.parkinglot.model.Token;

public interface ParkingFeeCalculationStrategy {

    public Long calculateFees(Token token, Gate exitGate);

}
