package com.ag.lld.patterns.factory.database.mongo;

import com.ag.lld.patterns.factory.database.Connection;

public class MongoConnection implements Connection {
    @Override
    public String getName() {
        return "Mongo DB Connection";
    }
}
