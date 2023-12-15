package com.ag.lld.patterns.factory.database.mongo;

import com.ag.lld.patterns.factory.database.Connection;
import com.ag.lld.patterns.factory.database.Database;
import com.ag.lld.patterns.factory.database.QueryFactory;

public class MongoDatabase implements Database {
    @Override
    public Connection createConn() {
        return new MongoConnection();
    }

    @Override
    public QueryFactory getQueryFactory() {
        return new NoSqlQueryFactory();
    }


}
