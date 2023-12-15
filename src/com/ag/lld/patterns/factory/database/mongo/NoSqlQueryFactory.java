package com.ag.lld.patterns.factory.database.mongo;

import com.ag.lld.patterns.factory.database.Query;
import com.ag.lld.patterns.factory.database.QueryFactory;
import com.ag.lld.patterns.factory.database.QueryParam;

public class NoSqlQueryFactory implements QueryFactory {
    @Override
    public Query createQuery(String queryString, QueryParam<String, Integer> params) {
        return NoSqlQuery.builder()
                .setQueryString(queryString)
                .setQueryParams(params)
                .build();
    }
}
