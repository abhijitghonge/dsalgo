package com.ag.lld.patterns.factory.database.db2;

import com.ag.lld.patterns.factory.database.Connection;

public class Db2Connection implements Connection {
    @Override
    public String getName() {
        return "DB2 Connection";
    }
}
