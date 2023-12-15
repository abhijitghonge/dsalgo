package com.ag.lld.patterns.adapter;

import com.ag.lld.patterns.adapter.banks.hdfc.HDFCBankAPIAdapter;
import com.ag.lld.patterns.adapter.banks.icici.ICICIBankAPIAdapter;

import java.util.EnumMap;

public class APIAdapterFactory {


    private final EnumMap<BankType, BankAPI> bankConfig;

    public APIAdapterFactory(){
        bankConfig = new EnumMap<>(BankType.class);
        bankConfig.put(BankType.HDFCBANK, new HDFCBankAPIAdapter());
        bankConfig.put(BankType.ICICI, new ICICIBankAPIAdapter());
    }
    public  BankAPI getBankAPI(BankType bankType) {
        return bankConfig.get(bankType);
    }
}
