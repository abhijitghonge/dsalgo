package com.ag.lld.parkinglot.patterns;

import com.ag.lld.parkinglot.model.enums.SlotAssignmentStrategyType;
import com.ag.lld.parkinglot.strategies.SlotAssignmentStrategy;

import java.util.EnumMap;
import java.util.Map;

public class SlotAssignStrategyRegistry {
    private final Map<SlotAssignmentStrategyType, SlotAssignmentStrategy> slotAssignStrategiesRepo = new EnumMap<>(SlotAssignmentStrategyType.class);

    public SlotAssignmentStrategy getSlotAssignStrategy(SlotAssignmentStrategyType strategyType){
        return slotAssignStrategiesRepo.get(strategyType);
    }

    public void addSlotAssignStrategy(SlotAssignmentStrategyType strategyType, SlotAssignmentStrategy strategy){
        slotAssignStrategiesRepo.put(strategyType, strategy);
    }
}
