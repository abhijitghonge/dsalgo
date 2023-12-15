package com.ag.lld.patterns.factory.database;


public interface Database {


    Connection createConn();

    QueryFactory getQueryFactory();
}
