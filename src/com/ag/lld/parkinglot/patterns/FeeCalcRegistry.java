package com.ag.lld.parkinglot.patterns;

import com.ag.lld.parkinglot.model.enums.ParkingFeeCalcStrategyType;
import com.ag.lld.parkinglot.strategies.ParkingFeeCalculationStrategy;

import java.util.EnumMap;
import java.util.Map;

public class FeeCalcRegistry {

    private Map<ParkingFeeCalcStrategyType, ParkingFeeCalculationStrategy> feeCalcMap = new EnumMap<>(ParkingFeeCalcStrategyType.class);

    public void addFeeCalcStrategy(ParkingFeeCalcStrategyType feeCalcStrategyType, ParkingFeeCalculationStrategy feeCalculationStrategy){
        feeCalcMap.put(feeCalcStrategyType, feeCalculationStrategy);
    }

    public ParkingFeeCalculationStrategy getFeeCalcStrategy(ParkingFeeCalcStrategyType feeCalcStrategyType){
        return feeCalcMap.get(feeCalcStrategyType);
    }
}
