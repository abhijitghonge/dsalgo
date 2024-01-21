package com.ag.lld.parkinglot.patterns;

import com.ag.lld.parkinglot.model.enums.ParkingFeeCalcStrategyType;
import com.ag.lld.parkinglot.model.enums.SlotAssignmentStrategyType;
import com.ag.lld.parkinglot.strategies.ParkingFeeCalculationStrategy;
import com.ag.lld.parkinglot.strategies.SlotAssignmentStrategy;

public class ParkingLotFactory {
    private static final FeeCalcRegistry feeCalcRegistry = new FeeCalcRegistry();
    private static final SlotAssignStrategyRegistry slotAssignStrategyRegistry = new SlotAssignStrategyRegistry();

    public static ParkingFeeCalculationStrategy getFeeCalcStrategy(ParkingFeeCalcStrategyType feeCalcStrategyType){
        return feeCalcRegistry.getFeeCalcStrategy(feeCalcStrategyType);
    }

    public static SlotAssignmentStrategy getSlotAssignmentStrategy(SlotAssignmentStrategyType slotAssignmentStrategyType){
        return slotAssignStrategyRegistry.getSlotAssignStrategy(slotAssignmentStrategyType);
    }
}
