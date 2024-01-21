package com.ag.lld.parkinglot.repositories;

import com.ag.lld.parkinglot.model.Bill;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BillRepository {
    private Map<Long, Bill> billRepo = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(0L);

    public Bill save(Bill bill){
        bill.setId(idCounter.incrementAndGet());
        billRepo.put(bill.getId(), bill);
        return bill;
    }
}
