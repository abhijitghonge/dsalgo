package com.ag.lld.patterns.factory.database.db2;

import com.ag.lld.patterns.factory.database.*;

public class DB2Database implements Database {
    @Override
    public Db2Connection createConn() {
        return new Db2Connection();
    }

    @Override
    public QueryFactory getQueryFactory() {
        return new SqlQueryFactory();
    }


}
