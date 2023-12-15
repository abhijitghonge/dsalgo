package com.ag.lld.patterns.factory.database;

public interface QueryFactory {
    Query createQuery(String queryString, QueryParam<String, Integer> params);
}
