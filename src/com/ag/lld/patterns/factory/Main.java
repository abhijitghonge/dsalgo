package com.ag.lld.patterns.factory;

import com.ag.lld.patterns.factory.database.Database;
import com.ag.lld.patterns.factory.database.Query;
import com.ag.lld.patterns.factory.database.QueryFactory;
import com.ag.lld.patterns.factory.database.QueryParam;
import com.ag.lld.patterns.factory.database.db2.DB2Database;
import com.ag.lld.patterns.factory.database.mongo.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        Database db = new MongoDatabase();
        int avgPsp = 90;
        String queryString = "select * from Students where psp> :AvgPSP";
        QueryParam<String, Integer> queryParam = new QueryParam<>();
        queryParam.add("AvgPSP", avgPsp);

        QueryFactory factory = db.getQueryFactory();
        Query query =  factory.createQuery(queryString, queryParam);
        query.execute(db.createConn());
    }
}
